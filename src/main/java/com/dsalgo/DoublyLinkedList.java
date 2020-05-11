package main.java.com.dsalgo;

public class DoublyLinkedList {

    public Node head;
    public Node tail;

    public void setHead(Node node) {
        this.head = node;
    }

    public void setTail(Node node) {
        this.tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if (node.value == head.value) {
            head = nodeToInsert;
            head.next = node;
            return;
        }
        Node current = head;
        while (current.value != node.value) {
            current = current.next;
        }
        current.prev.next = nodeToInsert;
        nodeToInsert.next = current;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        Node current = node;
        Node next = current.next;

        while (current.value != node.value) {
            current = current.next;
            next = next.next;
        }
        current.next = nodeToInsert;
        if (current == tail) {
            nodeToInsert = tail;
        } else {
            nodeToInsert.next = next;
        }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        int count = 0;
        Node current = head;
        while(count < position) {
            current = current.next;
        }
        insertBefore(current,nodeToInsert);
    }

    public void removeNodesWithValue(int value) {

    }

    public void remove(Node node) {
        // Write your code here.
    }

    public boolean containsNodeWithValue(int value) {
        // Write your code here.
        return false;
    }
}

// Do not edit the class below.
class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}



