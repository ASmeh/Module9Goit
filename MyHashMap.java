import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V>,Printable {
    private class Node<K, V> {
        // Node<K, V> next;
        Object key;
        Object value;
        int hash;

        public Node(Object key, Object value, int hash) {
            // this.next = next;
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key) ^ Objects.hash(value);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            if (o == this)
                return true;
            if (o instanceof MyHashMap.Node) {
                Node<K, V> node = (Node<K, V>) o;
                return node.key.equals(key) && node.value.equals(value);
            }
            return false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }



    @Override
    public void put(Object key, Object value) {
        Node<K, V> newNode = new Node<>(key, value, Objects.hash(key));
        if (size == 0) {
            Node<K, V>[] newTable = new Node[1];
            newTable[0] = newNode;
            table = newTable;
        } else {
            boolean grinded = false;
            for (int i = 0; i < table.length; i++) {
                if (table[i].key == key) {
                    table[i].value = value;
                    grinded = true;
                }
            }
            if (!grinded) {
                Node<K, V>[] newTable = new Node[table.length+1];
                for (int i = 0; i < table.length; i++) {
                    newTable[i] = table[i];
                }
                newTable[table.length] = newNode;
                table = newTable;
            }

        }
        ++size;
    }

    @Override
    public void remove(Object key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i].key.equals(key)) {
                table[i] = null;
            }
        }
        Node<K, V>[] newTable = new Node[table.length-1];
        int j = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                newTable[j++] = table[i];
            }
        }
        table = newTable;
    }

    @Override
    public void clear() {
        if (table != null && size > 0) {
            for (int i = 0; i < table.length; i++) {
                table[i] = null;
            }
            size = 0;
            table = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(Object key) {
        for (Node<K, V> node : table) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
        }
        return null;
    }
    @Override
    public void print() {
        for(Node<K,V> node:table){
            System.out.println("key:"+node.key+" value:"+node.value);
        }
    }
    private Node<K, V>[] table = null;
    private int size = 0;
}
