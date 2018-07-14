package me.tomisanhues2.client.games;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import me.tomisanhues2.client.GameClient;


public class Rps extends GameClient {

    private RpsOptions rpsOptions;

    public Rps() {
        setGame();
    }

    private void setGame() {
        HBox hBox = new HBox();
        VBox option;
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefWidth(800);
        for (RpsOptions options : RpsOptions.values()) {
            Button button = new Button(options.name());
            button.setFont(new Font(16));
            button.setPrefWidth(180);
            button.setOnAction(this::selectOption);
            option = new VBox();
            option.setPrefWidth(160);
            option.setPadding(new Insets(10));
            option.setAlignment(Pos.CENTER);
            option.getChildren().addAll(button);
            hBox.getChildren().add(option);
        }


        pane.setCenter(hBox);
    }

    private void selectOption(ActionEvent event) {
        String option = ((Button) event.getSource()).getText();
        for (int i = 0; i < 3; i++) {
            System.out.println(RpsOptions.values()[i].name());
            if (option.equalsIgnoreCase(RpsOptions.values()[i].name())) {
                rpsOptions = RpsOptions.values()[i];
                for (Node node : getPane().getChildren()) {
                    if (node instanceof Button) {
                        node.setDisable(true);
                    }
                }
            }
        }
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        hBox.setPrefWidth(1000);
        hBox.setPrefHeight(100);
        //BOTTOM-HIGH
        HBox hBoxH = new HBox();
        Label playerChoice = new Label("\bYou selected " + rpsOptions.name());
        playerChoice.setFont(new Font(22));
        hBoxH.getChildren().add(playerChoice);

        //BOTTOM-LOW
        HBox hBoxL = new HBox();
        ProgressBar progressBar = new ProgressBar(-1.0);
        progressBar.setProgress(-1.0);
        progressBar.setPrefSize(200,50);
        hBoxL.getChildren().add(progressBar);

        vBox.getChildren().addAll(hBoxH,hBoxL);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        hBox.getChildren().add(vBox);
        hBox.setAlignment(Pos.CENTER);

        pane.setBottom(hBox);
    }

}
