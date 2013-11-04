/** Stellt Anfragen an ein PHP-Skript auf und gibt die Rückantwort zurück.
 * @param $PHPurl Die Adresse des Skripts. */
function ServerConnector ($PHPurl) {

  var url = $PHPurl;      // Die Serveradresse des Skriptes.

  
  /** Stellt eine Anfrage an den Server und gibt die Antwort zurück. 
   * @param query String mit dem SQL-Befehl. */
  this.sendQuery = function (query) {

    if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest (); // Moderne Browser.
    else xmlhttp = new ActiveXObject ("Microsoft.XMLHTTP");     // Für IE 5 und 6. 
    
    /*   
    // Funktion zur Bearbeitung asynchroner Anfragen.
    xmlhttp.onreadystatechange = function () {
      if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        alert ("Antw. "+xmlhttp.responseText);
        // Hinweis: return funktioniert bei async nicht. (wohin soll es gehen?)
      }    
    }       
    */
     
    xmlhttp.open ("GET", url+"?q="+query, false);  // 3. Parameter: Asynchron oder nicht.
    xmlhttp.send ();
    return xmlhttp.responseText;       
  }
}