class TimeMap {
    HashMap<String,TreeMap<Integer,String>> m;
    public TimeMap() {
        m=new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!m.containsKey(key)){
            m.put(key,new TreeMap());
        }
        // HashMap<Integer,String> timeMap=new HashMap();
        // timeMap.put(timestamp,value);
        m.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(m.containsKey(key)){
            TreeMap<Integer,String> timeMap=m.get(key);
            if(timeMap.containsKey(timestamp)){
                return timeMap.get(timestamp);
            }else{
                Integer idx=timeMap.floorKey(timestamp);
                if(idx==null)return "";
                return timeMap.get(idx);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */