@extends('template')

@section('title', 'Login')
@section('header')
  <header>
    <h1>Log in</h1>
  </header>
@endsection
@section('content')
  <main>
    <form action="{{ route('login') }}" method="POST">
      @csrf
      <div class="fomr-group">
        <label for="login">Username</label>
        <input type="text" class="form-control" id="login" name="login">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="passowrd" name="password">
      </div>
      <input type="submit" value="Log in" class="btn btn-dark btn-block">
      @if (!empty($error))
          <div class="text-danger">
            <p>{{ $error }}</p>
          </div>
      @endif
    </form>
  </main>
@endsection
