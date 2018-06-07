# How to run

This example uses the [dish DMN table][]. To run it you need [python 3][]
installed.

You also need to get a public key from [dmn.lab.camunda][]. Click on the
Deploy button after the Dish table.

Run it with:
```
python dish-decision.py
```

Paste the public key in the key prompt.

# Output

```
$ python dish-decision.py
Your public key: decision-2bc97e15-6a3b-11e8-aacd
What Season is it? (Spring, Summer, Fall, Winter)  Spring
How many Guests?  3
You should have Dry Aged Gourmet Steak
```


[dish DMN table]: https://dmn.camunda.cloud/view/index.html?key=example-dish
[python 3]: https://www.python.org/downloads/
[dmn.lab.camunda]: https://dmn.lab.camunda.com