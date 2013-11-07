
public class TwitterDataAnalyser {

	public static void main(String[] args) {
		
		try {
			new DatabaseAdapter("85.25.155.25","3306","MI_WS1314","MIWS1314","Oq1gk28@").readDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
