public interface MyQueue<E> {

    public void add(Object value);

    public void clear();

    public int size();

    public Object peek();

    public Object poll();
}
