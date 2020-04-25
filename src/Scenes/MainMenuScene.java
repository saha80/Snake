package Scenes;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

import java.io.*;

public class MainMenuScene {
    public static final int MAIN_MENU_WIDTH = 400;
    public static final int MAIN_MENU_HEIGHT = 400;
    private Button playButton = new Button("Play");
    private Button scoreboardButton = new Button("Score board");
    private Button optionsButton = new Button("Options");
    private Button exitButton = new Button("Exit");
    private final Image snakeImage = new Image(
            (new File("C:/Users/Alex/IdeaProjects/Snake/resources/snake icon.png")).toURI().toString());
    private VBox rootLayout = new VBox();
    private Scene scene;

    public MainMenuScene() {
        initRootLayout();
        scene = new Scene(rootLayout, MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT);
    }

    private void initRootLayout() {
        final double indent = 50;
        // init buttons
        playButton.setMaxWidth(Double.MAX_VALUE);
        scoreboardButton.setMaxWidth(Double.MAX_VALUE);
        optionsButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setMaxWidth(Double.MAX_VALUE);
        // init layout
        rootLayout.setSpacing(10);
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setMinSize(100, 100);
        rootLayout.setPadding(new Insets(0, indent, 0, indent));
        ImageView imageView = new ImageView(snakeImage);
        imageView.setFitWidth(snakeImage.getWidth() / 4);
        imageView.setFitHeight(snakeImage.getHeight() / 4);
        rootLayout.setStyle("-fx-font-size:14");
        rootLayout.getChildren().addAll(imageView, playButton, scoreboardButton, optionsButton, exitButton);
    }

    public Scene getScene() {
        return scene;
    }

    public Image getSnakeImage() {
        return snakeImage;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getScoreBoardButton() {
        return scoreboardButton;
    }

    public Button getOptionsButton() {
        return optionsButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
