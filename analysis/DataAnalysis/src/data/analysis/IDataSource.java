package data.analysis;

import java.sql.Timestamp;
import java.util.Map;

public interface IDataSource {

	/**
	 *  
	 * obtains data from a given SQL-table in a defined interval.<br />
	 * if begin and end is 0, then all messages will be delivered
	 * 
	 * @param table SQL-table where the data comes from 
	 * @param begin timestamp 
	 * @param end timestamp
	 * @return Array of social media messages <i><b>SocialMessage[]</b></i>
	 */
	public SocialMessage[] getSocialMessages(String table, Timestamp begin, Timestamp end);
	
	/**
	 * 
	 * @param table
	 * @param categories
	 * @param limit
	 * @return 2D-Array of training messages sorted by category <i>[category][messages]</i>
	 */
	public SocialMessage[] getTrainMessages(String table, Map<Integer, String> categories, int limit);

	/**
	 *
	 * @param table SQL-table where the data comes from
	 * @return Array with names of categories
	 */
	public Map<Integer, String> getCategories(String table);
	
	/**
	 * 
	 * @param socialMessages the message
	 * @param deleteFirst set true if you want to delete the element before you insert the new one
	 */
	public void storeMetadata(SocialMessage[] socialMessages);
	
}
