package _17_trees.intro;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // Insert elements
    public void populate(Scanner sc) {
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    // This is the helper function for recursive population
    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to enter left child of " + node.value + "? (true/false)");
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value for the left child: ");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to enter right child of " + node.value + "? (true/false)");
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value for the right child: ");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }

    // Display the tree structure
    public void display() {
        display(root, "");
    }

    // Helper function to display the tree in a simple format
    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent + "  ");  // Indent for left child
        display(node.right, indent + "  "); // Indent for right child
    }
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    //pre order traversal
    public void preOrder() {
        //starting from the root
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //node -> left -> right
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //in order traversal
    public void inOrder() {
        //starting from the root
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        //left -> node -> right
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    //post order traversal
    public void postOrder() {
        //starting from the root
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        //left -> right -> node
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
}
