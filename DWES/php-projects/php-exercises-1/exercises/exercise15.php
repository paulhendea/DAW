<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 15</title>
</head>

<body>

    <h1>Exercise 15</h1>

    <?php

    $num = mt_rand(1, 100);
    $isPrime = true;
    $i = 2;
    while ($i < $num) {
        if ($num % $i == 0) $isPrime = false;
        $i++;
    }

    $answer = $isPrime ? "is" : "is not";
    print "<p>$num " . $answer . " a prime number.</p>";

    ?>

</body>

</html>