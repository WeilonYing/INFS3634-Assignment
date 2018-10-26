# Classes and Objects
Most popular object-oriented languages are class-based. Class-based OOP refers to the definition of
objects as instances of classes. In other words, classes define the structure and behaviour of
an object. One analogy of this concept is that of an architectural blueprint and a house: the
blueprint is the class, and the house is the realised object instance of that class. There are two
main types of object-oriented programming: class-based OOP and prototype-based OOP.

## Class-based vs. Prototype-based OOP
### Class-based OOP
In class-based OOP, objects are predefined and are instantiated based on a blueprint, or a *class*.
Examples of class-based object-oriented languages include Java and Python.

Example in Java (a class-based language):
```Java
public class Fruit { // Here, we're defining the blueprint of an object (i.e. a class)
    int calories; // This line declares the existence of a field, or data about the Fruit object.
    public void eat() { // This line declares the existence of a procedure, or a object's action
        System.out.println("I just consumed " + calories + " kilojoules!");
    }
}
```
```Java
// This line creates a new object instance of the Fruit class, and can be referred to using 'f'
Fruit f = new Fruit();
f.eat(); // This line calls a procedure (or method) from that object.
```

### Prototype-based OOP
In prototype-based OOP, classes do not exist. Instead, objects are the primary entities.
Instead of classes, objects are defined and instantiated by the cloning of another object, i.e. a
*prototype*.

Example in JavaScript (a prototype-based language):
```JavaScript
function Fruit() { // We declare a Fruit prototype object as a function
    this.calories = 0; // Declare and define the calories attribute
}

Fruit.prototype.eat = function() { // This linen declares the existence of a procedure
    console.log("I just consumed " + this.calories.toString() + " kilojoules!");
}
```
```JavaScript
let f = Fruit(); // Create a new object instance from its prototype.
f.eat(); // This line calls a procedure (or method) fron that object.
```
