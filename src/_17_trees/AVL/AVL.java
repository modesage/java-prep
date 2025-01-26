package _17_trees.AVL;

class AVL {
    // Node class represents each node in the AVL tree
    public class Node {
        private int value;  // Node's value
        private Node left;  // Left child of the node
        private Node right; // Right child of the node
        private int height; // Height of the node (used for balancing)

        public Node(int value) {
            this.value = value;
            this.height = 0; // New nodes start with height 0
        }

        public int getValue() {
            return value;
        }
    }

    private Node root; // Root of the AVL tree

    public AVL() {
    }

    // Compute height of the tree (dynamic calculation for debugging)
    private int computeHeight(Node node) {
        if (node == null) return -1;
        return Math.max(computeHeight(node.left), computeHeight(node.right)) + 1;
    }

    public int height() {
        return computeHeight(root);
    }

    // Insert a value into the AVL tree
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value); // Create a new node if the current one is null
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            // Duplicate values are not allowed in this implementation
            return node;
        }

        // Update the height of the current node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Check for imbalances and rotate if necessary
        return rotate(node);
    }

    // Rotate to balance the tree
    private Node rotate(Node node) {
        int balanceFactor = height(node.left) - height(node.right);

        // Left-heavy
        if (balanceFactor > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                // Left-Left case
                return rightRotate(node);
            } else {
                // Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right-heavy
        if (balanceFactor < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                // Right-Right case
                return leftRotate(node);
            } else {
                // Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node; // No imbalance
    }

    // Right rotation to fix left-heavy trees
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotation to fix right-heavy trees
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Populate the AVL tree with an array of integers
    public void populate(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
    }

    // Populate the AVL tree from a sorted array for balanced insertion
    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    // Display the AVL tree structure
    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    // Check if the AVL tree is balanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;
        int balanceFactor = Math.abs(height(node.left) - height(node.right));
        return balanceFactor <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    // Private helper to get the height of a node
    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }
}
