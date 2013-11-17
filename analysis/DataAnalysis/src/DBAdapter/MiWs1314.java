/**
 * This class is generated by jOOQ
 */
package DBAdapter;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MiWs1314 extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 1569675344;

	/**
	 * The singleton instance of <code>MI_WS1314</code>
	 */
	public static final MiWs1314 MI_WS1314 = new MiWs1314();

	/**
	 * No further instances allowed
	 */
	private MiWs1314() {
		super("MI_WS1314");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			DBAdapter.tables.Categories.CATEGORIES,
			DBAdapter.tables.CategoriesTrainingTweets.CATEGORIES_TRAINING_TWEETS,
			DBAdapter.tables.CategoriesTweets.CATEGORIES_TWEETS,
			DBAdapter.tables.Employees.EMPLOYEES,
			DBAdapter.tables.GeodbChangelog.GEODB_CHANGELOG,
			DBAdapter.tables.GeodbCoordinates.GEODB_COORDINATES,
			DBAdapter.tables.GeodbFloatdata.GEODB_FLOATDATA,
			DBAdapter.tables.GeodbHierarchies.GEODB_HIERARCHIES,
			DBAdapter.tables.GeodbIntdata.GEODB_INTDATA,
			DBAdapter.tables.GeodbLocations.GEODB_LOCATIONS,
			DBAdapter.tables.GeodbTextdata.GEODB_TEXTDATA,
			DBAdapter.tables.GeodbTypeNames.GEODB_TYPE_NAMES,
			DBAdapter.tables.Information.INFORMATION,
			DBAdapter.tables.Tags.TAGS,
			DBAdapter.tables.TagsTweets.TAGS_TWEETS,
			DBAdapter.tables.TweetsHochwasser.TWEETS_HOCHWASSER,
			DBAdapter.tables.TweetsSturm.TWEETS_STURM,
			DBAdapter.tables.TweetsSyria.TWEETS_SYRIA);
	}
}