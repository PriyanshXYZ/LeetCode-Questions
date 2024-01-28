class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefix = new int[n][m];
        
        for(int j=0;j<n;j++){
            prefix[j][0] = matrix[j][0];
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                prefix[i][j] = matrix[i][j] + prefix[i][j-1];
            }
        }
        
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int curr = 0;
                for(int k=0;k<n;k++){
                    curr += prefix[k][j] - (i > 0 ? prefix[k][i-1] : 0);
                    res += map.getOrDefault(curr-target,0);
                    map.put(curr,map.getOrDefault(curr,0)+1);
                }
            }
        }
        return res;
    }
}