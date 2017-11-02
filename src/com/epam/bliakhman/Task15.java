package com.epam.bliakhman;

import java.util.Arrays;

public class Task15 {

    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     * @param matrix Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public static int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {

        NewOrderedRow[] orderedmatrix = new NewOrderedRow[matrix.length];
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            orderedmatrix[i] = new NewOrderedRow ( matrix[i], indexColumn);
        }
        Arrays.sort ( orderedmatrix );

        for ( int i = 0 ; i < matrix.length ; i++ ) {
            matrix[i] = orderedmatrix[i].row;
        }

        return matrix;
    }
}

class NewOrderedRow implements Comparable<NewOrderedRow> {
    int[] row;
    int index;

    public NewOrderedRow (int[] row, int index) {
        this.row = row;
        this.index = index;
    }

    @Override
    public int compareTo (NewOrderedRow other) {
        if ((this.index != other.index) | (index < 0 )  | ( index > row.length - 1)) {try {
            throw new IllegalAccessException("Index mismatch");
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        }}
        else {

        }
        return Integer.compare ( this.row[ index ], other.row[ index ] );
    }

}

