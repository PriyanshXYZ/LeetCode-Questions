class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> freqMap = new HashMap<>();
        
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        int max = 0;
        for(int key : map.keySet()){
            if(!freqMap.containsKey(map.get(key)))
                freqMap.put(map.get(key),new ArrayList<>());
            freqMap.get(map.get(key)).add(key);
            max = Math.max(map.get(key),max);
        }
        // System.out.println(freqMap);
        // System.out.println(max);
        List<Integer> ans = new ArrayList<>();
        while(max>0 && k>0){

            if(freqMap.containsKey(max)){
                
                int idx = 0;
                while(k>0 && idx<freqMap.get(max).size()){
                    ans.add(freqMap.get(max).get(idx));
                    idx++;
                    k--;
                }
            }
            max--;
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}