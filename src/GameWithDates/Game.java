package GameWithDates;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.time.LocalDate;
import java.util.Random;

import static GameWithDates.Main.menuScene;
import static GameWithDates.Main.stage;

class Game extends Pane { //основная игровая панель
    private ScrollPane datePane = new ScrollPane();
    private Date date;
    private Label dateText = new Label();
    private Label information = new Label();
    private Boolean isMyTurn = true;

    Game() {
        setPrefSize(600, 350);
        setStyle("-fx-background-color: #2d2d2d");
        addButtons();
        addDateText();
        addLabels();
        addButtons();
        addPlusButtons();
    }

    private void addButtons() { //метод для добавление на панель кнопок
        Button startButton = new Button(); //создание кнопки начала новой игры
        startButton.setText("Начать новую игру");
        startButton.setFont(new Font(18));
        startButton.setPrefSize(200, 40);
        startButton.setTranslateX(370);
        startButton.setTranslateY(20);
        startButton.setFocusTraversable(false);
        startButton.setOnAction(event -> { //при нажатии на кнопку панель очищается, все элементы добавляются заново, генерируется новая дата
            getChildren().clear();
            addDateText();
            addLabels();
            addButtons();
            addPlusButtons();
        });

        Button backButton = new Button(); //создание кнопки "назад"
        backButton.setText("Назад в меню");
        backButton.setFont(new Font(18));
        backButton.setPrefSize(200, 40);
        backButton.setTranslateX(30);
        backButton.setTranslateY(20);
        backButton.setFocusTraversable(false);
        backButton.setOnAction(event -> {
            stage.setScene(menuScene); //при нажатии на кнопку открывается сцена с меню
        });

        getChildren().addAll(startButton, backButton); //добавление кнопок на панель
    }

