class Solution {
    public void swap(int i,int j,int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public int[] sortArrayByParity(int[] a) {
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]%2!=0 && a[j]%2==0){
                    swap(i,j,a);
                }
            }
        }
        return a;
    }
}