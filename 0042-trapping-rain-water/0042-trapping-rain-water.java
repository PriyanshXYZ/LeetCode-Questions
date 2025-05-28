class Solution {
    public int trap(int[] height) {
        int ans=0;
        int idx=0;
        
        Stack<Integer> stk = new Stack();
        while(idx<height.length) {
            while(!stk.isEmpty() && height[idx]>height[stk.peek()]){
                int topIdx = stk.pop();
                if(stk.isEmpty())break;
                int dist = idx - stk.peek() - 1;
                int ht = Math.min(height[idx],height[stk.peek()])-height[topIdx];
                ans += dist*ht;
            }
            stk.push(idx++);
        }
        return ans;
    }
}
class Solution1 {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                leftMax[i]=height[i];
            }else{
                leftMax[i]=Math.max(height[i],leftMax[i-1]);
            }
        }
        
        int[] rightMax=new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1)
                rightMax[i]=height[i];
            else
                rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        
        int stored=0;
        for(int i=0;i<n;i++){
            int water=Math.min(leftMax[i],rightMax[i])-height[i];
            stored+=water;
        }
        return stored;
    }
}