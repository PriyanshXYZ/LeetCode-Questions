class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
		long curr = 0;
		for(int val : nums){
		    if(val==0){
		        curr+=1;
		    }else{
		        curr=0;
		    }
		    ans += curr;
		}
		return ans;
    }
}