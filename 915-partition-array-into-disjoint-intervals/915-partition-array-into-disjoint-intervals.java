class Solution {
    public int partitionDisjoint(int[] nums) {
        int  idx=0;
        int maxTillPartition=nums[0];
        int maxTillScan=nums[0];
        int n=nums.length;
        
        for(int i=1;i<n;i++){
            maxTillScan=Math.max(maxTillScan,nums[i]);
            
            if(nums[i]<maxTillPartition){
                idx=i;
                maxTillPartition=maxTillScan;
            }
        }
        return idx+1;
    }
}
class Solution1 {
    // TC O(n) & space O(n)
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int[] maxLeft=new int[n];
        int[] minRight=new int[n];
        
        storeMax(maxLeft,nums);
        storeMin(minRight,nums);
        
        int leftIdx=-1;
        for(int i=0;i<n;i++){
            int a=maxLeft[i];
            int b=i+1<n?minRight[i+1]:Integer.MIN_VALUE;
            leftIdx=i;
            if(a<=b){
                System.out.println(a+" "+b+" "+leftIdx);
                return leftIdx+1;
            }
        }
        return -1;
    }
    private void storeMax(int[] a,int[] b){
        int n=a.length;
        int prev=-1;
        for(int i=0;i<n;i++){
            a[i]=Math.max(prev,b[i]);
            prev=a[i];
            
        }
        
        
    }
    private void storeMin(int[] a,int[] b){
        int n=a.length;
        int ahead=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            a[i]=Math.min(ahead,b[i]);
            ahead=a[i];
        
        }
        
        
    }
}