package Application;


import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

import Scenes.MainMenuScene;


public class Main extends Application {
    private MainMenuScene mainMenu = new MainMenuScene();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Controller(primaryStage);
//        primaryStage.setTitle("Snake");
//        //Scene scene = new Scene(mainMenu.getScene(), 300, 275);
//        primaryStage.setScene(mainMenu.getScene());
//        primaryStage.setResizable(false);
//        primaryStage.show();
    }
}
