<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 7</title>
</head>

<body>

    <h1>Exercise 7</h1>

    <?php

    $num = mt_rand(0, 100);

    # check the parity
    $parity = $num % 2 == 0 ? "even" : "odd";

    print "<p>The number $num is $parity.</p>";

    ?>

</body>

</html>