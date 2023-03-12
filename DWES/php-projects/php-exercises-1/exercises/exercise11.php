<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise 11</title>

    <style>
        table,
        table td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>

<body>

    <h1>Exercise 11</h1>

    <?php

    $tableNum = mt_rand(1, 10);

    print "<table>
        <caption>Talel of $tableNum</caption>
        <tbody>";
    $i = 1;
    while ($i <= 10) {
        $mult = $tableNum * $i;
        print "<tr><td>$tableNum * $i</td><td>$mult</td></tr>";
        $i++;
    }
    print "</tbody>
        </table>";

    ?>

</body>

</html>