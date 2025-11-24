package CAs.SecondCA.Two;

import java.util.Arrays;

public class VetShop {
    private String name;
    private String address;
    private String phone;
    private String[] vets;
    private Pet[] pets;
    private Appointment[] appointments;

    public VetShop(String name, String address, String phone) {
        setName(name);
        setAddress(address);
        setPhone(phone);

        vets = new String[20];
        pets = new Pet[50];
        appointments = new Appointment[2000];

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

    public String[] getVets() {
        return Arrays.copyOf(vets, vets.length);
    }


    public Pet[] getPets() {
        return Arrays.copyOf(pets, pets.length);
    }


    public Appointment[] getAppointments() {
        return Arrays.copyOf(appointments, appointments.length);
    }

    public void addPet(Pet pet) {
        int petID = pet.getID();
        int lastDigitInID = petID % 10;
        pets[lastDigitInID] = pet;
    }

    public void addVet(String vet) {
        for (int i = 0; i < vets.length; i++) {
            if (vets[i] == null) {
                vets[i] = vet;
                break;
            }
        }
    }

    private String[] getBookedVets(String date, int hour) {
        String[] bookedVets = new String[vets.length];
        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] != null && appointments[i].getDate().equals(date) && appointments[i].getHour() == hour) {
                bookedVets[i] = appointments[i].getVet();
            }
        }
        return bookedVets;
    }

    private String[] getAvailableVets(String[] bookedVets) {
        String[] availableVets = new String[vets.length];
        for (int i = 0; i < vets.length; i++) {
            if (!linearSearch(bookedVets, vets[i])) {
                availableVets[i] = vets[i];
            }
        }
        return availableVets;
    }

    private boolean linearSearch(String[] bookedVets, String vet) {
        for (int i = 0; i < bookedVets.length; i++) {
            if (bookedVets[i] != null && bookedVets[i].equals(vet)) {
                return true;
            }
        }
        return false;
    }

    public void makeAppointment(String date, int hour, Pet pet) {
        int availableVetsCount = 0;
        String[] bookedVets = getBookedVets(date, hour);
        String[] availableVets = getAvailableVets(bookedVets);
        for (String availableVet : availableVets) {
            if (availableVet != null) {
                availableVetsCount++;
            }
        }

        if (availableVetsCount >= 1) {
            String[] nonNullVets = new String[availableVetsCount];
            int index = 0;
            for (String vet : availableVets) {
                if (vet != null) {
                    nonNullVets[index] = vet;
                    index++;
                }
            }
            int randomIndex = (int) (Math.random() * availableVetsCount);
            String randomVet = nonNullVets[randomIndex];
            Appointment newAppointment = new Appointment(date, hour, randomVet, pet);
            for (int i = 0; i < appointments.length; i++) {
                if (appointments[i] == null) {
                    appointments[i] = newAppointment;
                    break;
                }
            }
        } else {
            System.out.println("\nSorry, no vets are available at this time\n\n");
        }
    }


    @Override
    public String toString() {
        String output = "";
        output += "Initial state of the vet shop: \n\nName: " + getName() + "  Address: " + getAddress() + "  Phone: " + getPhone();
        output += "\n\nVets: " + Arrays.toString(Arrays.copyOf(vets, vets.length));
        output += "\n\nPets: ";
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] != null) {
                output += pets[i].toString();
            }
        }
        output += "\n\nAppointments: ";
        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] != null) {
                output += appointments[i].toString();
            }
        }
        return output;
    }
}
