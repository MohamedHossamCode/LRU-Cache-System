public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFront(Node newNode) {
        // In case the list is empty
        if (this.head == null) {
            // Set the new node as both head and tail
            head = tail = newNode;
        }
        // In case the list already contains elements
        else {
            // Link the new node and the current head to each other
            newNode.setNext(head);
            head.setPrev(newNode);

            // Update head to point to the new node
            head = newNode;

            // Set the previous of the head to null as this is a linear DLL, not circular
            head.setPrev(null);
        }
        
    }
public void removeNode(Node node) {
    if (node == head && node == tail){
        head = null;
        tail = null;
    }
    else if (node == head)
    {    head = head.getNext();
        head.setPrev(null);
    }
    else if (node == tail)
    {    tail = tail.getPrev();
        tail.setNext(null);
    }
    else
    {    node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }
node.setNext(null);
node.setPrev(null);
}


}