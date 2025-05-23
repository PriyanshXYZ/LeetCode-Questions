class Solution {
    /**
     [0,1,1,1,1,1,0,0,0]

     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum =0;
        Map<Integer, Integer> map = new HashMap();
        map.put(sum,-1);
        int maxLen = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                sum -=1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i-map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}