package data.analysis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DBAdapter.DBAdapterImpl;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.ApproxDictionaryChunker;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.TrieDictionary;
import com.aliasi.spell.FixedWeightEditDistance;
import com.aliasi.spell.WeightedEditDistance;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.LowerCaseTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;


/**
 * 
 * @author Abdul-Wahed
 *
 */
public class LocationFromText {

	private static TrieDictionary<String> citiesTrie = null;
	private static TokenizerFactory tokenizerFactory = new GermanStopWordsTokenizerFactory(new LowerCaseTokenizerFactory(IndoEuropeanTokenizerFactory.INSTANCE));
	private double maxDistance = 2.0;
	private WeightedEditDistance editDistance = new FixedWeightEditDistance(0,-1,-1,-1,Double.NaN);
	private ApproxDictionaryChunker chunker = null;
	
	public LocationFromText(){
		if(citiesTrie == null){//Create TrieDictionary for lingpipe
			citiesTrie = new TrieDictionary<String>();
			
			Iterator<String> cities = DBAdapterImpl.alleStaedte.iterator();
			
			while(cities.hasNext()){
				String cityName = cities.next();
				
				citiesTrie.addEntry(new DictionaryEntry<String>(cityName, cityName));//Value and Category set to CityName
			}
		}
		
		chunker = new ApproxDictionaryChunker(citiesTrie, tokenizerFactory, editDistance, maxDistance);
	}
	
	/**
	 * Return geolocation in form GeoLocation{latitude=51.264493, longitude=11.278812} if available or NULL;
	 * @param place
	 * @return
	 */
	private String getGeolocationForPlace(String place){
		
		List<Map<String, Object>> geolocations = DBAdapterImpl.getInstance().getKoordinatenVonOrt(place);
		
		if(geolocations.isEmpty()){
			return null;//No Geolocation
		}
		
		Iterator<Map<String, Object>> it = geolocations.iterator();
		
		while(it.hasNext()){
			
			Map<String, Object> current = it.next();
			
			String lon = current.get("zc_lon").toString();
			String lat = current.get("zc_lat").toString();
			
			if(it.hasNext()){//More than one geolocation for place; need to validated data
				if(lon == null || lon.equalsIgnoreCase("null")){
					continue;//No valid data
				}
				
				if(lat == null || lat.equalsIgnoreCase("null")){
					continue;//No valid data
				}
				
				if(lon.equalsIgnoreCase("0.0") && lat.equalsIgnoreCase("0.0")){
					continue;//No valid data
				}
			}
			
			return "GeoLocation{latitude="+lat+", longitude="+lon+"}";
			
		}
		
		return null;
	}
	
	public SocialMessage getLocation(SocialMessage message){
		
		if(!message.getGeolocation().equalsIgnoreCase("null")){
			return message;//Geolocation already available
		}
		
		if(!message.getPlace().equalsIgnoreCase("null")){//Place, but no Geolocation
			
			String geolocation = getGeolocationForPlace(message.getGeolocation());
			
			if(geolocation == null){
				message.setGeolocation("null");//No Geolocation found for given place, try to find a place from text
			}else{
				message.setGeolocation(geolocation);
				return message;//Geolocation found for given place
			}	
		}
		
	
		Chunking chunking = chunker.chunk(message.getText());
		
//	    CharSequence cs = chunking.charSequence();
	    Set<Chunk> chunkSet = chunking.chunkSet();
	    
	    double shortestDistance = maxDistance+1;
	    String bestMatch = "null";
//	    String matchedPlace = "null";
	    
	    //System.out.println("Tweet: "+message.getText());//TODO REMOVE
	    
	    for (Chunk chunk : chunkSet) {
	    	/*int start = chunk.start();
	        int end = chunk.end();
	        CharSequence str = cs.subSequence(start,end);
	        double distance = chunk.score();
	        String match = chunk.type();
	        
	        if(distance < shortestDistance){
	        	shortestDistance = distance;
	        	bestMatch = match;
	        	matchedPlace = str.toString();
	        }*///since we are not doing any analysis, we can do this instead
	    	
	    	
	    	if(chunk.score() < shortestDistance){
	        	shortestDistance = chunk.score();
	        	bestMatch = chunk.type();
//	        	System.out.println("New best match: "+bestMatch);
	        }
	    	
	        
	       //System.out.printf("%15s  %15s   %8.1f\n", cs.subSequence(chunk.start(),chunk.end()), chunk.type(), chunk.score());//TODO REMOVE
	    }
	    
	    message.setGeolocation(getGeolocationForPlace(bestMatch));
	    
		return message;
	}
	
	/**
	 * Returns the original Array of SocialMessages enriched with geolocation data.
	 */
	public SocialMessage[] getLocations(SocialMessage[] messages){
		
		
		for(int i=0; i<messages.length; i++){
			
			messages[i] = getLocation(messages[i]);
			
		}

					
		return messages;
	}
	
}
