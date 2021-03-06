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
public class TagsTweetsRecord extends org.jooq.impl.UpdatableRecordImpl<DBAdapter.tables.records.TagsTweetsRecord> implements org.jooq.Record2<java.lang.Long, java.lang.Integer> {

	private static final long serialVersionUID = -438934727;

	/**
	 * Setter for <code>MI_WS1314.tags_tweets.tweet_id</code>. 
	 */
	public void setTweetId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tags_tweets.tweet_id</code>. 
	 */
	public java.lang.Long getTweetId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.tags_tweets.tag_id</code>. 
	 */
	public void setTagId(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.tags_tweets.tag_id</code>. 
	 */
	public java.lang.Integer getTagId() {
		return (java.lang.Integer) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record2<java.lang.Long, java.lang.Integer> key() {
		return (org.jooq.Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Long, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Long, java.lang.Integer> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return DBAdapter.tables.TagsTweets.TAGS_TWEETS.TWEET_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return DBAdapter.tables.TagsTweets.TAGS_TWEETS.TAG_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getTweetId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getTagId();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TagsTweetsRecord
	 */
	public TagsTweetsRecord() {
		super(DBAdapter.tables.TagsTweets.TAGS_TWEETS);
	}

	/**
	 * Create a detached, initialised TagsTweetsRecord
	 */
	public TagsTweetsRecord(java.lang.Long tweetId, java.lang.Integer tagId) {
		super(DBAdapter.tables.TagsTweets.TAGS_TWEETS);

		setValue(0, tweetId);
		setValue(1, tagId);
	}
}
