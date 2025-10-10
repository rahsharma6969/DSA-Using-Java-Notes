import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        // 1. CREATING A HASHMAP
        HashMap<String, Integer> map = new HashMap<>();
        
        System.out.println("=== ADDING ELEMENTS ===");
        
        // 2. put() - Add key-value pairs
        map.put("Apple", 100);
        map.put("Banana", 50);
        map.put("Orange", 75);
        System.out.println("After put(): " + map);
        
        // 3. putIfAbsent() - Add only if key doesn't exist
        map.putIfAbsent("Apple", 200); // Won't update
        map.putIfAbsent("Mango", 60);  // Will add
        System.out.println("After putIfAbsent(): " + map);
        
        // 4. putAll() - Add all entries from another map
        HashMap<String, Integer> newMap = new HashMap<>();
        newMap.put("Grapes", 80);
        newMap.put("Pineapple", 90);
        map.putAll(newMap);
        System.out.println("After putAll(): " + map);
        
        System.out.println("\n=== RETRIEVING ELEMENTS ===");
        
        // 5. get() - Get value by key
        Integer applePrice = map.get("Apple");
        System.out.println("get('Apple'): " + applePrice);
        
        // 6. getOrDefault() - Get value or default if key not found
        Integer kiwiPrice = map.getOrDefault("Kiwi", 0);
        System.out.println("getOrDefault('Kiwi', 0): " + kiwiPrice);
        
        // 7. containsKey() - Check if key exists
        boolean hasApple = map.containsKey("Apple");
        System.out.println("containsKey('Apple'): " + hasApple);
        
        // 8. containsValue() - Check if value exists
        boolean hasPrice100 = map.containsValue(100);
        System.out.println("containsValue(100): " + hasPrice100);
        
        System.out.println("\n=== SIZE AND EMPTINESS ===");
        
        // 9. size() - Get number of entries
        System.out.println("size(): " + map.size());
        
        // 10. isEmpty() - Check if map is empty
        System.out.println("isEmpty(): " + map.isEmpty());
        
        System.out.println("\n=== ITERATING OVER HASHMAP ===");
        
        // 11. keySet() - Get all keys
        Set<String> keys = map.keySet();
        System.out.println("keySet(): " + keys);
        
        // 12. values() - Get all values
        Collection<Integer> values = map.values();
        System.out.println("values(): " + values);
        
        // 13. entrySet() - Get all key-value pairs
        System.out.println("Iterating with entrySet():");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // 14. forEach() - Modern iteration (Java 8+)
        System.out.println("Using forEach():");
        map.forEach((key, value) -> 
            System.out.println("  " + key + " costs " + value)
        );
        
        System.out.println("\n=== UPDATING ELEMENTS ===");
        
        // 15. replace() - Replace value for a key
        map.replace("Apple", 120);
        System.out.println("After replace('Apple', 120): " + map);
        
        // 16. replace() with old value check
        map.replace("Banana", 50, 55);
        System.out.println("After replace('Banana', 50, 55): " + map);
        
        // 17. compute() - Compute new value based on key and old value
        map.compute("Orange", (key, val) -> val == null ? 0 : val + 10);
        System.out.println("After compute('Orange'): " + map);
        
        // 18. computeIfPresent() - Compute only if key exists
        map.computeIfPresent("Mango", (key, val) -> val * 2);
        System.out.println("After computeIfPresent('Mango'): " + map);
        
        // 19. computeIfAbsent() - Compute only if key doesn't exist
        map.computeIfAbsent("Watermelon", key -> 45);
        System.out.println("After computeIfAbsent('Watermelon'): " + map);
        
        // 20. merge() - Merge values for a key
        map.merge("Apple", 30, (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge('Apple', 30): " + map);
        
        System.out.println("\n=== REMOVING ELEMENTS ===");
        
        // 21. remove() - Remove by key
        map.remove("Pineapple");
        System.out.println("After remove('Pineapple'): " + map);
        
        // 22. remove() with value check
        map.remove("Grapes", 80);
        System.out.println("After remove('Grapes', 80): " + map);
        
        // 23. clear() - Remove all entries
        HashMap<String, Integer> tempMap = new HashMap<>(map);
        tempMap.clear();
        System.out.println("After clear() on tempMap: " + tempMap);
        
        System.out.println("\n=== FINAL MAP ===");
        System.out.println(map);
    }
}