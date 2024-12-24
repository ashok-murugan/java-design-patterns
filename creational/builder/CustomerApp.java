//Builder Pattern : Building a Customer App


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
