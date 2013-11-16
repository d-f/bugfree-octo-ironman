package data.analysis;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class TwitterDataAnalyser implements IDataSource {
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	private final static String HOST = "85.25.155.25";
	private final static String PORT = "3306";
	private final static String DATABASE = "MI_WS1314";
	private final static String USER = "MIWS1314";
	private final static String PASSWORD = "Oq1gk28@";

	@Override
	public SocialMessage[] getSocialMessages(String table, Timestamp begin, Timestamp end) {
		ArrayList<SocialMessage> messages = new ArrayList<SocialMessage>();

		try {
			open();
			statement = (Statement) connect.createStatement();

			if (begin.getTime() == 0L && end.getTime() == 0L) {
				end = new Timestamp(Long.MAX_VALUE);
			}

			resultSet = statement.executeQuery("SELECT id, text, timestamp, geolocation FROM "
					+ DATABASE + "." + table + " WHERE timestamp >= '" + begin
					+ "' AND timestamp <= '" + end + "'");

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
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return messages.toArray(new SocialMessage[messages.size()]);
	}

	@Override
	public SocialMessage[][] getTrainMessages(String table, String[] categories, int limit) {
		SocialMessage[][] messages = new SocialMessage[categories.length][limit];

		try {
			open();
			statement = (Statement) connect.createStatement();

			for (int i = 0; i < categories.length; i++) {
				resultSet = statement.executeQuery("SELECT text, category FROM " + DATABASE + "."
						+ table + " WHERE category=" + i + " LIMIT " + limit);

				int k = 0;
				while (resultSet.next()) {
					messages[i][k] = new SocialMessage();
					messages[i][k].setText(resultSet.getString(1));
					if (resultSet.getInt(2) < categories.length) {
						messages[i][k].setCategory(resultSet.getInt(2));
					}
					k++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return messages;
	}

	@Override
	public String[] getCategories(String table) {
		ArrayList<String> categories = new ArrayList<String>();

		try {
			open();
			statement = (Statement) connect.createStatement();
			resultSet = statement.executeQuery("SELECT name, id FROM " + DATABASE + "." + table
					+ " ORDER BY id ASC");

			while (resultSet.next()) {
				String category = resultSet.getString(1);
				categories.add(category);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return categories.toArray(new String[categories.size()]);
	}

	@Override
	public void storeMetadata(SocialMessage[] socialMessage) {
		// TODO not only categories
		try {
			open();
			preparedStatement = (PreparedStatement) connect.prepareStatement("INSERT INTO "
					+ DATABASE + ".categories_tweets VALUES (?,?)");

			for (int i = 0; i < socialMessage.length; i++) {
				preparedStatement.setBigDecimal(1, socialMessage[i].getId());
				preparedStatement.setInt(2, socialMessage[i].getCategory());
				preparedStatement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void open() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT
				+ "/" + DATABASE + "?user=" + USER + "&password=" + PASSWORD);
	}

	private void close() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (connect != null) {
			connect.close();
		}
	}
}