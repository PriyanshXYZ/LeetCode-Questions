class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] frequencyArr = new int[128];   
            for(int i = 0;i<s.length();i++){
                frequencyArr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
        }
        // System.out.println(map);
        return new LinkedList<>(map.values());
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        if(strs.length==1){
            List<List<String>> res=new ArrayList();
            res.add(new ArrayList());
            res.get(0).add(strs[0]);
            return res;
        }
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
