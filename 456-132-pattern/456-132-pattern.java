class Solution {
    public boolean find132pattern(int[] nums) {
        //using stack
       Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = stack.pop();
            }
            if (nums[i] > max) stack.push(nums[i]);
            if (nums[i] < max) return true;
        }
        return false;
        
    }
     // O(n^2) 
    public boolean better(int[] nums) {
        int min=nums[0];
        for(int j=1;j<nums.length;j++){
            for(int k=j+1;k<nums.length;k++){
                if(min<nums[k] && nums[k]<nums[j])return true;   
            }
            min=Math.min(nums[j],min);
        }
        return false;
    }
    
    //0(n^3) TLE
    public boolean bruteForce(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i] < nums[k] && nums[k] < nums[j])return true;
                }
            }
        }
        return false;
    }
}