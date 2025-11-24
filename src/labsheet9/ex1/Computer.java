package labsheet9.ex1;

public class Computer {
    private String manufacturer;
    private String type;
    private double speed;
    private int RAM;
    private double price;

    public Computer() {
        this("Not available", "Not available", 0, 0, 0);
    }

    public Computer(String manufacturer, String type, double speed, int RAM, double price) {
        this.manufacturer = manufacturer;
        this.type = type;
        setSpeed(speed);
        setRAM(RAM);
        setPrice(price);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public int getRAM() {
        return RAM;
    }

    public double getPrice() {
        return price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpeed(double speed) {
         this.speed = Math.max(speed, 0);
    }

    public void setRAM(int RAM) {
        this.RAM = Math.max(RAM, 0);
    }

    public void setPrice(double price) {
         this.price = Math.max(price, 0);
    }

    public String toString() {
        return "Manufacturer: " + getManufacturer() + " Type: " + getType() + " Speed: " + getSpeed()

                + " RAM: " + getRAM() + " Price: " + getPrice();
    }
}