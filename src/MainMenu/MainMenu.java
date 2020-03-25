package MainMenu;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu {
    private Button playButton = new Button("Play");
    private Button scoreboardButton = new Button("Score board");
    private Button optionsButton = new Button("Options");
    private Button exitButton = new Button("Exit");
    private ImageView imageView = new ImageView(new Image(new File("\"C:\\Users\\Alex\\Desktop\\snake icon.jpg\"").toURI().toString()));
    private VBox verticalLayout = new VBox();

    public MainMenu() {
        initButtons();
        initVBox();
    }

    public VBox getvBox() {
        return verticalLayout;
    }

    private void initButtons() {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                
            }
        };
        playButton.setMaxWidth(Double.MAX_VALUE);
        scoreboardButton.setMaxWidth(Double.MAX_VALUE);
        optionsButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setOnAction(e -> Platform.exit());
    }

    private void initVBox() {
        final double indent = 50;
        verticalLayout.setSpacing(10);
        verticalLayout.setAlignment(Pos.CENTER);
        verticalLayout.setMinSize(100, 100);
        verticalLayout.setPadding(new Insets(0, indent, 0, indent));
        verticalLayout.getChildren().addAll(imageView, playButton, scoreboardButton, optionsButton, exitButton);
    }
}
