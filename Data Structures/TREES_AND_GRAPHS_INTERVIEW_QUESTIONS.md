# 🎯 Trees & Graphs — Frequently Asked Interview Questions

> **Covers: Easy → Medium → Hard | Trees, BST, Graphs, Advanced Topics**
>
> *Perfect for last-minute revision and deep-dive preparation*

---

## 📑 Table of Contents

| Section | Topic | Difficulty |
|---------|-------|------------|
| [T1](#t1-basic-tree-concepts) | Basic Tree Concepts | 🟢 Easy |
| [T2](#t2-traversal-variants) | Traversal Variants | 🟢 Easy |
| [T3](#t3-tree-properties) | Tree Properties | 🟢 Easy |
| [T4](#t4-height-and-depth) | Height and Depth | 🟢 Easy |
| [T5](#t5-bst-fundamentals) | BST Fundamentals | 🟡 Easy–Medium |
| [T6](#t6-bst-operations) | BST Operations | 🟡 Medium |
| [T7](#t7-bst-edge-cases) | BST Edge Cases | 🟡 Medium |
| [T8](#t8-bst-advanced) | BST Advanced | 🟠 Medium–Hard |
| [T9](#quick-reference-card) | Quick Reference Card | 📋 Reference |
| [G1](#g1-graph-fundamentals) | Graph Fundamentals | 🟢 Easy |
| [G2](#g2-bfs-and-dfs) | BFS and DFS | 🟡 Easy–Medium |
| [G3](#g3-graph-variants) | Graph Variants | 🟡 Medium |
| [G4](#g4-graph-problems) | Graph Problems | 🟠 Medium |
| [G5](#g5-shortest-paths) | Shortest Paths | 🔴 Hard |
| [G6](#g6-minimum-spanning-trees) | Minimum Spanning Trees | 🔴 Hard |
| [G7](#g7-strongly-connected-components) | Strongly Connected Components | 🔴 Hard |
| [G8](#g8-graph-hard-problems) | Graph Hard Problems | 🔴 Hard |
| [G9](#g9-graph-specialized-algorithms) | Graph Specialized Algorithms | 🔴 Hard |
| [Cross-Topic](#cross-topic-questions) | Cross-Topic Questions | 🔴 Hard |
| [Cheat Sheet](#algorithm-cheat-sheet) | Algorithm Cheat Sheet | 📋 Reference |

---

<br>
<br>
<br>

---

## T1: Basic Tree Concepts

> **Difficulty:** 🟢 Easy
> **Focus:** Foundational understanding of tree data structures

---

### Q1: What is a tree? How does it differ from a graph?

<br>

**Answer:**

A **tree** is a special type of graph that satisfies three key properties:

1. **Connected:** There is exactly one path between any two nodes.
2. **Acyclic:** It contains no cycles or loops.
3. **Has a root:** There is exactly one node with no parent (the root), and all other nodes have exactly one parent.

**Key Differences Between Tree and Graph:**

| Property | Tree | Graph |
|----------|------|-------|
| Cycles | ❌ No cycles allowed | ✅ Cycles allowed |
| Connectivity | Must be connected | Can be disconnected |
| Root | Exactly one root | No concept of root |
| Edges | Exactly `N-1` edges for N nodes | Can have 0 to N(N-1) edges |
| Path between nodes | Exactly one unique path | Multiple paths possible |

**Mathematical Property:**
For a tree with `N` nodes, there are exactly `N - 1` edges. This is a defining characteristic — if a graph has N nodes and N-1 edges and is connected, it must be a tree.

**Real-world Examples:**
- File system directories
- Organization charts
- HTML DOM structure
- Decision trees in machine learning

---

<br>

### Q2: What is the difference between a binary tree and a general tree?

<br>

**Answer:**

**Binary Tree:**
- Each node has **at most 2 children** (commonly called left and right child).
- Children are typically distinguished as "left" and "right."
- Enables efficient search operations when structured as a BST.
- Maximum nodes at level `L` = `2^L`.

**General Tree (N-ary Tree):**
- Each node can have **any number of children** (0, 1, 2, 3, ...).
- No left/right distinction — children are stored in a list.
- More flexible for representing hierarchical data like file systems.
- Common variants: Trie (26-ary for alphabets), B-Tree (m-ary for databases).

**Comparison Table:**

| Aspect | Binary Tree | General Tree |
|--------|-------------|--------------|
| Max children per node | 2 | Unlimited |
| Storage per node | 2 pointers | List/array of pointers |
| Traversal methods | 4 standard traversals | BFS + DFS variants |
| Common use cases | BST, Expression trees | File systems, Tries |
| Memory overhead | Lower | Higher (dynamic lists) |

**Why Binary Trees Are Popular:**
1. Simpler implementation and analysis
2. Enable O(log n) search with BST property
3. Balance algorithms (AVL, Red-Black) are well-understood
4. Natural fit for divide-and-conquer algorithms

---

<br>

### Q3: Define root, leaf, parent, child, sibling, depth, and height.

<br>

**Answer:**

These are the fundamental terminologies used when working with trees:

**Visual Example:**
```
        1 (Root, Depth=0, Height=2)
       / \
      2   3 (Siblings, Depth=1)
     / \   \
    4   5   6 (Leaves, Depth=2)
```

| Term | Definition | Example |
|------|------------|---------|
| **Root** | The topmost node with no parent | Node 1 |
| **Leaf** | A node with no children (external node) | Nodes 4, 5, 6 |
| **Parent** | The immediate ancestor of a node | Node 2 is parent of 4, 5 |
| **Child** | A node directly below another | Nodes 4, 5 are children of 2 |
| **Sibling** | Nodes sharing the same parent | Nodes 2 and 3 are siblings |
| **Depth** | Number of edges from root to the node | Depth of node 4 = 2 |
| **Height** | Number of edges on the longest path from node to a leaf | Height of root = 2 |

**Important Formulas:**

- **Depth of root** = 0 (or 1 depending on convention)
- **Height of leaf** = 0
- **Height of tree** = Height of root node = Maximum depth of any node
- **Level of a node** = Depth + 1 (root is at level 1)

**Relationship:**
```
Height(node) = 1 + max(Height(left child), Height(right child))
Depth(node) = Depth(parent) + 1
```

---

<br>

### Q4: What is a full binary tree, complete binary tree, and perfect binary tree?

<br>

**Answer:**

These are special types of binary trees with specific structural properties:

**1. Full Binary Tree (Strictly Binary Tree):**
- Every node has **either 0 or 2 children**.
- No node has exactly one child.

```
      1          ✅ Full Binary Tree
     / \
    2   3
   / \
  4   5
```

**Properties:**
- Number of leaves = Number of internal nodes + 1
- Total nodes always odd

**2. Complete Binary Tree:**
- All levels are **completely filled** except possibly the last level.
- The last level has nodes filled **from left to right**.
- This is the structure used for binary heaps.

```
      1          ✅ Complete Binary Tree
     / \
    2   3
   / \  /
  4  5 6
```

**Properties:**
- Height = ⌊log₂(n)⌋
- Used in heap data structures
- Array representation is compact (no gaps)

**3. Perfect Binary Tree:**
- All internal nodes have **exactly 2 children**.
- All leaves are at the **same level**.
- This is both full AND complete.

```
      1          ✅ Perfect Binary Tree
     / \
    2   3
   / \ / \
  4  5 6  7
```

**Properties:**
- Number of nodes = 2^(h+1) - 1 where h = height
- Number of leaves = 2^h
- All perfect binary trees are full and complete

**Comparison Table:**

| Property | Full | Complete | Perfect |
|----------|------|----------|---------|
| Every node has 0 or 2 children | ✅ Required | ❌ Not required | ✅ Required |
| All levels full except last | ❌ Not required | ✅ Required | ✅ Required |
| Last level left-filled | ❌ Not required | ✅ Required | ✅ Required |
| All leaves at same level | ❌ Not required | ❌ Not required | ✅ Required |

---

<br>

### Q5: What is a skewed binary tree? What is its worst-case time complexity?

<br>

**Answer:**

A **skewed binary tree** is a degenerate tree where each parent has only one child, making it essentially a **linked list**.

**Types of Skewed Trees:**

**Left-Skewed:**
```
1
 \
  2
   \
    3
     \
      4
```

**Right-Skewed:**
```
        1
       /
      2
     /
    3
   /
  4
```

**Why It's Problematic:**

| Operation | Balanced Tree | Skewed Tree |
|-----------|--------------|-------------|
| Search | O(log n) | **O(n)** |
| Insert | O(log n) | **O(n)** |
| Delete | O(log n) | **O(n)** |
| Height | O(log n) | **O(n)** |

**Causes of Skewed Trees:**

1. **Inserting sorted data into BST** — Most common cause
2. **Deleting nodes improperly** — Without rebalancing
3. **No self-balancing mechanism** — Using plain BST

**How to Prevent Skewing:**

1. **Self-balancing trees:** AVL Trees, Red-Black Trees
2. **Randomized insertion:** Insert elements in random order
3. **Tree rotations:** Maintain balance during operations
4. **Use B-Trees/B+ Trees:** For database applications

**Interview Tip:** Always mention that skewed trees defeat the purpose of binary search trees, and self-balancing trees solve this problem.

---

<br>

### Q6: How many edges does a tree with N nodes have? Why?

<br>

**Answer:**

A tree with **N nodes** has exactly **N - 1 edges**.

**Mathematical Proof:**

**Method 1: By Construction**
- Start with 1 node, 0 edges.
- To add a new node, we must add exactly 1 edge (to connect it to the existing tree).
- Adding N-1 more nodes requires N-1 more edges.
- Total edges = N - 1.

**Method 2: By Induction**
- **Base case:** A tree with 1 node has 0 edges. ✓
- **Inductive step:** Assume a tree with k nodes has k-1 edges.
  - Adding a new node requires exactly 1 new edge (otherwise we'd create a cycle or disconnect the tree).
  - A tree with k+1 nodes has (k-1) + 1 = k edges. ✓

**Why This Matters:**

1. **Cycle Detection:** If a graph has N nodes and ≥ N edges, it must have a cycle.
2. **Connectivity Check:** If a graph has N nodes and < N-1 edges, it cannot be connected.
3. **Tree Validation:** A connected graph with N nodes and N-1 edges is a tree.

**Related Properties:**

| Property | Formula |
|----------|---------|
| Minimum edges for connectivity | N - 1 |
| Maximum edges without cycles | N - 1 |
| Edges in a tree | Exactly N - 1 |

**Practical Application:**
In Union-Find (DSU), we know we've built an MST when we've added exactly N-1 edges.

---

<br>

### Q7: What is the maximum number of nodes at level L in a binary tree?

<br>

**Answer:**

The maximum number of nodes at level `L` in a binary tree is **2^L** (where root is at level 0).

**Explanation:**

- **Level 0 (Root):** 2^0 = 1 node
- **Level 1:** 2^1 = 2 nodes
- **Level 2:** 2^2 = 4 nodes
- **Level 3:** 2^3 = 8 nodes
- **Level L:** 2^L nodes

**Visual Representation:**
```
Level 0:          1 node (2^0)
                /     \
Level 1:      2         3     → 2 nodes (2^1)
             / \       / \
Level 2:    4   5     6   7   → 4 nodes (2^2)
           / \ / \   / \ / \
Level 3:  8 9 10 11 12 13 14 15 → 8 nodes (2^3)
```

**Total Nodes in a Perfect Binary Tree:**

For a tree of height `h` (where height of single node = 0):

```
Total nodes = 2^0 + 2^1 + 2^2 + ... + 2^h
            = 2^(h+1) - 1
```

**Important Formulas:**

| What | Formula |
|------|---------|
| Max nodes at level L | 2^L |
| Total nodes in perfect tree of height h | 2^(h+1) - 1 |
| Min height for n nodes | ⌈log₂(n+1)⌉ - 1 |
| Max height for n nodes | n - 1 (skewed) |
| Leaves in perfect tree of height h | 2^h |

**Memory Calculation Example:**
If a tree has 10 levels (level 0-9), the last level alone can have 2^9 = 512 nodes.

---

<br>
<br>
<br>

---

## T2: Traversal Variants

> **Difficulty:** 🟢 Easy
> **Focus:** Mastering tree traversal techniques

---

### Q1: Explain all four binary tree traversal methods with their use cases.

<br>

**Answer:**

Tree traversal means visiting every node exactly once. There are **four main traversal methods**:

---

**1. Preorder Traversal (Root → Left → Right)**

**Order:** Visit root first, then left subtree, then right subtree.

```
    1          Preorder: 1 → 2 → 4 → 5 → 3 → 6 → 7
   / \
  2   3
 / \ / \
4  5 6  7
```

**Use Cases:**
- Creating a copy of the tree
- Prefix expression evaluation
- Serializing a tree
- Finding the first node in certain searches

**Code:**
```java
public void preorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.data + " "); // Process root
    preorder(root.left);                // Process left
    preorder(root.right);               // Process right
}
```

---

**2. Inorder Traversal (Left → Root → Right)**

**Order:** Visit left subtree, then root, then right subtree.

**Critical Property:** For a BST, inorder traversal produces **sorted output**.

```
    4          Inorder: 2 → 4 → 5 → 1 → 3 → 6 → 7
   / \         (Not sorted because this isn't a BST)
  2   1
   \ / \
   5 3  7
      \
       6
```

**For BST:**
```
    5          Inorder: 2 → 4 → 5 → 6 → 8 → 10 (Sorted!)
   / \
  4   8
 /   / \
2   6   10
```

**Use Cases:**
- Getting sorted elements from BST
- Infix expression evaluation
- Validating BST property
- Finding kth smallest/largest in BST

**Code:**
```java
public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);                 // Process left
    System.out.print(root.data + " "); // Process root
    inorder(root.right);                // Process right
}
```

---

**3. Postorder Traversal (Left → Right → Root)**

**Order:** Visit left subtree, then right subtree, then root.

```
    1          Postorder: 4 → 5 → 2 → 6 → 7 → 3 → 1
   / \
  2   3
 / \ / \
4  5 6  7
```

**Use Cases:**
- Deleting a tree (delete children before parent)
- Postfix expression evaluation
- Calculating directory sizes (files before folders)
- Bottom-up dynamic programming on trees

**Code:**
```java
public void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);               // Process left
    postorder(root.right);              // Process right
    System.out.print(root.data + " "); // Process root
}
```

---

**4. Level Order Traversal (BFS)**

**Order:** Visit nodes level by level, left to right within each level.

```
    1          Level Order: 1 → 2 → 3 → 4 → 5 → 6 → 7
   / \         (Level 0, then Level 1, then Level 2)
  2   3
 / \ / \
4  5 6  7
```

**Use Cases:**
- Finding the right/left view of tree
- Level-by-level processing
- Finding shortest path in unweighted tree
- Serializing tree compactly

**Code:**
```java
public void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.data + " ");
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}
```

---

**Comparison Table:**

| Traversal | Order | Time | Space (recursive) | Space (iterative) |
|-----------|-------|------|-------------------|-------------------|
| Preorder | Root-Left-Right | O(n) | O(h) | O(h) |
| Inorder | Left-Root-Right | O(n) | O(h) | O(h) |
| Postorder | Left-Right-Root | O(n) | O(h) | O(h) |
| Level Order | BFS | O(n) | O(w) | O(w) |

Where h = height, w = maximum width of tree.

---

<br>

### Q2: Given preorder and inorder traversals, can you reconstruct the tree? How?

<br>

**Answer:**

**Yes!** A binary tree can be uniquely reconstructed from its preorder and inorder traversals.

**Why It Works:**

1. **Preorder** tells us the root: The first element is always the root.
2. **Inorder** tells us the structure: Elements left of the root form the left subtree, elements right form the right subtree.

**Step-by-Step Example:**

```
Preorder: [3, 9, 20, 15, 7]
Inorder:  [9, 3, 15, 20, 7]

Step 1: First element of preorder = 3 is the root
Step 2: Find 3 in inorder: [9] | 3 | [15, 20, 7]
        Left subtree inorder: [9]
        Right subtree inorder: [15, 20, 7]

Step 3: Left subtree preorder: [9] (1 element after root)
        Right subtree preorder: [20, 15, 7]

Step 4: Recursively build left and right subtrees
```

**Final Tree:**
```
    3
   / \
  9  20
     / \
    15  7
```

**Algorithm:**

```java
class Solution {
    private int preIdx = 0;
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build hashmap for O(1) lookup in inorder array
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Root is the next element in preorder
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        // Find position of root in inorder
        int inIdx = inMap.get(rootVal);

        // Build left subtree first (important: preorder processes left before right)
        root.left = build(preorder, inStart, inIdx - 1);
        root.right = build(preorder, inIdx + 1, inEnd);

        return root;
    }
}
```

**Time Complexity:** O(n) — we visit each node exactly once.

**Space Complexity:** O(n) — for the hashmap and recursion stack.

**Important Note:** The order matters! We must process left subtree before right because preorder gives left subtree nodes first.

---

<br>

### Q3: Can you reconstruct a binary tree from preorder and postorder traversals alone?

<br>

**Answer:**

**Not uniquely** for general binary trees, but **yes** for full binary trees.

**Why It Doesn't Work for General Trees:**

Consider these two different trees with the same preorder and postorder:

```
Tree 1:          Tree 2:
    1               1
   /                 \
  2                   2

Preorder:  [1, 2]     Preorder:  [1, 2]
Postorder: [2, 1]     Postorder: [2, 1]
```

Both trees have identical preorder and postorder, but they're structurally different!

**Why It Works for Full Binary Trees:**

In a full binary tree, every node has either 0 or 2 children. This removes the ambiguity:

- When a node has 2 children, preorder and postorder together can distinguish left from right.
- When a node has 0 children (leaf), there's no ambiguity.

**Algorithm for Full Binary Trees:**

```java
class Solution {
    private int preIdx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, postorder, postMap, 0, postorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] post, Map<Integer, Integer> postMap,
                          int postStart, int postEnd) {
        if (postStart > postEnd) return null;

        TreeNode root = new TreeNode(pre[preIdx++]);

        if (postStart == postEnd) return root; // Leaf node

        // Find the left child in postorder to determine boundary
        int leftChildIdx = postMap.get(pre[preIdx]);

        root.left = build(pre, post, postMap, postStart, leftChildIdx);
        root.right = build(pre, post, postMap, leftChildIdx + 1, postEnd - 1);

        return root;
    }
}
```

**Summary Table:**

| Traversal Pair | Unique Reconstruction? |
|----------------|------------------------|
| Preorder + Inorder | ✅ Always |
| Postorder + Inorder | ✅ Always |
| Preorder + Postorder | ❌ General trees |
| Preorder + Postorder | ✅ Full binary trees |
| Level Order + Inorder | ✅ Always |

---

<br>

### Q4: Implement iterative (non-recursive) inorder and preorder traversals.

<br>

**Answer:**

Iterative traversals use an explicit **stack** to simulate the recursion.

---

**Iterative Inorder (Left → Root → Right):**

**Algorithm:**
1. Go as left as possible, pushing nodes to stack.
2. When you can't go left anymore, pop from stack and process.
3. Move to the right child and repeat.

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        // Go as left as possible
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        // Process the node
        curr = stack.pop();
        result.add(curr.data);

        // Move to right subtree
        curr = curr.right;
    }

    return result;
}
```

**Visual Walkthrough:**
```
    4
   / \
  2   6
 / \ / \
1  3 5  7

Stack evolution: [4] → [4,2] → [4,2,1]
Pop 1, result: [1], go right (null)
Pop 2, result: [1,2], go right (3)
Push 3, stack: [4,3]
Pop 3, result: [1,2,3], go right (null)
Pop 4, result: [1,2,3,4], go right (6)
... and so on
```

---

**Iterative Preorder (Root → Left → Right):**

**Algorithm:**
1. Process root first, push it to stack.
2. Pop and process, push right child first, then left child.
3. This ensures left is processed before right.

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.data);

        // Push right first, then left (so left is processed first)
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }

    return result;
}
```

**Alternative (Uniform approach):**
```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            result.add(curr.data);  // Process before going left
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        curr = curr.right;
    }

    return result;
}
```

---

**Iterative Postorder (Left → Right → Root):**

Postorder is trickier. Here's an elegant approach using two stacks:

```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);

    while (!stack1.isEmpty()) {
        TreeNode node = stack1.pop();
        stack2.push(node);

        if (node.left != null) stack1.push(node.left);
        if (node.right != null) stack1.push(node.right);
    }

    while (!stack2.isEmpty()) {
        result.add(stack2.pop().data);
    }

    return result;
}
```

**Time Complexity:** O(n) for all traversals.

**Space Complexity:** O(h) where h is the height of the tree.

---

<br>

### Q5: What is Morris Traversal and how does it achieve O(1) space?

<br>

**Answer:**

**Morris Traversal** is a clever technique that achieves **O(1) space complexity** for tree traversal by temporarily modifying the tree structure using **threaded binary tree** concepts.

**Key Idea:**

Instead of using a stack or recursion to remember where to go back, we create temporary links (threads) from a node's predecessor back to the node itself. After using the thread, we remove it to restore the original tree structure.

---

**Morris Inorder Traversal:**

**Algorithm:**
1. If current node has no left child, process it and go right.
2. If current node has a left child:
   - Find its inorder predecessor (rightmost node in left subtree).
   - If predecessor's right is null, create a thread to current node.
   - If predecessor's right is current (thread exists), remove it, process current, go right.
3. Repeat until all nodes processed.

```java
public List<Integer> morrisInorder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null) {
        if (curr.left == null) {
            // No left child, process and go right
            result.add(curr.data);
            curr = curr.right;
        } else {
            // Find inorder predecessor
            TreeNode predecessor = curr.left;
            while (predecessor.right != null && predecessor.right != curr) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                // Create thread
                predecessor.right = curr;
                curr = curr.left;
            } else {
                // Thread exists, remove it
                predecessor.right = null;
                result.add(curr.data);
                curr = curr.right;
            }
        }
    }

    return result;
}
```

---

**Visual Example:**

```
Original Tree:         During Traversal:
      4                      4
     / \                    / \
    2   6                  2   6
   / \                    / \
  1   3                  1   3
   \                      \
    → (thread to 2)        → (thread removed after processing)

When at node 2:
1. Find predecessor (node 1's rightmost = node 1)
2. Create thread: 1 → 2
3. Go left to node 1
4. Process 1, follow thread back to 2
5. Remove thread, process 2, go to 3
```

---

**Morris Preorder Traversal:**

Same as inorder, but process the node when creating the thread:

```java
public List<Integer> morrisPreorder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null) {
        if (curr.left == null) {
            result.add(curr.data);
            curr = curr.right;
        } else {
            TreeNode predecessor = curr.left;
            while (predecessor.right != null && predecessor.right != curr) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                result.add(curr.data);  // Process before going left
                predecessor.right = curr;
                curr = curr.left;
            } else {
                predecessor.right = null;
                curr = curr.right;
            }
        }
    }

    return result;
}
```

---

**Comparison:**

| Method | Time | Space | Modifies Tree? |
|--------|------|-------|----------------|
| Recursive | O(n) | O(h) | No |
| Iterative (Stack) | O(n) | O(h) | No |
| Morris | O(n) | **O(1)** | Temporarily |

**When to Use Morris Traversal:**
- Space is extremely constrained
- Tree is very deep (stack overflow risk)
- Need to process huge trees in memory-constrained environments

**Note:** The tree is restored to its original state after traversal.

---

<br>

### Q6: What is the difference between level order traversal and BFS?

<br>

**Answer:**

**Short Answer:** Level order traversal IS BFS applied to trees. They are the same algorithm with different names depending on context.

---

**Detailed Explanation:**

**BFS (Breadth-First Search):**
- A general graph traversal algorithm
- Explores all neighbors before moving to the next level
- Uses a queue (FIFO) data structure
- Works on any graph (including trees)

**Level Order Traversal:**
- The same BFS algorithm applied specifically to trees
- Visits nodes level by level (root level first, then level 1, etc.)
- The "level" concept is natural in trees but not in general graphs
- The term is used exclusively in tree contexts

---

**Side-by-Side Comparison:**

| Aspect | BFS | Level Order |
|--------|-----|-------------|
| Data Structure | Queue | Queue |
| Application | Any graph | Only trees |
| Level concept | Not always meaningful | Core concept |
| Shortest path | Finds shortest path in unweighted graphs | Finds shortest path in unweighted trees |
| Time Complexity | O(V + E) | O(n) where n = nodes |
| Space Complexity | O(V) | O(w) where w = max width |

---

**Code Comparison:**

**BFS on General Graph:**
```java
public void bfs(int start, List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```

**Level Order on Tree:**
```java
public void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.data + " ");

        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}
```

**Key Differences in Code:**
- BFS needs a `visited` array (graphs can have cycles)
- Level order doesn't need `visited` (trees have no cycles)
- BFS iterates over adjacency list; level order accesses left/right directly

---

<br>

### Q7: Given a level order traversal array, can you construct a complete binary tree?

<br>

**Answer:**

**Yes!** For a complete binary tree, we can directly map array indices to tree positions.

**Index Mapping Formula:**

For a node at index `i` in the array:
- **Left child** is at index `2i + 1`
- **Right child** is at index `2i + 2`
- **Parent** is at index `(i - 1) / 2`

---

**Why It Works:**

A complete binary tree is filled left-to-right without gaps. This creates a perfect mapping:

```
Array: [1, 2, 3, 4, 5, 6, 7]

Tree:       1 (index 0)
           / \
          2   3 (indices 1, 2)
         / \ / \
        4  5 6  7 (indices 3, 4, 5, 6)

Left child of 2 (index 1) = index 2*1+1 = 3 → Node 4 ✓
Right child of 2 (index 1) = index 2*1+2 = 4 → Node 5 ✓
```

---

**Implementation:**

```java
public TreeNode buildFromLevelOrder(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) {
        return null;
    }

    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    int i = 1;
    while (!queue.isEmpty() && i < arr.length) {
        TreeNode node = queue.poll();

        // Add left child
        if (i < arr.length && arr[i] != null) {
            node.left = new TreeNode(arr[i]);
            queue.add(node.left);
        }
        i++;

        // Add right child
        if (i < arr.length && arr[i] != null) {
            node.right = new TreeNode(arr[i]);
            queue.add(node.right);
        }
        i++;
    }

    return root;
}
```

---

**Handling Null Values:**

For non-complete trees, we use `null` markers:

```java
Integer[] arr = {1, 2, 3, null, null, 4, 5};

Tree:       1
           / \
          2   3
             / \
            4   5
```

---

**Comparison with Other Constructions:**

| Input | Tree Type | Algorithm |
|-------|-----------|-----------|
| Level order array | Complete tree | Direct index mapping O(n) |
| Level order with nulls | Any tree | BFS construction O(n) |
| Preorder + Inorder | Any tree | Recursive O(n) |
| Preorder only | BST | Direct insertion O(n log n) |

**Note:** This is the same representation used for **binary heaps** in array form!

---

<br>
<br>
<br>

---

## T3: Tree Properties

> **Difficulty:** 🟢 Easy
> **Focus:** Understanding and computing tree properties

---

### Q1: What is the maximum and minimum height of a binary tree with N nodes?

<br>

**Answer:**

**Maximum Height:** `N - 1`

This occurs in a **skewed tree** (essentially a linked list).

```
Example: N = 4, Height = 3

1
 \
  2
   \
    3
     \
      4
```

**Minimum Height:** `⌊log₂(N)⌋`

This occurs in a **complete/perfect binary tree**.

```
Example: N = 7, Height = 2 (⌊log₂(7)⌋ = 2)

        1
       / \
      2   3
     / \ / \
    4  5 6  7
```

---

**Detailed Analysis:**

| N nodes | Min Height (⌊log₂ N⌋) | Max Height (N-1) |
|---------|----------------------|------------------|
| 1 | 0 | 0 |
| 2 | 1 | 1 |
| 3 | 1 | 2 |
| 4 | 2 | 3 |
| 7 | 2 | 6 |
| 8 | 3 | 7 |
| 15 | 3 | 14 |
| 100 | 6 | 99 |
| 1000 | 9 | 999 |
| 10000 | 13 | 9999 |

**Key Insight:**

For a tree with `N` nodes:
- **Best case (balanced):** Height = O(log N) → Operations are fast
- **Worst case (skewed):** Height = O(N) → Operations degrade

This is why **self-balancing trees** (AVL, Red-Black) are important — they maintain O(log N) height.

---

**Formula Derivation:**

For minimum height:
```
A perfect tree of height h has 2^(h+1) - 1 nodes.

So for N nodes:
2^h ≤ N < 2^(h+1)
h ≤ log₂(N)
h = ⌊log₂(N)⌋
```

For maximum height:
```
Each level has exactly 1 node.
Height = N - 1 edges.
```

---

<br>

### Q2: How do you count the number of leaf nodes in a binary tree?

<br>

**Answer:**

A **leaf node** is a node with no children (both left and right are null).

**Recursive Approach:**

```java
public int countLeaves(TreeNode root) {
    // Base case: empty tree
    if (root == null) {
        return 0;
    }

    // If this is a leaf node
    if (root.left == null && root.right == null) {
        return 1;
    }

    // Recursively count leaves in both subtrees
    return countLeaves(root.left) + countLeaves(root.right);
}
```

---

**Iterative Approach (BFS):**

```java
public int countLeaves(TreeNode root) {
    if (root == null) return 0;

    int count = 0;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();

        // Check if leaf
        if (node.left == null && node.right == null) {
            count++;
        }

        // Add children to queue
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }

    return count;
}
```

---

**Example:**

```
        1
       / \
      2   3
     / \   \
    4   5   6

Leaves: 4, 5, 6 → Count = 3
```

**Time Complexity:** O(n) — visit every node once.

**Space Complexity:** O(h) recursive, O(w) iterative (w = max width).

---

**Related Problems:**

| Problem | Approach |
|---------|----------|
| Count all nodes | Return 1 + count(left) + count(right) |
| Count internal nodes | Total nodes - leaf nodes |
| Count nodes with one child | Check if exactly one child is null |
| Count full nodes | Check if both children exist |

---

<br>

### Q3: How do you check if two trees are mirrors of each other?

<br>

**Answer:**

Two trees are **mirrors** if:
1. Both are null (empty trees are mirrors)
2. Both non-null with data equal, and:
   - Left subtree of tree1 equals right subtree of tree2
   - Right subtree of tree1 equals left subtree of tree2

---

**Recursive Solution:**

```java
public boolean isMirror(TreeNode a, TreeNode b) {
    // Both null → mirrors
    if (a == null && b == null) {
        return true;
    }

    // One null, one not → not mirrors
    if (a == null || b == null) {
        return false;
    }

    // Check data and recursively check swapped children
    return (a.data == b.data)
        && isMirror(a.left, b.right)
        && isMirror(a.right, b.left);
}
```

---

**Iterative Solution (using BFS):**

```java
public boolean isMirror(TreeNode a, TreeNode b) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(a);
    queue.add(b);

    while (!queue.isEmpty()) {
        TreeNode node1 = queue.poll();
        TreeNode node2 = queue.poll();

        if (node1 == null && node2 == null) continue;
        if (node1 == null || node2 == null) return false;
        if (node1.data != node2.data) return false;

        // Add children in mirror order
        queue.add(node1.left);
        queue.add(node2.right);
        queue.add(node1.right);
        queue.add(node2.left);
    }

    return true;
}
```

---

**Visual Example:**

```
Tree A:        Tree B (Mirror):
    1              1
   / \            / \
  2   3          3   2
 / \            / \
4   5          5   4

A.left (2,4,5) is mirror of B.right (2,5,4) ✓
A.right (3) is mirror of B.left (3) ✓
```

**Application:** Checking if a tree is symmetric is checking if left and right subtrees are mirrors.

---

<br>

### Q4: What is a uni-value tree? How do you count uni-value subtrees?

<br>

**Answer:**

A **uni-value tree** (or univalue tree) is a tree where all nodes have the same value.

A **uni-value subtree** is a subtree where all nodes have the same value.

---

**Example:**

```
        5
       / \
      4   5
     / \   \
    4   4   5

Uni-value subtrees:
- [4] (leaf) → 1
- [4] (leaf) → 1
- [4,4,4] (subtree rooted at 4) → 1
- [5] (leaf) → 1
- [5,5,5] (subtree rooted at 5) → 1

Total: 5 uni-value subtrees
```

---

**Algorithm:**

We need to check from bottom-up:
1. Check if left subtree is uni-value
2. Check if right subtree is uni-value
3. Check if current node matches children's values

```java
class Solution {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }

    private boolean isUnival(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);

        // If either subtree is not unival, this can't be unival
        if (!left || !right) {
            return false;
        }

        // Check if children match current value
        if (node.left != null && node.left.data != node.data) {
            return false;
        }
        if (node.right != null && node.right.data != node.data) {
            return false;
        }

        // This is a unival subtree
        count++;
        return true;
    }
}
```

---

**Time Complexity:** O(n) — each node visited once.

**Space Complexity:** O(h) — recursion stack.

---

**Alternative Approach (returning value):**

```java
class Solution {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    // Returns the unival value if valid, or a special marker if not
    private Integer helper(TreeNode node) {
        if (node == null) {
            return null;  // Empty is unival
        }

        Integer left = helper(node.left);
        Integer right = helper(node.right);

        // Determine if current subtree is unival
        Integer val = node.data;

        if (left != null && !left.equals(val)) return null;
        if (right != null && !right.equals(val)) return null;

        count++;
        return val;
    }
}
```

---

<br>
<br>
<br>

---

## T4: Height and Depth

> **Difficulty:** 🟢 Easy
> **Focus:** Computing and understanding height/depth in trees

---

### Q1: How do you find the height of a binary tree?

<br>

**Answer:**

**Height** of a node is the number of edges on the longest path from that node to a leaf.

**Height of tree = Height of root node.**

---

**Recursive Formula:**
```
height(node) = 1 + max(height(left), height(right))
height(null) = -1  (empty tree has height -1)
height(leaf) = 0   (single node has height 0)
```

---

**Recursive Implementation:**

```java
public int height(TreeNode root) {
    // Empty tree has height -1 (convention)
    // Alternatively, return 0 for empty tree (height = number of nodes)
    if (root == null) {
        return -1;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return 1 + Math.max(leftHeight, rightHeight);
}
```

---

**Iterative Implementation (Level Order):**

```java
public int height(TreeNode root) {
    if (root == null) return -1;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int height = -1;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        height++;  // Increment for each level

        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    return height;
}
```

---

**Visual Example:**

```
        1           Height = 2
       / \
      2   3         Height of node 2 = 1
     / \            Height of node 3 = 1
    4   5           Height of nodes 4,5,6 = 0 (leaves)
       /
      6

height(1) = 1 + max(height(2), height(3))
          = 1 + max(1, 1)
          = 2
```

---

**Time Complexity:** O(n)

**Space Complexity:** O(h) recursive, O(w) iterative

---

**Note on Convention:**
- Some define height as number of edges: height(leaf) = 0
- Others define height as number of nodes: height(leaf) = 1
- Always clarify with interviewer which convention to use!

---

<br>

### Q2: Given a binary tree, find the minimum depth (shortest root-to-leaf path).

<br>

**Answer:**

**Minimum depth** is the number of nodes on the shortest path from root to the nearest leaf node.

**Important:** It must be a path to a **leaf** (both children null), not just any null node.

---

**Key Difference from Maximum Depth:**

```
        1
       /
      2

Maximum depth = 2 (path: 1→2)
Minimum depth = 2 (only one leaf: node 2)

        1
         \
          2

Maximum depth = 2
Minimum depth = 2 (only one leaf)

        1
       / \
      2   3
     /
    4

Maximum depth = 3 (path: 1→2→4)
Minimum depth = 2 (path: 1→3)
```

---

**Recursive Solution:**

```java
public int minDepth(TreeNode root) {
    // Base case: empty tree
    if (root == null) {
        return 0;
    }

    // If leaf, depth is 1
    if (root.left == null && root.right == null) {
        return 1;
    }

    // If only one child exists, use that child's depth
    if (root.left == null) {
        return 1 + minDepth(root.right);
    }
    if (root.right == null) {
        return 1 + minDepth(root.left);
    }

    // Both children exist, take minimum
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}
```

---

**BFS Solution (More Efficient):**

BFS is better because we can stop at the first leaf found!

```java
public int minDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int depth = 1;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();

        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();

            // Found the first leaf!
            if (node.left == null && node.right == null) {
                return depth;
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        depth++;
    }

    return depth;
}
```

---

**Why BFS is Better:**

| Approach | Best Case | Worst Case | Space |
|----------|-----------|------------|-------|
| Recursive DFS | O(n) | O(n) | O(h) |
| BFS | O(min depth) | O(n) | O(w) |

For a tree with only one leaf at depth n, DFS visits all nodes while BFS finds it immediately.

---

**Example Walkthrough:**

```
        1
       / \
      2   3
     /     \
    4       5
             \
              6

BFS Level 1: [1], depth=1, not leaf
BFS Level 2: [2, 3], depth=2, not leaves
BFS Level 3: [4, 5], depth=3
  - Node 4 is a leaf! Return 3

Minimum depth = 3 (path: 1→2→4)
```

---

<br>
<br>
<br>

---

## T5: BST Fundamentals

> **Difficulty:** 🟡 Easy–Medium
> **Focus:** Core BST concepts and properties

---

### Q1: What is a BST and what is its key property?

<br>

**Answer:**

A **Binary Search Tree (BST)** is a binary tree with a special ordering property that enables efficient searching.

**Key Property:**

For every node in a BST:
- All values in the **left subtree** are **less than** the node's value
- All values in the **right subtree** are **greater than** the node's value

```
        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13

Left subtree of 8: [1,3,4,6,7] - all < 8 ✓
Right subtree of 8: [10,13,14] - all > 8 ✓
```

---

**Important Characteristics:**

1. **Inorder traversal produces sorted output**
2. **No duplicates** typically allowed (varies by implementation)
3. **Left < Node < Right** property applies recursively

---

**Why BST is Powerful:**

| Operation | Array (unsorted) | Sorted Array | BST (balanced) |
|-----------|-----------------|--------------|----------------|
| Search | O(n) | O(log n) | O(log n) |
| Insert | O(1) | O(n) | O(log n) |
| Delete | O(n) | O(n) | O(log n) |
| Min/Max | O(n) | O(1) | O(log n) |
| Sorted output | O(n log n) | O(n) | O(n) |

BST provides a balanced trade-off: good at everything!

---

**BST vs Binary Heap:**

| Property | BST | Binary Heap |
|----------|-----|-------------|
| Ordering | Left < Root < Right | Parent > Children (max-heap) |
| Search | O(log n) | O(n) |
| Find min/max | O(log n) | O(1) for root |
| Sorted output | O(n) inorder | O(n log n) |

---

**Inorder = Sorted:**

```java
public void printSorted(TreeNode root) {
    if (root == null) return;
    printSorted(root.left);
    System.out.print(root.data + " ");  // Sorted order!
    printSorted(root.right);
}
```

For the example tree above: `1 3 4 6 7 8 10 13 14`

---

<br>

### Q2: What is the time complexity of BST operations?

<br>

**Answer:**

**Time Complexity Summary:**

| Operation | Average Case | Worst Case |
|-----------|-------------|------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Find Min | O(log n) | O(n) |
| Find Max | O(log n) | O(n) |
| Traversal | O(n) | O(n) |

---

**Why Average Case is O(log n):**

In a balanced BST, each comparison eliminates approximately half the remaining nodes (similar to binary search).

```
Search for 6 in this BST:
        8           → Compare with 8, go left
       / \
      3   10        → Compare with 3, go right
     / \    \
    1   6    14     → Compare with 6, found!
       / \   /
      4   7 13

Comparisons: 3 (≈ log₂ 9)
```

---

**Why Worst Case is O(n):**

If the tree becomes skewed (like a linked list), we might need to visit every node.

```
Skewed BST (inserted 1,2,3,4,5 in order):

1
 \
  2
   \
    3
     \
      4
       \
        5

Search for 5: 5 comparisons = O(n)
```

---

**Space Complexity:**

| Implementation | Space |
|---------------|-------|
| Recursive | O(h) call stack |
| Iterative | O(1) extra space |

Where h = height of tree.

---

**How to Guarantee O(log n):**

Use **self-balancing trees**:

| Tree Type | Balance Criterion | Rotation Cost |
|-----------|------------------|---------------|
| AVL Tree | Height diff ≤ 1 | O(log n) |
| Red-Black Tree | Color-based rules | O(1) amortized |
| B-Tree | All leaves same level | O(log n) |

---

**Practical Tips:**

1. Always ask if the BST is balanced in interviews
2. For sorted input, either randomize insertion or use self-balancing trees
3. If you need guaranteed O(log n), mention AVL or Red-Black trees

---

<br>

### Q3: Why is BST search O(log n) on average?

<br>

**Answer:**

BST search is O(log n) because each comparison cuts the search space roughly in half.

---

**Mathematical Analysis:**

In a balanced BST with n nodes:
- Level 0: 1 node (2^0)
- Level 1: 2 nodes (2^1)
- Level 2: 4 nodes (2^2)
- ...
- Level h: 2^h nodes

Total nodes: `n = 2^0 + 2^1 + ... + 2^h = 2^(h+1) - 1`

Solving for h: `h ≈ log₂(n)`

**Maximum comparisons = h + 1 = O(log n)**

---

**Visual Explanation:**

```
        8           Level 0: 1 node
       / \
      4   12        Level 1: 2 nodes
     / \  / \
    2  6 10 14      Level 2: 4 nodes
   /\  /\/\  /\
  1 3 5 7 9 11 13 15  Level 3: 8 nodes

Height = 3, Nodes = 15
log₂(15) ≈ 3.9 ≈ 4

Search for 7:
1. Compare with 8 → go left (eliminates right half)
2. Compare with 4 → go right (eliminates left half of remaining)
3. Compare with 6 → go right (eliminates left of remaining)
4. Compare with 7 → found!

4 comparisons = log₂(16) = 4
```

---

**Comparison with Other Search Methods:**

| Data Structure | Search | Why? |
|---------------|--------|------|
| Unsorted Array | O(n) | Must check every element |
| Sorted Array | O(log n) | Binary search, but insert is O(n) |
| Linked List | O(n) | Linear scan |
| **BST** | **O(log n)** | Halves search space each step |
| Hash Table | O(1) | Direct access, but no ordering |

---

**Key Insight:**

BST search is like playing "higher or lower" — each guess eliminates half the possibilities.

```
Guess a number between 1-100:
1. Is it 50? No, higher. (Eliminated 1-49)
2. Is it 75? No, lower. (Eliminated 76-100)
3. Is it 62? No, higher. (Eliminated 51-61)
...
≈ log₂(100) ≈ 7 guesses needed
```

---

<br>

### Q4: What is the kth smallest element in a BST? How do you find it efficiently?

<br>

**Answer:**

The **kth smallest element** in a BST is the kth element when all elements are sorted.

**Key Insight:** Inorder traversal of BST gives sorted order. The kth element in inorder traversal is the kth smallest!

---

**Approach 1: Recursive Inorder (O(n) time, O(h) space)**

```java
class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.data;
            return;
        }

        if (count < k) {
            inorder(node.right, k);
        }
    }
}
```

---

**Approach 2: Iterative Inorder (O(h + k) time, O(h) space)**

Better because we can stop early!

```java
public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();
        k--;

        if (k == 0) {
            return curr.data;
        }

        curr = curr.right;
    }

    return -1; // Not found
}
```

---

**Approach 3: Morris Traversal (O(n) time, O(1) space)**

```java
public int kthSmallest(TreeNode root, int k) {
    TreeNode curr = root;

    while (curr != null) {
        if (curr.left == null) {
            k--;
            if (k == 0) return curr.data;
            curr = curr.right;
        } else {
            TreeNode pred = curr.left;
            while (pred.right != null && pred.right != curr) {
                pred = pred.right;
            }

            if (pred.right == null) {
                pred.right = curr;
                curr = curr.left;
            } else {
                pred.right = null;
                k--;
                if (k == 0) return curr.data;
                curr = curr.right;
            }
        }
    }

    return -1;
}
```

---

**Optimization: Augmented BST**

If we store subtree size at each node, we can achieve O(h) time:

```java
class AugmentedTreeNode {
    int data;
    int leftSize;  // Number of nodes in left subtree
    AugmentedTreeNode left, right;
}

public int kthSmallest(AugmentedTreeNode root, int k) {
    if (root == null) return -1;

    if (root.leftSize == k - 1) {
        return root.data;
    } else if (root.leftSize > k - 1) {
        return kthSmallest(root.left, k);
    } else {
        return kthSmallest(root.right, k - root.leftSize - 1);
    }
}
```

---

**Time Complexity Comparison:**

| Method | Time | Space |
|--------|------|-------|
| Recursive Inorder | O(n) | O(h) |
| Iterative Inorder | O(h + k) | O(h) |
| Morris Traversal | O(n) | O(1) |
| Augmented BST | O(h) | O(n) setup |

---

<br>
<br>
<br>

---

## T6: BST Operations

> **Difficulty:** 🟡 Medium
> **Focus:** Core BST manipulation techniques

---

### Q1: How do you insert into a BST? Iterative vs Recursive approach.

<br>

**Answer:**

**Insertion Rule:**
- Compare value with current node
- If smaller, go left
- If larger, go right
- When you reach null, insert there

---

**Recursive Approach:**

```java
public TreeNode insert(TreeNode root, int val) {
    // Base case: found the insertion point
    if (root == null) {
        return new TreeNode(val);
    }

    // Recursive cases
    if (val < root.data) {
        root.left = insert(root.left, val);
    } else if (val > root.data) {
        root.right = insert(root.right, val);
    }
    // If val == root.data, do nothing (no duplicates)

    return root;
}
```

**How It Works:**
```
Insert 5 into:    8
                   / \
                  3   10

1. 5 < 8, go left
2. 5 > 3, go right
3. 3.right is null, insert 5 there

Result:           8
                 / \
                3   10
                 \
                  5
```

---

**Iterative Approach:**

```java
public TreeNode insert(TreeNode root, int val) {
    // Edge case: empty tree
    if (root == null) {
        return new TreeNode(val);
    }

    TreeNode curr = root;
    while (true) {
        if (val < curr.data) {
            if (curr.left == null) {
                curr.left = new TreeNode(val);
                break;
            }
            curr = curr.left;
        } else if (val > curr.data) {
            if (curr.right == null) {
                curr.right = new TreeNode(val);
                break;
            }
            curr = curr.right;
        } else {
            // Duplicate, don't insert
            break;
        }
    }

    return root;
}
```

---

**Comparison:**

| Aspect | Recursive | Iterative |
|--------|-----------|-----------|
| Code clarity | More intuitive | More explicit |
| Space | O(h) call stack | O(1) |
| Risk | Stack overflow for deep trees | No overflow risk |
| Performance | Slight overhead | Slightly faster |

---

**Handling Duplicates:**

Three common strategies:

1. **Ignore duplicates:** (shown above)
2. **Store count:** Each node has a `count` field
3. **Insert to one side:** Always insert duplicates to left (or right)

```java
// Option 2: Store count
class TreeNode {
    int data;
    int count = 1;  // Number of occurrences
    TreeNode left, right;
}

public TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);

    if (val < root.data) {
        root.left = insert(root.left, val);
    } else if (val > root.data) {
        root.right = insert(root.right, val);
    } else {
        root.count++;  // Duplicate found
    }

    return root;
}
```

---

<br>

### Q2: How do you delete a node from a BST? Cover all 3 cases.

<br>

**Answer:**

BST deletion has **three cases** based on the number of children the node has.

---

**Case 1: Node is a Leaf (no children)**

Simply remove the node by returning null to parent.

```
Delete 4:
        5              5
       / \            / \
      3   7    →     3   7
     /              /
    4              null
```

---

**Case 2: Node has One Child**

Replace the node with its child.

```
Delete 3:
        5              5
       / \            / \
      3   7    →     4   7
       \
        4
```

---

**Case 3: Node has Two Children**

Find either:
- **Inorder successor:** Smallest node in right subtree
- **Inorder predecessor:** Largest node in left subtree

Replace the node's value with successor/predecessor, then delete that successor/predecessor.

```
Delete 5:
        5              6 (inorder successor)
       / \            / \
      3   7    →     3   7
     / \   \        / \   \
    2   4   8      2   4   8

Step 1: Find inorder successor of 5 = 6 (leftmost in right subtree)
Step 2: Replace 5's value with 6
Step 3: Delete the original 6 from right subtree
```

---

**Complete Implementation:**

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // Search for the node
    if (key < root.data) {
        root.left = deleteNode(root.left, key);
    } else if (key > root.data) {
        root.right = deleteNode(root.right, key);
    } else {
        // Found the node to delete

        // Case 1 & 2: Node has 0 or 1 child
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // Case 3: Node has two children
        // Find inorder successor (smallest in right subtree)
        TreeNode successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }

        // Replace with successor's value
        root.data = successor.data;

        // Delete the successor from right subtree
        root.right = deleteNode(root.right, successor.data);
    }

    return root;
}
```

---

**Using Inorder Predecessor Instead:**

```java
// Find predecessor (largest in left subtree)
TreeNode predecessor = root.left;
while (predecessor.right != null) {
    predecessor = predecessor.right;
}

root.data = predecessor.data;
root.left = deleteNode(root.left, predecessor.data);
```

---

**Time Complexity:** O(h) where h = height of tree.

**Space Complexity:** O(h) for recursion stack.

---

**Summary Table:**

| Case | Children | Action |
|------|----------|--------|
| Leaf | 0 | Return null |
| One child | 1 | Return the child |
| Two children | 2 | Replace with successor/predecessor |

---

<br>

### Q3: What is the inorder successor of a node in a BST?

<br>

**Answer:**

The **inorder successor** of a node is the node that comes immediately after it in the inorder traversal (i.e., the next larger value).

---

**Two Cases:**

**Case 1: Node has a right subtree**

The successor is the **leftmost (minimum) node** in the right subtree.

```
Successor of 5:
        5
         \
          7
         /
        6       ← Inorder successor (leftmost in right subtree)

Inorder: ... 5, 6, 7, ...
```

**Case 2: Node has no right subtree**

The successor is the **lowest ancestor** where the node is in the left subtree.

```
Successor of 4:
        5       ← Inorder successor (ancestor where 4 is in left subtree)
       /
      3
       \
        4

Inorder: 3, 4, 5, ...
```

---

**Implementation:**

```java
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    // Case 1: Has right subtree
    if (p.right != null) {
        TreeNode node = p.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Case 2: No right subtree, find ancestor
    TreeNode successor = null;
    while (root != null) {
        if (p.data < root.data) {
            successor = root;  // Potential successor
            root = root.left;
        } else {
            root = root.right;
        }
    }

    return successor;
}
```

---

**Visual Example:**

```
        20
       /  \
      8    22
     / \
    4   12
       /  \
      10   14

Node 8 has right subtree → Successor = 10 (leftmost in right)
Node 10 has no right subtree → Successor = 12 (ancestor)
Node 14 has no right subtree → Successor = 20 (ancestor)
Node 22 has no right subtree → Successor = null (no successor)
```

---

**Time Complexity:** O(h)

**Space Complexity:** O(1) iterative, O(h) recursive

---

<br>

### Q4: How do you find the minimum and maximum in a BST?

<br>

**Answer:**

In a BST:
- **Minimum** is the **leftmost** node
- **Maximum** is the **rightmost** node

---

**Implementation:**

```java
// Find minimum (leftmost node)
public int findMin(TreeNode root) {
    if (root == null) {
        throw new IllegalArgumentException("Tree is empty");
    }

    while (root.left != null) {
        root = root.left;
    }

    return root.data;
}

// Find maximum (rightmost node)
public int findMax(TreeNode root) {
    if (root == null) {
        throw new IllegalArgumentException("Tree is empty");
    }

    while (root.right != null) {
        root = root.right;
    }

    return root.data;
}
```

---

**Visual:**

```
        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13

Minimum: Go left as far as possible → 1
Maximum: Go right as far as possible → 14
```

---

**Recursive Version:**

```java
public int findMin(TreeNode root) {
    if (root == null) throw new IllegalArgumentException("Empty tree");
    return root.left == null ? root.data : findMin(root.left);
}

public int findMax(TreeNode root) {
    if (root == null) throw new IllegalArgumentException("Empty tree");
    return root.right == null ? root.data : findMax(root.right);
}
```

---

**Time Complexity:** O(h) — height of tree

**Space Complexity:** O(1) iterative, O(h) recursive

---

**Comparison with Other Structures:**

| Data Structure | Find Min | Find Max |
|---------------|----------|----------|
| Unsorted Array | O(n) | O(n) |
| Sorted Array | O(1) | O(1) |
| BST | O(h) | O(h) |
| Min-Heap | O(1) | O(n) |
| Max-Heap | O(n) | O(1) |

---

<br>
<br>
<br>

---

## T7: BST Edge Cases

> **Difficulty:** 🟡 Medium
> **Focus:** Handling tricky BST scenarios

---

### Q1: How do you validate that a binary tree is a valid BST? Why is the naive approach wrong?

<br>

**Answer:**

**Naive (Wrong) Approach:**

Just checking `left.data < node.data < right.data` is **insufficient**.

```java
// WRONG APPROACH
public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    if (root.left != null && root.left.data >= root.data) return false;
    if (root.right != null && root.right.data <= root.data) return false;

    return isValidBST(root.left) && isValidBST(root.right);
}
```

**Why It Fails:**

Consider this tree:
```
        10
       /  \
      5    15
          /  \
         6    20   ← 6 is in right subtree of 10, but 6 < 10!
```

The naive approach passes because:
- 5 < 10 < 15 ✓
- 6 < 15 < 20 ✓

But it's **NOT a valid BST** because 6 is in 10's right subtree yet 6 < 10.

---

**Correct Approach: Range Validation**

Pass down the valid range (min, max) for each node.

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // Node must be within valid range
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Left subtree must be < node.data
        // Right subtree must be > node.data
        return validate(node.left, min, node.data)
            && validate(node.right, node.data, max);
    }
}
```

**Why Long.MIN_VALUE/MAX_VALUE?**
To handle edge cases where node values are Integer.MIN_VALUE or Integer.MAX_VALUE.

---

**How It Works:**

```
        10
       /  \
      5    15
          /  \
         6    20

validate(10, -∞, +∞)
  validate(5, -∞, 10) → ✓
  validate(15, 10, +∞)
    validate(6, 10, 15) → FAIL! 6 <= 10
```

---

**Alternative: Inorder Traversal**

If inorder traversal produces strictly increasing sequence, it's a BST.

```java
class Solution {
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        if (!inorder(node.left)) return false;

        if (prev != null && node.data <= prev) return false;
        prev = node.data;

        return inorder(node.right);
    }
}
```

---

**Iterative Version:**

```java
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Integer prev = null;
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();

        if (prev != null && curr.data <= prev) {
            return false;
        }
        prev = curr.data;

        curr = curr.right;
    }

    return true;
}
```

---

**Complexity:**

| Approach | Time | Space |
|----------|------|-------|
| Range validation | O(n) | O(h) |
| Inorder traversal | O(n) | O(h) |

---

<br>

### Q2: How do you find the floor and ceiling of a value in a BST?

<br>

**Answer:**

- **Floor:** Largest value ≤ target
- **Ceiling:** Smallest value ≥ target

---

**Floor Implementation:**

```java
public Integer floor(TreeNode root, int target) {
    Integer result = null;

    while (root != null) {
        if (root.data == target) {
            return target;
        }

        if (root.data > target) {
            // Current is too large, go left
            root = root.left;
        } else {
            // Current is smaller than target, this could be floor
            result = root.data;
            root = root.right;
        }
    }

    return result;
}
```

---

**Ceiling Implementation:**

```java
public Integer ceiling(TreeNode root, int target) {
    Integer result = null;

    while (root != null) {
        if (root.data == target) {
            return target;
        }

        if (root.data < target) {
            // Current is too small, go right
            root = root.right;
        } else {
            // Current is larger than target, this could be ceiling
            result = root.data;
            root = root.left;
        }
    }

    return result;
}
```

---

**Example:**

```
BST:
        8
       / \
      4   12
     / \  / \
    2  6 10 14

Target = 5
Floor = 4  (largest ≤ 5)
Ceiling = 6 (smallest ≥ 5)

Target = 6
Floor = 6
Ceiling = 6

Target = 15
Floor = 14
Ceiling = null (no value ≥ 15)

Target = 1
Floor = null (no value ≤ 1)
Ceiling = 2
```

---

**Time Complexity:** O(h)

**Space Complexity:** O(1)

---

<br>
<br>
<br>

---

## T8: BST Advanced

> **Difficulty:** 🟠 Medium–Hard
> **Focus:** Advanced BST transformations and operations

---

### Q1: How do you convert a sorted array to a balanced BST?

<br>

**Answer:**

To create a **balanced BST** from a sorted array, always pick the **middle element** as the root.

---

**Algorithm:**
1. Find middle of array → make it root
2. Recursively build left subtree from left half
3. Recursively build right subtree from right half

```java
public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
}

private TreeNode build(int[] nums, int left, int right) {
    if (left > right) return null;

    int mid = left + (right - left) / 2;

    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, left, mid - 1);
    root.right = build(nums, mid + 1, right);

    return root;
}
```

---

**Visual Example:**

```
Array: [1, 2, 3, 4, 5, 6, 7]

Step 1: mid = 3, root = 4
Array: [1,2,3] 4 [5,6,7]

Step 2: Left subtree
mid = 1, root.left = 2
[1] 2 [3]

Step 3: Right subtree
mid = 5, root.right = 6
[5] 6 [7]

Final BST:
        4
       / \
      2   6
     / \ / \
    1  3 5  7
```

---

**Time Complexity:** O(n)

**Space Complexity:** O(log n) recursion stack

---

<br>

### Q2: How do you serialize and deserialize a binary tree?

<br>

**Answer:**

**Serialization:** Convert tree to string
**Deserialization:** Reconstruct tree from string

---

**Approach: Preorder with null markers**

```java
public class Codec {
    private static final String NULL = "#";
    private static final String SEP = ",";

    // Serialize: preorder with null markers
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(node.data).append(SEP);
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserialize: use queue for preorder reconstruction
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(
            Arrays.asList(data.split(SEP))
        );
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals(NULL)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
}
```

---

**Example:**

```
Tree:
    1
   / \
  2   3
     / \
    4   5

Serialized: "1,2,#,#,3,4,#,#,5,#,#,"
```

---

**Time & Space:** O(n) for both operations

---

<br>

### Q3: How do you find the lowest common ancestor in a BST?

<br>

**Answer:**

In a BST, LCA can be found efficiently using the BST property.

**Key Insight:**
- If both values < root, LCA is in left subtree
- If both values > root, LCA is in right subtree
- Otherwise, root is the LCA

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (p.data < root.data && q.data < root.data) {
            root = root.left;
        } else if (p.data > root.data && q.data > root.data) {
            root = root.right;
        } else {
            return root;  // This is the LCA
        }
    }
    return null;
}
```

---

**Example:**

```
        6
       / \
      2   8
     / \ / \
    0  4 7  9
      / \
     3   5

LCA(2, 8) = 6  (both < 6 → no, both > 6 → no, so 6 is LCA)
LCA(2, 4) = 2  (both < 6 → go left; both > 2 → no, so 2 is LCA)
LCA(0, 5) = 2  (both < 6 → go left; 0 < 2, 5 > 2 → 2 is LCA)
```

---

**Time Complexity:** O(h)

**Space Complexity:** O(1)

---

<br>
<br>
<br>

---

## Quick Reference Card

| Topic | Key Algorithm | Time | Space |
|-------|--------------|------|-------|
| Tree Traversals | DFS (recursive) / Morris | O(n) | O(h) / O(1) |
| BST Search | Binary Search | O(log n) avg | O(1) iter |
| BST Insert | Recursive/Iterative | O(log n) avg | O(h) / O(1) |
| BST Delete | 3-case algorithm | O(log n) avg | O(h) |
| BST Validate | Range validation | O(n) | O(h) |
| Height of Tree | DFS | O(n) | O(h) |
| LCA (General Tree) | DFS | O(n) | O(h) |
| LCA (BST) | BST Property | O(log n) avg | O(1) |
| Serialize/Deserialize | Preorder + markers | O(n) | O(n) |

---

<br>
<br>
<br>

---

## G1: Graph Fundamentals

> **Difficulty:** 🟢 Easy
> **Focus:** Foundational understanding of graphs, representations, and basic concepts

---

### Q1: What is a graph? How does it differ from a tree?

<br>

**Answer:**

A **graph** is a fundamental data structure consisting of **vertices (nodes)** connected by **edges (arcs)**. Formally written as `G = (V, E)` where:
- **V** = Set of vertices
- **E** = Set of edges (pairs of vertices)

**Historical Context:**
Graph theory originated in 1736 when Euler solved the **Seven Bridges of Königsberg problem**, creating the foundation for modern computer science.

**Key Differences Between Tree and Graph:**

| Property | Tree | Graph |
|----------|------|-------|
| **Cycles** | ❌ No cycles | ✅ Can have cycles |
| **Connectivity** | Must be connected | Can be disconnected |
| **Root** | Exactly one root | No required root |
| **Edges** | N-1 for N nodes | 0 to N(N-1)/2 edges |
| **Path uniqueness** | Exactly one path between nodes | Multiple paths possible |
| **Acyclic** | Always acyclic | May contain cycles |
| **Hierarchy** | Hierarchical | No inherent hierarchy |

**Trees are Special Graphs:**
```
All trees are graphs, but not all graphs are trees.
A tree = Connected + Acyclic graph
```

**Real-World Graph Applications:**

| Application | Vertices | Edges |
|-------------|----------|-------|
| Social Networks | Users | Friendships/Follows |
| Web Pages | URLs | Hyperlinks |
| Road Networks | Cities | Roads |
| Molecule Structures | Atoms | Chemical Bonds |
| Computer Networks | Devices | Network Links |
| Call Graphs | Functions | Function Calls |
| Citation Networks | Papers | References |

**Mathematical Definition:**

- **Directed Graph (Digraph):** Edges have direction (ordered pairs): A → B
- **Undirected Graph:** Edges have no direction (unordered pairs): A — B
- **Weighted Graph:** Edges have weights/costs
- **Multigraph:** Multiple edges between same vertices allowed
- **Simple Graph:** No self-loops, no multiple edges

**Why Graphs Matter:**

Graphs generalize trees and add flexibility to model real-world relationships where hierarchy and single-parent constraints don't apply. They enable:
- Social network analysis
- Route optimization
- Dependency resolution
- Recommendation systems
- Web crawling and search

---

<br>

### Q2: What is the difference between adjacency matrix and adjacency list?

<br>

**Answer:**

These are two fundamental representations of graphs with different trade-offs.

**Adjacency Matrix:**

A 2D array where `matrix[i][j]` represents whether an edge exists between vertices i and j.

```java
// Undirected graph representation
int[][] adj = new int[n][n];
adj[0][1] = 1;  // Edge between 0 and 1
adj[1][0] = 1;  // Symmetric for undirected

// Weighted graph
int[][] adj = new int[n][n];
adj[0][1] = 5;  // Edge with weight 5

// Example: Graph with 4 vertices
    0 1 2 3
  0[0 1 0 1]
  1[1 0 1 0]
  2[0 1 0 1]
  3[1 0 1 0]
```

**Adjacency List:**

A map/array of lists where each vertex has a list of its adjacent vertices.

```java
// Unweighted graph
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
adj.get(0).add(1);  // Edge from 0 to 1
adj.get(1).add(0);  // Edge from 1 to 0 (for undirected)

// Weighted graph
List<List<int[]>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
adj.get(0).add(new int[]{1, 5});  // Edge 0→1 with weight 5

// Example: Same graph as above
0: [1, 3]
1: [0, 2]
2: [1, 3]
3: [0, 2]
```

**Comprehensive Comparison:**

| Aspect | Adjacency Matrix | Adjacency List |
|--------|------------------|----------------|
| **Space** | O(V²) | O(V + E) |
| **Edge lookup** | O(1) | O(degree) avg |
| **Add edge** | O(1) | O(1) avg |
| **Remove edge** | O(1) | O(degree) |
| **Find neighbors** | O(V) | O(degree) |
| **Iteration time** | O(V²) | O(V + E) |
| **Memory waste** | High for sparse | None |
| **Dense graphs** | Preferred | Not recommended |
| **Sparse graphs** | Wasteful | Preferred |
| **Implementation** | Simple | More complex |

**Decision Rule:**

```
If E ≈ V² (dense) → Use adjacency matrix
If E ≈ V (sparse) → Use adjacency list

Most real-world graphs are SPARSE → Use adjacency list!
```

**Example Scenario:**

```
Social network with 1M users:
- Edges in matrix: 1M × 1M = 1 trillion cells → 8TB (infeasible!)
- Using adjacency list: ~1M users × avg 500 friends = 500M entries → 2GB
```

**Complexity Analysis:**

| Operation | Matrix | List |
|-----------|--------|------|
| Traverse all edges | O(V²) | O(V+E) ✅ |
| Check if edge (u,v) exists | O(1) ✅ | O(degree) |
| Get all neighbors of u | O(V) | O(degree) ✅ |
| BFS/DFS | O(V²) | O(V+E) ✅ |

---

<br>

### Q3: What are in-degree and out-degree in a directed graph?

<br>

**Answer:**

These measure the connections of vertices in **directed graphs**.

**Definitions:**

- **In-degree of vertex v:** Number of edges pointing **TO** vertex v (incoming edges)
- **Out-degree of vertex v:** Number of edges pointing **FROM** vertex v (outgoing edges)
- **Total degree:** In-degree + Out-degree

**Visual Example:**

```
        1
       ↙ ↖
      2 → 3
      ↓   ↑
      4 ← 5

Vertex 1: in-degree=2 (from 2,3), out-degree=0
Vertex 2: in-degree=0, out-degree=2 (to 3,4)
Vertex 3: in-degree=2 (from 1,2), out-degree=1 (to 1)
Vertex 4: in-degree=1 (from 2), out-degree=1 (to 5)
Vertex 5: in-degree=1 (from 4), out-degree=1 (to 3)
```

**The Handshaking Lemma:**

For any directed graph:
```
Sum of all in-degrees = Sum of all out-degrees = Number of edges (E)
```

**Proof:**
Each edge contributes exactly 1 to one vertex's out-degree and 1 to one vertex's in-degree.

**Real-World Applications:**

| Concept | In-degree meaning | Out-degree meaning |
|---------|------|------|
| **Citation Network** | Times cited by others | Times cites others |
| **Social Media** | Number of followers | Number following |
| **Web Links** | Number of backlinks | Links to other pages |
| **Task Dependencies** | Tasks that must complete first | Tasks that depend on this |
| **Call Graph** | Functions calling this | Functions this calls |

**Computing In/Out Degrees:**

```java
// Build adjacency list
List<List<Integer>> adj = new ArrayList<>();

// Count out-degrees (easy - just list sizes)
int[] outDegree = new int[n];
for (int i = 0; i < n; i++) {
    outDegree[i] = adj.get(i).size();
}

// Count in-degrees (must traverse all edges)
int[] inDegree = new int[n];
for (int i = 0; i < n; i++) {
    for (int neighbor : adj.get(i)) {
        inDegree[neighbor]++;
    }
}
```

**Topological Sort Connection:**

In topological sorting, we start with vertices having **in-degree = 0** (no prerequisites).

```java
// Kahn's Algorithm uses in-degree
int[] indegree = new int[n];

// Count all indegrees first
for (int i = 0; i < n; i++) {
    for (int neighbor : adj.get(i)) {
        indegree[neighbor]++;
    }
}

// Start with vertices of indegree 0
Queue<Integer> queue = new ArrayDeque<>();
for (int i = 0; i < n; i++) {
    if (indegree[i] == 0) queue.add(i);
}
```

---

<br>

### Q4: What is a weighted vs unweighted graph? Java representations.

<br>

**Answer:**

**Unweighted Graph:**
- Edges have no associated cost or weight
- All edges are equivalent
- Used for: Social networks, basic connectivity, reachability

**Weighted Graph:**
- Edges have associated values (weights, costs, distances)
- Different edges have different importance
- Used for: Road networks (distance), communication (latency), transactions (cost)

**Unweighted Representation:**

```java
// Adjacency List (preferred for sparse graphs)
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) {
    adj.add(new ArrayList<>());
}
adj.get(0).add(1);  // Edge from 0 to 1
adj.get(1).add(2);  // Edge from 1 to 2

// Adjacency Matrix
int[][] adj = new int[n][n];
adj[0][1] = 1;  // Edge exists
adj[1][2] = 1;
```

**Weighted Representation:**

```java
// Adjacency List with int[] {neighbor, weight}
List<List<int[]>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) {
    adj.add(new ArrayList<>());
}
adj.get(0).add(new int[]{1, 5});   // Edge 0→1, weight=5
adj.get(1).add(new int[]{2, 3});   // Edge 1→2, weight=3

// Adjacency Matrix with weights
int[][] adj = new int[n][n];
adj[0][1] = 5;   // Weight from 0 to 1
adj[1][2] = 3;

// Using a custom Edge class (most readable)
class Edge {
    int to;
    int weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

List<List<Edge>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) {
    adj.add(new ArrayList<>());
}
adj.get(0).add(new Edge(1, 5));
adj.get(1).add(new Edge(2, 3));
```

**Working with Weighted Graphs - Dijkstra's Example:**

```java
public int[] dijkstra(int start, List<List<int[]>> adj, int n) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[]{0, start});  // {distance, node}

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int d = curr[0], node = curr[1];

        if (d > dist[node]) continue;

        // Access neighbors as int[] {neighbor, weight}
        for (int[] edge : adj.get(node)) {
            int neighbor = edge[0];
            int weight = edge[1];

            if (dist[node] + weight < dist[neighbor]) {
                dist[neighbor] = dist[node] + weight;
                pq.add(new int[]{dist[neighbor], neighbor});
            }
        }
    }

    return dist;
}
```

**Comparison:**

| Property | Unweighted | Weighted |
|----------|-----------|----------|
| **Storage** | Simple list | List with weights |
| **BFS** | Finds shortest path | ❌ Can't use |
| **Dijkstra** | O(V+E) | O((V+E)logV) |
| **Use case** | Social networks | Road maps, costs |
| **Interpretation** | Connection only | Strength/distance |

**Real-World Examples:**

```
Unweighted:
- Facebook: A connected to B (binary)
- Web graph: Page A links to Page B

Weighted:
- Google Maps: Distance in kilometers
- Flight booking: Price in dollars
- Network: Latency in milliseconds
- Molecule: Bond strength
```

---

<br>

### Q5: What is a graph cycle? How does it affect algorithms?

<br>

**Answer:**

A **cycle** is a path that starts and ends at the same vertex, with at least 3 vertices involved.

**Cycle vs Self-Loop vs Multi-Edge:**

```
Self-loop:       1 → 1  (edge from node to itself)
Not counted as cycle (typically requires ≥ 3 vertices)

Simple cycle:    1 → 2 → 3 → 1  (valid cycle)

Cycle with repeat: 1 → 2 → 1 → 3 → 1  (contains cycles)
```

**Types of Cycles:**

| Type | Definition | Example |
|------|-----------|---------|
| Simple Cycle | No vertex repeated | 1→2→3→1 |
| Positive Cycle | Sum of weights > 0 | Weights: 1,2,3 |
| Negative Cycle | Sum of weights < 0 | Weights: 1,-5,2 |
| Back Edge | Edge to ancestor in DFS | Indicates cycle |

**How Cycles Affect Algorithms:**

**1. Shortest Path Algorithms:**

```
Dijkstra:
- ❌ FAILS with negative cycles (infinite loop possible)
- ✅ Works fine with positive cycles

Bellman-Ford:
- ✅ Detects negative cycles
- ✅ Works with negative weights (no negative cycles)
```

**2. Topological Sort:**

```
- ❌ IMPOSSIBLE if graph has cycles
- ✅ Only works on DAGs (Directed Acyclic Graphs)

Why? Topological sort needs an ordering where all edges point forward.
Cycles prevent any such ordering.
```

**3. Graph Traversal:**

```
Without cycles (trees):
- ✅ Simple traversal, no visited tracking needed

With cycles:
- ❌ Would visit nodes infinitely without visited array
- ✅ Must track visited nodes

Example:
    1 → 2
    ↑   ↓
    4 ← 3

DFS without visited: 1→2→3→4→1→2→3→4→1... (infinite)
DFS with visited: 1→2→3→4 (stops, all visited)
```

**Cycle Detection Algorithms:**

**Undirected Graph - DFS with Parent:**

```java
public boolean hasCycle(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
    }

    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!visited[i] && hasCycleDFS(i, -1, adj, visited)) {
            return true;
        }
    }
    return false;
}

private boolean hasCycleDFS(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            if (hasCycleDFS(neighbor, node, adj, visited)) return true;
        } else if (neighbor != parent) {
            // Back edge found (not to parent) → cycle!
            return true;
        }
    }
    return false;
}
```

**Directed Graph - 3-Color DFS:**

```java
public boolean hasCycle(int n, List<List<Integer>> adj) {
    int[] color = new int[n];  // 0=WHITE, 1=GRAY, 2=BLACK
    for (int i = 0; i < n; i++) {
        if (color[i] == 0 && hasCycleDFS(i, adj, color)) {
            return true;
        }
    }
    return false;
}

private boolean hasCycleDFS(int node, List<List<Integer>> adj, int[] color) {
    color[node] = 1;  // GRAY - visiting
    for (int neighbor : adj.get(node)) {
        if (color[neighbor] == 1) {
            // Back edge to GRAY node → cycle!
            return true;
        }
        if (color[neighbor] == 0 && hasCycleDFS(neighbor, adj, color)) {
            return true;
        }
    }
    color[node] = 2;  // BLACK - done
    return false;
}
```

**Impact on Algorithm Selection:**

| Algorithm | Requires Acyclic? | Handling Cycles |
|-----------|------------------|----------------|
| BFS | ❌ No | Works fine with visited array |
| DFS | ❌ No | Works fine with visited array |
| Topological Sort | ✅ YES | Returns empty if cycle detected |
| Dijkstra | ❌ No | ❌ Fails with negative cycles |
| Bellman-Ford | ❌ No | ✅ Detects negative cycles |
| Dynamic Programming on Graphs | ✅ YES | Needs DAG |

---

<br>
<br>
<br>

---

## G2: BFS and DFS

> **Difficulty:** 🟡 Easy–Medium
> **Focus:** Core graph traversal techniques

---

### Q1: Explain BFS (Breadth-First Search). What data structure does it use and why?

**Answer:**

**BFS (Breadth-First Search)** explores all neighbors of the current node before moving deeper into the graph. It processes nodes in **level order** — visiting the starting node, then all its neighbors, then all their neighbors, and so on.

**Data Structure:** BFS uses a **Queue (FIFO - First In First Out)**

**Why a Queue?**
Because BFS needs to process nodes in the exact order they were discovered. The first node discovered must be processed first (FIFO ordering). A stack (LIFO) would give us DFS instead.

**Step-by-Step Process:**
1. Start with the source node, mark it visited, enqueue it
2. Dequeue a node, visit it
3. Enqueue all unvisited neighbors, mark them visited
4. Repeat until queue is empty

---

**Visualization:**

```
Graph:        BFS Traversal Order (starting from A):

    A         → Queue: [A]
   / \        → Visit A, add B,C → Queue: [B,C]
  B   C       → Visit B, add D,E → Queue: [C,D,E]
 / \   \     → Visit C, add F   → Queue: [D,E,F]
D   E   F    → Visit D, no new neighbors
             → Visit E, add G → Queue: [F,G]
             → Visit F → Queue: [G]
             → Visit G → Queue: []

Result: A → B → C → D → E → F → G
```

---

**Complete Implementation:**

```java
public void bfs(int start, List<List<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();
    
    queue.add(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();        // Dequeue
        System.out.print(node + " ");    // Process
        
        // Add all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```

**Time Complexity:** O(V + E) — each vertex and edge processed once

**Space Complexity:** O(V) — for visited array and queue

> 💡 **Why O(V + E)?** The visited array is processed once for each vertex (O(V)), and each edge is examined once from the adjacency list (O(E)).

---

**BFS Properties:**

| Property | Description |
|----------|-------------|
| **Completeness** | Guaranteed to find solution if one exists (if graph is finite) |
| **Optimality** | Finds shortest path in unweighted graphs |
| **Space** | Can require O(V) memory (wide graphs) |
| **Level-order** | Processes all nodes at distance k before k+1 |

---

### Q2: Explain DFS (Depth-First Search). How do recursive and iterative approaches differ?

**Answer:**

**DFS (Depth-First Search)** explores as far down one branch as possible before backtracking. It processes a node's children before moving to siblings.

**Data Structure:** DFS uses either:
- **Recursion** (implicit call stack)
- **Stack (explicit)** for iterative version

---

**Recursive DFS:**

```java
public void dfsRecursive(int node, List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    System.out.print(node + " ");
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfsRecursive(neighbor, adj, visited);
        }
    }
}
```

**How Recursive DFS Works:**

```
Call stack (implicit):
main: dfs(1)
  → dfs(2): visited[2]=true, print 2
    → dfs(4): visited[4]=true, print 4
      → no unvisited neighbors, return
    → dfs(5): visited[5]=true, print 5
      → no unvisited neighbors, return
  → dfs(3): visited[3]=true, print 3
    → dfs(6): visited[6]=true, print 6
    → no unvisited neighbors, return

Output: 1 2 4 5 3 6
```

---

**Iterative DFS:**

```java
public void dfsIterative(int start, List<List<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    
    stack.push(start);
    
    while (!stack.isEmpty()) {
        int node = stack.pop();
        
        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node + " ");
            
            // Push unvisited neighbors
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
```

---

**Key Differences:**

| Aspect | Recursive DFS | Iterative DFS |
|--------|--------------|---------------|
| **Data Structure** | Call stack (implicit) | Stack (explicit) |
| **Code Clarity** | More readable, natural | More verbose |
| **Stack Overflow** | Risk for deep graphs | No risk |
| **Control** | Harder to modify | Full control |
| **Memory** | O(depth) | O(depth) |
| **Traversal Order** | Left-to-right | Depends on push order |

**Important Note on Traversal Order:**

The iterative version may produce a different traversal order than the recursive version because the stack processes elements in reverse order of insertion:

```java
// For neighbors [2, 3, 5]:
// Recursive: processes 2, then 3, then 5
// Iterative: pushes 2, 3, 5 → pops 5, 3, 2 (reverse order)

// To match recursive order in iterative:
Collections.reverse(adj.get(node)); // or push in reverse order
for (int i = adj.get(node).size() - 1; i >= 0; i--) {
    stack.push(adj.get(node).get(i));
}
```

---

**DFS Variations:**

| Type | Description | Use Case |
|------|-------------|----------|
| **Pre-order DFS** | Process node before visiting children | Graph copying |
| **Post-order DFS** | Process node after visiting children | Topological sort |
| **Euler Tour** | Visit each edge twice | Tree problems |
| **Backtracking DFS** | Undo choices when backtracking | Maze solving |

---

### Q3: What is the difference between BFS and DFS in terms of memory and use-cases?

**Answer:**

| Aspect | BFS | DFS |
|--------|-----|-----|
| **Memory** | O(width) — queue holds all nodes at current level | O(depth) — stack holds nodes along current path |
| **Optimal?** | Finds shortest path in unweighted graphs | Does NOT find shortest path in weighted graphs |
| **Completeness** | Guaranteed to find if exists | Guaranteed to find if exists |
| **Space worst case** | O(V) — all vertices in queue at once | O(V) — all vertices on path |
| **Space best case** | O(V) — wide but shallow graphs | O(log V) — balanced trees |

**Memory Visualization:**

```
Wide Tree (Breadth):      Deep Tree (Depth):
       1                        1
     /   \                      \
    2     3                      2
   / \   / \                       \
  4   5 6   7                      3
                                     \
                                      4

BFS memory: O(4) at widest level   DFS memory: O(4) at deepest path
BFS: [4,5,6,7]                     DFS: [1,2,3,4]
```

---

**When to Use Each:**

| Scenario | Use BFS | Use DFS |
|----------|---------|---------|
| Shortest path (unweighted) | ✅ | ❌ |
| Shortest path (weighted) | ❌ | ❌ (use Dijkstra) |
| Level-order processing | ✅ | ❌ |
| Connected components | Either | Either |
| Cycle detection | ✅ | ✅ |
| Topological sort | ✅ (Kahn's) | ✅ |
| Path existence (yes/no) | ✅ | ✅ |
| Find ALL paths | ❌ | ✅ |
| Maze solving (backtracking) | ❌ | ✅ |
| Minimum steps in puzzle | ✅ | ❌ |

---

**Interview Tip:**
Always ask: "Do you need the shortest path?" If yes, use BFS. If you just need any path or to explore all possibilities, DFS is often simpler.

---

### Q4: How does BFS find the shortest path in an unweighted graph?

**Answer:**

BFS guarantees finding the shortest path in an **unweighted graph** (where all edges have equal weight).

**Algorithm:**
1. Start from source, distance to source = 0
2. For each neighbor, distance = parent's distance + 1
3. First time we reach a node, that distance is the shortest

---

**Implementation with Distance Tracking:**

```java
public int[] shortestPath(int start, List<List<Integer>> adj) {
    int n = adj.size();
    int[] dist = new int[n];
    Arrays.fill(dist, -1);  // -1 means unreachable
    
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    dist[start] = 0;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        for (int neighbor : adj.get(node)) {
            if (dist[neighbor] == -1) {
                dist[neighbor] = dist[node] + 1;
                queue.add(neighbor);
            }
        }
    }
    
    return dist;
}
```

---

**Why BFS Finds Shortest Path:**

The key insight is that BFS processes nodes **in order of their distance** from the source. When we first encounter a node at distance k, any other path to that node would have to go through nodes already at distance ≤ k, which have already been processed. So the distance we assign is indeed the minimum.

```
Visualization:
    1         dist=0
   / \
  2   3       dist=1
 /   / \
4   6   7     dist=2
 \
  5           dist=3

Node 5 is first reached via 1→3→6→5 (distance 3)
No shorter path exists because BFS explores in distance order.
```

---

**Path Reconstruction:**

```java
public int[] shortestPathWithParent(int start, int end, List<List<Integer>> adj) {
    int n = adj.size();
    int[] dist = new int[n];
    int[] parent = new int[n];
    Arrays.fill(dist, -1);
    Arrays.fill(parent, -1);
    
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    dist[start] = 0;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        if (node == end) break; // Early exit
        
        for (int neighbor : adj.get(node)) {
            if (dist[neighbor] == -1) {
                dist[neighbor] = dist[node] + 1;
                parent[neighbor] = node;
                queue.add(neighbor);
            }
        }
    }
    
    return new int[]{dist[end], /* use parent[] to reconstruct path */};
}
```

---

**Time & Space Complexity:**
- **Time:** O(V + E)
- **Space:** O(V)

> ⚠️ **BFS finds shortest path only in unweighted graphs!** For weighted graphs, Dijkstra's algorithm is needed.

---

### Q5: How does DFS find if a path exists between two nodes?

**Answer:**

DFS explores as deep as possible first, and can determine if a path exists by performing a complete search.

**Approach:**
1. Start DFS from source node
2. If we reach the target during DFS, return true
3. If DFS completes without finding target, return false

---

**Implementation:**

```java
public boolean hasPathDFS(int node, int target,
                           List<List<Integer>> adj, boolean[] visited) {
    if (node == target) return true;  // Found!
    
    visited[node] = true;
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            if (hasPathDFS(neighbor, target, adj, visited)) {
                return true;  // Propagate success up
            }
        }
    }
    
    return false;  // This path didn't work
}

// Wrapper
public boolean hasPath(int start, int end, List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    return hasPathDFS(start, end, adj, visited);
}
```

---

**Iterative Version:**

```java
public boolean hasPathIterative(int start, int target, List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    Stack<Integer> stack = new Stack<>();
    
    stack.push(start);
    
    while (!stack.isEmpty()) {
        int node = stack.pop();
        
        if (node == target) return true;
        
        if (!visited[node]) {
            visited[node] = true;
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
    
    return false;
}
```

---

**Complexity:**
- **Time:** O(V + E) — may need to visit all nodes
- **Space:** O(V) — visited array + recursion stack

**Key Points:**
- DFS is better for **exploring all possibilities** (find ALL paths)
- DFS uses **less memory** than BFS for deep, narrow graphs
- DFS is used in **backtracking** algorithms

---

### Q6: How do you handle disconnected graphs in BFS/DFS?

**Answer:**

For **disconnected graphs**, run BFS/DFS from every unvisited node:

```java
public int connectedComponents(List<List<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];
    int components = 0;
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            bfs(i, adj, visited);  // Or dfs(i, adj, visited)
            components++;
        }
    }
    
    return components;
}
```

---

## G3: Graph Variants

> **Difficulty:** 🟡 Medium
> **Focus:** Special graph types and their unique properties

---

### Q1: What is a directed graph? Give a real-world example.

**Answer:**

A **directed graph** (digraph) has edges with direction — each edge goes from one vertex to another, but not necessarily back.

**Formal Definition:**
- Edges are **ordered pairs** (u, v) meaning u → v
- Edge (u, v) does NOT imply edge (v, u)
- Notation: G = (V, E) where E ⊆ V × V

---

**Real-World Examples:**

| Domain | Directed Graph Example |
|--------|----------------------|
| **Social Media** | Twitter: A follows B (one-way) |
| **Transportation** | One-way streets, flight routes |
| **Web** | Page A links to Page B (hyperlink) |
| **Dependencies** | Build system: A must compile before B |
| **Biology** | Food web: Predator → Prey |
| **Finance** | Payment transactions: A pays B |
| **Citation** | Paper A cites Paper B |
| **Computer Networks** | Data packet routing |

---

**Visual Example:**

```
Twitter Follow Graph:
  Alice → Bob      (Alice follows Bob, not vice versa)
    ↓     ↑
  Carol ←────── Bob also follows Alice, but Alice doesn't follow Carol
  
  Alice follows Bob and Carol
  Bob follows Alice
  Carol follows Alice
```

---

**Directed Graph Properties:**

```
For directed graph G = (V, E):

In-degree(v) = |{u : (u,v) ∈ E}|   // Edges INTO v
Out-degree(v) = |{u : (v,u) ∈ E}|  // Edges FROM v

Sum of in-degrees = Sum of out-degrees = |E|
```

---

**Directed Graph Applications:**
- **Task scheduling** (dependencies must be met)
- **Web page ranking** (PageRank algorithm)
- **Compiler design** (control flow graphs, call graphs)
- **Network protocols** (routing tables, packet forwarding)

---

### Q2: What is a DAG (Directed Acyclic Graph)? Why is it important?

**Answer:**

A **DAG (Directed Acyclic Graph)** is a directed graph with **no cycles**.

**Why "No Cycles" Matters:**
A cycle would mean a node can reach itself, which creates logical contradictions in dependency representations.

---

**Visual: Invalid Dependency (Cycle):**

```
❌ Circular dependency:
  Task A → Task B → Task C → Task A
  
  "A depends on B, B depends on C, C depends on A"
  No valid order to execute these tasks!

✅ Valid DAG:
  Task A → Task B → Task C
         ↘ Task D
```

---

**Key Properties of DAGs:**

| Property | Description |
|----------|-------------|
| **Topological ordering exists** | Tasks can be ordered |
| **No back edges in DFS** | DFS never revisits ancestor |
| **Longest path computable** | Can find critical path |
| **Shortest path computable** | Can find quickest route |

---

**Applications:**

| Domain | DAG Use |
|--------|----------|
| **Build Systems** | Makefile, Maven, Gradle |
| **Task Scheduling** | Course prerequisites |
| **Spreadsheets** | Cell dependencies |
| **Version Control** | Git commit history |
| **Workflows** | Business process modeling |
| **Data Processing** | Pipeline dependency graphs |
| **Compiler Design** | Variable lifetimes |
| **Machine Learning** | Computation graphs |

---

**Example: Course Prerequisites**

```
Prerequisites Graph:
CS101 → CS201 → CS301
  ↓      ↘
CS150 → CS250

If this graph has no cycles, courses can be taken in topological order:
CS101 → CS150 → CS201 → CS250 → CS301
```

---

**Topological Sort on DAG:**

```java
public List<Integer> topologicalSort(DAG dag) {
    int n = dag.size();
    int[] inDegree = new int[n];
    Queue<Integer> queue = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();
    
    // Calculate in-degrees
    for (int node : dag) {
        for (int neighbor : dag.get(node)) {
            inDegree[neighbor]++;
        }
    }
    
    // Add all nodes with no incoming edges
    for (int i = 0; i < n; i++) {
        if (inDegree[i] == 0) queue.add(i);
    }
    
    // Process nodes level by level
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);
        
        for (int neighbor : dag.get(node)) {
            if (--inDegree[neighbor] == 0) {
                queue.add(neighbor);
            }
        }
    }
    
    // If result.size() != n → cycle exists!
    return result;
}
```

---

### Q3: What is a bipartite graph? How do you check it?

**Answer:**

A **bipartite graph** is a graph whose vertices can be **divided into two disjoint sets** such that every edge connects a vertex in one set to a vertex in the other.

**Formal Definition:**
A graph G = (V, E) is bipartite if we can partition V into sets U and W where:
- U ∪ W = V
- U ∩ W = ∅
- Every edge connects a node in U to a node in W (no edges within U or W)

**Equivalently:** A graph is bipartite ↔ it is **2-colorable**

**Visualization:**

```
Bipartite:
Set U = {A, C, E}    Set W = {B, D, F}
A ── B ✓    (OK: A∈U, B∈W)
C ── D ✓    (OK: C∈U, D∈W)
E ── F ✓    (OK: E∈U, F∈W)

Not bipartite:
A ── B
B ── C
A ── C    (Triangle = cycle of odd length = impossible to 2-color!)
```

---

**Bipartite <=> No Odd Cycles**

**Key theorem:** A graph is bipartite ↔ it contains no odd-length cycles.

- Triangle (3-cycle) = odd → not bipartite
- Square (4-cycle) = even → bipartite
- Pentagon (5-cycle) = odd → not bipartite

---

**Algorithm: BFS 2-Coloring**

```java
public boolean isBipartite(List<List<Integer>> graph) {
    int n = graph.size();
    int[] color = new int[n];  // 0=uncolored, 1=colorA, -1=colorB
    
    for (int i = 0; i < n; i++) {
        if (color[i] == 0 && !bfs(i, graph, color)) {
            return false;
        }
    }
    return true;
}

private boolean bfs(int start, List<List<Integer>> graph, int[] color) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    color[start] = 1;  // Color it
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == 0) {
                color[neighbor] = -color[node];  // Opposite color
                queue.add(neighbor);
            } else if (color[neighbor] == color[node]) {
                return false;  // Adjacent nodes have same color
            }
        }
    }
    return true;
}
```

---

**DFS 2-Coloring:**

```java
public boolean isBipartite(List<List<Integer>> graph) {
    int[] color = new int[graph.size()];
    
    for (int i = 0; i < graph.size(); i++) {
        if (color[i] == 0 && !dfs(i, graph, color, 1)) {
            return false;
        }
    }
    return true;
}

private boolean dfs(int node, List<List<Integer>> graph, int[] color, int currentColor) {
    if (color[node] != 0) {
        return color[node] == currentColor;
    }
    
    color[node] = currentColor;
    
    for (int neighbor : graph.get(node)) {
        if (!dfs(neighbor, graph, color, -currentColor)) {
            return false;
        }
    }
    return true;
}
```

---

**Real-world Applications of Bipartite Graphs:**

- **Dating apps:** Men ↔ Women
- **Job matching:** Candidates ↔ Positions
- **Recommendation systems:** Users ↔ Content
- **Network flow:** Source ↔ Sink bipartitions

---

### Q4: What is a complete graph? How many edges does it have?

**Answer:**

A **complete graph** is a graph where **every pair of distinct vertices is connected by a unique edge**.

**Notation:** K_n (complete graph on n vertices)

**Edge Count:**
- **Undirected Complete Graph:** n(n-1)/2 edges
- **Directed Complete Graph:** n(n-1) edges (each ordered pair)

**Examples:**

```
K_1:    K_2:    K_3:    K_4:
○       ○─○      ○       ○
                ╱ ╲     │ │
               ○───○    └─┘
                     / /│\ \
                    ○ ○ ○ ○
```

| n | Undirected | Directed |
|---|-----------|----------|
| 1 | 0 | 0 |
| 2 | 1 | 2 |
| 3 | 3 | 6 |
| 4 | 6 | 12 |
| 5 | 10 | 20 |
| 10 | 45 | 90 |
| 100 | 4,950 | 9,900 |

---

### Q5: What is a sparse graph vs dense graph?

**Answer:**

| Property | Sparse Graph | Dense Graph |
|----------|-------------|-------------|
| **Definition** | E ≈ O(V) | E ≈ O(V²) |
| **Edges** | Few edges | Many edges |
| **Adjacency Matrix** | Wasteful | Efficient |
| **Adjacency List** | Efficient | Still OK but less benefit |

**Decision Rule:**
- If E < V × log(V) → consider **sparse**
- If E > V × log(V) → consider **dense**

**Examples:**
- **Sparse:** Social networks (avg degree ~150, millions of users)
- **Dense:** Fully connected mesh network, tournament graphs
- **Medium:** Web graph (sparse), road network (sparse)

---

## G4: Graph Problems

> **Difficulty:** 🟠 Medium
> **Focus:** Common graph algorithms and problem patterns

---

### Q1: How do you find the number of connected components in an undirected graph?

**Answer:**

A **connected component** is a maximal set of nodes where you can reach any node from any other in the set.

**Two Approaches:**

**1. DFS/BFS - "Flood Fill" Approach:**
```java
public int countComponents(int n, int[][] edges) {
    List<List<Integer>> adj = buildAdj(n, edges);
    boolean[] visited = new boolean[n];
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited);  // Mark all nodes in this component
            count++;
        }
    }
    return count;
}

private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited);
        }
    }
}
```

**2. Union-Find Approach:**
```java
public int countComponents(int n, int[][] edges) {
    DSU dsu = new DSU(n);
    int components = n;  // Start with each node as its own component
    
    for (int[] edge : edges) {
        if (dsu.union(edge[0], edge[1])) {
            components--;  // Merged two components
        }
    }
    return components;
}
```

**Complexity:**
| Approach | Time | Space |
|----------|------|-------|
| DFS/BFS | O(V + E) | O(V) |
| Union-Find | O(E × α(n)) | O(V) |

---

### Q2: How do you detect a cycle in an undirected graph?

**Answer:**

**Key Insight:** During DFS, if we encounter a visited node that is NOT the parent, there's a cycle.

**DFS with Parent Tracking:**

```java
public boolean hasCycle(int n, List<List<Integer>> adj) {
    boolean[] visited = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            if (hasCycleDFS(i, -1, adj, visited)) {
                return true;
            }
        }
    }
    return false;
}

private boolean hasCycleDFS(int node, int parent,
                            List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            if (hasCycleDFS(neighbor, node, adj, visited)) {
                return true;
            }
        } else if (neighbor != parent) {
            // Found a visited node that isn't the parent → cycle
            return true;
        }
    }
    return false;
}
```

**Alternative: Union-Find Approach:**
```java
public boolean hasCycle(int n, int[][] edges) {
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
        if (dsu.find(edge[0]) == dsu.find(edge[1])) {
            return true;  // Same component → cycle
        }
        dsu.union(edge[0], edge[1]);
    }
    return false;
}
```

---

### Q3: How do you detect a cycle in a directed graph?

**Answer:**

Use **3-color DFS**:

| Color | Meaning |
|-------|---------|
| **WHITE (0)** | Unvisited |
| **GRAY (1)** | Currently being processed (in recursion stack) |
| **BLACK (2)** | Fully processed |

**Key Insight:** If we encounter a **GRAY** node during DFS, we've found a back edge → cycle exists.

```java
public boolean hasCycle(int n, List<List<Integer>> adj) {
    int[] color = new int[n];  // Default: WHITE (0)
    
    for (int i = 0; i < n; i++) {
        if (color[i] == 0 && hasCycleDFS(i, adj, color)) {
            return true;
        }
    }
    return false;
}

private boolean hasCycleDFS(int node, List<List<Integer>> adj, int[] color) {
    color[node] = 1;  // Mark as GRAY (visiting)
    
    for (int neighbor : adj.get(node)) {
        if (color[neighbor] == 1) {
            return true;  // Back edge to GRAY node = cycle
        }
        if (color[neighbor] == 0) {
            // WHITE node: recurse
            if (hasCycleDFS(neighbor, adj, color)) {
                return true;
            }
        }
        // BLACK nodes: already processed, skip
    }
    
    color[node] = 2;  // Mark as BLACK (done)
    return false;
}
```

---

### Q4: How do you perform topological sort?

**Answer:**

**Topological Sort:** Linear ordering of vertices where for every directed edge u → v, u comes before v.

**Two Methods:**

**Method 1: Kahn's Algorithm (BFS-based)**

```java
public List<Integer> topologicalSort(int n, List<List<Integer>> adj) {
    // Step 1: Calculate in-degrees
    int[] inDegree = new int[n];
    for (int i = 0; i < n; i++) {
        for (int neighbor : adj.get(i)) {
            inDegree[neighbor]++;
        }
    }
    
    // Step 2: Find all nodes with in-degree 0
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        if (inDegree[i] == 0) {
            queue.add(i);
        }
    }
    
    // Step 3: Process nodes level by level
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);
        
        // "Remove" this node's edges
        for (int neighbor : adj.get(node)) {
            if (--inDegree[neighbor] == 0) {
                queue.add(neighbor);
            }
        }
    }
    
    // If result.size() != n, there's a cycle
    return result.size() == n ? result : new ArrayList<>();
}
```

**Method 2: DFS-based**

```java
public List<Integer> topologicalSort(int n, List<List<Integer>> adj) {
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited, stack);
        }
    }
    
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty()) {
        result.add(stack.pop());
    }
    return result;
}

private void dfs(int node, List<List<Integer>> adj,
                boolean[] visited, Stack<Integer> stack) {
    visited[node] = true;
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, stack);
        }
    }
    
    stack.push(node);  // Add after all dependencies are processed
}
```

**Complexity:**
- Time: O(V + E) for both methods
- Space: O(V) for both methods

---

### Q5: How do you detect if a course schedule is possible? (LeetCode 207)

**Answer:**

This is essentially **cycle detection in a directed graph** (checking if it's a DAG).

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Build graph: prerequisites[a, b] means course b must be taken before a
    List<List<Integer>> adj = new ArrayList<>();
    int[] inDegree = new int[numCourses];
    
    for (int i = 0; i < numCourses; i++) {
        adj.add(new ArrayList<>());
    }
    
    for (int[] pre : prerequisites) {
        adj.get(pre[1]).add(pre[0]);  // b → a (b before a)
        inDegree[pre[0]]++;
    }
    
    // Kahn's algorithm
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
        if (inDegree[i] == 0) {
            queue.add(i);
        }
    }
    
    int count = 0;
    while (!queue.isEmpty()) {
        int course = queue.poll();
        count++;
        
        for (int next : adj.get(course)) {
            if (--inDegree[next] == 0) {
                queue.add(next);
            }
        }
    }
    
    // If we processed all courses, no cycle exists
    return count == numCourses;
}
```

---

## G5: Shortest Paths

> **Difficulty:** 🔴 Hard
> **Focus:** Dijkstra, Bellman-Ford, Floyd-Warshall algorithms

---

### Q1: How does Dijkstra's algorithm work? Why is it correct?

**Answer:**

Dijkstra's algorithm finds the shortest paths from a **single source** to all vertices in a **weighted graph with non-negative edges** using a **greedy approach** with a priority queue.

---

**Algorithm Steps:**

1. Initialize distances: source = 0, all others = ∞
2. Add all vertices to priority queue (or lazily add during relaxation)
3. While PQ is not empty:
   a. Extract vertex u with minimum distance
   b. For each neighbor v of u: relax edge (u, v)
   c. If distance[u] + weight < distance[v], update distance[v]

---

**Why Does It Work?**

The **greedy choice property** is the key: when we extract a vertex from the PQ with the minimum distance, that distance is **finalized** (cannot be improved).

This relies critically on the **non-negative edge weights** constraint:
- Since all edges ≥ 0, no path through an unexplored vertex can create a shorter path to an already-extracted vertex.

---

**Implementation:**

```java
public int[] dijkstra(int start, List<List<int[]>> adj, int n) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    
    // Priority queue: {distance, vertex}
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(a[0], b[0])
    );
    pq.add(new int[]{0, start});
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int d = curr[0], node = curr[1];
        
        if (d > dist[node]) continue;  // Stale entry
        
        for (int[] edge : adj.get(node)) {
            int neighbor = edge[0], weight = edge[1];
            
            if (dist[node] + weight < dist[neighbor]) {
                dist[neighbor] = dist[node] + weight;
                pq.add(new int[]{dist[neighbor], neighbor});
            }
        }
    }
    
    return dist;
}
```

---

**With Path Tracking:**

```java
public int[] dijkstraWithPath(int start, List<List<int[]>> adj, int n) {
    int[] dist = new int[n];
    int[] parent = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);
    dist[start] = 0;
    
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(a[0], b[0])
    );
    pq.add(new int[]{0, start});
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int d = curr[0], node = curr[1];
        
        if (d > dist[node]) continue;
        
        for (int[] edge : adj.get(node)) {
            int neighbor = edge[0], weight = edge[1];
            
            if (dist[node] + weight < dist[neighbor]) {
                dist[neighbor] = dist[node] + weight;
                parent[neighbor] = node;
                pq.add(new int[]{dist[neighbor], neighbor});
            }
        }
    }
    
    return dist;  // Use parent[] to reconstruct path
}
```

---

**Complexity Analysis:**

| Implementation | Time | Space |
|----------------|------|-------|
| With Binary Heap | O((V + E) log V) | O(V) |
| With Fibonacci Heap | O(V log V + E) | O(V) |
| With Array (dense) | O(V²) | O(V) |

---

**Correctness Proof Sketch:**

*Invariant:* When vertex u is extracted from PQ, dist[u] = δ(s, u) (shortest distance).

*Proof:* 
1. Base case: Source has distance 0 ✓
2. Inductive step: Suppose all extracted vertices so far have correct distances.
3. Let u be next vertex extracted. Any path to u must go through:
   - Already extracted vertex x with finalized δ(s, x) ≥ 0, plus edge x→u
   - But we already relaxed x→u during its extraction, so δ(s, x) + w(x,u) ≥ current dist[u]
4. Since edge weights ≥ 0, no other unextracted vertex can produce a shorter path.

---

### Q2: Why can't Dijkstra handle negative weight edges?

**Answer:**

Dijkstra **fails** with negative edge weights because of its **greedy assumption**.

**The Core Problem:**

> Dijkstra assumes: Once a node is **settled** (popped from PQ), its shortest distance has been found.

This assumption breaks when negative edges exist.

---

**Counter-Example:**

```
Graph:
A ─1→ B ─-5→ C
B ←2── C          (edge C→B weight 2)

