
public class HashTable {
    private Node[] table;
    private int capacity;
    private int num_of_nodes = 0;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node current = table[index];

        // Check for existing key and update
        while (current != null) {
            if (current.getKey() == key) {
                current.setValue(value);
                return;
            }
            current = current.nextInHash;
        }

        // Key not found — insert at head
        Node newNode = new Node(key, value);
        newNode.nextInHash = table[index];
        table[index] = newNode;
        num_of_nodes++;
    }

    public void search(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.getKey() == key) {
                System.out.println("Node with key " + key + " is found");
                return; // stop after finding
            }
            current = current.nextInHash;
        }

        System.out.println("Node not found");
    }

    public void delete(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.getKey() == key) {
                // CASE 1: Deleting the very first node (Beginning)
                if (prev == null) {
                    table[index] = current.nextInHash;
                }
                // CASE 2 & 3: Deleting from the Middle or End
                else {
                    prev.nextInHash = current.nextInHash;
                }
                num_of_nodes--; // fix: decrement counter
                return;
            }
            prev = current;
            current = current.nextInHash;
        }

        System.out.println("Node not found"); // fix: notify if key doesn't exist
    }
}
