class Solution {
    public boolean halvesAreAlike(String s) {
        // s = s.toLowerCase();
        
        int cnt = 0;
        for(int i=0, j=s.length()/2;i<s.length()/2;i++,j++){
            char ch = s.charAt(i);
            char chh = s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                cnt++;
            }
            if(chh=='a' || chh=='e' || chh=='i' || chh=='o' || chh=='u' || chh=='A' || chh=='E' || chh=='I' || chh=='O' || chh=='U'){
                cnt--;
            }
        }
        return cnt==0;
    }
}