package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void startButton() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}