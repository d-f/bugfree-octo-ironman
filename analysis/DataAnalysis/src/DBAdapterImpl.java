import DBAdapter.Tables;
import DBAdapter.tables.GeodbTextdata;
import data.analysis.SocialMessage;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static Map<String, Object> alleStaedte = new HashMap<>();

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

        Object lat = result.getValues(Tables.GEODB_COORDINATES.LAT).get(0);
        Object lon = result.getValues(Tables.GEODB_COORDINATES.LON).get(0);

		//System.out.println("lat: " + lat + " : " + "lon: " + lon);
        Map<String, String> map = new HashMap<String, String>();
        map.put("lat", lat.toString());
        map.put("lon", lon.toString());
        close();
		return map;
	}

    //Sollte nicht genutzt werden! Stattdessen auf die Klassenvariable zugreifen!! Diese wird
    //bereits beim Initialisieren der Instanz befuellt
    private void getAlleStaedteNamen(){
        open();
        List<Map<String, Object>> result = create
                .select(GeodbTextdata.GEODB_TEXTDATA.LOC_ID, GeodbTextdata.GEODB_TEXTDATA.TEXT_VAL)
                .from(GeodbTextdata.GEODB_TEXTDATA)
                .where(GeodbTextdata.GEODB_TEXTDATA.TEXT_TYPE.eq(500100000))
                .fetchMaps();

        for (Map<String, Object> m : result){
            String key = m.get("loc_id").toString();
            String value = m.get("text_val").toString();
            //System.out.println(key + "--" + value);
            alleStaedte.put(key, value);
        }
        close();
    }

    public SocialMessage[] getSocialMessages(String table, Timestamp begin, Timestamp end) {
        List<SocialMessage> messages = new ArrayList<SocialMessage>();
        open();
        try {
            if (begin.getTime() == 0L && end.getTime() == 0L) {
                end = new Timestamp(Long.MAX_VALUE);
            }

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, text, timestamp, geolocation FROM "  + table
                    + " WHERE timestamp >= '" + begin + "' AND timestamp <= '" + end + "'");

            while (resultSet.next()) {
                SocialMessage sm = new SocialMessage();
                sm.setId(resultSet.getBigDecimal(1));
                sm.setText(resultSet.getString(2));
                sm.setTimestamp(resultSet.getTimestamp(3));
                sm.setGeolocation(resultSet.getString(4));
                messages.add(sm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return messages.toArray(new SocialMessage[messages.size()]);
    }
}
