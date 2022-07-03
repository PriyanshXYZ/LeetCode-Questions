class Solution {
    public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
		// max of taking the next one as increasing or decreasing + 1
        return 1 + Math.max(recurseHelper(nums, 1, 0, true), recurseHelper(nums, 1, 0, false));
    }

    public int recurseHelper(int[] nums, int current, int prev, boolean positive) {
        if (current < 0 || current >= nums.length || prev < 0 || prev >= nums.length) {
            return 0;
        }
		// if the diff between prev and current should be positive,
        if (positive) {
		    // yes, it is positive, increment and change it to negative
            if (nums[prev] > nums[current]) {
                return 1 + recurseHelper(nums, current + 1, current, !positive);
            } else {
			   // its not positive. try the next element
                return recurseHelper(nums, current + 1, current, positive);
            }
        } else {
		   // if the diff between prev and current should be negative,
            if (nums[prev] < nums[current]) {  // yes, it is negative, increment and change it to positive
                return 1 + recurseHelper(nums, current + 1, current, !positive);
            } else {
				// its not negative. try the next element
                return recurseHelper(nums, current + 1, current, positive);
            }
        }
    }
}
//O(n) tc and O(1) sc
class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=2)return 1;
        else{
            int diff=nums[1]-nums[0];
            int flag=diff>0?1:diff==0?-1:0;//if diff is >0 flag is 1 and <0 flag is 0 and -1 for diff==0
            int count=diff==0?1:0;//if diff is 0 we need to keep count as 1
            for(int i=1;i<nums.length-1;i++){
                int currDiff=nums[i+1]-nums[i];
                
                if(currDiff==0){
                    count++;
                    
                    continue;
                }
                if(state(currDiff)!=flag){
                    flag=state(currDiff);
                }else{
                    count++;
                }
            }
            return nums.length-count;
        }
        
    }
    public int state(int x){
        if(x>0){
            return 1;
        }else{
            return 0;
        }
    }
}
