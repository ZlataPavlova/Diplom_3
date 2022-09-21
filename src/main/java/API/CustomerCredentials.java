package API;

public class CustomerCredentials {
    private String email;
    private String password;
    private String name;

    public CustomerCredentials(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static CustomerCredentials from(Customer customer) {
        return new CustomerCredentials(customer.getEmail(), customer.getPassword(), customer.getName());
    }


}
