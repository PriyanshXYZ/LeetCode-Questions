class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distFromNode1 = new int[n];
        int[] distFromNode2 = new int[n];
        Arrays.fill(distFromNode1, Integer.MAX_VALUE);
        Arrays.fill(distFromNode2, Integer.MAX_VALUE);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(node1);
        int distCounter = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            if(distFromNode1[node]!=Integer.MAX_VALUE)continue;
            distFromNode1[node]=distCounter;
            if(edges[node]!=-1){
                q.add(edges[node]);
            }
            
            distCounter++;
        }
        distCounter=0;
        q.add(node2);
        while(!q.isEmpty()) {
            int node = q.remove();
            if(distFromNode2[node]!=Integer.MAX_VALUE)continue;
            distFromNode2[node]=distCounter;
            if(edges[node]!=-1){
                q.add(edges[node]);
            }
            
            distCounter++;
        }

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<n;i++) {
            int max = Math.max(distFromNode2[i], distFromNode1[i]);
            if(max<min){
                min = max;
                idx = i;
            }
        }
        return idx;
    }
}