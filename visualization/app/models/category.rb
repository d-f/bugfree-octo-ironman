class Category < ActiveRecord::Base
  has_many :categories_tweets
  has_many :tweets, :through => :categories_tweets
end
