class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        
        int cnt = 0;
        for(int i=0, j=s.length()/2;i<s.length()/2;i++,j++){
            char ch = s.charAt(i);
            char chh = s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                cnt++;
            }
            if(chh=='a' || chh=='e' || chh=='i' || chh=='o' || chh=='u'){
                cnt--;
            }
        }
        return cnt==0;
    }
}