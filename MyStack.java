import java.util.Arrays;

public class MyStack<E> implements MyList<E> {
    private int size = 0;

    Object[] elements = {};

    public void push(Object value) {
        Object[] newElements = Arrays.copyOf(elements, elements.length + 1);
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        newElements[elements.length] = value;
        elements = newElements;
    }

    public void remove(int index) {

    }

    public void clear() {
        elements = null;
    }

    public int size() {
        return size;
    }

    public Object peek() {

    }

    public Object pop() {

    }
}