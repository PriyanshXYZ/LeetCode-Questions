class Solution {
    class Pair{
        int s;
        int e;
        
        Pair(int s,int e){
            this.s=s;
            this.e=e;
        }
        public String toString(){
            return "s=>"+s+" e=>"+e;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Pair[] prfmnce=new Pair[n];
        for(int i=0;i<n;i++){
            int s=speed[i];
            int e=efficiency[i];
            Pair p=new Pair(s,e);
            prfmnce[i]=p;
        }
        Arrays.sort(prfmnce,(a,b)->{
            return b.e-a.e;
        });
        
        
        long res=0;
        long total=0;
        for(int i=0;i<n;i++){
            if(pq.size()==k) total-=pq.remove();
            Pair p=prfmnce[i];
            total+=p.s;
            int minE=p.e;
            res=Math.max(total*minE,res);
            pq.add(p.s);
        }
        int mod=(int)(1e9+7);
        return (int)(res%mod);
    }
}