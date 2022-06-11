class Solution1 {
    //O(n) TC and SC
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
class Solution{
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        
        if(sum-x==0)return nums.length;
        
        int left=0;
        int minOp=Integer.MAX_VALUE;
        int n=nums.length-1;
        for(int right=0;right<=n;right++){
            sum-=nums[right];
            while(sum<x && left<=right){
                sum+=nums[left];
                left++;
            }
            if(sum==x){
                minOp=Math.min(minOp,n-right+left);
            }
        }
        return minOp==Integer.MAX_VALUE?-1:minOp;
    }
}