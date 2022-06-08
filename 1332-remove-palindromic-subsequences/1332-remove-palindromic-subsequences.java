class Solution {
    public int removePalindromeSub(String s) {
        if(s.length()==0)return 0;
        if(isPalindrome(s)){
            return 1;
        }else{
            //becuase insubsequence we can delete in any order ...if question would have been of substring then if would result in other operations as well
            return 2;
        }
    }
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}