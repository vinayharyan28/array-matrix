package matrixprobleams;
import java.util.HashMap;
import java.util.HashSet;


public class CommonElementsInAllRows {
    public static void findTheCommonElementsFromAllRows(int[][] matrix){
        HashMap<Integer, HashSet<Integer>> hashSetHashMap = new HashMap<>();

        for (int i=0; i<matrix.length; i++){
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j=0; j<matrix[0].length; j++){
                hashSet.add(matrix[i][j]);
            }
            hashSetHashMap.put(i, hashSet);
        }

        HashSet<Integer> hashSetCommon = new HashSet<>(hashSetHashMap.get(0));
        for (int i=1; i<matrix.length; i++){
            hashSetCommon.retainAll(hashSetHashMap.get(i));
        }
        System.out.println(hashSetCommon);
    }


    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };

        findTheCommonElementsFromAllRows(matrix);


    }
}
