class Solution {
    public int numberOfSpecialChars(String word) {
        Integer[] idxCap = new Integer[26];
        Integer[] idxSmall = new Integer[26];
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z')idxSmall[ch-'a']=i;
            else {
                if(idxCap[ch-'A']==null)
                    idxCap[ch-'A']=i;
            }
        }
        int cnt = 0;
        for(int i=0;i<26;i++){
            if(idxCap[i]!=null && idxSmall[i]!=null){
                if(idxCap[i]>idxSmall[i])cnt++;
            }
        }
        return cnt;
    }
}