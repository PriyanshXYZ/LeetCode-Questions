class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq=new int[26];
        //adding freq of string s characters
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        //subtracting freq of string t characters
        for(char ch:t.toCharArray()){
            freq[ch-'a']--;
            if(freq[ch-'a']<0)return false;
        }
        
        for(int i=0;i<26;i++){
            if(freq[i]>0)return false;
        }
        return true;
    }
}