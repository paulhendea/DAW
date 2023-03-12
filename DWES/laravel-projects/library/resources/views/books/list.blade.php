@extends('template')

@section('title', 'Book list')
@section('header')
    <header>
        <h1>Book list</h1>
    </header>
@endsection

@section('content')
    <main>
        <ul>
            @forelse ($books as $book)
                <li>{{ $book['titulo'] }} ({{ $book['autor'] }})</li>
            @empty
                <p>There are no books... :(</p>
            @endforelse
        </ul>
    </main>
@endsection
