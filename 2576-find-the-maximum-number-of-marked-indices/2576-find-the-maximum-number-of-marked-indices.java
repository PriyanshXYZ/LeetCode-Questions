class Solution1 {
    public int maxNumOfMarkedIndices(int[] nums) {
        int cnt = 0, n = nums.length;
        
        Arrays.sort(nums);
        boolean[] vis = new boolean[n];
        for(int i=0;i<n/2;i++){
            if(bs(i/2,n-1,2*nums[i], nums, vis)){
                cnt+=2;
            }
        }
        return cnt;
    }
    public boolean bs(int lo,int hi, int tar, int[] nums, boolean[] vis){
        boolean found = false;
        int index = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (tar <= nums[mid] && !vis[mid]) {
                
                found = true;
                index = mid;    
                
                hi = mid - 1;

            } else {
                lo = mid + 1;
            }

        }


        if (found)
            vis[index] = true;

        return found;
    }
}
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int cnt = 0,n=nums.length;
        // boolean[] vis = new boolean[n];
        Arrays.sort(nums);
        int j=(n+1)/2;
        int i=0;
        for(;j<n;j++){
            if(2*nums[i]<=nums[j]){
                cnt+=2;
                i++;
            }
        }
        return cnt;
    }
    
}