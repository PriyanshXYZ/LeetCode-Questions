class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList();
        
        HashMap<Character,Integer> map1=new HashMap();
        for(String word : words2){
            HashMap<Character,Integer> temp=new HashMap();
            for(char ch:word.toCharArray()){
                temp.put(ch,temp.getOrDefault(ch,0)+1);
            }
            for(char key: temp.keySet()){
                if(!map1.containsKey(key)){
                    map1.put(key,temp.get(key));
                }else{
                    if(map1.get(key)<temp.get(key)){
                        map1.put(key,temp.get(key));
                    }
                }
            }
        }
        
        for(String word : words1){
            
            HashMap<Character,Integer> map=new HashMap();
            for(char ch : word.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
                
            }
            
            boolean flag=true;
            for(char key : map1.keySet()){
                if(!map.containsKey(key) || map.get(key)<map1.get(key)){
                    flag=false;
                    break;
                }
            }
            if(flag)res.add(word);
        }
        return res;
    }
}