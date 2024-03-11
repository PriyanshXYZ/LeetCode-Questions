class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
       
        String res = "";
        for(char ch : order.toCharArray()){
            while(freq[ch-'a']>0){
                res += ch;
                freq[ch-'a']--;
            }
        }
        
        for(int ch=0;ch<26;ch++){
            while(freq[ch]>0){
                res+= (char)(ch + 'a');
                freq[ch]--;
            }
        }
       
        
        return res;
    }
}