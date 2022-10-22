class Solution {
    public void setZeroes(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        
        boolean col0=false;
        
        for(int i=0;i<n;i++){
            if(a[i][0]==0){
                col0=true;
            }
            for(int j=1;j<m;j++){
                if(a[i][j]==0){
                    a[0][j]=0;
                    a[i][0]=0;
                }
            }
        }
        
        //iterating thorugh cols
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                if(a[0][j]==0 || a[i][0]==0){
                    a[i][j]=0;
                }
            }
        }
        
        if(a[0][0]==0){
            for(int j=0;j<m;j++){
                a[0][j]=0;
            }    
        }
        if(col0){
            for(int i=0;i<n;i++){
                a[i][0]=0;
            }
        }
        
    }
}
class Solution1 {
    class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    //time complexity O(n*m)  space compelxty O(zeros)
    public void setZeroes(int[][] matrix) {
        List<Pair> zeros=new ArrayList();
        int n=matrix.length;
        int m=matrix[0].length;
        //getting zeros
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    Pair p=new Pair(i,j);
                    zeros.add(p);
                }
            }
        }
        if(zeros.size()==m*n)return;
        for(Pair p:zeros){
            int r=p.x;
            int c=p.y;
            
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
            for(int j=0;j<m;j++){
                matrix[r][j]=0;
            }
        }
    }
    
}