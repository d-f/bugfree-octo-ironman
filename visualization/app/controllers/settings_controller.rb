class SettingsController < ApplicationController

  def index
    @time = SimulatedTime.get[0]
  end

end
