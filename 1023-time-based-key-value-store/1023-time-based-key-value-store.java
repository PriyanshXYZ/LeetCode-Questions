class TimeMap {
    Map<String,TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new TreeMap());
        }
        timeMap.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(timeMap.containsKey(key)){
            var possibleEntry = timeMap.get(key).floorEntry(timestamp);
            if(possibleEntry!=null)return possibleEntry.getValue();
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