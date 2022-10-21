class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer,Integer> map=new TreeMap();
        int n=nums.length;
        for(int i=0;i<n;i++){
            Integer floor=map.floorKey(nums[i]+valueDiff);
            Integer ceil=map.ceilingKey(nums[i]-valueDiff);
            if(floor!=null && floor>=nums[i]){
                // System.out.println(i+" "+nums[i]+" "+map.get(floor)+" "+floor+" => floor");
                return true;
            }else if(ceil!=null && ceil<=nums[i]){
                // System.out.println(i+" "+nums[i]+" "+map.get(ceil)+" "+ceil+" => ceil");
                return true;
            }
            map.put(nums[i],i);
            if(i>=indexDiff){
                map.remove(nums[i-indexDiff]);
            }
        }
        return false;
    }
}