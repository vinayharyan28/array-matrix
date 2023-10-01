package matrixprobleams;

public class SpiralFormOFMatrix {
    public static void printSpiralFormOfMatrix(int[][] matrix){
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top<=bottom && left<=right){
            // Print top row
            for (int i=left; i <= right; i++){
                System.out.print(matrix[top][i] + " ");
            }top++;

            // Print right column
            for (int i=top; i<=bottom; i++){
                System.out.print(matrix[i][right] + " ");
            }right--;

            // Print bottom row if it exists
            if (top <= bottom){
                for (int i=right; i>=left; i--){
                    System.out.print(matrix[bottom][i] + " ");
                }bottom--;
            }

            // Print leftmost column if it exists
            if (left <= right){
                for (int i=bottom; i>= top; i--){
                    System.out.print(matrix[i][left] + " ");
                }left++;
            }
        }
    }

    public static void main(String[] args){
        int[][] spiralArr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printSpiralFormOfMatrix(spiralArr);


    }
}
