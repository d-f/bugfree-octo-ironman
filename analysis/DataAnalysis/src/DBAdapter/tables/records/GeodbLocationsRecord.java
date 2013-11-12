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
public class GeodbLocationsRecord extends org.jooq.impl.UpdatableRecordImpl<DBAdapter.tables.records.GeodbLocationsRecord> implements org.jooq.Record2<java.lang.Integer, java.lang.Integer> {

	private static final long serialVersionUID = -1169440457;

	/**
	 * Setter for <code>MI_WS1314.geodb_locations.loc_id</code>. 
	 */
	public void setLocId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_locations.loc_id</code>. 
	 */
	public java.lang.Integer getLocId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_locations.loc_type</code>. 
	 */
	public void setLocType(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_locations.loc_type</code>. 
	 */
	public java.lang.Integer getLocType() {
		return (java.lang.Integer) getValue(1);
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
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Integer, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Integer, java.lang.Integer> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return DBAdapter.tables.GeodbLocations.GEODB_LOCATIONS.LOC_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return DBAdapter.tables.GeodbLocations.GEODB_LOCATIONS.LOC_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getLocId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getLocType();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GeodbLocationsRecord
	 */
	public GeodbLocationsRecord() {
		super(DBAdapter.tables.GeodbLocations.GEODB_LOCATIONS);
	}

	/**
	 * Create a detached, initialised GeodbLocationsRecord
	 */
	public GeodbLocationsRecord(java.lang.Integer locId, java.lang.Integer locType) {
		super(DBAdapter.tables.GeodbLocations.GEODB_LOCATIONS);

		setValue(0, locId);
		setValue(1, locType);
	}
}
