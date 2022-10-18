class Solution {
    List<Integer> nums;
    Integer[][][] dp;// pos => place value count=> 1's count tight => 0->no 1->yes

    public int countDigitOne(int n) {
        nums=new ArrayList();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        dp=new Integer[10][10][2];
        
        Collections.reverse(nums);
        return digitdp(0,0,1);        
    }
    public int digitdp(int pos,int count,int tight){
        if(pos==nums.size())return count;
        
        if(dp[pos][count][tight]!=null){
            return dp[pos][count][tight];
        }
        
        int ans=0;
        int limit=tight==1?nums.get(pos):9;
        
        for(int val=0;val<=limit;val++){
            int newCnt=val==1?count+1:count;
        
            boolean newTight=tight==1 && val==limit;//if state is 
            ans+=digitdp(pos+1,newCnt ,newTight?1:0);
        }
        return dp[pos][count][tight]=ans;
    }
}