class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        
        int minSubstring = 1;
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            if(freq[ch-'a']>1){
                freq = new int[26];
                freq[ch-'a']=1;
                minSubstring+=1;
            }
        }
        return minSubstring;
    }
}