<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 17</title>
</head>

<body>

    <h1>Exercise 17</h1>

    <?php

    $num = 100;

    print "<p>";
    for ($i = 1; $i <= $num; $i++) {
        print $i;
        print $i == $num ? "." : ", ";
    }
    print "</p>";

    ?>

</body>

</html>