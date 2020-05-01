package classes.inheritance.figure;

public class FigureTest {
    public static void main(String[] args) {
        Circle f1 = new Circle(3);
        System.out.println(f1.toString());

        Figure f2 = new Square(5);
        System.out.println(f2.toString());
    }
}
