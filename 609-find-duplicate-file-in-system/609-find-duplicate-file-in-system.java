class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> map=new HashMap();
        for(String str:paths){
            String[] a=str.split(" ");
            for(int i=1;i<a.length;i++){
                String s=a[i].substring(a[i].indexOf("(")+1,a[i].length()-1);
                if(!map.containsKey(s)){
                    map.put(s,new ArrayList());
                }
                map.get(s).add(a[0]+"/"+a[i].substring(0,a[i].indexOf("(")));
            }
        }
        List<List<String>> ans=new ArrayList();
        for(String key:map.keySet()){
            if(map.get(key).size()>1)
                ans.add(map.get(key));
        }
        return ans;
        
    }
}