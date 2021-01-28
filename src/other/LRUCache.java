package other;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>{


    private final int capacity;


    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }

    public LRUCache(int capacity) {
        //default constructor called for LinkedHashMap if nothing done
        super(capacity, 0.75F, true);
       this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key,-1);
    }


    public void put(int key, int value) {
        super.put(key,value);
    }
}

