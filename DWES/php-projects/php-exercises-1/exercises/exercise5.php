<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 5</title>
</head>

<body>

    <h1>Exercise 5</h1>

    <?php

    $a = "Hello to everyone, ";
    $b = "my name is Paul Hendea.";
    $c = $a . $b;

    print "<p>Method 1: $c</p>";

    $a .= $b;

    print "<p>Method 2: $a</p>";

    ?>

</body>

</html>