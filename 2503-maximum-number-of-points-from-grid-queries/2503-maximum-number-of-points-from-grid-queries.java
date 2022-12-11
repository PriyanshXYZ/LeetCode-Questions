class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m=grid.length;
        int n=grid[0].length;
        int[] res=new int[queries.length];
        int[] arr = new int[1000001]; 
        int max=0;
        int count=0;
        boolean[][] vis=new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]); 
        pq.add(new int[] { 0, 0 }); 
        while (!pq.isEmpty()) { 
            int[] del = pq.remove(); 
            int r = del[0]; 
            int c = del[1]; 
            if (vis[r][c]) 
                continue; 
            vis[r][c] = true; 
            max = Math.max(max, grid[r][c]); 
            if (grid[r][c] == max) { 
                count++; 
                arr[grid[r][c]]++; 
            }else { 
                arr[max]++; 
            }
            for(int[] dir:dirs){
                int x=r+dir[0];
                int y=c+dir[1];
                if(x>=0 && y>=0 && x<m && y<n)
                    pq.add(new int[]{x,y});
            }
      } 
      for (int i = 1; i < arr.length; i++) { 
          arr[i] += arr[i - 1]; 
      } 
      int[] ans = new int[queries.length]; 
      for (int i = 0; i < queries.length; i++) { 
          ans[i] = arr[queries[i] - 1]; 
      } 
      return ans; 
        
        
    }
//     public void dfs(int r, int c, int[] cnt,int val, boolean[][] vis, int[][] grid){
//         if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || vis[r][c] || grid[r][c]>=val)return;
        
//         vis[r][c]=true;
//         cnt[0]++;
//         for(int[] dir : dirs){
//             int x=r+dir[0];
//             int y=c+dir[1];
//             dfs(x,y,cnt,val,vis,grid);
//         }
//     }
}