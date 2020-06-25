package javafxapps;

public class PGMImageTest {
    public static void main(String[] args) throws Exception {
        PGMImage img1 = new PGMImage(80, 60);
        PGMImage img2 = new PGMImage(80, 60);

        // заполняем img1 случайными числами от 0 до 255
        for (int i = 0; i < img1.height; i++) {
            for (int j = 0; j < img1.width; j++)
                img1.setPixel(j, i, (int) (Math.random() * 256));
        }
        img1.saveTo("img1.pgm");

        for (int i = 0; i < img2.height; i++) {
            for (int j = 0; j < img2.width; j++)
                img2.setPixel(j, i, (i + j) % 256);
        }
        img2.saveTo("img2.pgm");
    }
}
