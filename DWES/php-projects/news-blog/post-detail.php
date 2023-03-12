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
      }
      else {
        // database config
    $conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

        // check connection
        if (mysqli_connect_errno()) {
          print 'Failed to connect with the database :( <br>' . mysqli_connect_error();
        }

        // execute query
        $sql = POST_DETAIL_QUERY;
        $sql = str_replace(ID_PLACEHOLDER, $_GET['id'], $sql);
        $result = mysqli_query($conn, $sql);

        // show result
        if ($row = mysqli_fetch_array($result)) {
          print '<header><h1>' . $row['post_title'] . '</h1></header>';
          print '<article>' . $row['post_body'] . '</article>';
        }
        else {
          print '<header><h1>Post not found :(</h1></header>';
        }

        // close connection
        mysqli_close($conn);
      }
    ?>
  </main>
  
</body>
</html>