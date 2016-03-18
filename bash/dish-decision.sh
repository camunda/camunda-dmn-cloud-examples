#!/bin/bash

echo -n "What Season is it? (Spring, Summer, Fall, Winter)  "
read season

echo -n "How many Guests?  "
read guests

inputs='{"season": {"value": "'$season'", "type": "string"}, "guests": {"value": '$guests', "type": "integer"}}'

result=$(curl -s -H "Content-Type: application/json" -d "$inputs" \
    https://dmn.camunda.cloud/api/v1/decision/example-dish | grep -Po '"values":\["\K([^"]+)')

echo "You should have $result"
