package labsheet14.sampleprogram2;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle() {
        super("Rectangle");
        setLength(0);
        setWidth(0);
    }

    public Rectangle(double length, double width) {
        super("Rectangle");
        setLength(length);
        setWidth(width);
    }

    public void setLength(double length) {
        if (length>0)
            this.length = length;
        else
            this.length = 0;
    }

    public void setWidth(double width) {
        if (width>0)
            this.width = width;
        else
            this.width = 0;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double area() {
        return getLength()*getWidth();
    }

    public double perimeter() {
        return 2*getLength()+2*getWidth();
    }

    public String toString() {
        return "Shape type: " + type + "\nArea: " + area() + "\nPerimeter: " + perimeter();
    }

}
