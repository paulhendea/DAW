<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 8</title>
</head>

<body>

    <h1>Exercise 8</h1>

    <?php

    $num1 = mt_rand(0, 10);
    $num2 = mt_rand(0, 10);
    $add = $num1 + $num2;
    $mult = $num1 * $num2;

    print "<p>The numbers are $num1 and $num2.</p>";

    if ($add > $mult) print "<p>Addition is greater than multiplication.</p>";
    else if ($add < $mult) print "<p>Multiplication is greater than addition.</p>";
    # in some cases are equal (2 and 2, 0 and 0, etc)
    else print "<p>Addition and multiplication are equal.</p>";

    ?>

</body>

</html>