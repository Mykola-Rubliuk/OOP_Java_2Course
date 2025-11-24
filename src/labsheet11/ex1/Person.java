package labsheet11.ex1;

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        setName(firstName, lastName);
    }

    public Person(){
        this("Not Supplied", "Not Supplied");
    }
    public void setName(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString(){
        return "First name "  + getFirstName() + " Last name " + getLastName() + "\n";
    }
}
