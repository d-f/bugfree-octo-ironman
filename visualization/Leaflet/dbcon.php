<?php  

  $dbconnected = 0;       // Status der MySQL-Verbindung.
                          // (0-getrennt, 1-manuell, 2-automatisch)


  // Wenn eine GET-Anfrage kommt, wird sie bearbeitet und das Ergebnis zurückgegeben.
  if (isset ($_GET['q'])) {
    $result = execQuery ($_GET['q']);
    echo json_encode ($result);  
  }    
      
      
  /** Führt eine Anfrage auf die Datenbank durch.
   * @param query Ein String mit der zu stellenden SQL-Anfrage. 
   * @return Ein normalisiertes PHP-Array mit den Ergebnisdaten. */
  function execQuery ($query) {
    global $dbconnected;
    if ($dbconnected == 0) { 
      connectDB (); 
      $dbconnected = 2;
    }
    $query_result = mysql_query ($query);     
    $result = array(); // Datenbank-Einträge in ein PHP-Array formatieren.  
    for ($i = 0; $i < mysql_num_rows ($query_result); $i ++) {
      $result[$i] = mysql_fetch_array ($query_result);  
    }
    if ($dbconnected == 2) disconnectDB ();   
    return $result; 
  }
  
  
  /** Stellt eine Verbindung zur MySQL-Datenbank her. */
  //   mysql -u d016c17d -p -h edetronics.de   // "knockknock"
  //   show databases; use <db>; show tables;    
  function connectDB () {
    mysql_connect ("localhost", "root", "");
    mysql_select_db ("flood_protection");
    mysql_query ('SET character_set_results = utf8');
    //mysql_query ('SET names = utf8');  
    //mysql_query ('SET character_set_client = utf8');
    //mysql_query ('SET character_set_connection = utf8');
    global $dbconnected;
    $dbconnected = 1;   
  }
  
  
  /** Schließt die Datenbankverbindung. */
  function disconnectDB () {
    mysql_close ();
    global $dbconnected;
    $dbconnected = 0;      
  }
  
?> 


 
 