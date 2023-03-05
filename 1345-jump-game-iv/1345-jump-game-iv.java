class Solution {
    public int minJumps(int[] arr) {
        
        HashMap<Integer,List<Integer>> valToIdxMap = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(!valToIdxMap.containsKey(arr[i]))
                valToIdxMap.put(arr[i],new ArrayList<>());
            
            valToIdxMap.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        
        int steps = 0;
        
        while(q.size()>0){
            int size = q.size();
            while(size-- > 0){
                int idx = q.remove();
                
                if(idx==n-1)return steps;
                
                if(idx-1>=0 && valToIdxMap.containsKey(arr[idx-1])){
                    q.add(idx-1);
                }
                
                if(idx+1<n && valToIdxMap.containsKey(arr[idx+1])){
                    q.add(idx+1);
                }
                
                if(valToIdxMap.containsKey(arr[idx])){
                    for(int nbr : valToIdxMap.get(arr[idx])){
                        if(nbr!=idx){
                            q.add(nbr);    
                        }    
                    }
                }
                    
                valToIdxMap.remove(arr[idx]);
            }
            steps++;
        }
        return -1;
    }
    
}