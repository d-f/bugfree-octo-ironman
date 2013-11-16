class Information < ActiveRecord::Base
  self.primary_key = :tweet_id
  belongs_to :tweet
end
