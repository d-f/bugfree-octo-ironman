import DBAdapter.Tables;
import data.analysis.SocialMessage;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import static org.jooq.impl.DSL.fieldByName;
import static org.jooq.impl.DSL.tableByName;

/**
 * Created with IntelliJ IDEA. User: denisf Date: 12.11.13 Time: 22:22 To change
 * this template use File | Settings | File Templates.
 */

public class DBAdapterImpl {
    private static DBAdapterImpl instance = null;
    private String userName;
    private String password;
    private String url;
    private Connection conn = null;
    private DSLContext create;
    public static Set<String> alleStaedte = new HashSet<>();

    private DBAdapterImpl(String name, String pass, String url) {
        this.userName = name;
        this.password = pass;
        this.url = url;
        if (alleStaedte.isEmpty()) {
            getAlleStaedteNamen();
        }
    }

    public static DBAdapterImpl getInstance(String name, String pass, String url) {
        if (instance == null) {
            instance = new DBAdapterImpl(name, pass, url);
        }
        return instance;
    }

    public static DBAdapterImpl getInstance() {
        if (instance == null) {
            throw new RuntimeException("Instanz ist noch nicht initialisiert");
        }
        return instance;
    }

    // @Override
    private void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("CLOSED!!");
            } catch (SQLException ignore) {
            }
        }
    }

    // @Override
    private void open() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            create = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("OPEN!!");
        } catch (Exception e) {
            // For the sake of this tutorial, let's keep exception handling
            // simple
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
            }
            e.printStackTrace();
        }
    }

    // @Override
    public void storeTweetInformations() {
        // To change body of implemented methods use File | Settings | File
        // Templates.
    }

    // @Override
    public void dumpToConsole(String table) {
        // To change body of implemented methods use File | Settings | File
        // Templates.
    }

    public Result<Record> getKategorien() {
        open();
        Result<Record> result = null;
        if (conn != null) {
            result = create.select().from(Tables.CATEGORIES).fetch();
            for (Record r : result) {
                Integer id = r.getValue(Tables.CATEGORIES.ID);
                String name = r.getValue(Tables.CATEGORIES.NAME);
            }
        }
        close();
        return result;
    }

    public Map<String, String> getKoordinatenVonLocId(String locId) {
        open();
        Result result = create
                .select(Tables.GEODB_COORDINATES.LAT, Tables.GEODB_COORDINATES.LON)
                .from(Tables.GEODB_COORDINATES)
                .leftOuterJoin(Tables.GEODB_TYPE_NAMES)
                .on(Tables.GEODB_COORDINATES.COORD_TYPE.equal(Tables.GEODB_TYPE_NAMES.TYPE_ID))
                .where(Tables.GEODB_COORDINATES.LOC_ID.like(locId))
                .fetch();

        //System.out.println("lat: " + lat + " : " + "lon: " + lon);
        Map<String, String> map = new HashMap<String, String>();
        map.put("lat", result.getValues(Tables.GEODB_COORDINATES.LAT).get(0).toString());
        map.put("lon", result.getValues(Tables.GEODB_COORDINATES.LON).get(0).toString());
        close();
        return map;
    }

    public List<Map<String, Object>> getKoordinatenVonOrt(String ort){
        open();
        List<Map<String, Object>> result = create
                .select(fieldByName("zip_coordinates","zc_location_name"),fieldByName("zip_coordinates","zc_lon"),fieldByName("zip_coordinates","zc_lat"))
                .from(tableByName("zip_coordinates"))
                .where(fieldByName("zip_coordinates","zc_location_name").eq(ort))
                .groupBy(fieldByName("zip_coordinates","zc_location_name"))
                .fetchMaps();
        System.out.println(result);
        close();
        return result;
    }


    //Sollte nicht genutzt werden! Stattdessen auf die Klassenvariable zugreifen!! Diese wird
    //bereits beim Initialisieren der Instanz befuellt
    private void getAlleStaedteNamen() {
        open();
        /*Result<Record2<Object, Object>> result = create
                .select(fieldByName("geodb_textdata","loc_id"),fieldByName("geodb_textdata","text_val"))
                .from(tableByName("geodb_textdata"))
                .where(fieldByName("geodb_textdata","text_val")
                        .eq(100700000))
                .fetch();*/

        /*List<Map<String, Object>> result = create
                .select(fieldByName("geodb_hierarchies","loc_id"),fieldByName("geodb_textdata","text_val"))
                .from(tableByName("geodb_textdata"),tableByName("geodb_hierarchies"))
                .where(fieldByName("geodb_hierarchies", "loc_id")
                                .eq(fieldByName("geodb_textdata", "loc_id"))
                        .and(fieldByName("geodb_hierarchies", "id_lvl2")
                                .eq(105))
                        .and(fieldByName("geodb_hierarchies", "id_lvl5")
                                .isNotNull())
                        .and(fieldByName("geodb_hierarchies", "id_lvl6")
                                .isNotNull())
                        .and(fieldByName("geodb_textdata", "text_type")
                                .eq(500100000)))
                .fetchMaps();*/
        List<Map<String, Object>> result = create
                .select(fieldByName("zip_coordinates","zc_location_name"))
                .from(tableByName("zip_coordinates"))
                .groupBy(fieldByName("zc_location_name"))
                .fetchMaps();

        for (Map<String,Object> map : result ){
           alleStaedte.add((String)map.get("zc_location_name"));
        }
        //System.out.println(alleStaedte);
        //System.out.println(alleStaedte.size());

        close();
    }

    public Result<Record> getSocialMessages(Table table, Timestamp begin, Timestamp end) {
        open();
        if (begin.getTime() == 0L && end.getTime() == 0L) {
            end = new Timestamp(Long.MAX_VALUE);
        }
        List<SocialMessage> messages = new ArrayList<SocialMessage>();

        Result<Record> result = null;
        result = create
                .select()
                .from(table)
                .where(Tables.TWEETS_STURM.TIMESTAMP.greaterOrEqual(begin).and(Tables.TWEETS_STURM.TIMESTAMP.lessOrEqual(end)))
                .fetch();
        System.out.println("between " + begin + " and " + end);
        System.out.println(result);

        close();
        return result;//messages.toArray(new SocialMessage[messages.size()]);
    }

    public List<Map<String, Object>> getSocialMessages(String table, Timestamp begin, Timestamp end) {
        open();
        if (begin.getTime() == 0L && end.getTime() == 0L) {
            end = new Timestamp(Long.MAX_VALUE);
        }
        System.out.println(begin);
        List<Map<String, Object>> result = null;
        result = create
                .select()
                .from(tableByName(table))
                .where(fieldByName(table,"timestamp")
                        .greaterOrEqual(begin.toString())
                        .and(fieldByName(table,"timestamp")
                                .lessOrEqual(end.toString())))
                .fetchMaps();
        System.out.println(result);
        close();
        return result;
    }

    public List<Map<String, Object>> getInfoZurLocId(int loc_id) {
        open();
        List<Map<String, Object>> result = create
                .select(fieldByName("geodb_type_names","name"), fieldByName("geodb_textdata","text_val"))
                .from(tableByName("geodb_textdata"))
                .leftOuterJoin(tableByName("geodb_type_names"))
                .on(fieldByName("geodb_textdata", "text_type")
                        .equal(fieldByName("geodb_type_names", "type_id")))
                .where(fieldByName("loc_id")
                        .equal(loc_id))
                .fetchMaps();
        close();
        System.out.println(result);
        return result;
    }

    public List<Map<String, Object>> getLocIdZumOrt(String ort) {
        open();
        List<Map<String, Object>> result =  create
                    .select(fieldByName("geodb_type_names","name"), fieldByName("geodb_textdata","loc_id"))
                    .from(tableByName("geodb_textdata"))
                    .leftOuterJoin(tableByName("geodb_locations"))
                    .on(fieldByName("geodb_locations", "loc_id").eq(fieldByName("geodb_textdata", "loc_id")))
                    .leftOuterJoin(tableByName("geodb_type_names"))
                    .on(fieldByName("geodb_locations", "loc_type").eq(fieldByName("geodb_type_names", "type_id")))
                    .where(fieldByName("text_val")
                            .equal(ort))
                    .and(fieldByName("text_type").equal(500100000))
                    .fetchMaps();
        close();
        System.out.println(result);
        return result;
    }
}
