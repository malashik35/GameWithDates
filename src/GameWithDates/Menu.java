package GameWithDates;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import static GameWithDates.Main.*;

class Menu extends Pane { //панель с меню
    Menu() {
        setPrefSize(600, 350);
        setStyle("-fx-background-color: #2d2d2d");
        addButtons();
    }

    private void addButtons() { //метод для добавление на панель кнопок
        Button startButton = new Button(); //создание кнопки начала игры
        startButton.setText("Начать игру");
        startButton.setFont(new Font(18));
        startButton.setPrefSize(150, 40);
        startButton.setTranslateX(225);
        startButton.setTranslateY(115);
        startButton.setFocusTraversable(false);
        startButton.setOnAction(event -> {
            stage.setScene(gameScene); //при нажатии на кнопку открывается сцена с игрой
        });

        Button rulesButton = new Button(); //создание кнопки для вызова правил игры
        rulesButton.setText("Правила игры");
        rulesButton.setFont(new Font(18));
        rulesButton.setPrefSize(150, 40);
        rulesButton.setTranslateX(225);
        rulesButton.setTranslateY(170);
        rulesButton.setFocusTraversable(false);
        rulesButton.setOnAction(event -> {
            stage.setScene(rulesScene); //при нажатии на кнопку открывается сцена с правилами игры
        });

        getChildren().addAll(startButton, rulesButton); //добавление кнопок на панель
    }
}
