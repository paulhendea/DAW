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
  <link rel="stylesheet" href="css/index.css">
  
</head>

<body>

  <header id="header">
    <h1>News Blog</h1>
  </header>

  <main>
    <?php
    // database config
    $conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

    // check connection
    if (mysqli_connect_errno()) {
      print 'Failed to connect with the database :( <br>' . mysqli_connect_error();
    }

    // get order param
    $order = $_GET['order'];
    if ($order != ORDER_ASC && $order != ORDER_DESC) {
      $order = ORDER_DESC;
    }

    // execute query
    $sql = $order == ORDER_DESC ? INDEX_DESC_QUERY : INDEX_ASC_QUERY ;
    $result = mysqli_query($conn, $sql);

    // show result
    // set orderLink the opposite value of order
    $orderLink = $order != ORDER_DESC ? ORDER_DESC : ORDER_ASC;
    print 
    '
      <nav>
        <ul class="buttons">
          <li><a href="insert.php">+ New post</a></li>
          <li><a href="index.php?order='.$orderLink.'">Order '.$orderLink.'</a></li>
        </ul>
      </nav>
    ';
    
    while ($row = mysqli_fetch_array($result)) {
      if ($row['post_visible'] == 'Mostrar') {
        print '<article>';
          print '<header><h3>' . $row['post_title'] . '</h3>';
          print '<small>' . $row['post_date'] . '</small></header>';
          print '<p class="image"><img src="img/' . $row['post_image'] . '"></p>';
          print '<p>' . $row['post_abstract'] . '</p>';
          // buttons
          print '<div class="buttons">';
            print '<a href="post-detail.php?id=' . $row['post_id'] . '">Read More</a>';
            print '<a href="edit.php?id=' . $row['post_id'] . '"">Edit</a>';
            print '<a href="delete.php?id=' . $row['post_id'] . '">Delete</a>';
          print '</buttons>';
        print '</article>';
      }
    }

    // close connection
    mysqli_close($conn);
    ?>
  </main>

  <footer></footer>

</body>

</html>