package matrixprobleams;
import java.util.Stack;

public class MaximumSizeRectangleBinarySubMatrixWithAll1s {
    public int maximalRectangle(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return 0;
        }

        int columns = matrix[0].length;
        int[] hist = new int[columns];
        int maxArea = 0;

        for (int[] ints : matrix) {
            for (int j = 0; j < columns; j++) {
                if (ints[j] == 1) {
                    hist[j] += 1;
                } else {
                    hist[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maximalRectangleInHistogram(hist));
        }
        return maxArea;
    }

    private int maximalRectangleInHistogram(int[] hist){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i=0; i<hist.length; i++){
            while ((!stack.isEmpty() && hist[i] < hist[stack.peek()])){
                int height = hist[stack.pop()];
                int width = stack.isEmpty() ? i: i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int height = hist[stack.pop()];
            int width = stack.isEmpty() ? hist.length : hist.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        int[][] matrix1 = {
            {0, 1, 1},
            {1, 1, 1},
            {0, 1, 1}
        };

        MaximumSizeRectangleBinarySubMatrixWithAll1s maximumSizeRectangleBinarySubMatrixWithAll1s = new MaximumSizeRectangleBinarySubMatrixWithAll1s();

        System.out.println(maximumSizeRectangleBinarySubMatrixWithAll1s.maximalRectangle(matrix));
        System.out.println(maximumSizeRectangleBinarySubMatrixWithAll1s.maximalRectangle(matrix1));

    }
}
