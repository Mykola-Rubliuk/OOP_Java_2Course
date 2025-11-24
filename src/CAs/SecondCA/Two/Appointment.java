package CAs.SecondCA.Two;

public class Appointment {
    private String date;
    private int hour;
    private String vet;
    private Pet pet;
    private char status = 'A';
    private static int counter;

    public Appointment(String date, int hour, String vet, Pet pet) {
        setDate(date);
        setHour(hour);
        setVet(vet);
        setPet(pet);
        setStatus(status);

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public static int getCounter() {
        return counter;
    }



    @Override
    public String toString() {
        return "\nDate: " + getDate() + " Hour: " + getHour() + " Vet: " + getVet() +  "\n Pet: " + getPet() + " Status: " + getStatus();
    }
}
