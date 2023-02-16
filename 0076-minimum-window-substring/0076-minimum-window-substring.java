class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        
        Map<Character,Integer> mapT = new HashMap<>();
        for(char ch : t.toCharArray()){
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> mapS = new HashMap<>();
        int strtIdx=-1;
        int minLen = s.length()+1;
        int count = 0;
        
        for(int right = 0, left = 0; right <s.length(); right++){
            char ch = s.charAt(right);
            mapS.put(ch , mapS.getOrDefault(ch,0)+1);
            
            if(mapT.containsKey(ch) && mapS.get(ch) <= mapT.get(ch)){
                count++;
            }
            
            if(count == t.length()){//we got a subarray which has String t in it
                //try to reduce the size of subarray
                while(mapS.get(s.charAt(left))>mapT.getOrDefault(s.charAt(left),0) || mapT.getOrDefault(s.charAt(left),0)==0){
                    if(mapS.get(s.charAt(left))>mapT.getOrDefault(s.charAt(left),0)){
                        mapS.put(s.charAt(left),mapS.get(s.charAt(left))-1);
                    }
                    left++;
                }
                int windowLen = right - left + 1;
                if(minLen > windowLen){
                    minLen = windowLen;
                    strtIdx = left;
                }
            }
        }
        
        if(strtIdx==-1)return "";
        return s.substring(strtIdx,strtIdx+minLen);
    }
}