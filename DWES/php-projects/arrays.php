<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Arrays</title>
</head>
<body>

  <?php

  $names = array("Paul", "JCarlos", "Manel", "Sandra", "Alejandro");
  $students = array(
    array("id" => "01", "name" => "Paul", "age" => "23"),
    array("id" => "02", "name" => "JCarlos", "age" => "19"),
    array("id" => "03", "name" => "Manel", "age" => "14"),
    array("id" => "04", "name" => "Sandra", "age" => "25"),
    array("id" => "05", "name" => "Alejandro", "age" => "20")
  );
  $numbers = array();
  // fill the numbers array with random values
  for ($i = 0; $i < 10; $i++) {
    $numbers[$i] = rand(0, 10);
  }
  
  // Names array
  print "<h1>Names array</h1>";
  print "<p>";
  print "For the following array with names: " . implode(", ", $names) . "<br>";
    
  print "Length: " . count($names) . "<br>";

  // since the sort function sorts the original string, we need to copy the original array before sorting
  $names2 = $names;
  sort($names2);
  $names_string = implode(" ", $names2);
  print "Using implode() and sort(): $names_string<br>";

  $names_reverse = array_reverse($names);
  print "Reverse: " . implode(", ", $names_reverse) . "<br>";

  print "Position of Paul: " . array_search("Paul", $names_reverse) . "<br>";
  print "</p>";

  // Students array
  print "<h1>Students array</h1>";
  $students_id = array_column($students, "id");
  $students_names = array_column($students, "name");
  $students_age = array_column($students, "age");

  print '
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
      </tr>
  ';
  for ($i = 0; $i < count($students); $i++) {
    print '<tr>';
    print '<td>' . $students_id[$i] . '</td>';
    print '<td>' . $students_names[$i] . '</td>';
    print '<td>' . $students_age[$i] . '</td>';
    print '</tr>';
  }
  print '
    </table>
  ';

  // Number array
  print "<h1>Numbers array</h1>";
  print "From the following array with numbers " . implode(", ", $numbers) . "<br>";
  print "Sum: " . array_sum($numbers) . "<br>";


  ?>
  
</body>
</html>