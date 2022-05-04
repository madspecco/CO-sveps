package com.example.proiectdigitspi;

import bench.CPUDigitsOfPIBench;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import bench.cpu.*;
import logging.ConsoleLogger;
import timing.Timer;


public class Controller {
    Timer timer = new Timer();
    CPUDigitsOfPIBench cpu1 = new CPUDigitsOfPIBench();
    Digits4 cpu2 = new Digits4();
    Digits3 cpu3 = new Digits3();
    Digits5 cpu4 = new Digits5();
    Cramer cpu5 = new Cramer();

    double avgScore = 0.0;
    int avg;
    long bestTime;
    String method;

    @FXML
    public TextField nrOfDigits;

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

    public void warmup() throws InterruptedException {
        for (int i = 1; i <= 100000; i++) {
            for (int j = 1; j <= 100000; j++) {
                CPUDigitsOfPIBench test = new CPUDigitsOfPIBench();
                ConsoleLogger test2 = new ConsoleLogger();
                Timer test3 = new Timer();
            }

        }

        warmupLabel.setText("Warm-Up done! Let's GO!");
        warmupLabel.setTextFill(Color.web("#ffffff", 1));
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    @FXML
    public void execute() throws InterruptedException {
        try{
            long stop;
            warmup();

            cpu1.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu1.run();
            stop = timer.stop();
            piLabel.setTextFill(Color.web("#ffffff",1));
            piLabel.setText("First Nilakantha CPU computation took " + stop + " nanoseconds to complete");
            bestTime = stop;
            avgScore+=stop/Double.parseDouble(nrOfDigits.getText());
            method = "First Nilakantha";

            cpu2.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu2.run();
            stop = timer.stop();
            piLabel2.setTextFill(Color.web("#ffffff",1));
            piLabel2.setText("Second Nilakantha CPU computation took " + stop + " nanoseconds to complete");
            avgScore+=stop/Double.parseDouble(nrOfDigits.getText());
            if(stop < bestTime){
                bestTime = stop;
                method = "Second Nilakantha";
            }

//            cpu3.initialize(Integer.parseInt(nrOfDigits.getText()));
//            timer.start();
//            cpu3.run();
//            stop = timer.stop();
//            piLabel3.setTextFill(Color.web("#ffffff",1));
//            piLabel3.setText("Spigot CPU computation took " + stop + " nanoseconds to complete");
//            if(stop < bestTime){
//                bestTime = stop;
//                method = "Spigot";
//            }

            cpu4.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu4.run();
            stop = timer.stop();
            piLabel4.setTextFill(Color.web("#ffffff",1));
            piLabel4.setText("Arithmetic-Geometric mean CPU computation took " + stop + " nanoseconds to complete");
            avgScore+=stop/Double.parseDouble(nrOfDigits.getText());
            if(stop < bestTime){
                bestTime = stop;
                method = "Arithmetic-Geometric mean";
            }

            cpu5.initialize(Integer.parseInt(nrOfDigits.getText()));
            timer.start();
            cpu5.run();
            stop = timer.stop();
            cramerLabel.setTextFill(Color.web("#ffffff",1));
            cramerLabel.setText("Cramer CPU computation took " + stop + " nanoseconds to complete");
            avgScore+=stop/Double.parseDouble(nrOfDigits.getText());
            if(stop < bestTime){
                bestTime = stop;
                method = "Cramer";
            }

            avgScore = avgScore/4.0;
            avg = (int)Math.round(avgScore);
            score.setTextFill(Color.web("#ffffff",1));
            score.setText("Average score: " + avg + " points");

            best.setTextFill(Color.web("#ffffff",1));
            best.setText("The best method was " + method + " and it took " + bestTime + " ns to complete");

        }catch(InterruptedException e){
            throw new InterruptedException();
        }

    }
}