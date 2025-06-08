class Solution {
    int mod = (int)(1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int[] dp = new int[n + 1];
        int[] prefixSum = new int[n + 1];

        dp[0] = 1;
        prefixSum[0] = 1;

        int start = 0;
        for (int end = 1; end <= n; end++) {
            int val = nums[end - 1];

            // Maintain minQ
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= val) {
                minQ.pollLast();
            }
            minQ.addLast(end - 1);

            // Maintain maxQ
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= val) {
                maxQ.pollLast();
            }
            maxQ.addLast(end - 1);

            // Shrink the window from left while it violates the condition
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (minQ.peekFirst() == start) minQ.pollFirst();
                if (maxQ.peekFirst() == start) maxQ.pollFirst();
                start++;
            }

            int prev = (start > 0) ? prefixSum[start - 1] : 0;
            dp[end] = (prefixSum[end - 1] - prev + mod) % mod;
            prefixSum[end] = (prefixSum[end - 1] + dp[end]) % mod;
        }

        return dp[n];
    }
}
