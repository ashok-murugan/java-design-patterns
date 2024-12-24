# Builder Pattern

## What is the Builder Pattern?

The Builder Pattern is a creational design pattern that is used to construct complex objects step by step. It allows you to separate the construction of an object from its representation, enabling the creation of different representations of the same type of object.

## Why use the Builder Pattern?

- To create complex objects that require multiple configurations or optional parameters.
- To avoid constructors with too many parameters, making code cleaner and more manageable.
- To allow for flexible object construction.

##  Code Example: Building a Customer App

```java
//Builder Pattern for Customer App


class Customer {
    // Required fields
    private String email;
    private String name;

    // Optional fields
    private String phone;
    private String city;

    // Private constructor to restrict direct object creation
    private Customer(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
        this.phone = builder.phone;
        this.city = builder.city;
    }

    // Getter methods (optional, depending on your use case)
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer [Email=" + email + ", Name=" + name + ", Phone=" + phone + ", City=" + city + "]";
    }

    // Builder class inside Customer class
    public static class Builder {
        private String email;
        private String name;
        private String phone;
        private String city;

        // Constructor for required fields
        public Builder(String email, String name) {
            this.email = email;
            this.name = name;
        }

        // Setter for optional fields
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        // Build method to return the final Customer object
        public Customer build() {
            return new Customer(this);
        }
    }
}

public class CustomerApp {
    public static void main(String[] args) {

        // Creating customer using Builder pattern
        Customer customer1 = new Customer.Builder("abc@gmail.com", "ABC").build();
        System.out.println(customer1.toString());

        Customer customer2 = new Customer.Builder("bcd@gmail.com", "BCD")
                              .setPhone("9876543210")
                              .build();
        System.out.println(customer2.toString());

        Customer customer3 = new Customer.Builder("cde@gmail.com", "CDE")
                              .setPhone("0123456789")
                              .setCity("Chennai")
                              .build();
        System.out.println(customer3.toString());
    }
}
```

## Benefits
- **Separation of concerns**: The construction logic is encapsulated within the builder, making it easier to manage.
- **Flexible object creation**: You can easily create different types of user accounts without changing the client code.
- **Avoids large constructors**: Instead of having a constructor with many parameters, the builder pattern allows you to set only the required properties.

## Pitfalls
- **Increased complexity**: For simple objects, the builder pattern may introduce unnecessary complexity.
- **More classes**: If there are many types of objects to build, you may end up creating many builder classes.


