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
  <link rel="stylesheet" href="css/post-detail.css">

</head>

<body>

  <main>
    <?php
    if (!isset($_GET['id']) || empty($_GET['id'])) {
      print '<header><h1>Post not found :(</h1></header>';
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
      $sql = POST_DETAIL_QUERY;
      $sql = str_replace(ID_PLACEHOLDER, $_GET['id'], $sql);
      // execute query
      $stmt = $dbh->prepare($sql);
      $stmt->execute();

      // show result
      if ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
        print "<header><h1>${row['post_title']}</h1></header>";
        print "<article>${row['post_body']}</article>";
      } else {
        print '<header><h1>Post not found :(</h1></header>';
      }

      // close connection
      $dbh = null;
    }
    ?>
  </main>

</body>

</html>