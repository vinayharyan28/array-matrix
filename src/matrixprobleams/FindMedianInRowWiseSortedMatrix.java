package matrixprobleams;
import java.util.ArrayList;
import java.util.Collections;

public class FindMedianInRowWiseSortedMatrix {

    public static int findMedianInRowWiseSortedMatrix(int[][] matrix){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] rows: matrix){
            for (int row : rows) {
                arrayList.add(row);
            }
        }

        Collections.sort(arrayList);

        if (arrayList.size() % 2 == 0){
            int median = arrayList.size()/2;
            return (arrayList.get(median) + arrayList.get(median-1))/2;
        }else {
            return arrayList.get(arrayList.size()/2);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 4},
                {2, 5, 6},
                {7, 8, 9}
        };
        System.out.println(findMedianInRowWiseSortedMatrix(matrix));
    }
}
