package com.sveps.svepsfx;

import bench.cpu.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import logging.ConsoleLogger;
import timing.Timer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;


public class Controller
{
    Timer timer = new Timer();
    CPUDigitsOfPIBench cpu1 = new CPUDigitsOfPIBench();
    Digits4 cpu2 = new Digits4();
    //Digits3 cpu3 = new Digits3();
    Digits5 cpu4 = new Digits5();
    Cramer cpu5 = new Cramer();

    double avgScore = 0.0;
    int avg;
    long bestTime;
    String method;

    @FXML
    public Label warmupLabel;

    @FXML
    public TextField time;

    @FXML
    public Label stringErrorLabel;

    @FXML
    public Label piLabel;

    @FXML
    public Label piLabel2;

    @FXML
    public Label piLabel3;

    @FXML
    public Label piLabel4;

    @FXML
    public Label cramerLabel;

    @FXML
    public Label score;

    @FXML
    public Label best;


    //implement number checking
    @FXML
    private Label welcomeLabel;
    @FXML
    private TextField nrOfDigits;
    @FXML
    private Button runButton;

    int input;


    public static boolean isFileExists(File file){
        return file.isFile();
    }

    public Controller() throws IOException {
    }

    public void execute(ActionEvent event) throws InterruptedException, IOException {

        try {
            long stop;
            warmup();



            String desktopPath =System.getProperty("user.home") + "\\"+"Desktop" + "\\"+"results.txt";

            System.out.println(desktopPath);


            File file = new File(desktopPath);
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);




            pw.append("\nNumber of digits: " + nrOfDigits.getText() +"\n");

            cpu1.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu1.run();
            stop = timer.stop();

            pw.append("First Nilakantha time: " + stop +" nanoseconds\n");

            piLabel.setTextFill(Color.web("#ffffff", 1));
            piLabel.setText("First Nilakantha CPU computation took " + stop + " nanoseconds.");
            bestTime = stop;
            avgScore += stop / Double.parseDouble(nrOfDigits.getText());
            method = "First Nilakantha";

            cpu2.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu2.run();
            stop = timer.stop();

            pw.append("Second Nilakantha time: " + stop +" nanoseconds\n");

            piLabel2.setTextFill(Color.web("#ffffff", 1));
            piLabel2.setText("Second Nilakantha CPU computation took " + stop + " nanoseconds");
            avgScore += stop / Double.parseDouble(nrOfDigits.getText());
            if (stop < bestTime) {
                bestTime = stop;
                method = "Second Nilakantha";
            }

            cpu4.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu4.run();
            stop = timer.stop();

            pw.append("Arithmetic-Geometric time: " + stop +" nanoseconds\n");

            piLabel4.setTextFill(Color.web("#ffffff", 1));
            piLabel4.setText("Arithmetic-Geometric mean CPU computation took " + stop + " nanoseconds.");
            avgScore += stop / Double.parseDouble(nrOfDigits.getText());
            if (stop < bestTime) {
                bestTime = stop;
                method = "Arithmetic-Geometric mean";
            }

            cpu5.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu5.run();
            stop = timer.stop();

            pw.append("Cramer time: " + stop +" nanoseconds\n");

            cramerLabel.setTextFill(Color.web("#ffffff", 1));
            cramerLabel.setText("Cramer CPU computation took " + stop + " nanoseconds.");
            avgScore += stop / Double.parseDouble(nrOfDigits.getText());
            if (stop < bestTime) {
                bestTime = stop;
                method = "Cramer";
            }

            avgScore = 4.0 / avgScore * 1000000000;

            pw.append("Score: " + avgScore+"\n");

            avg = (int) Math.round(avgScore);
            score.setTextFill(Color.web("#ffffff", 1));
            score.setText("Average score: " + avg + " points");

            best.setTextFill(Color.web("#ffffff", 1));
            best.setText("The best method was " + method + " and it took " + bestTime + " nanoseconds.");


            pw.close();


        } catch (NumberFormatException e) {
            welcomeLabel.setText("That's OK. Seems like you did not enter a number. Try again!");
            nrOfDigits.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d*")) {
                        nrOfDigits.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        } catch (Exception e) {
            welcomeLabel.setText("I don't know buddy, something went wrong!");
        }

    }


    // WARM UP
    public void warmup() throws InterruptedException
    {
        for (int i = 1; i <= 100000; i++) {
            for (int j = 1; j <= 100000; j++)
            {
                warmupLabel.setText("Warm-up Completed!");
                //warmupLabel.setTextFill(Color.web("#ffffff", 1));
            }

        }
    }
}