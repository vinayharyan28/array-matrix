import java.math.BigInteger;
import java.nio.channels.Pipe;
import java.util.*;


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

    private static class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static HashSet<Integer> findUnion(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for (int i: arr1){
            set.add(i);
        }

        for (int j: arr2){
            set.add(j);
        }

        return set;
    }

    public static HashSet<Integer> findIntersection(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i: arr1){
            set.add(i);
        }

        for (int j: arr2){
            if (set.contains(j)){
                result.add(j);
            }
        }
        return result;
    }

    public static int[] separateNegativeElement(int[] arr){
        int[] result = new int[arr.length];
        int count = 0;
        for (int k : arr) {
            if (k > 0) {
                result[count++] = k;
            }
        }

        for (int i : arr) {
            if (i < 0) {
                result[count++] = i;
            }
        }
        arr = result;
        return arr;
    }

    public static int[] arrayRotatedByOne(int[] arr){
        int temp = arr[arr.length-1];
        for (int i=arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        return arr;
    }

    public static int findMaximumSubArraySum(int[] arr){  // Kadane's Algorithm
        int maxSubArray = arr[0], maxSoFar = 0, tempStart=0, start=0, end=0;
        for (int i=1; i<arr.length; i++){
            if (arr[i] > maxSubArray + arr[i]){
                maxSubArray = arr[i];
                tempStart = i;
            }else{
                maxSubArray += arr[i];
            }
            if (maxSubArray > maxSoFar){
                maxSoFar = maxSubArray;
                start = tempStart;
                end = i;
            }
        }
        System.out.print("sub array: ");
        for (int i=start; i<=end; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxSoFar;
    }

    public static int maximizeMinimizeDiffHeight(int[] arr, int n, int k){
        Arrays.sort(arr); // maximum possible height difference
        int tempMin, tempMax, min=arr[0], max=arr[n-1];
        int ans = max - min;

        for(int i=1; i<n; i++){
            if (arr[i] < k){
                continue;
            }
            tempMin = Math.min(min + k, arr[i] - k);
            tempMax = Math.max(arr[i-1]+k, max-k);
            ans = Math.min(ans, tempMax - tempMin);
        }
        return ans;
    }

    public static ArrayList<Integer> findDuplicateElement(int[] arr){
        HashSet<Integer> result = new HashSet<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int element: arr){
            if (result.contains(element)){
                arr2.add(element);
            }
            result.add(element);
        }
        return arr2;
    }

    public static List<Interval> merge(List<Interval> intervals){
        if (intervals == null || intervals.size() <= 1){
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        List<Interval> merged = new ArrayList<>();
        Interval current = intervals.get(0);

        for (Interval interval: intervals){
            if (interval.start <= current.end){
                current.end = Math.max(current.end, interval.end);
            }else {
                merged.add(current);
                current = interval;
            }
        }

        merged.add(current);
        return merged;

    }


    public static List<Interval> merging(List<Interval> intervals){
        if (intervals == null || intervals.size() <=1){
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        Interval current = intervals.get(0);
        ArrayList<Interval> merged = new ArrayList<>();
        for (Interval interval: intervals){
            if (interval.start <= current.end){
                current.end = Math.max(current.end, interval.end);
            }else{
                merged.add(current);
                current = interval;
            }
        }
        merged.add(current);
        return merged;
    }

    public static String nextLexicographicPermutation(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Find the first character that is smaller than its next character
        int index1 = n - 2;
        while (index1 >= 0 && arr[index1] >= arr[index1+1]){
            index1--;
        }

        if (index1 == -1){
            return new StringBuilder(s).reverse().toString();
        }

        // Find the smallest character greater thant arr[index1]
        int index2 = n - 1;
        while (arr[index2] <= arr[index1]){
            index2--;
        }

        // Swap
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        // Reverse the substring from index1 + 1 to the end
        reverseSubstring(arr, index1 + 1, n-1);
        return new String(arr);
    }

    private static void reverseSubstring(char[] arr, int start, int end){
        while (start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void countInversion(int[] arr){
        int count = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[i] > arr[j]){
                    System.out.print("(" + arr[i] + ", " + arr[j]+") ");
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println("Total inversion count: " + count);
    }

    public static int inversionCountUsingMergeSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return 0; // No inversion in an empty or one-element array
        }

        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length-1);
    }

    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right){
        int inversionCount = 0;
        if (left < right){
            int mid = left + (right - left) / 2;

            // Recursively sort and count inversion in the left and right halves
            inversionCount += mergeSortAndCount(arr, temp, left, mid);
            inversionCount += mergeSortAndCount(arr, temp, mid+1, right);

            // Merge the two sorted sub arrays and count inversions
            inversionCount += mergeWithCount(arr, temp, left, mid, right);
        }
        return inversionCount;
    }

    private static int mergeWithCount(int[] arr, int[] temp, int left, int mid, int right){
        int i = left, j = mid + 1, k = left, inversionCount = 0;
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                // if arr[i] > arr[j], it's an inversion
                temp[k++] = arr[j++];
                // This is used to count the number of inversion during this merge step
                // Calculate the number of elements in the left sub array that are greater than the current element from the right subarray

                inversionCount += (mid - i + 1);
            }
        }

        // Copy the remaining elements from the left sub array
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements from the right sub array
        while (j <= right){
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back to the original array
        for (i=left; i<=right; i++){
            arr[i] = temp[i];
        }

        return inversionCount;
    }

    public static int buySellStock(int[] arr){
        if (arr == null || arr.length <= 1){
            return 0;
        }

        int sellWithProfit=0, buyMinimumPrice=arr[0];
        for(int i=1; i<arr.length; i++){
            if (buyMinimumPrice > arr[i]){
                buyMinimumPrice = arr[i];
            }else{
                sellWithProfit = Math.max(sellWithProfit, arr[i]-buyMinimumPrice);
            }
        }return sellWithProfit;
    }

    public static void pairSumCount(int[] arr, int k){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[i] + arr[j] == k){
                    System.out.print("("+arr[i]+","+arr[j]+")");
                }
            }
        }
    }

    public static int getPairsCount(int[] arr, int n, int k){
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i=0; i<n; i++){
            if (m.containsKey(k-arr[i])){
                count += m.get(k - arr[i]);
            }

            if (m.containsKey(arr[i])){
                m.put(arr[i], m.get(arr[i]) + 1);
            }else{
                m.put(arr[i], 1);
            }
        }
        return count;
    }

    public static void findCommonElementThreeSortedArray(int[] arr1, int[] arr2, int[] arr3){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int a: arr1){
            set1.add(a);
        }

        for (int b: arr2){
            set2.add(b);
        }

        for (int c: arr3){
            if (set1.contains(c) && set2.contains(c)){
                System.out.print(c + " ");
            }
        }
    }

    public static ArrayList<Integer> alternateNegativePositiveNumber(int[] arr){
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int j : arr) {
            if (j < 0) {
                negative.add(j);
            } else {
                positive.add(j);
            }
        }

        while (!positive.isEmpty() && !negative.isEmpty()){
            result.add(negative.remove(0));
            result.add(positive.remove(0));
        }

        while (!positive.isEmpty()){
            result.add(positive.remove(0));
        }

        while (!negative.isEmpty()){
            result.add(negative.remove(0));
        }

        return result;
    }


    public static boolean subArrayWithZeroSum(int[] arr){  // Kadane's Algorithm
        for (int i=0; i<arr.length; i++){
            int sum = arr[i];
            if (sum == 0){
                return true;
            }
            for (int j=i+1; j<arr.length; j++){
                sum += arr[j];
                if (sum == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean subArrayWithZeroSumCumulativeSum(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int cumulativeSum = 0;
        for (int element: arr){
            cumulativeSum += element;
            if (cumulativeSum == 0 || set.contains(cumulativeSum)){
                return true;
            }
            set.add(element);
        }return false;
    }

    public static BigInteger largeNumberFactorial(int number){
        BigInteger result = BigInteger.ONE;
        for (int i=1; i<=number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }

    public static int getMaxProductSum(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int maxValue=arr[0], minValue=arr[0], maxProductSum=0;
        for (int i=1; i<arr.length; i++){
            // If multiply by -ve maxValue become minValue and minValue become maxValue
            if (arr[i] < 0){
                int temp = maxValue;
                maxValue = minValue;
                minValue = temp;
            }
            maxValue = Math.max(arr[i], arr[i]*maxValue);
            minValue = Math.min(arr[i], arr[i]*minValue);
            maxProductSum = Math.max(maxProductSum, Math.max(minValue, maxValue));
        }
        return maxProductSum;
    }

    public static int longestConsecutiveSubsequence(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        Integer[] arr1 = set.toArray(new Integer[0]);
        int count = 1;
        for (int i=0; i<arr1.length-1; i++){
            if (arr1[i]+1 == arr1[i+1]){
                count++;
            }else {
                return count;
            }
        }return count;
    }


    public static int longestConsecutive(int[] numbers){
        if (numbers == null || numbers.length == 0){
            return 0;
        }

        HashSet<Integer> numberSet = new HashSet<>();
        for (int num: numbers){
            numberSet.add(num);
        }

        int longestStreak = 0;

        for (int num: numberSet){
            if (!numberSet.contains(num - 1)){
                int currentNumber = num;
                int currentStreak = 1;
                while (numberSet.contains(currentNumber + 1)){
                    currentNumber++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                return longestStreak;
            }
        }
        return longestStreak;

    }

    public static HashSet<Integer> findALlElementsThatAppearMoreThanNbyKTime(int[] arr, int k){
        int number = arr.length / k;
        System.out.println("number: " + number);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i: arr){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() > number){
                set.add(entry.getKey());
            }
        }
        return set;
    }

    public static int maximumProfitByBuyingSellingShare(int[] prices){
        int n = prices.length;
        int firstBuy=Integer.MIN_VALUE;
        int firstSell=0;
        int secondBuy=Integer.MIN_VALUE;
        int secondSell=0;
        if (n == 1){
            return 0;
        }
        for (int price: prices){
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy+price);
            secondBuy = Math.max(secondBuy, firstSell-price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
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
        System.out.println(Arrays.toString(separateNegativeElement(new int[] {1, 2,  -4, -5, 2, -7, 3, 2, -6, -8, -9, 3, 2,  1})));
        System.out.println("union: " + findUnion(new int[] {7, 1, 5, 2, 3, 6}, new int[] {3, 8, 6, 20, 7}));
        System.out.println("intersection: " + findIntersection(new int[] {7, 1, 5, 2, 3, 6}, new int[] {3, 8, 6, 20, 7}));
        System.out.println("rotated by one: " + Arrays.toString(arrayRotatedByOne(new int[] {3, 8, 6, 20, 7})));
        System.out.println("max sum: "+ findMaximumSubArraySum(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println("maximizeMinimizeDiffHeight: " + maximizeMinimizeDiffHeight(new int[] {1, 15, 10}, 3, 6));
        System.out.println("find duplicate inside array: " + findDuplicateElement(new int[] {1, 2, 3, 4 ,3}));
        List<ArrayQuestions.Interval> intervals = new ArrayList<>();
        intervals.add(new ArrayQuestions.Interval(1, 3));
        intervals.add(new ArrayQuestions.Interval(2, 6));
        intervals.add(new ArrayQuestions.Interval(8, 10));
        intervals.add(new ArrayQuestions.Interval(15, 18));

        List<ArrayQuestions.Interval> merged = merging(intervals);
        for(ArrayQuestions.Interval interval: merged){
            System.out.println(interval.start + " " + interval.end);
        }

        String inputString = "abcde";
        String nextPermutation = nextLexicographicPermutation(inputString);
        System.out.println("Next permutation: " + nextPermutation);
        countInversion(new int[] {8, 4, 2, 1});

        System.out.println("Inversion count using merge sort: " + inversionCountUsingMergeSort(new int[] {8, 4, 2, 1}));
        System.out.println("Buy Sell stock: " + buySellStock(new int[] {7, 6, 4, 3, 1} ));
        pairSumCount(new int[] {1, 5, 7, -1}, 6);
        System.out.println();
        System.out.println(getPairsCount(new int[] {1, 1, 1, 1}, 4, 2));
        findCommonElementThreeSortedArray(
                new int[] {1, 5, 5} ,
                new int[] {3, 4, 5, 5, 10},
                new int[] {5, 5, 10, 20}
        );

        System.out.println();
        System.out.println(alternateNegativePositiveNumber(new int[] {1, 2, 3, -4, -1, 4}));
        System.out.println(subArrayWithZeroSum(new int[] {-3, 2, 3, 1, 6}));
        System.out.println(subArrayWithZeroSumCumulativeSum(new int[] {-3, 2, 3, 1, 6}));
        System.out.println(largeNumberFactorial(100));
        System.out.println(getMaxProductSum(new int[] { -2, -3, 0, -2, -40}));
        System.out.println(longestConsecutiveSubsequence(new int[] {1, 9, 3, 10, 4, 20, 2}));

        System.out.println(findALlElementsThatAppearMoreThanNbyKTime(new int[] {3, 1, 2, 2, 1, 2, 3, 3}, 4));
        System.out.println(maximumProfitByBuyingSellingShare(new int[] {10, 22, 5, 75, 65, 80}));
    }

}
