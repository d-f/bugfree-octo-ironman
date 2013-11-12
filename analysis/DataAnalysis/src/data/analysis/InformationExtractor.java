package data.analysis;

public class InformationExtractor {

	private IDataSource twitterData;
	private ICategorizer twitterCategorizer;
	private SocialMessage[][] twitterTrainMessages;
	private String[] categories;

	private static final int TRAIN_MESSAGE_COUNT = 10;
	private static final String TABLE_TWITTER_CATEGORIES = "categories";
	private static final String TABLE_TWITTER_TRAINING = "categories_training_tweets";

	public static void main(String[] args) {
		new InformationExtractor();
	}

	public InformationExtractor() {
		twitterData = new TwitterDataAnalyser();
		twitterCategorizer = new Categorizer();

		System.out.println("determine categories...");
		categories = twitterData.getCategories(TABLE_TWITTER_CATEGORIES);

		System.out.println("load training data...");
		twitterTrainMessages = new SocialMessage[categories.length][TRAIN_MESSAGE_COUNT];
		twitterTrainMessages = twitterData.getTrainMessages(TABLE_TWITTER_TRAINING, categories,
				TRAIN_MESSAGE_COUNT);

		System.out.println("train classifier...");
		twitterCategorizer.train(categories, twitterTrainMessages);

		System.out.println("...initialisation finished.");
		
		System.out.println("save metadata...");
		// TODO method not yet ready 
		//twitterData.storeMetadata();
		
	}

}