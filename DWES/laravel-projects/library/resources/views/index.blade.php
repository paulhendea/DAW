@extends('template')

@section('title', 'Index')
@section('header')
    <header>
        <h1>Main Page</h1>
        @if (auth()->check())
            <p> Welcome {{ auth()->user()->login }}</p>
        @endif
    </header>
@endsection
