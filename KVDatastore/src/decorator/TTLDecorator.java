package decorator;

import Models.KeyWithExpiry;
import core.KeyValueStore;
import core.SupportTTL;

import java.util.HashMap;

public class TTLDecorator implements KeyValueStore, SupportTTL {

    KeyValueStore keyValueStore;
    HashMap<String, KeyWithExpiry>ttlMap;

    public TTLDecorator(KeyValueStore keyValueStore) {
        this.keyValueStore = keyValueStore;
        ttlMap = new HashMap<>();
    }

    @Override
    public String get(String key) {
        if (ttlMap.containsKey(key) && ttlMap.get(key).isExpired()) {
            ttlMap.remove(key);
            keyValueStore.delete(key);
            return null;
        }
        return keyValueStore.get(key);
    }

    @Override
    public void set(String key, String value) {
        set(key, value, 100000);
    }

    @Override
    public void set(String key, String value, long ttlMillis) {
        ttlMap.put(key, new KeyWithExpiry(ttlMillis));
        keyValueStore.set(key, value);
    }

    @Override
    public void delete(String key) {
        if (ttlMap.containsKey(key)) ttlMap.remove(key);
        keyValueStore.delete(key);
    }
}
