//Builder Pattern : Building a Customer App


class Customer {
    //required fields
    private String email;
    private String name;

    //optinal fields
    private String phone;
    private String city;

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Customer(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

      public Customer(String email, String name, String phone , String city) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "Customer [ Email=" + email + ", Name=" + name + ", Phone=" + phone 
               + ", City=" + city + "]";
    }
}

public class CustomerApp {

    public static void main(String[] args) {

        Customer customer1 = new Customer("abc@gmail.com", "ABC");
        System.out.println(customer1.toString());

        Customer customer2 = new Customer("bcd@gmail.com", "BCD", "9876543210");
        System.out.println(customer2.toString());

        Customer customer3 = new Customer("cde@gmail.com", "CDE", "0123456789", "Chennai");
        System.out.println(customer3.toString());
    }
}


