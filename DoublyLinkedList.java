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

    public void moveToFront(Node node){
        
        if(node == null) {
            System.out.println("ERROR! node can't be null.");
            return;
        }
        
        
        if (node == head) {
        System.out.println("The node is already at the front.");
        return;
    }

    
    if (node != tail) {
       
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    } else {
        tail = node.getPrev(); 
        if (tail != null) {
            tail.setNext(null);
     }

    }
    node.setNext(head);
    node.setPrev(null); 
    
    
    if (head != null) {
                head.setPrev(node);
            }
            
    head = node;
    
    
     System.out.println("Node successfully moved to front!");
   }
    

    public Node findNode(int value) {
    Node current = head;
    while (current != null) {
        if (current.getKey() == value) {
            return current; // Found it!
        }
        current = current.getNext();
    }
        System.out.println("ERROR! node does not exist.");
    return null; // Value doesn't exist
}




}