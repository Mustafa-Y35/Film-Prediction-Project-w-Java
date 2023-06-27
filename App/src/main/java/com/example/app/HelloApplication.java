package com.example.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static final int MAX_ATTEMPTS = 5;
    private static final int BOX_COUNT = 6;

    private TextField guessField;
    private VBox boxContainer;
    private int attemptCount;

    @Override
    public void start(Stage primaryStage) {
        guessField = new TextField();
        Button guessButton = new Button("Guess");
        guessButton.setOnAction(event -> handleGuess());

        HBox inputContainer = new HBox(10);
        inputContainer.setAlignment(Pos.CENTER);
        inputContainer.getChildren().addAll(guessField, guessButton);

        boxContainer = new VBox(10);
        boxContainer.setAlignment(Pos.CENTER);

        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(inputContainer, boxContainer);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleGuess() {
        if (attemptCount >= MAX_ATTEMPTS) {
            showGameOverAlert();
            return;
        }

        String guess = guessField.getText().trim();
        if (!guess.isEmpty()) {
            createBoxes();
            guessField.clear();
            attemptCount++;
        }
    }

    private void createBoxes() {
        HBox boxRow = new HBox(5);
        boxRow.setAlignment(Pos.CENTER);

        for (int i = 0; i < BOX_COUNT; i++) {
            Button box = new Button();
            box.setPrefSize(30, 30);
            boxRow.getChildren().add(box);
        }

        boxContainer.getChildren().add(boxRow);
    }

    private void showGameOverAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setContentText("Do you want to try again?");

        ButtonType tryAgainButton = new ButtonType("Try Again");
        ButtonType exitButton = new ButtonType("Exit");

        alert.getButtonTypes().setAll(tryAgainButton, exitButton);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setOnCloseRequest(event -> System.exit(0));

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == tryAgainButton) {
                resetGame();
            } else if (buttonType == exitButton) {
                System.exit(0);
            }
        });
    }

    private void resetGame() {
        boxContainer.getChildren().clear();
        attemptCount = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