Shortest path from A to C:
- Path A→B→C: distance = 1 + (-5) = -4
- Direct path A→C: doesn't exist
```

**Dijkstra's Execution:**
1. Extract A (dist=0), relax edges → dist[B] = 1, dist[C] = ∞
2. Extract B (dist=1) ← **WRONG!** B is settled at distance 1
3. Relax B→C → dist[C] = 1 + (-5) = -4
4. Extract C (dist=-4)
5. But the true shortest path is A→B→C = -4, which Dijkstra finds here by luck!

But if there were a cheaper path to B:

```
A ─1→ B ─-5→ C
A ─2→ D ─-3→ B

True shortest to B: A→D→B = 2 + (-3) = -1
But Dijkstra settles B at distance 1 first!
```

**Why Negative Cycles Are Worse:**
If there's a negative cycle, the shortest path is **undefined** (−∞), and any attempt would loop infinitely.

---

**Alternatives:**

| Algorithm | Time | Negative Edges? | Negative Cycles? |
|-----------|------|-----------------|------------------|
| Dijkstra | O((V+E)logV) | ❌ | ❌ |
| Bellman-Ford | O(VE) | ✅ | ✅ (detects) |
| SPFA | O(VE) avg | ✅ | ✅ (detects) |
| DAG shortest | O(V+E) | ✅ | ❌ |

---

### Q3: Explain Bellman-Ford algorithm. How does it detect negative cycles?

**Answer:**

The **Bellman-Ford** algorithm finds shortest paths from a source to all vertices, handling **negative edge weights** and **detecting negative cycles**.

**Key Idea:**
Any shortest path has at most **V-1 edges** (in an acyclic graph). So relax all edges **V-1 times**.

---

**Algorithm Steps:**

1. Initialize distances: source = 0, all others = ∞
2. Repeat V-1 times:
   - For each edge (u, v, w): if dist[u] + w < dist[v], update dist[v]
3. **Check for negative cycles:**
   - One more relaxation pass: if anything changes → negative cycle exists!

---

**Implementation:**

```java
public int[] bellmanFord(int[][] edges, int n, int src) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    
    // Relax edges V-1 times
    for (int i = 0; i < n - 1; i++) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }
    
    // Check for negative cycles
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
            // Negative cycle detected!
            throw new RuntimeException("Negative cycle exists");
        }
    }
    
    return dist;
}
```

---

**Why V-1 Iterations?**

| Iteration | What it means |
|-----------|--------------|
| 0 | Direct neighbors of source (1 edge paths) |
| 1 | Paths with ≤ 2 edges |
| 2 | Paths with ≤ 3 edges |
| ... | ... |
| V-2 | Paths with ≤ V-1 edges (all possible shortest paths) |

> Any simple path has at most V-1 edges (no vertex revisited).

---

**Negative Cycle Detection:**

After V-1 relaxation passes, if we can still relax an edge in the Vth pass, a **negative cycle** must exist along the path to that edge.

```
Example:
3 ─(-1)→ 4 ─(-1)→ 2 ─(-1)→ 3

