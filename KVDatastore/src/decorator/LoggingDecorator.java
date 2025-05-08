package decorator;

import core.KeyValueStore;

public class LoggingDecorator implements KeyValueStore {

    private KeyValueStore keyValueStore;

    public LoggingDecorator(KeyValueStore keyValueStore) {
        this.keyValueStore = keyValueStore;
    }

    @Override
    public String get(String key) {
        System.out.println("[LOG] GET " + key);
        return keyValueStore.get(key);
    }

    @Override
    public void set(String key, String value) {
        System.out.println("[LOG] SET " + key + " = " + value);
        keyValueStore.set(key, value);
    }

    @Override
    public void delete(String key) {
        System.out.println("[LOG] REMOVE " + key);
        keyValueStore.delete(key);
    }
}
