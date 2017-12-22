package GameWithDates;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static GameWithDates.Main.*;

class Rules extends Pane { //панель с правилами игры
    Rules() {
        setPrefSize(600, 350); //устанавливаем размеры полей
        setStyle("-fx-background-color: #2d2d2d");
        addText();
        addBackButton();
    }

    private void addText() { //метод для добавление на панель текста
        Label head = new Label("Правила игры"); //создание заголовка
        head.setFont(new Font(28));
        head.setTextFill(Color.WHITE);
        head.setAlignment(Pos.CENTER);
        head.setPrefWidth(600);
        head.setTranslateY(30);

        Label text = new Label(); //создание текста правил
        text.setFont(new Font(20));
        text.setTextFill(Color.WHITE);
        text.setAlignment(Pos.CENTER);
        text.setTextAlignment(TextAlignment.JUSTIFY);
        text.setTranslateX(30);
        text.setPrefWidth(550);
        text.setTranslateY(85);
        text.setWrapText(true);//должен ли быть перенос
        text.setText("Задаётся какая-то дата (день и месяц). Каждый игрок на своём ходе называет более позднюю дату, " +
                "увеличивая на 1 или 2 либо день в месяце, либо месяц, но не то и другое сразу. " +
                "При этом сочетание дня и месяца должно оставаться датой. Игрок, назвавший 31 декабря, проигрывает.");

        getChildren().addAll(head, text); //добавление текста на панель
    }

    private void addBackButton() { //метод для добавление на панель кнопки "назад"
        Button backButton = new Button(); //создание кнопки "назад"
        backButton.setText("Назад");
        backButton.setFont(new Font(16));
        backButton.setPrefSize(95, 25);
        backButton.setTranslateX(30);
        backButton.setTranslateY(290);
        backButton.setFocusTraversable(false);
        backButton.setOnAction(event -> {
            stage.setScene(menuScene); //при нажатии на кнопку открывается сцена с меню
        });

        getChildren().add(backButton); //добавление кнопки на панель
    }
}
