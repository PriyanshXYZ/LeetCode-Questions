class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> idxMap=new HashMap();
        
        int si=0,ei=0,maxLen=0;//start idx,end idx,maxLen possible
        
        for(;ei<s.length();ei++){
            if(idxMap.containsKey(s.charAt(ei))){
                if(si<idxMap.get(s.charAt(ei))+1){
                    si=idxMap.get(s.charAt(ei))+1;
                }
            }
            idxMap.put(s.charAt(ei),ei);
            maxLen=Math.max(maxLen,ei-si+1);
        }
        return maxLen;
    }
}