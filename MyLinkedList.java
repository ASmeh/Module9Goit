import org.w3c.dom.Node;

public class MyLinkedList<E> implements MyList<E>, MyQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    private class Node<E> {
        Node<E> prev;
        Node<E> next;
        E value;

        Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    @Override
    public void add(Object value) {

        Node<E> newNode = new Node<>(tail, null, (E) value);
        if (tail == null && head == null) {
            tail = newNode;
            head = newNode;
        } else if (size == 1) {
            tail = newNode;
            head.next = tail;
            tail.prev = head;
        } else {
            Node<E> oldTail = tail;
            oldTail.next = newNode;
            tail = newNode;
        }

        ++size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> prev = null;
        Node<E> cur = head;
        int counter = 0;
        while (counter != index) {
            prev = cur;
            cur = cur.next;
            ++counter;
        }
        prev.next = cur.next;
        cur.prev = prev;
        cur = null;
        --size;
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
        head = tail = null;
        size = 0;
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
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void printLinkedList() {
        Node<E> cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public Object peek() {
        return head;
    }

    @Override
    public Object poll() {
        if (size == 1) {
            Object returnObj = peek();
            head = tail = null;
            return returnObj;
        }
        Object returnObj = head;
        head.next.prev = null;
        Node<E> tmpHead =head;
        head = head.next;
        tmpHead.next=null;
        tmpHead.prev=null;
        --size;
        return returnObj;
    }

}
