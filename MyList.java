public interface MyList<E> {
    void add(E value);

    void remove(int index);

    void clear();

    int size();

    Object get(int index);

}
