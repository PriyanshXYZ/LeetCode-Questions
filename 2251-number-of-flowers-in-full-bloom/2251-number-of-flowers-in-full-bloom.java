class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];
        
        
        for(int i=0;i<flowers.length;i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1] + 1;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] res = new int[people.length];
        int i = 0;
        for(;i<people.length;i++){
            int bloomed = bs(start,people[i]);
            int rotted = bs(end,people[i]);
            
            res[i] = bloomed - rotted;
        }
        return res;
    }
    
    public int bs(int[] arr, int target){
        long lo = 0;
        long hi = arr.length;
        
        while(lo < hi){
            long mid = lo + (hi - lo) / 2;
            if(arr[(int)mid]>target){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return (int)(lo);
    }
}