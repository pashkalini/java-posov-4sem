package javafxapps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class Messenger extends Application {
    @Override
    public void start(Stage mainStage) {
        Scene scene = new Scene(initInterface(), 640, 480);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private HBox initInterface() {
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb1 = new HBox();
        HBox mainHB = new HBox();

        Button b = new Button("Send");
        TextArea ta = new TextArea();
        TextField tf = new TextField();
        Label l = new Label("Contacts");
        ListView<String> lv = new ListView<>();

        EventHandler<ActionEvent> h = ActionEvent -> {
            ta.appendText(tf.getText() + "\n");
        };
        b.addEventHandler(ActionEvent.ACTION, h);
        tf.addEventHandler(ActionEvent.ACTION, h);

        b.setOnAction(h);

        lv.setMinWidth(400);
        hb1.getChildren().addAll(tf, b); // TextField
        vb1.getChildren().addAll(ta, hb1); // left side
        vb2.getChildren().addAll(l, lv); // Right side
        VBox.setVgrow(ta, Priority.ALWAYS);
        VBox.setVgrow(lv, Priority.ALWAYS);
        HBox.setHgrow(tf, Priority.ALWAYS);
        mainHB.getChildren().addAll(vb1, vb2);
        HBox.setHgrow(vb1, Priority.ALWAYS);


        return mainHB;
    }

}
