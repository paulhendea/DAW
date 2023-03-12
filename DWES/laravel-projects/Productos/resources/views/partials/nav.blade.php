<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-3 mb-3">
    <a class="navbar-brand" href="{{ route('productos.index') }}">Productos</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="{{ route('productos.create') }}">Nuevo producto</a></li>
        </ul>
    </div>
</nav>
