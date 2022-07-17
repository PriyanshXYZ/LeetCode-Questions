class Solution{
    
    int M = 1000000007;
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return ((inv(n, k, dp) + M - (k > 0 ? inv(n, k - 1, dp) : 0)) % M);
    }
    public int inv(int n, int k,int[][] dp) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (dp[n][k] != -1)
            return dp[n][k];
        int val = (inv(n - 1, k, dp) + M - ((k - n) >= 0 ? inv(n - 1, k - n, dp) : 0)) % M;
        dp[n][k] = (inv(n, k - 1, dp) + val) % M;
        return dp[n][k];
    }
}
class Solution1 {
    //O(n^2*k) tc
    int mod=(int)(1e9+7);
    public int kInversePairs(int n, int k) {
        int[][] dp=new int[n+1][k+1];
        dp[0][0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                for(int a=Math.max(0,j-i+1);a<=j;a++){
                    dp[i][j]=(dp[i][j]%mod+dp[i-1][a]%mod)%mod;
                }
            }
        }
        return dp[n][k];
    }
    public int memo(int num,int n,int k,int[][] dp){
        if(num==n+1)return dp[num][k]=(k==0)?1:0;
        int count=0;
        if(dp[num][k]>=0)return dp[num][k];
        for(int i=Math.max(0,k-(num-1));i<=k;i++){
            count=(count%mod+memo(num+1,n,i,dp)%mod)%mod;
        }
        return dp[num][k]=count;
    }
}

class BruteForcer {
    public int kInversePairs(int n, int k) {
        return permutation(1,n,k);
    }
    public int permutation(int num,int n,int k){
        
        if(num==n+1)return k==0?1:0;
        int count=0;
        for(int i=Math.max(0,k-(num-1));i<=k;i++){
            count+=permutation(num+1,n,i);
        }
        return count;
    }
}
class BruteForcest {
    public int kInversePairs(int n, int k) {
        return permutation(1,n,k,new ArrayList());
    }
    public int permutation(int num,int n,int k,List<Integer> lsf){
        
        if(num==n+1)return isKInverse(k,lsf);
        int count=0;
        for(int i=0;i<=lsf.size();i++){
            List<Integer> perm=new ArrayList<>(lsf);
            perm.add(i,num);
            count+=permutation(num+1,n,k,perm);
        }
        return count;
    }
    
    private int isKInverse(int k,List<Integer> a){
        // System.out.println(a);
        int n=a.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a.get(i)>a.get(j)){
                   k--; 
                }
            }
        }
        return k==0?1:0;
    }
}