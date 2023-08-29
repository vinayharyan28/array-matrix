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

    public static int minimumNumberOfJumps(int[] arr){
        if (arr.length <= 1){
            return -1;
        }

        if (arr[0] == 0){
            return -1;
        }

        int maxReach=arr[0], steps=arr[0], jumps=1;
        for (int i=1; i<arr.length; i++){
            if (i==arr.length-1){
                return jumps;
            }

            maxReach = Math.max(maxReach, i+arr[i]);
            steps-=1;

            if (steps == 0){
                if (i >= maxReach){
                    return -1;
                }
                steps = maxReach - i;
                jumps += 1;
            }
        }
        return -1;
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        int arr1Index=0, arr2Index=0, arr3Index=0;
        while (arr1Index < arr1.length && arr2Index < arr2.length){
            if (arr1[arr1Index] < arr2[arr2Index]){
                arr3[arr3Index++] = arr1[arr1Index++];
            }else{
                arr3[arr3Index++] = arr2[arr2Index++];
            }
        }

        while (arr1Index < arr1.length){
            arr3[arr3Index++] = arr1[arr1Index++];
        }

        while (arr2Index < arr2.length){
            arr3[arr3Index++] = arr2[arr2Index++];
        }

        return arr3;
    }

    public static void main(String[] args){
        int[] arr = {3, 5, 4, 1, 9};
        int[] arr1 = {22, 14, 8, 17, 35, 3};
        int[] result = minimumMaximum(arr1);
        kthSmallestElement(arr, 3);
        System.out.println(Arrays.toString(result));
        int[] arr3 = {2, 1, 0, 3};
        int[] arr10 = { 5, 8, 9};
        int[] arr11 = {4, 7, 8};
        System.out.println("Minimum jumps: " + minimumNumberOfJumps(arr3));
        System.out.println("Merge two sorted array: " + Arrays.toString(mergeTwoSortedArrays(arr10, arr11)));
    }

}
