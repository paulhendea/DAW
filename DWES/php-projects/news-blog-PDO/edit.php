<?php

// include sql queries and config
include_once('resources/MYSQL_CONFIG.php');
include_once('resources/SQL_QUERIES.php');
include_once('models/Post.php');

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
      $sql = POST_BY_ID_QUERY;
      $sql = str_replace(ID_PLACEHOLDER, $_GET['id'], $sql);
      // execute query
      $stmt = $dbh->prepare($sql);
      $stmt->execute();
      if ($post = $stmt->fetch(PDO::FETCH_OBJ)) {
        // print form
        print '<h3>Edit post with id ' . $_GET['id'] . '</h3>';

        print
          '<form method="POST" action="edit.php" enctype="multipart/form-data"> 
          <input type="hidden" name="id" value="' . $_GET['id'] . '">
          <input type="hidden" name="image" value="' . $post->post_image . '">
          <p>
            <label for="title">Title: </label>
            <input type="text" id="title" class="expand" name="title" value="' . $post->post_title . '" maxlength="100" placeholder="a catchy title" required autofocus>
          </p>
          <p>
            <label for="slug">Slug: </label>
            <input type="text" id="slug" class="expand" name="slug" value="' . $post->post_slug . '" maxlength="100" placeholder="no spaces allowed, use (-) instead" required>
          </p>
          <p>
            <label for="abstract">Abstract: </label>
            <input type="text" id="abstract" class="expand" name="abstract" value="' . $post->post_abstract . '" maxlength="255" placeholder="a little description" required>
          </p>
          <p>
            <label for="body">Body: </label><br>
            <textarea id="body" name="body" rows="10" cols="50" placeholder="use HTML5 tags to format the text here" required>' . $post->post_body . '</textarea>
          </p>
          <p>
            <label for="date">Date: </label>
            <input type="date" id="date" name="date" value="' . $post->post_date . '" required>
          </p>
          <p>
            <label for="visible">Visible: </label>
            <input type="checkbox" id="visible" name="visible" ' . ($post->post_visible == 'Mostrar' ? 'checked' : '') . '>
          </p>
          <p>
            <input type="hidden" name="MAX_FILE_SIZE" value="4194304">
            <label for="image">Image: </label>
            <input type="file" id="image" name="image">
          </p>

          <p>
            <input type="submit" name="submit" value="Update">
            <input type="reset" value="Clean">
          </p>

        </form>';
      } else {
        die('<h3>Post ID not found :(</h3>');
      }

      // close connection
      $dbh = null;
    } else {

      // database config
      try {
        $host = DB_HOST;
        $dbname = DB_NAME;
        $user = DB_USERNAME;
        $password = DB_PASSWORD;
        $dsn = "mysql:host=$host;dbname=$dbname";
        $dbh = new PDO($dsn, $user, $password);

        $post = new Post(
          $_POST['title'],
          $_POST['slug'],
          $_POST['abstract'],
          $_POST['body'],
          $_POST['date'],
          $_POST['visible'],
          is_uploaded_file($_FILES['image']['tmp_name']) ? null : $_POST['image']
        );

        // prepare query
        $sql = UPDATE_QUERY;
        $sql = str_replace(ID_PLACEHOLDER, $_POST['id'], $sql);
        // execute query
        $stmt = $dbh->prepare($sql);
        if ($stmt->execute((array) $post)) {
          print "
            <header>
              <h1>Post {$_POST['id']} updated successfully</h1>
              <p>Redirecting to home page in 3 seconds</p>
            </header>";
        }
      } catch (PDOException $e) {
        die($e->getMessage());
      } catch (Exception $e) {
        die($e->getMessage());
      }

      // close connection
      $dbh = null;

      // redirect to home page
      header('refresh: 3; url = index.php');
    }
    ?>
  </main>

  <footer></footer>

</body>

</html>