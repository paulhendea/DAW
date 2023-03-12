<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Strings</title>

    <!-- CSS -->
    <style>
        .container {
            margin: 50px;
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<body>

    <?php

        if (!isset($_GET["submit"])) {
            echo '
                <div class="container">
                    <form method="GET" action="index.php">
                        <input type="text" name="prefix" placeholder="Prefix" autofocus>
                        <input type="text" name="name" placeholder="Name">
                        <input type="submit" name="submit" value="submit">
                    </form>
                </div>
            ';
        }
        else {

            echo "<p>";
            if (!empty($_GET["name"])) {
                $name = $_GET["name"];
                $name = trim($name, "/");
                echo "Name: $name<br>";
            }
            else {
                echo "Nickname: Paul<br>";
            }

            print "Name length: " . strlen($name) . "<br>";
            echo "Uppercase: " . strtoupper($name) . "<br>";
            echo "Lowercase: " . strtolower($name) . "<br>";

            if (!empty($_GET["prefix"])) {
                $prefix = $_GET["prefix"];
                $start_with = str_starts_with($name, $prefix);
                if ($start_with) {
                    echo "The name starts with $prefix<br>";
                }
                else {
                    echo "The name does NOT start with $prefix<br>";
                }
            }

            $numOfA = substr_count(strtolower($name), "a");
            echo "Letter 'A' appears $numOfA times<br>";

            if ($numOfA != 0) {
                $firstOccurrenceOfA = strpos(strtolower($name), "a");
                echo "The first occurrence of letter 'A' is at position $firstOccurrenceOfA<br>";
            }
            else {
                echo "There is no letter 'A' :(";
            }

            echo "Replacing o by 0: " . str_replace("o", "0", strtolower($name)) . "<br>";

            $url = 'http://username:password@hostname:9090/path?arg=value';
            echo "From the following url: http://username:password@hostname:9090/path?arg=value<br>";
            echo "Protocol: " . parse_url($url, PHP_URL_SCHEME) . "<br>";
            echo "Username: " . parse_url($url, PHP_URL_USER) . "<br>";
            echo "Path: " . parse_url($url, PHP_URL_PATH) . "<br>";
            echo "Query: " . parse_url($url, PHP_URL_QUERY) . "<br>";
            
            echo "</p>";
        }

    ?>
    
</body>
</html>