class Solution {
    public int numberOfSubstrings(String s) {
        return atMost(s,3) -atMost(s,2);
    }
    
    public int atMost(String s,int k){
        int ans=0;
        Map<Character,Integer> charFreq=new HashMap();
        int si=0,ei=0;
        char[] a=s.toCharArray();
        for(;ei<s.length();ei++){
            charFreq.put(a[ei],charFreq.getOrDefault(a[ei],0)+1);
            
            while(charFreq.size()==k+1){
                charFreq.put(a[si],charFreq.getOrDefault(a[si],0)-1);
                if(charFreq.get(a[si])==0){
                    charFreq.remove(a[si]);
                }
                si++;
            }
            
            ans+=ei-si+1;
        }
        return ans;
    }
}