package classes.interfaces;

public class PrintableLetter implements Printable {
    private String letter;
    private int cnt;

    public PrintableLetter(String letter, int cnt) {
        this.letter = letter;
        this.cnt = cnt;
    }

    @Override
    public void print() {
        for (int i = 1; i <= cnt; i++) {
            System.out.println(letter);
        }
    }
}
