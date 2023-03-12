<?php

class Post
{

  public $post_title;
  public $post_slug;
  public $post_abstract;
  public $post_body;
  public $post_date;
  public $post_visible;
  public $post_image;

  public function __construct(
    $post_title,
    $post_slug,
    $post_abstract,
    $post_body,
    $post_date,
    $post_visible,
    $post_image = null
  ) {
    $this->post_title = addslashes($post_title);
    $this->post_slug = $this->isValidSlug($post_slug)
      ? addslashes($post_slug)
      : throw new Exception("Invalid slug");
    $this->post_abstract = addslashes($post_abstract);
    $this->post_body = addslashes($post_body);
    $this->post_date = $post_date;
    $this->post_visible = $post_visible != null 
      ? 'Mostrar'
      : 'No Mostrar';
    $this->post_image = $post_image == null
      ? $this->processImage()
      : $post_image;
  }

  private function isValidSlug($slug)
  {
    return !boolval(strpos($slug, " "));
  }
  private function processImage()
  {
    if (is_uploaded_file($_FILES['image']['tmp_name'])) {
      $imgDir = 'img/';
      $uniqueName = time() . '-' . $_FILES['image']['name'];

      move_uploaded_file($_FILES['image']['tmp_name'], $imgDir . $uniqueName);
      return $uniqueName;
    } else {
      throw new Exception("Image cant be uploaded");
    }
  }

  public function __toString()
  {
    return '<br>title: ' . $this->post_title
      . '<br>slug: ' . $this->post_slug
      . '<br>abstract: ' . $this->post_abstract
      . '<br>body: ' . $this->post_body
      . '<br>date: ' . $this->post_date
      . '<br>visible: ' . $this->post_visible
      . '<br>image: ' . $this->post_image;
  }
}
