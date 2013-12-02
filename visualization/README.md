# bugfree octo ironman

## Installation

You need

* Ruby >= 2.0
* Redis >= 2.4
* Database server (preferably MySQL)
* The bundler gem (gem install bundler)


All other dependencies will be installed through `bundler`, by running `bundle` in the application's main directory.


## Running

1. Start redis on localhost running on port 6379 (default)
1. Start sidekiq by running `bundle exec sidekiq`
1. Start the rails server (`rails server` in the main directory)
1. Start the "clockwork" daemon, by running `bundle exec clockwork clockwork.rb`
1. Start the rails websocket server by running `bundle exec rake websocket_rails:start_server`




## Misc

The following can be run to generate test time data for the tweet table:

    start = DateTime.parse("2013-10-27 13:25:00")
    Tweet.order(:id).each_with_index do |item,index|
        item.timestamp = start
        start += [3,5,10,15].sample.seconds
        item.save
    end


