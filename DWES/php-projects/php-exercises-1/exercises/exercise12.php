<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 12</title>
</head>

<body>

    <h1>Exercise 12</h1>

    <?php

    $NUM = 100;

    print "<p>";
    $i = $NUM;
    while ($i >= 0) {
        print "$i";
        if ($i == 1 || $i == 0) print ".";
        else print ", ";
        $i -= 2;
    }
    print "</p>";

    ?>

</body>

</html>