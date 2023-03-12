<nav>
    <ul>
        <li><a href="{{ route('index') }}">Index</a></li>
        <li><a href="{{ route('book_list') }}">Book list</a></li>
        @if (auth()->check())
            <li><a href="{{ route('books.create') }}">New book</a></li>
            <li><a href="{{ route('logout') }}">Log out</a></li>
        @endif
    </ul>
</nav>
