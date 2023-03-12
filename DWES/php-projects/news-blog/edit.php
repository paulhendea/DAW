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
  <link rel="stylesheet" href="css/edit.css">
  
</head>

<body>

  <header id="header">
    <h1>News Blog</h1>
  </header>

  <main>  
    <?php

    if (!isset($_POST["submit"])) {
        
      // check id param
      if (!isset($_GET['id']) || empty($_GET['id'])) die('<h3>Post ID not found :(</h3>');

      // database config
      $conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

      // check connection
      if (mysqli_connect_errno()) {
        print 'Failed to connect with the database :( <br>' . mysqli_connect_error();
      }

      $sql = POST_BY_ID_QUERY;
      $sql = str_replace(ID_PLACEHOLDER, $_GET['id'], $sql);
      $result = mysqli_query($conn, $sql);

      // show result
      $row = mysqli_fetch_array($result);
      if ($row == false) die('<h3>Post ID not found :(</h3>');

      // transform data
      $id = $_GET['id'];
      $title = $row['post_title'];
      $slug = $row['post_slug'];
      $abstract = $row['post_abstract'];
      $body = $row['post_body'];
      $date = $row['post_date'];
      $visible = $row['post_visible'] == 'Mostrar' ? 'checked' : '';
      $image = $row['post_image'];

      // print form
      print '<h3>Edit post with id ' . $id . '</h3>';

      print 
      '<form method="POST" action="edit.php" enctype="multipart/form-data"> 
        <input type="hidden" name="id" value="' . $id . '">
        <input type="hidden" name="image" value="' . $image . '">
        <p>
          <label for="title">Title: </label>
          <input type="text" id="title" class="expand" name="title" value="' . $title . '" maxlength="100" placeholder="a catchy title" required autofocus>
        </p>
        <p>
          <label for="slug">Slug: </label>
          <input type="text" id="slug" class="expand" name="slug" value="' . $slug . '" maxlength="100" placeholder="no spaces allowed, use (-) instead" required>
        </p>
        <p>
          <label for="abstract">Abstract: </label>
          <input type="text" id="abstract" class="expand" name="abstract" value="' . $abstract . '" maxlength="255" placeholder="a little description" required>
        </p>
        <p>
          <label for="body">Body: </label><br>
          <textarea id="body" name="body" rows="10" cols="50" placeholder="use HTML5 tags to format the text here" required>' . $body . '</textarea>
        </p>
        <p>
          <label for="date">Date: </label>
          <input type="date" id="date" name="date" value="' . $date . '" required>
        </p>
        <p>
          <label for="visible">Visible: </label>
          <input type="checkbox" id="visible" name="visible" ' . $visible . '>
        </p>
        <p>
          <input type="hidden" name="MAX_FILE_SIZE" value="4194304">
          <label for="image">Image: </label>
          <input type="file" id="image" name="image">
        </p>

        <p>
          <input type="submit" name="submit" value="Insert">
          <input type="reset" value="Clean">
        </p>

      </form>';
    }
    else {

      // database config
      $conn = mysqli_connect(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

      // check connection
      if (mysqli_connect_errno()) {
        print 'Failed to connect with the database :( <br>' . mysqli_connect_error();
      }

      // get body params
      // with addslashes function we can escape the special characters like quotes or slashes
      $id = $_POST['id'];
      $title = addslashes($_POST['title']);
      $slug = addslashes($_POST['slug']);
      $abstract = addslashes($_POST['abstract']);
      $body = addslashes($_POST['body']);
      $date = $_POST['date'];
      $visible = $_POST['visible'] ? 'Mostrar' : 'No Mostrar';
      $image = $_POST['image'];

      // data validation
      if (strpos($slug, " ")) die("<header><h1>Space was found in slug</h1></header>");
      if (is_uploaded_file($_FILES['image']['tmp_name'])) {
        $imgDir = 'img/';
        $uniqueName = time() . '-' . $_FILES['image']['name'];

        move_uploaded_file($_FILES['image']['tmp_name'], $imgDir . $uniqueName);
        $image = $uniqueName;
      }
      else {
        print('original image used');
      }
      
      $sql = UPDATE_QUERY;
      $sql = str_replace(ID_PLACEHOLDER, $id, $sql);
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
        print '<header><h1>Post with id: $id updated successfully :)</h1></header>';
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