interface Payment {
    void processPayment(double amount);
}

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

public class PaymentClient {
    public static void main(String[] args) {
        // Process credit card payment
        Payment creditCardPayment = new CreditCardPayment();
        creditCardPayment.processPayment(100.00);

        // Process PayPal payment
        Payment payPalPayment = new PayPalPayment();
        payPalPayment.processPayment(250.00);
    }
}
