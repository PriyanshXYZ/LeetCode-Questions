class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] mat=new int[matrix.length*matrix[0].length];
        int row=0;
        int col=0;
        for(int i=0;i<mat.length;i++){
            if(col<matrix[0].length){
                mat[i]=matrix[row][col];
                
            }else{
                col=0;
                row++;
                mat[i]=matrix[row][col];
            }
            col++;
        }
        // print(mat);
        return binarySearch(mat,target,0,mat.length);
    }
    public void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public boolean binarySearch(int[] mat,int target,int start,int end){
        if(mat.length==1 ){
            if(mat[0]==target)return true;
            else return false;
        } 
        int mid=start+(end-start)/2;
        while(start<=end && mid<mat.length){
            // System.out.println(mid);
            if(mat[mid]==target){
                return true;
            }else if(mat[mid]<target){
                start=mid+1;
                mid=start+(end-start)/2;
            }else{
                end=mid-1;
                mid=start+(end-start)/2;
            }
        }
        return false;
    }
}