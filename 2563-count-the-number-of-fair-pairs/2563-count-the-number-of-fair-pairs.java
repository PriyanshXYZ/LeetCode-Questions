class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ct = 0;
        for (int i = 0; i < n; i++) {
            int j = lower(nums,lower-nums[i],i);
            
            int k = upper(nums,upper-nums[i],i);
            
            ct += k - j;
            
        }
        return ct;
    }
    public  int lower(int arr[],int key, int idx){
        int low = idx + 1;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < key){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    public int upper(int arr[],int key, int idx){
        int low =  idx + 1;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] > key){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}