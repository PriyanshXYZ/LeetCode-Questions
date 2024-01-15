class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> lose = new HashMap<>();
        Map<Integer,Integer> win = new HashMap<>();
        
        for(int[] match : matches){
            win.put(match[0],win.getOrDefault(match[0],0)+1);
            lose.put(match[1],lose.getOrDefault(match[1],0)+1);
        }
        // System.out.println(win);
        // System.out.println(lose);
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for(int key : win.keySet()){
            if(!lose.containsKey(key))res.get(0).add(key);
        }
        for(int key : lose.keySet()){
            if(lose.get(key) == 1)res.get(1).add(key);
        }
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}