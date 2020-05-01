package classes.drawing;

public class DrawingTest {
    public static void main(String[] args) {
        Drawing d1 = new Drawing(5, 10, '.');
        d1.print();

        d1.setPoint(3, 3, '#');
        System.out.println();
        d1.print();
        System.out.println();

        d1.drawVerticalLine(2, 2, 4, '|');
        d1.print();
        System.out.println();

        d1.drawHorizontalLine(2, 9, 1, '—');
        d1.print();
        System.out.println();

        Drawing d2 = new Drawing(10, 20, '.');
        d2.drawRectangle(1, 1, 4, 4, '*');
        d2.print();

        System.out.println(d2.getWidth());
        System.out.println(d2.getHeight());

        System.out.println(d1.getWidth());
        System.out.println(d1.getHeight());

        Drawing d3 = new Drawing(49, 49, '.');
        d3.drawCircle(24, 24, 20, '*');
        d3.print();
        System.out.println();

        Drawing d4 = new Drawing(20, 20, '.');
        d4.drawOn(5, 5, d1);
        d4.print();
        System.out.println();

        Drawing d5 = new Drawing(49, 49, '.');
        d5.drawHouse();
        d5.print();
    }
}
