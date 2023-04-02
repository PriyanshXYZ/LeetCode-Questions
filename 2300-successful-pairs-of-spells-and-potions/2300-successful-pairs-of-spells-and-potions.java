class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            long ceil = (long)Math.ceil(1.0*success/spells[i]);
            if(ceil > potions[potions.length-1])continue;
            int idx = bs(potions , success, (long)spells[i]);
            res[i]= potions.length - idx;
        }
        return res;
    }
    int bs(int[] a, long target,long mul){
        int lo = 0, hi = a.length-1;
        while(lo<hi){
            int mid = lo + (hi - lo) / 2;
            
            long num = (long)((long)mul * (long) a[mid]);
            
            if(num>=target){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}