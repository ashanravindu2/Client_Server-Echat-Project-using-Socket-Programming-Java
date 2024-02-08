package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.model.UserModel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    public AnchorPane pane;
    public TextField txtUserName;
    public TextField txtPass;
    public Rectangle profileImg;
    private String profileURL ;

    UserModel userModel = new UserModel();
    public void initialize(){

        profileImg.setFill(new javafx.scene.paint.ImagePattern(new javafx.scene.image.Image("assets/registercamera.png")));

    }

    public void btnCreateOnAction(ActionEvent actionEvent) throws SQLException {
        if (profileURL==null){
            profileURL = "assets/icons8-male-user-100.png";
        }

    if (!txtUserName.getText().isEmpty()&&txtUserName.getText().matches("[A-Za-z]+")){
        if (!txtPass.getText().isEmpty()&&txtPass.getText().matches("[A-Za-z0-9]+")) {
            boolean isValid = userModel.exists(txtUserName.getText());
            if (isValid){
                new Alert(Alert.AlertType.ERROR, "User already exists").show();
            }else {
                boolean isRegister = userModel.register(txtUserName.getText(), txtPass.getText(), profileURL);
                if (isRegister){
                    new Alert(Alert.AlertType.CONFIRMATION, "User created successfully").show();
                }
            }
        }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please enter your name").show();
        }

    }

    public void getLogInPageAction(MouseEvent mouseEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.pane.getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
    }

    public void selectProfilePicAction(MouseEvent mouseEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Image File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
            );
            File selectedFile = fileChooser.showOpenDialog(null);
            profileImg.setFill(new javafx.scene.paint.ImagePattern(new javafx.scene.image.Image(selectedFile.toURI().toString())));
            String selectFile = selectedFile.getAbsolutePath();
            profileURL= selectFile;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void btnEnterOnAction(KeyEvent keyEvent) throws SQLException {
        if (keyEvent.getCode().toString().equals("ENTER")) {
            try {
                btnCreateOnAction(new ActionEvent());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
