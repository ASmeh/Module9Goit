public interface MyMap<K, V> {
    void put(Object key, Object value);

    void remove(Object key);

    void clear();

    int size();

    Object get(Object key);
}