<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 6</title>
</head>

<body>

    <h1>Exercise 6</h1>

    <?php

    $mainNumbers = [];
    $starNumbers = [];

    # fill the main numbers array
    for ($i = 0; $i < 5; $i++) {
        $rand = mt_rand(1, 50);
        # make sure there is no duplicates
        if (!in_array($rand, $mainNumbers)) {
            $mainNumbers[] = $rand;
        } else $i--;
    }

    # fill the star numbers array
    for ($i = 0; $i < 2; $i++) {
        $rand = mt_rand(1, 9);
        # make sure there is no duplicates
        if (!in_array($rand, $starNumbers)) {
            $starNumbers[] = $rand;
        } else $i--;
    }

    # print main numbers
    print "<p>Main numbers: <br>";
    foreach ($mainNumbers as $mainNum) {
        print "$mainNum<br>";
    }
    print "</p>";

    # print star numbers
    print "<p>Star numbers: <br>";
    foreach ($starNumbers as $starNum) {
        print "$starNum<br>";
    }
    print "</p>";

    ?>

</body>

</html>