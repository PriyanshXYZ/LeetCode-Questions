class Solution {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int size = fruits[n - 1][0];

        int[] prefixSum = new int[500002];
        
        for (int i = 0; i < n; i++) prefixSum[fruits[i][0] + 1] = fruits[i][1];

        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        // for(int i = 0; i <= size + 1; i++) {
        //     System.out.print(prefixSum[i]+" ");
        // }
        // System.out.println();

        // A cleaner implementation:
        int result = 0;
        
        // Scenario 1: Go to a point 'l' on the left and come back to a point 'r' on the right
        // The path is start -> l -> r. Steps = (start - l) + (r - l)
        for (int l = 0; l <= k; l++) {
            int leftPos = startPos - l;
            if (leftPos < 0) continue;
            int remainingSteps = k - 2 * l; // Steps to go left and back
            if (remainingSteps < 0) continue;
            
            int rightPos = startPos + remainingSteps;
            int currentFruits = prefixSum[rightPos + 1] - prefixSum[leftPos];
            result = Math.max(result, currentFruits);
        }

        // Scenario 2: Go to a point 'r' on the right and come back to a point 'l' on the left
        // The path is start -> r -> l. Steps = (r - start) + (r - l)
        for (int r = 0; r <= k; r++) {
            int rightPos = startPos + r;
            int remainingSteps = k - 2 * r;
            if (remainingSteps < 0) continue;
            
            int leftPos = startPos - remainingSteps;
            if (leftPos < 0) leftPos = 0;
            
            int currentFruits = prefixSum[rightPos + 1] - prefixSum[leftPos];
            result = Math.max(result, currentFruits);
        }

        return result;
    }
}