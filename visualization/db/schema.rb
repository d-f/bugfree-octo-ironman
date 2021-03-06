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

  create_table "categories_tweets", id: false, force: true do |t|
    t.integer "tweet_id",            limit: 8,                          null: false
    t.integer "category_id",                                            null: false
    t.decimal "category_confidence",           precision: 10, scale: 0
  end

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

end
