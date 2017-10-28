package com.epam.bliakhman;

public class Task13 {
    /**
     * Позволяет получить название месяца по его номеру.
     * При реализации использовать оператор switch.
     * @param number Номер месяца.
     * @return Название месяца, или пустая строка, если месяц с указанным номером отсутствует.
     */
    public static String getMonthByNumber(int number) {
        switch (number) {
            case 1: return "January";
            case 2: return "Febrary";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Not a month number";

        }
    }
}
