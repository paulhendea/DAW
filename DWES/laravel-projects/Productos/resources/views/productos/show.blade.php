@extends('plantilla')

@section('title', 'Detalle del producto')

@section('content')
<header>
    <h1>{{ $producto->nombre }}</h1>
</header>
    <main>
    <p>{{ $producto->descripcion }}</p>
    <p>Precio: {{ $producto->precio }}$</p>
        <section id="categoria">
            <h3>Categoria {{ $producto->categoria->nombre }}</h3>
            <p>{{ $producto->categoria->descripcion }}</p>
        </section>
    </main>
@endsection
