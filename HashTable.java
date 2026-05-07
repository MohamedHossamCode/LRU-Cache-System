public class HashTable {
    private Node[] table;
    private int capacity;
    
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    private int hash(int key) {
        return Math.abs(key) % capacity; 
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        // collision handling using chaining
        Node head = table[index];
        if (head == null) table[index] = new Node(key,value);
        Node current = head;
        while (current != null) {
            if (current.getKey() == key) {
                current.setValue(value); // update existing key
                return;
            }
            current = current.nextInHash;
        }
    }
}