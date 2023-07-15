public interface MyList<E> {
    void add(Object value);

    void remove(int index);

    void clear();

    int size();

    Object get(int index);

}
