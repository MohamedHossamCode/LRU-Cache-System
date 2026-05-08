public class HashTable {
    private Node[] table;
    private int capacity;
    private int num_of_nodes = 0;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    private int hash(int key) {
        if (capacity == 0) return 0;
        return Math.abs(key) % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.getKey() == key) {
                current.setValue(value);
                return;
            }
            current = current.nextInHash;
        }
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
                return;
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
                if (prev == null) {
                    table[index] = current.nextInHash;
                } else {
                    prev.nextInHash = current.nextInHash;
                }
                num_of_nodes--;
                return;
            }
            prev = current;
            current = current.nextInHash;
        }
        System.out.println("Node not found");
    }

    public Node getNode(int key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.getKey() == key) return current;
            current = current.nextInHash;
        }
        return null;
    }

    public void putNode(Node node) {

        int index = hash(node.getKey());
        Node current = table[index];
        while (current != null) {
            if (current.getKey() == node.getKey()) {
                current.setValue(node.getValue());
                return; // update, don't insert duplicate
            }
            current = current.nextInHash;
        }
        node.nextInHash = table[index];
        table[index] = node;
        num_of_nodes++;
    }
}