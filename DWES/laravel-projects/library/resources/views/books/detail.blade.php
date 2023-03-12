@extends('template')

@section('title', 'Book list')
@section('header')
    <header>
        <h1>Book detail</h1>
    </header>
@endsection

@section('content')
    <main>
        <p>Book detail with id {{ $id }}</p>
    </main>
@endsection
