package _17_trees.intro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        tree.preOrder();
//        tree.prettyDisplay();

//        BinarySearchTree tree = new BinarySearchTree();
//        //if array is given sorted then if we populate using the for loop, the BST will degenerate into a linked list
//        int[] numsSorted = {1,2,3,4,5,6,7,8,9};
////        tree.populate(numsSorted);
//        //so to avoid linear complexity, we will use other method to insert the numbers
//        tree.populatedSorted(numsSorted);
//        System.out.println("Is the tree balanced? " + tree.balanced());
//        tree.display();
    }
}
