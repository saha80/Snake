package Scenes;

import Game.Entities.Field;
import Game.Game;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import static Game.Entities.Field.FIELD_SIZE;

public class GameScene {
    private Scene scene;
    private Game game = new Game();
    private boolean isGameHasStarted = false;
    private Button exitButton = new Button("X");

    public GameScene() {
        VBox rootLayout = new VBox();
        exitButton.setStyle("-fx-color: black");
        exitButton.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");
        //exitButton.setStyle("-fx-background-color: #000000");
        //exitButton.setStyle("-fx-text-fill: #ffffff");
        rootLayout.setStyle("-fx-background-color: black");
        rootLayout.getChildren().addAll(exitButton, game.getCanvas());
        scene = new Scene(rootLayout, FIELD_SIZE, FIELD_SIZE);
    }

    public String getScore() {// todo: return game score
//        if (game.gameCycle()) {
//            return "";
//        }
        return "";
    }

    public void startGame(boolean b) {
        isGameHasStarted = b;
        if (isGameHasStarted) {
            game = new Game();
            scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
                game.setNewDirection(Game.getDirectionByKey(keyEvent.getCode()));
                System.out.println(keyEvent.getCode());
            });
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
