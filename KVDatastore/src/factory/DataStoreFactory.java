package factory;

import core.KeyValueStore;
import core.RedisKVStore;
import core.SimpleKVStore;

public class DataStoreFactory {
    public enum DataStoreType {
        IN_MEMORY,
        REDIS
    }

    public static KeyValueStore getDataStore(DataStoreType dataStoreType) {
        return switch (dataStoreType) {
            case REDIS -> new RedisKVStore();
            case IN_MEMORY -> new SimpleKVStore();
        };
    }
}
