# How to run

This example uses the [dish DMN table][]. To run it you need [java][] and
[maven][] installed.

Run it with:
```
mvn clean package
java -jar target/DishDecision.jar
```

# Output

```
$ mvn clean package
$ java -jar target/DishDecision.jar
What Season is it? (Spring, Summer, Fall, Winter)  Spring
How many Guests?  3
You should have Dry Aged Gourmet Steak

```


[dish DMN table]: https://dmn.camunda.cloud/view/index.html?key=example-dish
[java]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[maven]: https://maven.apache.org/download.cgi
