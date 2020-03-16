package MainMenu;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class MainMenu {
    private Button playButton = new Button("Play");
    private Button scoreboardButton = new Button("Score board");
    private Button optionsButton = new Button("Options");
    private Button exitButton = new Button("Exit");
    private VBox vBox = new VBox();

    public MainMenu() {
        playButton.setMaxWidth(Double.MAX_VALUE);
        scoreboardButton.setMaxWidth(Double.MAX_VALUE);
        optionsButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setOnAction(e -> Platform.exit());
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        final double indent = 50;
        vBox.setPadding(new Insets(0, indent, 0, indent));
        vBox.getChildren().addAll(playButton, scoreboardButton, optionsButton, exitButton);
    }

    public VBox getvBox() {
        return vBox;
    }
}
