class SimulatedTime
  class << self

    def get
      time = $redis.get("simulated_time")
      if time.nil?
        time = DateTime.now.to_s
        $redis.set("simulated_time", time)
        $redis.set("simulated_time_set_at", time)
        [time, time]
      else
        [time, $redis.get("simulated_time_set_at")]
      end
    end

    def now
      time = get()
      DateTime.parse(time[0]) + (DateTime.now - DateTime.parse(time[1]))
    end

    def set(time)
      time = DateTime.parse(time).to_s
      $redis.set("simulated_time", time)
      $redis.set("simulated_time_set_at", DateTime.now)

      [$redis.get("simulated_time"), $redis.get("simulated_time_set_at")]
      TweetWorker.clear_last_execution
    end


  end
end
