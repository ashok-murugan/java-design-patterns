# Factory Method Pattern

## What is the Factory Method Pattern?
The Factory Method Pattern provides a way to delegate the instantiation of objects to subclasses. It defines an interface or abstract class for creating an object, but allows the subclasses to decide which class to instantiate.

## Why use the Factory Method Pattern?
- To decouple the client code from specific classes it uses.
- To allow more flexibility in introducing new classes without changing existing code.
- To enforce consistent object creation.

##  Code Example: Factory Method for Payment Processing

### Step 1: Define the Product Interface
```java
interface Payment {
    void processPayment(double amount);
}
```

### Step 2: Implement Concrete Products
```java
class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
```

### Step 3: Define the Creator Abstract Class
```java
abstract class PaymentFactory {
    public abstract Payment createPayment();
}
```

### Step 4: Implement Concrete Factories
```java
class CreditCardPaymentFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}
```

### Usage Example
```java
public class PaymentClient {
    public static void main(String[] args) {
        // Create a factory for CreditCardPayment
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.processPayment(100.00);

        // Create a factory for PayPalPayment
        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        Payment payPalPayment = payPalFactory.createPayment();
        payPalPayment.processPayment(250.00);
    }
}
```

## Benefits
- **Adheres to the Open/Closed Principle**: Adding new payment methods doesn't affect existing code.
- **Encapsulates object creation logic**, making code easier to maintain and extend.

## Pitfalls
- **Can increase the number of classes**, leading to potential complexity.
- **Overhead in simpler scenarios** where a direct instantiation would suffice.
