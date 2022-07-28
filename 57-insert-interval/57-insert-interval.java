class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list=new ArrayList();
        
        for(int i=0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        list.add(newInterval);
        
        Collections.sort(list,(a,b)->{
           return a[0]-b[0]; 
        });
        
        ArrayList<int[]> ans=new ArrayList();
        for(int i=0;i<list.size();i++){
            if(i==0){
                ans.add(list.get(i));
            }else{
                int[] top=ans.get(ans.size()-1);
                if(top[1]>=list.get(i)[0]){
                    top[1]=Math.max(list.get(i)[1],top[1]);// remeber interval can also be [1,4][2,3] ..hence math.max
                }else{
                    ans.add(list.get(i));
                }
            }
        }
        int[][] res=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}