Shortest path: keeps getting cheaper → no minimum exists
→ Negative cycle: 3→4→2→3 (total weight -3)
```

---

**Complexity:**
- **Time:** O(V × E) — relax all E edges, V-1 times
- **Space:** O(V)

**When to Use:**
- Graph has negative weights
- Need to detect negative cycles
- Edges are sparse enough that E × V is acceptable

---

### Q4: Explain Floyd-Warshall algorithm. When is it preferred?

**Answer:**

The **Floyd-Warshall** algorithm finds **all-pairs shortest paths** using dynamic programming.

**Key Insight:**
For each pair (i, j), consider using vertex k as an intermediate stop:
`dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`

**Algorithm:**
```java
public int[][] floydWarshall(int[][] graph) {
    int n = graph.length;
    int[][] dist = new int[n][n];
    
    // Initialize
    for (int i = 0; i < n; i++) {
        System.arraycopy(graph[i], 0, dist[i], 0, n);
    }
    
    // Dynamic programming: build paths through intermediate vertices
    for (int k = 0; k < n; k++) {      // Intermediate vertex
        for (int i = 0; i < n; i++) {  // Source
            for (int j = 0; j < n; j++) {  // Destination
                if (dist[i][k] != INF && dist[k][j] != INF) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    
    // Check for negative cycles
    for (int i = 0; i < n; i++) {
        if (dist[i][i] < 0) {
            // Negative cycle detected
        }
    }
    
    return dist;
}
```

**Complexity:**
- **Time:** O(V³)
- **Space:** O(V²)

---

**When to Prefer Floyd-Warshall:**

| Scenario | Use Floyd-Warshall |
|----------|---------------------|
| Need all-pairs shortest paths | ✅ |
| Graph has ≥ V²/4 or more edges | ✅ (dense graphs) |
| Graph has negative weights | ✅ |
| Need transitive closure | ✅ |
| Real-time lookups after precompute | ✅ |

---

## G6: Minimum Spanning Trees

> **Difficulty:** 🟠 Medium–Hard
> **Focus:** Kruskal's and Prim's algorithms, Union-Find

---

### Q1: What is a Minimum Spanning Tree (MST)?

**Answer:**

An **MST** is a subset of edges from a connected, undirected, weighted graph that:
1. **Connects all vertices** (spanning)
2. **Has no cycles** (tree)
3. Has the **minimum possible total edge weight**

**Properties:**
- Has exactly **V-1 edges** for V vertices
- May not be unique (if edges have equal weights)
- Every MST connects all vertices
- For distinct weights, MST is **unique**

---

**Real-World Applications:**
- Network design (connect cities with minimum cost)
- Circuit design (wire lengths)
- Clustering (Kruskal's for clustering)
- Image segmentation

---

### Q2: How does Kruskal's algorithm work?

**Algorithm:**
1. **Sort** all edges by weight
2. **Iterate** edges from smallest to largest:
   - Add edge if it doesn't create a cycle (use DSU to check)
3. **Stop** when V-1 edges are added

```java
public int kruskalMST(int n, int[][] edges) {
    // Sort edges by weight
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);
    
    DSU dsu = new DSU(n);
    int mstWeight = 0;
    int edgesUsed = 0;
    
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        
        // If edge doesn't form a cycle
        if (dsu.find(u) != dsu.find(v)) {
            dsu.union(u, v);
            mstWeight += w;
            edgesUsed++;
            
            if (edgesUsed == n - 1) break;  // MST complete
        }
    }
    
    return (edgesUsed == n - 1) ? mstWeight : -1;  // -1 if graph disconnected
}
```

**Complexity:**
- **Time:** O(E log E) — dominated by sorting
- **Space:** O(V) — for DSU

---

### Q3: How does Prim's algorithm work?

**Algorithm:**
1. Start from arbitrary vertex
2. Use **priority queue** to pick min-weight edge to unvisited vertex
3. Repeat until all vertices visited

```java
public int primMST(List<List<int[]>> adj, int n) {
    boolean[] inMST = new boolean[n];
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(a[0], b[0])  // {weight, vertex}
    );
    
    pq.add(new int[]{0, 0});  // Start from vertex 0
    int totalWeight = 0;
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int weight = curr[0], node = curr[1];
        
        if (inMST[node]) continue;  // Already added
        
        inMST[node] = true;
        totalWeight += weight;
        
        for (int[] edge : adj.get(node)) {
            int neighbor = edge[0], w = edge[1];
            if (!inMST[neighbor]) {
                pq.add(new int[]{w, neighbor});
            }
        }
    }
    
    return totalWeight;
}
```

**Complexity:**
- With Binary Heap: O((V + E) log V)
- For Dense Graphs: O(V²)

---

### Q4: Comparison of MST algorithms

| Algorithm | Time (Sparse) | Time (Dense) | Space | Best For |
|-----------|--------------|--------------|-------|----------|
| **Kruskal** | O(E log V) | O(E log V) | O(V) | Sparse graphs |
| **Prim (Heap)** | O((V+E) log V) | O((V+E) log V) | O(V) | Sparse graphs |
| **Prim (Matrix)** | O(V²) | O(V²) | O(V) | Dense graphs |

---

## G7: Strongly Connected Components

> **Difficulty:** 🔴 Hard
> **Focus:** Kosaraju's and Tarjan's algorithms

---

### Q1: What is a Strongly Connected Component (SCC)?

**Answer:**

A **Strongly Connected Component (SCC)** is a maximal set of vertices in a directed graph where:
**Every vertex in the set is reachable from every other vertex in the set.**

```
Example:
0 → 1 → 2    3 → 4
↑   ↓        ↑   ↓
├───┘        └───┘

