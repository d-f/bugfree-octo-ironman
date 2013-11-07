import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseAdapter {

	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private String host;
	private String port;
	private String database;
	private String user;
	private String password;

	public DatabaseAdapter(String host, String port, String database, String user, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.user = user;
		this.password = password;
	}

	/**
	 * Returns Tweets in given time range t1 to t2
	 */
	public SocialMessage[] getTweets(String table, Timestamp t1, Timestamp t2) {
		ArrayList<SocialMessage> messages = new ArrayList<SocialMessage>();

		try {
			open();
			statement = (Statement) connect.createStatement();
			resultSet = statement.executeQuery("select id, text, timestamp from " + database + "."
					+ table + " where timestamp >= '" + t1 + "' and timestamp <= '" + t2 + "'" );

			while (resultSet.next()) {
				SocialMessage sm = new SocialMessage();
				sm.setId(resultSet.getBigDecimal(1));
				sm.setText(resultSet.getString(2));
				sm.setTimestamp(resultSet.getTimestamp(3));
				messages.add(sm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return messages.toArray(new SocialMessage[messages.size()]);
	}

	public void storeTweetInformations() {

	}

	/**
	 * Dumps all messages in given database
	 */
	public void dumpToConsole() {
		try {
			open();
			statement = (Statement) connect.createStatement();
			resultSet = statement.executeQuery("select * from MI_WS1314.tweets_sturm");

			while (resultSet.next()) {
				System.out.println("[ID] " + resultSet.getBigDecimal(1));
				System.out.println("[iteration]" + resultSet.getInt(2));
				System.out.println("[text]" + resultSet.getString(3));
				System.out.println("[hashtags]" + resultSet.getString(4));
				System.out.println("[author]" + resultSet.getString(5));
				System.out.println("[retweets]" + resultSet.getInt(6));
				System.out.println("[timestamp]" + resultSet.getTimestamp(7).getTime());
				System.out.println("[follower]" + resultSet.getInt(8));
				System.out.println("[geolocation]" + resultSet.getString(9));
				System.out.println("[place]" + resultSet.getString(10));
				System.out.println("[commentRef]" + resultSet.getBigDecimal(11));
				System.out.println("###########################################################");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	private void open() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port
					+ "/" + database + "?user=" + user + "&password=" + password);
		} catch (Exception e) {
			throw e;
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
