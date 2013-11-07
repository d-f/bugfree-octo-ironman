class Tweet < ActiveRecord::Base
  has_one :information
  has_and_belongs_to_many :categories
  has_and_belongs_to_many :tags
end
