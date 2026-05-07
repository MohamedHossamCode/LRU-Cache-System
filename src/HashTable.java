public class HashTable {
    private Node[] table;
    private int capacity;
    
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }
    private int hash(int key) {
        return key%capacity;
    }
}
