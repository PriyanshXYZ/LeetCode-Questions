class Solution {
    class CPU implements Comparable<CPU>{
        int idx;
        int enq;
        int process;
        
        CPU(int idx, int enq, int process){
            this.idx = idx;
            this.enq = enq;
            this.process = process;
        }
        public int compareTo(CPU o){
            if(this.process!=o.process){
                return this.process - o.process;
            }else{
                return this.idx - o.idx;
            }
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<CPU> pq = new PriorityQueue();
        int[][] sortedTask = new int[tasks.length][3];
        
        int idx=0;
        for(int[] task : tasks){
            sortedTask[idx][0] = idx;
            sortedTask[idx][1] = task[0];
            sortedTask[idx][2] = task[1];
            idx++;
        }
        Arrays.sort(sortedTask,(a,b)->(a[1]-b[1]));
        
        int ansIdx=0;
        int[] res = new int[tasks.length];
        idx = 0;
        long time=0l;
        while(ansIdx < tasks.length){
            while(idx<tasks.length && time >= sortedTask[idx][1]){
                int[] currThread = sortedTask[idx];
                pq.add(new CPU(currThread[0], currThread[1], currThread[2]));
                idx++;
            }
            if(pq.isEmpty()){
                time = sortedTask[idx][1];
                continue;
            }
            CPU bestThread = pq.remove();
            res[ansIdx++] = bestThread.idx;
            time += bestThread.process;
        }
        return res;
    }
}