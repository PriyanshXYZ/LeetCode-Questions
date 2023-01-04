class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        
        int minRounds = 0;
        for(int i =0;i<tasks.length;){
            int j = i+1;
            while(j<tasks.length && tasks[j]==tasks[i])j++;
            
            int value = j-i;
            if(value == 1)return -1;
            if(value % 3 ==0){
                minRounds += value/3;
            }else if(value % 3 == 1){
                minRounds += ((value - 4) / 3) + (4 / 2);//2 group of 2 tasks
            }else{
                minRounds += ((value - 2) / 3) + (2 / 2);
            }
            i=j;
        }
        return minRounds;
    }
}
class Solution1 {
    //O{n} time and space
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }

        int minRounds = 0;
        for(int value : map.values()){
            if(value==1)return -1;
            if(value %3 == 0){
                minRounds += value/3;
                
            }else if(value%3 == 2){
                //for 2 take example 8 we can directly add 1 of 2 task.
                minRounds += value/3 + 1; //remainder can be 1 or 2
            }else{
                //for 1 take example 7 so we made group of 3 3 1 (invalid) which can be done as 3 2 2 
                // so value/3 -1 => reducing last 3 task group into  2 task group twice (3 2 2)
                minRounds += (value/3-1)+2;
            }
        }
        return minRounds;
    }
   
}