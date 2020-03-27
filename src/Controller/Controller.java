package Controller;

import Scenes.GameScene;
import Scenes.MainMenu;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Stage mainStage;
    private MainMenu menu;
    private GameScene gameScene = null;

    public Controller(Stage stage) {
        mainStage = stage;
        menu.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getID()) {
            case 0:
                gameScene = new GameScene();
                mainStage.setScene(gameScene.getScene());
                gameScene.startGame();
                break;
            case 1:

                break;
            case 2:
                break;
        }
    }
}
