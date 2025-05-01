import core.KeyValueStore;
import core.SupportTTL;
import decorator.LoggingDecorator;
import decorator.TTLDecorator;
import factory.DataStoreFactory;

public class Main {
    public static void main(String[] args) {
        KeyValueStore baseStore = DataStoreFactory.getDataStore(DataStoreFactory.DataStoreType.IN_MEMORY);

        KeyValueStore loggingStore = new LoggingDecorator(baseStore);
        KeyValueStore ttlStore = new TTLDecorator(loggingStore);

        ttlStore.set("k1", "v1");

        if (ttlStore instanceof SupportTTL) {
            ((SupportTTL) ttlStore).set("k2", "v2", 1000);
        }
    }
}