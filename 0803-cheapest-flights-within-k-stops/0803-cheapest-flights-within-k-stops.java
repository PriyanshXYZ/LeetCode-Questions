class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph  = new ArrayList();
        for(int i = 0; i < n ; i++) graph.add(new ArrayList<>());
        //create the graph
        for(int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[]{to, price});
        }

        //try to find solution within k stops approach is dfs
        int[] priceforKStops = new int[n];

        Arrays.fill(priceforKStops,Integer.MAX_VALUE);
        priceforKStops[src] = 0;
        Queue<int[]> bfsQ = new ArrayDeque();
        bfsQ.add(new int[]{src,0,0});

        while(!bfsQ.isEmpty()) {
            int[] peek = bfsQ.remove();
            int place = peek[0];
            int price = peek[1];
            int stop = peek[2];
            if(stop>k)continue;

            for(int[] nbr : graph.get(place)) {
                int nextPlace = nbr[0];
                int nextPrice = nbr[1]; // Correct: nextPrice is the edge weight
                int newCost = price + nextPrice; // Calculate the new accumulated cost

                if (newCost <= priceforKStops[nextPlace]) {
                    priceforKStops[nextPlace] = newCost;
                    bfsQ.add(new int[]{nextPlace, newCost, stop + 1});
                }
            }
        }
    
        return priceforKStops[dst]==Integer.MAX_VALUE?-1:priceforKStops[dst];
    }
}