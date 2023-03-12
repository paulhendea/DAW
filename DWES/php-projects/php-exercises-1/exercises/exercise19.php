<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 19</title>
</head>

<body>

    <h1>Exercise 19</h1>

    <?php

    $NUM = 100;

    print "<p>";

    for ($i = $NUM; $i >= 0; $i -= 2) {
        print "$i";
        if ($i == 1 || $i == 0) print ".";
        else print ", ";
    }
    print "</p>";

    ?>

</body>

</html>