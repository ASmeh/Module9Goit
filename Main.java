import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("MyArrayList test:");
        MyList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }
        // TODO:test more myArrayList
        System.out.println(myArrayList);

        myArrayList.remove(3);
        System.out.println(myArrayList);
        System.out.println("Index 3:" +myArrayList.get(3));

        /////////////////////////////////
        System.out.println("MyLinkedList test:");
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
        }
        ((MyLinkedList<Integer>) myLinkedList).printLinkedList();
        // TODO:test mor myLinkedList
        myLinkedList.remove(3);
        ((MyLinkedList<Integer>) myLinkedList).printLinkedList();
        System.out.println(myLinkedList.get(3));
        myLinkedList.clear();
        ((MyLinkedList<Integer>) myLinkedList).printLinkedList();
        System.out.println(myLinkedList.size());
        ////////////////////////////////
        System.out.println("MyQueue test:");
        MyQueue<Integer> myQueue = new MyQueueList<>();
        for (int i = 0; i < 10; i++) {
            myQueue.add(i);
        }
        ((MyQueueList<Integer>) myQueue).printQueue();
        // TODO: test more Queue
        System.out.println("myQueue size:"+myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println("myQueue size:"+myQueue.size());
        System.out.println(myQueue.poll());
        System.out.println("myQueue size:"+myQueue.size());
        ((MyQueueList<Integer>) myQueue).printQueue();

        ///////////////////////////////
        System.out.println("MyStack test:");
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            myStack.add(i);
        }
        System.out.println(myStack);
        // TODO: test more myStack
        myStack.remove(0);
        System.out.println(myStack);
        System.out.println(myStack.peek());
        System.out.println("Stack size:" + myStack.size());
        System.out.println(myStack.pop());
        System.out.println("Stack size:" + myStack.size());

        ////////////////////////////////
        System.out.println("MyHashMap  test:");
        MyMap<String, Integer> map2 = new MyHashMap<>();
        for (int i = 0; i < 10; i++) {
            map2.put("qwerty" + i, i);
        }
        ((MyHashMap<String, Integer>) map2).print();
        // TODO: test more MyHashMap
        map2.put("asdf",20);
        ((MyHashMap<String, Integer>) map2).print();
        System.out.println("asdf val:" + map2.get("asdf"));
        map2.remove("asdf");
        ((MyHashMap<String, Integer>) map2).print();
    }
}
    