package CAs.SecondCA.Two;

public class Owner {
    private String name;
    private String address;
    private String phone;

    public Owner(String name, String address, String phone) {
        setName(name);
        setAddress(address);
        setPhone(phone);
    }

    public Owner(Owner other) {
        setName(other.getName());
        setAddress(other.getAddress());
        setPhone(other.getPhone());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " Name: " + name + " Address: " + address + " Phone: " + phone;
    }
}
