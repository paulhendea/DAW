@extends('plantilla')

@section('title', 'Editar producto')

@section('content')
<header>
    <h1>Editar producto</h1>
</header>
    <main>
        <form action="{{ route('productos.update', $producto) }}" method="POST" class="form">
            @method('PUT')
            @csrf

            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" id="nombre" name="nombre" value="{{ $producto->nombre }}">
              @if ($errors->has('nombre'))
                  <div class="text-danger">
                      <p>{{ $errors->first('nombre') }}</p>
                  </div>
              @endif
          </div>

          <div class="form-group">
              <label for="descripcion">Descripcion</label>
              <textarea name="descripcion" id="descripcion" cols="30" rows="10" class="form-control">{{ $producto->descripcion }}</textarea>
              @if ($errors->has('descripcion'))
                  <div class="text-danger">
                      <p>{{ $errors->first('descripcion') }}</p>
                  </div>
              @endif
          </div>

          <div class="form-group">
              <label for="precio">Precio</label>
              <input type="number" step="0.01" id="precio" name="precio" class="form-control" value="{{ $producto->precio }}">
              @if ($errors->has('precio'))
                  <div class="text-danger">
                      <p>{{ $errors->first('precio') }}</p>
                  </div>
              @endif
          </div>

          <div class="form-group">
              <label for="categoria">Categoria</label>
              <select name="categoria" id="categoria">
                <option value="{{ $producto->categoria->id }}" selected disabled>{{ $producto->categoria->nombre }}</option>
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
              <input type="submit" value="Editar" class="btn btn-dark mt-2">
          </div>

        </form>
    </main>
@endsection
