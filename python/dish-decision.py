import json
import urllib.request

season = input('What Season is it? (Spring, Summer, Fall, Winter)  ')
guests = input('How many Guests?  ')

inputs = json.dumps({
    'season': {'value': season,
               'type': 'string'},
    'guests': {'value': int(guests),
               'type': 'integer'}
}).encode('utf-8')

request = urllib.request.Request(
    'https://dmn.camunda.cloud/api/v1/decision/example-dish',
    data=inputs,
    headers={'Content-Type': 'application/json'})

with urllib.request.urlopen(request) as response:
    body = response.read().decode('utf-8')

result = json.loads(body)['outputs']['dish']['values'][0]
print('You should have ' + result)
