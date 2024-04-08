
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

public:
    int minOperations(const vector<int>& input, int target) const {
        priority_queue<long long, vector<long long>, greater<long long>> minHeap;
        for (const auto& n : input) {
            minHeap.push(n);
        }

        int minOperations = 0;
        while (minHeap.top() < target && minHeap.size() > 1) {
            long long firstValue = minHeap.top();
            minHeap.pop();

            long long secondValue = minHeap.top();
            minHeap.pop();

            long long newValue = min(firstValue, secondValue) * 2 + max(firstValue, secondValue);

            minHeap.push(newValue);
            ++minOperations;
        }

        return minOperations;
    }
};
