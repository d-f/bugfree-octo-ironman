/**
 * This class is generated by jOOQ
 */
package DBAdapter.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TweetsSyriaRecord extends org.jooq.impl.UpdatableRecordImpl<DBAdapter.tables.records.TweetsSyriaRecord> implements org.jooq.Record11<java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Long> {

	private static final long serialVersionUID = 1790137661;

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.id</code>. 
	 */
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.iteration</code>. 
	 */
	public void setIteration(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.iteration</code>. 
	 */
	public java.lang.Integer getIteration() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.text</code>. 
	 */
	public void setText(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.text</code>. 
	 */
	public java.lang.String getText() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.hashtags</code>. 
	 */
	public void setHashtags(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.hashtags</code>. 
	 */
	public java.lang.String getHashtags() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.author</code>. 
	 */
	public void setAuthor(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.author</code>. 
	 */
	public java.lang.String getAuthor() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.retweets</code>. 
	 */
	public void setRetweets(java.lang.Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.retweets</code>. 
	 */
	public java.lang.Integer getRetweets() {
		return (java.lang.Integer) getValue(5);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.timestamp</code>. 
	 */
	public void setTimestamp(java.sql.Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.timestamp</code>. 
	 */
	public java.sql.Timestamp getTimestamp() {
		return (java.sql.Timestamp) getValue(6);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.follower</code>. 
	 */
	public void setFollower(java.lang.Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.follower</code>. 
	 */
	public java.lang.Integer getFollower() {
		return (java.lang.Integer) getValue(7);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.geolocation</code>. 
	 */
	public void setGeolocation(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.geolocation</code>. 
	 */
	public java.lang.String getGeolocation() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.place</code>. 
	 */
	public void setPlace(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.place</code>. 
	 */
	public java.lang.String getPlace() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_syria.commentRef</code>. 
	 */
	public void setCommentref(java.lang.Long value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_syria.commentRef</code>. 
	 */
	public java.lang.Long getCommentref() {
		return (java.lang.Long) getValue(10);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Long> fieldsRow() {
		return (org.jooq.Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Long> valuesRow() {
		return (org.jooq.Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.ITERATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.HASHTAGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.AUTHOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field6() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.RETWEETS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field7() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.TIMESTAMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field8() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.FOLLOWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field9() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.GEOLOCATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field10() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.PLACE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field11() {
		return DBAdapter.tables.TweetsSyria.TWEETS_SYRIA.COMMENTREF;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getIteration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getHashtags();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getAuthor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value6() {
		return getRetweets();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value7() {
		return getTimestamp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value8() {
		return getFollower();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value9() {
		return getGeolocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value10() {
		return getPlace();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value11() {
		return getCommentref();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TweetsSyriaRecord
	 */
	public TweetsSyriaRecord() {
		super(DBAdapter.tables.TweetsSyria.TWEETS_SYRIA);
	}

	/**
	 * Create a detached, initialised TweetsSyriaRecord
	 */
	public TweetsSyriaRecord(java.lang.Long id, java.lang.Integer iteration, java.lang.String text, java.lang.String hashtags, java.lang.String author, java.lang.Integer retweets, java.sql.Timestamp timestamp, java.lang.Integer follower, java.lang.String geolocation, java.lang.String place, java.lang.Long commentref) {
		super(DBAdapter.tables.TweetsSyria.TWEETS_SYRIA);

		setValue(0, id);
		setValue(1, iteration);
		setValue(2, text);
		setValue(3, hashtags);
		setValue(4, author);
		setValue(5, retweets);
		setValue(6, timestamp);
		setValue(7, follower);
		setValue(8, geolocation);
		setValue(9, place);
		setValue(10, commentref);
	}
}