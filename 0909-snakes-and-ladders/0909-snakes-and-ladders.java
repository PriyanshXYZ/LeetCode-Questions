class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public String toString(){
            return x+" "+y;
        }
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        Pair[] cell = new Pair[n*n + 1];
        int idx = 1;
        boolean flag = true;
        for(int i = n - 1 ; i >= 0; i--){
            if(flag){
                for(int j = 0; j < n; j++){
                    cell[idx++] = new Pair(i,j);
                }
            }else{
                for(int j = n - 1; j >= 0; j--){
                    cell[idx++] = new Pair(i,j);
                }
            }
            flag=!flag;
        }
        
        int moves=0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n*n+1];
        q.add(1);
        vis[1]=true;
        while(q.size()>0){
            int size = q.size();
            while(size-- > 0){
                int pos = q.remove();
                
                if(pos == n*n)return moves;
                
                for(int nbr = pos + 1; nbr <=Math.min(n*n,pos+6); nbr++){
                    int x = cell[nbr].x;
                    int y = cell[nbr].y;
                    int val = board[x][y]==-1? nbr : board[x][y];
                    if(vis[val]==false){
                        q.add(val);
                        vis[val]=true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}