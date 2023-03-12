@extends('template')

@section('title', 'Book list')
@section('header')
    <header>
        <h1>Create a Book</h1>
    </header>
@endsection

@section('content')
    <main>
        <form action="{{ route('books.store') }}" method="POST"> 
          @csrf
            <div class="form-group">
                <label for="titulo">Título:</label>
                <input type="text" class="form-control" name="titulo" id="titulo">
            </div>
            <div class="form-group">
                <label for="editorial">Editorial:</label>
                <input type="text" class="form-control" name="editorial" id="editorial">
            </div>
            <div class="form-group">
                <label for="precio">Precio:</label>
                <input type="text" class="form-control" name="precio" id="precio">
            </div>
            <div class="form-group">
                <label for="autor">Autor:</label>
                <select class="form-control" name="autor" id="autor">
                    @foreach ($authors as $author)
                        <option value="{{ $author->id }}">
                            {{ $author->name }}
                        </option>
                    @endforeach
                </select>
            </div>
            <input type="submit" name="enviar" value="Enviar" class="btn btn-dark btn-block">
        </form>
    </main>
@endsection
