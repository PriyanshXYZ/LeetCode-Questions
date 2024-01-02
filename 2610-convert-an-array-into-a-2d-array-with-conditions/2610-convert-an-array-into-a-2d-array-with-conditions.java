class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums){
            uniq.add(num);
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<List<Integer>> res = new ArrayList<>();
        
        
        while(freq.size()>0){
            List<Integer> list = new ArrayList<>();
            for(int num : uniq){
                if(freq.containsKey(num) && freq.get(num)>0){
                    list.add(num);
                    freq.put(num,freq.get(num)-1);
                }else{
                    freq.remove(num);
                }
            }
            if(list.size()>0)
                res.add(list);
        }
        return res;
    }
}