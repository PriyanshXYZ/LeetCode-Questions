class Solution {
    class Pair implements Comparable<Pair>{
        int profit;
        int capital;
        
        Pair(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
        
        public int compareTo(Pair o){
            return this.capital-o.capital;
        }
        
        public String toString(){
            return this.capital+" "+this.profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Pair[] projects = new Pair[profits.length];
        int n = projects.length;
        for(int i=0;i<n;i++){
            Pair p = new Pair(profits[i],capital[i]);
            projects[i] = p;
        }
        
        Arrays.sort(projects);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//here pair wont work as we want to get maxprofit
        int ptr = 0;
        for(int i = 0; i < k; i++){
            while(ptr < n && projects[ptr].capital<=w){
                pq.add(projects[ptr].profit);
                ptr++;
            }
            if(pq.size()==0)break;
            
            w += pq.remove();
        }
        return w;
    }
}