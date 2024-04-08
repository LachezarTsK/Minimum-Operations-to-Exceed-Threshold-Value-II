
/**
 * @param {number[]} input
 * @param {number} target
 * @return {number}
 */
var minOperations = function (input, target) {
    // PriorityQueue<number>
    // const {MinPriorityQueue} = require('@datastructures-js/priority-queue');
    const minHeap = new MinPriorityQueue({compare: (x, y) => x - y});
    for (let n of input) {
        minHeap.enqueue(n);
    }

    let minOperations = 0;
    while (minHeap.front() < target && minHeap.size() > 1) {
        let firstValue = minHeap.dequeue();
        let secondValue = minHeap.dequeue();
        let newValue = Math.min(firstValue, secondValue) * 2 + Math.max(firstValue, secondValue);

        minHeap.enqueue(newValue);
        ++minOperations;
    }

    return minOperations;
};
