package classes.inheritance.figure;

public class Circle implements Figure {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimiter() {
        return 2 * Math.PI * r;
    }

    @Override
    public String type() {
        return "круг";
    }
}
