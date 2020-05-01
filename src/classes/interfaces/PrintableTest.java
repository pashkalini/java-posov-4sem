package classes.interfaces;

import classes.drawing.Drawing;

public class PrintableTest {
    public static void main(String[] args) {
        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print(); //печатает букву x 10 раз

        PrintableString ps = new PrintableString("asdf");
        ps.print(); //печатает asdf
        Drawing d1 = new Drawing(5, 10, '.');
        Printable[] Arr = {d1, pl, ps};

        for (Printable element : Arr)
            element.print();
    }
}
