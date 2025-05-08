package Models;

import java.util.HashMap;
import java.util.Map;

public class Redis<K, V> {
    Map<K, V>map;

    public Redis() {
        map = new HashMap<>();
    }

    public void setKey(K key, V value) {
        map.put(key, value);
    }

    public V getValue(K key) {
        return map.get(key);
    }

    public void remove (K key) {
        map.remove(key);
    }
}
