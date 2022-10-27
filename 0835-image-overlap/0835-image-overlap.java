class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int ans=0;
        
        for(int i=-img1.length;i<img1.length;i++){
            for(int j=-img1[0].length;j<img1[0].length;j++){
                ans=Math.max(ans,overlap(img1,img2,i,j));
                ans=Math.max(ans,overlap(img2,img1,i,j));
            }
        }
        return ans;
    }
    
    public int overlap(int[][] a,int[][] b,int rowOffset,int colOffset){
        int ans=0;
        
        for(int row=0;row<a.length;row++){
            for(int col=0;col<a[0].length;col++){
                if(row+rowOffset<0 || row+rowOffset>=a.length || col+colOffset<0 || col+colOffset>=a[0].length){
                    continue;
                }
                if(a[row][col]==1 && b[row+rowOffset][col+colOffset]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}