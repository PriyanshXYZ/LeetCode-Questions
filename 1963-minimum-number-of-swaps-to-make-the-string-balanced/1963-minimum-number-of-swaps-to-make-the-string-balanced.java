class Solution {
    public int minSwaps(String s) {
        int pair = 0;
        int mismatch = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                pair++;
            }else{
                if(pair>0)pair--;
                else mismatch++;
            }
        }
        return (mismatch+1)/2;
    }
}