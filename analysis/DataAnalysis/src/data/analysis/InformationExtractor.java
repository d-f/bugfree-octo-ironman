package data.analysis;

import java.sql.Timestamp;
import java.util.Map;

public class InformationExtractor {

	private IDataSource twitterData;
	private ICategorizer twitterCategorizer;
	private SocialMessage[] twitterTrainMessages;
	private SocialMessage[] twitterMessages;
	private Map<Integer, String> categories;

	private static final int TRAIN_MESSAGE_COUNT = 30;
	private static final String TABLE_TWITTER_CATEGORIES = "categories";
	private static final String TABLE_TWITTER_TRAINING = "categories_training_tweets";
	private static final String TABLE_TWITTER_STURM = "tweets_sturm";

	public static void main(String[] args) {
		new InformationExtractor();
	}

	public InformationExtractor() {
		twitterData = new TwitterDataAnalyser();
		twitterCategorizer = new Categorizer();

		System.out.print("determine categories...");
		categories = twitterData.getCategories(TABLE_TWITTER_CATEGORIES);
		System.out.println(" done.");

		System.out.print("load training data...");
		twitterTrainMessages = new SocialMessage[categories.size() * TRAIN_MESSAGE_COUNT];
		twitterTrainMessages = twitterData.getTrainMessages(TABLE_TWITTER_TRAINING, categories, TRAIN_MESSAGE_COUNT);
		System.out.println(" done.");

		System.out.print("train classifier...");
		twitterCategorizer.train(categories, twitterTrainMessages);
		System.out.println(" done.");

		System.out.print("fetching test data... ");
		twitterMessages = twitterData.getSocialMessages(TABLE_TWITTER_STURM, new Timestamp(0L), new Timestamp(
				Long.MAX_VALUE));
		System.out.println(" done. " + twitterMessages.length + " messages found.");

		int[] sm = {42,1337,88,69,7,13,1900,1985,1986,263,611,1701,666,314,1024,2048,512,90,60,925};
		
		for (int i : sm) {
			twitterCategorizer.handle(twitterMessages[i]);
			System.out.println(twitterMessages[i].getCategory() + ";" + twitterMessages[i].getText());
		}
		
//		System.out.println("categorize messages...");
//		for (int i = 0; i < twitterMessages.length; ++i) {
//			if ((i % 100) == 0 || i == twitterMessages.length - 1) {
//				System.out.println(i);
//			}
//			twitterCategorizer.handle(twitterMessages[i]);
//		}
//		System.out.println(" done.");

//		System.out.println("save metadata...");
//		twitterData.storeMetadata(twitterMessages);
//		System.out.println(" done.");
//
	}

}