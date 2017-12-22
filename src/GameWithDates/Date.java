package GameWithDates;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Date { //класс, описывающий дату
    private LocalDate date;

    private Date(LocalDate d) {
        date = d;
    }

    static Date generateDate() { //генерация случайной даты
        return new Date(LocalDate.MIN.plusDays(new Random().nextInt(364)));
    }

    static Boolean isCorrectDate(LocalDate d) { //проверка на корректность даты
        return d.isBefore(LocalDate.of(-999999999, 12, 31)) ||
                d.isEqual(LocalDate.of(-999999999, 12, 31));
    }

    static Boolean isCorrectDate(int month, int day) { //проверка на корректность дня и месяца
        LocalDate d;
        try {
            d = LocalDate.of(-999999999, month, day);
        } catch (DateTimeException e) {
            return false;
        }
        return d.isBefore(LocalDate.of(-999999999, 12, 31)) ||
                d.isEqual(LocalDate.of(-999999999, 12, 31));
    }

    LocalDate getDate() {
        return date;
    }

    void setDate(LocalDate d) { date = d;  }

    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("dd.MM"));
    }
}
