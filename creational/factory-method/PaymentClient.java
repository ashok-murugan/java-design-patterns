//Factory Method for Payment Processing

// Step 1: Define the Product Interface
interface Payment {
    void processPayment(double amount);
}

// Step 2: Implement Concrete Products
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

// Step 3: Define the Creator Abstract Class
abstract class PaymentFactory {
    public abstract Payment createPayment();
}

// Step 4: Implement Concrete Factories
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

// PaymentClient
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