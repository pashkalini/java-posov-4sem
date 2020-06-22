package javafxapps;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Drawing extends Application {
    public void start(Stage mainStage) throws FileNotFoundException {
        Scene scene = new Scene(initInterface(), 360, 512);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private VBox initInterface() throws FileNotFoundException {
        VBox mainVB = new VBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();

        WritableImage wi1 = new WritableImage(120, 100);
        PixelWriter pw1 = wi1.getPixelWriter();

        for (int x = 0; x < 120; x++)
            for (int y = 0; y < 100; y++)
                pw1.setColor(x, y, Color.GREEN);


        WritableImage wi2 = new WritableImage(256, 256);
        PixelWriter pw2 = wi2.getPixelWriter();

        for (int x = 0; x < 256; x++)
            for (int y = 0; y < 256; y++)
                pw2.setColor(x, y, Color.rgb(0, x, y));


        WritableImage wi3 = new WritableImage(256, 256);
        PixelWriter pw3 = wi3.getPixelWriter();

        for (int x = 0; x < 256; x++)
            for (int y = 0; y < 256; y++)
                pw3.setColor(x, y, Color.rgb(x, x, y));


        WritableImage wi4 = new WritableImage(360, 100);
        PixelWriter pw4 = wi4.getPixelWriter();

        for (int x = 0; x < 360; x++)
            for (int y = 0; y < 100; y++)
                pw4.setColor(x, y, Color.hsb(x, y / 99.0, 1));

        WritableImage wi5 = new WritableImage(360, 140);
        PixelWriter pw5 = wi5.getPixelWriter();

        for (int x = 0; x < 360; x++)
            for (int y = 0; y < 100; y++)
                pw5.setColor(x, y, LCH.colorFromLCH(80, y, x));


        ImageView iv1 = new ImageView(wi1);

        ImageView iv2 = new ImageView(wi2);
        iv2.setFitHeight(100);
        iv2.setFitWidth(120);

        ImageView iv3 = new ImageView(wi3);
        iv3.setFitHeight(100);
        iv3.setFitWidth(120);

        ImageView iv4 = new ImageView(wi4);
        ImageView iv5 = new ImageView(wi5);

        Image image = new Image(new FileInputStream("src\\javafxapps\\green_room.jpg"),
                128, 128, false, false);
        ImageView iv6 = new ImageView(image);
       /* iv6.setFitWidth(256);
        iv6.setFitHeight(256);*/
        PixelReader pr = image.getPixelReader();

        WritableImage wi7 = new WritableImage(128, 128);
        PixelWriter pw7 = wi7.getPixelWriter();

        for (int x = 0; x < 128; x++)
            for (int y = 0; y < 128; y++)
                pw7.setColor(x, y, Color.hsb(
                        0,
                        0,
                        0.2126 * pr.getColor(x, y).getRed()
                                + 0.7152 * pr.getColor(x, y).getGreen()
                                + 0.0722 * pr.getColor(x, y).getBlue())
                );

        ImageView iv7 = new ImageView(wi7);

        hb1.getChildren().addAll(iv1, iv2, iv3);
        hb2.getChildren().addAll(iv6, iv7);
        mainVB.getChildren().addAll(hb1, iv4, iv5, hb2);

        return mainVB;
    }
}
