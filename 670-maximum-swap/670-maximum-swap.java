class Solution {
    public int maximumSwap(int num) {
        String s=num+"";
        char[] useless=s.toCharArray();
        int[] nums=new int[s.length()];
        for(int i=0;i<s.length();i++){
            nums[i]=useless[i]-'0';
        }
        int[] right=new int[s.length()];//stores idx of largest to right...
        right[s.length()-1]=-1;
        int max=nums[s.length()-1];
        for(int i=s.length()-1;i>=0;i--){
            if(i==s.length()-1){
                right[i]=-1;
            }else if(i==s.length()-2){
                right[i]=s.length()-1;
            }else{
                if(nums[i+1]>nums[right[i+1]]){
                    right[i]=i+1;
                }else{
                    right[i]=right[i+1];
                }
            }
        }
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[right[i]]){
                int temp=nums[i];
                nums[i]=nums[right[i]];
                nums[right[i]]=temp;
                break;
            }
        }
        String ans="";
        for(int i=0;i<nums.length;i++){
            ans+=nums[i];
        }
        return Integer.parseInt(ans);
    }
}