    private void moveOfComputer() { //логика ходов компьютера
        int i = new Random().nextInt(4); //выбирает случайный ход
        if (i == 0) { //пытается прибавить 2 месяца, если это не получается - 1 месяц и так далее
            if (date.getDate().plusMonths(2).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(2));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (date.getDate().plusMonths(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 2) &&
                    date.getDate().plusDays(2).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(2));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isEqual(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
                information.setText("Ты выиграл!");
            }

        } else if (i == 1) { //пытается прибавить 1 месяц, если это не получается - 2 дня и так далее
            if (date.getDate().plusMonths(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());

            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 2) &&
                    date.getDate().plusDays(2).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(2));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());

            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isEqual(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
                information.setText("Ты выиграл!");
            }

        } else if (i == 2) { //пытается прибавить 2 дня, если это не получается - 1 день и так далее
            if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 2) &&
                    date.getDate().plusDays(2).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(2));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(date.toString());
            } else if (date.getDate().plusMonths(2).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(2));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (date.getDate().plusMonths(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isEqual(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
                information.setText("Ты выиграл!");
            }

        } else if (i == 3) { //пытается прибавить 1 день, если это не получается - 2 месяца и так далее
            if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (date.getDate().plusMonths(2).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(2));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (date.getDate().plusMonths(1).isBefore(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusMonths(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
            } else if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1) &&
                    date.getDate().plusDays(1).isEqual(LocalDate.of(-999999999, 12, 31))) {
                date.setDate(date.getDate().plusDays(1));
                dateText.setText(dateText.getText() + "\n Ход компьютера: " + date.toString());
                information.setText("Ты выиграл!");
            }
        }
        isMyTurn = true;
    }

    private void addLabels() { //метод для добавления на панель текстовых полей
        information.setText(""); //текстовое поле с информацией о неверном ходе/победе
        information.setFont(new Font(24));
        information.setTextFill(Color.WHITE);
        information.setPrefWidth(600);
        information.setAlignment(Pos.CENTER);
        information.setTranslateY(300);

        Label text0 = new Label("Твой ход:");
        text0.setFont(new Font(18));
        text0.setTextFill(Color.WHITE);
        text0.setTranslateX(40);
        text0.setTranslateY(85);

        getChildren().addAll(information, text0);
    }

    private void addPlusButtons() { //добавление кнопок для выбора хода
        Button dayPlusOne = new Button(); //создание кнопки "+1 к числу"
        dayPlusOne.setText("+1 к числу");
        dayPlusOne.setFont(new Font(14));
        dayPlusOne.setPrefSize(100, 20);
        dayPlusOne.setTranslateX(30);
        dayPlusOne.setTranslateY(120);
        dayPlusOne.setFocusTraversable(false);
        dayPlusOne.setOnAction(event -> { //при нажатии на кнопку проверяется на корректность получившаяся дата,
            if (isMyTurn) {               //если дата корректна, то делается ход, иначе выводится сообщение об ошибке
                if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 1)) {
                    information.setText("");
                    date.setDate(date.getDate().plusDays(1));
                    dateText.setText(dateText.getText() + "\n Твой ход: " + date.toString());
                    datePane.setVvalue(1.0);
                    if (date.getDate().isEqual(LocalDate.of(-999999999, 12, 31)))
                        information.setText("Ты проиграл!");
                    isMyTurn = false;
                    moveOfComputer();
                } else information.setText("Неверный ход");
            }
        });

        Button dayPlusTwo = new Button(); //создание кнопки "+2 к числу"
        dayPlusTwo.setText("+2 к числу");
        dayPlusTwo.setFont(new Font(14));
        dayPlusTwo.setPrefSize(100, 20);
        dayPlusTwo.setTranslateX(30);
        dayPlusTwo.setTranslateY(170);
        dayPlusTwo.setFocusTraversable(false);
        dayPlusTwo.setOnAction(event -> { //при нажатии на кнопку проверяется на корректность получившаяся дата,
            if (isMyTurn) {               //если дата корректна, то делается ход, иначе выводится сообщение об ошибке
                if (Date.isCorrectDate(date.getDate().getMonthValue(), date.getDate().getDayOfMonth() + 2)) {
                    information.setText("");
                    date.setDate(date.getDate().plusDays(2));
                    dateText.setText(dateText.getText() + "\n Твой ход: " + date.toString());
                    datePane.setVvalue(1.0);
                    if (date.getDate().isEqual(LocalDate.of(-999999999, 12, 31)))
                        information.setText("Ты проиграл!");
                    isMyTurn = false;
                    moveOfComputer();
                } else information.setText("Неверный ход");
            }
        });

        Button monthPlusOne = new Button(); //создание кнопки "+1 к месяцу"
        monthPlusOne.setText("+1 к месяцу");
        monthPlusOne.setFont(new Font(14));
        monthPlusOne.setPrefSize(100, 20);
        monthPlusOne.setTranslateX(30);
        monthPlusOne.setTranslateY(220);
        monthPlusOne.setFocusTraversable(false);
        monthPlusOne.setOnAction(event -> { //при нажатии на кнопку проверяется на корректность получившаяся дата,
            if (isMyTurn) {                 //если дата корректна, то делается ход, иначе выводится сообщение об ошибке
                if (Date.isCorrectDate(date.getDate().plusMonths(1))) {
                    information.setText("");
                    date.setDate(date.getDate().plusMonths(1));
                    dateText.setText(dateText.getText() + "\n Твой ход: " + date.toString());
                    datePane.setVvalue(1.0);
                    if (date.getDate().isEqual(LocalDate.of(-999999999, 12, 31)))
                        information.setText("Ты проиграл!");
                    isMyTurn = false;
                    moveOfComputer();
                } else information.setText("Неверный ход");
            }
        });

        Button monthPlusTwo = new Button();  //создание кнопки "+2 к месяцу"
        monthPlusTwo.setText("+2 к месяцу");
        monthPlusTwo.setFont(new Font(14));
        monthPlusTwo.setPrefSize(100, 20);
        monthPlusTwo.setTranslateX(30);
        monthPlusTwo.setTranslateY(270);
        monthPlusTwo.setFocusTraversable(false);
        monthPlusTwo.setOnAction(event -> { //при нажатии на кнопку проверяется на корректность получившаяся дата,
            if (isMyTurn) {                 //если дата корректна, то делается ход, иначе выводится сообщение об ошибке
                if (Date.isCorrectDate(date.getDate().plusMonths(2))) {
                    information.setText("");
                    date.setDate(date.getDate().plusMonths(2));
                    dateText.setText(dateText.getText() + "\n Твой ход: " + date.toString());
                    datePane.setVvalue(1.0);
                    if (date.getDate().isEqual(LocalDate.of(-999999999, 12, 31)))
                        information.setText("Ты проиграл!");
                    isMyTurn = false;
                    moveOfComputer();
                } else information.setText("Неверный ход");
            }
        });

        getChildren().addAll(dayPlusOne, dayPlusTwo, monthPlusOne, monthPlusTwo);  //добавление кнопок на панель
    }

    private void addDateText() { //метод для добавления случайносгенерированной даты
        datePane.setPrefWidth(300);
        datePane.setMaxHeight(180);
        datePane.setTranslateX(200);
        datePane.setTranslateY(100);
        datePane.setFitToWidth(true);
        datePane.setVvalue(1.0);
        datePane.setStyle("-fx-background-color: #2d2d2d");

        date = Date.generateDate();
        dateText.setText(" Начальная дата: " + date.toString());
        dateText.setTextAlignment(TextAlignment.CENTER);
        dateText.setFont(new Font(24));
        dateText.setTextFill(Color.valueOf("#2d2d2d"));
        datePane.setContent(dateText);
        getChildren().add(datePane);
    }

}
