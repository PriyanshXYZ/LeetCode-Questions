class Solution {
    public void swap(char[] a,int i,int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(left<right){
            swap(s,left,right);
            left++;
            right--;
        }
    }
}