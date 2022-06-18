class WordFilter {
    Map<String,Integer> map;
    public WordFilter(String[] words) {
        map=new HashMap();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String prefix=words[i].substring(0,j);
                for(int k=0;k<words[i].length();k++){
                    String suffix=words[i].substring(k,words[i].length());
                    map.put(prefix+"#"+suffix,i+1);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String s=prefix+"#"+suffix;
        return map.getOrDefault(s,0)-1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */