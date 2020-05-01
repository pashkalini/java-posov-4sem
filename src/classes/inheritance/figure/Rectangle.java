package classes.inheritance.figure;

public class Rectangle implements Figure {
    private double h;
    private double w;

    public Rectangle(double h, double w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public double area() {
        return w * h;
    }

    @Override
    public double perimiter() {
        return 2 * (w + h);
    }

    @Override
    public String type() {
        return "прямоугольник";
    }
}
