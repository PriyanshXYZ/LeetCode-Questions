class Solution {
    class Pair implements Comparable<Pair>{
        int plnt;
        int grow;
        
        Pair(int plnt,int grow){
            this.plnt=plnt;
            this.grow=grow;
        }
        
        @Override
        public int compareTo(Pair o){
            return this.grow-o.grow;
        }
        
        public String toString(){
            return plnt+" "+grow;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Pair[] time=new Pair[plantTime.length];
        
        for(int i=0;i<time.length;i++){
            Pair p=new Pair(plantTime[i],growTime[i]);
            time[i]=p;
        }
        Arrays.sort(time);
        int ans=0;
        for(int i=0;i<time.length;i++){
            ans=Math.max(time[i].grow,ans)+time[i].plnt;
        }
        return ans;
    }
}