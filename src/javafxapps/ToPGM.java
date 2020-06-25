package javafxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ToPGM extends Application {
    private Window mainStage;

    public void start(Stage mainStage) throws FileNotFoundException {
        Scene scene = new Scene(initInterface(), 360, 512);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private VBox initInterface() throws FileNotFoundException {
        VBox vb = new VBox();
        Button b1 = new Button("Choose image to PGM");
        Button b2 = new Button("Choose image from PGM");
        FileChooser fileChooser = new FileChooser();
        ImageView iv1 = new ImageView();

        b1.setOnAction(e -> {
            File chosenImage = fileChooser.showOpenDialog(mainStage);
            saveAsPGM(chosenImage);
            iv1.setImage(saveAsPGM(chosenImage));
            vb.getChildren().addAll(new Label(getImageName(chosenImage)), iv1);
        });

        b2.setOnAction(e -> {
            File chosenImage = fileChooser.showOpenDialog(mainStage);
            saveAsPNG(chosenImage);
            vb.getChildren().addAll(new Label(getImageName(chosenImage)));
        });

        vb.getChildren().addAll(b1, b2);
        return vb;
    }

    private String getImageName(File image) { // получаем имя выбранного изображения
        return image.getName();
    }

    private Image saveAsPGM(File chosenImage) { // сохраняем картинку в формате PGM
        ImageView iv = new ImageView();

        Image image;
        try {
            image = new Image(new FileInputStream(chosenImage),
                    128, 128, false, false);
            iv.setImage(image);
            iv.setFitHeight(128);
            iv.setFitWidth(128);

            PixelReader pr = image.getPixelReader();
            PGMImage newPGM = new PGMImage(128, 128);

            for (int x = 0; x < newPGM.getHeight(); x++)
                for (int y = 0; y < newPGM.getWidth(); y++)
                    newPGM.setPixel(x, y,
                            (int) (
                                    (0.2126 * pr.getColor(x, y).getRed()
                                            + 0.7152 * pr.getColor(x, y).getGreen()
                                            + 0.0722 * pr.getColor(x, y).getBlue()
                                    ) * 255)
                    );
            newPGM.saveTo(getImageName(chosenImage) + ".pgm");
            return image;
        } catch (Exception fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return null;
        }
    }

    private void saveAsPNG(File chosenImage) {  // сохраняем картинку из PGM в PNG
        try {
            Path imagePath = Path.of(String.valueOf(chosenImage));
            Scanner scan = new Scanner(imagePath, StandardCharsets.UTF_8);
            scan.next(); // пропускаем P2
            int width = Integer.parseInt(scan.next()); // считываем длину картинки
            int height = Integer.parseInt(scan.next()); // считываем высоту картинки
            int maxValue = Integer.parseInt(scan.next()); // считываем максимальное значение цвета

            WritableImage wi = new WritableImage(width, height);
            PixelWriter pw = wi.getPixelWriter();

            for (int i = 0; i < height; i++) { //  задаём цвет нового изображения
                for (int j = 0; j < width; j++) {
                    pw.setColor(j, i,
                            Color.gray((double) Integer.parseInt(scan.next()) / maxValue));
                }
            }

            File outputFile = new File("PNGfromPMG.png");
            BufferedImage bImage = SwingFXUtils.fromFXImage(wi, null);
            ImageIO.write(bImage, "png", outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
