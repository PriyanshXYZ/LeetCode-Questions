class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = 0;
        int n = word.length();
        for(int i=0;i<n;i++){
            if(word.charAt(i)==ch){
                idx=i;
                break;
            }
        }
        
        String res = "";
        int cnt = idx;
        while(cnt>=0){
            res += word.charAt(cnt);
            cnt--;
        }
        if(idx<n)
            res += word.substring(idx+1);
        return res;
    }
}