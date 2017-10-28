package com.epam.bliakhman;

import java.util.Arrays;

public class Task14 {

    public static void main (String[] args) {
        int[][] test = createSquareMatrix ( 6 );
        for ( int i = 0 ; i <6  ; i++ ) {
            for ( int j = 0 ; j <6  ; j++ ) {
                System.out.printf (test[i][j]+"\t" );
            }
            System.out.println ("" );
        }
    }

    /**
     * Формирует квадратную матрицу размером {@code dimension}.
     * Матрица должна быть заполнена элементами от 1 до {@code dimension}^2, начиная с верхнего левого угла.
     *
     * dimension = 3:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @param dimension Размерность матрицы.
     * @return Созданная матрица.
     */
    public static int[][] createSquareMatrix(int dimension) {
        int[][] result = new int[dimension][dimension];
        int counter=1;
        for ( int i = 0 ; i <dimension  ; i++ ) {
            for ( int j = 0 ; j < dimension ; j++ ) {
                result[i][j]=counter++;
            }
        }
        return result;
    }
}
