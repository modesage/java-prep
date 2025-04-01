package _22_hashmaps;

import java.util.*;

class MapUsingHash {

    // Array of Entity objects to store key-value pairs
    private Entity[] entities;

    // Constructor to initialize the array with 100 slots for key-value pairs
    public MapUsingHash() {
        entities = new Entity[100];
    }

    // Method to insert a key-value pair into the map
    public void put(String key, String value) {
        // Calculate the hash for the key using its hashCode and ensure it's within bounds of the array size
        int hash = Math.abs(key.hashCode() % entities.length);

        // Insert the new Entity into the array at the computed index
        // If a key already exists, this will override the previous value at that index
        entities[hash] = new Entity(key, value);
    }

    // Method to retrieve the value associated with a given key
    public String get(String key) {
        // Calculate the hash and find the correct index in the array
        int hash = Math.abs(key.hashCode() % entities.length);

        // Check if the key exists at the calculated index, and return its associated value if it does
        if (entities[hash] != null && entities[hash].key.equals(key)) {
            return entities[hash].value;
        }
        // Return null if the key is not found
        return null;
    }

    // Method to remove a key-value pair from the map
    public void remove(String key) {
        // Calculate the hash and find the index of the entity to be removed
        int hash = Math.abs(key.hashCode() % entities.length);

        // If the key exists at the index, remove it by setting the array slot to null
        if (entities[hash] != null && entities[hash].key.equals(key)) {
            entities[hash] = null;
        }
    }

    // Inner class representing a key-value pair (Entity)
    private class Entity {
        String key;
        String value;

        // Constructor to create an Entity with a key and a value
        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Uncomment to test the hash demo functionality
        // hashDemo();

        // Create an instance of HashMapFinal
        HashMapFinal<String, String> map = new HashMapFinal<>();

        // Adding key-value pairs to the map
        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Kunal's fav fruit");

        // Print out the entire map using the overridden toString method
        System.out.println(map);
    }

    // Method to demonstrate the use of hash codes, HashMap, and HashSet
    public static void hashDemo() {
        // Example of calculating the hash code of a String
        String name = "messi";
        Integer a = 4235679;
        int code = a.hashCode();
        System.out.println(code);

        // Create and use a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put("messi", 10);
        map.put("xavi", 8);
        map.put("ramos", 93);

        // Retrieve and print the value associated with the key "messi"
        System.out.println(map.get("messi"));

        // Retrieve and print a default value for a missing key "cavani"
        System.out.println(map.getOrDefault("cavani", 21));

        // Check if the key "messi" exists in the map and print the result
        System.out.println(map.containsKey("messi"));

        // Create a HashSet to store unique integers
        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56);  // Duplicate element, will not be added
        set.add(2);

        // Print out the HashSet (no duplicates will be shown)
        System.out.println(set);
    }
}
