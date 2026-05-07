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
    
}