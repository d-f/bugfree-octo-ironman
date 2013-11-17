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
public class Categories extends org.jooq.impl.TableImpl<DBAdapter.tables.records.CategoriesRecord> {

	private static final long serialVersionUID = -1681579703;

	/**
	 * The singleton instance of <code>MI_WS1314.categories</code>
	 */
	public static final DBAdapter.tables.Categories CATEGORIES = new DBAdapter.tables.Categories();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<DBAdapter.tables.records.CategoriesRecord> getRecordType() {
		return DBAdapter.tables.records.CategoriesRecord.class;
	}

	/**
	 * The column <code>MI_WS1314.categories.id</code>. 
	 */
	public final org.jooq.TableField<DBAdapter.tables.records.CategoriesRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this);

	/**
	 * The column <code>MI_WS1314.categories.name</code>. 
	 */
	public final org.jooq.TableField<DBAdapter.tables.records.CategoriesRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(200), this);

	/**
	 * Create a <code>MI_WS1314.categories</code> table reference
	 */
	public Categories() {
		super("categories", DBAdapter.MiWs1314.MI_WS1314);
	}

	/**
	 * Create an aliased <code>MI_WS1314.categories</code> table reference
	 */
	public Categories(java.lang.String alias) {
		super(alias, DBAdapter.MiWs1314.MI_WS1314, DBAdapter.tables.Categories.CATEGORIES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<DBAdapter.tables.records.CategoriesRecord, java.lang.Integer> getIdentity() {
		return DBAdapter.Keys.IDENTITY_CATEGORIES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<DBAdapter.tables.records.CategoriesRecord> getPrimaryKey() {
		return DBAdapter.Keys.KEY_CATEGORIES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<DBAdapter.tables.records.CategoriesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<DBAdapter.tables.records.CategoriesRecord>>asList(DBAdapter.Keys.KEY_CATEGORIES_PRIMARY, DBAdapter.Keys.KEY_CATEGORIES_INDEX_CATEGORIES_ON_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DBAdapter.tables.Categories as(java.lang.String alias) {
		return new DBAdapter.tables.Categories(alias);
	}
}