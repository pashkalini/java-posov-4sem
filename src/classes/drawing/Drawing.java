package classes.drawing;

import classes.interfaces.Printable;

import java.util.Arrays;

public class Drawing implements Printable {
    private char[][] draw;

    public Drawing(int h, int w, char s) {
        // количество строк
        // количество столбцов
        //симавол, которым изначально всё заполнить
        this.draw = new char[h][w];
        for (char[] chars : draw) {
            Arrays.fill(chars, s);
        }
    }

    public void print() {
        for (char[] line : draw) {
            for (char x : line)
                System.out.print(x + "  ");
            System.out.println();
        }
    }

    //3) Метод setPoint(x, y, char) рисует один символ в изображении.
    // Методу нужно указать, где и какой символ поставить.
    public void setPoint(int x, int y, char s) {
        draw[y][x] = s;
    }

    //4) Методы drawVerticalLine(...), drawHorizontalLine(...) рисуют
    // вертикальную
    // или горизонтальную линию от заданной точки до заданной.
    // Определите сами параметры для методов,
    // они должны определять расположение линии и символ, которым линию
    // рисовать.
    public void drawHorizontalLine(int x1, int x2, int y, char s) {
        for (int i = x1; i <= x2; i++)
            draw[y][i] = s;
    }

    public void drawVerticalLine(int x, int y1, int y2, char s) {
        for (int i = y1; i <= y2; i++)
            draw[i][x] = s;
    }

    //5) Метод drawRectangle() рисует прямоугольник по двум противоположным
    // углам, стороны прямоугольника вертикальны и горизонтальны.
    // Используйте методы, реализованные ранее.
    public void drawRectangle(int x1, int y1, int x2, int y2, char s) {
        //(x1, y1) - верхняя левая точка; (x2, y2) - нижняя правая точка
        // (x1, y2) - нижняя левая; (x2, y1) - верхняя левая
        drawHorizontalLine(x1, x2, y1, s); //верхняя сторона
        drawHorizontalLine(x1, x2, y2, s); // нижняя сторона
        drawVerticalLine(x1, y1, y2, s); //левая сторона
        drawVerticalLine(x2, y1, y2, s); //правая сторона
    }

    public int getHeight() {
        int cnt = 0;

        for (char[] line : draw)
            cnt += 1;

        return cnt;
    }

    public int getWidth() {
        int cnt = 0;

        for (char[] line : draw) {
            for (char x : line)
                cnt += 1;
        }

        return cnt / getHeight();
    }

    //7) Рисование круга
    public void drawCircle(int x, int y, int r, char s) {
        setPoint(x, y, '@');

        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                int deltaX = i - x;
                int deltaY = j - y;

                if (deltaX * deltaX + deltaY * deltaY <= r * r)
                    draw[j][i] = s;
            }
        }
    }

    //8) Реализуйте метод draw(x, y, Drawing d) нарисовать одно изображение на другом.
    // При вызове метода указывается, где и какое изображение рисовать.
    public void drawOn(int x, int y, Drawing d) {
        for (int i = 0; i < d.getWidth(); i++) {
            for (int j = 0; j < d.getHeight(); j++) {
                draw[y + j][x + i] = d.draw[j][i];
            }
        }
    }

    //10) Используйте все реализованные вами ранее методы, чтобы нарисовать домик.
    public void drawHouse() {
        this.drawRectangle(10, 20, 40, 48, '*');
    }
}
