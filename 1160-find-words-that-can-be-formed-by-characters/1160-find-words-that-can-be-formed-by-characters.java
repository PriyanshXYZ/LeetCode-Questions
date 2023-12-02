class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        int ans = 0;
        for(String word : words){
            for(char ch : word.toCharArray()){
                freq1[ch-'a']++;
            }
            for(char ch : chars.toCharArray()){
                freq2[ch-'a']++;
            }
            boolean flag = true;
            int cnt = 0;
            for(int i=0;i<26;i++){
                if(freq2[i]>=freq1[i]){
                    cnt += freq1[i];
                }else{
                    cnt = 0;
                    break;
                }
            }
            ans += cnt;
            
            freq1 = new int[26];
            freq2 = new int[26];
        }
        return ans;
    }
}