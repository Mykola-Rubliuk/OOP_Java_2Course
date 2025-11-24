package CAs.SecondCA.Two;

public class TestVetShop {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Timmy Clifford", "72 Spa Rd., Tralee, Co Kerry", "085-2891234");
        Owner owner2 = new Owner("Mary O Connor", "32 Park Rd., Killarney, Co Kerry", "083-1231256");

        Pet pet1 = new Pet("Fido", "Dog", "10-01-2020", "16-08-2019", owner1);
        Pet pet2 = new Pet("Rascal", "Cat", "21-03-2017", "01-03-2016", owner2);
        Pet pet3 = new Pet("Sammy", "Snake", "02-11-2022", "14-05-2022", owner2);

        VetShop vetShop = new VetShop("McGrath's Vet Centre", "Rock St., Tralee, Co. Kerry", "087-5342571");

        vetShop.addPet(pet1);
        vetShop.addPet(pet2);
        vetShop.addPet(pet3);

        vetShop.addVet("Justin Flaherty");
        vetShop.addVet("Bridget Mulcahy");

        vetShop.makeAppointment("24-02-2020", 15, pet1);
        vetShop.makeAppointment("24-02-2020", 15, pet2);
        vetShop.makeAppointment("24-02-2020", 15, pet3);

        System.out.println(vetShop);

    }
}
