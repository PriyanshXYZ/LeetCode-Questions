class Solution {
    public String sortSentence(String s) {
        String[] words=s.split(" ");
        HashMap<Integer,String> map=new HashMap();
        for(int i=0;i<words.length;i++){
            map.put(words[i].charAt(words[i].length()-1)-'0',words[i]);
        }
        System.out.println(map);
        StringBuilder sb=new StringBuilder();
        for(int pos:map.keySet()){
            sb.append(map.get(pos).substring(0,map.get(pos).length()-1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}