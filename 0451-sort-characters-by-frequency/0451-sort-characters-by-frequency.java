class Solution {
    public String frequencySort(String str) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, String> freq = new HashMap<>();
        
        int maxFreq = 0;
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        
        for(var key : map.keySet()){
            int f = map.get(key);
            if(!freq.containsKey(f))freq.put(f,"");
            String s = freq.get(f);
            if(s.length()>0 && (s.charAt(s.length()-1)>key))freq.put(f,key + freq.get(f));
            else freq.put(f,freq.get(f)+key);
        }
        String res = "";
        while(maxFreq>0){
            if(freq.containsKey(maxFreq)){
                for(char ch : freq.get(maxFreq).toCharArray()){
                    res +=  IntStream.range(0, maxFreq).mapToObj(i -> String.valueOf(ch)).collect(Collectors.joining());
                }
            }
            maxFreq--;
        }
        return res;
    }
}