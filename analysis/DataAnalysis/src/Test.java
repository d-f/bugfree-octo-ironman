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
    public static void main(String ... args){
        String userName = args[0];
        String password = args[1];
        String url = args[2];

                
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
