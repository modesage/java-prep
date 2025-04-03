package _00_algorithm.huffman_coding_greedy;

import _21_heaps.Heap;

import java.util.*;

// HuffmanCoder class to implement Huffman Coding
class HuffmanCoder {
    // HashMaps to store the encoding and decoding mappings
    HashMap<Character, String> encoder;  // Character to Huffman code
    HashMap<String, Character> decoder;  // Huffman code to character

    // Inner Node class that represents a node in the Huffman Tree
    private class Node implements Comparable<Node> {
        Character data;  // Character stored in the node (null for internal nodes)
        int cost;        // Cost represents frequency of character in input string
        Node left;       // Left child
        Node right;      // Right child

        // Constructor to initialize node with data and cost
        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        // Comparing nodes based on cost (used for priority queue/heap)
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    // Constructor for HuffmanCoder
    public HuffmanCoder(String feeder) throws Exception {
        // Map to store frequency of each character in the input string
        HashMap<Character, Integer> fmap = new HashMap<>();

        // Count frequency of each character in the feeder string
        for(int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            fmap.put(cc, fmap.getOrDefault(cc, 0) + 1);
        }

        // Min heap to store nodes of the Huffman Tree based on frequency (cost)
        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        // Create a node for each character and insert into the min heap
        for(Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        // Build the Huffman Tree by combining nodes with the least cost
        while(minHeap.size() != 1) {
            // Remove two nodes with the lowest frequency
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            // Create a new internal node with combined frequency
            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            // Insert the combined node back into the heap
            minHeap.insert(newNode);
        }

        // The last remaining node is the root of the Huffman Tree
        Node ft = minHeap.remove();

        // Initialize the encoder and decoder maps
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        // Generate the encoding and decoding mappings
        this.initEncoderDecoder(ft, "");
    }

    // Recursive function to traverse the Huffman Tree and build encoding/decoding maps
    private void initEncoderDecoder(Node node, String osf) {
        if(node == null) {
            return;
        }
        // If it's a leaf node, store its encoding and decoding mappings
        if(node.left == null && node.right == null) {
            this.encoder.put(node.data, osf);  // Character to Huffman code
            this.decoder.put(osf, node.data);  // Huffman code to character
        }
        // Traverse left and right subtrees with updated encoding
        initEncoderDecoder(node.left, osf + "0");
        initEncoderDecoder(node.right, osf + "1");
    }

    // Encode the given source string using Huffman encoding
    public String encode(String source) {
        String ans = "";

        // For each character in the source string, append its Huffman code
        for(int i = 0; i < source.length(); i++) {
            ans += encoder.get(source.charAt(i));  // Append Huffman code for each character
        }

        return ans;
    }

    // Decode the given coded string using Huffman decoding
    public String decode(String codedString) {
        String key = "";  // Current Huffman code
        String ans = "";  // Decoded string

        // Traverse the coded string and decode using the decoder map
        for(int i = 0; i < codedString.length(); i++) {
            key = key + codedString.charAt(i);  // Add one bit at a time to the current key
            if(decoder.containsKey(key)) {
                ans = ans + decoder.get(key);  // Append decoded character
                key = "";  // Reset key for the next character
            }
        }

        return ans;
    }
}
