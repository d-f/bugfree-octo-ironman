require 'clockwork'
require './config/boot'
require './config/environment'

include Clockwork


handler do |job|
  TweetWorker.perform_async("msg")
end

every(3.seconds, 'frequent.job')
#every(3.minutes, 'less.frequent.job')
#every(1.hour, 'hourly.job')

#every(1.day, 'midnight.job', :at => '00:00')
