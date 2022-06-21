class Solution {
    //kahn's algorithm
    public int[] findOrder(int numCourses, int[][] a) {
        //reverse topological 
        List<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++){
            graph[i]=(new ArrayList());
        }
        //creating a graph...
        for(int[] req:a){
            graph[req[0]].add(req[1]);
        }
        
        Queue<Integer> q=new ArrayDeque();
        
        //getting the in degree of the vtces of the graph
        int[] inDeg=new int[numCourses];
        for(int i=0;i<graph.length;i++){
            for(int nbr:graph[i]){
                inDeg[nbr]++;
            }
        }
        
        //adding vtces which are not dependancy
        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }
        
        int[] arr=new int[numCourses];
        int idx=numCourses-1;
        while(!q.isEmpty()){
            int rem=q.remove();
            arr[idx--]=rem;
            
            for(int nbr:graph[rem]){
                if(inDeg[nbr]>0){
                    inDeg[nbr]--;
                }
                if(inDeg[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        
        if(idx==-1)return arr;
        else return new int[]{};
    }
}