#!/bin/bash

#1. Start redis on localhost running on port 6379 (default)
#1. Start sidekiq by running `bundle exec sidekiq`
#1. Start the rails server (`rails server` in the main directory)
#1. Start the "clockwork" daemon, by running `bundle exec clockwork clockwork.rb`
#1. Start the rails websocket server by running `bundle exec rake websocket_rails:start_server`

trap ctrl_c INT

echo "Starting redis"
redis-server /usr/local/etc/redis.conf 1>log/redis.log 2>&1 &
REDIS_PID=$!
echo "PID: $REDIS_PID"

echo "Starting sidekiq"
bundle exec sidekiq 1>log/sidekiq.log 2>&1 &
SIDEKIQ_PID=$!
echo "PID: $SIDEKIQ_PID"

echo "Starting rails"
rails server 1>log/rails.log 2>&1 &
RAILS_PID=$!
echo "PID: $RAILS_PID"

echo "Starting clockwork"
bundle exec clockwork clockwork.rb 1>log/clockwork.log 2>&1 &
CLOCKWORK_PID=$!
echo "PID: $CLOCKWORK_PID"

bundle exec rake websocket_rails:start_server

function ctrl_c() {
    bundle exec rake websocket_rails:stop_server

    echo "Killing redis with PID $REDIS_PID"
    kill $REDIS_PID

    echo "Killing sidekiq with PID $SIDEKIQ_PID"
    kill $SIDEKIQ_PID

    echo "Killing rails with PID $RAILS_PID"
    kill $RAILS_PID

    echo "Killing clockwork with PID $CLOCKWORK_PID"
    kill $CLOCKWORK_PID
}

echo "Everythings up and running. Stop using Ctrl-C"

wait
echo "All processes have terminated!"

