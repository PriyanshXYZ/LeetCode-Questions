class Solution {
    //O(nlogn)
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int loDiff=0;
        int hiDiff=nums[n-1]-nums[0];
        
        
        
        while(loDiff < hiDiff){
            int mid = loDiff + (hiDiff - loDiff)/2;
            
            int amount=0;
            int j=0;
            
            for(int i=0;i<n;i++){
                while(j<n && nums[j] - nums[i] <= mid){
                    j++;
                }
                
                amount += (j - i - 1);
            }
            
            if(amount < k){
                loDiff = mid+1;
            }else{
                hiDiff = mid;
            }
        }
        return loDiff;
    }
}
class Solution1 {
    //O(n^2) TLE
    public int smallestDistancePair(int[] nums, int k) {
        int len=(nums.length-1)*(nums.length)/2;
        int[] res=new int[len];
        int idx=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                res[idx++]=Math.abs(nums[i]-nums[j]);
            }
        }
        
        Arrays.sort(res);
        return res[k-1];
    }
}