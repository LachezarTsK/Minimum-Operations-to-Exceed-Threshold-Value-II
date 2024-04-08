
import java.util.PriorityQueue;

public class Solution {

    public int minOperations(int[] input, int target) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long n : input) {
            minHeap.add(n);
        }

        int minOperations = 0;
        while (minHeap.peek() < target && minHeap.size() > 1) {
            long firstValue = minHeap.poll();
            long secondValue = minHeap.poll();
            long newValue = Math.min(firstValue, secondValue) * 2 + Math.max(firstValue, secondValue);

            minHeap.add(newValue);
            ++minOperations;
        }

        return minOperations;
    }
}
