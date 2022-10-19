class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        Map<Integer,Set<String>> freq=new TreeMap(Collections.reverseOrder());
        
        for(String key:map.keySet()){
            int val=map.get(key);
            if(!freq.containsKey(val))
                freq.put(val,new TreeSet());
            freq.get(val).add(key);
        }
        
        List<String> ans=new ArrayList();
        for(int f:freq.keySet()){
            List<String> a=new ArrayList(freq.get(f));
            for(int i=0;i<freq.get(f).size() && k>0;i++,k--){
                ans.add(a.get(i));
            }
            if(k==0)break;
        }
        return ans;
    }
}