package _17_trees.adv_questions;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.HashMap;
import java.util.Map;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PreIn {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0);
    }
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderMap.get(rootVal);
        int leftSize = inIndex - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inStart);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, inIndex + 1);
        return root;
    }
}
