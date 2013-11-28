package data.analysis;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SocialMessage {

	private BigDecimal id;
	private String text;
	private Timestamp timestamp;
	private String geolocation;
	private int category;
	private String confidence;
	private String place;

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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}

	public String getGeolocation() {
		return geolocation;
	}

	@Override
	public String toString() {
		return new String("[id]" + id + "; [timestamp]" + timestamp
				+ "; [category]" + category + "; [geolocation]" + geolocation
				+ "; [place]" + place + "; [text]" + text);
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

}
