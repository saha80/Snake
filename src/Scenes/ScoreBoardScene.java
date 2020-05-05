package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;

import static Scenes.MainMenuScene.MAIN_MENU_HEIGHT;
import static Scenes.MainMenuScene.MAIN_MENU_WIDTH;

public class ScoreBoardScene {
    private final Scene scene;
    private final Button exitButton = new Button("X");
    private final VBox rootLayout = new VBox();

    private final HBox scoreTable = new HBox();
    private final ListView<String> number = new ListView<>();
    private final ListView<String> name = new ListView<>();
    private final ListView<String> score = new ListView<>();

    private BufferedWriter out;
    private BufferedReader in;

    public ScoreBoardScene() {
        initRootLayout();
        scene = new Scene(rootLayout, MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT);
    }

    private void initRootLayout() {
        HBox exitAndTitle = new HBox();
        exitAndTitle.getChildren().addAll(exitButton, new Label("Score board"));
        exitAndTitle.setAlignment(Pos.TOP_LEFT);
        exitAndTitle.setSpacing((double) MAIN_MENU_WIDTH / 3);

        number.getItems().add("№");
        name.getItems().add("Nickname");
        score.getItems().add("Score");
        try {
            out = new BufferedWriter(new FileWriter("ScoreBoard.txt"));
            in = new BufferedReader(new FileReader("ScoreBoard.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                number.getItems().add(String.valueOf(number.getItems().size()));
                name.getItems().add(line.split(" ")[0]);
                score.getItems().add(line.split(" ")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scoreTable.getChildren().addAll(number, name, score);
        rootLayout.getChildren().addAll(exitAndTitle, scoreTable);
        rootLayout.setStyle("-fx-font-size:14");
    }

    public void writeScore(String score) {
        try {
            out.append(score).append(String.valueOf('\n'));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
