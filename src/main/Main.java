package main;

import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml/"));
        stage.setTitle("C195 Appointment Manager");
        stage.setScene(new Scene(root, 800, 425));
        stage.show();
    }


    public static void main(String[] args){

        JDBC.openConnection();
        System.out.println("Current Business Date/Time: " + LocalDateTime.now(ZoneId.of("America/New_York")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("Current System Date/Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        launch(args);
        JDBC.closeConnection();


    }
}
