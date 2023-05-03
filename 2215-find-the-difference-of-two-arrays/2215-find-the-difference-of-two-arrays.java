class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        for(int i=0;i<n1;i++){
            set1.add(nums1[i]);
        }
        
        for(int i=0;i<n2;i++){
            set2.add(nums2[i]);
        }
        
        List<Set<Integer>> list = new ArrayList<>();
        
        list.add(new HashSet<>());
        for(int i=0;i<n1;i++){
            if(!set2.contains(nums1[i])){
                list.get(0).add(nums1[i]);
            }
        }
        list.add(new HashSet<>());
        for(int i=0;i<n2;i++){
            if(!set1.contains(nums2[i])){
                list.get(1).add(nums2[i]);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int val : list.get(0)){
            res.get(0).add(val);
        }
        
        res.add(new ArrayList<>());
        for(int val : list.get(1)){
            res.get(1).add(val);
        }
        return res;
    }
}