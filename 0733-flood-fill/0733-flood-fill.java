class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        dfs(sr, sc, n, m, color, image[sr][sc], image, new boolean[n][m]);
        return image;
    }
    private void dfs(int sr, int sc, int n, int m, int color, int originalColor, int[][] image, boolean[][] visited) {
        //base case 
        if(sr<0 || sc<0 || sr>=n || sc>=m || visited[sr][sc])return;

        if(originalColor==image[sr][sc]){
            image[sr][sc] = color;
            visited[sr][sc] = true;
            //horizontal movement up and down
            dfs(sr + 1, sc, n, m, color, originalColor, image, visited);
            dfs(sr - 1, sc, n, m, color, originalColor, image, visited);
            //vertical movement left and right
            dfs(sr, sc + 1, n, m, color, originalColor, image, visited);
            dfs(sr, sc - 1, n, m, color, originalColor, image ,visited);
        }
    }
}