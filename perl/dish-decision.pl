#!/usr/bin/env perl

use strict;
use warnings;
use LWP::UserAgent;
use JSON qw ( decode_json );

print 'What Season is it? (Spring, Summer, Fall, Winter)  ';
chomp(my $season = <>);
print 'How many Guests?  ';
chomp(my $guests = <>);

my $ua = LWP::UserAgent->new;
my $uri = 'https://dmn.camunda.cloud/api/v1/decision/example-dish';
my $inputs = '{"season": { "value": "' . $season .  '", "type": "string"}, "guests": {"value": ' . $guests . ', "type": "integer"}}}';
my $req = HTTP::Request->new('POST', $uri);
$req->header( 'Content-Type' => 'application/json' );
$req->content( $inputs );

my $json = $ua->request($req)->decoded_content;
my $result = decode_json( $json )->{'outputs'}{'dish'}{'values'}[0];
print 'You should have '  . $result . "\n";
