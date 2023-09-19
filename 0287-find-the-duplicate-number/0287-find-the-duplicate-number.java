class Solution {
    //approach 1 sort and then check if i+1 !=nums[i] return it
    //approach 2 use hashset to get duplicate ..
    //approach 3 using linkedlist cycle detection... i.e if there is duplicacy we can get to that point again...so there would be a cycle we just have to start val of cycle ..using flyod cycle detection algo..
    
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        
        
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}