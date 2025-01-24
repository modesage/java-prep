# Definition of a Tree (in Data Structures)

A **tree** is a **non-linear data structure** consisting of a set of **nodes** connected by **edges**. It is used to represent hierarchical relationships or structures, where each node stores a value and is connected to other nodes via edges.

### **Key Characteristics of a Tree:**
1. **Root:** The topmost node in a tree, from which all other nodes originate.
2. **Nodes:** The elements of the tree, each containing a value or data.
3. **Edges:** The connections between nodes, which represent relationships.
4. **Parent and Child Nodes:** A node that is connected to other nodes is called the "parent," and the connected nodes are called its "children."
5. **Leaf Nodes:** Nodes that have no children are called leaf nodes.
6. **Depth of a Node:** The number of edges from the root to that node.
7. **Height of a Node:** The max number of edges from that node to any of its leaf nodes.
8. **Height/Depth of a Tree:** The max number of edges from root node to a leaf node.
9. **Subtree:** A tree formed by a node and all of its descendants.
10. **Size:** Total number of nodes in the tree.
11. **Siblings:** Nodes having same parent.
12. **Level:** Difference of height between that node and root node
13. **Ancestor-Descendant:** When found a path between A and B node, then A is the ancestor of B and B is the descendant of A.

### **Properties of a Tree:**
- **Acyclic:** There are no cycles in a tree, meaning you cannot start from a node and return to it by following edges.
- **Connected:** A tree is a connected graph, meaning there’s a path between any two nodes.
- **N-1 Edges:** For a tree with `N` nodes, there are exactly `N-1` edges.

### **Example of a Tree:**

Consider a simple tree structure where nodes represent numbers:

         1
       /   \
      2     3
     / \     \
    4   5     6

- **Root:** Node 1.
- **Parent and Child:** Node 1 is the parent of nodes 2 and 3. Node 2 is the parent of nodes 4 and 5.
- **Leaf Nodes:** Nodes 4, 5, and 6 are leaf nodes since they have no children.
- **Height of the Tree:** The height of the tree is 2, as the longest path from the root to a leaf involves 2 edges (e.g., 1 → 2 → 4).

---
# Advantages of Trees

1. **Hierarchical Representation:**
    - Trees represent hierarchical structures naturally (e.g., file systems, organizational charts).

2. **Efficient Search:**
    - Balanced trees (e.g., AVL, Red-Black) provide O(log n) time complexity for searching, insertion, and deletion.

3. **Flexible Traversals:**
    - Various traversal techniques (pre-order, in-order, post-order) allow different ways to process tree nodes.

4. **Efficient Sorting:**
    - BSTs provide efficient sorting (in-order traversal gives sorted data).

5. **Balanced Structures:**
    - Self-balancing trees (e.g., AVL, Red-Black) provide guaranteed balanced structures, ensuring efficiency.

---

# Disadvantages of Trees

1. **Complexity in Implementation:**
    - Tree structures, especially balanced ones, can be complex to implement and maintain.

2. **Memory Overhead:**
    - Trees require extra memory for storing pointers to child nodes, leading to higher memory consumption compared to linear structures like arrays.

3. **Unbalanced Performance:**
    - Without proper balancing, trees like BSTs can degrade to linked lists, resulting in inefficient O(n) performance for operations.

4. **Rebalancing Overhead:**
    - Self-balancing trees require additional operations (e.g., rotations) after insertions and deletions, which may impact performance in some cases.

5. **Difficulty with Random Access:**
    - Unlike arrays, trees don't provide constant-time random access, making them less efficient for some use cases.

---

# Use Cases of Trees

Trees are widely used across many domains in computer science and real-world applications. Here are some key areas where trees are utilized:

### 1. **File Systems**
- **Usage:** File systems are often represented as trees, with directories as nodes and files as leaves.
- **Example:** Directory structures in Windows, macOS, or Linux.

### 2. **Databases**
- **Usage:** **B-trees** and **B+ trees** are used for indexing and efficient search operations in databases.
- **Example:** Indexing in MySQL, PostgreSQL, MongoDB.

### 3. **Search Engines**
- **Usage:** **Tries** are used for autocomplete and search indexing, and inverted indices use trees for efficient retrieval.
- **Example:** Search engines like Google use trees for indexing and autocomplete.

### 4. **Expression Parsing and Compilation**
- **Usage:** **Abstract Syntax Trees (ASTs)** are used in compilers to represent the structure of code.
- **Example:** Parsing and compiling programming languages.

