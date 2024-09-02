class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int c : chalk) {
            sum += c;
        }
        
        long val = k % sum;
        
        for(int i=0;i<chalk.length;i++){
            if(val<chalk[i]){
                return i;
            }else{
                val-=chalk[i];
            }
        }
        return 0;
    }
}