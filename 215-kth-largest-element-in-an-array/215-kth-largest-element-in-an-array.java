class Solution {
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        int lo=0;
        int hi=nums.length-1;
        return quickSelect(nums,lo,hi,k);
        
    }
    public int quickSelect(int[] a,int lo,int hi,int k){
        if(lo==hi) return a[lo];
        int pivotIdx=partition(a,a[hi],lo,hi);
        System.out.println(pivotIdx);
        if(pivotIdx==k){
            return a[pivotIdx];
        }else if(pivotIdx<k){
            return quickSelect(a,pivotIdx+1,hi,k);
        }
        return quickSelect(a,lo,pivotIdx-1,k);
    }
    public int partition(int[] a,int pivot,int lo,int hi){
        int i=lo,j=lo;
        while(j<=hi){
            if(a[j]<=pivot){
                swap(a,i,j);
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i-1;
    }
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
class Solution1 {
    //tc o(nlogn)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        int idx=0;
        while(k>0){
            pq.add(nums[idx]);
            idx++;
            k--;
        }
        
        while(idx<nums.length){
            if(pq.peek()<nums[idx]){
                pq.remove();
                pq.add(nums[idx]);
            }
            idx++;
        }
        return pq.peek();
    }
}