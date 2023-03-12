<?php

// include sql queries and config
include_once('resources/MYSQL_CONFIG.php');
include_once('resources/SQL_QUERIES.php');

?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>News Blog</title>

  <!-- CSS -->
  <link rel="stylesheet" href="css/style.css">

</head>

<body>

  <header>
    <?php
    if (!isset($_GET['id']) || empty($_GET['id'])) {
      print '<header><h1>Post ID not found :(</h1></header>';
    } else {
      // database config
      try {
        $host = DB_HOST;
        $dbname = DB_NAME;
        $user = DB_USERNAME;
        $password = DB_PASSWORD;
        $dsn = "mysql:host=$host;dbname=$dbname";
        $dbh = new PDO($dsn, $user, $password);
      } catch (PDOException $e) {
        die($e->getMessage());
      }

      // prepare query
      $id = $_GET['id'];
      $sql = HIDE_POST_QUERY;
      $sql = str_replace(ID_PLACEHOLDER, $id, $sql);

      // execute query
      try {
        $rowsAffected = $dbh->exec($sql);
        print "
        <header>
          <h1>${rowsAffected} post hidden</h1>
          <p>Redirecting to home page in 3 seconds...</p>
        </header>";
      } catch (PDOException $e) {
        die($e->getMessage());
      }

      // close connection
      $dbh = null;

      // redirect to home page
      header('refresh: 3; url = index.php');
    }
    ?>
  </header>

</body>

</html>