### 5. **Decision Trees (Machine Learning)**
- **Usage:** **Decision trees** are used in machine learning for classification and regression tasks.
- **Example:** Decision tree classifiers in scikit-learn.

### 6. **Network Routing Algorithms**
- **Usage:** **Spanning trees** are used in network routing to find efficient paths.
- **Example:** Algorithms like OSPF and RIP use spanning trees for routing.

### 7. **Hierarchical Data Representation**
- **Usage:** Trees represent hierarchical data, like organization charts or category structures.
- **Example:** Organizational charts or category structures in e-commerce websites.

### 8. **Artificial Intelligence**
- **Usage:** Trees are used in AI for decision-making, like **minimax trees** in game theory.
- **Example:** Game tree search for chess or tic-tac-toe.

### 9. **Huffman Coding (Data Compression)**
- **Usage:** **Huffman trees** are used in compression algorithms to encode data efficiently.
- **Example:** Compression in ZIP files or image formats like JPEG.

### 10. **Priority Queues (Heaps)**
- **Usage:** **Heaps** are used in priority queues to efficiently retrieve the highest or lowest priority elements.
- **Example:** Dijkstra’s algorithm for shortest path finding.

### 11. **Blockchain (Merkle Trees)**
- **Usage:** **Merkle trees** are used in blockchain to efficiently verify the integrity of data.
- **Example:** Bitcoin and Ethereum use Merkle trees for verifying transaction blocks.

### 12. **Network Design (Spanning Trees)**
- **Usage:** **Spanning trees** are used in network design to connect all nodes with the minimal number of connections.
- **Example:** Minimum spanning tree algorithms like Prim’s and Kruskal’s.

### 13. **Version Control Systems**
- **Usage:** Trees are used to manage the history of changes in code repositories, like Git.
- **Example:** Git version history with branches and commits.

### 14. **Game Development (Scene Graphs)**
- **Usage:** Trees are used in 3D game engines to represent and manage game objects.
- **Example:** Scene graph in Unity or Unreal Engine.

### 15. **Social Networks (Family Trees, Social Graphs)**
- **Usage:** Trees can represent relationships, such as family trees or social connections.
- **Example:** Family trees or LinkedIn connections.

---

# Tree Data Structures: Detailed Overview

---

## 1. **Binary Tree**
- **Definition**: A binary tree is a tree where each node has at most two children, commonly referred to as the left and right children. There are no constraints on the arrangement of the nodes.

### **Time Complexity:**
- **Search, Insert, Delete**: O(n) (in the worst case, for an unbalanced tree)
- **Space Complexity**: O(n)

### **Advantages:**
- Simple to implement.
- Can represent hierarchical relationships (e.g., parsing expressions).

### **Disadvantages:**
- Can become unbalanced, leading to inefficient operations (O(n) in worst case).
- Lack of ordering makes searching slower (O(n)).

---

## 2. **Complete Binary Tree**
- **Definition**: A complete binary tree is a binary tree in which every level is completely filled, except possibly the last level, which is filled from left to right.

### **Time Complexity:**
- **Search, Insert, Delete**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Well-balanced tree structure.
- Efficient for storing data in an array-like structure.

### **Disadvantages:**
- May require more effort in terms of rearranging or balancing during insertion or deletion.

---

## 3. **Full Binary Tree**
- **Definition**: A full binary tree is a tree in which every node has either 0 or exactly 2 children. Every non-leaf node has two children.

### **Time Complexity:**
- **Search, Insert, Delete**: O(n)
- **Space Complexity**: O(n)

### **Advantages:**
- Simplifies tree traversal as all non-leaf nodes have two children.
- Good for representing some hierarchical structures.

### **Disadvantages:**
- Fixed structure that doesn't allow for flexible node distribution.
- Insertion or deletion may break the "full" property.

---

## 4. **Perfect Binary Tree**
- **Definition**: A perfect binary tree is a binary tree where all interior nodes have two children and all leaf nodes are at the same level.

### **Time Complexity:**
- **Search, Insert, Delete**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Very balanced structure, ensuring minimal depth and efficient operations.
- All leaf nodes are guaranteed to be at the same level.

### **Disadvantages:**
- Insertion and deletion require careful rebalancing.
- Can be challenging to maintain when dealing with dynamic data.

---

## 5. Height-Balanced Binary Tree (e.g., AVL Tree, Red-Black Tree)

---

