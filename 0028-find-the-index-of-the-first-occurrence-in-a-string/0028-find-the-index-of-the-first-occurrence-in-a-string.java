class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }
        if(needle.length() == haystack.length()){
            if(needle.equals(haystack))return 0;
            return -1;
        }
        
        int n = needle.length() , m = haystack.length();
        
        for(int i = 0 ; i < haystack.length(); i++){
            if((i + n) <= m && haystack.substring(i,i + n).equals(needle))return i;
        }
        return -1;
    }
}