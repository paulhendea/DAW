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

    // get order param
    $order = $_GET['order'] ?? ORDER_DESC;
    if ($order != ORDER_ASC && $order != ORDER_DESC) {
      $order = ORDER_DESC;
    }

    // execute query
    $sql = $order == ORDER_DESC ? INDEX_DESC_QUERY : INDEX_ASC_QUERY;
    $stmt = $dbh->prepare($sql);
    $stmt->execute();

    // show result
    // set orderLink the opposite value of order
    $orderLink = $order != ORDER_DESC ? ORDER_DESC : ORDER_ASC;
    print '
      <nav>
        <ul class="buttons">
          <li><a href="insert.php">+ New post</a></li>
          <li><a href="index.php?order=' . $orderLink . '">Order ' . $orderLink . '</a></li>
        </ul>
      </nav>
    ';

    while ($row = $stmt->fetch(PDO::FETCH_OBJ)) {
      if ($row->post_visible == 'Mostrar') {
        print '
        <article>
          <header>
            <h3>' . $row->post_title . '</h3>
            <small>' . $row->post_date . '</small>
          </header>
          <p class="image"><img src="img/' . $row->post_image . '"></p>
          <p>' . $row->post_abstract . '</p>
          <div class="buttons">
            <a href="post-detail.php?id=' . $row->post_id . '">Read More</a>
            <a href="edit.php?id=' . $row->post_id . '"">Edit</a>
            <a href="delete.php?id=' . $row->post_id . '">Delete</a>
          </div>
        </article>
        ';
      }
    }

    // close connection
    $dbh = null;
    ?>
  </main>

  <footer></footer>

</body>

</html>