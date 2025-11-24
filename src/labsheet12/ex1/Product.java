package labsheet12.ex1;

//Product.java
/*A simple instantiable class definition for a Product*/

public class Product {
    private static int count = 1000000;
    private int id;
    private String name;
    private String description;

    public Product(String name, String description) {
        setId();
        setName(name);
        setDescription(description);
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
       this.id = ++count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Product details are as follows: id: " + getId() + "  name: " + getName() + "  description: " + getDescription();
    }
}

