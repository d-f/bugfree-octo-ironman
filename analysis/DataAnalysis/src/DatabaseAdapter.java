import java.io.FileWriter;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseAdapter {

	private Connection connect;
	private Statement statement;
	// private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String host;
	private String port;
	private String database;
	private String user;
	private String password;
	private Date lastCall;

	public DatabaseAdapter(String host, String port, String database, String user, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.user = user;
		this.password = password;
		lastCall = new Date(0);
	}

	/**
	 * returns Tweets between last call and now
	 */
	public void getTweets() {
		try {
			open();

			
			lastCall.setTime(System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void storeTweetInformations() {

	}

	public void readDataBase() throws Exception {
		FileWriter writer;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager
					.getConnection("jdbc:mysql://85.25.155.25:3306/MI_WS1314?"
							+ "user=MIWS1314&password=Oq1gk28@");

			// Statements allow to issue SQL queries to the database
			statement = (Statement) connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from MI_WS1314.tweets_sturm");
//			resultSet.next();
			while (resultSet.next()) {

				// File file = new
				// File("C:/Users/steph_000/Desktop/training/Sturm/"
				// + resultSet.getBigDecimal(1) + ".txt");
				// writer = new FileWriter(file, true);
				// writer.write(resultSet.getString(2));
				// writer.flush();
				// writer.close();

//				 System.out.println("[ID] " + resultSet.getBigDecimal(1));
//				 System.out.println("[iteration]" + resultSet.getInt(2));
//				 System.out.println("[text]" + resultSet.getString(3));
//				 System.out.println("[hashtags]" + resultSet.getString(4));
//				 System.out.println("[author]" + resultSet.getString(5));
//				 System.out.println("[retweets]" + resultSet.getInt(6));
				 System.out.println("[timestamp]" + resultSet.getTimestamp(7).getTime());
//				 System.out.println("[follower]" + resultSet.getInt(8));
//				 System.out.println("[geolocation]" + resultSet.getString(9));
//				 System.out.println("[place]" + resultSet.getString(10));
//				 System.out.println("[commentRef]" +
//				 resultSet.getBigDecimal(11));
				 System.out.println("###########################################################");
				// i++;
			}

			// System.out.println("Anzahl: " + i);

			// writeResultSet(resultSet);

			// PreparedStatements can use variables and are more efficient
			// preparedStatement = (PreparedStatement) connect
			// .prepareStatement("insert into  TEST.INFORMATION values (?, ?, ?)");
			// "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
			// Parameters start with 1
			// preparedStatement.setInt(1, 0);
			// preparedStatement.setString(2, "TestEmail");
			// preparedStatement.setInt(3, 123);
			// preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
			// preparedStatement.setString(5, "TestSummary");
			// preparedStatement.setString(6, "TestComment");
			// preparedStatement.executeUpdate();

			// preparedStatement = (PreparedStatement) connect
			// .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from TEST.COMMENTS");
			// resultSet = preparedStatement.executeQuery();
			// writeResultSet(resultSet);

			// Remove again the insert comment
			// preparedStatement = (PreparedStatement) connect
			// .prepareStatement("delete from TEST.INFORMATION where id= ? ; ");
			// preparedStatement.setInt(1, 0);
			// preparedStatement.executeUpdate();
			//
			// resultSet =
			// statement.executeQuery("select * from TEST.COMMENTS");
			// writeMetaData(resultSet);

		} catch (Exception e) {
			throw e;
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
