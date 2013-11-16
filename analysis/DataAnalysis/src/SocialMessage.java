import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SocialMessage {

	private BigDecimal id;
	private String text;
	private Timestamp timestamp;
	protected List<String> categories;

	public SocialMessage() {
		categories = new ArrayList<String>();
	}
	
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal bigDecimal) {
		this.id = bigDecimal;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String[] getCategories() {
		return categories.toArray(new String[categories.size()]);
	}

	public void addCategory(String category) {
		categories.add(category);
	}

	public void deleteCategory(String category) {
		categories.remove(category);
	}

}
