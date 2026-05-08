public class Main {
    public static void main(String[] args) {

        System.out.println(" Test 1: Basic Insert ");
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.display();

        System.out.println(" Test 2: Get (moves to front) ");
        cache.get(1);
        cache.display();

        System.out.println("Test 3: Eviction (cache full) ");
        cache.put(4, 40);
        cache.display();

        System.out.println("Test 4: Update existing key ");
        cache.put(1, 99);
        cache.display();

        System.out.println(" Test 5: Remove ");
        cache.remove(4);
        cache.display();
        System.out.println(" Test 6: Get non-existent key ");
        System.out.println("get(99) = " + cache.get(99));

        System.out.println("Test 7: Repeated access");
        cache.put(5, 50);
        System.out.println("After put(5,50):"); cache.display();
        cache.put(6, 60);
        System.out.println("After put(6,60) - key 3 evicted:"); cache.display();
        cache.get(1);
        System.out.println("After get(1) - moved to front:"); cache.display();    }
}