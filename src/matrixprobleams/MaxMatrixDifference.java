package matrixprobleams;

public class MaxMatrixDifference {
    public static int findMaxDifference(int[][] matrix, int n){
        int maxValue = Integer.MIN_VALUE;
        int[][] maxArr = new int[n][n];
        maxArr[n-1][n-1] = matrix[n-1][n-1];
        int max = matrix[n-1][n-1];
        for (int j = n-2; j >= 0; j--){ // Preprocess last row
            if (matrix[n-1][j] > max){
                max = matrix[n-1][j];
            }
            maxArr[n-1][j] = max;
        }

        max = matrix[n-1][n-1];
        for(int i=n-2; i>=0; i--){ // preprocessing last column
            if (matrix[i][n-1] > maxValue){
                max = matrix[i][n-1];
            }
            maxArr[i][n-1] = max;
        }

        for(int i=n-2; i>=0; i--){ // preprocessing rest of the matrix from bottom
            for (int j=n-2; j>=0; j--){
                if(maxArr[i+1][j+1] - matrix[i][j] > maxValue){
                    maxValue = maxArr[i+1][j+1] - matrix[i][j];
                }
                maxArr[i][j] = Math.max(matrix[i][j], Math.max(maxArr[i][j+1], maxArr[i+1][j]));
            }
        }
        return maxValue;
    }

    static int findMaxValueNRestTo4(int[][] matrix, int n){
        int maxValue = Integer.MIN_VALUE;
        for (int a = 0; a < n-1; a++){
            for (int b = 0; b < n-1; b++){
                for (int d = a+1; d < n; d++){
                    for (int e = b+1; e < n; e++){
                        if (maxValue < matrix[d][e] - matrix[a][b]){
                            maxValue = matrix[d][e] - matrix[a][b];
                        }
                    }
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 6, 1, 3},
                {-4, -1, 1, 7, -6},
                {0, -4, 10, -5, 1}
        };

        int maxDifference = findMaxDifference(matrix1, matrix1.length);
        System.out.println("Maximum difference: " + maxDifference);
        System.out.printf("Maximum difference N^4: " + findMaxValueNRestTo4(matrix1, matrix1.length));

    }
}
