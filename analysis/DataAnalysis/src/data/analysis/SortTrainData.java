package data.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SortTrainData {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] cat = new String[6];
		cat[0] = "C:/Users/steph_000/Desktop/Lucas/Hilferuf/";
		cat[1] = "C:/Users/steph_000/Desktop/Lucas/Support_anfrage/";
		cat[2] = "C:/Users/steph_000/Desktop/Lucas/Support_angebot/";
		cat[3] = "C:/Users/steph_000/Desktop/Lucas/Information_anfrage/";
		cat[4] = "C:/Users/steph_000/Desktop/Lucas/information_angebot/";
		cat[5] = "C:/Users/steph_000/Desktop/Lucas/trashtalk/";
		
		for (int i = 0; i < cat.length; i++) {
			File file = new File(cat[i]);
			File[] files = file.listFiles();
			
			for (File f : files) {
				try {
					BufferedReader in = new BufferedReader(new FileReader(f.getAbsoluteFile()));
					String zeile = null;
					String satz = "";
					while ((zeile = in.readLine()) != null) {
						satz += zeile;
					}
					in.close();
					System.out.println("insert into MI_WS1314.categories_training_tweets values ('" + satz + "'," + i + ");");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		

	}

}
