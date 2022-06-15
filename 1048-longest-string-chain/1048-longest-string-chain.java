class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        });
        
        HashMap<String,Integer> map=new HashMap();
        
        for(String word:words){
            map.put(word,1);    
        }
        
        int maxChain=0;
        for(String word:words){
            StringBuilder sb=new StringBuilder(word);
            for(int i=0;i<word.length();i++){
                char t=sb.charAt(i);
                sb=sb.deleteCharAt(i);
                String str=sb.toString();
                if(map.containsKey(str)){
                    map.put(word,Math.max(map.get(str)+1,map.get(word)));
                }
                sb.insert(i,t);
            }
            maxChain=Math.max(map.get(word),maxChain);
        }
        System.out.println(map);
        return maxChain;
    }
}