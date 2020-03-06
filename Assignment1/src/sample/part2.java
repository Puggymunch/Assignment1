package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.text.DecimalFormat;

public class part2 extends Application {

    private Label amountL, yearsL, interestL, futureL; //years could be int but simplicity's sake makes it easier to be double
    private TextField amountT, yearsT, interestT, finalT;
    private Button calculate;
    private DecimalFormat df;

    @Override
    public void start(Stage stage) throws Exception {

        //Make max amount of decimals to be 2
        df = new DecimalFormat("0.00");

        BorderPane pane = new BorderPane();
        pane.setTop(getGridPane());
        pane.setBottom(getHBox());
        stage.setScene(new Scene(pane));
        stage.setTitle("Question 2");
        stage.show();
    }

    //Catch any exceptions if user input is incorrect
    private double isDouble(TextField field) {
        try {
            double value = Double.parseDouble(field.getText());
            return value;
        } catch(NumberFormatException e) {
            field.setText("Error");
            return -1;
        }
    }

    private GridPane getGridPane() {

        //initializing gPane
        GridPane gPane = new GridPane();
        gPane.setVgap(0);
        gPane.setHgap(5);
        gPane.setPadding(new Insets(10, 10, 0, 10));

        amountL = new Label("Initial Investment");
        yearsL = new Label("Years");
        interestL = new Label("Annual Interest Rate");
        futureL =  new Label("Final Value");

        //text field declarations
        amountT = new TextField();
        amountT.setAlignment(Pos.BASELINE_RIGHT);
        yearsT = new TextField();
        yearsT.setAlignment(Pos.BASELINE_RIGHT);
        interestT = new TextField();
        interestT.setAlignment(Pos.BASELINE_RIGHT);
        finalT = new TextField();
        finalT.setAlignment(Pos.BASELINE_RIGHT);
        finalT.setStyle("-fx-background-color: #F2F2F2;");

        //adding to gPane
        gPane.add(amountL, 0, 0);
        gPane.add(yearsL, 0, 1);
        gPane.add(interestL, 0, 2);
        gPane.add(futureL, 0, 3);
        gPane.add(amountT, 1, 0);
        gPane.add(yearsT, 1, 1);
        gPane.add(interestT, 1, 2);
        gPane.add(finalT, 1, 3);


        return gPane;
    }

    private HBox getHBox() {

        //initializing hbox
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 10, 10, 0));

        // button declaration
        calculate = new Button("Calculate");

        // set button action
        calculate.setOnAction(e -> {
            finalT.setText("");
            double finalAmount;
            double initAmount = isDouble(amountT);
            double years = isDouble(yearsT);
            double interest = isDouble(interestT);
            finalAmount = calculateInterest(initAmount, years, interest);
            if(initAmount >= 0 && years >= 0 && interest >= 0)
                finalT.setText(""+df.format(finalAmount));
        });
        hBox.getChildren().add(calculate);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        return hBox;
    }

    // calculate future investment
    private double calculateInterest(double amount, double years, double interest) {
        double finalAmount = (amount * (Math.pow((1 + interest / 1200), (years * 12))));
        return finalAmount;
    }

    public static void main(String[] args) { launch(args); }
}