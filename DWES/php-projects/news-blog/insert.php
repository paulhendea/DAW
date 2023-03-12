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
  <link rel="stylesheet" href="css/insert.css">
  
</head>

<body>

  <header id="header">
    <h1>News Blog</h1>
  </header>

  <main>
    <?php
      if (!isset($_POST["submit"])) {

        print '<h3>Insert post</h3>';
        
      ?>  

        <form method="POST" action="insert.php" enctype="multipart/form-data"> 
          <p>
            <label for="title">Title: </label>
            <input type="text" id="title" class="expand" name="title" maxlength="100" placeholder="a catchy title" required autofocus>
          </p>
          <p>
            <label for="slug">Slug: </label>
            <input type="text" id="slug" class="expand" name="slug" maxlength="100" placeholder="no spaces allowed, use (-) instead" required>
          </p>
          <p>
            <label for="abstract">Abstract: </label>
            <input type="text" id="abstract" class="expand" name="abstract" maxlength="255" placeholder="a little description" required>
          </p>
          <p>
            <label for="body">Body: </label><br>
            <textarea id="body" name="body" rows="10" cols="50" placeholder="use HTML5 tags to format the text here" required></textarea>
          </p>
          <p>
            <label for="date">Date: </label>
            <input type="date" id="date" name="date" required>
          </p>
          <p>
            <label for="visible">Visible: </label>
            <input type="checkbox" id="visible" name="visible" checked>
          </p>
          <p>
            <input type="hidden" name="MAX_FILE_SIZE" value="4194304">
            <label for="image">Image: </label>
            <input type="file" id="image" name="image" required>
          </p>

          <p>
            <input type="submit" name="submit" value="Insert">
            <input type="reset" value="Clean">
          </p>

        </form>

      <?php
      }
      else {

        // database config
        $conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

        // check connection
        if (mysqli_connect_errno()) {
          print 'Failed to connect with the database :( <br>' . mysqli_connect_error();
        }

        // get body params
        $title = addslashes($_POST['title']);
        $slug = addslashes($_POST['slug']);
        $abstract = addslashes($_POST['abstract']);
        $body = addslashes($_POST['body']);
        $date = $_POST['date'];
        $visible = $_POST['visible'] ? 'Mostrar' : 'No Mostrar';

        // data validation
        if (strpos($slug, " ")) die("<header><h1>Space was found in slug</h1></header>");
        if (is_uploaded_file($_FILES['image']['tmp_name'])) {
          $imgDir = 'img/';
          $uniqueName = time() . '-' . $_FILES['image']['name'];

          move_uploaded_file($_FILES['image']['tmp_name'], $imgDir . $uniqueName);
          $image = $uniqueName;
        }
        else {
          die("<header><h1>Image cant be uploaded</h1></header>");
        }
        
        $sql = INSERT_QUERY;
        $sql = str_replace(TITLE_PLACEHOLDER, $title, $sql);
        $sql = str_replace(SLUG_PLACEHOLDER, $slug, $sql);
        $sql = str_replace(ABSTRACT_PLACEHOLDER, $abstract, $sql);
        $sql = str_replace(BODY_PLACEHOLDER, $body, $sql);
        $sql = str_replace(DATE_PLACEHOLDER, $date, $sql);
        $sql = str_replace(VISIBLE_PLACEHOLDER, $visible, $sql);
        $sql = str_replace(IMAGE_PLACEHOLDER, $image, $sql);

        // show result
        if (!mysqli_query($conn, $sql)) {
          die('Error: '.mysqli_error($conn)."<br>SQL:= ".$sql);
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
  </main>

  <footer></footer>

</body>

</html>