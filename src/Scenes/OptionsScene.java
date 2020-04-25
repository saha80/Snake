package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import static Scenes.MainMenuScene.MAIN_MENU_WIDTH;
import static Scenes.MainMenuScene.MAIN_MENU_HEIGHT;

public class OptionsScene {
    private Scene scene;
    private Button exitButton = new Button("X");
    private Slider slider = new Slider(0, 2, 0);
    private ColorPicker colorPickerForSnake = new ColorPicker();
    private ColorPicker colorPickerForBackground = new ColorPicker();
    private VBox rootLayout = new VBox();
    private BufferedWriter out; // "Options.txt";
    private BufferedReader in; // "Options.txt";

    public OptionsScene() {
        initRootLayout();
        scene = new Scene(rootLayout, MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT);
    }

    private void initRootLayout() {
        HBox exitAndTitle = new HBox();
        exitAndTitle.getChildren().addAll(exitButton, new Label("Options"));
        exitAndTitle.setAlignment(Pos.TOP_LEFT);
        exitAndTitle.setSpacing((double) MAIN_MENU_WIDTH / 3);

        initSlider();

        HBox difficulty = new HBox();
        difficulty.getChildren().addAll(new Label("Difficulty"), slider);
        difficulty.setAlignment(Pos.CENTER);
        difficulty.setSpacing(10);

        colorPickerForSnake.setValue(Color.GREEN);
        colorPickerForSnake.setOnAction(actionEvent -> {
            //todo: save in file
        });
        colorPickerForBackground.setValue(Color.BLACK);
        colorPickerForBackground.setOnAction(actionEvent -> {
            //todo: save in file
        });

        HBox snakeColor = new HBox();
        snakeColor.getChildren().addAll(new Label("Snake color"), colorPickerForSnake);
        snakeColor.setAlignment(Pos.CENTER);
        snakeColor.setSpacing(10);

        HBox backgroundColor = new HBox();
        backgroundColor.getChildren().addAll(new Label("Background color"), colorPickerForBackground);
        backgroundColor.setAlignment(Pos.CENTER);
        backgroundColor.setSpacing(10);

        rootLayout.setSpacing(10);
        rootLayout.setStyle("-fx-font-size:14");
        rootLayout.getChildren().addAll(exitAndTitle, difficulty, snakeColor, backgroundColor);
    }

    private void initSlider() {
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit(1);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setLabelFormatter(new StringConverter<>() {
            @Override
            public String toString(Double n) {
                if (n < 0.5) return "Easy";
                if (n < 1.5) return "Normal";
                if (n < 2.5) return "Hard";
                return "";
            }

            @Override
            public Double fromString(String s) {
                if (s.equals("Easy")) return 0d;
                if (s.equals("Normal")) return 1d;
                if (s.equals("Hard")) return 2d;
                return 0d;
            }
        });
        slider.setOnDragDone(dragEvent -> {
            //todo: save in file
        });
    }

    public Scene getScene() {
        return scene;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
