# Encapsulation
Encapsulation refers to the mechanism of restricting and controlling access to an object's components.
It is used to hide methods and the values of data in an object, preventing another party from
unauthorised access.

Programming languages that support explicit encapsulation usually denote attributes and methods to
be hidden using the `private` keyword. In Java, the `protected` keyword is also used to allow
attributes and methods to be accessed by subclasses.

Publicly accessible methods are generally provided that allows outsiders controlled access to the
object's attributes. These are known as *getters* and *setters*, which retrieve and modify the
values of the attributes respectively.  

## Examples
Example of controlling access to an attribute using encapsulation in Java:
```Java
public class BankAccount { // the class itself can be publicly known and accessed
  private double balance; // balance can only be accessed by methods within this class

  public double getBalance() { // Getter method to allow users to retrieve the current balance amount
    return this.balance;
  }

  // Allow users to withdraw from balance with some checks
  // Exposing this method instead of allowing direct access ensures user can't overdraw the balance
  public double withdrawBalance(double amount) {
    if (this.balance - amount > 0) {
      this.balance -= amount;
    } else {
      System.out.println("Insufficient balance");
    }
  }
}
```