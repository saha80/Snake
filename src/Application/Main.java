package Application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import MainMenu.MainMenu;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snake");
        //StackPane root = new StackPane();
        MainMenu mainMenu = new MainMenu();
        Scene scene = new Scene(mainMenu.getvBox(), 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}
