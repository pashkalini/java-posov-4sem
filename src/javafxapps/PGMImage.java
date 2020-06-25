package javafxapps;

import java.io.PrintStream;

public class PGMImage {
    private int[][] pixelColors; // двумерный массив int[][] цветов пикселей изображения
    int width;
    int height;

    PGMImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixelColors = new int[width][height];
    }

    void setPixel(int x, int y, int color) {
        this.pixelColors[x][y] = color;
    }

    public void saveTo(String filename) throws Exception {
        PrintStream savedImage = new PrintStream(filename);
        savedImage.println("P2");
        savedImage.println(this.width + " " + this.height);
        savedImage.println("255");

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                savedImage.print(" " + this.pixelColors[j][i] + " ");
            }
        }
        savedImage.close();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
