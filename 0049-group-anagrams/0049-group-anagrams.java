class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap();
        
        for(String str:strs){
            char[] a=str.toCharArray();
            Arrays.sort(a);
            String srt="";
            for(char c:a)srt+=c;
            if(map.containsKey(srt)){
                map.get(srt).add(str);
            }else{
                map.put(srt,new ArrayList());
                map.get(srt).add(str);
            }
        }
        // System.out.println(map);
        List<List<String>> res=new ArrayList();
        for(List<String> val:map.values()){
            res.add(val);
        }
        return res;
    }
}