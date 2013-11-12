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
public class TweetsSturmRecord extends org.jooq.impl.UpdatableRecordImpl<DBAdapter.tables.records.TweetsSturmRecord> implements org.jooq.Record11<java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.sql.Timestamp, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Long> {

	private static final long serialVersionUID = -835148751;

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.id</code>. 
	 */
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.iteration</code>. 
	 */
	public void setIteration(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.iteration</code>. 
	 */
	public java.lang.Integer getIteration() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.text</code>. 
	 */
	public void setText(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.text</code>. 
	 */
	public java.lang.String getText() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.hashtags</code>. 
	 */
	public void setHashtags(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.hashtags</code>. 
	 */
	public java.lang.String getHashtags() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.author</code>. 
	 */
	public void setAuthor(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.author</code>. 
	 */
	public java.lang.String getAuthor() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.retweets</code>. 
	 */
	public void setRetweets(java.lang.Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.retweets</code>. 
	 */
	public java.lang.Integer getRetweets() {
		return (java.lang.Integer) getValue(5);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.timestamp</code>. 
	 */
	public void setTimestamp(java.sql.Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.timestamp</code>. 
	 */
	public java.sql.Timestamp getTimestamp() {
		return (java.sql.Timestamp) getValue(6);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.follower</code>. 
	 */
	public void setFollower(java.lang.Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.follower</code>. 
	 */
	public java.lang.Integer getFollower() {
		return (java.lang.Integer) getValue(7);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.geolocation</code>. 
	 */
	public void setGeolocation(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.geolocation</code>. 
	 */
	public java.lang.String getGeolocation() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.place</code>. 
	 */
	public void setPlace(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.place</code>. 
	 */
	public java.lang.String getPlace() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>MI_WS1314.tweets_sturm.commentRef</code>. 
	 */
	public void setCommentref(java.lang.Long value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tweets_sturm.commentRef</code>. 
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
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.ITERATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.HASHTAGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.AUTHOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field6() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.RETWEETS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field7() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.TIMESTAMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field8() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.FOLLOWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field9() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.GEOLOCATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field10() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.PLACE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field11() {
		return DBAdapter.tables.TweetsSturm.TWEETS_STURM.COMMENTREF;
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
	 * Create a detached TweetsSturmRecord
	 */
	public TweetsSturmRecord() {
		super(DBAdapter.tables.TweetsSturm.TWEETS_STURM);
	}

	/**
	 * Create a detached, initialised TweetsSturmRecord
	 */
	public TweetsSturmRecord(java.lang.Long id, java.lang.Integer iteration, java.lang.String text, java.lang.String hashtags, java.lang.String author, java.lang.Integer retweets, java.sql.Timestamp timestamp, java.lang.Integer follower, java.lang.String geolocation, java.lang.String place, java.lang.Long commentref) {
		super(DBAdapter.tables.TweetsSturm.TWEETS_STURM);

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
