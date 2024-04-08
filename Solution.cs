
using System;
using System.Collections.Generic;

public class Solution
{
    public int MinOperations(int[] input, int target)
    {
        PriorityQueue<long, long> minHeap = new PriorityQueue<long, long>();
        foreach (long n in input)
        {
            minHeap.Enqueue(n, n);
        }

        int minOperations = 0;
        while (minHeap.Peek() < target && minHeap.Count > 1)
        {
            long firstValue = minHeap.Dequeue();
            long secondValue = minHeap.Dequeue();
            long newValue = Math.Min(firstValue, secondValue) * 2 + Math.Max(firstValue, secondValue);

            minHeap.Enqueue(newValue, newValue);
            ++minOperations;
        }

        return minOperations;
    }
}
