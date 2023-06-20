package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com.example.demo.view/hello-view.fxml"));
            Parent fxmlroot = fxmlLoader.load();

            // Créer un conteneur de mise en page
            VBox vbox = new VBox();

            // Obtenir la taille de l'écran
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            // Définir les dimensions de la fenêtre
            double width = bounds.getWidth();
            double height = bounds.getHeight() - 20;

            // Ajouter la racine du fichier FXML et le Vbox à un conteneur parent
            Parent root = new VBox(fxmlroot, vbox);

            // Créer une scène avec le conteneur parent
            Scene scene = new Scene(root, width, height);

            // Définir la scène sur la fenêtre principale
            primaryStage.setScene(scene);


            // Centrer la fenêtre sur l'écran
            primaryStage.centerOnScreen();

            // Titre de la fenêtre principale
            primaryStage.setTitle("Discothèque chez Lauth");

            // Affichage de la fenêtre
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}