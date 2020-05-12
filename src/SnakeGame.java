import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        new Controller(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
