<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 10</title>
</head>

<body>

    <h1>Exercise 10</h1>

    <?php

    $NUM = 100;

    print "<p>";
    $i = 1;
    while ($i <= $NUM) {
        print "$i";

        if ($i != $NUM) print ", ";
        else print ".";

        $i++;
    }
    print "</p>";

    ?>

</body>

</html>