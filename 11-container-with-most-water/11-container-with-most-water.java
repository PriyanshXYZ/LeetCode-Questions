class Solution {
    public int maxArea(int[] height) {
        return optimized(height);
    }
    public int brute(int[] height){
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int area=Math.min(height[i],height[j])*(j-i);
                max=Math.max(max,area);
            }
        }
        return max;
    }
    public int optimized(int[] height){
        int left=0;
        int right=height.length-1;
        int max=Math.min(height[left],height[right])*(right-left);
        while(left<right){
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            int area=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,area);
        }
        return max;
    }
}