## **Definition**:
A **Height-Balanced Binary Tree** is a type of binary search tree where the difference in heights between the left and right subtrees of any node is at most 1. This balance property ensures that the tree remains balanced, and thus, the search, insert, and delete operations are efficient.

The **AVL Tree** is the most common implementation of a height-balanced binary tree, named after its inventors Adelson-Velsky and Landis.

### **Balancing Condition**:
- For any node, the height of the left and right subtrees can differ by at most 1. This ensures the tree remains balanced.

---

## **Time Complexity**:

- **Search**: O(log n)
- **Insert**: O(log n)
- **Delete**: O(log n)

Where `n` is the number of nodes in the tree.

---

## **Space Complexity**:
- **Space**: O(n) where `n` is the number of nodes, as each node stores information like left and right child pointers, height, etc.

---

## **Advantages**:
- **Efficient Search**: Guarantees that operations like search, insertion, and deletion are O(log n), ensuring efficient performance even in the worst case.
- **Self-Balancing**: Automatically rebalances itself after every insertion or deletion operation, ensuring that the tree stays balanced and operations stay efficient.
- **Optimized for performance**: Due to the balancing, the tree avoids the worst-case performance of O(n), which can occur in unbalanced binary search trees.

---

## **Disadvantages**:
- **Complex Implementation**: The balancing requires complex rotations (left and right) after insertions and deletions, making it more complicated to implement compared to simple binary search trees.
- **Performance Overhead**: The balancing operations (rotations) introduce additional overhead during insertions and deletions, though they still maintain O(log n) time complexity.
- **Extra Space**: The height of each node needs to be stored, which requires additional space.

---

## **Operations in a Height-Balanced Binary Tree (AVL Tree)**:

1. **Insert**:
    - When a new node is inserted, the tree checks whether it becomes unbalanced (i.e., the balance factor is greater than 1 or less than -1).
    - If unbalanced, rotations (left or right) are performed to restore balance.

2. **Delete**:
    - When a node is deleted, the tree checks whether the deletion causes the tree to become unbalanced.
    - Similar to insertions, rotations are performed to rebalance the tree.

3. **Search**:
    - Standard binary search is performed on the tree, with the height-balance property ensuring that the time complexity remains O(log n).

---

## **Balancing Techniques (Rotations)**:

To maintain the height balance, **rotations** are used. There are four types of rotations:

1. **Right Rotation** (Single Rotation)
2. **Left Rotation** (Single Rotation)
3. **Left-Right Rotation** (Double Rotation)
4. **Right-Left Rotation** (Double Rotation)

These rotations are used to re-balance the tree whenever an imbalance occurs after insertion or deletion.

---

## **Height-Balanced Trees by Default**:

There are several types of trees that are height-balanced by default:

### 1. **AVL Tree**:
- A self-balancing binary search tree where the difference between the heights of the left and right subtrees is at most 1.

### 2. **Red-Black Tree**:
- A type of binary search tree where each node has a color (red or black). It guarantees that the tree remains balanced by enforcing a set of balancing rules.

### 3. **Splay Tree**:
- A binary search tree that automatically performs rotations to bring the most recently accessed node to the root. While it is not strictly balanced, it has a logarithmic amortized time complexity for operations.

### 4. **Weight-Balanced Trees**:
- A type of tree where the balance is maintained based on the weight (size) of the subtrees, instead of the height. These trees also maintain O(log n) time complexity for operations.

---

## **Example**:

- A tree where the balance factor is checked after every insertion/deletion:

    - If balance factor > 1, perform a **right rotation**.
    - If balance factor < -1, perform a **left rotation**.
    - If balance factor == 2, check for left-right imbalance and perform a double rotation.
    - If balance factor == -2, check for right-left imbalance and perform a double rotation.

---

## 6. Skewed Binary Tree

---

## **Definition**:
A **Skewed Binary Tree** is a type of binary tree where all the nodes are skewed to one side, either left or right. This means that each node in the tree has only one child (either left or right). Skewed trees are essentially a degenerate form of binary trees, resembling a linked list, either in a left-skewed or right-skewed manner.

- **Left-Skewed Tree**: Every node only has a left child.
- **Right-Skewed Tree**: Every node only has a right child.

---

## **Time Complexity**:

- **Search**: O(n), where `n` is the number of nodes, because the tree degenerates into a linked list and searching requires traversing all nodes sequentially.
- **Insert**: O(n), as the insertion will need to traverse the tree to find the appropriate position, which could be as long as the height of the tree.
- **Delete**: O(n), since deleting a node might require traversing the entire tree to find the node, and adjusting the tree structure after removal.

