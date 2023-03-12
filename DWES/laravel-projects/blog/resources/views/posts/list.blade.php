@extends('template')

@section('title', 'Post list')

@section('header')
    <header>
        <h1>Post list</h1>
    </header>
@endsection

@section('content')
    <main>
        <div class="post-grid">
            @forelse($posts as $post)
                <article>
                    <header>
                        <h3>{{ $post->title }}</h3>
                        <p>{{ $post->user->login }}</p>
                        {{-- <small>' . $row->post_date . '</small> --}}
                    </header>
                    {{-- <p class="image"><img src="img/' . $row->post_image . '"></p> --}}
                    {{-- <p>' . $row->post_abstract . '</p> --}}
                    <div class="buttons">
                        <a href="{{ route('posts.show', $post) }}"><button class="btn btn-primary">Read More</button></a>
                        @if (auth()->check() && (auth()->user()->rol == 'admin' || $post->user->id == auth()->user()->id))
                            <a href="{{ route('posts.edit', $post) }}"><button class="btn btn-warning">Edit</button></a>
                            <form action="{{ route('posts.destroy', $post) }}" method="POST">
                                @method('DELETE')
                                @csrf
                                <button class="btn btn-danger">Delete</button>
                            </form>
                        @endif
                    </div>
                </article>

            @empty
                <p>There are no posts :(</p>
            @endforelse
        </div>
    </main>

    {{ $posts->links() }}
@endsection
