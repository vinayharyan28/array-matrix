package matrixprobleams;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
    public static int kthSmallestElement(int[][] matrix, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int countElement = 1;
        for (int[] row: matrix){
            for (int value: row){
                priorityQueue.add(value);
            }
        }

        while (!priorityQueue.isEmpty()){
            int smallestElement = priorityQueue.poll();
            if (countElement == k){
                return smallestElement;
            }
            countElement++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 25, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        System.out.println("kth smallest element is: " + kthSmallestElement(matrix, 3));
    }
}
