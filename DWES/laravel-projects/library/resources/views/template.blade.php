<!DOCTYPE html>
<html>

<head>
    <title>
        @yield('title')
    </title>
</head>

<body>

    @include('partials.nav')
    @yield('header')
    @yield('content')

</body>

</html>
