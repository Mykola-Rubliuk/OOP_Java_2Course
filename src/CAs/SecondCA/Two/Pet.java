package CAs.SecondCA.Two;

public class Pet {
    private static int count = 10000;
    private int ID;
    private String name;
    private String type;
    private String registrationDate;
    private String dateOfBirth;
    private Owner owner;

    public Pet(String name, String type, String registrationDate, String dateOfBirth, Owner owner) {
        setName(name);
        setType(type);
        setRegistrationDate(registrationDate);
        setDateOfBirth(dateOfBirth);
        setOwner(owner);
        setID();
    }

    public int getID() {
        return ID;
    }

    private void setID() {
        count++;
        this.ID = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Owner getOwner() {
        return new Owner(this.owner);
    }

    public void setOwner(Owner owner) {
        this.owner = new Owner(owner);
    }

    @Override
    public String toString() {
        return "\nID: " + getID() + "  Name: " + getName() + "  Type: " + getType() + "  RegistrationDate: " + getRegistrationDate() + "  Date of Birth: " + getDateOfBirth() + "\nOwner details : " + getOwner();
    }
}
