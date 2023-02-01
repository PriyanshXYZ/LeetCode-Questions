//using segment tree
class Solution {
    int[] tree = new int[4*1000+5];
    void update(int start, int end, int parent, int index, int val){
        if(start==end){
            tree[parent]=val;
            return;
        }
        int mid=(start+end)/2;
        if(index<=mid){
            update(start,mid,2*parent+1,index,val);
        }
        else{
            update(mid+1,end,2*parent+2,index,val);
        }
        tree[parent]=Math.max(tree[2*parent+1],tree[2*parent+2]);
    }
    
    int query(int start, int end, int parent, int qstart, int qend){
        if(qstart>end || qend<start){
            return 0;
        }
        if(qstart<=start && qend>=end){
            return tree[parent];
        }
        int mid=(start+end)/2;
        int L=query(start,mid,2*parent+1,qstart,qend);
        int R=query(mid+1,end,2*parent+2,qstart,qend);
        return Math.max(L,R);
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr,(a,b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        
        int res = 0;
        for(int[] a : arr){
            int age = a[0];
            int score = a[1];
            int maxScore = score + query(0,1000,0,0,age);
            update(0,1000,0,age,maxScore);
            res = Math.max(res, maxScore);
        }
        return res;
    }
}
//using dp
class Solution1 {
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