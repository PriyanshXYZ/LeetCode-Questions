public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            System.out.println(Integer.toBinaryString(n));
            count+=n&1;
            n=n >>> 1;
        }
        return count;
    }
}