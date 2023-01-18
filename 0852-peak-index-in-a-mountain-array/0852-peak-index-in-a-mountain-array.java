class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
		int hi = arr.length;
		int ans = -1;
		while(lo<=hi){
			int mid = (lo + hi) / 2;

			if(mid>0 && arr[mid-1]>=arr[mid]){
				hi = mid - 1;
			}else{
				lo = mid + 1;
				ans = mid;
			}
		}
		return ans;
    }
}