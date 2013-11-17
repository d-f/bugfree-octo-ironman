package data.analysis;

import java.sql.Timestamp;
import java.util.Map;

public class InformationExtractor {

	private IDataSource twitterData;
	private ICategorizer twitterCategorizer;
	private SocialMessage[] twitterTrainMessages;
	private SocialMessage[] twitterTestMessages;
	private Map<Integer, String> categories;

	private static final int TRAIN_MESSAGE_COUNT = 5;
	private static final String TABLE_TWITTER_CATEGORIES = "categories";
	private static final String TABLE_TWITTER_TRAINING = "categories_training_tweets";
	private static final String TABLE_TWITTER_TEST = "tweets_sturm";

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
		twitterTrainMessages = twitterData.getTrainMessages(TABLE_TWITTER_TRAINING, categories,
				TRAIN_MESSAGE_COUNT);
		System.out.println(" done.");

		System.out.print("train classifier...");
		twitterCategorizer.train(categories, twitterTrainMessages);
		System.out.println(" done.");
		
		System.out.println("Fetch testing data... ");
		twitterTestMessages = twitterData.getSocialMessages(TABLE_TWITTER_TEST, new Timestamp(0L), new Timestamp(Long.MAX_VALUE));
		System.out.println(twitterTestMessages.length + " messages found.");
		
		System.out.println(twitterTestMessages[1000].toString());
		twitterCategorizer.handle(twitterTestMessages[1000]);
		System.out.print(twitterTestMessages[1000].toString());
		System.out.println(" [" + categories.get(twitterTestMessages[1000].getCategory()) + "]");
		
		System.out.print("save metadata...");
		// TODO method not yet ready 
		//twitterData.storeMetadata();
		System.out.println(" done.");
	}

}