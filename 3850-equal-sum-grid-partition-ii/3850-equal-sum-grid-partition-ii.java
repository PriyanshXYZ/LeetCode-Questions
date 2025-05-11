class Solution {
    final int MAX_VALUE = 100001;
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long gridSum = 0;
        long[] rowwiseSum = new long[n];
        long[] colwiseSum = new long[m];

        Integer[] minRow = new Integer[MAX_VALUE];
        Integer[] maxRow = new Integer[MAX_VALUE];
        Integer[] minCol = new Integer[MAX_VALUE];
        Integer[] maxCol = new Integer[MAX_VALUE];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int v = grid[i][j];
                gridSum += v;
                rowwiseSum[i] += v;
                colwiseSum[j] += v;

                if (minRow[v] == null) {
                    minRow[v] = maxRow[v] = i;
                    minCol[v] = maxCol[v] = j;
                } else {
                    if (i < minRow[v]) minRow[v] = i;
                    if (i > maxRow[v]) maxRow[v] = i;
                    if (j < minCol[v]) minCol[v] = j;
                    if (j > maxCol[v]) maxCol[v] = j;
                }
            }
        }

        long currRowUpperSum = 0L;
        for(int i=0;i<n-1;i++){
            currRowUpperSum += rowwiseSum[i];
            long currRowLowerSum = gridSum - currRowUpperSum;
            
            if(currRowUpperSum == currRowLowerSum)return true;
            else if(currRowUpperSum > currRowLowerSum){
                long diff = currRowUpperSum - currRowLowerSum;
                if(diff>MAX_VALUE || minRow[(int)diff]==null)continue;
                if(i==0 || m==1){
                    if(diff==grid[0][0] || diff == grid[0][m-1])return true;
                }else if(minRow[(int)diff]<=i){
                    return true;
                }
            }else{
                long diff = currRowLowerSum - currRowUpperSum;
                if(diff>MAX_VALUE || maxRow[(int)diff]==null)continue;
                if(i==n-2){
                    if(diff==grid[i+1][0] || diff== grid[i+1][m-1])return true;
                }else if(maxRow[(int)diff]>i){
                    return true;
                }
            }
        }


        long currColLeftSum = 0L;
        for(int j=0;j<m-1;j++){
            currColLeftSum += colwiseSum[j];
            long currColRightSum = gridSum - currColLeftSum;
            
            if(currColLeftSum == currColRightSum)return true;
            else if(currColLeftSum > currColRightSum){
                long diff = currColLeftSum - currColRightSum;
                if(diff>MAX_VALUE || minCol[(int)diff]==null)continue;
                if(j==0 || n==1){
                    if(diff==grid[0][0] || diff== grid[n-1][0])return true;
                }else if(minCol[(int)diff]<=j){
                    return true;
                }
            }else{
                long diff = currColRightSum - currColLeftSum;
                if(diff>MAX_VALUE || maxCol[(int)diff]==null)continue;
                if(j==m-2){
                    if(diff==grid[n-1][0] || diff== grid[n-1][m-1])return true;
                }else if(maxCol[(int)diff]>j){
                    return true;
                }
            }
        }
        return false;
    }
}