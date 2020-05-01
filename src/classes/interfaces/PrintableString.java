package classes.interfaces;

public class PrintableString implements Printable {
    private String str;

    PrintableString(String str) {
        this.str = str;
    }

    @Override
    public void print() {
        System.out.println(str);
    }
}
