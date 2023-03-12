<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 9</title>
</head>

<body>

    <h1>Exercise 9</h1>

    <?php

    $firstName = "Paul ";
    $lastName = "Hendea";
    $num1 = mt_rand(-10, 10);
    $num2 = mt_rand(-10, 10);

    print "<p>num1 = $num1<br>
        num2 = $num2</p>";

    # we supose that when $num1 is 0 will be the first case
    print "<p>";
    if ($num1 < 0) {
        print $firstName . $lastName;
    } else if ($num1 > $num2) {
        print $firstName;
    } else {
        print $lastName;
    }
    print "</p>";

    ?>

</body>

</html>