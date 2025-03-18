package _17_trees.DFS;

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //https://leetcode.com/problems/diameter-of-binary-tree/description/
        //google, amazon, facebook
        height(root);
        return diameter;
    }
    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //post order traversal
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        //google
        //https://leetcode.com/problems/invert-binary-tree/description/
        invert(root);
        return root;
    }
    TreeNode invert(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode leftSubTree = invert(node.left);
        TreeNode rightSubTree = invert(node.right);
        node.left = rightSubTree;
        node.right = leftSubTree;
        return node;
    }

    int depth = 0;
    public int maxDepth(TreeNode root) {
        //google
        //https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
        findDepth(root);
        return depth;
    }
    int findDepth(TreeNode node){
        if(node == null){
            return 1;
        }
        int leftSubTree = findDepth(node.left);
        int rightSubTree = findDepth(node.right);
        depth = Math.max(leftSubTree, rightSubTree);
        return depth + 1;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        //facebook
        return formBST(nums, 0, nums.length);
    }
    private TreeNode formBST(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = formBST(nums, start, mid);
        root.right = formBST(nums, mid + 1, end);
        return root;
    }

    public void flatten(TreeNode root) {
        //facebook
        //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        //in O(1) with morris traversal
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        //google, amazon
        //https://leetcode.com/problems/validate-binary-search-tree/
        return helper(root, null, null);
    }
    public boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null){
            return true;
        }
        if(low != null && node.val <= low){
            return false;
        }
        if(high != null && node.val >= high){
            return false;
        }

        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val, high);

        return leftTree && rightTree;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //amazon
        //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }

    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        //facebook, amazon, google
        //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        return helper1(root, k).val;
    }
    public TreeNode helper1(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper1(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if(count == k) {
            return root;
        }
        return helper1(root.right, k);
    }


    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //amazon
        //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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

    public class Codec {
        //google, facebook, amazon
        //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
        // Encodes a tree to a single string using preorder traversal
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }
        private void serializeHelper(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("N,"); // Mark null nodes
                return;
            }
            sb.append(node.val).append(","); // Store node value
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
        // Decodes your encoded data to tree
        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserializeHelper(nodes);
        }
        private TreeNode deserializeHelper(Queue<String> nodes) {
            String val = nodes.poll(); // Read the next value
            if (val.equals("N")) return null; // Null marker
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        //amazon
        //https://leetcode.com/problems/path-sum/description/
        if(root == null) return false;
        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public int sumNumbers(TreeNode root) {
        //https://leetcode.com/problems/sum-root-to-leaf-numbers/
        return helper(root, 0);
    }
    int helper(TreeNode node, int sum) {
        if(node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //facebook
        //https://leetcode.com/problems/binary-tree-maximum-path-sum/
        helper(root);
        return ans;
    }
    int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        int pathSum = left + right + node.val;
        ans = Math.max(ans, pathSum);
        return Math.max(left, right) + node.val;
    }

    boolean findPath(TreeNode node, int[] arr){
        if(node == null){
            return arr.length == 0;
        }
        return helper(node, arr, 0);
    }
    boolean helper(TreeNode node, int[] arr, int index){
        if(node == null) return false;
        if(index > arr.length || node.val != arr[index]) return false;
        if(node.left == null && node.right == null && index == arr.length - 1) return true;
        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

    int countPaths(TreeNode node, int sum) {
        List<Integer> path = new ArrayList<>();
        return helper(node, sum, path);
    }
    int helper(TreeNode node, int sum, List<Integer> path) {
        if(node == null) {
            return 0;
        }

        path.add(node.val);
        int count = 0;
        int s = 0;
        // how many paths I can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            s += itr.previous();

            if (s == sum) {
                count++;
            }
        }

        count += helper(node.left, s, path) + helper(node.right, sum, path);

        // backtrack
        path.remove(path.size() - 1);
        return count;

    }

    // put in a list
    List<List<Integer>> findPaths(TreeNode node, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(node, sum, path);
        return paths;
    }
    void helper(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths) {
        if(node == null) {
            return;
        }

        path.add(node.val);

        if (node.val == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            helper(node.left, sum-node.val, path, paths);
            helper(node.right, sum-node.val, path, paths);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    // dfs using stack
    void dfsStack(TreeNode node) {
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode removed = stack.pop();
            System.out.print(removed.val + " ");
            if(removed.right != null) {
                stack.push(removed.right);
            }
            if(removed.left != null) {
                stack.push(removed.left);
            }
        }
    }
}
