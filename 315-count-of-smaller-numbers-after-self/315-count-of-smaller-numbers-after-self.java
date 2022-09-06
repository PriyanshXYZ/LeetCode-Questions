class Solution {
    Integer[] res;
    class Pair{
        int val;
        int idx;
        
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        //Priyansh Ragit is the best
        res=new Integer[nums.length];
        Arrays.fill(res,0);
        
        Pair[] a=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            Pair p=new Pair(nums[i],i);
            a[i]=p;
        }
        mergeSort(0,a.length-1,a);
        return Arrays.asList(res);
    }
    
    public Pair[] mergeSort(int lo,int hi,Pair[] a){
        if(lo == hi){
            Pair[] barr = new Pair[1];
            barr[0] = new Pair(a[lo].val, a[lo].idx);
            return barr;
        }
        
        int mid=(lo+hi)/2;
        Pair[] left=mergeSort(lo,mid,a);
        Pair[] right=mergeSort(mid+1,hi,a);
        
        return merge(left,right);
    }
    
    public Pair[] merge(Pair[] left,Pair[] right){
        
        Pair[] ans=new Pair[left.length+right.length];
        
        int i=0,j=0;
        int idx=0;
        while(i < left.length && j < right.length){
            if(left[i].val > right[j].val){
                res[left[i].idx]+=(right.length-j);
                ans[idx]=left[i];
                idx++;
                i++;
                
            }else{
                
                ans[idx]=right[j];
                idx++;
                j++;
                
            }
        }
        while(i<left.length){
            ans[idx++]=left[i++];
        }
        
        while(j<right.length){
            ans[idx++]=right[j++];
        }
        return ans;
    }
}