SCC 1: {0, 1, 2} (mutually reachable)
SCC 2: {3, 4} (mutually reachable)
```

**Applications:**
- Web page importance analysis
- Social network circles
- Compiler optimizations
- Dependency analysis

---

### Q2: Explain Kosaraju's algorithm for SCC

**Algorithm (Two-Pass DFS):**

1. **Pass 1:** DFS on original graph, push nodes to stack by finish time
2. **Transpose:** Reverse all edges
3. **Pass 2:** Pop from stack, DFS on transposed graph — each DFS tree is an SCC

```java
public List<List<Integer>> kosaraju(int n, List<List<Integer>> adj) {
    // Pass 1: DFS on original graph
    boolean[] visited = new boolean[n];
    Stack<Integer> finishStack = new Stack<>();
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs1(i, adj, visited, finishStack);
        }
    }
    
    // Build transposed graph
    List<List<Integer>> radj = transpose(adj);
    
    // Pass 2: DFS on transposed graph in finish order
    Arrays.fill(visited, false);
    List<List<Integer>> sccs = new ArrayList<>();
    
    while (!finishStack.isEmpty()) {
        int node = finishStack.pop();
        if (!visited[node]) {
            List<Integer> scc = new ArrayList<>();
            dfs2(node, radj, visited, scc);
            sccs.add(scc);
        }
    }
    
    return sccs;
}

