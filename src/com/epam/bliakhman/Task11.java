package com.epam.bliakhman;

public class Task11 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    public static long getSumDigits(long value) {
        if ( Math.abs (value)  < 10 ) return Math.abs ( value );
        else {
            return Math.abs ( value ) %10 + getSumDigits ( (Math.abs (value) -  Math.abs (value) % 10)/10 ) ;

        }
    }
}
