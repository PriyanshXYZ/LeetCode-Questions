class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> map=new HashMap();
        //get a subarray of max length (to get min of operations to reduce to 0)
        int target=0;
        map.put(0,-1);//to handle case of sum==target 
        for(int num:nums)target+=num;
        
        target=target-x;
        
        if(target==0)return nums.length;
        int sum=0;
        int size=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-target)){
                size=Math.max(size,i-map.get(sum-target));
            }
            map.put(sum,i);
        }
        return size==0?-1:nums.length-size;
    }
}