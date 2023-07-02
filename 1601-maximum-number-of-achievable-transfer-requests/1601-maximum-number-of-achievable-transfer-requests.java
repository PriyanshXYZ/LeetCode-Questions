class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return backtrack(0,requests,indegree,0);
    }
    
    public int backtrack(int idx, int[][] req, int[] indegree,int cnt){
        //base case
        if(idx == req.length){
            for(int deg : indegree){
                if(deg!=0)return 0;
            }
            return cnt;
        }
        
        //successful transfer
        indegree[req[idx][0]]--;
        indegree[req[idx][1]]++;
        
        int success = backtrack(idx + 1, req, indegree,cnt + 1);
        
        //unsuccessful transfer
        indegree[req[idx][0]]++;
        indegree[req[idx][1]]--;
        int notSuccess = backtrack(idx + 1, req, indegree,cnt);
        
        return Math.max(success, notSuccess);
    }
}