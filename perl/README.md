# How to run

This example uses the [dish DMN table][]. To run it you need [perl][] and the
modules [LWP][], [LWP::Protocol::https][] and [JSON] installed.

Run it with:
```
perl dish-decision.pl
```

# Output

```
$ perl dish-decision.pl
What Season is it? (Spring, Summer, Fall, Winter)  Spring
How many Guests?  3
You should have Dry Aged Gourmet Steak
```


[dish DMN table]: https://dmn.camunda.cloud/view/index.html?key=example-dish
[perl]: https://www.perl.org/get.html
[LWP]: http://search.cpan.org/dist/libwww-perl/lib/LWP.pm
[LWP::Protocol::https]: http://search.cpan.org/~mschilli/LWP-Protocol-https-6.06/lib/LWP/Protocol/https.pm
[JSON]: http://search.cpan.org/~makamaka/JSON-2.90/lib/JSON.pm
