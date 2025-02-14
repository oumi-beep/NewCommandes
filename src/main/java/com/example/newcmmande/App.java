package com.example.newcmmande;

import com.example.newcmmande.Models.model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class App extends Application {

    @Override
    public void start(Stage primaryStage)   {
        //model.getInstance().getViewfactory().showLogn();
        FXMLLoader Loader=new FXMLLoader(getClass().getResource("/Fxml/hello-view.fxml"));
        Scene scene=null;
        try {
            scene = new Scene(Loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("actuel");
        stage.show();
    }
}
