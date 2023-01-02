class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        int idx=0;
        int i =0;
        for(char ch : word.toCharArray()){
            if(ch>='A' && ch<='Z'){
                idx = i;
                capitalCount++;
            }
            i++;
        }
        if(capitalCount<=1){
            if(idx == 0)return true;
            else return false;
        }else if(capitalCount == word.length()){
            return true;
        }
        return false;
    }
}