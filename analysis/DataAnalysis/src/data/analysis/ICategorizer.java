package data.analysis;

public interface ICategorizer {

	/**
	 * 
	 * @param categories
	 * @param socialMessages
	 */
	public void train(String[] categories, SocialMessage[][] socialMessages);
	
	/**
	 * 
	 * @param socialMessage
	 * @return
	 */
	public SocialMessage handle(SocialMessage socialMessage);
	
}
