@extends('plantilla')

@section('title', 'Post list')

@section('content')

    <header>
        <h1>Productos</h1>
    </header>

    <main>
        <div class="productos-grid">
            @forelse($productos as $producto)
                <article>
                    <header>
                        <h3>{{ $producto->nombre }}</h3>
                        <p>{{ $producto->categoria->nombre }}</p>
                        <p>{{ $producto->precio }}$</p>
                    </header>
                    <div class="buttons">
                        <a href="{{ route('productos.show', $producto) }}"><button class="btn btn-primary">Ver
                                producto</button></a>
                        <a href="{{ route('productos.edit', $producto) }}"><button class="btn btn-warning">Edit</button></a>
                        <form action="{{ route('productos.destroy', $producto) }}" method="POST">
                            @method('DELETE')
                            @csrf
                            <button class="btn btn-danger">Borrar</button>
                        </form>
                    </div>
                </article>

            @empty
                <p>No hay productos :(</p>
            @endforelse
        </div>
        {{ $productos->links() }}
    </main>


@endsection
