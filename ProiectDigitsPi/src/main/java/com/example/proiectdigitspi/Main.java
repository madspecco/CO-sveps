package com.example.proiectdigitspi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;


import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(new File("C:/UPT/Second Year/Second Semester/CO/Project/ProiectDigitsPi/src/main/resources").toURI().toURL());
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("C:/UPT/Second Year/Second Semester/CO/Project/ProiectDigitsPi/src/main/resources"));
        primaryStage.setTitle("CPU Benchmark");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
