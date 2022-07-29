class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1=getMax(nums,firstLen,secondLen);
        int max2=getMax(nums,secondLen,firstLen);
        
        return Math.max(max1,max2);
    }
    private int getMax(int[] nums,int fl,int sl){
        int n=nums.length;
        int[] leftMax=new int[n];
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(i==fl-1){
                leftMax[i]=sum;
            }else if(i>=fl){
                sum-=nums[i-fl];
                leftMax[i]=Math.max(leftMax[i-1],sum);
            }
        }
        
        int[] rightMax=new int[n];
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            
            if(i==n-sl){
                rightMax[i]=sum;
            }else if(i<n-sl){
                sum-=nums[i+sl];
                rightMax[i]=Math.max(rightMax[i+1],sum);
            }
        }
        
        for(int i=0;i<n;i++){
            System.out.print(leftMax[i]+" ");
        }
        System.out.println();
        
        for(int i=0;i<n;i++){
            System.out.print(rightMax[i]+" ");
        }
        System.out.println();
        
        int maxSum=0;
        for(int i=fl-1;i<n-sl;i++){
            maxSum=Math.max(maxSum,leftMax[i]+rightMax[i+1]);
        }
        return maxSum;
    }
}