class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public void swap(int i, int j){
        int elem = list.get(i);
        list.set(i,list.get(j));
        list.set(j,elem);
        
        map.put(list.get(i), i);
        map.put(list.get(j), j);
    }
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            swap(idx, list.size()-1);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */