class Solution {
    public boolean canReach(int[] arr, int start) {
        return recursion(arr,start,arr.length);
    }
    public boolean recursion(int[] arr,int start,int n){
        if(start>=0 && start<n && arr[start]>=0){
        if(arr[start]==0)return true;
        
        boolean ans1=false,ans2=false;
        arr[start]=-arr[start];
        ans1=recursion(arr,start+arr[start],n);

        ans2=recursion(arr,start-arr[start],n);
        return ans1 || ans2;
        }
        return false;
    }
}