class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        Integer[][] dp = new Integer[n][n];
        int maxScore = memo(0,arr,-1,dp);
        return maxScore;
    }
    public int memo(int idx, int[][] a, int prev, Integer[][] dp){
        if(idx==a.length)return 0;
        
        if(prev !=-1 && dp[idx][prev] != null) return dp[idx][prev];
        
        int exc = memo(idx+1,a,prev,dp);
        int inc = 0;
        if(prev==-1){
            inc = a[idx][1] + memo(idx+1, a, idx, dp);
        }
        //conflict between players of different age so we need to keep prev choosen se bada score
        else if(a[idx][0]>a[prev][0] && a[idx][1]>=a[prev][1]){
            inc = a[idx][1] + memo(idx+1, a, idx, dp);
        //conflict wil not happend in casee of same age
        }else if(a[idx][0]==a[prev][0]){
            inc = a[idx][1] + memo(idx+1, a, idx, dp);
        }
        
        int ans = Math.max(inc,exc);
        if(prev!=-1){
            dp[idx][prev] = ans;
        }
        return ans;
    }
}