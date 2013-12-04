# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20131202092637) do

  create_table "categories", force: true do |t|
    t.string "name", limit: 200
  end

  add_index "categories", ["name"], name: "index_categories_on_name", unique: true, using: :btree

  create_table "categories_training_tweets", primary_key: "text", force: true do |t|
    t.integer "category", null: false
  end

  add_index "categories_training_tweets", ["text"], name: "text_UNIQUE", unique: true, using: :btree

  create_table "categories_tweets", id: false, force: true do |t|
    t.integer "tweet_id",            limit: 8,                          null: false
    t.integer "category_id",                                            null: false
    t.decimal "category_confidence",           precision: 10, scale: 0
  end

  create_table "employees", force: true do |t|
    t.string "first_name", limit: 56
    t.string "last_name",  limit: 56
  end

  create_table "geodb_changelog", force: true do |t|
    t.date   "datum",                   null: false
    t.text   "beschreibung",            null: false
    t.string "autor",        limit: 50, null: false
    t.string "version",      limit: 8
  end

  create_table "geodb_coordinates", id: false, force: true do |t|
    t.integer "loc_id",          null: false
    t.integer "coord_type",      null: false
    t.float   "lat"
    t.float   "lon"
    t.integer "coord_subtype"
    t.date    "valid_since"
    t.integer "date_type_since"
    t.date    "valid_until",     null: false
    t.integer "date_type_until", null: false
  end

  add_index "geodb_coordinates", ["coord_subtype"], name: "coord_stype_idx", using: :btree
  add_index "geodb_coordinates", ["coord_type"], name: "coord_type_idx", using: :btree
  add_index "geodb_coordinates", ["lat"], name: "coord_lat_idx", using: :btree
  add_index "geodb_coordinates", ["loc_id"], name: "coord_loc_id_idx", using: :btree
  add_index "geodb_coordinates", ["lon"], name: "coord_lon_idx", using: :btree
  add_index "geodb_coordinates", ["valid_since"], name: "coord_since_idx", using: :btree
  add_index "geodb_coordinates", ["valid_until"], name: "coord_until_idx", using: :btree

  create_table "geodb_floatdata", id: false, force: true do |t|
    t.integer "loc_id",          null: false
    t.integer "float_type",      null: false
    t.float   "float_val",       null: false
    t.date    "valid_since"
    t.integer "date_type_since"
    t.date    "valid_until",     null: false
    t.integer "date_type_until", null: false
  end

  add_index "geodb_floatdata", ["float_type"], name: "float_type_idx", using: :btree
  add_index "geodb_floatdata", ["float_val"], name: "float_val_idx", using: :btree
  add_index "geodb_floatdata", ["loc_id"], name: "float_lid_idx", using: :btree
  add_index "geodb_floatdata", ["valid_since"], name: "float_since_idx", using: :btree
  add_index "geodb_floatdata", ["valid_until"], name: "float_until_idx", using: :btree

  create_table "geodb_hierarchies", id: false, force: true do |t|
    t.integer "loc_id",          null: false
    t.integer "level",           null: false
    t.integer "id_lvl1",         null: false
    t.integer "id_lvl2"
    t.integer "id_lvl3"
    t.integer "id_lvl4"
    t.integer "id_lvl5"
    t.integer "id_lvl6"
    t.integer "id_lvl7"
    t.integer "id_lvl8"
    t.integer "id_lvl9"
    t.date    "valid_since"
    t.integer "date_type_since"
    t.date    "valid_until",     null: false
    t.integer "date_type_until", null: false
  end

  add_index "geodb_hierarchies", ["id_lvl1"], name: "hierarchy_lvl1_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl2"], name: "hierarchy_lvl2_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl3"], name: "hierarchy_lvl3_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl4"], name: "hierarchy_lvl4_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl5"], name: "hierarchy_lvl5_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl6"], name: "hierarchy_lvl6_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl7"], name: "hierarchy_lvl7_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl8"], name: "hierarchy_lvl8_idx", using: :btree
  add_index "geodb_hierarchies", ["id_lvl9"], name: "hierarchy_lvl9_idx", using: :btree
  add_index "geodb_hierarchies", ["level"], name: "hierarchy_level_idx", using: :btree
  add_index "geodb_hierarchies", ["loc_id"], name: "hierarchy_loc_id_idx", using: :btree
  add_index "geodb_hierarchies", ["valid_since"], name: "hierarchy_since_idx", using: :btree
  add_index "geodb_hierarchies", ["valid_until"], name: "hierarchy_until_idx", using: :btree

  create_table "geodb_intdata", id: false, force: true do |t|
    t.integer "loc_id",                    null: false
    t.integer "int_type",                  null: false
    t.integer "int_val",         limit: 8, null: false
    t.date    "valid_since"
    t.integer "date_type_since"
    t.date    "valid_until",               null: false
    t.integer "date_type_until",           null: false
  end

  add_index "geodb_intdata", ["int_type"], name: "int_type_idx", using: :btree
  add_index "geodb_intdata", ["int_val"], name: "int_val_idx", using: :btree
  add_index "geodb_intdata", ["loc_id"], name: "int_lid_idx", using: :btree
  add_index "geodb_intdata", ["valid_since"], name: "int_since_idx", using: :btree
  add_index "geodb_intdata", ["valid_until"], name: "int_until_idx", using: :btree

  create_table "geodb_locations", primary_key: "loc_id", force: true do |t|
    t.integer "loc_type", null: false
  end

  add_index "geodb_locations", ["loc_type"], name: "loc_type_idx", using: :btree

  create_table "geodb_textdata", id: false, force: true do |t|
    t.integer "loc_id",                    null: false
    t.integer "text_type",                 null: false
    t.string  "text_val",                  null: false
    t.string  "text_locale",     limit: 5
    t.integer "is_native_lang",  limit: 2
    t.integer "is_default_name", limit: 2
    t.date    "valid_since"
    t.integer "date_type_since"
    t.date    "valid_until",               null: false
    t.integer "date_type_until",           null: false
  end

  add_index "geodb_textdata", ["is_default_name"], name: "text_default_idx", using: :btree
  add_index "geodb_textdata", ["is_native_lang"], name: "text_native_idx", using: :btree
  add_index "geodb_textdata", ["loc_id"], name: "text_lid_idx", using: :btree
  add_index "geodb_textdata", ["text_locale"], name: "text_locale_idx", using: :btree
  add_index "geodb_textdata", ["text_type"], name: "text_type_idx", using: :btree
  add_index "geodb_textdata", ["text_val"], name: "text_val_idx", using: :btree
  add_index "geodb_textdata", ["valid_since"], name: "text_since_idx", using: :btree
  add_index "geodb_textdata", ["valid_until"], name: "text_until_idx", using: :btree

  create_table "geodb_type_names", id: false, force: true do |t|
    t.integer "type_id",               null: false
    t.string  "type_locale", limit: 5, null: false
    t.string  "name",                  null: false
  end

  add_index "geodb_type_names", ["name"], name: "name_tnames_idx", using: :btree
  add_index "geodb_type_names", ["type_id", "type_locale"], name: "type_id", unique: true, using: :btree
  add_index "geodb_type_names", ["type_id"], name: "tid_tnames_idx", using: :btree
  add_index "geodb_type_names", ["type_locale"], name: "locale_tnames_idx", using: :btree

  create_table "information", primary_key: "tweet_id", force: true do |t|
    t.string "geolocation", limit: 200
    t.string "place",       limit: 200
  end

  create_table "tags", force: true do |t|
    t.string "name", limit: 200
  end

  add_index "tags", ["name"], name: "index_tags_on_name", unique: true, using: :btree

  create_table "tags_tweets", id: false, force: true do |t|
    t.integer "tweet_id", limit: 8, null: false
    t.integer "tag_id",             null: false
  end

  create_table "tweets", force: true do |t|
    t.integer  "iteration"
    t.string   "text",        limit: 150
    t.string   "hashtags",    limit: 150
    t.string   "author",      limit: 50
    t.integer  "retweets"
    t.datetime "timestamp"
    t.integer  "follower"
    t.string   "geolocation", limit: 200
    t.string   "place",       limit: 200
    t.integer  "commentRef",  limit: 8
  end

  add_index "tweets", ["id"], name: "id_UNIQUE", unique: true, using: :btree

  create_table "tweets_haiyan", force: true do |t|
    t.integer  "iteration"
    t.string   "text",        limit: 150
    t.string   "hashtags",    limit: 150
    t.string   "author",      limit: 50
    t.integer  "retweets"
    t.datetime "timestamp"
    t.integer  "follower"
    t.string   "geolocation", limit: 200
    t.string   "place",       limit: 200
    t.integer  "commentRef",  limit: 8
  end

  add_index "tweets_haiyan", ["id"], name: "id_UNIQUE", unique: true, using: :btree

  create_table "tweets_hochwasser", force: true do |t|
    t.integer  "iteration"
    t.string   "text",        limit: 500
    t.string   "hashtags",    limit: 150
    t.string   "author",      limit: 50
    t.integer  "retweets"
    t.datetime "timestamp"
    t.integer  "follower"
    t.string   "geolocation", limit: 200
    t.string   "place",       limit: 200
    t.integer  "commentRef",  limit: 8
  end

  add_index "tweets_hochwasser", ["id"], name: "id_UNIQUE", unique: true, using: :btree

  create_table "tweets_old", force: true do |t|
    t.integer  "iteration"
    t.string   "text",        limit: 150, null: false
    t.string   "hashtags",    limit: 150
    t.string   "author",      limit: 50,  null: false
    t.integer  "retweets",                null: false
    t.datetime "timestamp",               null: false
    t.integer  "follower"
    t.string   "geolocation", limit: 200
    t.string   "place",       limit: 200
    t.integer  "commentRef",  limit: 8
  end

  create_table "tweets_syria", force: true do |t|
    t.integer  "iteration"
    t.string   "text",        limit: 150
    t.string   "hashtags",    limit: 150
    t.string   "author",      limit: 50
    t.integer  "retweets"
    t.datetime "timestamp"
    t.integer  "follower"
    t.string   "geolocation", limit: 200
    t.string   "place",       limit: 200
    t.integer  "commentRef",  limit: 8
  end

  add_index "tweets_syria", ["id"], name: "id_UNIQUE", unique: true, using: :btree

  create_table "tweets_yolandaph", force: true do |t|
    t.integer  "iteration"
    t.string   "text",        limit: 150
    t.string   "hashtags",    limit: 150
    t.string   "author",      limit: 50
    t.integer  "retweets"
    t.datetime "timestamp"
    t.integer  "follower"
    t.string   "geolocation", limit: 200
    t.string   "place",       limit: 200
    t.integer  "commentRef",  limit: 8
  end

  add_index "tweets_yolandaph", ["id"], name: "id_UNIQUE", unique: true, using: :btree

  create_table "zip_coordinates", primary_key: "zc_id", force: true do |t|
    t.integer "zc_loc_id",                   null: false
    t.string  "zc_zip",           limit: 10, null: false
    t.string  "zc_location_name",            null: false
    t.float   "zc_lat",                      null: false
    t.float   "zc_lon",                      null: false
  end

end
