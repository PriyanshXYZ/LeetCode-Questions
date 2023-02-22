class Solution {
    public int singleNumber(int[] nums) {
        int threeN = -1, threeNp1 = 0, threeNp2 = 0;
        for(int val : nums){
            int commonThreeN = val & threeN;
            int commonThreeNp1 = val & threeNp1;
            int commonThreeNp2 = val & threeNp2;
            
            threeN = threeN & (~commonThreeN);
            threeN = threeN | commonThreeNp2;
            
            threeNp1 = threeNp1 & (~commonThreeNp1);
            threeNp1 = threeNp1 | commonThreeN;
            
            threeNp2 = threeNp2 & (~commonThreeNp2);
            threeNp2 = threeNp2 | (commonThreeNp1);
        }
        return threeNp1;
    }
}