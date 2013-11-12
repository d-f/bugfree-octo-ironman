/**
 * This class is generated by jOOQ
 */
package DBAdapter.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Information extends org.jooq.impl.TableImpl<DBAdapter.tables.records.InformationRecord> {

	private static final long serialVersionUID = -752968269;

	/**
	 * The singleton instance of <code>MI_WS1314.information</code>
	 */
	public static final DBAdapter.tables.Information INFORMATION = new DBAdapter.tables.Information();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<DBAdapter.tables.records.InformationRecord> getRecordType() {
		return DBAdapter.tables.records.InformationRecord.class;
	}

	/**
	 * The column <code>MI_WS1314.information.tweet_id</code>. 
	 */
	public final org.jooq.TableField<DBAdapter.tables.records.InformationRecord, java.lang.Long> TWEET_ID = createField("tweet_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>MI_WS1314.information.geolocation</code>. 
	 */
	public final org.jooq.TableField<DBAdapter.tables.records.InformationRecord, java.lang.String> GEOLOCATION = createField("geolocation", org.jooq.impl.SQLDataType.VARCHAR.length(200), this);

	/**
	 * The column <code>MI_WS1314.information.place</code>. 
	 */
	public final org.jooq.TableField<DBAdapter.tables.records.InformationRecord, java.lang.String> PLACE = createField("place", org.jooq.impl.SQLDataType.VARCHAR.length(200), this);

	/**
	 * Create a <code>MI_WS1314.information</code> table reference
	 */
	public Information() {
		super("information", DBAdapter.MiWs1314.MI_WS1314);
	}

	/**
	 * Create an aliased <code>MI_WS1314.information</code> table reference
	 */
	public Information(java.lang.String alias) {
		super(alias, DBAdapter.MiWs1314.MI_WS1314, DBAdapter.tables.Information.INFORMATION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<DBAdapter.tables.records.InformationRecord> getPrimaryKey() {
		return DBAdapter.Keys.KEY_INFORMATION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<DBAdapter.tables.records.InformationRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<DBAdapter.tables.records.InformationRecord>>asList(DBAdapter.Keys.KEY_INFORMATION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DBAdapter.tables.Information as(java.lang.String alias) {
		return new DBAdapter.tables.Information(alias);
	}
}
