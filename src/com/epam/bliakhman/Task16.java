package com.epam.bliakhman;

import java.util.Arrays;

public class Task16 {

    public static void main(String[] args) {

        int[][] array = new int[][]{{0,5},{1,5},{2,5},{3,5}};
        System.out.println ( Arrays.deepToString ( array ) );
        verticalCyclicShift ( array, -2 );
        System.out.println ( Arrays.deepToString ( array ) );
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public static void verticalCyclicShift (int[][] matrix, int numberShifts) {
        if (matrix == null || matrix.length==0) {
            //    if (matrix == null || matrix.length==0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        //length of first part
        int a = (matrix.length - numberShifts%matrix.length)%matrix.length;

        reverse(matrix, 0, a-1);
        reverse(matrix, a, matrix.length-1);
        reverse(matrix, 0, matrix.length-1);

    }

    public static void reverse(int[][] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int[] temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        // TODO решение задачи
        return null;
    }

}

