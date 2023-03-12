<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 24</title>
</head>

<body>

    <h1>Exercise 24</h1>

    <?php

    $grade = mt_rand() / mt_getrandmax() * 10;
    $grade = number_format($grade, 2);

    print "<p>The grade is $grade, ";

    switch ((int) $grade) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
            print "insufficient.";
            break;
        case 5:
            print "ok.";
            break;
        case 6:
            print "good.";
            break;
        case 7:
        case 8:
            print "very good.";
            break;
        case 9:
        case 10:
            print "excellent.";
            break;
        default:
            print "unexpected grade... :(";
    }

    print "</p>";

    ?>

</body>

</html>