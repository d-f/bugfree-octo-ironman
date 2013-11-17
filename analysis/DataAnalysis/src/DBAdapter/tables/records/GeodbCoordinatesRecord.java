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
public class GeodbCoordinatesRecord extends org.jooq.impl.TableRecordImpl<DBAdapter.tables.records.GeodbCoordinatesRecord> implements org.jooq.Record9<java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.Integer, java.sql.Date, java.lang.Integer, java.sql.Date, java.lang.Integer> {

	private static final long serialVersionUID = -350367206;

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.loc_id</code>. 
	 */
	public void setLocId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.loc_id</code>. 
	 */
	public java.lang.Integer getLocId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.coord_type</code>. 
	 */
	public void setCoordType(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.coord_type</code>. 
	 */
	public java.lang.Integer getCoordType() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.lat</code>. 
	 */
	public void setLat(java.lang.Double value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.lat</code>. 
	 */
	public java.lang.Double getLat() {
		return (java.lang.Double) getValue(2);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.lon</code>. 
	 */
	public void setLon(java.lang.Double value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.lon</code>. 
	 */
	public java.lang.Double getLon() {
		return (java.lang.Double) getValue(3);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.coord_subtype</code>. 
	 */
	public void setCoordSubtype(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.coord_subtype</code>. 
	 */
	public java.lang.Integer getCoordSubtype() {
		return (java.lang.Integer) getValue(4);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.valid_since</code>. 
	 */
	public void setValidSince(java.sql.Date value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.valid_since</code>. 
	 */
	public java.sql.Date getValidSince() {
		return (java.sql.Date) getValue(5);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.date_type_since</code>. 
	 */
	public void setDateTypeSince(java.lang.Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.date_type_since</code>. 
	 */
	public java.lang.Integer getDateTypeSince() {
		return (java.lang.Integer) getValue(6);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.valid_until</code>. 
	 */
	public void setValidUntil(java.sql.Date value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.valid_until</code>. 
	 */
	public java.sql.Date getValidUntil() {
		return (java.sql.Date) getValue(7);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_coordinates.date_type_until</code>. 
	 */
	public void setDateTypeUntil(java.lang.Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_coordinates.date_type_until</code>. 
	 */
	public java.lang.Integer getDateTypeUntil() {
		return (java.lang.Integer) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row9<java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.Integer, java.sql.Date, java.lang.Integer, java.sql.Date, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row9<java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.Integer, java.sql.Date, java.lang.Integer, java.sql.Date, java.lang.Integer> valuesRow() {
		return (org.jooq.Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.LOC_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.COORD_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field3() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.LAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field4() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.LON;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.COORD_SUBTYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Date> field6() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.VALID_SINCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field7() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.DATE_TYPE_SINCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Date> field8() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.VALID_UNTIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field9() {
		return DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES.DATE_TYPE_UNTIL;
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
		return getCoordType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value3() {
		return getLat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value4() {
		return getLon();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getCoordSubtype();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Date value6() {
		return getValidSince();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value7() {
		return getDateTypeSince();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Date value8() {
		return getValidUntil();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value9() {
		return getDateTypeUntil();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GeodbCoordinatesRecord
	 */
	public GeodbCoordinatesRecord() {
		super(DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES);
	}

	/**
	 * Create a detached, initialised GeodbCoordinatesRecord
	 */
	public GeodbCoordinatesRecord(java.lang.Integer locId, java.lang.Integer coordType, java.lang.Double lat, java.lang.Double lon, java.lang.Integer coordSubtype, java.sql.Date validSince, java.lang.Integer dateTypeSince, java.sql.Date validUntil, java.lang.Integer dateTypeUntil) {
		super(DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES);

		setValue(0, locId);
		setValue(1, coordType);
		setValue(2, lat);
		setValue(3, lon);
		setValue(4, coordSubtype);
		setValue(5, validSince);
		setValue(6, dateTypeSince);
		setValue(7, validUntil);
		setValue(8, dateTypeUntil);
	}
}