---

## **Space Complexity**:
- **Space**: O(n), where `n` is the number of nodes, because each node stores a reference to either its left or right child (depending on whether it’s left-skewed or right-skewed). The space complexity is proportional to the number of nodes.

---

## **Advantages**:
- **Simple to Implement**: Skewed binary trees are straightforward to implement and do not require complex balancing logic.
- **Memory Efficiency**: The structure is simple, with each node storing only one child pointer (either left or right).
- **Easy Traversal**: Insertion and deletion are easy to conceptualize since there is only one child to deal with at each node.

---

## **Disadvantages**:
- **Inefficient Operations**: Since the tree behaves like a linked list, operations such as search, insert, and delete all have O(n) time complexity in the worst case, which is inefficient compared to balanced binary trees.
- **No Balanced Structure**: The tree does not provide efficient search or other operations, which can result in poor performance if the tree becomes large.
- **Unbalanced**: As there is no balancing mechanism, the skewed binary tree can become severely unbalanced, making operations slow.

---

## **Example**:

- **Left-Skewed Tree**:
    - All nodes have only a left child, forming a structure like a linked list.

---

## 7. Ordered Binary Tree / Binary Search Tree (BST)

---

## **Definition**:
An **Ordered Binary Tree** (also known as a **Binary Search Tree (BST)**) is a binary tree in which the nodes are ordered in a specific manner: for each node, the value of all the nodes in its left subtree is less than the node’s value, and the value of all the nodes in its right subtree is greater than the node’s value. This property ensures that in-order traversal of the tree will give the nodes in sorted order.

---

## **Time Complexity**:

- **Search**: O(log n) on average, but O(n) in the worst case if the tree becomes unbalanced (degenerates into a linked list).
- **Insert**: O(log n) on average, but O(n) in the worst case.
- **Delete**: O(log n) on average, but O(n) in the worst case.

Where `n` is the number of nodes in the tree.

---

## **Space Complexity**:
- **Space**: O(n), where `n` is the number of nodes, as each node stores information like a left and right child pointer.

---

## **Advantages**:
- **Efficient Search**: The ordered property allows for fast searching (O(log n) on average) since you can navigate the tree based on the value comparisons.
- **Efficient Insertion and Deletion**: New nodes can be added and removed efficiently by following the ordering rules, making operations like insertions and deletions faster than in unstructured trees.
- **In-Order Traversal**: Traversing the tree in in-order provides the nodes in a sorted manner, which is useful in applications that require sorted data.

---

## **Disadvantages**:
- **Unbalanced Tree**: If the tree becomes unbalanced (e.g., by inserting nodes in a sorted or reverse-sorted order), it may degrade to a linked list, resulting in O(n) time complexity for search, insert, and delete operations.
- **Requires Balancing**: To maintain efficient performance, ordered binary trees require balancing mechanisms (e.g., AVL, Red-Black Tree) to avoid degenerating into a linked list.
- **Not Optimal for Range Queries**: While search is fast, an ordered binary tree is not the best choice for range queries unless it is balanced.

---

## **Example**:

- **Ordered Binary Tree** (BST):

---

## 8. **AVL Tree**
- **Definition**: An AVL tree (Adelson-Velsky and Landis Tree) is a self-balancing binary search tree where the height difference between the left and right subtrees of any node is at most 1.

### **Time Complexity:**
- **Search, Insert, Delete**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Provides O(log n) time complexity for search, insertion, and deletion.
- Automatically balances itself after every insertion or deletion.

### **Disadvantages:**
- More complex to implement than a regular BST.
- Requires rebalancing after every insert/delete operation, which may impact performance in some cases.

---

## 9. **Red-Black Tree**
- **Definition**: A red-black tree is a type of self-balancing binary search tree with extra properties for balancing: nodes are either red or black, and specific rules govern their arrangement.

### **Time Complexity:**
- **Search, Insert, Delete**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Guarantees O(log n) time complexity for search, insert, and delete operations.
- Easier to implement than AVL trees, though still self-balancing.

### **Disadvantages:**
- Slightly more complex than unbalanced BSTs.
- Balancing involves multiple operations, which can add overhead.

---

## 10. **Heap (Binary Heap)**
- **Definition**: A heap is a binary tree that satisfies the heap property: in a max-heap, the value of each node is greater than or equal to its children; in a min-heap, the value of each node is less than or equal to its children.

