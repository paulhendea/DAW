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
    }
    else {
      // database config
    $conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

      // check connection
      if (mysqli_connect_errno()) {
        print 'Failed to connect with the database :( <br>' . mysqli_connect_error();
      }

      // execute query
      $id = $_GET['id'];
      $sql = HIDE_POST_QUERY;
      $sql = str_replace(ID_PLACEHOLDER, $id, $sql);

      // show result
      if (!mysqli_query($conn, $sql)) {
        die('Error: '.mysqli_error($conn)."<br>SQL:=".$sql);
      }
      else {
        print '<header><h1>Post with id: $id deleted successfully :)</h1></header>';
      }

      // close connection
      mysqli_close($conn);

      // redirect to home page
      header('Location: index.php');
    }
    ?>
  </header>

</body>

</html>