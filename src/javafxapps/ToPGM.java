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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ToPGM extends Application {
    private Window mainStage;

    public void start(Stage mainStage) throws FileNotFoundException {
        Scene scene = new Scene(initInterface(), 360, 512);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private VBox initInterface() throws FileNotFoundException {
        VBox vb = new VBox();
        Button b = new Button("Choose image");
        FileChooser fileChooser = new FileChooser();
        ImageView iv = new ImageView();

        b.setOnAction(e -> {
            File chosenImage = fileChooser.showOpenDialog(mainStage);
            saveAsPGM(chosenImage);
            iv.setImage(saveAsPGM(chosenImage));
            vb.getChildren().addAll(new Label(getImageName(chosenImage)), iv);

        });

        vb.getChildren().addAll(b);
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

}
