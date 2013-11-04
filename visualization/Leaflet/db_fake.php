<!DOCTYPE html>
<html>
  <head>
  </head>
  
  <body>
  
  <?php 
    echo ("<p><b>Setting new date values:</b></p>".
          "<table border='1' cellspacing='0' cellpadding='3'>".
          "<tr><th>ID</th><th>Old Date</th><th>Type</th><th>Position</th>".
          "<th>New Date</th></tr>");
  
    // Datenbankverbindung aufbauen und alle Werte abrufen.
    mysql_connect ("localhost", "root", "");
    mysql_select_db ("flood_protection");
    mysql_query ('SET character_set_results = utf8');  
    $query_result = mysql_query ("SELECT * FROM processed_data");     
    $result = array ();
    
    for ($i = 0; $i < mysql_num_rows ($query_result); $i ++) {    
      $result[$i] = mysql_fetch_array ($query_result);
      $id = $result[$i]['id'];  
     
      $date = new DateTime ("now"); 
      $date->sub (new DateInterval ("PT".rand(0, 240)."M".rand(0, 59)."S"));
      $date = date ("Y-m-d H:i:s", $date->getTimestamp ());
      
      echo ("<tr><td>$id</td><td>".$result[$i]['senddate']."</td>".
            "<td>".$result[$i]['category']."</td><td>".$result[$i]['position']."</td>".
            "<td>$date</td></tr>");
              
      mysql_query ("UPDATE processed_data SET senddate='$date' WHERE id='$id'");
    }         
    mysql_close ();  
    
    echo ("</table><p><b>Finished!</b></p>".
          "<a href='index.php'>Return to Map</a>");  
  ?>
  
  </body>
</html>  