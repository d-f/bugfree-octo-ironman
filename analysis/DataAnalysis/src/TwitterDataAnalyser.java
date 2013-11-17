import java.sql.Timestamp;

public class TwitterDataAnalyser {

	public static void main(String[] args) {

		try {
			DatabaseAdapter da = new DatabaseAdapter("85.25.155.25", "3306", "MI_WS1314", "MIWS1314", "Oq1gk28@");

			SocialMessage[] messages = da.getSocialMessage("tweets_sturm", new Timestamp(0), new Timestamp(System.currentTimeMillis()));
			System.out.println("Message count: " + messages.length);
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
