<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-3 mb-3">
    <a class="navbar-brand" href="{{ route('index') }}">Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="{{ route('posts.index') }}">Post list</a></li>
            @if (auth()->check())
                <li class="nav-item"><a class="nav-link" href="{{ route('posts.create') }}">New post</a></li>
            @endif
        </ul>
    </div>



    <div>
        <span class="navbar-text"> {{ currentDate('d/m/Y') }} </span>
        @if (auth()->check())
            <a href="{{ route('logout') }}"><button class="btn btn-light btn-block">Log out</button></a>
        @else
            <a href="{{ route('login') }}"><button class="btn btn-light btn-block">Log in</button></a>
        @endif
    </div>
</nav>
