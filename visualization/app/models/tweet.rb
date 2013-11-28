class Tweet < ActiveRecord::Base
  has_one :information
  has_and_belongs_to_many :categories
  has_and_belongs_to_many :tags

  def enriched
    data = attributes

    category = categories.first
    data[:category_id] = category.try!(:id)
    data[:category_name] = category.try!(:name)

    data[:geolocation] = nilWhenEmpty(geolocation) || nilWhenEmpty(information.try!(:geolocation))
    data[:geolocation] = geolocation_to_json(data[:geolocation])
    data[:place] = nilWhenEmpty(place) || nilWhenEmpty(information.try!(:place))

    data
  end

private

  def nilWhenEmpty(x)
    # rows in database are not real SQL NULL's but the string "null" -_-"
    return nil if(x === "" || x === "null")
    x
  end

  def geolocation_to_json(x)
    if x =~ /.*{.*=([0-9.]+), .*=([0-9.]+)}/
      {:latitude => $1, :longitude => $2}
    else
      x
    end
  end


end
