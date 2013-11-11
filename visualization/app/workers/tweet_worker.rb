class TweetWorker
  include Sidekiq::Worker

  def perform(msg)
    WebsocketRails[:ui].trigger(:time_range_updated, {:start => 123, :end => 456})
  end
end
