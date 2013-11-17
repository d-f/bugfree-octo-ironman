import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import DBAdapter.Tables;

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

	private DBAdapterImpl(String name, String pass, String url) {
		this.userName = name;
		this.password = pass;
		this.url = url;
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
	public Result<Record> getSocialMessage(String table, Timestamp t1, Timestamp t2) {
		Result<Record> result = create.select().from(Tables.CATEGORIES).fetch();
		for (Record r : result) {
			Integer id = r.getValue(Tables.CATEGORIES.ID);
			String name = r.getValue(Tables.CATEGORIES.NAME);

			System.out.println("ID: " + id + " name: " + name);
		}
		return result; // To change body of implemented methods use File |
						// Settings | File Templates.
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

	public Result<Record> getCategories() {
		open();
		Result<Record> result = null;
		if (conn != null) {
			result = create.select().from(Tables.CATEGORIES).fetch();
			for (Record r : result) {
				Integer id = r.getValue(Tables.CATEGORIES.ID);
				String name = r.getValue(Tables.CATEGORIES.NAME);
				System.out.println("ID: " + id + " name: " + name);
			}
		}
		close();
		return result;
	}

	public Result<Record> getCoordinates(String stadt) {
		open();
		Result result = null;
		Object lat = 0;
		Object lon = 0;
		result = create.select(Tables.GEODB_COORDINATES.LAT, Tables.GEODB_COORDINATES.LON)
				.from(Tables.GEODB_COORDINATES).leftOuterJoin(Tables.GEODB_TYPE_NAMES)
				.on(Tables.GEODB_COORDINATES.COORD_TYPE.equal(Tables.GEODB_TYPE_NAMES.TYPE_ID))
				.where(Tables.GEODB_COORDINATES.LOC_ID.like("60000")).fetch();

		lat = result.getValues(Tables.GEODB_COORDINATES.LAT).get(0);
		lon = result.getValues(Tables.GEODB_COORDINATES.LON).get(0);

		System.out.println("lat: " + lat + " : " + "lon: " + lon);
		close();
		return result;
	}
}
