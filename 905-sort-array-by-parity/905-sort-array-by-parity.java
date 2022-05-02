class Solution {
    public void swap(int i,int j,int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    //O(n^2)
    // public int[] sortArrayByParity(int[] a) {
    //     for(int i=0;i<a.length;i++){
    //         for(int j=i+1;j<a.length;j++){
    //             if(a[i]%2!=0 && a[j]%2==0){
    //                 swap(i,j,a);
    //             }
    //         }
    //     }
    //     return a;
    // }
    public int[] sortArrayByParity(int[] a) {
        //o(n)
        int left=0,right=a.length-1;
        while(left<right){
            //left even 
            if(a[left]%2==0){
                
                left++;
            }//left odd
            else{
                //right even
                if(a[right]%2==0){
                    swap(left,right,a);
                    left++;
                    right--;
                }else{
                    right--;
                }
            }
        }
        return a;
    }
}