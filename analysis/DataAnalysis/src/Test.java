import java.sql.Timestamp;

import data.analysis.LocationFromText;
import DBAdapter.DBAdapterImpl;

/**
 * Created with IntelliJ IDEA.
 * User: denisf
 * Date: 12.11.13
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */



public class Test {
	
	protected final static String HOST = "85.25.155.25";
	protected final static String PORT = "3306";
	protected final static String DATABASE = "MI_WS1314";
	protected final static String USER = "MIWS1314";
	protected final static String PASSWORD = "Oq1gk28@";
	
    public static void main(String ... args){
        String userName = USER;
        String password = PASSWORD;
        String url = "jdbc:mysql://" +HOST; // args[2];

                
        DBAdapterImpl dbAdapter = DBAdapterImpl.getInstance(userName,password,url);
        //dbAdapter.getKoordinatenVonOrt("Wittenberg");
        //System.out.println(DBAdapterImpl.alleStaedte);
        //dbAdapter.getLocIdZumOrt("Hamburg");
        //dbAdapter.getInfoZurLocId(17838);
        //System.out.println(Arrays.deepToString(dbAdapter.getSocialMessages("tweets_sturm", new Timestamp(0L), new Timestamp(Long.MAX_VALUE))));

        //dbAdapter.getSocialMessages("tweets_sturm", new Timestamp(0L), new Timestamp(Long.MAX_VALUE));
        //dbAdapter.getSocialMessages("tweets_sturm", new Timestamp(0L), new Timestamp(Long.MAX_VALUE));
        
        LocationFromText lft = new LocationFromText();
        
        lft.getLocations(dbAdapter.getSocialMessagesArray("tweets_sturm", new Timestamp(0L), new Timestamp(0L)));
        
    }
}
