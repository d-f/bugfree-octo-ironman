class TweetWorker
  include Sidekiq::Worker

  def perform(msg)
    start = TweetWorker.last_execution
    endd = SimulatedTime.now

    if start.nil?
      start = SimulatedTime.now
    end

    tweets = Tweet.includes(:categories, :information).where("timestamp >= ? and timestamp < ?", start, endd).to_a
    #tweets = [Tweet.includes(:categories, :information).first(:offset => rand(Tweet.count))] # for testing
    tweets = tweets.map do |t|
      t.enriched
    end

    if tweets.length > 0
      WebsocketRails[:tweets].trigger(:new, tweets)
    end

    TweetWorker.set_last_execution
  end


  @@last_execution_key = "tweet_worker:last_execution"
  class << self

    def clear_last_execution
      $redis.del(@@last_execution_key)
      nil
    end

    def last_execution
      time = $redis.get(@@last_execution_key)
      return nil if time.nil?
      DateTime.parse(time)
    end

    def set_last_execution
      time = SimulatedTime.now
      $redis.set(@@last_execution_key, time)
      time
    end

  end
end