private void dfs1(int node, List<List<Integer>> adj,
                  boolean[] visited, Stack<Integer> stack) {
    visited[node] = true;
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs1(neighbor, adj, visited, stack);
        }
    }
    stack.push(node);
}

private void dfs2(int node, List<List<Integer>> radj,
                  boolean[] visited, List<Integer> scc) {
    visited[node] = true;
    scc.add(node);
    for (int neighbor : radj.get(node)) {
        if (!visited[neighbor]) {
            dfs2(neighbor, radj, visited, scc);
        }
    }
}
```

**Complexity:** O(V + E) time, O(V) space

---

### Q3: Explain Tarjan's algorithm for SCC

**Key Insight:**
Uses a single DFS with two values per node:
- `tin[u]`: discovery time
- `low[u]`: lowest discovery time reachable from u's subtree

When `low[u] == tin[u]`, node u is the root of an SCC.

```java
class TarjanSCC {
    int timer = 0;
    Stack<Integer> stack = new Stack<>();
    boolean[] onStack;
    int[] tin, low;
    
    public List<List<Integer>> tarjan(int n, List<List<Integer>> adj) {
        onStack = new boolean[n];
        tin = new int[n];
        low = new int[n];
        Arrays.fill(tin, -1);
        List<List<Integer>> sccs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (tin[i] == -1) {
                tarjanDFS(i, adj, sccs);
            }
        }
        return sccs;
    }
    
    private void tarjanDFS(int u, List<List<Integer>> adj, List<List<Integer>> sccs) {
        tin[u] = low[u] = timer++;
        stack.push(u);
        onStack[u] = true;
        
        for (int v : adj.get(u)) {
            if (tin[v] == -1) {
                tarjanDFS(v, adj, sccs);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                // Back edge — v is in current SCC
                low[u] = Math.min(low[u], tin[v]);
            }
        }
        
        // u is root of an SCC
        if (low[u] == tin[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int w = stack.pop();
                onStack[w] = false;
                scc.add(w);
                if (w == u) break;
            }
            sccs.add(scc);
        }
    }
}
```

**Complexity:** O(V + E) time, O(V) space

---

## G8: Graph Hard Problems

> **Difficulty:** 🔴 Hard
> **Focus:** Advanced algorithms for complex graph problems

---

### Q1: Explain A* (A-Star) algorithm

**Answer:**

**A*** is a best-first search algorithm that uses a **heuristic function** to guide the search toward the goal, making it faster than Dijkstra for single-pair shortest paths.

**Key Formula:**
`f(n) = g(n) + h(n)`

Where:
- **g(n)** = actual cost from start to n
- **h(n)** = estimated cost from n to goal (heuristic)
- **f(n)** = estimated total cost of path through n

---

**Heuristics:**

A good heuristic must satisfy two properties:
1. **Admissible**: Never overestimates actual cost (h(n) ≤ h*(n))
2. **Consistent (monotonic)**: h(n) ≤ w(n,n') + h(n') for all neighbors n'

```
Grid Pathfinding Example:
h(n) = Manhattan distance = |x_n - x_goal| + |y_n - y_goal|

