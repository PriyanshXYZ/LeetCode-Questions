class Solution {
    public int longestNiceSubarray(int[] res) {
        int n = res.length; 
        int used = 0,strt=0,end =0;
        int ans =0;
        while(end<n){
            while((used&res[end])!=0){
                used^=res[strt];
                strt++;
            }
            used |= res[end];
            ans = Math.max(end-strt+1,ans);
            end++;
        }
        return ans;
    } 
}