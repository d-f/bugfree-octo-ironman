package data.analysis;

import java.util.Map;

public interface ICategorizer {

	/**
	 * 
	 * @param categories
	 * @param socialMessages
	 */
	public void train(Map<Integer, String> categories, SocialMessage[] socialMessages);
	
	/**
	 * 
	 * @param socialMessage
	 * @return
	 */
	public void handle(SocialMessage socialMessage);
	
}
