class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {    
        int idx = 0;
        
        for(int i = 0; i < str1.length() && idx<str2.length(); i++) {
            char ch = str2.charAt(idx);
            char ch1 = str1.charAt(i);
            char ch2 = (char)((str1.charAt(i) - 'a' + 1) % 26 + 'a');
            if(ch == ch1 || ch == ch2){
                idx++;
            }
        }
        return idx == str2.length();
    }
}