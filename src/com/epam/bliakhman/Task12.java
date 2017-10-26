package com.epam.bliakhman;

public class Task12 {

    public static void main (String[] args) {

        System.out.println (reverse(91023777) );
    }
    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    public static int reverse(int value) {
        if ( value < 10 ) return value;
        else {
            return  value%10*(int)Math.pow(10,(int)Math.log10((double)value)) + reverse(value/10);
        }

    }
}
