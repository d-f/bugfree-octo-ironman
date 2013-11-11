/** Stellt Anfragen an ein PHP-Skript auf und gibt die Rückantwort zurück.
 * @param $PHPurl Die Adresse des Skripts. */
function ServerConnector ($PHPurl) {

  var url = $PHPurl;      // Die Serveradresse des Skriptes.
  
  /** Ruft die Tweed-Kategorien ab.
   * @return JSON-Array der Kategorien. */
  this.getCategories = function () { 
    return fetchData ("arg=getCategories");  
  }
  
  /** Ruft Einträge einer gewissen Zeitspanne ab.
   * @param minDate Untere Zeitschranke (Mindest-Datum).
   * @param maxDate Obere Zeitschranke (begrenzt neuestes Datum). 
   * @return JSON-Array der Tweeds. */
  this.getData = function (minDate, maxDate) {
    return fetchData ("arg=getData&minDate="+minDate+"&maxDate="+maxDate);
  }  
  
  /** Stellt eine POST-Anfrage an den Server und gibt die Antwort zurück. 
   * @param post Die POST-Argumente der Anfrage.
   * @return JSON-kodierte Datenbankantwort. */
  function fetchData (post) {
    if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest (); 
    else xmlhttp = new ActiveXObject ("Microsoft.XMLHTTP");      
    xmlhttp.open ("POST", url, false);
    xmlhttp.setRequestHeader ("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send (post);
    return xmlhttp.responseText;     
  }
}