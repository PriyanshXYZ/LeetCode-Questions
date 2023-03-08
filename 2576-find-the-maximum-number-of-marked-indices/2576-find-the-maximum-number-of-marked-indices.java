class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int res = 0;
        Arrays.sort(nums);

        // visited array to mark the indices we visited , so not to take the 
        // same indices again
        boolean[] visited = new boolean[nums.length];
        for(int i = 0;i<nums.length/2;i++)
        {
            int target = 2 * nums[i];
            if(binarySearch(nums, target , i/2 , nums.length-1, visited))
                res+=2;
        }

        return res;
    }
  
    boolean binarySearch(int [] nums , int target , int start , int end, boolean [] visited){

        boolean found = false;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target <= nums[mid] && !visited[mid]) {
                found = true;
                index = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }

        }


        if (found)
            visited[index] = true;

        return found;
    }
}
class Solution1 {
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