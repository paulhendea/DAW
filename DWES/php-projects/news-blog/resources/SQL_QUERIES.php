<?php

define('ID_PLACEHOLDER', '${post_id}');
define('TITLE_PLACEHOLDER', '${post_title}');
define('SLUG_PLACEHOLDER', '${post_slug}');
define('ABSTRACT_PLACEHOLDER', '${post_abstract}');
define('BODY_PLACEHOLDER', '${post_body}');
define('DATE_PLACEHOLDER', '${post_date}');
define('VISIBLE_PLACEHOLDER', '${post_visible}');
define('IMAGE_PLACEHOLDER', '${post_image}');

define('ORDER_ASC', 'ASC');
define('ORDER_DESC', 'DESC');

define('INDEX_DESC_QUERY', '
  SELECT 
    post_id, 
    post_title, 
    post_slug, 
    post_abstract, 
    post_date, 
    post_visible, 
    post_image 
  FROM 
    gnr_post
  ORDER BY 
    post_date DESC
');

define('INDEX_ASC_QUERY', '
SELECT 
  post_id, 
  post_title, 
  post_slug, 
  post_abstract, 
  post_date, 
  post_visible, 
  post_image 
FROM 
  gnr_post
ORDER BY 
  post_date ASC
');

define('POST_BY_ID_QUERY', '
  SELECT 
    post_title, 
    post_slug, 
    post_abstract, 
    post_body, 
    post_date, 
    post_visible, 
    post_image 
  FROM 
    gnr_post 
  WHERE 
    post_id = '.ID_PLACEHOLDER.'
');

define('POST_DETAIL_QUERY', '
  SELECT 
    post_title, 
    post_body, 
    post_date, 
    post_image 
  FROM 
    gnr_post 
  WHERE 
    post_id = '.ID_PLACEHOLDER.'
');

define('DELETE_QUERY', '
  DELETE FROM 
    gnr_post 
  WHERE 
    post_id = '.ID_PLACEHOLDER.' 
');

define('HIDE_POST_QUERY', '
  UPDATE 
    gnr_post 
  SET 
    post_visible = "No Mostrar" 
  WHERE 
    post_id = '.ID_PLACEHOLDER.' 
');

define('INSERT_QUERY', '
  INSERT INTO 
    gnr_post 
    (
      post_title, 
      post_slug, 
      post_abstract, 
      post_body, 
      post_date, 
      post_visible, 
      post_image
    ) 
  VALUES 
    (
      "'.TITLE_PLACEHOLDER.'", 
      "'.SLUG_PLACEHOLDER.'", 
      "'.ABSTRACT_PLACEHOLDER.'", 
      "'.BODY_PLACEHOLDER.'", 
      "'.DATE_PLACEHOLDER.'", 
      "'.VISIBLE_PLACEHOLDER.'", 
      "'.IMAGE_PLACEHOLDER.'"
    )
');

define('UPDATE_QUERY', '
  UPDATE 
    gnr_post 
  SET 
    post_title = "'.TITLE_PLACEHOLDER.'",
    post_slug = "'.SLUG_PLACEHOLDER.'", 
    post_abstract = "'.ABSTRACT_PLACEHOLDER.'", 
    post_body = "'.BODY_PLACEHOLDER.'", 
    post_date = "'.DATE_PLACEHOLDER.'", 
    post_visible = "'.VISIBLE_PLACEHOLDER.'", 
    post_image = "'.IMAGE_PLACEHOLDER.'" 
  WHERE 
    post_id = '.ID_PLACEHOLDER.'
');
