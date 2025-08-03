class Solution {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        
        // Extract positions and prefix sums
        int[] positions = new int[n];
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            positions[i] = fruits[i][0];
            prefixSum[i + 1] = prefixSum[i] + fruits[i][1];
        }

        int maxFruits = 0;

        // Try all combinations: go left then right
        for (int stepsLeft = 0; stepsLeft <= k; stepsLeft++) {
            int left = startPos - stepsLeft;
            int rem = k - 2 * stepsLeft;
            if (rem < 0) break;
            int right = startPos + rem;
            maxFruits = Math.max(maxFruits, getFruitsInRange(positions, prefixSum, left, right));
        }

        // Try all combinations: go right then left
        for (int stepsRight = 0; stepsRight <= k; stepsRight++) {
            int right = startPos + stepsRight;
            int rem = k - 2 * stepsRight;
            if (rem < 0) break;
            int left = startPos - rem;
            maxFruits = Math.max(maxFruits, getFruitsInRange(positions, prefixSum, left, right));
        }

        return maxFruits;
    }

    private int getFruitsInRange(int[] positions, int[] prefixSum, int left, int right) {
        int l = lowerBound(positions, left);
        int r = upperBound(positions, right);
        return prefixSum[r] - prefixSum[l];
    }

    // Binary search for first position >= target
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // Binary search for first position > target
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}