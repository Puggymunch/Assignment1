package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.Random;

public class part3 extends Application {
    private int radius = 100;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Circle circle0 = new Circle(radius);
        circle0.setCenterX(150);
        circle0.setCenterY(150);
        circle0.setStroke(Color.BLACK);
        circle0.setFill(Color.WHITE);

        //dotPos = new double [3];
        //sideLengths = new double[3];

        Pane pane = new Pane();
        primaryStage.setTitle("Question 3");
        primaryStage.setScene(new Scene(pane, 300, 300));
        pane.getChildren().add(circle0);
        //pane.getChildren().add(dots);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
