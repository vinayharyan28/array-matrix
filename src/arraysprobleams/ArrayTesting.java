package arraysprobleams;

public class ArrayTesting {
    public static void printSubArrays(int[] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                for (int k=i; k<=j; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int maximumSubArraySum(int[] arr){
        int maxSubArraySum = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                int sum = 0;
                for (int k=i; k<=j; k++){
                    sum += arr[k];
                }
                maxSubArraySum = Math.max(sum, maxSubArraySum);
            }
        }
        return maxSubArraySum;
    }


    //Optimized with prefix array
    public static int maximumSubArrayPrefixSum(int[] arr){
        int maxSubArraySum = 0;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        // Calculate prefix array
        for (int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                int sum = i == 0 ? prefix[j] : prefix[j] - prefix[i];
                maxSubArraySum = Math.max(sum, maxSubArraySum);
            }
        }
        return maxSubArraySum;
    }

    //Optimized sub array
    static int kadaneAlgorithm(int[] arr){
         int currentSum = 0, maxSum = Integer.MIN_VALUE;

        for (int j : arr) {
            currentSum = currentSum + j;
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] subArray = new int[] {2, 4, 6, 8, 10};
        printSubArrays(subArray);
        System.out.println(maximumSubArraySum(subArray));
        System.out.println(maximumSubArrayPrefixSum(subArray));
        System.out.println(kadaneAlgorithm(subArray)); // Fail for all -ve number
    }
}
