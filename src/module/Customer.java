package module;

public class Customer {
    private String ID;
    private String name;
    private String email;
    private String phone;

    public Customer() {}
    public Customer(String ID, String name, String email, String phone) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public Customer(Customer customer) {
        this.ID = customer.ID;
        this.name = customer.name;
        this.email = customer.email;
        this.phone = customer.phone;
    }

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
