import java.util.Arrays;


public class ArrayQuestions {
    public static int[] minimumMaximum(int[] arr){
        int min=Integer.MAX_VALUE, max=-Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) {
                min = j;
            }

            if (j > max) {
                max = j;
            }
        }
        return new int[] {min, max};
    }

    public static void kthSmallestElement(int[] arr, int k){
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }

    public static void zeroAndOneSorting(int[] arr){

    }

    public static void main(String[] args){
        int[] arr = {3, 5, 4, 1, 9};
        int[] arr1 = {22, 14, 8, 17, 35, 3};
        int[] result = minimumMaximum(arr1);
        kthSmallestElement(arr, 3);
        System.out.println(Arrays.toString(result));
        int[] arr2 = {0, 2, 1, 2, 0};
        zeroAndOneSorting(arr2);

    }

}
