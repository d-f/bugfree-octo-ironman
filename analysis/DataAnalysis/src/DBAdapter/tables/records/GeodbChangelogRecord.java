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
public class GeodbChangelogRecord extends org.jooq.impl.UpdatableRecordImpl<DBAdapter.tables.records.GeodbChangelogRecord> implements org.jooq.Record5<java.lang.Integer, java.sql.Date, java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = 376460929;

	/**
	 * Setter for <code>MI_WS1314.geodb_changelog.id</code>. 
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_changelog.id</code>. 
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_changelog.datum</code>. 
	 */
	public void setDatum(java.sql.Date value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_changelog.datum</code>. 
	 */
	public java.sql.Date getDatum() {
		return (java.sql.Date) getValue(1);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_changelog.beschreibung</code>. 
	 */
	public void setBeschreibung(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_changelog.beschreibung</code>. 
	 */
	public java.lang.String getBeschreibung() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_changelog.autor</code>. 
	 */
	public void setAutor(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_changelog.autor</code>. 
	 */
	public java.lang.String getAutor() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_changelog.version</code>. 
	 */
	public void setVersion(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_changelog.version</code>. 
	 */
	public java.lang.String getVersion() {
		return (java.lang.String) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.sql.Date, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.sql.Date, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Date> field2() {
		return DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG.DATUM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG.BESCHREIBUNG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG.AUTOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG.VERSION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Date value2() {
		return getDatum();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getBeschreibung();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getAutor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getVersion();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GeodbChangelogRecord
	 */
	public GeodbChangelogRecord() {
		super(DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG);
	}

	/**
	 * Create a detached, initialised GeodbChangelogRecord
	 */
	public GeodbChangelogRecord(java.lang.Integer id, java.sql.Date datum, java.lang.String beschreibung, java.lang.String autor, java.lang.String version) {
		super(DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG);

		setValue(0, id);
		setValue(1, datum);
		setValue(2, beschreibung);
		setValue(3, autor);
		setValue(4, version);
	}
}