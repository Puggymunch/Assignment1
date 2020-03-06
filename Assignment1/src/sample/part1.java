package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class part1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        HBox layout = new HBox();
        
        final int numCards = 3;
        Image[] cards = new Image[numCards];
        ImageView[] images = new ImageView[numCards];
        String fileName;
        
        //randomizerr
        Random rand = new Random();
        int randNum;

        // generate random cards
        for(int i=0; i<3; i++) {
            randNum = rand.nextInt(54);            //generate random number for the card
            fileName = "/Cards/"+(randNum + 1)+".png";    //generate file path and name
            cards[i] = new Image(fileName);               //load card image
            images[i] = new ImageView(cards[i]);
            layout.getChildren().add(images[i]);
        }

        //display
        primaryStage.setScene(new Scene(layout));
        primaryStage.setTitle("Question 1");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
