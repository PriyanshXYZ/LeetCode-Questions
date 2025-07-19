class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int len = 0;
        int res = 0;
        int[] lis = new int[n];
        int[] count = new int[n];
    
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(lis[i] == lis[j] + 1){
                        count[i] += count[j];
                    }else if (lis[i] < lis[j] + 1){
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            len = Math.max(len, lis[i]);
        }

        for(int i=0;i<n;i++){
            if(len == lis[i]){
                res += count[i];
            }
        }

        return res;
    }
}