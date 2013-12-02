class CategoriesTweet < ActiveRecord::Base
  belongs_to :category
  belongs_to :tweet
end
