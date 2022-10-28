class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap();
        
        for(String str:strs){
            char[] a=str.toCharArray();
            Arrays.sort(a);
            String s="";
            for(char ch:a){
                s+=ch;
            }
            
            if(!map.containsKey(s)){
                map.put(s,new ArrayList());
            }
            map.get(s).add(str);
        }
        // System.out.println(map);
        
        List<List<String>> res=new ArrayList();
        for(List<String> val:map.values()){
            res.add(val);
        }
        return res;
    }
}