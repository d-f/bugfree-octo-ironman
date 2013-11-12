class SettingsController < ApplicationController

  def index
    @time = SimulatedTime.now[0]
  end

end
