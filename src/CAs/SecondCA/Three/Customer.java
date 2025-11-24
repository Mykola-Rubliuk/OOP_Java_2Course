package CAs.SecondCA.Three;

public class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        setName(name);
        setEmail(email);
        setPhone(phone);
    }

    public Customer(Customer other) {
        setName(other.getName());
        setEmail(other.getEmail());
        setPhone(other.getPhone());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "No name specified";
        } else {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer details\n\nname "+ getName() + " email " + getEmail() + " phone " + getPhone();
    }
}
