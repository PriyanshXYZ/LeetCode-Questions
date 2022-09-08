class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] sl=nsl(heights);
        int[] sr=nsr(heights);
        
        int n=heights.length;
        
//         for(int i=0;i<n;i++){
//             System.out.print(sl[i]+" ");
//         }
//         System.out.println();
        
//         for(int i=0;i<n;i++){
//             System.out.print(sr[i]+" ");
//         }
//         System.out.println();
        
        int area=0;
        for(int i=0;i<heights.length;i++){
            int currArea=heights[i]*(sr[i]-sl[i]-1);
            area=Math.max(currArea,area);
        }
        return area;
    }
    public int[] nsl(int[] a){
        int n=a.length;
        int[] res=new int[n];
        
        Stack<Integer> stk=new Stack();
        for(int i=0;i<n;i++){
            while(stk.size()>0 && a[stk.peek()]>=a[i]){
                stk.pop();
            }
            if(stk.size()==0)res[i]=-1;
            else res[i]=stk.peek();
            
            stk.push(i);
        }
        return res;
    }
    
    public int[] nsr(int[] a){
        int n=a.length;
        int[] res=new int[n];
        
        Stack<Integer> stk=new Stack();
        for(int i=n-1;i>=0;i--){
            while(stk.size()>0 && a[stk.peek()]>=a[i]){
                stk.pop();
            }
            if(stk.size()==0)res[i]=n;
            else res[i]=stk.peek();
            
            stk.push(i);
        }
        return res;
    }
}