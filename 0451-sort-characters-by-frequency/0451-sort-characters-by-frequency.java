class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap();
        HashMap<Integer,String> freq=new HashMap();
        int maxFreq=0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(map.get(ch),maxFreq);
        }
        
        for(char ch:map.keySet()){
            int f=map.get(ch);
            if(!freq.containsKey(f)){
                freq.put(f,"");
            }
            freq.put(f,freq.get(f)+ch);
        }
        // System.out.println(map);
        // System.out.println(freq);
        // System.out.println(maxFreq);
        StringBuilder sb=new StringBuilder();
        while(maxFreq >0){
            if(freq.containsKey(maxFreq)){
                for(int i=0;i<freq.get(maxFreq).length();i++){
                    char ch=freq.get(maxFreq).charAt(i);
                    int count=maxFreq;
                    while(count-- >0){
                        sb.append(ch);
                    }
                }
            }
            maxFreq--;
        }
        return sb.toString();
    }
}