class WebsocketController < WebsocketRails::BaseController
  def update_range
    WebsocketRails[:channel_name].trigger(:event_name, {:start => message})
    WebsocketRails[:ui].trigger(:time_range_updated, {:start => 999, :end => 111})
  end
end
