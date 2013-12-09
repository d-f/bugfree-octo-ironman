class WebsocketController < WebsocketRails::BaseController
  def set_range
    range = message[:range].to_i
    SimulatedTime.set_range range
    start = SimulatedTime.now - range.seconds
    WebsocketRails[:time].trigger(:range_updated, {:start => start.to_i})
    TweetWorker.set_last_execution(start - 1.second)
  end

  def get_range
    trigger_success SimulatedTime.get_range
  end

  def get_time
    SimulatedTime.set("2013-10-27 13:23:00")
    trigger_success SimulatedTime.get
  end

  def set_time
    SimulatedTime.set(message[:time])
    WebsocketRails[:time].trigger(:simulated_time_updated, SimulatedTime.get)
    trigger_success SimulatedTime.get
  end

  def get_categories
    trigger_success Category.order(:id).all.to_json
  end
end