This is admissible because:
- Actual path must traverse at least this many cells
- It ignores obstacles (optimistic estimate)
```

---

**Comparison with Dijkstra:**

| Algorithm | Uses Heuristic? | Expands | When Optimal |
|-----------|----------------|---------|--------------|
| Dijkstra | ❌ | All directions | Always (no negative edges) |
| A* | ✅ (admissible) | Toward goal | With admissible h(n) |
| A* | ❌ (h=0) | All nodes | Same as Dijkstra |

---

**Implementation:**

```java
public int astar(int[][] grid, int[] start, int[] end) {
    int rows = grid.length, cols = grid[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(a[0], b[0])  // {f, x, y, g}
    );
    
    int[][] dist = new int[rows][cols];
    for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
    
    // h(start) = Manhattan distance
    int h = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    pq.add(new int[]{h, start[0], start[1], 0});
    dist[start[0]][start[1]] = 0;
    
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int f = curr[0], x = curr[1], y = curr[2], g = curr[3];
        
        if (x == end[0] && y == end[1]) return g;  // Reached goal
        
        if (g > dist[x][y]) continue;
        
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 0) {
                int ng = g + 1;
                if (ng < dist[nx][ny]) {
                    dist[nx][ny] = ng;
                    int nh = Math.abs(nx - end[0]) + Math.abs(ny - end[1]);
                    pq.add(new int[]{ng + nh, nx, ny, ng});
                }
            }
        }
    }
    
    return -1;  // No path found
}
```

---

### Q2: What is network flow? Explain the Max-Flow Min-Cut theorem

**Answer:**

The **Maximum Flow Problem** asks: *Given a flow network with capacities on edges, what is the maximum amount of flow that can be sent from source s to sink t?*

**Formal Definition:**
- Directed graph G = (V, E) with edge capacities c(e) ≥ 0
- Designated source vertex s and sink vertex t
- Find maximum flow satisfying:
  - **Capacity constraint:** 0 ≤ f(e) ≤ c(e)
  - **Flow conservation:** For all v ≠ s,t: Σ f(e) into v = Σ f(e) out of v

---

**Max-Flow Min-Cut Theorem:**

The **maximum flow** from s to t equals the capacity of the **minimum cut** separating s from t.

A **cut** (S, T) partitions vertices with s ∈ S, t ∈ T.

```
Example:
    s ─3→ A ─5→ t
    │     │
    2     4
    ↓     ↓
    B ─6→ C

