public class LRUCache {
    private int capacity;
    private int size;
    private DoublyLinkedList dll;
    private HashTable hashTable;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        dll = new DoublyLinkedList();
        hashTable = new HashTable(nextPrime(capacity * 2));
    }

    private int nextPrime(int n) {
        if (n < 2) return 2;
        while (!isPrime(n)) n++;
        return n;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }


    public int get(int key) {
        if (capacity <= 0)
            return -1;
        Node node = hashTable.getNode(key);
        if (node == null)
            return -1;
        dll.moveToFront(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        Node node = hashTable.getNode(key);
        if (node != null) {
            node.setValue(value);
            dll.moveToFront(node);
            return;
        }
        if (size == capacity) {
            Node lru = dll.removeLeastRecentlyUsed();
            if (lru != null) {
                hashTable.delete(lru.getKey());
                size--;
            }
        }
        Node newNode = new Node(key, value);
        dll.insertFront(newNode);
        hashTable.putNode(newNode);
        size++;
    }

    public void remove(int key) {
        if (capacity <= 0) return;
        Node node = hashTable.getNode(key);
        if (node == null) return;
        dll.removeNode(node);
        hashTable.delete(key);
        size--;
    }


    public void display() {
        Node current = dll.head;
        System.out.print("Cache : ");
        while (current != null) {
            System.out.print("[" + current.getKey() + " : " + current.getValue() + "] ");
            current = current.getNext();
        }
        System.out.println();
    }
}