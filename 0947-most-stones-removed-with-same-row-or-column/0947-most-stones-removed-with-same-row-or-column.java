class Solution {
    static class Uf{
        int left;
        int[] parent;
        int[] size;

        Uf(int n) {
            this.left = n;
            this.parent = new int[n];
            this.size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x] == x)return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int leadX = find(x);
            int leadY = find(y);

            if(leadX!=leadY) {
                if(size[leadX] >= size[leadY]){
                    size[leadX] += size[leadY];
                    parent[leadY] = leadX;
                }else {
                    size[leadY] += size[leadX];
                    parent[leadX] = leadY;
                }
                left--;
            }
        }

        public int connectedComponents(){
            return left;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Uf uf = new Uf(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j)continue;
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    uf.union(i,j);
            }
        }

        return n - uf.connectedComponents();
    }
}