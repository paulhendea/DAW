@extends('template')

@section('title', 'Post edit')
@section('header')
    <header>
        <h1>Edit post</h1>
    </header>
@endsection

@section('content')
    <main>
        <form action="{{ route('posts.update', $post) }}" method="POST" class="form">
            @method('PUT')
            @csrf

            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="{{ $post->title }}">
                @if ($errors->has('title'))
                    <div class="text-danger">
                        <p>{{ $errors->first('title') }}</p>
                    </div>
                @endif
            </div>

            <div class="form-group">
                <label for="content">Content</label>
                <textarea name="content" id="content" cols="30" rows="10" class="form-control">{{ $post->content }}</textarea>
                @if ($errors->has('content'))
                    <div class="text-danger">
                        <p>{{ $errors->first('content') }}</p>
                    </div>
                @endif
            </div>

            <div class="form-group">
                <input type="submit" value="Update" class="btn btn-dark mt-2">
            </div>

        </form>
    </main>
@endsection
