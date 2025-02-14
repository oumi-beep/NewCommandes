package com.example.newcmmande.Controls;

import com.example.newcmmande.Models.Data;
import com.example.newcmmande.Models.model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class loginControls implements Initializable {

    @FXML
    private TextField payeAdresstext;


    @FXML
    private Button boton;


    @FXML
    private PasswordField passwordtext;


    @FXML
    private Label erreur;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boton.setOnAction(event -> onlogn());
    }
    private void onlogn(){
        if(validateLogin()){
            /*
        Stage stage=(Stage) boton.getScene().getWindow();
        model.getInstance().getViewfactory().closStage(stage);
        model.getInstance().getViewfactory().showDashbordClient();*/
         FXMLLoader root=new FXMLLoader(getClass().getResource("/Fxml/Menu.fxml"));
         Stage stage =new Stage();
            Scene scence;
            try {
                scence =new Scene(root.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage .setTitle("oums");

         stage.setMinWidth(1100);
         stage.setMinHeight(700);
         stage.setScene(scence);
         stage.show();
         boton.getScene().getWindow().hide();

        }

        else{
         erreur.setText("Nom d'utilisateur ou mot de passe incorrect.");
        }
    }
    private boolean validateLogin() {
        String username = payeAdresstext.getText();
        String password = passwordtext.getText();
        try {
            Connection connection =DbConnection.getConnect();
            Statement stat = connection.createStatement();
            ResultSet resul = stat.executeQuery("SELECT * FROM admin WHERE userName = '" + username + "' AND motdepasse = '" + password + "'");
            if (resul.next()) {
                Data.username=username;
                // Si au moins une ligne correspond à l'utilisateur et au mot de passe
                return true;
            } else {
                // Aucun utilisateur correspondant trouvé
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
