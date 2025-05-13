class Solution {
    public int findMaxForm(String[] strs, int M, int N) {
        int[][] dp =new int[M+1][N+1];

        for(String str : strs) {
            int[] count = getZerosAndOnes(str);
            int cntZeros = count[0];
            int cntOnes = count[1];
            for(int m=M;m>=cntZeros;m--){
                for(int n=N;n>=cntOnes;n--){
                    int take = 1 + dp[m-cntZeros][n-cntOnes];
                    int notTake = dp[m][n];
                    dp[m][n] = Math.max(take, notTake);
                }
            }
            // print(dp);
        }
        return dp[M][N];
    }
    private void print(int[][] dp) {
        for(int[] col : dp) {
            for(int val : col){
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int[] getZerosAndOnes(String str) {
        int zeros = 0;
        int ones = 0;
        for(char ch : str.toCharArray()){
            if(ch=='1'){
                ones++;
            }else{
                zeros++;
            }
        }
        return new int[]{zeros,ones};
    }
}