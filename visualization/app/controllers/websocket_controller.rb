class WebsocketController < WebsocketRails::BaseController
  def update_range
    WebsocketRails[:channel_name].trigger(:event_name, {:start => message})
    WebsocketRails[:ui].trigger(:time_range_updated, {:start => 999, :end => 111})
  end

  def get_time
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
