class Solution {
    
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = 0;
        int maxDiff = nums[n - 1] - nums[0];
        int ans = 0;

        while(minDiff < maxDiff) {
            int currDiff = minDiff + (maxDiff - minDiff) / 2;

            if(possibleDiffLessThanK(nums, currDiff, k)) {
                minDiff = currDiff + 1;
            }else {
                maxDiff = currDiff;
            }
        }

        return minDiff;
    }
    /**
     [1, 2, 3, 4, 5, 6, 7]
      1-7 -> 6 pair
      2-7 -> 5 pair
      3-7 -> 4 pair
      4-7 -> 3 pair
      5-7 -> 2 pair
      6-7 -> 1 pair
      7-7 -> 0 pair
     */

    private boolean possibleDiffLessThanK(int[] nums, int difference, int k) {
        int count = 0;
        
        for (int left = 0; left < nums.length; left++) {
            int right = upperBound(nums, left, nums.length, nums[left] + difference);
            count += (right - left - 1);
        }
        return count<k;
    }
    private int upperBound(int[] nums, int left, int right, int k) {
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] <= k) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}