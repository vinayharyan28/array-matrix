package matrixprobleams;

public class SearchElementInMatrix {
    public static boolean searchOn2(int[][] matrix, int target){
        int columns = matrix[0].length;
        for (int[] rows : matrix) {
            for (int j = 0; j < columns; j++) {
                if (rows[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    1. Start from the top-right corner of the matrix (the element at the first row and last column).
    2. Compare the target value with the current element.
        if the target is equal to the current element, you have found it.
        if the target is smaller than current element, move one column to the left.
        if the target is larger than the current element, move one row down.
    3. Repeat step 2 until you find the target or go out of bounds (meaning the element doesn't exist in the matrix).
     */

    public static boolean searchInSortedMatrixMPlusN(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns-1;

        while (row < rows && column >= 0){
            int current = matrix[row][column];
            if (current == target){
                return true; // Found the target
            }else if(current > target){
                column--; // Move left
            }else {
                row++; // Move down
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        System.out.println(searchOn2(matrix, 100));
        System.out.println(searchInSortedMatrixMPlusN(matrix, 100));


    }
}
