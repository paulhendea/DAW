<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 23</title>
</head>

<body>

    <h1>Exercise 23</h1>

    <?php

    $times = 20;
    $a = 1;
    $b = 1;
    $next = $a + $b;

    print "<p>First $times numbers of Fibonacci sequence:<br>
        $a, $b, ";

    # start the counter on 3 because we already have 2 numbers

    for ($i = 3; $i <= $times; $i++) {
        print $next;
        print $i == $times ? "." : ", ";

        $a = $b;
        $b = $next;
        $next = $a + $b;
    }

    print "</p>";

    ?>

</body>

</html>