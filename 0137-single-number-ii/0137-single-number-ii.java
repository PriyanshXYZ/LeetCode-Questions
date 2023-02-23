class Solution {
    //more understandble solution
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
		for(int val : nums){
			int i = 0;
			while(i < 32){
				if((val & 1)>0){
					bits[i]++;
				}
				i++;
				val=val>>1;//left shifting the val
			}
		}

		int ans = 0;
		for(int i=0;i<32;i++){
			if(bits[i]%3 == 1)ans = ans | (1<<i);// making a mask for ith bit  set if it contributes 3n+1 times
		}
		return ans;
    }
}
class Solution1 {
    public int singleNumber(int[] nums) {
        int threeN = -1, threeNp1 = 0, threeNp2 = 0;
        for(int val : nums){
            int commonThreeN = val & threeN;
            int commonThreeNp1 = val & threeNp1;
            int commonThreeNp2 = val & threeNp2;
            
            threeN = threeN & (~commonThreeN);
            threeN = threeN | commonThreeNp2; // ans of 3n + 2 will contribute to 3n+3 as we have 
            
            threeNp1 = threeNp1 & (~commonThreeNp1);
            threeNp1 = threeNp1 | commonThreeN;
            
            threeNp2 = threeNp2 & (~commonThreeNp2);
            threeNp2 = threeNp2 | (commonThreeNp1);
        }
        return threeNp1;
    }
    
}