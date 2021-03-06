package Controller;

import Scenes.*;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Controller {
    private final Stage mainStage;
    private final MainMenuScene mainMenuScene = new MainMenuScene();
    private final GameScene gameScene = new GameScene();
    private final ScoreBoardScene scoreBoardScene = new ScoreBoardScene();
    private final OptionsScene optionsScene = new OptionsScene();

    public Controller(Stage primaryStage) {
        mainStage = primaryStage;
        mainStage.setScene(mainMenuScene.getScene());
        mainStage.getIcons().add(mainMenuScene.getSnakeImage());
        mainStage.setTitle("Snake");
        setUpEvents();
        mainStage.setResizable(false);
        mainStage.show();
    }

    private void setUpEvents() {
        // main menu scene events
        mainMenuScene.getPlayButton().setOnAction(actionEvent -> {
            mainStage.setTitle("Snake: Play");
            mainStage.setScene(gameScene.getScene());
            mainStage.show();
            gameScene.startGame(true);
        });
        mainMenuScene.getScoreBoardButton().setOnAction(actionEvent -> {
            mainStage.setScene(scoreBoardScene.getScene());
            mainStage.setTitle("Snake: Score board");
            mainStage.show();
        });
        mainMenuScene.getOptionsButton().setOnAction(actionEvent -> {
            mainStage.setScene(optionsScene.getScene());
            mainStage.setTitle("Snake: Options");
            mainStage.show();
        });
        mainMenuScene.getExitButton().setOnAction(e -> Platform.exit());
        // game scene events
        gameScene.getExitButton().setOnAction(actionEvent -> {
            //gameScene
            mainStage.setScene(mainMenuScene.getScene());
            mainStage.setTitle("Snake");
            mainStage.show();
        });
        // score board events
        scoreBoardScene.getExitButton().setOnAction(actionEvent -> {
            mainStage.setScene(mainMenuScene.getScene());
            mainStage.setTitle("Snake");
            mainStage.show();
        });
        // options scene events
        optionsScene.getExitButton().setOnAction(actionEvent -> {
            mainStage.setScene(mainMenuScene.getScene());
            mainStage.setTitle("Snake");
            mainStage.show();
        });
    }
}
