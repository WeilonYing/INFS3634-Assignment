# Polymorphism
Polymorphism is the use of a single interface or symbol to represent multiple different types.
It can be done through the provision of a single **interface** as a set of common methods and data fields).
Alternatively, polymorphism can also be done through **subtyping**, where instances of multiple
classes are treated as a single common superclass (parent class). In other words, a variable of
a supertype can refer to a subtype object.

## Examples
Suppose there exists a Fruit class.
```Java
pubilc class Fruit {
  int calories;

  public void eat() {
    System.out.println("Om nom nom nom nom");
  }
}
```

And there also exists an Apple class that extends the properties of Fruit.
```Java
public class Apple extends Fruit {
  @Override
  public void eat() {
    System.out.println("CRUNCH");
  }
}
```

Then the Apple class can be assigned (i.e. polymorphed) as an instance of a Fruit.
```Java
Fruit fruit = new Apple();
fruit.eat();
```

