class Solution {
    public int numberOfWays(String corridor) {
        //if no of seats are odd then it is not possible to divide then we need to return 0
        int n = corridor.length();
        int seats = 0;
        for(char ch : corridor.toCharArray()){
            seats += ((ch == 'S')?1:0);
        }
        
        if(seats ==0 || seats%2!=0)return 0;
        
        long mod = (long)(1e9+7);
        long res = 1;
        seats = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            char ch = corridor.charAt(i);
            if(ch == 'S'){
                seats++;
                if(seats>2 && seats%2==1){
                    res = res % mod;
                    res = res*(i-j);
                }else if(seats%2==0){
                    j = i;
                }
            }
        }
        return (int)(res%mod);
    }
}