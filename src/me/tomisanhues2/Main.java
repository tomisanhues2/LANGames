package me.tomisanhues2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import me.tomisanhues2.client.GameClient;

public class Main extends Application{
    public static void main(String[] args) {
/*        try {
            GameServer server = new GameServer(9090);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


      launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,1000,400);

        primaryStage.setScene(scene);
        primaryStage.show();
        GameClient gameClient = new GameClient(root);
    }
}
