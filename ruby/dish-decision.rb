require 'net/http'
require 'json'

print "What Season is it? (Spring, Summer, Fall, Winter)  "
season = gets.chomp

print "How many Guests?  "
guests = gets.chomp

uri = URI('https://dmn.camunda.cloud/api/v1/decision/example-dish')
Net::HTTP.start(uri.host, uri.port, :use_ssl => true) do |http|
  request = Net::HTTP::Post.new uri
  request.body = {season: {value: season, type: 'string'}, guests: {value: guests.to_i, type: 'integer'}}.to_json
  request.content_type = 'application/json'

  response = http.request request
  result = JSON.parse(response.body)['outputs']['dish']['values'][0]
  puts "You should have #{result}"
end
