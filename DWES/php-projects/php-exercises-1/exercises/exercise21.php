<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 21</title>
</head>

<body>

    <h1>Exercise 21</h1>

    <?php

    $num = mt_rand(1, 100);

    print "<p>The divisors of $num are ";


    for ($i = 1; $i <= $num; $i++) {
        # if the $i is not a divisor then increment and continue
        if ($num % $i != 0) continue;

        print $i;
        print $i != $num ? ", " : ".";
    }
    print "</p>";

    ?>

</body>

</html>