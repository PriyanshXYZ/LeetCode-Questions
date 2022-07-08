class Solution {
    class Pair{
        String config;
        int move;
    }
    public int slidingPuzzle(int[][] board) {
        HashSet<String> vis=new HashSet<>();
        
        Queue<Pair> q=new ArrayDeque<>();
        Pair p=new Pair();
        p.config=getBoardConfig(board);
        p.move=0;
        vis.add(p.config);
        int[][] dirs={
            {1,3},{0,2,4},{1,5},{0,4},{3,1,5},{4,2}
        };
        q.add(p);
        
        while(q.size()>0){
            int size=q.size();
            
            while(size-- >0){
                Pair rPair=q.remove();
                if(rPair.config.equals("123450")){
                    return rPair.move;
                }
                int idx=rPair.config.indexOf('0');
                for(int dir : dirs[idx]){
                    
                    Pair pp=new Pair();
                    pp.config=swap(rPair.config,idx,dir);
                    
                    pp.move=rPair.move+1;
                    if(vis.contains(pp.config)==false){
                        q.add(pp);
                        vis.add(pp.config);
                    }
                }
            }
            
        }
        return -1;
    }
    
    public String swap(String str,int idx,int dir){
        StringBuilder sb=new StringBuilder(str);
        char ch1=sb.charAt(idx);
        char ch2=sb.charAt(dir);
        sb.setCharAt(idx,ch2);
        sb.setCharAt(dir,ch1);
        
        return sb.toString();
        
    }
    public String getBoardConfig(int[][] board){
        StringBuilder sb=new StringBuilder();
        
        for(int[] row:board){
            for(int val:row){
                sb.append(val);
            }
        }
        return sb.toString();
    }
}