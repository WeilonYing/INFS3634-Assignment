# Abstraction
Abstraction refers to the separation of the implementation of the class from the use of the class.
The creator provides a description of the class and lets the user know how the class can be used.
As a result, the user doesn't need to know how the class is implemented in order to use it.

Abstraction can be done through the provision of a common interface that the class implements, and
called by the user via the interface. It can also be done through simple documentation of how the
class can be used. For example, the Android API documentation provides information on how each
 class can be used. The user does not need to worry about how each class is implemented,
only how it should be called.

## Examples
### Definition of a Shape interface
One method of abstraction is the provision of a Shape interface that sets out what methods
are available to a user for classes that are a form of a Shape (e.g. Circle, Square).
```Java
public interface Shape {
  public void draw(Graphics2D graphics);
}
```
### Implementation of a Circle class
The programmer creates a Circle class that implements the Shape interface.
```Java
public class Circle implements Shape {
  // Programmer provides documentation to show how class can be used.
  // Documentation can be compiled into JavaDocs, which can be accessed in a web browser
  // for easy access.
  /**
   * Draw a circle on a graphics object
   * @param radius the radius of the circle
   * @param graphics the graphics object to draw on
   */
  @Override
  public void draw(Graphics2D graphics) {
    int numPoints = 32;
    for (int i = 0; i < numPoints; i++) {
      graphics.addPoint(
        Math.sin(((double) i/numPoints) / (2 * Math.PI)),
        Math.cos(((double) i/numPoints) / (2 * Math.PI)));
    }
  }
}
```
### How a user could use the Circle class
The user simply uses and calls methods from the Circle and doesn't need to worry about its
implementation.
```Java
Shape[] shapes = { new Circle(), new Square() }; // array with a variety of shapes
for (Shape s : shapes) { // draw each shape in the array.
  s.draw();  // User doesn't need to worry how the shape is drawn, they just need to call the method.
}
```
