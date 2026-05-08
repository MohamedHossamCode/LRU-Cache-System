public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFront(Node newNode) {
        if (newNode == null) return;
        newNode.setPrev(null);
        newNode.setNext(head);
        if (head != null) {
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void removeNode(Node node) {
        if (node == null || head == null) return;
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.getNext();
            if (head != null) head.setPrev(null);
        } else if (node == tail) {
            tail = tail.getPrev();
            if (tail != null) tail.setNext(null);
        } else {
            if (node.getPrev() != null) node.getPrev().setNext(node.getNext());
            if (node.getNext() != null) node.getNext().setPrev(node.getPrev());
        }
        node.setPrev(null);
        node.setNext(null);
    }

    public void moveToFront(Node node) {
        if (node == null || head == null || node == head) return;
        removeNode(node);
        insertFront(node);
    }


    public Node removeLeastRecentlyUsed() {
        if (tail == null) return null;
        Node removedNode = tail;
        removeNode(removedNode);
        return removedNode;
    }

    public Node findNode(int key) {
        if (head == null) return null;
        Node current = head;
        while (current != null) {
            if (current.getKey() == key) return current;
            current = current.getNext();
        }
        return null;
    }}