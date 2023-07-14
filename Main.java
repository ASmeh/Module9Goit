import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }
        // TODO:test more myArrayList
        System.out.println(myArrayList);

        /////////////////////////////////
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
        }
        ((MyLinkedList<Integer>) myLinkedList).printLinkedList();
    }
}