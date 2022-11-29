class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> l;
    Random r;
    public RandomizedSet() {
        map=new HashMap();
        l=new ArrayList();
        r=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        map.put(val,l.size());
        l.add(val);
        return true;
    }
    private void swap(int i,int j){
        int val1=l.get(i);
        int val2=l.get(j);
        l.set(i,val2);
        l.set(j,val1);
        
        map.put(val1,j);
        map.put(val2,i);
    }
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx=map.get(val);
            
            swap(idx,l.size()-1);
            l.remove(l.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int idx=r.nextInt(l.size());
        return l.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */