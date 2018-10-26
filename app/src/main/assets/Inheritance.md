# Inheritance
Inheritance is the action of basing the implementation of a class/object off another class/object.
An object created through inheritance retains the properties and behaviours of its parent.

This feature is very useful for extending existing software and implementations with new features
and behaviours while keeping much of the existing properties, as well as maximising the reuse of
code.

A class that inherits the properties of another class is called a **subclass**.

![Example of Inheritance](https://i.imgur.com/ieEt4Yn.png)

## Subclasses and superclasses
Consider the existence of different classes that have some common properties and behaviours, which
can be generalised in a common class. The common class is known as a **superclass**.

Consider the existence of class *C1* that extends upon the properties of class *C2*. Class *C1*
is the **subclass**.

## Inheritance in Java
In Java, a class is defined as a subtype of another by using the `extends` keyword in
the class' declaration. The example below shows an `Apple` class inheriting the properties
of a `Fruit`:
```Java
public class Apple extends Fruit {
  // code
}
```

The properties of the parent class can be used in the child class so long as the property
is either `public` (any entity can access it) or `protected`
(only subclasses and the class itself can access it). For example, if `Fruit` had the
following attributes and methods:
```Java
public class Fruit {
  protected int calories;
  public int getCalories() { /* code */ };
  private int setCalories() { /* code */};
}
```
Then `Apple` is able to access `calories` and `getCalories()`, but not `setCalories()`.

Subclasses of `Fruit`, like `Apple` can replace the implementation of protected and
public methods in `Fruit`, provided that the method signature remains the same.
Example:
```Java
public class Apple extends Fruit {
  @Override // specify we are overriding the implementation of a parent's method
  public int getCalories() {
    int calories = super.getCalories(); // we can still use the parent's method by using super.
    return calories + 10;
  }
}
```
