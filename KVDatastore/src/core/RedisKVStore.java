package core;

import Models.Redis;

public class RedisKVStore implements KeyValueStore{

    Redis<String, String> redis = new Redis<>();

    @Override
    public String get(String key) {
        return redis.getValue(key);
    }

    @Override
    public void set(String key, String value) {
        redis.setKey(key, value);
    }

    @Override
    public void delete(String key) {
        redis.remove(key);
    }
}
