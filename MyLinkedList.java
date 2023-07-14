import org.w3c.dom.Node;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public class Node<E> {
        Node<E> prev;
        Node<E> next;
        E value;

        Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(tail, null, value);
        tail.next = newNode;
        ++size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public void clear() {
        Node<E> cur = head;
        while (cur != null) {
            Node<E> tmpNext = cur.next;
            cur.prev = null;
            cur.value = null;
            cur.next = null;
            cur = tmpNext;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur;
    }

}
