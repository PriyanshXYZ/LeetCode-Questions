// class Solution{
//     String[] words;
//     String result;
//     public boolean isSolvable(String[] words, String result) {
//         this.words = words;
//         this.result = result;
//         boolean[] used = new boolean[10];
        
//         int[] map = new int[128];
//         Set<Character> starts = new HashSet<>();
//         Set<Character> all = new HashSet<>();
//         for(String word : words) {
//             int index = 0;
//             for(char c : word.toCharArray()) {
//                 if(index == 0)
//                     starts.add(c);
//                 index++;
//                 all.add(c);
//             }
//         }
//         int index = 0;
//         for(char c : result.toCharArray()) {
//             if(index == 0 && words.length>1)
//                 starts.add(c);
//             index++;
//             all.add(c);
//         }
//         char[] arr = new char[all.size()];
//         index = 0;
//         for(char c : all)
//             arr[index++] = c;
        
//         return dfs(arr, starts, map, used, 0);
//     }
    
    
//     boolean dfs(char[] arr, Set<Character> starts, int[] map, boolean[] used, int startI) {
//         if(startI == arr.length) {
//             return calculate(map);
//         }
        
//         for(int i = 0; i < 10; i++) {
//             if(used[i])
//                 continue;
            
//             if(i == 0 && starts.contains(arr[startI]))
//                 continue;
//             map[arr[startI]] = i;
//             used[i] = true;
//             if(dfs(arr, starts, map, used, startI+1))
//                 return true;
//             used[i] = false;
//             map[arr[startI]] = 0;
//         }
class Solution {
    HashSet<Character> start;
    String[] words;
    String result;
    public boolean isValid(String[] words, String result){
        int maxLen = 0;
        for(String word : words){
            maxLen = Math.max(word.length(), maxLen);
        }
        if(maxLen + 1 < result.length() || maxLen > result.length())return false;
        return true;
    }
    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        if(!isValid(words , result))return false;
        
        Integer[] map = new Integer[26];
        HashSet<Character> set = new HashSet();
        start= new HashSet();
        for(String word : words){
            for(int i=0 ; i < word.length(); i++){
                char ch = word.charAt(i);
                if(i==0 && word.length()>1)start.add(ch);
                set.add(ch);
            }
        }
        
        for(int i = 0;i < result.length(); i++){
            char ch =result.charAt(i);
            if(i==0 && result.length() > 1)start.add(ch);
            set.add(ch);
        }
        if(set.size()>10)return false;
        char[] unique=new char[set.size()];
        int idx = 0;
        for(char ch : set){
            unique[idx++] = ch;
        }
        
        return recur(0, unique, map, new boolean[10]);
    }
    
    public boolean isEqual(Integer[] map){
        int lSum = 0, rSum = 0;
        
        for(String str : words){
            int num=0;
            for(char ch : str.toCharArray()){
                num = 10*num +map[ch-'A'];
            }
            lSum += num;
        }
        int num=0;
        for(char ch : result.toCharArray()){
            num = 10*num +map[ch-'A'];
        }
        rSum += num;
        return lSum == rSum;
    }
    public boolean recur(int idx, char[] unique, Integer[] map, boolean[] digits){
        if(idx == unique.length){
            return isEqual(map);
        }
        
        boolean ans = false;
        for(int i = 0; i <10; i++){
            char ch = unique[idx];
            if(digits[i])continue;
            if(i==0 && start.contains(ch))continue;
            digits[i]=true;
            map[ch-'A'] = i;
            if(recur(idx + 1, unique, map,digits)){
                return true;
            }
            map[ch-'A'] = null;
            digits[i]=false;
        }
        return false;
    }
}