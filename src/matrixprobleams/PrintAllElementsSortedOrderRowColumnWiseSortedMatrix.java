package matrixprobleams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrintAllElementsSortedOrderRowColumnWiseSortedMatrix {
    public static ArrayList<Integer> sortedMatrix(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] rows: matrix){
            for (int value: rows){
                result.add(value);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args){
        System.out.println(sortedMatrix(
                new int[][] {
                        {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}
                }
        ));
    }
}
