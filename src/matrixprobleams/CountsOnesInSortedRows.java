package matrixprobleams;

public class CountsOnesInSortedRows {
    public int countOnesInRows(int[][] matrix){
        int maxCount = 0;
        int rowIndex = -1;
        for (int[] rows: matrix){
            int count = 0;
            for (int value: rows){
                if (value == 1){
                    count++;
                }
            }

            if (count > maxCount){
                rowIndex++;
            }
        }
        return rowIndex;
    }


    public int optimizeCountOnesInRows(int[][] matrix){
        int maxOnesRow = -1;
        int currentRow = 0;
        int currentColumns = matrix[0].length - 1;

        while (currentRow < matrix.length && currentColumns >= 0){
            if (matrix[currentRow][currentColumns] == 1){
                currentColumns--;
                maxOnesRow = currentRow;
            }else {
                currentRow++;
            }
        }
        return maxOnesRow;
    }


    public static void main(String[] args){
        CountsOnesInSortedRows countsOnesInSortedRows = new CountsOnesInSortedRows();
        int[][] matrix = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println(countsOnesInSortedRows.countOnesInRows(matrix));

        // The time complexity of this algorithm is O(m+n), where 'm' is teh number of rows, and 'n' is the number of columns
        System.out.println(countsOnesInSortedRows.optimizeCountOnesInRows(matrix));

    }
}
