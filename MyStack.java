import java.util.Arrays;

import org.w3c.dom.Node;

public class MyStack<E> implements MyList<E> {
    private int size = 0;

    private Object[] elements = {};

    public void push(Object value) {
        Object[] newElements = Arrays.copyOf(elements, elements.length + 1);
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        newElements[elements.length] = value;
        elements = newElements;
        ++size;
    }

    public void remove(int index) {
        Object[] newElemnts = new Object[elements.length - 1];
        elements[index] = null;
        int j = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                newElemnts[j++] = elements[i];
            }
        }
        --size;
        elements = newElemnts;
    }

    public void clear() {
        elements = null;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return elements[0];
    }

    public Object pop() {
        Object retValue = peek();
        remove(0);
        return retValue;
    }

    @Override
    public String toString() {
        return "MyStack [elements=" + Arrays.toString(elements) + "]";
    }

    @Override
    public void add(Object value) {
        if (elements.length == 0) {
            elements = new Object[1];
            elements[0] = value;

        } else {
            Object[] newElements = new Object[elements.length + 1];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            newElements[elements.length] = value;
            elements = newElements;
        }
        ++size;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }
}