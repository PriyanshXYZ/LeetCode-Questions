class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        int idx = 0;
        for(int i: nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            if(map.getOrDefault(i,0)>0){
                res.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}