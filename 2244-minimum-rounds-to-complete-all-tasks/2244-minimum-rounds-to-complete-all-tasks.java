class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }

        int minRounds = 0;
        for(int value : map.values()){
            if(value==1)return -1;
            if(value %3 == 0){
                minRounds += value/3;
                
            }else{
                minRounds += value/3 + 1; //remainder can be 1 or 2
                //for 1 take example 7 so we made group of 3 3 1 (invalid) which can be done as 3 2 2 
                //for 2 take example 8 we can directly add 1 of 2 task.
            }
            
           
        }
        return minRounds;
    }
   
}