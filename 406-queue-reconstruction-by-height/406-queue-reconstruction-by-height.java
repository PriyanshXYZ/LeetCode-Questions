class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people,new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }else{
                    return b[0]-a[0];
                }
            }
        });
        
        //insertion sort
        for(int i=0;i<people.length;i++){
            int count=0;
            for(int j=0;j<i;j++){
                if(people[j][0]>=people[i][0])count++;
                if(count>people[i][1]){
                    swap(people,i,j);
                    break;
                }
            }
        }
        return people;
    }
    public void swap(int[][] a,int i,int j){
        int[] temp=a[i];
        
        for(int k=i;k>j;k--){
            a[k]=a[k-1];
        }
        a[j]=temp;
    }
}