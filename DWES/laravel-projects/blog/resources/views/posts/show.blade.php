@extends('template')

@section('title', 'Post detail')
@section('header')
    <header>
        <h1>{{ $post->title }}</h1>
        <p>{{ $post->user->login }} - {{ showDate($post->created_at) }}</p>
    </header>
@endsection

@section('content')
    <main>
        <p>{{ $post->content }}</p>
        <section id="comments">
            <h3>Comments</h3>
            @forelse ($post->comments as $comment)
                <article>
                    <p>
                        <strong>{{ $comment->user->login }}</strong> - {{ showDate($comment->created_at) }}
                    </p>
                    <p>{{ $comment->content }}</p>
                </article>
            @empty
                <p>There is no comments :(</p>
            @endforelse
        </section>
    </main>
@endsection
