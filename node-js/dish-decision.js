var readline = require('readline');
var https = require('https');

var rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("What Season is it? (Spring, Summer, Fall, Winter)  ", function(season) {

  rl.question("How many Guests?  ", function(guests) {

    var req = https.request({
      hostname: 'dmn.camunda.cloud',
      port: 443,
      path: '/api/v1/decision/example-dish',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      }
    }, function(res) {
      var body = '';
      res.on('data', function(chunk) {
        body += chunk;
      });
      res.on('end', function() {
        var response = JSON.parse(body);
        var result = response.outputs.dish.values[0];

        console.log('You should have ' + result);

        rl.close();
      });
    });

    req.write(JSON.stringify({
      season: {
        value: season,
        type: 'string'
      },
      guests: {
        value: parseInt(guests, 10),
        type: 'integer'
      }
    }));

    req.end();
  });
});