### **Time Complexity:**
- **Insert**: O(log n)
- **Delete**: O(log n)
- **Find Min/Max**: O(1)
- **Space Complexity**: O(n)

### **Advantages:**
- Efficient O(log n) insertions and deletions (especially for priority queues).
- Supports fast retrieval of the maximum (max-heap) or minimum (min-heap).

### **Disadvantages:**
- Not suitable for general searching; retrieving arbitrary elements takes O(n) time.
- Not balanced like a BST.

---

## 11. **Trie (Prefix Tree)**
- **Definition**: A trie is a tree used to store a dynamic set of strings where the keys are usually strings. Each node represents a character, and the path from root to node represents a prefix.

### **Time Complexity:**
- **Insert, Search**: O(k), where `k` is the length of the string.
- **Space Complexity**: O(k * n), where `n` is the number of words.

### **Advantages:**
- Efficient searching for words or prefixes (O(k) time, where k is the length of the word).
- Ideal for autocomplete and spell-checking applications.

### **Disadvantages:**
- Can consume a lot of memory (especially if the tree is sparse).
- Can be slower than hash tables for some operations.

---

## 12. **B-Tree**
- **Definition**: A B-tree is a self-balancing search tree used in databases and file systems. It is optimized for systems that read and write large blocks of data and maintains sorted data while allowing searches, insertions, deletions, and sequential access.

### **Time Complexity:**
- **Search, Insert, Delete**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Efficient for large datasets as it minimizes disk access.
- Balanced and guarantees O(log n) time complexity for operations.

### **Disadvantages:**
- More complex structure compared to binary trees.
- Can require extra memory for storing additional child pointers.

---

## 13. **B+ Tree**
- **Definition**: A B+ tree is an extension of the B-tree where only the leaf nodes contain data and the internal nodes are used for indexing. It is widely used in databases for indexing.

### **Time Complexity:**
- **Search, Insert, Delete**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Efficient in databases for indexing as it keeps data in the leaf nodes.
- Supports range queries efficiently (all leaf nodes are linked).

### **Disadvantages:**
- Requires additional space for storing only data in leaf nodes.
- Insertions and deletions can be more complex due to rebalancing.

---

## 14. **N-ary Tree**
- **Definition**: An N-ary tree is a tree in which each node can have up to N children. It is a generalization of the binary tree.

### **Time Complexity:**
- **Search**: O(n) (in the worst case, linear search)
- **Space Complexity**: O(n)

### **Advantages:**
- Suitable for representing hierarchical structures with more than two children (like file systems).

### **Disadvantages:**
- Can be more complex to manage than binary trees.
- Searching may be slower compared to binary search trees.

---

## 15. **Segment Tree**
- **Definition**: A segment tree is a binary tree used for storing intervals or segments. It allows efficient querying and updating of intervals, such as finding the sum or minimum in a range.

### **Time Complexity:**
- **Build Tree**: O(n)
- **Query**: O(log n)
- **Update**: O(log n)
- **Space Complexity**: O(4n)

### **Advantages:**
- Efficient range queries and updates (O(log n) time).
- Useful in problems like range minimum query (RMQ), range sum query, etc.

### **Disadvantages:**
- Requires extra memory (O(4n) space).
- More complex than simple trees.

---

## 16. **Fenwick Tree (Binary Indexed Tree)**
- **Definition**: A Fenwick tree is a data structure that supports efficient cumulative frequency tables and range sum queries. It allows for efficient updates and queries in logarithmic time.

### **Time Complexity:**
- **Update, Query**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Efficient for range sum queries and point updates (O(log n) time).
- Compact in memory.

### **Disadvantages:**
- Does not support range queries like Segment Tree.
- Complex to implement and understand.

---

## 17. **Merkle Tree**
- **Definition**: A Merkle tree is a tree where each leaf node contains a hash of data and each non-leaf node contains a hash of its children. Merkle trees are used in blockchain technology to verify the integrity of data.

### **Time Complexity:**
- **Build**: O(n)
- **Verify**: O(log n)
- **Space Complexity**: O(n)

### **Advantages:**
- Provides integrity verification through hashing.
- Efficient for distributed systems and blockchain technology.

### **Disadvantages:**
- Not suitable for general-purpose use outside of cryptographic applications.
- Extra computational overhead for hashing.

---


# Properties

- **Perfect Binary tree**: height = h, total nodes = 2^(h+1) - 1
- 
