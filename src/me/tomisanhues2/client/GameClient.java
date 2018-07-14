package me.tomisanhues2.client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import me.tomisanhues2.client.games.Rps;
import me.tomisanhues2.res.GameList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class GameClient {

    protected static BorderPane pane;
    protected Socket socket;

    public GameClient(String serverAddress, int port) throws IOException{
        socket = new Socket(serverAddress,port);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }

    public GameClient() {

    }

    public GameClient(BorderPane pane) {
        this.pane = pane;
        showGames();
        System.out.println(getPane().getChildren().toString());
    }

    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }


    private void showGames() {


        HBox centerHBox = new HBox();
        VBox game;
        Label title;
        centerHBox.setAlignment(Pos.CENTER);
        centerHBox.setPrefWidth(1000);
        for (int i = 0; i < GameList.values().length; i++) {
            title = new Label(GameList.getDisplayName(GameList.values()[i]));
            title.setFont(new Font(16));
            Button button = new Button("Select");
            button.setPrefWidth(180);
            button.setOnAction(event -> startRpsGame());
            game = new VBox();
            game.setMaxWidth((pane.getWidth() / GameList.values().length) - 100);
            game.setPrefWidth((200));
            game.setPadding(new Insets(10));
            game.setAlignment(Pos.CENTER);
            game.getChildren().addAll(title,button);
            centerHBox.getChildren().add(game);
        }
        pane.setCenter(centerHBox);
    }

    private void startRpsGame() {
        Rps rps = new Rps();
    }

}
