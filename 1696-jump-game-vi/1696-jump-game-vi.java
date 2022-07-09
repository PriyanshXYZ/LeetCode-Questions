class Solution {
    
    public int maxResult(int[] nums, int k) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        LinkedList<Integer> list=new LinkedList<>();
        
        // return recursion(nums,0,k);
        // return memo(nums,0,k,dp);
        return optimized(nums,k,dp,list);
    }
    public int recursion(int[] nums,int idx,int k){
        //base
        if(idx==nums.length-1)return nums[idx];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=k;i++){
            if(idx+i<nums.length){
                int curr=recursion(nums,idx+i,k)+nums[idx];
                ans=Math.max(curr,ans);
            }
        }
        return ans;
    }
    public int memo(int[] nums,int idx,int k,int[] dp){
        //base
        if(idx==nums.length-1)return dp[idx]=nums[idx];
        
        if(dp[idx]!=Integer.MIN_VALUE)return dp[idx];
        
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=k;i++){
            if(idx+i<nums.length){
                int curr=memo(nums,idx+i,k,dp)+nums[idx];
                ans=Math.max(curr,ans);
            }
        }
        return dp[idx]=ans;
    }
    public int optimized(int[] nums,int k,int[] dp,LinkedList<Integer> list){
        int n=nums.length;
        list.add(0);
        
        for(int i=1;i<n;i++){
            if((list.getFirst()+k)<i)list.removeFirst();
            nums[i]+=nums[list.getFirst()];
            while(!list.isEmpty() && nums[list.getLast()]<=nums[i])list.removeLast();
            list.addLast(i);
        }
        
        return nums[n-1];
    }
}