package matrixprobleams;

import java.util.Arrays;

public class RotateMatrixClockwise {
    public static void rotateMatrixClockwise(int[][] matrix){
        int matrixSize = matrix.length;
        // Transpose the matrix
        for (int i=0; i<matrixSize; i++){
            for (int j=i; j<matrixSize; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i=0; i<matrixSize; i++){
            for (int j=0; j<matrixSize/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrixSize-1-j];
                matrix[i][matrixSize-1-j] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        rotateMatrixClockwise(matrix);
        for (int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
