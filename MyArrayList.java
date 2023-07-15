import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> implements MyList<E> {
    private int size = 0;

    Object[] elements = {};

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

    }

    @Override
    public void remove(int index) {
        if (elements.length == 0 || index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = null;
        Object[] newElements = new Object[elements.length - 1];
        int indx = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                newElements[indx++] = elements[i];
            }
        }
        elements = newElements;

    }

    @Override
    public void clear() {
        elements = null;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        return "MyArrayList [elements=" + Arrays.toString(elements) + "]";
    }

}
