# AVL Tree: Complete Theory and Algorithms

## What is an AVL Tree?
An **AVL tree** is a self-balancing binary search tree named after its inventors, **G. M. Adelson-Velsky** and **E. M. Landis**. It maintains a balance condition to ensure that the tree's height remains logarithmic, making operations like insertion, deletion, and search efficient.

### Properties of AVL Tree
1. **Binary Search Tree (BST) Property:** For each node:
    - All keys in the left subtree are smaller.
    - All keys in the right subtree are larger.
2. **Balance Factor Property:** For each node, the difference in height between the left and right subtrees (Balance Factor) is at most 1.
    - **Balance Factor (BF) = Height(left subtree) - Height(right subtree)**
    - BF values can only be -1, 0, or 1.
3. **Self-Balancing Property:** After every insertion or deletion, the tree is rebalanced to maintain the balance factor property.

### Applications of AVL Tree
- Databases and file systems
- Memory management
- Network routing algorithms

---

## Operations in AVL Tree
### 1. Insertion
When inserting a new node into an AVL tree:
1. Perform a normal BST insertion.
2. Update the height of the affected nodes.
3. Check the balance factor of each node.
4. If the balance factor becomes 2 or -2, perform rotations to rebalance the tree.

### 2. Deletion
When deleting a node from an AVL tree:
1. Perform a normal BST deletion.
2. Update the height of the affected nodes.
3. Check the balance factor of each node.
4. If the balance factor becomes 2 or -2, perform rotations to rebalance the tree.

### 3. Rotations
Rotations are used to restore balance in an AVL tree.

#### Types of Rotations
- **Left Rotation (LL):** Applied when a right-heavy subtree needs balancing.
- **Right Rotation (RR):** Applied when a left-heavy subtree needs balancing.
- **Left-Right Rotation (LR):** A combination of a left rotation followed by a right rotation.
- **Right-Left Rotation (RL):** A combination of a right rotation followed by a left rotation.

### Identifying the Node Causing Imbalance (Bottom-Up Approach)
1. Insert the new node as you would in a normal BST.
2. Starting from the newly inserted node, move up the tree to the root, updating the height of each ancestor node.
3. For each ancestor node, calculate the balance factor:
    - If the balance factor is within [-1, 0, 1], the node is balanced.
    - If the balance factor is outside this range (i.e., -2 or 2), the node is unbalanced.
4. The first unbalanced node encountered during this bottom-up traversal is the node that needs rebalancing.
5. Determine the type of imbalance (LL, RR, LR, RL) and perform the corresponding rotation to restore balance.

---

## Algorithms

### Node Structure
```java
class Node {
    int key, height;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
```

### Height Calculation
```java
int height(Node node) {
    return (node == null) ? 0 : node.height;
}
```

### Balance Factor
```java
int getBalanceFactor(Node node) {
    return (node == null) ? 0 : height(node.left) - height(node.right);
}
```

### Rotation Algorithms
#### Right Rotation
```java
Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights
    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    // Return new root
    return x;
}
```

#### Left Rotation
```java
Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    // Update heights
    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    // Return new root
    return y;
}
```

### Insertion
```java
Node insert(Node node, int key) {
    // Step 1: Perform normal BST insertion
    if (node == null)
        return new Node(key);

    if (key < node.key)
        node.left = insert(node.left, key);
    else if (key > node.key)
        node.right = insert(node.right, key);
    else
        return node; // Duplicate keys are not allowed

    // Step 2: Update height
    node.height = 1 + Math.max(height(node.left), height(node.right));

    // Step 3: Get balance factor
    int balance = getBalanceFactor(node);

    // Step 4: Balance the tree
    // Left Left Case
    if (balance > 1 && key < node.left.key)
        return rightRotate(node);

    // Right Right Case
    if (balance < -1 && key > node.right.key)
        return leftRotate(node);

    // Left Right Case
    if (balance > 1 && key > node.left.key) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < node.right.key) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node;
}
```

### Deletion
```java
Node delete(Node root, int key) {
    // Step 1: Perform normal BST deletion
    if (root == null)
        return root;

    if (key < root.key)
        root.left = delete(root.left, key);
    else if (key > root.key)
        root.right = delete(root.right, key);
    else {
        // Node with one child or no child
        if ((root.left == null) || (root.right == null)) {
            Node temp = (root.left != null) ? root.left : root.right;

            if (temp == null) {
                temp = root;
                root = null;
            } else {
                root = temp;
            }
        } else {
            // Node with two children
            Node temp = getMinValueNode(root.right);
            root.key = temp.key;
            root.right = delete(root.right, temp.key);
        }
    }

    if (root == null)
        return root;

    // Step 2: Update height
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    // Step 3: Get balance factor
    int balance = getBalanceFactor(root);

    // Step 4: Balance the tree
    // Left Left Case
    if (balance > 1 && getBalanceFactor(root.left) >= 0)
        return rightRotate(root);

    // Left Right Case
    if (balance > 1 && getBalanceFactor(root.left) < 0) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    // Right Right Case
    if (balance < -1 && getBalanceFactor(root.right) <= 0)
        return leftRotate(root);

    // Right Left Case
    if (balance < -1 && getBalanceFactor(root.right) > 0) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    return root;
}

Node getMinValueNode(Node node) {
    Node current = node;
    while (current.left != null)
        current = current.left;
    return current;
}
```

---

### Complexity
| Operation    | Time Complexity |
|--------------|-----------------|
| Search       | O(log n)        |
| Insertion    | O(log n)        |
| Deletion     | O(log n)        |

---

### Advantages of AVL Tree
- Ensures balanced structure, leading to predictable performance.
- Fast lookups, insertions, and deletions compared to unbalanced BSTs.

### Disadvantages of AVL Tree
- Rotations make insertion and deletion more complex compared to a standard BST.
- Slightly higher memory usage due to storing height information.
