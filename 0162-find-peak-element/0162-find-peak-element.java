class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==1)return 0;

		int lo = 0;
		int hi = arr.length;

		while(lo <= hi){
			int mid = (lo+hi)/2;

			if(mid==0){
				if(arr[mid]>arr[mid+1]){
					return mid;
				}else{
					lo = mid + 1;
				}
			}else if(mid == arr.length - 1){
				if(arr[mid]>arr[mid-1]){
					return mid;
				}else {
					hi = mid - 1;
				}
			}else{
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
					return mid;
				}else if(arr[mid] >= arr[mid-1]){//left part is sorted
					lo = mid + 1;
				}else{//right part is sorted
					hi = mid - 1;
				}
			}
		}
		return -1;
    }
}