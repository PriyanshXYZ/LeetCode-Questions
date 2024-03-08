class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for(int num : nums){
            freq[num]++;
            maxFreq = Math.max(freq[num], maxFreq);
        }
        int ans = 0;
        for(int f : freq){
            ans += (f==maxFreq?f:0);
        }
        return ans;
    }
}