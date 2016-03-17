@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')

import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON

def season = System.console().readLine('What Season is it? (Spring, Summer, Fall, Winter)  ')
def guests = System.console().readLine('How many Guests?  ')

def inputs = [
    input1: [ value: season, type: 'string'],
    input2: [ value: guests.toInteger(), type: 'integer']
]

def client = new RESTClient('https://dmn.camunda.cloud')
client.post(
    path: '/api/v1/decision/example-dish',
    body: inputs,
    requestContentType: JSON
) { response, json ->

    def result = json.outputs.output1.values[0];
    println "You should have $result"

}
