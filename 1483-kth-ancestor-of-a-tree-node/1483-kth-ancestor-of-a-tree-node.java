class TreeAncestor {
    
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        dp=new int[16][parent.length];
        
        for(int bits=0;bits<dp.length;bits++){
            for(int j=0;j<n;j++){
                if(bits==0){
                    dp[bits][j]=parent[j];
                }else{
                    int s1=dp[bits-1][j];
                    dp[bits][j]=s1==-1?-1:dp[bits-1][s1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int res=node;
        
        int bits=0;
        while((1<<bits)<=k){
            if((k & (1<<bits))!=0){
                res=dp[bits][res];
                if(res==-1)return -1;
            }
            bits++;
            
        }
        return res;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */