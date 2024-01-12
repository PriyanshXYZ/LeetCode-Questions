class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        
        int cnt = 0;
        for(int i=0;i<s.length()/2;i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                cnt++;
            }
        }
        for(int i=s.length()/2;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                cnt--;
            }
        }
        return cnt==0;
    }
}