
import java.util.PriorityQueue
import kotlin.math.min
import kotlin.math.max

class Solution {
    fun minOperations(input: IntArray, target: Int): Int {
        val minHeap = PriorityQueue<Long>();
        for (n in input) {
            minHeap.add(n.toLong());
        }

        var minOperations = 0;
        while (minHeap.peek() < target && minHeap.size > 1) {
            val firstValue = minHeap.poll();
            val secondValue = minHeap.poll();
            val newValue: Long = min(firstValue, secondValue) * 2 + max(firstValue, secondValue);

            minHeap.add(newValue);
            ++minOperations;
        }

        return minOperations;
    }
}
