package _22_hashmaps;

import java.util.*;

public class HashMapFinal<K, V> {
    // The list that will hold the LinkedLists of Entities (key-value pairs)
    ArrayList<LinkedList<Entity>> list;

    // Tracks the number of elements in the HashMap
    private int size = 0;

    // Load factor that determines when to rehash the HashMap
    private float lf = 0.5f;

    // Constructor to initialize the HashMap with an initial capacity of 10 buckets
    public HashMapFinal() {
        list = new ArrayList<>();
        // Initialize each bucket as a new LinkedList
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    // Puts a key-value pair into the HashMap
    public void put(K key, V value) {
        // Calculate the hash for the key using its hashCode
        int hash = Math.abs(key.hashCode() % list.size());

        // Get the LinkedList corresponding to the hash value
        LinkedList<Entity> entities = list.get(hash);

        // Check if the key already exists in the LinkedList, if so, update the value
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return; // Exit once the key is updated
            }
        }

        // Check if the load factor threshold has been exceeded, if so, trigger rehashing
        if ((float) (size) / list.size() > lf) {
            reHash();
        }

        // Add the new key-value pair as a new Entity in the LinkedList
        entities.add(new Entity(key, value));

        // Increment the size of the HashMap
        size++;
    }

    // Private method to rehash the HashMap by increasing the size of the list and redistributing the entities
    private void reHash() {
        System.out.println("We are now rehashing!");

        // Save the old list to rehash its contents
        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();

        // Reset size and increase the number of buckets
        size = 0;

        // Double the number of buckets
        for (int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        // Reinsert all existing elements into the new list (with increased capacity)
        for (LinkedList<Entity> entries : old) {
            for (Entity entry : entries) {
                put(entry.key, entry.value);
            }
        }
    }

    // Retrieves the value associated with the given key
    public V get(K key) {
        // Calculate the hash and retrieve the appropriate LinkedList
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        // Search for the key in the LinkedList and return the corresponding value
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }
        // Return null if the key is not found
        return null;
    }

    // Removes the key-value pair with the specified key from the HashMap
    public void remove(K key) {
        // Calculate the hash and get the corresponding LinkedList
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        // Search for the key in the LinkedList
        Entity target = null;
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                target = entity; // Mark the entity for removal
                break;
            }
        }

        // Remove the entity and decrease the size
        if (target != null) {
            entities.remove(target);
            size--;
        }
    }

    // Checks if the HashMap contains a key
    public boolean containsKey(K key) {
        // Return true if the key exists, otherwise false
        return get(key) != null;
    }

    // Override the toString method to provide a custom string representation of the HashMap
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        // Traverse each bucket and each entity in the bucket
        for (LinkedList<Entity> entities : list) {
            for (Entity entity : entities) {
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append(" , ");
            }
        }
        builder.append("}");

        return builder.toString();
    }

    // Inner class representing a key-value pair (Entity)
    private class Entity {
        K key;
        V value;

        // Constructor for creating an Entity with a key and value
        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
