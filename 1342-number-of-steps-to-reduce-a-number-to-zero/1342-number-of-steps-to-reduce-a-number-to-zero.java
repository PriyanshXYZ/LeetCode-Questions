
class Solution1{
    //TC O(1)
     public int numberOfSteps(int num){
         if(num==0)return 0;
         int res=0;
         while(num!=0){
             res+=(num&1)==1?2:1;
             num=num>>1;
         }
         return res-1;
     }
}
class Solution {
    //time complexity O(n);
    public int numberOfSteps(int num) {
        if(num==0)return 0;
        int count=0;
        while(num!=1){
            if(num%2==0){
                count++;
                num=num/2;
            }else{
                count++;
                num=num-1;
            }
        }
        return count+1;
    }
}