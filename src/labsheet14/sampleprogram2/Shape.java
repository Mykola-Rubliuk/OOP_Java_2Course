package labsheet14.sampleprogram2;

//Shape.java
/*An abstract class defining a generic shape*/

public abstract class Shape {

    protected String type;

    public Shape(String type) {
        setType(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract double area();

    public abstract double perimeter();
}