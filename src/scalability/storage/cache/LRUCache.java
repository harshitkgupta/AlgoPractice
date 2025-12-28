package scalability.storage.cache;

import java.util.LinkedHashMap;

public class LRUCache<Key, Value> extends LinkedHashMap<Key, Value> implements Cache<Key, Value> {

    public LRUCache() {
	super(16, 0.75f, true);
    }

    public LRUCache(int capacity) {
	super(capacity, 0.75f, true);
    }

    public LRUCache(int initialCapacity, float loadFactor) {
	super(initialCapacity, loadFactor, true);
    }

    public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
	super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    public void set(Key key, Value value) {
	Value value = 	
    }

}
