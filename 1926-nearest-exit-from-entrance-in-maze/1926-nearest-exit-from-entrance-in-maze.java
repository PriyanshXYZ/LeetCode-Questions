class Solution {
    class Pair{
        int x;
        int y;
        int z;
        
        Pair(int x,int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        public String toString(){
            return x+" "+y+" "+z;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Pair> q=new ArrayDeque<>();
        // q.add(new Pair(entrance[0],entrance[1],0));
        boolean[][] vis=new boolean[maze.length][maze[0].length];
        vis[entrance[0]][entrance[1]]=true;
        for(int[] dir:dirs){
            int x=entrance[0]+dir[0];
            int y=entrance[1]+dir[1];

            if(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]=='.' && vis[x][y]==false){
                q.add(new Pair(x,y,1));
                vis[x][y]=true;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            // System.out.println(q);
            while(size-- >0){
                Pair rem=q.remove();
                
                
                for(int[] dir:dirs){
                    int x=rem.x+dir[0];
                    int y=rem.y+dir[1];
                    
                    if(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]=='.' && vis[x][y]==false){
                        vis[x][y]=true;
                        q.add(new Pair(x,y,rem.z+1));
                    }else if(x<0 || y<0 || x==maze.length || y==maze[0].length){
                        return rem.z;
                    }
                }
            }
        }
        return -1;
    }
}