package GameWithDates;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage stage;

    private static Menu menu = new Menu();
    static Scene menuScene = new Scene(menu); //сцена с меню

    private static Rules rules = new Rules();
    static Scene rulesScene = new Scene(rules); //сцена с правилами

    private static Game game = new Game();
    static Scene gameScene = new Scene(game); //сцена с игрой

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Game");
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setScene(menuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}