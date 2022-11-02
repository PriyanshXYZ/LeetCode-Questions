class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int count=0;
        Queue<String> q=new ArrayDeque();
        HashSet<String> set=new HashSet();
        set.add(start);
        q.add(start);
        
        while(q.size()!=0){
            int sz=q.size();
            while(sz-- >0){
                String rem=q.remove();
                if(rem.equals(end))return count;
                for(char ch:new char[]{'A','T','C','G'}){
                    for(int i=0;i<rem.length();i++){
                        String alter=rem.substring(0,i)+ch+rem.substring(i+1);
                        if(Arrays.asList(bank).contains(alter) && !set.contains(alter)){
                            q.add(alter);
                            set.add(alter);
                        }
                    }
                }    
            }
            count++;
        }
        return -1;
    }
}