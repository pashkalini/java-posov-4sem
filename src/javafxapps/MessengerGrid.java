package javafxapps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MessengerGrid extends Application {
    @Override
    public void start(Stage mainStage) {
        Scene scene = new Scene(initInterface(), 640, 480);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private GridPane initInterface() {
        GridPane gp = new GridPane();

        Button b = new Button("Send");
        TextArea ta = new TextArea();
        TextField tf = new TextField();
        Label l = new Label("Contacts");
        ListView<String> lv = new ListView<>();

        gp.add(ta, 0, 0, 2, 2);
        gp.add(tf, 0, 2);
        gp.add(b, 1, 2);
        gp.add(l, 2, 0);
        gp.add(lv, 2, 1, 1, 2);

        ColumnConstraints column1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        ColumnConstraints column2 = new ColumnConstraints();
        //добавить ограничения в панель
        gp.getColumnConstraints().addAll(column1, column2, column2);

        RowConstraints row1 = new RowConstraints(0, 100, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row2 = new RowConstraints();
        //добавить ограничения в панель
        gp.getRowConstraints().addAll(row2, row1, row2);

        //lv.setMaxHeight(Double.MAX_VALUE);
        lv.setPrefHeight(0);

        return gp;
    }
}
