class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=2)return 1;
        else{
            int diff=nums[1]-nums[0];
            int flag=diff>0?1:diff==0?-1:0;//if diff is >0 flag is 1 and <0 flag is 0 
            int count=diff==0?1:0;
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
