class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1)return true;
        int[] orderMap = new int[26];
        
        for(int i=0; i<order.length();i++){
            char ch = order.charAt(i);
            orderMap[ch-'a']=i;
        }
        
        
        int n = words.length;
        
        for(int i=0;i<n-1;i++){
            for(int j=0;j<words[i].length();j++){
                if(j>=words[i+1].length())return false;//it violates our condition
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    if(orderMap[words[i].charAt(j)-'a']>orderMap[words[i+1].charAt(j)-'a'])return false;
                    else break;
                }
            }
        }
        
        return true;
    }
}