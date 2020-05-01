package javafxapps;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class CircleColor extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) {
        Scene scene = new Scene(initInterface(), 640, 480);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private GridPane initInterface() {
        GridPane gp = new GridPane();
        //gp.setGridLinesVisible(true);

        ColorPicker cp1 = new ColorPicker(); // ctrl+p -- parameter
        ColorPicker cp2 = new ColorPicker();
        Label l1 = new Label("Цвет");
        Label l2 = new Label("Фон");
        Label l3 = new Label("Радиус");
        Slider s = new Slider();
        Circle c = new Circle(50);
        Pane p = new Pane();
        p.getChildren().add(c);

        s.setShowTickLabels(true);

        c.radiusProperty().bind(s.valueProperty());
        c.centerXProperty().bind(p.widthProperty().divide(2));
        c.centerYProperty().bind(p.heightProperty().divide(2));
        c.fillProperty().bind(cp1.valueProperty());
        s.maxProperty().bind(Bindings.min(p.heightProperty().divide(2), p.widthProperty().divide(2)));


        gp.add(l1, 0, 0);
        gp.add(cp1, 0, 1);
        gp.add(l2, 0, 2);
        gp.add(cp2, 0, 3);
        gp.add(l3, 0, 4);
        gp.add(s, 0, 5);
        gp.add(p, 1, 0, 1, 7);


        ColumnConstraints column1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        ColumnConstraints column2 = new ColumnConstraints();
        //добавить ограничения в панель
        gp.getColumnConstraints().addAll(column2, column1);

        RowConstraints row1 = new RowConstraints(0, 100, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row2 = new RowConstraints();
        //добавить ограничения в панель
        gp.getRowConstraints().addAll(row2, row2, row2, row2, row2, row2, row1);


        //p.setBackground(new Background(new BackgroundFill(Paint.valueOf("red"),null , null)));
        p.backgroundProperty().bind(
                Bindings.createObjectBinding(
                        () -> new Background(new BackgroundFill(cp2.getValue(), null, null)),
                        cp2.valueProperty()
                )
        );

        return gp;
    }
}
