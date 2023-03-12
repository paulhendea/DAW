@extends('plantilla')

@section('title', 'Nuevo producto')

@section('content')
    <header>
        <h1>Nuevo producto</h1>
    </header>
    <main>
        <form action="{{ route('productos.store') }}" method="POST" class="form">
            @csrf

            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="{{ old('nombre') }}">
                @if ($errors->has('nombre'))
                    <div class="text-danger">
                        <p>{{ $errors->first('nombre') }}</p>
                    </div>
                @endif
            </div>

            <div class="form-group">
                <label for="descripcion">Descripcion</label>
                <textarea name="descripcion" id="descripcion" cols="30" rows="10" class="form-control">{{ old('descripcion') }}</textarea>
                @if ($errors->has('descripcion'))
                    <div class="text-danger">
                        <p>{{ $errors->first('descripcion') }}</p>
                    </div>
                @endif
            </div>

            <div class="form-group">
                <label for="precio">Precio</label>
                <input type="number" step="0.01" id="precio" name="precio" class="form-control" value="{{ old('precio') }}">
                @if ($errors->has('precio'))
                    <div class="text-danger">
                        <p>{{ $errors->first('precio') }}</p>
                    </div>
                @endif
            </div>

            <div class="form-group">
                <label for="categoria">Categoria</label>
                <select name="categoria" id="categoria">
                  <option value="#" selected disabled>Selecciona una categoria</option>
                  @forelse ($categorias as $categoria)
                      <option value="{{ $categoria->id }}">{{ $categoria->nombre }}</option>
                  @empty
                      <option value="#">No hay categorias</option>
                  @endforelse
                </select>
                @if ($errors->has('categoria'))
                    <div class="text-danger">
                        <p>{{ $errors->first('categoria') }}</p>
                    </div>
                @endif
            </div>


            <div class="form-group">
                <input type="submit" value="Crear" class="btn btn-dark mt-2">
            </div>

        </form>
    </main>
@endsection
