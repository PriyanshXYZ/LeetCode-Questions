class Solution {
    public int minimumLength(String s) {
        if(s.length()<2)return s.length();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1!=ch2)return j - i + 1;
            while(i<=j && s.charAt(i)==ch1){
                i++;
            }
            while(i<=j && s.charAt(j)==ch1){
                j--;
            }
        }
        if(i-j==1)return 0;
        else if(i-j>1)return 1;
        return j - i + 1;
    }
}