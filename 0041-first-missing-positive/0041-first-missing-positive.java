class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        int val = 1;
        while(set.contains(val)){
            val++;
        }
        return val;
    }
}