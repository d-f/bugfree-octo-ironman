class CreateTables < ActiveRecord::Migration
  def change

    create_table :tweets do |t|
      t.integer :iteration
      t.string :text, :limit => 150, :null => false
      t.string :hashtags, :limit => 150
      t.string :author, :limit => 50, :null => false
      t.integer :retweets, :null => false
      t.timestamp :timestamp, :null => false
      t.integer :follower
      t.string :geolocation, :limit => 200
      t.string :place, :limit => 200
      t.integer :commentRef, :limit => 8
    end
    change_column :tweets, :id , "bigint NOT NULL AUTO_INCREMENT"

    create_table :categories do |t|
      t.string :name, :limit => 200
    end

    create_table :categories_tweets do |t|
      t.belongs_to :tweet, :null => false, :limit => 8
      t.belongs_to :category, :null => false
    end

    create_table :information do |t|
      t.belongs_to :tweet, :null => false, :limit => 8
      t.string :geolocation, :limit => 200
      t.string :place, :limit => 200
    end

  end
end
