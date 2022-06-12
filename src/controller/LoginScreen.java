package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    public TextField userIDField;
    public TextField passwordField;
    public Button loginButton;
    public Button exitButton;
    public Label locationLabel;
    public ChoiceBox<String> languageBox;

    private String[] languages = {"English","French"};



    /**
     *  Login button changes the scene to the main screen upon a successful login
     * @param actionEvent Changes the scene
     * @throws IOException exception to prevent I/O failure
     */
    public void onLoginButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    /**
     *  Exits the applications
     * @param actionEvent System.exit closes the application
     */
    public void onExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        languageBox.getItems().addAll(languages);
        languageBox.setValue("English");
    }
}
