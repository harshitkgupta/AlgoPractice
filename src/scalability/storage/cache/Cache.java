package scalability.storage.cache;

public interface Cache<Key, Value> {

    Value get(Key k);

    void set(Key key, Value value);
}
