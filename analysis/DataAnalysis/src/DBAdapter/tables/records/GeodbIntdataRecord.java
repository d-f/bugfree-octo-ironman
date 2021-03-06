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
public class GeodbIntdataRecord extends org.jooq.impl.TableRecordImpl<DBAdapter.tables.records.GeodbIntdataRecord> implements org.jooq.Record7<java.lang.Integer, java.lang.Integer, java.lang.Long, java.sql.Date, java.lang.Integer, java.sql.Date, java.lang.Integer> {

	private static final long serialVersionUID = -1134682013;

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.loc_id</code>. 
	 */
	public void setLocId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.loc_id</code>. 
	 */
	public java.lang.Integer getLocId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.int_type</code>. 
	 */
	public void setIntType(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.int_type</code>. 
	 */
	public java.lang.Integer getIntType() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.int_val</code>. 
	 */
	public void setIntVal(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.int_val</code>. 
	 */
	public java.lang.Long getIntVal() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.valid_since</code>. 
	 */
	public void setValidSince(java.sql.Date value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.valid_since</code>. 
	 */
	public java.sql.Date getValidSince() {
		return (java.sql.Date) getValue(3);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.date_type_since</code>. 
	 */
	public void setDateTypeSince(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.date_type_since</code>. 
	 */
	public java.lang.Integer getDateTypeSince() {
		return (java.lang.Integer) getValue(4);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.valid_until</code>. 
	 */
	public void setValidUntil(java.sql.Date value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.valid_until</code>. 
	 */
	public java.sql.Date getValidUntil() {
		return (java.sql.Date) getValue(5);
	}

	/**
	 * Setter for <code>MI_WS1314.geodb_intdata.date_type_until</code>. 
	 */
	public void setDateTypeUntil(java.lang.Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>MI_WS1314.geodb_intdata.date_type_until</code>. 
	 */
	public java.lang.Integer getDateTypeUntil() {
		return (java.lang.Integer) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Integer, java.lang.Integer, java.lang.Long, java.sql.Date, java.lang.Integer, java.sql.Date, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Integer, java.lang.Integer, java.lang.Long, java.sql.Date, java.lang.Integer, java.sql.Date, java.lang.Integer> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.LOC_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.INT_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.INT_VAL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Date> field4() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.VALID_SINCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.DATE_TYPE_SINCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Date> field6() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.VALID_UNTIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field7() {
		return DBAdapter.tables.GeodbIntdata.GEODB_INTDATA.DATE_TYPE_UNTIL;
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
		return getIntType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getIntVal();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Date value4() {
		return getValidSince();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getDateTypeSince();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Date value6() {
		return getValidUntil();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value7() {
		return getDateTypeUntil();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GeodbIntdataRecord
	 */
	public GeodbIntdataRecord() {
		super(DBAdapter.tables.GeodbIntdata.GEODB_INTDATA);
	}

	/**
	 * Create a detached, initialised GeodbIntdataRecord
	 */
	public GeodbIntdataRecord(java.lang.Integer locId, java.lang.Integer intType, java.lang.Long intVal, java.sql.Date validSince, java.lang.Integer dateTypeSince, java.sql.Date validUntil, java.lang.Integer dateTypeUntil) {
		super(DBAdapter.tables.GeodbIntdata.GEODB_INTDATA);

		setValue(0, locId);
		setValue(1, intType);
		setValue(2, intVal);
		setValue(3, validSince);
		setValue(4, dateTypeSince);
		setValue(5, validUntil);
		setValue(6, dateTypeUntil);
	}
}