Max flow = 7 (3 via s→A→t, 4 via s→B→C→A→t)
Min cut = {(s,B), (A,C)} with capacity = 2 + 5 = 7
```

---

### Q3: How do you find all bridges in a graph?

**Answer:**

A **bridge** is an edge whose removal increases the number of connected components.

**Key Idea:** Edge (u, v) is a bridge if `low[v] > tin[u]`.

This means v cannot reach u or any ancestor of u through any other path.

```java
int timer = 0;

public List<int[]> findBridges(int n, List<List<Integer>> adj) {
    int[] tin = new int[n];
    int[] low = new int[n];
    Arrays.fill(tin, -1);
    List<int[]> bridges = new ArrayList<>();
    
    // Handle disconnected components
    for (int i = 0; i < n; i++) {
        if (tin[i] == -1) {
            dfs(i, -1, adj, tin, low, bridges);
        }
    }
    
    return bridges;
}

private void dfs(int u, int parent, List<List<Integer>> adj,
                 int[] tin, int[] low, List<int[]> bridges) {
    tin[u] = low[u] = timer++;
    
    for (int v : adj.get(u)) {
        if (v == parent) continue;  // Skip the edge we came from
        
        if (tin[v] == -1) {
            // Tree edge: explore subtree
            dfs(v, u, adj, tin, low, bridges);
            low[u] = Math.min(low[u], low[v]);
            
            // Check if edge u-v is a bridge
            if (low[v] > tin[u]) {
                bridges.add(new int[]{u, v});
            }
        } else {
            // Back edge: update low based on ancestor
            low[u] = Math.min(low[u], tin[v]);
        }
    }
}
```

**Complexity:** O(V + E) time, O(V) space

**Visualization:**
```
Bridges (red edges):
    1 ── 2 ── 4 ── 5
         |    |    |
         3    6 ───┘

