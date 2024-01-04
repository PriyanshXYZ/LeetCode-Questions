class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for(int key : freq.keySet()){
            int f = freq.get(key);
            if(f==1)return -1;
            ans += Math.ceil((double) f/3);
        }
        return ans;
    }
}