package section1_3;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/*
1.3.24 Write a method removeAfter() that takes a linked-list Node as argument and
removes the node following the given one (and does nothing if the argument or the next
field in the argument node is null).
 */

public class linkedList<Item extends Comparable<Item>> implements Iterable<Item>{
    private Node first;
    private int N;

    private class Node {
        Node next;
        Item item;
    }

    public Node createNode(Item item) {
        Node temp = new Node();
        temp.item = item;
        return temp;
    }

    public Node getNode(int k) {
        Node temp = null;
        try {

            temp = first;

            for (int i = 1; i < k ; i++) {
                temp = temp.next;
            }

        } catch (NullPointerException npe) {
            System.out.println("Out of bounds.");
        }
        return temp;
    }

    public void delete(int k) {
        if (k > 1) {
            try {
                Node temp = first;
                for (int i = 1; i < k - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                N--;
            } catch (NullPointerException npe) {
                System.out.println("index out of bounds");
            }
        } else {
            getFirstNode();
            N--;
        }
    }

    public static boolean find(linkedList<String> stack, String key) {
        linkedList.Node temp;
        temp = stack.first;
        if (stack.isEmpty()) return false;
        if (stack.size() == 1) return temp.item == key;
        while (temp != null) {
            if (temp.item == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public void removeAfter(Node node) {
        if (node == null || node.next == null) return;

        node.next = node.next.next;
        N--;
    }

    public void insertAfter(Node firstNode, Node secondNode) {  //firstNode verwijst NIET naar eerste node in list.
        if (firstNode == null || secondNode == null) return;

        Node temp = firstNode.next;
        firstNode.next = secondNode;
        secondNode.next = temp;
        N++;

    }

    public Item removeLastNode() {
        Item item = null;
        if (N > 1){
            Node temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            item = temp.next.item;
            temp.next = null;
            N--;
        } else {
            item = first.item;
            first = null;
            N--;
        }
        return item;
    }

    //Write a method remove() that takes a linked list and a string key as arguments
    //and removes all of the nodes in the list that have key as its item field
    public void removeAll(String key) {
        for (int i = 2; i <= size(); i++) {
            if (getNode(i) != null && Objects.equals(getNode(i).item, key)) {
                delete(i);
                i--;
            }
        }
        if (first.item == key) first = first.next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public void printList() {
        try {
            for (int i = 1; i <= this.size(); i++) {
                System.out.println(this.getNode(i) + ": " +this.getNode(i).item + "   ");
            }


        } catch (NullPointerException npe) {
            System.out.println();
        }
    }

//Write a method max() that takes a reference to the first node in a linked list as
//argument and returns the value of the maximum key in the list. Assume that all keys are
//positive integers, and return 0 if the list is empty
    public Item max(Node first) {
        Item max = first.item;
        Node x = first;
        while(x != null) {
            if ( max.compareTo(x.item) < 1) max =  x.item;
            x = x.next;
        }
        return max;
    }

    //develop recursive max implementation
    public Item maxRec(Node node, Item max) {
        if (node == null) return max;
        if (max.compareTo(node.item) < 1) max = node.item;
        return maxRec(node.next, max);
    }

    public Item getFirstNode() {
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }




    public static void main(String[] args) {

        linkedList<Integer> list = new linkedList<>();
        Random rand = new Random();

        for (int i = 0; i < 10 ; i++) {
            list.add(rand.nextInt(100));
        }

        list.printList();

        System.out.println();
        System.out.println(list.max(list.getNode(1)));
        System.out.println(list.maxRec(list.getNode(1), 0));


    }


}