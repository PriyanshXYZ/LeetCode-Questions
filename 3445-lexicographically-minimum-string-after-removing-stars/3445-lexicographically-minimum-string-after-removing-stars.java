class Solution {
    public String clearStars(String s) {
        int n = s.length();
        Stack<Integer>[] occuranceStack = new Stack[26];
        for(int i = 0; i < 26; i++) {
            occuranceStack[i] = new Stack();
        }
        char[] str = s.toCharArray();
        for(int i = 0; i < n; i++) {
            char ch = str[i];
            if(ch!='*') {
                occuranceStack[ch-'a'].add(i);
            }else{
                for(int j = 0; j < 26; j++) {
                    if(!occuranceStack[j].isEmpty()){
                        int idx = occuranceStack[j].pop();
                        str[idx]='*';
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = str[i];
            if(ch!='*') sb.append(ch);
        }
        return sb.toString();
    }
}
class Solution1 {
    //nlogn
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Integer> idxMinHeap = new PriorityQueue<>((a,b) -> s.charAt(a)==s.charAt(b)?(b-a):(s.charAt(a)-s.charAt(b)));
        Set<Integer>  toBeRemovedIdx = new HashSet();
        for(int i =0 ; i < n; i++) {
            if(s.charAt(i)!='*'){
                idxMinHeap.add(i);
            }else{
                toBeRemovedIdx.add(idxMinHeap.remove());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!toBeRemovedIdx.contains(i) && ch!='*')
                sb.append(ch);
        }
        return sb.toString();
    }
}