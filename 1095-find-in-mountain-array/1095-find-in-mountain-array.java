/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0;
        int hi = mountainArr.length();
        int val = -1;
        
        int peakIdx = peak(mountainArr, lo, hi);
        //search in increasing part of the array
        lo = 0;
        hi = peakIdx;
        while(lo<hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mountainArr.get(mid) < target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
            
        }
        
        if(mountainArr.get(lo) == target)
            return lo;
        
        //search in decreasing part of the array
        lo = peakIdx + 1;
        hi = mountainArr.length()-1;
        while(lo<hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mountainArr.get(mid) > target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        if(mountainArr.get(lo) == target)
            return lo;
        return -1;
        
    }
    public int peak(MountainArray mountainArr, int lo, int hi) {

		while(lo <= hi){
			int mid = (lo+hi)/2;

			if(mid==0){
				if(mountainArr.get(mid)>mountainArr.get(mid + 1)){
					return mid;
				}else{
					lo = mid + 1;
				}
			}else if(mid == mountainArr.length() - 1){
				if(mountainArr.get(mid)>mountainArr.get(mid - 1)){
					return mid;
				}else {
					hi = mid - 1;
				}
			}else{
				if(mountainArr.get(mid)>mountainArr.get(mid - 1) && mountainArr.get(mid)>mountainArr.get(mid + 1)){
					return mid;
				}else if(mountainArr.get(mid) >= mountainArr.get(mid - 1)){//left part is sorted
					lo = mid + 1;
				}else{//right part is sorted
					hi = mid - 1;
				}
			}
		}
		return -1;
    }
}