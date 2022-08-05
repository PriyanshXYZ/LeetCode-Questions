class Solution {
    public int longestOnes(int[] nums, int k) {
        int cz=0;
        
        int len=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                cz++;
            }
            
            //if count of 0 exceeds...
            while(cz>k){
                if(nums[j]==0){
                    cz--;
                }
                j++;//pointer to keep a window..
            }
            // System.out.println(i+" "+j+" "+cz);
            len=Math.max(len,i-j+1);
        }
        
        return len;
    }
}