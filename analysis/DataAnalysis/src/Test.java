import org.jooq.Record;
import org.jooq.Result;

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
        Result<Record> recordResult = dbAdapter.getCategories();
        dbAdapter.getCoordinates("Hamburg");
    }
}
