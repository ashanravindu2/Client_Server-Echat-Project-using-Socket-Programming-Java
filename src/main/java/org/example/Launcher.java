package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.handler.ServerHandler;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage s) throws Exception {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_form.fxml"))));
        stage.setTitle("Live Chat");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new javafx.scene.image.Image("/assets/icons8-chat-96.png"));
        stage.setOnCloseRequest(windowEvent -> {
            try {
                System.exit(0);
                ServerHandler.getInstance().closeServer();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}
