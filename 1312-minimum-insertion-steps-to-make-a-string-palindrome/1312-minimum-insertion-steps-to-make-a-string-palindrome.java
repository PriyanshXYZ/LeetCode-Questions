class Solution {
    private int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        }
        return memo[m][n] = Math.max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));
    }

    public int minInsertions(String s) {
        int n = s.length();
        String sRev = new StringBuilder(s).reverse().toString();
        int[][] memo = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j == 0)memo[i][j]=0;
                else if(s.charAt(i-1)==sRev.charAt(j-1)){
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else{
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return n - memo[n][n];
    }
}