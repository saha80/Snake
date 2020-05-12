package Scenes;

import Game.Game;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import static Game.Entities.Field.FIELD_SIZE;

public class GameScene {
    private final Scene scene;
    private final Game game = new Game();
    private boolean isGameHasStarted = false;
    private final Button exitButton = new Button("X");
    private final VBox rootLayout = new VBox();

    public GameScene() {
        exitButton.setStyle("-fx-color: black;" +
                            "-fx-focus-color:-fx-control-inner-background;" +
                            "-fx-faint-focus-color: -fx-control-inner-background;");
        rootLayout.setStyle("-fx-background-color: black");
        rootLayout.getChildren().addAll(exitButton, game.getCanvas());
        scene = new Scene(rootLayout, FIELD_SIZE, FIELD_SIZE);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            game.setNewDirection(Game.getDirectionByKey(keyEvent.getCode()));
        });
    }

    public String getScore() {
        return "";
    }

    public void startGame(boolean b) {
        isGameHasStarted = b;
        if (isGameHasStarted) {
            //rootLayout.getChildren().add(game.getCanvas());
            //dgame = new Game();
            game.gameLoop();
        }
    }

    public Scene getScene() {
        return scene;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