Edge 4→6 is a bridge: removing it disconnects {1,2,3} from {4,5,6}
All other edges are not bridges because alternative paths exist.
```

---

### Q4: How do you find articulation points (cut vertices)?

**Algorithm:**
A vertex u is an articulation point if:
1. u is the **root** of the DFS tree and has ≥ 2 children
2. u is **not the root** and has a child v where `low[v] ≥ tin[u]`

```java
public List<Integer> articulationPoints(int n, List<List<Integer>> adj) {
    int[] tin = new int[n];
    int[] low = new int[n];
    Arrays.fill(tin, -1);
    boolean[] isAP = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (tin[i] == -1) {
            dfs(i, -1, adj, tin, low, isAP);
        }
    }
    
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (isAP[i]) result.add(i);
    }
    return result;
}

private void dfs(int u, int parent, List<List<Integer>> adj,
                 int[] tin, int[] low, boolean[] isAP) {
    tin[u] = low[u] = timer++;
    int children = 0;
    
    for (int v : adj.get(u)) {
        if (v == parent) continue;
        
        if (tin[v] == -1) {
            children++;
            dfs(v, u, adj, tin, low, isAP);
            low[u] = Math.min(low[u], low[v]);
            
            // Articulation point conditions
            if (parent == -1 && children > 1) isAP[u] = true;  // Root case
            if (parent != -1 && low[v] >= tin[u]) isAP[u] = true;  // Non-root
        } else {
            low[u] = Math.min(low[u], tin[v]);
        }
    }
}
```

---

## G9: Graph Specialized Algorithms

---

### Q1: What is Johnson's algorithm? When is it used?

**Answer:**

**Johnson's algorithm** finds **all-pairs shortest paths** in a sparse graph with negative edge weights (but no negative cycles).

**Why Not Floyd-Warshall?**
- Floyd-Warshall: O(V³) regardless of edge count
- Johnson's: O(V²log V + VE) — faster for sparse graphs

---

**Algorithm Steps:**

1. **Add virtual source** s connected to all vertices with weight 0
2. **Run Bellman-Ford** from s to compute potentials h(v)
3. **Reweight edges**: w'(u,v) = w(u,v) + h(u) - h(v) (makes all weights ≥ 0)
4. **Run Dijkstra from each vertex** using reweighted edges

```java
public int[][] johnson(int n, int[][] edges) {
    // Step 1: Add virtual source
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
    for (int i = 0; i < n; i++) adj.get(n).add(new int[]{i, 0});  // s→all
    for (int[] e : edges) adj.get(e[0]).add(new int[]{e[1], e[2]});
    
    // Step 2: Bellman-Ford from virtual source
    int[] h = new int[n + 1];
    Arrays.fill(h, Integer.MAX_VALUE);
    h[n] = 0;
    
    for (int i = 0; i < n; i++) {
        for (int[] e : edges) {
            if (h[e[0]] != Integer.MAX_VALUE && h[e[0]] + e[2] < h[e[1]]) {
                h[e[1]] = h[e[0]] + e[2];
            }
        }
    }
    
    // Step 3 & 4: Dijkstra from each vertex with reweighted edges
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
        dist[i] = dijkstra(n, adj, edges, h, i);
    }
    
    return dist;
}
```

---

### Q2: What is 0-1 BFS and when is it faster than Dijkstra?

**Answer:**

**0-1 BFS** finds the shortest path in a graph where all edge weights are **0 or 1** (no other values).

**Key Insight:**
- Weight 0 → push to **front** of deque (free move)
- Weight 1 → push to **back** of deque (paid move)

This maintains the queue in sorted order of distances — same correctness as Dijkstra but **O(V + E) time instead of O((V + E) log V)**.

```java
public int zeroOneBFS(int[][] graph, int start, int end) {
    int n = graph.length;
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(start);
    
    while (!deque.isEmpty()) {
        int node = deque.poll();
        
        for (int neighbor = 0; neighbor < n; neighbor++) {
            int weight = graph[node][neighbor];
            if (weight >= 0) {  // Valid edge (0 or 1)
                int newDist = dist[node] + weight;
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    if (weight == 0) {
                        deque.addFirst(neighbor);
                    } else {
                        deque.addLast(neighbor);
                    }
                }
            }
        }
    }
    
    return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
}
```

---

## Cross-Topic Questions

---

### Q1: How do you find the diameter of a tree?

**Method 1: Two DFS/BFS**
```
1. BFS from any node → find farthest node A
2. BFS from node A → find farthest node B
3. Distance A→B = diameter
```

**Method 2: DFS with post-order**
```java
public int treeDiameter(List<List<Integer>> adj) {
    int[] diameter = {0};
    diameterDFS(0, -1, adj, diameter);
    return diameter[0];
}

private int diameterDFS(int node, int parent, List<List<Integer>> adj, int[] diameter) {
    int max1 = 0, max2 = 0;  // Top 2 longest paths from this node
    
    for (int neighbor : adj.get(node)) {
        if (neighbor != parent) {
            int depth = diameterDFS(neighbor, node, adj, diameter);
            if (depth > max1) {
                max2 = max1;
                max1 = depth;
            } else if (depth > max2) {
                max2 = depth;
            }
        }
    }
    
    diameter[0] = Math.max(diameter[0], max1 + max2);  // Path through node
    return max1 + 1;  // Return longest path downward from this node
}
```

---

### Q2: How do you check if an undirected graph is a tree?

**Conditions (check any 2 of 3):**
1. Connected
2. Has exactly V-1 edges
3. No cycles

```java
public boolean isTree(int n, int[][] edges) {
    if (n == 0) return true;
    if (edges.length != n - 1) return false;  // Must have exactly n-1 edges
    
    // Check connectivity
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
    }
    
    boolean[] visited = new boolean[n];
    dfs(0, adj, visited);
    
    for (boolean v : visited) {
        if (!v) return false;  // Not connected
    }
    return true;
}
```

---

### Q3: How do you design a file system using trees?

**Tree representation:**
- Each directory = internal node
- Each file = leaf node
- Root = "/" directory

**Operations:**
- `cd path`: DFS traversal
- `ls`: List children
- `mkdir`: Add child
- `rm -rf`: Delete subtree

---

### Q4: Meta/Facebook: Clone a graph with cycles

**Approach:** Use HashMap to map original → cloned. Handle cycles by checking the map before recursing.

```java
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        
        return copy;
    }
}
```

---

### Q5: Amazon: Serialize/Deserialize a tree for distributed systems

**Level-order BFS approach:**
```java
// Serialize
public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode node = q.poll();
        if (node == null) {
            sb.append("#,");
        } else {
            sb.append(node.data).append(",");
            q.add(node.left);
            q.add(node.right);
        }
    }
    return sb.toString();
}

// Deserialize
public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    String[] values = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    int i = 1;
    while (!q.isEmpty() && i < values.length) {
        TreeNode node = q.poll();
        if (!values[i].equals("#")) {
            node.left = new TreeNode(Integer.parseInt(values[i]));
            q.add(node.left);
        }
        i++;
        if (i < values.length && !values[i].equals("#")) {
            node.right = new TreeNode(Integer.parseInt(values[i]));
            q.add(node.right);
        }
        i++;
    }
    return root;
}
```

---

### Q6: Flipkart/Paytm: Shortest path with at most K stops

**Bellman-Ford with limited iterations:**
```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    
    for (int i = 0; i <= k; i++) {
        int[] temp = dist.clone();
        for (int[] f : flights) {
            int u = f[0], v = f[1], w = f[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                temp[v] = dist[u] + w;
            }
        }
        dist = temp;
    }
    
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
}
```

---

### Q7: Grid BFS template (Google-style)

**Universal pattern for 2D grid problems:**
```java
int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

public void bfsGrid(int[][] grid, int i, int j, boolean[][] visited) {
    int m = grid.length, n = grid[0].length;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{i, j});
    visited[i][j] = true;
    
    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] dir : dirs) {
            int ni = cell[0] + dir[0];
            int nj = cell[1] + dir[1];
            
            if (ni >= 0 && ni < m && nj >= 0 && nj < n
                && !visited[ni][nj] && grid[ni][nj] == 1) {
                visited[ni][nj] = true;
                queue.add(new int[]{ni, nj});
            }
        }
    }
}
```

**Common grid problems:**
- Number of Islands (#200)
- Max Area of Island (#695)
- Surrounded Regions (#130)
- Pacific Atlantic Water Flow (#417)
- Word Search (#79)
- Shortest Path in Binary Matrix (#1091)

---

### Q8: How do you find the number of spanning trees?

**Kirchhoff's Matrix Tree Theorem:**

The number of spanning trees equals any cofactor of the **Laplacian matrix** (Degree Matrix - Adjacency Matrix).

```java
public long countSpanningTrees(int n, int[][] edges) {
    // Build Laplacian matrix
    int[][] laplacian = new int[n][n];
    
    for (int[] e : edges) {
        int u = e[0], v = e[1];
        laplacian[u][u]++;  // Degree
        laplacian[v][v]++;
        laplacian[u][v]--;  // Edge
        laplacian[v][u]--;
    }
    
    // Calculate any cofactor (delete row 0, col 0, take determinant)
    int[][] submatrix = new int[n-1][n-1];
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < n; j++) {
            submatrix[i-1][j-1] = laplacian[i][j];
        }
    }
    
    return determinant(submatrix);  // O(n³) using Gaussian elimination
}
```

---

## Algorithm Cheat Sheet

### ⏱️ Complexity Summary

| Topic | Best Algorithm | Time | Space |
|-------|---------------|------|-------|
| Tree Traversals | DFS (recursive) / Morris | O(n) | O(h) / O(1) |
| BST Search | Binary comparison | O(log n) avg | O(1) iter |
| BST Validate | DFS with bounds | O(n) | O(h) |
| LCA (General Tree) | DFS | O(n) | O(h) |
| LCA (BST) | BST property | O(log n) avg | O(h) |
| MST (Sparse) | Kruskal + DSU | O(E log V) | O(V) |
| MST (Dense) | Prim's | O(V²) | O(V) |
| Shortest (non-negative) | Dijkstra | O((V+E) log V) | O(V+E) |
| Shortest (negative) | Bellman-Ford | O(VE) | O(V) |
| All-Pairs Shortest | Floyd-Warshall | O(V³) | O(V²) |
| SCC | Tarjan / Kosaraju | O(V+E) | O(V) |
| Bipartite Check | BFS 2-coloring | O(V+E) | O(V) |
| DSU | Path Comp + Rank | O(α(n)) ≈ O(1) | O(V) |
| Topological Sort | Kahn's / DFS | O(V+E) | O(V) |
| Grid BFS | Deque + visited | O(R×C) | O(R×C) |
| Bridges/Cut vertices | Tarjan's SCC-style | O(V+E) | O(V) |

---

### 🔑 Interview Strategy Guide

```
TREE RED FLAGS (check these first):
□ Skewed tree → O(n) worst case, mention self-balancing
□ BST validation → use min/max bounds, not just neighbor check
□ Min depth → careful with single-child nodes (not leaves)
□ Negative values in path sum → use max(gain, 0)
□ Serialization → level-order with null markers

GRAPH RED FLAGS:
□ Disconnected graph → always loop over all nodes for BFS/DFS
□ Self-loops → handle in neighbor iteration
□ Negative edges → Dijkstra FAILS, use Bellman-Ford
□ Directed cycle detection → 3-color DFS (not parent check)
□ Duplicate edges → adjacency list handles naturally
□ Grid problems → always check bounds + visited before enqueue

WHICH ALGORITHM TO CHOOSE:
┌─────────────────────────────────────────────┐
│ Shortest path, unweighted? → BFS           │
│ Shortest path, weighted (non-neg)? → Dijkstra │
│ Shortest path, has negative edges? → Bellman-Ford │
│ All-pairs shortest paths? → Floyd-Warshall │
│ MST (minimum spanning tree)? → Kruskal (sparse), Prim (dense) │
│ Topological ordering? → Kahn's BFS or DFS post-order │
│ Strongly connected components? → Tarjan or Kosaraju │
│ Bipartite check? → 2-color BFS │
│ Cycle detection (directed)? → 3-color DFS │
│ Cycle detection (undirected)? → DFS with parent │
│ Dynamic connectivity? → DSU (Union-Find) │
│ Range queries on tree? → Euler tour + Segment tree / HLD │
└─────────────────────────────────────────────┘
```

---

### 🏆 Problem-Solving Patterns

| Pattern Name | Problem Type | LeetCode Examples | Key Insight |
|-------------|-------------|-------------------|-------------|
| **Flood Fill** | Connected component on grid | #200, #130, #695 | BFS/DFS from each unvisited cell |
| **Union-Find** | Dynamic connectivity | #684, #685, #547, #1584 | Use DSU to track components |
| **Topological Sort** | Ordering with dependencies | #207, #210, #310 | Kahn's or DFS-based |
| **Multi-source BFS** | Shortest path from multiple sources | #994, #542 | Initialize queue with all sources |
| **Graph Coloring** | Bipartition, scheduling | #785, #886 | 2-color with BFS |
| **Eulerian Path/Circuit** | Visit every edge once | #332 | Hierholzer's algorithm |
| **DAG + DP** | Count paths, longest path | #329, #120 | Topological order + DP |
| **0-1 BFS** | Shortest path, weights 0/1 only | #542, #1300 | Use deque instead of PQ |
| **Dijkstra + State** | Shortest path with constraints | #787, #1631 | Add constraint to state |

---

### 💡 Company-Specific Patterns Summary

| Company | Pattern | Problem Example | Pro Tip |
|---------|--------|-----------------|---------|
| **Google** | Grid DFS/BFS | Number of Islands | Use direction arrays `{{1,0},{-1,0},{0,1},{0,-1}}` |
| **Facebook** | Graph cloning | Clone Graph | HashMap<Node, Node> handles cycles naturally |
| **Amazon** | Tree serialization | Serialize/Deserialize | Test with edge cases: single node, null nodes |
| **Microsoft** | BST with duplicates | Kth Largest in BST | Use count field or allow duplicates on right |
| **Apple** | DFS on tree | Path Sum variants | Consider both paths from root AND between any two nodes |
| **Netflix** | Graph analytics | Friend recommendation | Consider using PageRank or random walks |
| **Uber** | Shortest path | Shortest Path with K Stops | Bellman-Ford with limited iterations or Dijkstra with state |

---

### 📚 Further Study Resources

```
BOOKS:
├── "CLRS" — Algorithms (comprehensive reference)
├── "Competitive Programming" — CP techniques
└── "Elements of Programming Interviews" — Interview-focused

ONLINE:
├── LeetCode — Tree & Graph tags
├── HackerRank — Graph theory section
├── GeeksforGeeks — Topic-wise tutorials
└── VisuAlgo.net — Interactive visualizations

VISUALIZATION TOOLS:
├── csacademy.com/app — Graph algorithm visualizer
├── Algorithm Visualizer (GitHub) — 100+ algorithms
└── VisuAlgo — Step-by-step animations

INTERVIEW PRACTICE ORDER:
1. Tree traversals (T2) → DFS, BFS, Morris
2. BST problems (T5-T8) → Validate, LCA, Kth smallest
3. Graph traversal (G2) → BFS, DFS, connected components
4. Shortest paths (G5) → Dijkstra, Bellman-Ford
5. MST (G6) → Kruskal, Prim, DSU
6. Topological sort (G4) → Kahn's algorithm
7. SCC (G7) → Kosaraju or Tarjan
8. Hard problems (G8-G9) → A*, bridges, specialized algorithms
9. System design (X2-X3) → File systems, routing algorithms
10. Company-specific (X4) → Practice common patterns
```

---

*Master these questions and you'll be ready for any Trees & Graphs interview — from startups to FAANG. 🚀*

---

**Note:** This guide covers both fundamental concepts and advanced algorithms. For interview success:
1. Master the basics (T1-T8) first
2. Practice BFS/DFS patterns (G2-G4)
3. Learn MST and shortest path algorithms (G5-G6)
4. Study advanced techniques (G7-G9)
5. Practice with actual LeetCode problems in the cheat sheet

