package com.example.newcmmande.Controls;

import com.example.newcmmande.Models.Data;
import com.example.newcmmande.Models.Produit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class CardProduit implements Initializable {
    @FXML
    private AnchorPane cardproduit;

    @FXML
    private Label nomproduit;

    @FXML
    private Label prixproduit;

    @FXML
    private Label stock;

    @FXML
    private TextField quantitetext;

    @FXML
    private Button commandeproduit;
    @FXML
    private ImageView imageview;

    private Produit produit;
    private Image image;
    private Connection connection;
    private PreparedStatement prepere;
    private ResultSet result;
    private Alert alert;
    public void setData(Produit pro){
        this.produit=pro;
        nomproduit.setText(pro.getNom());
        prixproduit.setText("$ "+String.valueOf(pro.getPrix()));
        stock.setText(String.valueOf(pro.getQuantite()));
        Data.path=pro.getImage();
        String path="File:"+pro.getImage();
        Data.id=pro.getId();
        image=new Image(path,154,127,false,true);
        imageview.setImage(image);
    }
    public void clear(){
        quantitetext.setText("");
    }

    public void addBtn() {
        int stock;
        int idproduit;
        double prixProduit;
        String quantitestr = quantitetext.getText();
        int quantite  = Integer.parseInt(quantitestr);
        String checkQuantite = "SELECT * FROM produit WHERE nom=?";
        try (Connection connection = DbConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(checkQuantite)) {

            preparedStatement.setString(1, nomproduit.getText());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    stock = resultSet.getInt("quantite");
                    idproduit = resultSet.getInt("numeroproduit");
                    prixProduit=resultSet.getDouble("prix");
                    if (stock == 0 || quantite > stock || quantite == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Quantité invalide !");
                        alert.showAndWait();
                    } else {
                        int idcommand;
                        if (Data.IdCommande == 0) {
                            // Ajout d'une nouvelle commande
                            String insertNewCommande = "INSERT INTO commande(numeroclient, datecommande,prixtotal) VALUES (?,?,?)";
                            String insertNewfacteur="INSET INTO facteur(datefacteur,montant,numerocommande) VALUES (?,?,?)";
                            try (PreparedStatement preparedStatementCommande = connection.prepareStatement(insertNewCommande, Statement.RETURN_GENERATED_KEYS)
                            ) {
                                preparedStatementCommande.setInt(1, Data.IDClient);
                                preparedStatementCommande.setDate(2, Data.date);
                                preparedStatementCommande.setDouble(3,quantite*prixProduit);
                                preparedStatementCommande.executeUpdate();
                                ResultSet generatedKeys = preparedStatementCommande.getGeneratedKeys();
                                if (generatedKeys.next()) {
                                    idcommand = generatedKeys.getInt(1);
                                } else {
                                    throw new SQLException("Échec de la création de la commande, aucun ID généré.");
                                }
                            }
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Valid");
                            alert.setHeaderText(null);
                            alert.setContentText("Successfully Add new commande!");
                            alert.showAndWait();


                        }
                        else {
                            idcommand = Data.IdCommande;
                            // get le prix total de la commande
                            String sql="SELECT prixtotal FROM commande WHERE numerocommande="+idcommand;
                            PreparedStatement statement=connection.prepareStatement(sql);
                            ResultSet resutlCommandee=statement.executeQuery();
                            double prixTotal=0;
                            while(resutlCommandee.next()){
                                prixTotal=resutlCommandee.getDouble("prixtotal");
                            }
                            double somme=prixTotal+ quantite*prixProduit;
                            String update= "UPDATE commande SET prixtotal = ? WHERE numerocommande = ?";
                            try (PreparedStatement preparedStatementStock = connection.prepareStatement(update)) {
                                preparedStatementStock.setDouble(1,somme);
                                preparedStatementStock.setInt(2,idcommand);
                                preparedStatementStock.executeUpdate();

                            }
                        }

                        // Insertion des données dans la table commande_produit
                        String insertDataToCommandeProduit = "INSERT INTO commande_produit (numerocommande, numeroproduit, quantitecommande) VALUES (?, ?, ?)";
                        try (PreparedStatement preparedStatementProduit = connection.prepareStatement(insertDataToCommandeProduit)) {
                            preparedStatementProduit.setInt(1, idcommand);
                            preparedStatementProduit.setInt(2, idproduit);
                            preparedStatementProduit.setInt(3, quantite);
                            preparedStatementProduit.executeUpdate();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Valid");
                            alert.setHeaderText(null);
                            alert.setContentText("Successfully Add new produit to commande numero"+Data.IdCommande);
                            alert.showAndWait();
                        }
                        //insertion dans les donnees dans la table produitsansFacteur:
                        String insertDataproduitsansfacteur = "INSERT INTO produitsansfacteur (numerocommande, numeroproduit,nom,prixtotal) VALUES (?,?, ?,?)";
                        try (PreparedStatement preparedStatementProduit = connection.prepareStatement(insertDataproduitsansfacteur)) {
                            preparedStatementProduit.setInt(1, idcommand);
                            preparedStatementProduit.setInt(2, idproduit);
                            preparedStatementProduit.setString(3, nomproduit.getText());
                            preparedStatementProduit.setDouble(4, quantite*prixProduit);
                            preparedStatementProduit.executeUpdate();
                            System.out.println("yessssssssssssss");
                        }

                        // update prixtotal

                        // Mise à jour du stock du produit
                        int upstock = stock - quantite;
                        String update = "UPDATE produit SET quantite = ? WHERE numeroproduit = ?";

                        try (PreparedStatement preparedStatementStock = connection.prepareStatement(update)) {
                            preparedStatementStock.setInt(1, upstock);
                            preparedStatementStock.setInt(2, idproduit);
                            preparedStatementStock.executeUpdate();
                            clear();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
