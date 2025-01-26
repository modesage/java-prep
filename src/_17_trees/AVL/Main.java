package _17_trees.AVL;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();
//        int[] nums = new int[1000];

//        for (int i = 0; i < 1000; i++) {
//            nums[i] = i;
//        }
//        tree.populatedSorted(nums);

        // Test with sequential insertion
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }
        // Check the height of the tree
        System.out.println("Height of the tree: " + tree.height());

        // Check if the tree is balanced
        System.out.println("Is the tree balanced? " + tree.isBalanced());
    }
}
