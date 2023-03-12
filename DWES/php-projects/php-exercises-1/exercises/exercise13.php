<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 13</title>
</head>

<body>

    <h1>Exercise 13</h1>

    <?php

    $symbol = "*";

    print "<p>";

    $i = 1;
    while ($i <= 6) {
        $j = 0;
        while ($j < $i) {
            print $symbol;
            $j++;
        }
        print "<br>";
        $i++;
    }

    print "</p>";

    ?>

</body>

</html>