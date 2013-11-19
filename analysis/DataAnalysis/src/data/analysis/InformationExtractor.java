package data.analysis;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Scanner;

import org.jooq.util.derby.sys.Sys;

public class InformationExtractor {

	private IDataSource twitterData;
	private ICategorizer twitterCategorizer;
	private SocialMessage[] twitterTrainMessages;
	private SocialMessage[] twitterMessages;
	private Map<Integer, String> categories;

	private static final int TRAIN_MESSAGE_COUNT = 20;
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

		System.out.println("categorize messages...");
		for (int i = 0; i < twitterMessages.length; ++i) {
			if ((i % 99) == 0 || i == twitterMessages.length - 1) {
				System.out.println(i + 1);
			}
			twitterCategorizer.handle(twitterMessages[i]);
		}
		System.out.println(" done.");

		System.out.println("save metadata...");
		twitterData.storeMetadata(twitterMessages);
		System.out.println(" done.");
	}

}