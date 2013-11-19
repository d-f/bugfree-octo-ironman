package data.analysis;

public class LocationFromText {

	/**
	 * Returns the original Array of SocialMessages enriched with geo location data.
	 */
	public SocialMessage[] getLocations(SocialMessage[] messages){
		
		for(int i=0; i<messages.length; i++){
			
			if(!messages[i].getGeolocation().equalsIgnoreCase("")){//GeoLocation bereits vorhanden
				continue;
			}
			
			//Location aus Text extrahieren
			
			
			
		}
		
		return messages;
	}
	
}
