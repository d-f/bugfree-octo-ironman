class AddTweetCategoryConfidence < ActiveRecord::Migration
  def change
    change_table :categories_tweets do |t|
      t.decimal :category_confidence
    end
  end
end
