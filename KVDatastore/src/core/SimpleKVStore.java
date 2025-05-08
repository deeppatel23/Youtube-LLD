package core;

import java.util.HashMap;
import java.util.Map;

public class SimpleKVStore implements KeyValueStore{

    Map<String, String>map = new HashMap<>();

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void delete(String key) {
        if (map.containsKey(key)) map.remove(key);
    }
}
