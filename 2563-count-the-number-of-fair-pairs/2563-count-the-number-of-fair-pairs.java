class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ct = 0;
        int lo=n-1,hi=n-1;
        for (int i = 0; i < n; i++) {
            while(hi>=0 && (nums[i]+nums[hi])>upper)--hi;
            while(lo>=0 && (nums[i]+nums[lo])>=lower)--lo;
            System.out.println(hi-lo);
            ct += hi - lo;
            if(lo<i && hi>=i)--ct;//self pair must be excluded
            
        }
        return ct/2;//we have duplicate pairs i.e i,j & j,i so we remove them
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