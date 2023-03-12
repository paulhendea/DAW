<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 20</title>
</head>

<body>

    <h1>Exercise 20</h1>

    <?php

    $symbol = "*";

    print "<p>";

    for ($i = 1; $i <= 6; $i++) {
        for ($j = 0; $j < $i; $j++) {
            print $symbol;
        }
        print "<br>";
    }

    print "</p>";

    ?>

</body>

</html>