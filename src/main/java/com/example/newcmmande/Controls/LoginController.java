package com.example.newcmmande.Controls;

import com.example.newcmmande.Models.Data;
import com.example.newcmmande.Models.model;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class LoginController {

    @FXML
    private AnchorPane sideLoging;

    @FXML
    private TextField username;

    @FXML
    private Button login;

    @FXML
    private TextField password_text;

    @FXML
    private PasswordField password;

    @FXML
    private CheckBox show_password;

    @FXML
    private Hyperlink forget_password;

    @FXML
    private AnchorPane sideforme;

    @FXML
    private AnchorPane sideSingup;

    @FXML
    private TextField username1;

    @FXML
    private Button login1;

    @FXML
    private PasswordField password1;

    @FXML
    private TextField password_text1;

    @FXML
    private CheckBox show_password1;


    @FXML
    private void initialize() {
        // Vous pouvez ajouter du code d'initialisation ici
             // Masquer le mot de passe par défaut
            password.setVisible(true);
            password.setManaged(true);
            password_text.setVisible(false);
            password_text.setManaged(false);
        password1.setVisible(true);
        password1.setManaged(true);
        password_text1.setVisible(false);
        password_text1.setManaged(false);
    }

    @FXML
    private void redirectToDashboard(ActionEvent evennt) {
        try {
            // Charger la vue du tableau de bord
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle fenêtre pour le tableau de bord
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            // Ajouter un écouteur pour détecter lorsque la nouvelle fenêtre du tableau de bord est affichée
            dashboardStage.setOnShown(e -> {
                // Fermer la fenêtre de connexion
                Stage loginStage = (Stage) ((Node) evennt.getSource()).getScene().getWindow();
                loginStage.close();
            });
            // Afficher la nouvelle fenêtre du tableau de bord
            dashboardStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur de chargement", "Impossible de charger le tableau de bord.");
        }
    }



    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent evennt) {
        String usernameText = username.getText();
        String passwordText = password.getText();

        // Vérifier les informations d'identification
        if (checkCredentials(usernameText, passwordText)) {
            Data.username = usernameText; // Stockez le nom d'utilisateur dans la classe de données statique
            redirectToDashboard(evennt);
            System.out.println("Connexion réussie !");

        } else {
            // Afficher un message d'erreur
            showAlert(Alert.AlertType.ERROR, "Erreur de connexion", "Nom d'utilisateur ou mot de passe incorrect !");
        }
    }


    @FXML
    private void handleShowPasswordCheckBoxAction() {
        if (show_password.isSelected()) {
            // Afficher le mot de passe
            password_text.setText(password.getText());
            password_text.setVisible(true);
            password_text.setManaged(true);
            password.setVisible(false);
            password.setManaged(false);
        } else {
            // Masquer le mot de passe
            password.setText(password_text.getText());
            password.setVisible(true);
            password.setManaged(true);
            password_text.setVisible(false);
            password_text.setManaged(false);
        }
    }

    @FXML
    private void handleShowPassword1CheckBoxAction() {
        if (show_password1.isSelected()) {
            // Afficher le mot de passe
            password_text1.setText(password1.getText());
            password_text1.setVisible(true);
            password_text1.setManaged(true);
            password1.setVisible(false);
            password1.setManaged(false);
        } else {
            // Masquer le mot de passe
            password1.setText(password_text1.getText());
            password1.setVisible(true);
            password1.setManaged(true);
            password_text1.setVisible(false);
            password_text1.setManaged(false);
        }
    }

    @FXML
    public void switchGForme(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == forget_password) {
            slider.setNode(sideforme);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                sideSingup.setVisible(true);
                sideLoging.setVisible(false);
            });

            slider.play();
        } else if (event.getSource() == login1) {
            slider.setNode(sideforme);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                forget_password.setVisible(false);
                forget_password.setVisited(true);
            });

            slider.play();
        }
    }

    public boolean checkCredentials(String username, String password) {
        String sql = "SELECT * FROM admin WHERE userName = ? AND motdepasse = ?";
        try (Connection conn =DbConnection.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Retourne vrai si un utilisateur correspondant est trouvé
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Gérer l'erreur de connexion à la base de données
        }
    }
    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        String newUsername = username1.getText();
        String newPassword = password1.getText();

        // Perform validation if necessary
        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Username and password cannot be empty.");
            return;
        }

        // Save the new username and password to the database
        if (saveNewCredentials(newUsername, newPassword)) {
            // Transition back to the main login page
            TranslateTransition slider = new TranslateTransition();
            slider.setNode(sideforme);
            slider.setToX(-sideforme.getWidth()); // Slides completely to the left
            slider.setDuration(Duration.seconds(.5)); // Set the duration
            slider.setOnFinished(e -> {
                sideSingup.setVisible(false);
                sideLoging.setVisible(true);
                sideforme.setVisible(true);
            });
            slider.play();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save new credentials.");
        }
    }

    private boolean saveNewCredentials(String username, String password) {
        String sql = "insert into  admin (userName, motdepasse) VALUES (?,?)";
        try (Connection conn =DbConnection.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0; // Retourne true si au moins une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Gérer l'erreur de connexion à la base de données ou l'insertion des données
        }
    }
}
