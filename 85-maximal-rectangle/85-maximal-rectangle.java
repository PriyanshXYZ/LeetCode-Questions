class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] dp=new int[matrix[0].length];
        int m=matrix[0].length;
        int n =matrix.length;
        
        for(int i=0;i<m;i++){
            dp[i]=matrix[0][i]-'0';
            
        }
                
        int maxArea=calculateMax(dp);
        
        int idx=1;
        while(idx<matrix.length){
            char[] temp=matrix[idx];
            for(int i=0;i<m;i++){
                if(temp[i]=='1'){
                    dp[i]+=(temp[i]-'0');
                }else{
                    dp[i]=0;
                }
                
            }
            
            int currArea=calculateMax(dp);
            maxArea=Math.max(currArea,maxArea);
            idx++;
        }
        return maxArea;
    }
    public int calculateMax(int[] ht){
        int n=ht.length;
        int maxArea=0;
        
        int[] sl=nsl(ht);
        int[] sr=nsr(ht);
        
        
        for(int i=0;i<n;i++){
            int currArea=ht[i]*(sr[i]-sl[i]-1);
            maxArea=Math.max(currArea,maxArea);
        }
        return maxArea;
    }
    
    public int[] nsl(int[] ht){
        int[] res=new int[ht.length];
        int n=ht.length;
        Stack<Integer> stk=new Stack();
        
        for(int i=0;i<n;i++){
            while(stk.size()>0 && ht[i]<=ht[stk.peek()]){
                stk.pop();
            }
            if(stk.size()==0){
                res[i]=-1;
            }else{
                res[i]=stk.peek();
            }
            stk.push(i);
        }
        return res;
    }
    
    public int[] nsr(int[] ht){
        int[] res=new int[ht.length];
        int n=ht.length;
        Stack<Integer> stk=new Stack();
        
        for(int i=n-1;i>=0;i--){
            while(stk.size()>0 && ht[i]<=ht[stk.peek()]){
                stk.pop();
            }
            if(stk.size()==0){
                res[i]=ht.length;
            }else{
                res[i]=stk.peek();
            }
            stk.push(i);
        }
        return res;
    }
}