class NumArray {
    class Node{
        int strt,end;
        Node left,right;
        int val;
    }
    
    Node root;
    Node construct(int[] nums,int lo,int hi){
        if(lo==hi){
            //code
            Node node=new Node();
            node.strt=node.end=lo;
            node.left=node.right=null;
            node.val=nums[lo];
            return node;
        }
        
        Node node=new Node();
        node.strt=lo;
        node.end=hi;
        
        int mid=(lo+hi)/2;
        
        node.left=construct(nums,lo,mid);
        node.right=construct(nums,mid+1,hi);
        
        node.val=node.left.val+node.right.val;
        
        return node;
    }
    public NumArray(int[] nums) {
        root=construct(nums,0,nums.length-1);
    }
    
    void update(Node node,int idx,int val){
        if(node.strt==node.end){
            node.val=val;
            return;
        }
        
        int mid=(node.strt+node.end)/2;
        if(idx<=mid){
            update(node.left,idx,val);
        }else{
            update(node.right,idx,val);
        }
      
        node.val=node.left.val+node.right.val;
        
    }
    
    public void update(int index, int val) {
        update(root,index,val);
    }
    
    int sumRange(Node node,int left,int right){
        if(node.end<left || node.strt>right){
            return 0;
        }else if(left<=node.strt && right>=node.end){
            return node.val;
        }else{
            int leftSum=sumRange(node.left,left,right);
            int rightSum=sumRange(node.right,left,right);
            return leftSum+rightSum;
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */