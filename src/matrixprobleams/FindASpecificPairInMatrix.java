package matrixprobleams;

public class FindASpecificPairInMatrix {
    public static int findMaxValue(int matrix_size, int[][] matrix){
        int maxValue = Integer.MIN_VALUE;
        for (int a=0; a<matrix_size-1; a++){
            for (int b=0; b<matrix_size-1; b++){
                for (int d=a+1; d<matrix_size; d++){
                    for (int e=b+1; e<matrix_size; e++){
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
                { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 6, 1, 3 },
                { -4, -1, 1, 7, -6 },
                { 0, -4, 10, -5, 1 }
        };

        System.out.println("Maximum value is: " + findMaxValue(5, matrix));
    }
}
