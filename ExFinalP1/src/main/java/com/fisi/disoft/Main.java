package com.fisi.disoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(new URL("file:src" + File.separator + "main" + File.separator + "java" +
                File.separator + "com" + File.separator + "fisi" + File.separator + "disoft" + File.separator
                + "vista" + File.separator + "desktop" +
                File.separator + "main.fxml"));
        primaryStage.setTitle("Examen Final Parte 1");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(800);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
