package com.example.newcmmande.Controls;

import com.example.newcmmande.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Menu implements Initializable {

    @FXML
    private AnchorPane gestionProduit;
    @FXML
    private Button dashbord;

    @FXML
    private Button Product;

    @FXML
    private Button Clients;

    @FXML
    private Button orders;

    @FXML
    private Button invoices;

    @FXML
    private Button deliveries;

    @FXML
    private Button logout;

    @FXML
    private Button change;

    @FXML
    private TextField IDproduitText;

    @FXML
    private TextField NomProduitText;

    @FXML
    private TextField QuantiteText;

    @FXML
    private TextField prixText;
    @FXML
    private AnchorPane gestionLivraison;

    @FXML
    private ImageView imageProduit;

    @FXML
    private Button InsertImage;

    @FXML
    private Button Add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button clear;

    @FXML
    private TableView<Produit> tableview;

    @FXML
    private TableColumn<Produit,String> columID;

    @FXML
    private TableColumn<Produit,String> Columnom;

    @FXML
    private TableColumn <Produit,String> columQuantite;

    @FXML
    private TableColumn<Produit,String> colunprix;
    @FXML
    private Text admin;
    @FXML
    private AnchorPane gestionCommande;

    @FXML
    private TableView<Commande> tableCommand;

    @FXML
    private TableColumn<Commande,String> IDcommandcolun;

    @FXML
    private TableColumn<Commande,String> datecolun;

    @FXML
    private TableColumn<Commande,String> prixtotalcolun;
    @FXML
    private TableColumn<Commande,String> colunIDclient;


    @FXML
    private ScrollPane listproScroll;

    @FXML
    private GridPane listproGridpane;

    @FXML
    private TableView<Produit> tableproduit;

    @FXML
    private TableColumn<Produit,String> IDprocolun;

    @FXML
    private TableColumn<Produit,String> nomprocolun;

    @FXML
    private TableColumn<Produit,String> quantitecolun;

    @FXML
    private Button addcommand;

    @FXML
    private Button cannelcommand;
    @FXML
    private Button clearcommande;
    @FXML
    private Button deletProduitecommand;
    @FXML
    private Button deletecommande;
    Alert alert;
    private Connection connection;
    private PreparedStatement prepare;
    private Statement stat;
    private ResultSet result;
    private Image image;
    @FXML
    private Label test;
    private ObservableList<Produit> Cardlistdata=FXCollections.observableArrayList();
    @FXML
    private AnchorPane gestionClient;

    @FXML
    private TableView<Client> tableviewClient;

    @FXML
    private TableColumn<Client, String> columIDclient;

    @FXML
    private TableColumn<Client, String> ColumnomClient;

    @FXML
    private TableColumn<Client, String> columprenomclient;

    @FXML
    private TableColumn<Client, String> colunadress;

    @FXML
    private TableColumn<Client, String> coluntelephone;

    @FXML
    private TextField prenomclienttext;

    @FXML
    private TextField Nomclienttext;

    @FXML
    private TextField Adressclienttext;

    @FXML
    private TextField telclienttext;

    @FXML
    private Button updateCLIENT;

    @FXML
    private Button addclient;

    @FXML
    private Button update1;

    @FXML
    private Button deleteclient;

    @FXML
    private Button clearclient;

    @FXML
    private TextField searchtext;

    @FXML
    private Button btnsearch;

    @FXML
    private TableView<Commande> listcommande;

    @FXML
    private TableColumn<Commande,String> colunIDcommande;

    @FXML
    private TableColumn<Commande,String> colunDatecommande;

    @FXML
    private TableColumn<Commande,String> colunPrixtotal;
    @FXML
    private TextField DateCommandText;

    @FXML
    private TextField IDClienttext;

    @FXML
    private TextField QuantiteCommandText;

    @FXML
    private TextField IDProduitText;
    //facture variable:
    @FXML
    private AnchorPane gestionFacteur;

    @FXML
    private TextField IDfacture;

    @FXML
    private TextField idDateFacture;

    @FXML
    private TextField idCommande;

    @FXML
    private Button updateFacture;

    @FXML
    private Button AddFacture;

    @FXML
    private Button clearFacteur;

    @FXML
    private Button deleteFacture;

    @FXML
    private TextField searchFacture;

    @FXML
    private Button buttonsearchFacture;

    @FXML
    private TableView<ProduitsansFacteur> tableproduitsansFacture;

    @FXML
    private TableColumn<ProduitsansFacteur, String> colunIdProduit;

    @FXML
    private TableColumn<ProduitsansFacteur, String> colunnomProduit;

    @FXML
    private TableColumn<ProduitsansFacteur, String> colunquantiteproduit;
    @FXML
    private TableView<Facture> tablefactures;

    @FXML
    private TableColumn<Facture, String> Numerofacture;

    @FXML
    private TableColumn<Facture, String> NumeroCommande;

    @FXML
    private TableColumn<Facture, String> DateFacturecolun;

    @FXML
    private TableColumn<Facture, String> Montantcolun;
    @FXML
    private TableView<Produit> tableproduitdansfacture;

    @FXML
    private TableColumn<Produit, String> numeroproduitcolun;

    @FXML
    private TableColumn<Produit, String> nomproduitcolun;

    @FXML
    private TableColumn<Produit, String> quantiteproduitcolun;

    @FXML
    private TableColumn<Produit, String> prixproduitcolun;

    @FXML
    private TextField montantzone;

    @FXML
    private Button clearfacture;

    @FXML
    private Button install;

    @FXML
    private TextField numerocommandetext;

    @FXML
    private TextField numerofacturetext;

    @FXML
    private TextField DateFacturetext;

    @FXML
    private TextField telephonetext;

    @FXML
    private TextField nomclienttext;

    @FXML
    private TextField adressclienttext;
    @FXML
    private TableView<Facture> tablefactures1;

    @FXML
    private TableColumn<Facture,String> Numerofacture1;

    @FXML
    private TableColumn<Facture,String> NumeroCommande1;

    @FXML
    private TableColumn<Facture,String> DateFacturecolun1;

    @FXML
    private TableColumn<Facture,String> Montantcolun1;
    //parametre de livraison:
    @FXML
    private TableView<ProduitFactureLivr> tableviewInstallivBon;
    @FXML
    private TableColumn<ProduitFactureLivr, Integer> NumeroProduitInstall1;
    @FXML
    private TableColumn<ProduitFactureLivr, String> ClmNomProduitInstall1;
    @FXML
    private TableColumn<ProduitFactureLivr, Integer> QuantiteProduitInstall1;
    @FXML
    private TableColumn<ProduitFactureLivr, Double> PrixInstall1;
    @FXML
    private TableColumn<ProduitFactureLivr, Double> PrixTVA;
    @FXML
    private TableColumn<ProduitFactureLivr, Double> MontantTTC;
    @FXML
    private Label Montant;
    @FXML
    private Label Total_TTC;
    @FXML
    private Label Total_TVA;
    @FXML
    private Label NumeroFactureLivInstall;
    @FXML
    private Label DateLivraisonInstall;
    @FXML
    private Label NumeroCommandeLivInstall;
    @FXML
    private Label DateCommandeLivInstall;
    @FXML
    private Label NumeroLivraisonInstall;

    @FXML
    private TextField numeroFactureLivr;

    @FXML
    private TextField DateLivraison;

    @FXML
    private Label IDproduitText111;

    @FXML
    private TextField numerocommandeLiv;

    @FXML
    private TextField SearchByDateLiv;

    @FXML
    private TableView<Livraison> tableviewLivr;

    @FXML
    private TableColumn<?, ?> ColumNumeroFactureLivraison;

    @FXML
    private Integer numeroFactureLiv;

    @FXML
    private TableColumn<?, ?> ColumNumeroLivraison;

    @FXML
    private TableColumn<?, ?> ColumnumeroCommandLivraison;

    @FXML
    private TableColumn<?, ?> ColumDateLivraison;

    public void switchForm(ActionEvent event){
        if(event.getSource()==orders){
            gestionCommande.setVisible(true);
            gestionProduit.setVisible(false);
            gestionClient.setVisible(false);
            gestionFacteur.setVisible(false);
            gestionLivraison.setVisible(false);
            menuDisplayCard();
            showCommandes();


        } else if (event.getSource()==Product) {
            gestionCommande.setVisible(false);
            gestionClient.setVisible(false);
            gestionFacteur.setVisible(false);
            gestionProduit.setVisible(true);
            gestionLivraison.setVisible(false);
            showProduits();
        }
        else if(event.getSource()==Clients){
            gestionCommande.setVisible(false);
            gestionProduit.setVisible(false);
            gestionClient.setVisible(true);
            gestionFacteur.setVisible(false);
            gestionLivraison.setVisible(false);
            showClients();
        }
        else if(event.getSource()==invoices){
            gestionCommande.setVisible(false);
            gestionProduit.setVisible(false);
            gestionClient.setVisible(false);
            gestionFacteur.setVisible(true);
            gestionLivraison.setVisible(false);
            showfacture();
        }
        else if(event.getSource()==deliveries){
            gestionCommande.setVisible(false);
            gestionProduit.setVisible(false);
            gestionClient.setVisible(false);
            gestionFacteur.setVisible(false);
            gestionLivraison.setVisible(true);
            showlivraison();
        }

    }
    //Gestion client

    public ObservableList<Client> ClientDatalist(){
        ObservableList<Client> listclient= FXCollections.observableArrayList();
        String sql="SELECT * FROM client";
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Client client;
            while(result.next()){
                client=new Client(result.getInt("numeroclient"),result.getString("nom"),
                        result.getString("prenom"),result.getString("adresse"),result.getInt("tel") );
                listclient.add(client);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listclient;
    }
    private ObservableList<Client>  ClientList;

    public void showClients() {
        ClientList = ClientDatalist();
        columIDclient.setCellValueFactory(new PropertyValueFactory<>("ID"));
        ColumnomClient.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columprenomclient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colunadress.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        coluntelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tableviewClient.setItems(ClientList);
    }
    public void btnClearclient(){
        prenomclienttext.setText("");
        Nomclienttext.setText("") ;
        Adressclienttext.setText("");
        telclienttext.setText("");
        Data.IDClient=0;
    }
    public void selectFromClientData(){
        Client client=tableviewClient.getSelectionModel().getSelectedItem();
        int num=tableviewClient.getSelectionModel().getSelectedIndex();
        if(num-1<-1){ return ;}
        prenomclienttext.setText(client.getPrenom());
        Nomclienttext.setText(client.getNom()); ;
        Adressclienttext.setText(client.getAdresse());
        telclienttext.setText(String.valueOf(client.getTel()));
        Data.IDClient=client.getID();
        showCommandeClient();
    }
    public void AddClient(){
        if(prenomclienttext.getText().isEmpty()||Nomclienttext.getText().isEmpty()|| Adressclienttext.getText().isEmpty()
                || telclienttext.getText().isEmpty()){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            String checkclient="SELECT numeroclient FROM client WHERE tel="+telclienttext.getText();
            connection =DbConnection.getConnect();
            try{
                stat = connection.createStatement();
                result=stat.executeQuery(checkclient);
                Produit pro;
                if(result.next()){
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("this client is already taken");
                    alert.showAndWait();
                }
                else{
                    String insert="INSERT INTO client"+"(nom,prenom,adresse,tel)"+"VALUES(?,?,?,?)";
                    prepare=connection.prepareStatement(insert);
                    prepare.setString(1,Nomclienttext.getText());
                    prepare.setString(2,prenomclienttext.getText());
                    prepare.setString(3, Adressclienttext.getText());
                    prepare.setString(4,telclienttext.getText());
                    prepare.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    showClients();
                    btnClearclient();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void updateClient(){
        if(prenomclienttext.getText().isEmpty()||Nomclienttext.getText().isEmpty()|| Adressclienttext.getText().isEmpty()
                || telclienttext.getText().isEmpty()){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        }
        else{
            String update="UPDATE client SET nom='"+Nomclienttext.getText()+"',prenom='"+prenomclienttext.getText()+"',adresse='"+Adressclienttext.getText()
                    +"',tel="+telclienttext.getText()+" WHERE numeroclient ="+Data.IDClient;
            connection =DbConnection.getConnect();
            try{
                alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update"+ Nomclienttext.getText()+"" +prenomclienttext.getText());
                alert.showAndWait();
                Optional<ButtonType> option =alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    prepare=connection.prepareStatement(update);
                    prepare.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Update!");
                    alert.showAndWait();
                    showClients();
                    btnClearclient();

                }
                else{
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();

                }


            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public void deleteClient(){
        if(Data.IDClient==0){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this Client  ?");
            alert.showAndWait();
            Optional<ButtonType> option =alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                String delete="DELETE FROM client WHERE numeroclient= "+Data.IDClient;
                try{
                    prepare=connection.prepareStatement(delete);
                    prepare.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete!");
                    alert.showAndWait();
                    showClients();
                    btnClearclient();

                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
            else{
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();

            }


        }
    }
    public void searchClientByName() {
        String searchTerm =searchtext.getText().toLowerCase();
        ObservableList<Client> clientsList = ClientDatalist();
        FilteredList<Client> filteredList = new FilteredList(clientsList, (p) -> {
            return true;
        });
        filteredList.setPredicate((client) -> {
            if (searchTerm != null && !searchTerm.isEmpty()) {
                String lowerCaseSearchTerm = searchTerm.toLowerCase();
                return client.getNom().toLowerCase().contains(lowerCaseSearchTerm);
            } else {
                return true;
            }
        });
        tableviewClient.setItems(filteredList);
    }

   public void annullerecherche(){
       searchtext.setText("");
       showClients();
   }
   // search facture:
    /*
   public void searchFactureByDate() {
       String searchTerm = searchFacture.getText().toLowerCase();

       // Obtenir la liste complète des factures
       ObservableList<Facture> facturesList = getFacturesData();

       // Créer une FilteredList pour filtrer les factures en fonction de la date
       FilteredList<Facture> filteredList = new FilteredList<>(facturesList, p -> true);

       // Appliquer le filtre en fonction de la date de recherche
       filteredList.setPredicate(facture -> {
           // Si la recherche est vide ou nulle, afficher toutes les factures
           if (searchTerm == null || searchTerm.isEmpty()) {
               return true;
           }

           try {
               SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
               java.util.Date searchDate = formatter.parse(searchTerm);

               // La date de la facture est déjà un objet java.util.Date
               java.util.Date factureDate = facture.getDateFacture();

               return formatter.format(factureDate).equals(formatter.format(searchDate));
           } catch (ParseException e) {
               return false;
           }
       });

       tablefactures.setItems(filteredList);
   }
   */

    public ObservableList<Commande> CommandeClientDatalist(){
        ObservableList<Commande> listCommande= FXCollections.observableArrayList();
        String  sql="SELECT * FROM commande WHERE numeroclient="+Data.IDClient;
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Commande commande;
            while(result.next()){
                commande=new Commande(result.getInt("numerocommande"),result.getDate("datecommande"),result.getDouble("prixtotal"));
                listCommande.add(commande);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listCommande;
    }
    private ObservableList<Commande> listCommandeClient;
    //show les produit dans le tableau produit
    public void showCommandeClient() {
        listCommandeClient = CommandeClientDatalist();
        colunIDcommande.setCellValueFactory(new PropertyValueFactory<>("numerocommande"));
        colunDatecommande.setCellValueFactory(new PropertyValueFactory<>("datecommande"));
        colunPrixtotal.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
        listcommande.setItems(listCommandeClient);

    }
    //Gestion Commande
    public void addnewfacteur(){
        if(Data.IdCommande!=0){
        gestionCommande.setVisible(false);
        gestionProduit.setVisible(false);
        gestionClient.setVisible(false);
        gestionFacteur.setVisible(true);
        idDateFacture.setText(String.valueOf(Data.date));
        idCommande.setText(String.valueOf(Data.IdCommande));
        showproduitsansfacture();
        showfacturedunecommande();
    }
    }
    public void AddFactures(){
        if(idDateFacture.getText().isEmpty()||idCommande.getText().isEmpty()){
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            String insert="INSERT INTO facteur "+"(datefacteur,montant,numerocommande)"+"VALUES(?,?,?)";
            String  sql="SELECT * FROM produitsansfacteur WHERE numerocommande="+Data.IdCommande;
            String ajoutfp="INSERT INTO factureproduit (numerofacture, numeroproduit) VALUES (?,?)";
            String free="DELETE FROM produitsansfacteur WHERE numerocommande= "+Data.IdCommande;
            String prixtotal="SELECT sum(prixtotal) as prixtotal  FROM produitsansfacteur WHERE numerocommande="+Data.IdCommande;
            connection=DbConnection.getConnect();
            try(PreparedStatement setoprix=connection.prepareStatement(prixtotal);
                PreparedStatement selectproduit=connection.prepareStatement(sql);
                PreparedStatement freefsp=connection.prepareStatement(free);
                PreparedStatement ajoutefactureproduit=connection.prepareStatement(ajoutfp);
                PreparedStatement prepare=connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);){
                    result=setoprix.executeQuery();
                    double prix=0;
                    if(result.next()){
                        prix=result.getDouble("prixtotal");
                    }
                    prepare.setDate(1,Data.date);
                    prepare.setDouble(2,prix);
                    prepare.setInt(3,Data.IdCommande );
                    prepare.executeUpdate();
                    ResultSet generatedKeys = prepare.getGeneratedKeys();
                    int idfacture=0;
                if (generatedKeys.next()) {
                    idfacture = generatedKeys.getInt(1);
                }
                ResultSet produit=selectproduit.executeQuery();
                while(produit.next()){
                    int idproduit=produit.getInt("numeroproduit");
                    ajoutefactureproduit.setInt(1,idfacture);
                    ajoutefactureproduit.setInt(2,idproduit);
                    ajoutefactureproduit.executeUpdate();
                }
                    freefsp.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    showproduitsansfacture();
                    showfacturedunecommande();
                   idDateFacture.setText("");
                   idCommande.setText("");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //show facture d'une commande:
    public ObservableList<Facture> listfacturedunecommande(){
        ObservableList<Facture> listfacture= FXCollections.observableArrayList();
        String  sql="SELECT * FROM facteur WHERE numerocommande="+Data.IdCommande;
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Facture facture;
            while(result.next()){
                facture=new Facture(result.getInt("numerofacteur"),result.getInt("numerocommande"),result.getDate("datefacteur"),result.getDouble("montant"));
                listfacture.add(facture);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listfacture;
    }
    private ObservableList<Facture> listfacturedunecommande;

    public void showfacturedunecommande() {
        tablefactures.setVisible(false);
        tablefactures1.setVisible(true);
        listfacturedunecommande = listfacturedunecommande();
        Numerofacture1.setCellValueFactory(new PropertyValueFactory<>("numeroFacture"));
        NumeroCommande1.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
        DateFacturecolun1.setCellValueFactory(new PropertyValueFactory<>("dateFacture"));
        Montantcolun1.setCellValueFactory(new PropertyValueFactory<>("montant"));
        tablefactures1.setItems(listfacturedunecommande);
    }
    //ShowFacture:
    public ObservableList<Facture> listfacture(){
        ObservableList<Facture> listfacture= FXCollections.observableArrayList();
        String  sql="SELECT * FROM facteur ";
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Facture facture;
            while(result.next()){
                facture=new Facture(result.getInt("numerofacteur"),result.getInt("numerocommande"),result.getDate("datefacteur"),result.getDouble("montant"));
                listfacture.add(facture);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listfacture;
    }
    private ObservableList<Facture> listfacture;

    public void showfacture() {
        tablefactures1.setVisible(false);
        tablefactures.setVisible(true);
        listfacture = listfacture();
        Numerofacture.setCellValueFactory(new PropertyValueFactory<>("numeroFacture"));
        NumeroCommande.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
        DateFacturecolun.setCellValueFactory(new PropertyValueFactory<>("dateFacture"));
        Montantcolun.setCellValueFactory(new PropertyValueFactory<>("montant"));
        tablefactures.setItems(listfacture);
    }
    //les produit contient dans une facture:
    public void selectfacture(){
        Facture facture=tablefactures.getSelectionModel().getSelectedItem();
        int num=tablefactures.getSelectionModel().getSelectedIndex();
        if(num-1<-1){ return ;}
        numerocommandetext.setText(String.valueOf(facture.getNumeroCommande()));
        numerofacturetext.setText(String.valueOf(facture.getNumeroFacture())); ;
        DateFacturetext.setText(String.valueOf(facture.getDateFacture()) );
        montantzone.setText(String.valueOf(facture.getMontant()));
        Data.IDfacture=facture.getNumeroFacture();
        Data.IdCommande=facture.getNumeroCommande();
        String infoclient="SELECT c.nom, c.adresse ,c.tel FROM client c JOIN commande cd  ON c.numeroclient=cd.numeroclient WHERE cd.numerocommande="+facture.getNumeroCommande();
        try{
            connection=DbConnection.getConnect();
            stat=connection.createStatement();
            result=stat.executeQuery(infoclient);
            if(result.next()){
                nomclienttext.setText(result.getString("nom"));
                adressclienttext.setText(result.getString("adresse"));
                telephonetext.setText(String.valueOf(result.getInt("tel")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        showproduitfacture();
    }
    public void clearfacture(){
        numerocommandetext.setText("");
        numerofacturetext.setText("");
        DateFacturetext.setText("");
        montantzone.setText("0.00");
        nomclienttext.setText("");
        adressclienttext.setText("");
        telephonetext.setText("");

    }
    public void selectfacturedunecommande(){
        Facture facture=tablefactures1.getSelectionModel().getSelectedItem();
        int num=tablefactures1.getSelectionModel().getSelectedIndex();
        if(num-1<-1){ return ;}
        numerocommandetext.setText(String.valueOf(facture.getNumeroCommande()));
        numerofacturetext.setText(String.valueOf(facture.getNumeroFacture())); ;
        DateFacturetext.setText(String.valueOf(facture.getDateFacture()) );
        montantzone.setText(String.valueOf(facture.getMontant()));
        Data.IDfacture=facture.getNumeroFacture();
        Data.IdCommande=facture.getNumeroCommande();
        String infoclient="SELECT c.nom, c.adresse ,c.tel FROM client c JOIN commande cd  ON c.numeroclient=cd.numeroclient WHERE cd.numerocommande="+facture.getNumeroCommande();
        try{
            connection=DbConnection.getConnect();
            stat=connection.createStatement();
            result=stat.executeQuery(infoclient);
            if(result.next()){
                nomclienttext.setText(result.getString("nom"));
                adressclienttext.setText(result.getString("adresse"));
                telephonetext.setText(String.valueOf(result.getInt("tel")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        showproduitfacture();
    }

    public ObservableList<Produit> produitFacteur(){
        ObservableList<Produit> listproduit= FXCollections.observableArrayList();

        String  sql="SELECT p.nom ,p.prix ,p.numeroproduit ,cp.quantitecommande FROM produit p JOIN factureproduit fp ON p.numeroproduit= fp.numeroproduit JOIN  commande_produit as cp ON cp.numeroproduit=p.numeroproduit && cp.numerocommande="+Data.IdCommande + " WHERE fp.numerofacture= "+Data.IDfacture;
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Produit produit;
            while(result.next()){
                produit=new Produit(result.getInt("numeroproduit"),result.getString("nom"),result.getInt("quantitecommande"),result.getDouble("prix"));
                listproduit.add(produit);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listproduit;
    }

    private ObservableList<Produit> listproduit;
    //show les produit dans le tableau produit
    public void showproduitfacture(){
        listproduit = produitFacteur();
        numeroproduitcolun.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomproduitcolun.setCellValueFactory(new PropertyValueFactory<>("nom"));
        quantiteproduitcolun.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        prixproduitcolun.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tableproduitdansfacture.setItems(listproduit);
    }



    //liste produite sans facture:
    public ObservableList<ProduitsansFacteur> Datalistproduitsansfacture(){
        ObservableList<ProduitsansFacteur> listproduit= FXCollections.observableArrayList();
        String  sql="SELECT * FROM produitsansfacteur WHERE numerocommande="+Data.IdCommande;
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            ProduitsansFacteur produit;
            while(result.next()){
                produit=new ProduitsansFacteur(result.getInt("numerocommande"),result.getInt("numeroproduit"),result.getString("nom"),result.getDouble("prixtotal"));
                listproduit.add(produit);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listproduit;
    }
    private ObservableList<ProduitsansFacteur> listprsans;
    //show les produit dans le tableau produit
    public void showproduitsansfacture() {
        listprsans = Datalistproduitsansfacture();
        colunIdProduit.setCellValueFactory(new PropertyValueFactory<>("numeroproduit"));
        colunnomProduit.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colunquantiteproduit.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));
        tableproduitsansFacture.setItems(listprsans);
    }

    public void DeleteFacture() {
        if (Data.IDfacture == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this facture?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                String sql2 = "DELETE FROM facteur WHERE numerofacteur = ?";
                String sql = "DELETE FROM factureproduit WHERE numerofacture= ?";
                String select = "SELECT fp.numeroproduit ,p.nom,p.prix * cp.quantitecommande as prixtotal FROM factureproduit fp " +
                        " JOIN produit p ON fp.numeroproduit=p.numeroproduit JOIN commande_produit cp" +
                        " ON cp.numeroproduit=p.numeroproduit && cp.numerocommande=? WHERE fp.numerofacture=?";
                String update="";
                String inserttoproduitsansfacture = "INSERT INTO produitsansfacteur (numerocommande, numeroproduit,nom,prixtotal) VALUES (?,?,?,?)";
                String numerocommande = "SELECT numerocommande FROM facteur WHERE numerofacteur = ?";

                try (PreparedStatement stat = connection.prepareStatement(select);
                     PreparedStatement statement2 = connection.prepareStatement(sql2);
                     PreparedStatement statement = connection.prepareStatement(sql);
                     PreparedStatement numeroCommande = connection.prepareStatement(numerocommande);
                     PreparedStatement statupro = connection.prepareStatement(inserttoproduitsansfacture)) {
                     numeroCommande.setInt(1,Data.IDfacture);
                    try (ResultSet result=numeroCommande.executeQuery()){
                        if(result.next()){
                            int idCommand=result.getInt("numerocommande");
                            stat.setInt(1,idCommand);
                            stat.setInt(2,Data.IDfacture);
                        try (ResultSet resulta = stat.executeQuery()) {
                            while (resulta.next()) {
                                int numeroproduit = resulta.getInt("numeroproduit");
                                String nom = resulta.getString("nom");
                                double prixtotal=resulta.getDouble("prixtotal");
                                statupro.setInt(1,idCommand);
                                statupro.setInt(2,numeroproduit );
                                statupro.setString(3,nom);
                                statupro.setDouble(4,prixtotal);
                                statupro.executeUpdate();
                                    }
                                }
                            }
                        }

                    statement2.setInt(1, Data.IDfacture);
                    statement2.executeUpdate();

                    statement.setInt(1, Data.IDfacture);
                    statement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    showfacturedunecommande();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        }
    }

    public String getContentFromAnchorPane() {
        StringBuilder contentBuilder = new StringBuilder();

        // Informations générales de la facture
        contentBuilder.append("Date de la facture: ").append(DateFacturetext.getText()).append("\n");
        contentBuilder.append("Numero de la commande: ").append(numerocommandetext.getText()).append("\n");
        contentBuilder.append("Numero de la facture: ").append(numerofacturetext.getText()).append("\n\n");

        // Informations sur les produits commandés
        contentBuilder.append("Produits commandés:\n");
        contentBuilder.append("----------------------------------------------\n");
        contentBuilder.append("Numero du produit\tNom du produit\tQuantite\tPrix\n");
        contentBuilder.append("----------------------------------------------\n");

        List<Produit> items = tableproduitdansfacture.getItems();
        for (Produit item : items) {
            contentBuilder.append(item.getId()).append("\t\t\t")
                    .append(item.getNom()).append("\t")
                    .append(item.getQuantite()).append("\t")
                    .append(item.getPrix()).append("\n");
        }
        contentBuilder.append("----------------------------------------------\n\n");

        // Informations sur le client
        contentBuilder.append("Informations du client:\n");
        contentBuilder.append("Nom du client: ").append(nomclienttext.getText()).append("\n");
        contentBuilder.append("Adresse du client: ").append(adressclienttext.getText()).append("\n");
        contentBuilder.append("Telephone du client: ").append(telephonetext.getText()).append("\n");

        return contentBuilder.toString();
    }
    public void saveContentToFile() {
        String content = getContentFromAnchorPane();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le fichier");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers texte (*.txt)", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if (selectedFile != null) {
            try {
                FileWriter fileWriter = new FileWriter(selectedFile);
                fileWriter.write(content);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    ///
    public void freeaddcommand(){
        Data.IdCommande=0;
    }
    public ObservableList<Commande> CommandeDatalist(){
        ObservableList<Commande> listCommande= FXCollections.observableArrayList();
        String  sql="SELECT * FROM commande";
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Commande commande;
            while(result.next()){
                 commande=new Commande(result.getInt("numerocommande"),result.getDate("datecommande"),result.getInt("numeroclient"),result.getDouble("prixtotal"));
                listCommande.add(commande);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listCommande;
    }
    private ObservableList<Commande> listCommande;
    //show les produit dans le tableau produit
    public void showCommandes() {
        listCommande = CommandeDatalist();
        IDcommandcolun.setCellValueFactory(new PropertyValueFactory<>("numerocommande"));
        datecolun.setCellValueFactory(new PropertyValueFactory<>("datecommande"));
        colunIDclient.setCellValueFactory(new PropertyValueFactory<>("numeroclient"));
        prixtotalcolun.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
        tableCommand.setItems(listCommande);
    }
    public ObservableList<Produit> CommandeDatalistProduit(){
        ObservableList<Produit> listProduitCommande= FXCollections.observableArrayList();
        String sql="SELECT p.nom,p.numeroproduit, cp.quantiteCommande as quantite FROM produit p INNER JOIN commande_produit cp ON p.numeroproduit = cp.numeroproduit WHERE numerocommande="+Data.IdCommande;
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Produit produit;
            while(result.next()){
                produit=new Produit(result.getInt("numeroproduit"),result.getString("nom"),result.getInt("quantite"));
                listProduitCommande.add(produit);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listProduitCommande;
    }
    private ObservableList<Produit> listCommandeProduit;
    //show les produit dans le tableau produit
    public void showCommandesProduit() {
        listCommandeProduit = CommandeDatalistProduit();
        IDprocolun.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomprocolun.setCellValueFactory(new PropertyValueFactory<>("nom"));
        quantitecolun.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        tableproduit.setItems(listCommandeProduit);
    }
    public void selectProduitCommandData(){
        Produit pro=tableproduit.getSelectionModel().getSelectedItem();
        int num=tableproduit.getSelectionModel().getSelectedIndex();
        if(num-1<-1){ return ;}
        IDProduitText.setText(String.valueOf(pro.getId()));
        QuantiteCommandText.setText(String.valueOf(pro.getQuantite()));
        Data.id=pro.getId();
        String sql="SELECT * FROM commande WHERE numerocommande="+Data.IdCommande;
        try {
            prepare=connection.prepareStatement(sql);
            result=prepare.executeQuery();
            while(result.next()){
                IDClienttext.setText(String.valueOf(result.getInt("numeroclient")));
                DateCommandText.setText(String.valueOf(result.getDate("datecommande")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //supprimme un produit d'une commande
    public void DeleteProduitCommande(){
        if(Data.id==0){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this Product?");
            alert.showAndWait();
            Optional<ButtonType> option =alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                String delete="DELETE FROM commande_produit WHERE numeroproduit= "+Data.id+"&& numerocommande="+Data.IdCommande;
                String sql="SELECT prixtotal FROM commande WHERE numerocommande="+Data.IdCommande;
                String uptatprixtotal="UPDATE commande SET prixtotal = ? WHERE numerocommande = ?";
                String sqlpro="SELECT prix FROM produit WHERE numeroproduit="+Data.id;
                String sqlQuantite="SELECT quantitecommande FROM commande_produit WHERE numeroproduit= "+Data.id+"&& numerocommande="+Data.IdCommande;
                PreparedStatement statementsql;
                PreparedStatement statementupdate;
                PreparedStatement statement;
                PreparedStatement statementQuantite;
                ResultSet resultSet;
                ResultSet resultSetq;
                try{
                    prepare=connection.prepareStatement(delete);
                    statementsql=connection.prepareStatement(sql);
                    statementupdate=connection.prepareStatement(uptatprixtotal);
                    statement=connection.prepareStatement(sqlpro);
                    statementQuantite=connection.prepareStatement(sqlQuantite);
                    resultSetq=statementQuantite.executeQuery();
                    resultSet=statement.executeQuery();
                    result=statementsql.executeQuery();
                    double prix=0;
                    int quantite=0;
                    double prixtotal=0;
                    if(resultSetq.next()){
                        quantite=resultSetq.getInt("quantitecommande");
                    }
                    if(resultSet.next()){
                        prix=resultSet.getDouble("prix");
                    }
                    if(result.next()){
                        prixtotal=result.getDouble("prixtotal");
                    }
                    statementupdate.setDouble(1,prixtotal-prix*quantite);
                    statementupdate.setInt(2,Data.IdCommande);
                    statementupdate.executeUpdate();
                    prepare.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete!");
                    alert.showAndWait();
                    showCommandesProduit();
                    showCommandes();
                    btnClearProduitcommande();

                }
                catch(Exception e){
                    e.printStackTrace();
                }



            }
            else{
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();

            }


        }

    }
    public void DeleteCommande() {
        if (Data.IdCommande == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this commande?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                String sql2 = "DELETE FROM commande_produit WHERE numerocommande = ?";
                String sql = "DELETE FROM commande WHERE numerocommande = ?";
                String select = "SELECT * FROM commande_produit WHERE numerocommande = ?";
                String update = "UPDATE produit SET quantite = ? WHERE numeroproduit = ?";
                String stokproduit = "SELECT quantite FROM produit WHERE numeroproduit = ?";

                try (PreparedStatement stat = connection.prepareStatement(select);
                     PreparedStatement statement2 = connection.prepareStatement(sql2);
                     PreparedStatement statement = connection.prepareStatement(sql);
                     PreparedStatement statgetstok = connection.prepareStatement(stokproduit);
                     PreparedStatement statupro = connection.prepareStatement(update)) {

                    stat.setInt(1, Data.IdCommande);
                    try (ResultSet result = stat.executeQuery()) {
                        while (result.next()) {
                            int numeroproduit = result.getInt("numeroproduit");
                            int quantitecommande = result.getInt("quantitecommande");

                            statgetstok.setInt(1, numeroproduit);
                            try (ResultSet resultstok = statgetstok.executeQuery()) {
                                if (resultstok.next()) {
                                    int stock = resultstok.getInt("quantite");
                                    statupro.setInt(1, stock + quantitecommande);
                                    statupro.setInt(2, numeroproduit);
                                    statupro.executeUpdate();
                                }
                            }
                        }
                    }

                    statement2.setInt(1, Data.IdCommande);
                    statement2.executeUpdate();

                    statement.setInt(1, Data.IdCommande);
                    statement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    showCommandes();
                    showCommandesProduit();
                    menuDisplayCard();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        }
    }
    //update commande:
    public void UpdatCommande(){
        if (IDProduitText.getText().isEmpty()|| QuantiteCommandText.getText().isEmpty()|| IDClienttext.getText().isEmpty() || DateCommandText.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update this commande?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                String updateCommande = "UPDATE commande SET datecommande = ?,numeroclient=? ,prixtotal=? WHERE numerocommande= ?";
                String updatequantite = "UPDATE commande_produit SET quantitecommande=? WHERE numeroproduit=? && numerocommande=?";
                String getprix="SELECT prix FROM produit WHERE numeroproduit="+Data.id;
                String getprixtotal="SELECT prixtotal FROM commande WHERE numerocommande="+Data.IdCommande;
                String getQuantite = "SELECT quantitecommande FROM commande_produit WHERE numerocommande=? && numeroproduit=? ";
                try (PreparedStatement statement1 = connection.prepareStatement(updateCommande);
                     PreparedStatement statement2 = connection.prepareStatement(updatequantite);
                     PreparedStatement statement3 = connection.prepareStatement(getprix);
                     PreparedStatement statement4 = connection.prepareStatement(getQuantite);
                     PreparedStatement statement5 = connection.prepareStatement(getprixtotal)
                     ) {
                    statement4.setInt(1,Data.IdCommande);
                    statement4.setInt(2,Data.id);
                    int quantite=0;
                    double prix=0;
                    double prixtotal=0;
                    double prixT;
                    ResultSet result5=statement5.executeQuery();
                    ResultSet result4=statement4.executeQuery();
                    if(result4.next()){
                        quantite=result4.getInt("quantitecommande");
                    }
                    ResultSet result3=statement3.executeQuery();
                    if(result3.next()){
                        prix=result3.getDouble("prix");
                    }
                    if(result5.next()){
                        prixtotal=result5.getDouble("prixtotal");
                    }
                    if(quantite!=Integer.parseInt(QuantiteCommandText.getText())){
                        prixT=(Integer.parseInt(QuantiteCommandText.getText())-quantite)*prix+prixtotal;
                    }
                    else{
                        prixT=prixtotal;
                    }
                    statement1.setDate(1, Date.valueOf(DateCommandText.getText()));
                    statement1.setInt(2, Integer.parseInt(IDClienttext.getText()));
                    statement1.setDouble(3,prixT);
                    statement1.setInt(4,Data.IdCommande);
                    statement1.executeUpdate();
                    statement2.setInt(1,Integer.parseInt(QuantiteCommandText.getText()));
                    statement2.setInt(2,Data.id);
                    statement2.setInt(3,Data.IdCommande);
                    statement2.executeUpdate();
                    showCommandes();
                    showCommandesProduit();
                    System.out.println(quantite);
                    System.out.println(prixtotal);
                    System.out.println(prix);
                    System.out.println(Integer.parseInt(QuantiteCommandText.getText()));



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
            }
        }
    }

    public void btnClearProduitcommande(){
        IDProduitText.setText("");
        QuantiteCommandText.setText("");
        IDClienttext.setText("");
        DateCommandText.setText("");
        Data.id=0;
    }

    public void selectCommande(){
        Commande commande=tableCommand.getSelectionModel().getSelectedItem();
        int num=tableCommand.getSelectionModel().getSelectedIndex();
        if(num-1<-1){  return; }
        Data.IdCommande=commande.getNumerocommande();
        showCommandesProduit();
    }
    public ObservableList<Produit>  menuProduit() {
        ObservableList<Produit> listData=FXCollections.observableArrayList();
        String sql= "SELECT * FROM produit";
        connection=DbConnection.getConnect();
        try{
            prepare=connection.prepareStatement(sql);
            result=prepare.executeQuery();
            Produit produit;
            while(result.next()){
                produit=new Produit(result.getInt("numeroproduit"), result.getString("nom"),
                        result.getDouble("prix"),result.getInt("quantite"),result.getString("image") );
                listData.add(produit);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;

    }
    public void menuDisplayCard(){

        Cardlistdata.clear();
        Cardlistdata.addAll(menuProduit());
        int row=0;
        int colum=0;
        listproGridpane.getChildren().clear();
        listproGridpane.getRowConstraints().clear();
        listproGridpane.getColumnConstraints().clear();

        for (int q=0; q<Cardlistdata.size();q++){
             try{
                 FXMLLoader load=new FXMLLoader();
                 load.setLocation(getClass().getResource("/Fxml/CardProduit.fxml"));
                 AnchorPane pane= load.load();
                 CardProduit card=load.getController();
                 card.setData(Cardlistdata.get(q));
                 if(colum==5){
                     colum=0;
                     row+=1;
                 }
                 listproGridpane.add(pane,colum++,row);
                 GridPane.setMargin(pane,new Insets(10));

             }catch(Exception e){
                 e.printStackTrace();
             }
        }
    }

//Gestion produit
    public void deleteData(){
        if(Data.id==0){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this product  ?");
            alert.showAndWait();
            Optional<ButtonType> option =alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                String delete="DELETE FROM produit WHERE numeroproduit= "+Data.id;
                try{
                prepare=connection.prepareStatement(delete);
                prepare.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete!");
                    alert.showAndWait();
                    showProduits();
                    btnClear();

                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
            else{
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();

            }


        }
    }
    public void updateData(){
        if(NomProduitText.getText().isEmpty()||QuantiteText.getText().isEmpty()|| prixText.getText().isEmpty()
                || IDproduitText.getText().isEmpty()){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        }
        else{
            String path=Data.path;
            path=path.replace("\\","\\\\");
            String update="UPDATE produit SET"+" numeroproduit='"+IDproduitText.getText()+"',nom='"
                    +NomProduitText.getText()+"',quantite='"+QuantiteText.getText()+"',prix='"+prixText.getText()
                    +"',image='"+path+"' WHERE numeroproduit = "+Data.id;
            connection =DbConnection.getConnect();
            try{
                    alert=new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to update ID  "+ IDproduitText.getText()+" ? ");
                    alert.showAndWait();
                    Optional<ButtonType> option =alert.showAndWait();

                    if(option.get().equals(ButtonType.OK)){
                        prepare=connection.prepareStatement(update);
                        prepare.executeUpdate();
                        alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Valid");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Update!");
                        alert.showAndWait();
                        showProduits();
                        btnClear();

                    }
                    else{
                        alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled");
                        alert.showAndWait();

                    }


            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public void selectData(){
        Produit pro=tableview.getSelectionModel().getSelectedItem();
        int num=tableview.getSelectionModel().getSelectedIndex();
        if(num-1<-1){ return ;}
        IDproduitText.setText(String.valueOf(pro.getId()));
        NomProduitText.setText(pro.getNom());
        QuantiteText.setText(String.valueOf(pro.getQuantite()));
        prixText.setText(String.valueOf(pro.getPrix()));
         Data.path=pro.getImage();
        String path="File:"+pro.getImage();
        Data.id=pro.getId();
        image=new Image(path,120,127,false,true);
        imageProduit.setImage(image);

    }
    public void enventAdd(){
        if(NomProduitText.getText().isEmpty()||QuantiteText.getText().isEmpty()|| prixText.getText().isEmpty()
        || IDproduitText.getText().isEmpty()){

         alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText(null);
         alert.setContentText("Please fill all blank fields");
         alert.showAndWait();
        }
        else{
            String checkProdID="SELECT numeroproduit FROM produit WHERE numeroproduit='"+IDproduitText.getText()+"'";
            connection =DbConnection.getConnect();
            try{
                stat = connection.createStatement();
                result=stat.executeQuery(checkProdID);
                Produit pro;
                if(result.next()){
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText( IDproduitText.getText()+"is already taken");
                    alert.showAndWait();
                }
                else{
                    String insert="INSERT INTO produit"+"(numeroproduit,nom,quantite,prix,image)"+"VALUES(?,?,?,?,?)";
                    prepare=connection.prepareStatement(insert);
                    prepare.setString(1,IDproduitText.getText());
                    prepare.setString(2,NomProduitText.getText());
                    prepare.setString(3,QuantiteText.getText());
                    prepare.setString(4,prixText.getText());
                    String path=Data.path;
                    path=path.replace("\\","\\\\");
                    prepare.setString(5,path);
                    prepare.executeUpdate();
                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Valid");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    showProduits();
                    btnClear();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
public void btnClear(){
    NomProduitText.setText("");
    QuantiteText.setText("") ;
    prixText.setText("");
    IDproduitText.setText("");
    Data.path="";
    Data.id=0;
    imageProduit.setImage(null);
}
    public void ImportImage(){
        FileChooser openf=new FileChooser();
        openf.getExtensionFilters().add(new FileChooser.ExtensionFilter("insert image","*png","*jpg","*jpge"));
        File file= openf.showOpenDialog(imageProduit.getScene().getWindow());
        if(file !=null){
            Data.path=file.getAbsolutePath();
            image=new Image(file.toURI().toString(),120,127,false,true);
            imageProduit.setImage(image);
        }
    }

    public ObservableList<Produit> inventoryDatalist(){
        ObservableList<Produit> listproduit= FXCollections.observableArrayList();
        String sql="SELECT * FROM produit";
        connection =DbConnection.getConnect();
        try{
            stat = connection.createStatement();
            result=stat.executeQuery(sql);
            Produit pro;
            while(result.next()){
                pro=new Produit(result.getInt("numeroproduit"),result.getString("nom"),
                        result.getDouble("prix"),result.getInt("quantite"),result.getString("image") );
                listproduit.add(pro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listproduit;
    }
    private ObservableList<Produit> inventoryList;
    //show les produit dans le tableau produit
    public void showProduits() {
        inventoryList = inventoryDatalist();
        columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Columnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colunprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tableview.setItems(inventoryList);
    }

    public void displayUsername(){
        String  user= Data.username;
         user=user.substring(0,1).toUpperCase() +user.substring(1);
         admin.setText(user);
    }
    public void Logout(){
        try{
            alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout");
            Optional<ButtonType> option=alert.showAndWait();
            if(option.get().equals(ButtonType.OK)){
                logout.getScene().getWindow().hide();
                FXMLLoader Loader=new FXMLLoader(getClass().getResource("/Fxml/hello-view.fxml"));
                Scene scene=null;
                try {
                    scene = new Scene(Loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.setTitle("Actuel");
                stage.show();

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




    // gestion livraison
    @FXML
    private void selectLivraison(MouseEvent event) {
        Livraison lv = tableviewLivr.getSelectionModel().getSelectedItem();
        if (lv != null) {
            numerocommandeLiv.setText(String.valueOf(lv.getNumeroCommande()));
            numeroFactureLivr.setText(String.valueOf(lv.getNumeroFacture()));
            DateLivraison.setText(String.valueOf(lv.getDateLivraison()));

            showDetailsLivBon();
            ObservableList<ProduitFactureLivr> liv = getProduitsByFacture(lv.getNumeroFacture());

            // Calculate total prices
            double totalTVAValue = liv.stream()
                    .mapToDouble(ProduitFactureLivr::getMontantTTC)
                    .map(montant -> montant * 0.20) //  TVA (20%)
                    .sum();

            double totalTTCValue = liv.stream()
                    .mapToDouble(ProduitFactureLivr::getMontantTTC)
                    .sum();

            double totalMontantValue = liv.stream()
                    .mapToDouble(ProduitFactureLivr::getMontantTTC)
                    .sum();

            // Display total prices
            Total_TVA.setText(String.format("%.2f$", totalTVAValue));
            Total_TTC.setText(String.format("%.2f$", totalTTCValue));
            Montant.setText(String.format("%.2f$", totalMontantValue));

        }

    }



    public void btnClearLiv() {
        numerocommandeLiv.clear();
        DateLivraison.clear();
        numeroFactureLivr.clear();
    }

    @FXML
    public void showlivraison() {
        ObservableList<Livraison> livlist = getLivraisonData();
        ColumNumeroLivraison.setCellValueFactory(new PropertyValueFactory<>("idLivraison"));
        ColumnumeroCommandLivraison.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
        ColumDateLivraison.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        ColumNumeroFactureLivraison.setCellValueFactory(new PropertyValueFactory<>("numeroFacture"));
        tableviewLivr.setItems(livlist);
    }

    public ObservableList<Livraison> getLivraisonData() {
        ObservableList<Livraison> livlist = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Livraison";
        connection = DbConnection.getConnect();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idLivraison = resultSet.getInt("numeroLivraison");
                int numeroCommande = resultSet.getInt("numeroCommande");
                Date dateLivraison = resultSet.getDate("dateLivraison");
                int numeroFacture = resultSet.getInt("numeroFacture");
                Livraison livraison = new Livraison(idLivraison, numeroCommande, dateLivraison, numeroFacture);
                livlist.add(livraison);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livlist;
    }

    @FXML
    private void addLiv() {
        String dateLivraison = DateLivraison.getText();
        String numeroCommandeStr = numerocommandeLiv.getText();
        String numeroFactureStr = numeroFactureLivr.getText();

        if (dateLivraison.isEmpty() || numeroCommandeStr.isEmpty() || numeroFactureStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        int numeroCommande;
        int numeroFacture;

        try {
            numeroCommande = Integer.parseInt(numeroCommandeStr);
            numeroFacture = Integer.parseInt(numeroFactureStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Le numéro de commande et le numéro de facture doivent être des nombres.");
            return;
        }
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmation");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Voulez-vous vraiment Ajouter cette livraison ?");
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            String sql = "INSERT INTO Livraison (numeroCommande, dateLivraison, numeroFacture) VALUES (?, ?, ?)";
            connection = DbConnection.getConnect();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, numeroCommande);
                preparedStatement.setDate(2, java.sql.Date.valueOf(dateLivraison));
                preparedStatement.setInt(3, numeroFacture);
                preparedStatement.executeUpdate();
                showAlert(Alert.AlertType.CONFIRMATION, "Annonce"," Livraison added successfully!");
                btnClearLiv();
            } catch (SQLException e) {

                if (e.getErrorCode() == 1062 || e.getSQLState().equals("23000")) { // Code SQL pour violation de contrainte d'unicité
                    showAlert(Alert.AlertType.ERROR, "Erreur", "Le numéro de facture existe déjà. Veuillez entrer un numéro de facture unique.");
                } else {
                    e.printStackTrace();
                }
                return;
            }
            showlivraison();
            btnClearLiv();
        }}

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void deleteLiv() {
        Livraison selectedLivraison = tableviewLivr.getSelectionModel().getSelectedItem();
        if (selectedLivraison == null) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner une livraison à supprimer.");
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        showAlert(Alert.AlertType.ERROR, "Erreur", "Voulez-vous vraiment supprimer cette livraison ?");
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            String sql = "DELETE FROM Livraison WHERE numeroLivraison = ?";
            connection = DbConnection.getConnect();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, selectedLivraison.getIdLivraison());
                preparedStatement.executeUpdate();
                showAlert(Alert.AlertType.CONFIRMATION, "Annonce","livraison suprimer");

            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            showlivraison();
        }
    }

    @FXML
    private void updateLiv() {
        Livraison selectedLivraison = tableviewLivr.getSelectionModel().getSelectedItem();
        if (selectedLivraison == null) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Please fill all blank fields");
            return;
        }

        String dateLivraison = DateLivraison.getText();
        String numeroCommandeStr = numerocommandeLiv.getText();
        String numeroFactureStr = numeroFactureLivr.getText();

        if (dateLivraison.isEmpty() || numeroCommandeStr.isEmpty() || numeroFactureStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        int numeroCommande;
        int numeroFacture;
        try {
            numeroCommande = Integer.parseInt(numeroCommandeStr);
            numeroFacture = Integer.parseInt(numeroFactureStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Le numéro de commande et le numéro de facture doivent être des nombres.");
            return;
        }
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        showAlert(Alert.AlertType.ERROR, "Erreur", "Voulez-vous modifier cette livraison ?");
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            String sql = "UPDATE livraison SET numeroCommande = ?, dateLivraison = ?, numeroFacture = ? WHERE numeroLivraison = ?";
            connection = DbConnection.getConnect();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, numeroCommande);
                preparedStatement.setDate(2, java.sql.Date.valueOf(dateLivraison));
                preparedStatement.setInt(3, numeroFacture);
                preparedStatement.setInt(4, selectedLivraison.getIdLivraison());
                preparedStatement.executeUpdate();
                showAlert(Alert.AlertType.CONFIRMATION, "Annonce"," Livraison updated successfully");
            } catch (SQLException e) {
                if (e.getErrorCode() == 1062 || e.getSQLState().equals("23000")) { // Code SQL pour violation de contrainte d'unicité
                    showAlert(Alert.AlertType.ERROR, "Erreur", "Le numéro de facture existe déjà. Veuillez entrer un numéro de facture unique.");
                } else {
                    e.printStackTrace();
                }
                return;
            }

            showlivraison();
            btnClearLiv();
        }
    }

    @FXML
    public void searchLivraisonByDate() {

        String searchTerm = SearchByDateLiv.getText().toLowerCase();
        ObservableList<Livraison> livlist = getLivraisonData();

        FilteredList<Livraison> filterlist = new FilteredList<>(livlist, p -> true);

        filterlist.setPredicate(facture -> {
            if (searchTerm == null || searchTerm.isEmpty()) {
                return true;
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date searchDate = formatter.parse(searchTerm);

                java.util.Date factureDate = facture.getDateLivraison();

                return formatter.format(factureDate).equals(formatter.format(searchDate));
            } catch (ParseException e) {
                return false;
            }
        });

        tableviewLivr.setItems(filterlist);
    }

    // ######################········Tout ce qui concerne le bon ········################################


    @FXML
    public String getContentFromBon() {
        StringBuilder contentBuilder = new StringBuilder();

        // Informations générales de la facture
        contentBuilder.append("\t\t\t\t\t Date de la Livraison   : ").append(DateLivraisonInstall.getText()).append("\n");
        contentBuilder.append("Numero de la Livraison : ").append(NumeroLivraisonInstall.getText()).append("\n");
        contentBuilder.append("Numero de la Facture   : ").append(NumeroFactureLivInstall.getText()).append("\n\n");

        contentBuilder.append("--------------------------------------------------------------\n\n");

        // Informations sur le client
        contentBuilder.append("Details de la Commande   :\n");
        contentBuilder.append("Numero du Commande : ").append(NumeroCommandeLivInstall.getText()).append("\n");
        contentBuilder.append("Date du Livraison  : ").append(DateCommandeLivInstall.getText()).append("\n");


        contentBuilder.append("\n\n--------------------------------------------------------------\n\n");

        contentBuilder.append("Details de la Factures   :\n");
        contentBuilder.append("--------------------------------------------------------------\n");
        contentBuilder.append("Numero \tDescription \tQuantite\tPrix\tTVA\tMontant TTC\n");
        contentBuilder.append("--------------------------------------------------------------\n");

        ObservableList<ProduitFactureLivr> items = tableviewInstallivBon.getItems();
        for (ProduitFactureLivr item : items) {
            contentBuilder.append(item.getNumeroProduit()).append("\t")
                    .append(item.getNomProduit()).append("\t")
                    .append(item.getQuantite()).append("\t\t")
                    .append(item.getPrix()).append("\t")
                    .append(item.getTva()).append("\t")
                    .append(item.getMontantTTC()).append("\n");
        }

        contentBuilder.append("\n--------------------------------------------------------------\n\n");

        contentBuilder.append("Total TVA   : ").append(Total_TVA.getText()).append("\n");
        contentBuilder.append("Total TTC   : ").append(Total_TTC.getText()).append("\n");
        contentBuilder.append("Montant     : ").append(Montant.getText()).append("\n");

        return contentBuilder.toString();
    }

    @FXML
    public void saveContentToFileBon() {
        String content = getContentFromBon();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le fichier");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers texte (*.txt)", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if (selectedFile != null) {
            try {
                FileWriter fileWriter = new FileWriter(selectedFile);
                fileWriter.write(content);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<ProduitFactureLivr> getProduitsByFacture(int numeroFacture) {
        ObservableList<ProduitFactureLivr> listProduits = FXCollections.observableArrayList();
        String sql = "SELECT p.numeroproduit, p.nom, cp.quantitecommande, p.prix, " +
                "(cp.quantitecommande * p.prix * 1.20) AS montantTTC " + // 20% TVA
                "FROM produit p " +
                "JOIN factureproduit fp ON fp.numeroproduit = p.numeroproduit  " +
                "JOIN facteur f ON f.numerofacteur = fp.numerofacture " +
                "JOIN commande_produit cp ON p.numeroproduit = cp.numeroproduit && cp.numerocommande=f.numerocommande " +
                "JOIN Livraison l ON l.numeroFacture = f.numerofacteur " +
                "WHERE  l.numeroFacture = ?";
        try {
            connection = DbConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, numeroFacture);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                double prix = resultSet.getDouble("prix");
                int quantite = resultSet.getInt("quantitecommande");
                double montantTTC = resultSet.getDouble("montantTTC");
                double montant = quantite * prix;

                ProduitFactureLivr liv = new ProduitFactureLivr(
                        resultSet.getInt("numeroproduit"),
                        resultSet.getString("nom"),
                        quantite,
                        prix,
                        20.0,
                        montantTTC
                );
                listProduits.add(liv);



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduits;
    }



    public void showDetailsLivBon() {
        Livraison lv = tableviewLivr.getSelectionModel().getSelectedItem();

        if (lv != null) {
            DateLivraisonInstall.setText(lv.getDateLivraison().toString());
            NumeroLivraisonInstall.setText(String.valueOf(lv.getIdLivraison()));
            NumeroFactureLivInstall.setText(String.valueOf(lv.getNumeroFacture()));
            NumeroCommandeLivInstall.setText(String.valueOf(lv.getNumeroCommande()));

            listCommande = CommandeDatalist();
            for (Commande commande : listCommande) {
                if (commande.getNumerocommande() == lv.getNumeroCommande()) {
                    Date dateCommande = commande.getDatecommande();
                    if (dateCommande != null) {
                        DateCommandeLivInstall.setText(dateCommande.toString());
                    } else {
                        DateCommandeLivInstall.setText("Date de commande non disponible");
                    }
                    break;
                }}

            ObservableList<ProduitFactureLivr> liv = getProduitsByFacture(lv.getNumeroFacture());
            NumeroProduitInstall1.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
            ClmNomProduitInstall1.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
            QuantiteProduitInstall1.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            PrixInstall1.setCellValueFactory(new PropertyValueFactory<>("prix"));
            PrixTVA.setCellValueFactory(new PropertyValueFactory<>("tva"));
            MontantTTC.setCellValueFactory(new PropertyValueFactory<>("montantTTC"));
            tableviewInstallivBon.setItems(liv);

        }

    }

    public void btnClearLivBon() {
        DateLivraisonInstall.setText("DateLivraison");
        NumeroLivraisonInstall.setText("NumeroLivraison");
        NumeroFactureLivInstall.setText("NumeroFacture");
        NumeroCommandeLivInstall.setText("NumeroCommande");
        DateCommandeLivInstall.setText("DateCommande");
        Livraison selectedFacture = tableviewLivr.getSelectionModel().getSelectedItem();

        if (selectedFacture != null) {
            int numeroLivraison = selectedFacture.getIdLivraison();
            ObservableList<ProduitFactureLivr> produitsFacture = getProduitsByFacture(numeroLivraison);
            tableviewInstallivBon.setItems(produitsFacture);
        }

        Total_TVA.setText("");
        Total_TTC.setText("");
        Montant.setText("");
    }

    // fin gestion livraison

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        showProduits();
        menuDisplayCard();
        showCommandes();
        showClients();
        showfacture();
        showlivraison();
        Data.IdCommande=0;
        Data.IDClient=101;
        Data.date = Date.valueOf(LocalDate.now());
    }

}