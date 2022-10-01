class Solution {
    public int nextGreaterElement(int n) {
        String s=Integer.toString(n);
        char[] a=s.toCharArray();
        int i=a.length-1;
        //to check smallest non increasing element from right
        while(i>0){
            if(a[i-1]>=a[i]){
                i--;
            }else{
                break;
            }
        }
        if(i==0)return -1;
        
        int idx=i-1;
        int j=a.length-1;
        while(j>idx){
            if(a[j]>a[idx]){
                break;
            }else{
                j--;
            }
        }
        
        swap(a,i-1,j);//i-1 because  we were checking for idx-1 val
        
        reverse(a,i,a.length-1);
        
        String ans=String.valueOf(a);
        long res=Long.parseLong(ans);
        if(res>Integer.MAX_VALUE){
            return -1;
        }
        return (int)res;
    }
    void reverse(char[] a,int i,int j){
        while(i<j){
            swap(a,i,j);
            i++;
            j--;
        }
    }
    void swap(char[] a,int i,int j){
        char temp=a[i];
            a[i]=a[j];
            a[j]=temp;
    }
}