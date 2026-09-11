# 🎯 Trees & Graphs — Frequently Asked Interview Questions

> **Covers: Easy → Medium → Hard | Trees, BST, Graphs, Advanced Topics**
>
> *Perfect for last-minute revision and deep-dive preparation*

---

## 📑 Table of Contents

### 🌳 Trees — Basics & Traversals (Easy)
1. [T1](#t1-basic-tree-concepts) · [T2](#t2-traversal-variants) · [T3](#t3-tree-properties) · [T4](#t4-height-and-depth)

### 🌲 Binary Search Tree (Easy–Medium)
5. [T5](#t5-bst-fundamentals) · [T6](#t6-bst-operations) · [T7](#t7-bst-edge-cases) · [T8](#t8-bst-advanced)

### 🌲 Binary Tree Problems (Medium)
9. [T9](#t9-medium-tree-problems) · [T10](#t10-tree-optimization) · [T11](#t11-tree-advanced)

### 🕸️ Graph — Basics & Traversals (Easy–Medium)
12. [G1](#g1-graph-fundamentals) · [G2](#g2-bfs-and-dfs) · [G3](#g3-graph-variants) · [G4](#g4-graph-problems)

### 🕸️ Graph — Advanced & Hard (Medium–Hard)
13. [G5](#g5-graph-advanced) · [G6](#g6-graph-hard) · [G7](#g7-graph-specialized)

### 🔥 Cross-Topic & Company-Specific (Hard)
14. [X1](#x1-combined-concepts) · [X2](#x2-system-design-trees) · [X3](#x3-system-design-graphs) · [X4](#x4-company-patterns)

---

## 🌳 Trees — Basics & Traversals (Easy)

---

### T1. Basic Tree Concepts

**Q: What is a tree? How does it differ from a graph?**

> A tree is a special type of graph that is **connected**, **acyclic**, and has exactly **one root node**. A graph can have cycles, disconnected components, and multiple entry points. Trees have exactly `N-1` edges for `N` nodes.

---

**Q: What is the difference between a binary tree and a general tree?**

> A **binary tree** restricts each node to at most **2 children** (left, right). A **general tree** (n-ary tree) allows any number of children per node. Binary trees enable efficient traversals and BST properties.

---

**Q: Define root, leaf, parent, child, sibling, depth, and height.**

> - **Root:** Topmost node (no parent).
> - **Leaf:** Node with no children.
> - **Parent:** Node directly above another.
> - **Child:** Node directly below another.
> - **Sibling:** Nodes sharing the same parent.
> - **Depth:** Distance from root to a node (root depth = 0).
> - **Height:** Longest path from a node to a leaf (leaf height = 0). Tree height = root height.

---

**Q: What is a full binary tree, complete binary tree, and perfect binary tree?**

> - **Full:** Every node has 0 or 2 children.
> - **Complete:** All levels filled except last (filled left-to-right).
> - **Perfect:** All internal nodes have 2 children, all leaves at same level. Has `2^(h+1) - 1` nodes.

---

**Q: What is a skewed binary tree? What is its worst-case time complexity?**

> A skewed tree has every node with at most one child, resembling a linked list. Operations degrade from `O(log n)` to **`O(n)`** for search, insert, and delete.

---

**Q: How many edges does a tree with N nodes have?**

> Exactly **N - 1** edges. This is a defining property of trees — they are minimally connected (removing any edge disconnects the tree).

---

**Q: What is the maximum number of nodes at level L in a binary tree?**

> **2^L** nodes at level L (where root is level 0). A perfect binary tree of height h has **2^(h+1) - 1** total nodes.

---

### T2. Traversal Variants

**Q: Explain all four binary tree traversal methods.**

> - **Preorder (Root-Left-Right):** Process root first. Used for copying trees, prefix expressions.
> - **Inorder (Left-Root-Right):** Processes BST in sorted order. Used for sorted output.
> - **Postorder (Left-Right-Root):** Processes children before parent. Used for deleting trees.
> - **Level Order (BFS):** Processes level by level using a queue. Used for breadth-first analysis.

---

**Q: Given preorder and inorder traversals, can you reconstruct the tree? How?**

> Yes. The first element of preorder is always the root. Find this root in inorder — elements to the left form the left subtree, elements to the right form the right subtree. Recurse on both halves.

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
}

private TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> inMap) {
    if (preStart > preEnd || inStart > inEnd) return null;
    TreeNode root = new TreeNode(pre[preStart]);
    int inRoot = inMap.get(root.data);
    int numsLeft = inRoot - inStart;
    root.left = build(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, inMap);
    root.right = build(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, inMap);
    return root;
}
```

**Complexity:** Time O(n), Space O(n).

---

**Q: Can you reconstruct a binary tree from preorder and postorder traversals alone?**

> Not uniquely (unless it's a full binary tree). Postorder gives the left subtree root and right subtree root, but without inorder, you can't distinguish left vs right when a node has only one child. For **full binary trees**, it's uniquely reconstructable.

---

**Q: Implement iterative (non-recursive) inorder and preorder traversals.**

```java
// Iterative Inorder
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        result.add(curr.data);
        curr = curr.right;
    }
    return result;
}

// Iterative Preorder
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.data);
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
    return result;
}
```

---

**Q: What is Morris Traversal and how does it achieve O(1) space?**

> Morris Traversal uses **threaded binary trees** — temporarily linking a node's rightmost descendant's null right pointer back to the node itself. After traversal, threads are removed restoring original structure.

```java
// Morris Inorder (O(1) Space)
public List<Integer> inorderMorris(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;
    while (curr != null) {
        if (curr.left == null) {
            result.add(curr.data);
            curr = curr.right;
        } else {
            // Find inorder predecessor
            TreeNode pred = curr.left;
            while (pred.right != null && pred.right != curr) pred = pred.right;
            if (pred.right == null) {
                pred.right = curr;  // Create thread
                curr = curr.left;
            } else {
                pred.right = null;  // Remove thread
                result.add(curr.data);
                curr = curr.right;
            }
        }
    }
    return result;
}
```

---

**Q: What is the difference between level order traversal and BFS?**

> They are essentially the same algorithm applied to trees. Level order traversal of a tree IS BFS with a queue. BFS is a broader graph concept; level order is the tree-specific application.

---

**Q: Given a level order traversal array, can you construct a complete binary tree?**

> Yes, directly. For node at index `i`, left child is at `2i + 1`, right child at `2i + 2`. This works because complete binary trees have no gaps.

```java
public TreeNode buildFromLevelOrder(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) return null;
    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int i = 1;
    while (!queue.isEmpty() && i < arr.length) {
        TreeNode node = queue.poll();
        if (i < arr.length && arr[i] != null) {
            node.left = new TreeNode(arr[i]);
            queue.add(node.left);
        }
        i++;
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

### T3. Tree Properties

**Q: What is the maximum height of a binary tree with N nodes?**

> Maximum height = **N - 1** (skewed tree, essentially a linked list).

**Q: What is the minimum height of a binary tree with N nodes?**

> Minimum height = **⌊log₂(N)⌋** (complete/perfect binary tree).

---

**Q: How do you count the number of leaf nodes in a binary tree?**

```java
public int countLeaves(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    return countLeaves(root.left) + countLeaves(root.right);
}
```

---

**Q: How do you check if two trees are mirrors of each other?**

```java
public boolean isMirror(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    return a.data == b.data
        && isMirror(a.left, b.right)
        && isMirror(a.right, b.left);
}
```

---

**Q: What is a uni-value tree? How do you count uni-value subtrees?**

> A uni-value tree has all nodes with the same value.

```java
int count = 0;
public int countUnivalSubtrees(TreeNode root) {
    isUnival(root);
    return count;
}
private boolean isUnival(TreeNode node) {
    if (node == null) return true;
    boolean left = isUnival(node.left);
    boolean right = isUnival(node.right);
    if (!left || !right) return false;
    if (node.left != null && node.left.data != node.data) return false;
    if (node.right != null && node.right.data != node.data) return false;
    count++;
    return true;
}
```

---

### T4. Height and Depth

**Q: How do you find the height of a binary tree?**

```java
public int height(TreeNode root) {
    if (root == null) return -1; // Height of empty tree = -1, single node = 0
    return 1 + Math.max(height(root.left), height(root.right));
}
```

---

**Q: Given a binary tree, find the minimum depth (shortest root-to-leaf path).**

> Key difference from max depth: the shortest path to a leaf, not any null node. Both children must be null.

```java
public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    if (root.left == null) return 1 + minDepth(root.right);
    if (root.right == null) return 1 + minDepth(root.left);
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}
```

**BFS approach** is more efficient for this problem:

```java
public int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int depth = 1;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        depth++;
    }
    return depth;
}
```

---

## 🌲 Binary Search Tree (Easy–Medium)

---

### T5. BST Fundamentals

**Q: What is a BST and what is its key property?**

> A BST is a binary tree where for every node: **all left subtree values < node < all right subtree values**. This guarantees inorder traversal produces sorted output in O(n).

---

**Q: What is the time complexity of BST search, insert, and delete?**

| Operation | Average | Worst Case |
|-----------|---------|------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |

Worst case occurs with a **skewed tree** (sorted input inserted sequentially). Self-balancing trees (AVL, Red-Black) guarantee O(log n).

---

**Q: Why is BST search O(log n) on average?**

> At each comparison, we eliminate roughly half the remaining nodes (like binary search). With n nodes, we need at most log₂(n) comparisons to find any value.

---

**Q: What is the kth smallest element in a BST? How do you find it efficiently?**

> Use **inorder traversal** (gives sorted order). Stop when you've visited k nodes.

```java
class Solution {
    private int count = 0, result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        if (++count == k) { result = node.data; return; }
        inorder(node.right, k);
    }
}
```

**O(1) space approach:** Morris inorder traversal.

**O(h) space approach:** Iterative with stack — stop early at kth node.

---

### T6. BST Operations

**Q: How do you insert into a BST? What is the iterative vs recursive approach?**

```java
// Recursive
public TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.data) root.left = insert(root.left, val);
    else if (val > root.data) root.right = insert(root.right, val);
    return root;
}

// Iterative
public TreeNode insertIterative(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    TreeNode curr = root;
    while (true) {
        if (val < curr.data) {
            if (curr.left == null) { curr.left = new TreeNode(val); break; }
            else curr = curr.left;
        } else {
            if (curr.right == null) { curr.right = new TreeNode(val); break; }
            else curr = curr.right;
        }
    }
    return root;
}
```

---

**Q: How do you delete a node from a BST? Cover all 3 cases.**

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (key < root.data) root.left = deleteNode(root.left, key);
    else if (key > root.data) root.right = deleteNode(root.right, key);
    else {
        // Case 1: Leaf node or single child
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // Case 2: Two children
        // Find inorder successor (smallest in right subtree)
        TreeNode successor = root.right;
        while (successor.left != null) successor = successor.left;
        root.data = successor.data;
        root.right = deleteNode(root.right, successor.data);
    }
    return root;
}
```

**Case 1:** Node is leaf → return null.
**Case 2:** Node has one child → return the child.
**Case 3:** Node has two children → Replace with inorder successor/predecessor, then delete successor.

---

**Q: What is the inorder successor of a node in a BST?**

> The **inorder successor** is the next larger node in sorted order.
>
> - If the node has a **right subtree**: successor is the **leftmost node** in the right subtree.
> - If no right subtree: successor is the **lowest ancestor** where the node is in the left subtree.

```java
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p.right != null) {
        TreeNode node = p.right;
        while (node.left != null) node = node.left;
        return node;
    }
    TreeNode successor = null;
    while (root != null) {
        if (p.data < root.data) {
            successor = root;
            root = root.left;
        } else {
            root = root.right;
        }
    }
    return successor;
}
```

---

**Q: What is the inorder predecessor of a node in a BST?**

> The **inorder predecessor** is the previous smaller node in sorted order.
>
> - If the node has a **left subtree**: predecessor is the **rightmost node** in the left subtree.
> - If no left subtree: predecessor is the **lowest ancestor** where the node is in the right subtree.

---

**Q: How do you find the minimum and maximum in a BST?**

```java
public int findMin(TreeNode root) {
    while (root.left != null) root = root.left;
    return root.data;
}
public int findMax(TreeNode root) {
    while (root.right != null) root = root.right;
    return root.data;
}
```

**Complexity:** O(h) time, O(1) space.

---

### T7. BST Edge Cases

**Q: How do you validate that a binary tree is a valid BST? Why is the naive approach wrong?**

> **Naive (wrong):** Check `node.left.val < node.val && node.right.val > node.val`. This fails when a grandchild violates the global BST property.
>
> **Correct:** Pass `min` and `max` bounds down recursively.

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }
}
```

**Counter-example:**
```
    10
   /  \
  5   15
     /  \
    6   20   ← 6 < 15 (local check passes) but 6 < 10 (global check fails!)
```

---

**Q: What if BST allows duplicate values? How does validation change?**

> Depending on the BST definition:
> - **Left < Node ≤ Right** → Change `node.data <= min` to `node.data < min`
> - **Left ≤ Node < Right** → Change `node.data >= max` to `node.data > max`
>
> Always clarify this with the interviewer.

---

**Q: How do you find the floor and ceiling of a value in a BST?**

> - **Floor:** Largest value ≤ target
> - **Ceiling:** Smallest value ≥ target

```java
public Integer floor(TreeNode root, int target) {
    if (root == null) return null;
    if (root.data == target) return root.data;
    if (root.data > target) return floor(root.left, target);
    Integer rightFloor = floor(root.right, target);
    return (rightFloor != null && rightFloor <= target) ? rightFloor : root.data;
}
```

---

### T8. BST Advanced

**Q: How do you convert a sorted array to a balanced BST?**

```java
public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
}
private TreeNode build(int[] nums, int l, int r) {
    if (l > r) return null;
    int mid = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, l, mid - 1);
    root.right = build(nums, mid + 1, r);
    return root;
}
```

**Time:** O(n), **Space:** O(log n) recursion stack.

---

**Q: How do you convert a sorted linked list to a balanced BST?**

> Use **bottom-up recursion** simulating inorder traversal. Since linked list access is sequential, we build the left subtree first, then use the current node as root, then build the right subtree.

```java
private ListNode head;
public TreeNode sortedListToBST(ListNode head) {
    this.head = head;
    int n = size(head);
    return build(0, n - 1);
}
private TreeNode build(int l, int r) {
    if (l > r) return null;
    TreeNode left = build(l, l + (r - l) / 2 - 1);
    TreeNode root = new TreeNode(head.val);
    head = head.next;
    root.left = left;
    root.right = build(l + (r - l) / 2 + 1, r);
    return root;
}
```

---

**Q: How do you find the kth largest element in a BST?**

> Reverse inorder (Right → Root → Left) gives descending order. Stop at kth node.

```java
class Solution {
    private int count = 0, result = -1;
    public int kthLargest(TreeNode root, int k) {
        reverseInorder(root, k);
        return result;
    }
    private void reverseInorder(TreeNode node, int k) {
        if (node == null) return;
        reverseInorder(node.right, k);
        if (++count == k) { result = node.data; return; }
        reverseInorder(node.left, k);
    }
}
```

---

**Q: How do you serialize and deserialize a binary tree?**

> Use **preorder traversal** with null markers (`#`).

```java
public class Codec {
    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) { sb.append("#,"); return; }
        sb.append(node.data).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}
```

**Time:** O(n), **Space:** O(n).

---

**Q: How do you find the lowest common ancestor of two nodes in a BST?**

> Use BST property: if both values < root, LCA is in left subtree. If both > root, LCA is in right subtree. Otherwise, root is LCA.

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.data > root.data && q.data > root.data)
        return lowestCommonAncestor(root.right, p, q);
    if (p.data < root.data && q.data < root.data)
        return lowestCommonAncestor(root.left, p, q);
    return root;
}
```

**Time:** O(log n) average, O(n) worst.

---

**Q: What is a Treap (Tree + Heap)? What is its advantage?**

> A **Treap** combines BST ordering with a heap priority (random priority per node). It guarantees balanced height with high probability because priorities are random, eliminating the need for explicit rotations.

---

## 🌲 Binary Tree Problems (Medium)

---

### T9. Medium Tree Problems

**Q: What is the diameter of a binary tree?**

> The diameter is the **longest path between any two nodes** (may or may not pass through root). At each node, diameter = `leftHeight + rightHeight`.

```java
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    private int height(TreeNode node) {
        if (node == null) return 0;
        int lh = height(node.left), rh = height(node.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
```

---

**Q: How do you find the lowest common ancestor of two nodes in a binary tree (not BST)?**

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
```

**Time:** O(n), **Space:** O(h).

---

**Q: How do you check if a binary tree is symmetric?**

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
```

---

**Q: How do you find the right side view of a binary tree?**

> Return the **rightmost visible node** at each level (viewed from the right side).

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) result.add(node.data);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}
```

---

**Q: What is the vertical order traversal of a binary tree?**

> Assign a **horizontal distance** (HD) to each node: root HD = 0, left child HD = -1, right child HD = +1. Group nodes by HD and sort within each group by level.

```java
public List<List<Integer>> verticalOrder(TreeNode root) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    Queue<Pair> queue = new ArrayDeque<>();
    if (root != null) queue.add(new Pair(root, 0));
    while (!queue.isEmpty()) {
        Pair p = queue.poll();
        map.computeIfAbsent(p.hd, k -> new ArrayList<>()).add(p.node.data);
        if (p.node.left != null) queue.add(new Pair(p.node.left, p.hd - 1));
        if (p.node.right != null) queue.add(new Pair(p.node.right, p.hd + 1));
    }
    return new ArrayList<>(map.values());
}
```

---

**Q: How do you check if a binary tree is a valid BST using an iterative approach?**

```java
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (prev != null && prev.data >= root.data) return false;
        prev = root;
        root = root.right;
    }
    return true;
}
```

---

**Q: What is the sum of all root-to-leaf numbers?**

> If the tree represents numbers (e.g., path `1→2→3` represents `123`), find the sum of all such numbers.

```java
public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
}
private int dfs(TreeNode node, int currentSum) {
    if (node == null) return 0;
    currentSum = currentSum * 10 + node.data;
    if (node.left == null && node.right == null) return currentSum;
    return dfs(node.left, currentSum) + dfs(node.right, currentSum);
}
```

---

### T10. Tree Optimization

**Q: How do you find the largest BST subtree in a binary tree?**

```java
class Solution {
    int maxSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        largestBST(root);
        return maxSize;
    }
    private int[] largestBST(TreeNode node) {
        // {size, min, max, isBST}
        if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 1};
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if (left[3] == 1 && right[3] == 1 && node.data > left[2] && node.data < right[1]) {
            int size = left[0] + right[0] + 1;
            maxSize = Math.max(maxSize, size);
            return new int[]{size, Math.min(node.data, left[1]), Math.max(node.data, right[2]), 1};
        }
        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}
```

---

**Q: How do you find the distance between two nodes in a binary tree?**

> Distance = depth(node1) + depth(node2) - 2 × depth(LCA).

```java
public int findDistance(TreeNode root, int p, int q) {
    TreeNode lca = lca(root, p, q);
    return depth(lca, p) + depth(lca, q);
}
private int depth(TreeNode node, int target) {
    if (node == null) return -1;
    if (node.data == target) return 0;
    int left = depth(node.left, target);
    if (left >= 0) return left + 1;
    int right = depth(node.right, target);
    return right >= 0 ? right + 1 : -1;
}
private TreeNode lca(TreeNode root, int p, int q) {
    if (root == null || root.data == p || root.data == q) return root;
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

---

**Q: How do you find the longest consecutive sequence in a binary tree?**

```java
public int longestConsecutive(TreeNode root) {
    return dfs(root, null, 0);
}
private int dfs(TreeNode node, TreeNode parent, int length) {
    if (node == null) return length;
    int curr = (parent != null && node.data == parent.data + 1) ? length + 1 : 1;
    return Math.max(curr, Math.max(dfs(node.left, node, curr), dfs(node.right, node, curr)));
}
```

---

### T11. Tree Advanced

**Q: How do you serialize a binary tree using level order (BFS)?**

```java
public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) { sb.append("#,"); continue; }
        sb.append(node.data).append(",");
        queue.add(node.left);
        queue.add(node.right);
    }
    return sb.toString();
}
```

---

**Q: How do you reconstruct a binary tree from its preorder and postorder traversals (for full binary trees)?**

```java
int preIdx = 0;
public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return build(pre, post, 0, post.length - 1);
}
private TreeNode build(int[] pre, int[] post, int l, int r) {
    if (l > r || preIdx >= pre.length) return null;
    TreeNode root = new TreeNode(pre[preIdx++]);
    if (l == r || preIdx >= pre.length) return root;
    int idx = find(post, pre[preIdx], l, r);
    root.left = build(pre, post, l, idx);
    root.right = build(pre, post, idx + 1, r - 1);
    return root;
}
private int find(int[] arr, int val, int l, int r) {
    for (int i = l; i <= r; i++) if (arr[i] == val) return i;
    return -1;
}
```

---

**Q: How do you find the maximum path sum in a binary tree?**

> A path is any sequence of nodes connected by edges (doesn't need to pass through root).

```java
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        maxSum = Math.max(maxSum, node.data + left + right);
        return node.data + Math.max(left, right);
    }
}
```

---

**Q: How do you find the deepest node in a binary tree?**

```java
public TreeNode findDeepest(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    TreeNode deepest = null;
    while (!queue.isEmpty()) {
        deepest = queue.poll();
        if (deepest.left != null) queue.add(deepest.left);
        if (deepest.right != null) queue.add(deepest.right);
    }
    return deepest;
}
```

---

**Q: How do you check if two trees are cousins?**

> Cousins: Same depth, different parents.

```java
public boolean isCousins(TreeNode root, int x, int y) {
    int[] xInfo = find(root, x, 0, -1);
    int[] yInfo = find(root, y, 0, -1);
    return xInfo[0] == yInfo[0] && xInfo[1] != yInfo[1]; // Same depth, different parent
}
private int[] find(TreeNode node, int val, int depth, int parent) {
    if (node == null) return null;
    if (node.data == val) return new int[]{depth, parent};
    int[] left = find(node.left, val, depth + 1, node.data);
    return left != null ? left : find(node.right, val, depth + 1, node.data);
}
```

---

## 🕸️ Graph — Basics & Traversals (Easy–Medium)

---

### G1. Graph Fundamentals

**Q: What is a graph? How does it differ from a tree?**

> A graph G = (V, E) is a collection of vertices connected by edges. Unlike trees, graphs can have **cycles**, **disconnected components**, and **directed edges**. Trees are a special type of connected, acyclic graph.

---

**Q: What is the difference between adjacency matrix and adjacency list? When is each preferred?**

| Feature | Adjacency Matrix | Adjacency List |
|---------|-----------------|----------------|
| **Space** | O(V²) | O(V + E) |
| **Edge lookup** | O(1) | O(degree) |
| **Add edge** | O(1) | O(1) |
| **Best for** | Dense graphs | Sparse graphs |
| **Memory** | High | Low |

> 💡 **Rule of thumb:** Use **adjacency list** unless the graph is extremely dense. Most interview graphs are sparse.

---

**Q: What are in-degree and out-degree in a directed graph?**

> - **In-degree:** Number of edges pointing TO a vertex.
> - **Out-degree:** Number of edges pointing FROM a vertex.
> - **Total degree** (undirected) = in-degree + out-degree = number of adjacent vertices.

---

**Q: What is a weighted graph vs unweighted graph? How do you represent it?**

> - **Unweighted:** Adjacency list of integers (`List<List<Integer>>`).
> - **Weighted:** Adjacency list of pairs (`List<List<int[]>>`) where `int[]{neighbor, weight}`.

```java
// Weighted adjacency list
ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
adj.get(0).add(new int[]{1, 5}); // Edge 0 -> 1 with weight 5
```

---

### G2. BFS and DFS

**Q: Explain BFS. What data structure does it use and why?**

> **BFS (Breadth-First Search)** explores all neighbors of the current node before moving deeper. Uses a **Queue** (FIFO) because we need to process nodes in the exact order they were discovered — ensuring level-by-level traversal.

```java
public void bfs(int start, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");
        for (int nb : adj.get(node)) {
            if (!visited[nb]) {
                visited[nb] = true;
                queue.add(nb);
            }
        }
    }
}
```

**Time:** O(V + E), **Space:** O(V).

---

**Q: Explain DFS. How do you implement it iteratively?**

> **DFS (Depth-First Search)** explores as deeply as possible along one branch before backtracking. Uses **recursion** (implicit call stack) or an explicit **Stack**.

```java
// Iterative DFS
public void dfsIterative(int start, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    visited[start] = true;
    while (!stack.isEmpty()) {
        int node = stack.pop();
        System.out.print(node + " ");
        for (int nb : adj.get(node)) {
            if (!visited[nb]) {
                visited[nb] = true;
                stack.push(nb);
            }
        }
    }
}
```

---

**Q: What is the difference between BFS and DFS in terms of memory usage?**

> - **BFS:** Uses more memory for **wide graphs** — the queue can hold up to O(V) nodes at the widest level.
> - **DFS:** Uses less memory for **deep, narrow graphs** — the stack holds O(h) nodes (height).
> - **Worst case:** Both are O(V).

---

**Q: When should you prefer BFS over DFS?**

| Scenario | Use BFS |
|----------|---------|
| Shortest path in unweighted graph | ✅ |
| Level-order processing | ✅ |
| Finding connected components | Either |
| Cycle detection | Either |
| Finding all paths | DFS |
| Topological sort | Either (DFS or Kahn's) |

---

**Q: How do you implement BFS to find the shortest path in an unweighted graph?**

```java
public int shortestPath(int n, int[][] edges, int start, int end) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    dist[start] = 0;
    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int nb : adj.get(node)) {
            if (dist[nb] == -1) {
                dist[nb] = dist[node] + 1;
                queue.add(nb);
                if (nb == end) return dist[end];
            }
        }
    }
    return -1;
}
```

---

**Q: How do you implement DFS to detect if a path exists between two nodes?**

```java
public boolean hasPathDFS(int node, int target, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    if (node == target) return true;
    visited[node] = true;
    for (int nb : adj.get(node)) {
        if (!visited[nb] && hasPathDFS(nb, target, adj, visited)) return true;
    }
    return false;
}
```

---

### G3. Graph Variants

**Q: What is a directed graph? Give a real-world example.**

> Edges have direction: A → B does NOT mean B → A.
>
> **Examples:** Web page links, Twitter followers, task dependencies, citation networks.

---

**Q: What is an undirected graph? Give a real-world example.**

> Edges are bidirectional: A — B means A connects to B and B connects to A.
>
> **Examples:** Facebook friendships, road networks, electrical circuits.仙

---

**Q: What is a DAG (Directed Acyclic Graph)? Why is it important?**

> A directed graph with **no cycles**. Critical for:
> - **Topological sorting** (task scheduling)
> - **Dynamic programming** on DAGs
> - **Build systems** (Makefiles, Gradle)
> - **Spreadsheet dependency graphs**

---

**Q: What is a bipartite graph? How do you check if a graph is bipartite?**

> A graph is **bipartite** if vertices can be colored with **2 colors** such that no adjacent vertices share the same color.

```java
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = colorA, 2 = colorB
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !bfs(i, graph, color)) return false;
        }
        return true;
    }
    private boolean bfs(int start, int[][] graph, int[] color) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        color[start] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nextColor = (color[node] == 1) ? 2 : 1;
            for (int nb : graph[node]) {
                if (color[nb] == 0) {
                    color[nb] = nextColor;
                    queue.add(nb);
                } else if (color[nb] != nextColor) {
                    return false; // Adjacent nodes have same color
                }
            }
        }
        return true;
    }
}
```

---

**Q: What is a complete graph? How many edges does it have?**

> A complete graph has an edge between **every pair** of vertices. An undirected complete graph with n vertices has **n(n-1)/2** edges. A directed complete graph has **n(n-1)** edges.

---

**Q: What is a sparse graph vs dense graph?**

> - **Sparse:** E ≈ O(V). Adjacency list preferred.
> - **Dense:** E ≈ O(V²). Adjacency matrix preferred.
> - **Rule of thumb:** If E < V × log(V), it's sparse.

---

### G4. Graph Problems

**Q: How do you find the number of connected components in an undirected graph?**

```java
class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { dfs(i, adj, visited); count++; }
        }
        return count;
    }
}
```

**BFS approach** uses the same logic with a queue.

---

**Q: How do you detect a cycle in an undirected graph?**

> Key insight: If DFS encounters a visited neighbor that is NOT the parent, there's a cycle.

```java
class Solution {
    public boolean hasCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, -1, adj, visited)) return true;
        }
        return false;
    }
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nb : adj.get(node)) {
            if (!visited[nb]) {
                if (dfs(nb, node, adj, visited)) return true;
            } else if (nb != parent) {
                return true; // Back edge = cycle
            }
        }
        return false;
    }
}
```

---

**Q: How do you detect a cycle in a directed graph?**

> Use **3-color DFS**: WHITE (0) = unvisited, GRAY (1) = visiting (in recursion stack), BLACK (2) = visited. If we reach a GRAY node, there's a back-edge = cycle.

```java
class Solution {
    public boolean hasCycle(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]);
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            if (state[i] == 0 && dfs(i, adj, state)) return true;
        }
        return false;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] state) {
        state[node] = 1; // GRAY
        for (int nb : adj.get(node)) {
            if (state[nb] == 1) return true; // Back edge
            if (state[nb] == 0 && dfs(nb, adj, state)) return true;
        }
        state[node] = 2; // BLACK
        return false;
    }
}
```

---

**Q: How do you perform topological sort using Kahn's algorithm (BFS)?**

```java
public List<Integer> topologicalSort(int n, int[][] edges) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int[] indegree = new int[n];
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) { adj.get(e[0]).add(e[1]); indegree[e[1]]++; }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);
        for (int nb : adj.get(node)) {
            if (--indegree[nb] == 0) queue.add(nb);
        }
    }
    return result.size() == n ? result : new ArrayList<>(); // Empty if cycle exists
}
```

**Time:** O(V + E), **Space:** O(V).

---

**Q: How do you detect if a course schedule is possible? (LeetCode 207)**

> It's the same as topological sort — if a valid topological ordering exists (all nodes processed), the schedule is possible. If a cycle exists (some nodes remain with non-zero indegree), it's impossible.

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) { adj.get(pre[1]).add(pre[0]); indegree[pre[0]]++; }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.add(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll(); count++;
            for (int next : adj.get(course)) if (--indegree[next] == 0) queue.add(next);
        }
        return count == numCourses;
    }
}
```

---

**Q: How do you implement flood fill (image smoothing)?**

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) return;
        image[i][j] = newColor;
        dfs(image, i+1, j, oldColor, newColor);
        dfs(image, i-1, j, oldColor, newColor);
        dfs(image, i, j+1, oldColor, newColor);
        dfs(image, i, j-1, oldColor, newColor);
    }
}
```

---

**Q: How do you find the number of provinces (connected components in an undirected graph represented as an adjacency matrix)?**

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[node][j] == 1 && !visited[j]) dfs(graph, j, visited);
        }
    }
}
```

---

## 🕸️ Graph — Advanced & Hard (Medium–Hard)

---

### G5. Graph Advanced

**Q: How does Dijkstra's algorithm work? Why is it correct?**

> Dijkstra finds shortest paths from a source to all vertices in a weighted graph with **non-negative** weights.
>
> **Correctness relies on:** When a node is extracted from the priority queue, its shortest distance is **finalized**. Since all edge weights are ≥ 0, no future path can offer a shorter distance.
>
> **Why priority queue?** We always need the unvisited node with the **minimum tentative distance**.

```java
class Solution {
    public int[] dijkstra(int n, int[][] edges, int start) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];
            if (d > dist[node]) continue; // Stale entry
            for (int[] nb : adj.get(node)) {
                int nextNode = nb[0], weight = nb[1];
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist;
    }
}
```

**Time:** O((V + E) log V), **Space:** O(V + E).

---

**Q: Why can't Dijkstra handle negative weight edges?**

> Dijkstra assumes once a node is "settled" (popped from PQ), its distance won't decrease. A negative edge could create a cheaper path to an already-settled node, which Dijkstra would never re-examine.

```
A --1--> B --(-5)--> C
```
Dijkstra settles B (dist=1) before discovering the cheaper path A→B→C (dist=-4).

**Alternative:** Use **Bellman-Ford** (O(VE)) or **SPFA** (average O(E)).

---

**Q: Explain Bellman-Ford algorithm. How does it detect negative cycles?**

> Bellman-Ford relaxes all edges **V-1 times** (any shortest path has at most V-1 edges). Then runs a **V-th iteration** — if any edge can still be relaxed, a negative cycle exists.

```java
public int[] bellmanFord(int n, int[][] edges, int start) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int[] e : edges) {
            if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]]) {
                dist[e[1]] = dist[e[0]] + e[2];
            }
        }
    }
    // Check negative cycle
    for (int[] e : edges) {
        if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]]) {
            throw new RuntimeException("Negative cycle detected!");
        }
    }
    return dist;
}
```

**Time:** O(VE), **Space:** O(V).

---

**Q: Explain Floyd-Warshall algorithm. When is it preferred over Dijkstra?**

> Floyd-Warshall finds **all-pairs shortest paths** using dynamic programming.
>
> **Algorithm:** For each intermediate vertex k, update dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]).
>
> **Time:** O(V³), **Space:** O(V²).
>
> **Preferred when:** Graph is small, dense, or you need all-pairs shortest paths. Handles negative edges (but not negative cycles).

```java
public int[][] floydWarshall(int n, int[][] edges, int INF) {
    int[][] dist = new int[n][n];
    for (int[] row : dist) Arrays.fill(row, INF);
    for (int i = 0; i < n; i++) dist[i][i] = 0;
    for (int[] e : edges) dist[e[0]][e[1]] = e[2];
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (dist[i][k] != INF && dist[k][j] != INF)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    return dist;
}
```

---

**Q: How does the Union-Find (Disjoint Set Union) data structure work?**

> Supports two operations: **Find** (which set does element belong to?) and **Union** (merge two sets).
>
> With **path compression** and **union by rank**, achieves amortized **O(α(n))** per operation (inverse Ackermann, effectively O(1)).

```java
class DSU {
    int[] parent, rank;
    DSU(int n) {
        parent = new int[n]; rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x])); // Path compression
    }
    public boolean union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return false;
        if (rank[rx] < rank[ry]) parent[rx] = ry;
        else if (rank[rx] > rank[ry]) parent[ry] = rx;
        else { parent[ry] = rx; rank[rx]++; }
        return true;
    }
}
```

**Kruskal's MST using DSU:**

```java
public int kruskalMST(int n, int[][] edges) {
    Arrays.sort(edges, (a, b) -> a[2] - b[2]); // Sort by weight
    DSU dsu = new DSU(n);
    int mstWeight = 0, edgesUsed = 0;
    for (int[] e : edges) {
        if (dsu.union(e[0], e[1])) {
            mstWeight += e[2];
            if (++edgesUsed == n - 1) break;
        }
    }
    return mstWeight;
}
```

---

**Q: What is Kosaraju's algorithm for finding Strongly Connected Components?**

> **2-pass DFS algorithm:**
> 1. **Pass 1:** Run DFS, push nodes to stack based on finish times.
> 2. **Transpose:** Reverse all edges.
> 3. **Pass 2:** Pop from stack, run DFS on transposed graph. Each DFS tree = an SCC.

```java
public List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
    // Build graph and reversed graph
    List<List<Integer>> adj = new ArrayList<>(), radj = new ArrayList<>();
    for (int i = 0; i < n; i++) { adj.add(new ArrayList<>()); radj.add(new ArrayList<>()); }
    for (int[] e : edges) { adj.get(e[0]).add(e[1]); radj.get(e[1]).add(e[0]); }

    // Pass 1: Order by finish time
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) if (!visited[i]) dfs1(i, adj, visited, stack);

    // Pass 2: Process transposed graph
    Arrays.fill(visited, false);
    List<List<Integer>> sccs = new ArrayList<>();
    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (!visited[node]) {
            List<Integer> scc = new ArrayList<>();
            dfs2(node, radj, visited, scc);
            sccs.add(scc);
        }
    }
    return sccs;
}
private void dfs1(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
    visited[node] = true;
    for (int nb : adj.get(node)) if (!visited[nb]) dfs1(nb, adj, visited, stack);
    stack.push(node);
}
private void dfs2(int node, List<List<Integer>> radj, boolean[] visited, List<Integer> scc) {
    visited[node] = true;
    for (int nb : radj.get(node)) if (!visited[nb]) { scc.add(nb); dfs2(nb, radj, visited, scc); }
}
```

---

**Q: What is Tarjan's algorithm for SCC?**

> Single-pass DFS using `tin[u]` (discovery time) and `low[u]` (lowest reachable discovery time). When `low[u] == tin[u]`, node u is the root of an SCC.

**Time:** O(V + E), **Space:** O(V).

---

### G6. Graph Hard

**Q: How does the A* search algorithm differ from Dijkstra?**

> A* uses a **heuristic function** h(n) that estimates the cost to reach the goal. It prioritizes nodes with lowest `f(n) = g(n) + h(n)`, where g(n) is the actual cost from start and h(n) is the estimated cost to goal.
>
> - If h(n) = 0, A* = Dijkstra.
> - If h(n) is admissible (never overestimates), A* is **optimal** and **faster** than Dijkstra.
> - If h(n) is consistent, A* never needs to re-open closed nodes.

---

**Q: What is network flow? What is the max-flow min-cut theorem?**

> **Network flow** finds the maximum amount of flow from a **source** to a **sink** in a flow network with capacity constraints on edges.
>
> **Max-Flow Min-Cut Theorem:** The maximum flow equals the capacity of the minimum cut (the cheapest set of edges to remove to disconnect source from sink).
>
> **Ford-Fulkerson / Edmonds-Karp** algorithm finds max flow using augmenting paths. Time: O(VE²) for Edmonds-Karp (BFS-based).

---

**Q: How do you find all bridges in an undirected graph?**

> Using Tarjan's bridge-finding algorithm: Edge (u,v) is a bridge if `low[v] > tin[u]`.

```java
int timer = 0;
public List<List<Integer>> bridges(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
    int[] tin = new int[n], low = new int[n];
    Arrays.fill(tin, -1);
    List<List<Integer>> result = new ArrayList<>();
    dfs(0, -1, adj, tin, low, result, timer);
    return result;
}
private void dfs(int u, int parent, List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> result, int timer) {
    tin[u] = low[u] = timer++;
    for (int v : adj.get(u)) {
        if (v == parent) continue;
        if (tin[v] == -1) {
            dfs(v, u, adj, tin, low, result, timer);
            low[u] = Math.min(low[u], low[v]);
            if (low[v] > tin[u]) result.add(Arrays.asList(u, v)); // Bridge!
        } else {
            low[u] = Math.min(low[u], tin[v]);
        }
    }
}
```

---

**Q: How do you find articulation points (cut vertices)?**

> A vertex u is an articulation point if:
> - It's the **root** of the DFS tree with ≥ 2 children.
> - It's **not** the root and has a child v where `low[v] >= tin[u]`.

```java
int timer = 0;
public List<Integer> articulationPoints(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
    int[] tin = new int[n], low = new int[n];
    Arrays.fill(tin, -1);
    boolean[] visited = new boolean[n];
    List<Integer> result = new ArrayList<>();
    boolean[] isAP = new boolean[n];
    dfs(0, -1, adj, tin, low, visited, isAP);
    for (int i = 0; i < n; i++) if (isAP[i]) result.add(i);
    return result;
}
private void dfs(int u, int parent, List<List<Integer>> adj, int[] tin, int[] low, boolean[] visited, boolean[] isAP) {
    visited[u] = true;
    tin[u] = low[u] = timer++;
    int children = 0;
    for (int v : adj.get(u)) {
        if (v == parent) continue;
        if (!visited[v]) {
            children++;
            dfs(v, u, adj, tin, low, visited, isAP);
            low[u] = Math.min(low[u], low[v]);
            // AP condition
            if (parent == -1 && children > 1) isAP[u] = true;
            if (parent != -1 && low[v] >= tin[u]) isAP[u] = true;
        } else {
            low[u] = Math.min(low[u], tin[v]);
        }
    }
}
```

---

**Q: How do you find the shortest path in a weighted graph with 0-1 weights?**

> **0-1 BFS** using a **Deque**. Weight-0 edges push to front, weight-1 edges push to back. Achieves O(V + E).

```java
public int shortestPath01(int n, int[][] edges, int start, int end) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) { adj.get(e[0]).add(new int[]{e[1], e[2]}); }
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(start);
    while (!deque.isEmpty()) {
        int node = deque.poll();
        for (int[] nb : adj.get(node)) {
            int nextNode = nb[0], weight = nb[1];
            if (dist[node] + weight < dist[nextNode]) {
                dist[nextNode] = dist[node] + weight;
                if (weight == 0) deque.addFirst(nextNode);
                else deque.addLast(nextNode);
            }
        }
    }
    return dist[end];
}
```

---

**Q: How do you find the number of ways to reach a destination in a weighted DAG?**

> Combine **topological sort** with **DP**. After topo sort, process nodes in order and accumulate paths.

```java
public int countPaths(int n, int[][] edges, int src, int dst) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : edges) { adj.get(e[0]).add(e[1]); }
    int[] indegree = new int[n];
    for (int[] e : edges) indegree[e[1]]++;
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);
    int[] ways = new int[n];
    ways[src] = 1;
    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int nb : adj.get(node)) {
            ways[nb] += ways[node];
            if (--indegree[nb] == 0) queue.add(nb);
        }
    }
    return ways[dst];
}
```

---

### G7. Graph Specialized

**Q: What is Johnson's algorithm? When is it used?**

> Johnson's algorithm finds **all-pairs shortest paths** in a sparse graph with negative weights (but no negative cycles) by combining Bellman-Ford and Dijkstra.
>
> 1. Add a virtual source connected to all nodes with weight 0.
> 2. Run Bellman-Ford to get potentials h(v).
> 3. Reweight edges: w'(u,v) = w(u,v) + h(u) - h(v) (all weights become ≥ 0).
> 4. Run Dijkstra from every node with reweighted edges.
>
> **Time:** O(V² log V + VE), better than Floyd-Warshall for sparse graphs.

---

**Q: What is a Segment Tree? How is it used in competitive programming on trees?**

> A Segment Tree allows **range queries** (sum, min, max) and **point updates** in O(log n) time. On trees, it's combined with **Euler tour** or **Heavy-Light Decomposition (HLD)** to answer path queries between any two nodes.

**Heavy-Light Decomposition:**
- Decomposes a tree into disjoint chains.
- Path queries between u and v become O(log² n) segment tree queries on chains.

---

## 🔥 Cross-Topic & Company-Specific (Hard)

---

### X1. Combined Concepts

**Q: How do you find the minimum spanning tree of a graph that also has tree constraints?**

> This is a **Degree-Constrained MST** problem — NP-hard in general. Approximation algorithms exist. Common in interview variations: find MST with at most K edges of a specific type.

---

**Q: Given a tree, how do you find the longest path (diameter) using two BFS/DFS?**

> **Two-pass approach:**
> 1. BFS/DFS from any node → find the farthest node A.
> 2. BFS/DFS from A → find the farthest node B.
> 3. Distance from A to B is the diameter.

```java
// Step 1: Find farthest node from root
int[] bfs(int start, List<List<Integer>> adj) {
    int[] dist = new int[adj.size()];
    Arrays.fill(dist, -1);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start); dist[start] = 0;
    int farthest = start;
    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int nb : adj.get(node)) {
            if (dist[nb] == -1) { dist[nb] = dist[node] + 1; queue.add(nb); }
            if (dist[nb] > dist[farthest]) farthest = nb;
        }
    }
    return new int[]{farthest, dist[farthest]};
}
// Diameter = bfs(bfs(0)[0])[1]
```

---

**Q: How do you find the number of spanning trees in a graph?**

> **Kirchhoff's Matrix Tree Theorem:** The number of spanning trees equals any cofactor of the **Laplacian matrix** (Degree matrix minus Adjacency matrix). Compute the determinant of any (n-1)×(n-1) submatrix.

---

**Q: How do you find if a graph is a tree?**

> A graph is a tree if and only if:
> 1. It is **connected** (all nodes reachable from any node).
> 2. It has exactly **V - 1** edges.
> 3. It has **no cycles**.
>
> Check any two of the three conditions (the third follows from the first two).

---

### X2. System Design with Trees

**Q: How would you design a file system using a tree?**

> Each directory is a node with children (subdirectories and files). The root `/` is the tree root. Use a **n-ary tree** where each node stores metadata (name, size, permissions, type). Operations: `cd` (traverse), `ls` (list children), `mkdir` (add child), `rm` (delete subtree).

---

**Q: How would you design an auto-complete system using a Trie?**

> A **Trie** is a tree where each node represents a character. Root to any node spells a prefix. Store words by inserting each character as a node. For auto-complete, traverse to the prefix node, then DFS to find all words in the subtree.

---

**Q: How do you design a database index using a B+ Tree?**

> B+ Tree stores keys in internal nodes (for routing) and data in leaf nodes (linked list). Disk pages align with tree nodes. Supports O(log n) lookups and O(k) range queries for k results. MySQL/PostgreSQL use B+ Trees for clustered indexes.

---

### X3. System Design with Graphs

**Q: How would you design a social network friend recommendation system using graphs?**

> - **Graph model:** Users = vertices, friendships = undirected edges.
> - **Recommendation:** Find **friends-of-friends** (BFS 2 levels deep) not already connected.
> - **Ranking:** Score by mutual friends count + interaction weight.
> - **Scale:** Use **sharded adjacency lists**, **graph databases** (Neo4j), or distributed processing (MapReduce Pregel).

---

**Q: How would you design a navigation system (shortest path) using graphs?**

> - **Graph model:** Intersections = vertices, roads = weighted edges (distance/time).
> - **Algorithm:** A* with geographic distance heuristic for fast pathfinding.
> - **Preprocessing:** Contraction Hierarchies for continent-scale queries (millions of nodes).
> - **Real-time:** Live traffic updates modify edge weights dynamically.

---

**Q: How would you design a task scheduler with dependencies using topological sort?**

> - **Graph model:** Tasks = vertices, dependencies = directed edges.
> - **Algorithm:** Kahn's BFS topological sort.
> - **Cycle detection:** If topological sort doesn't include all vertices, there's a circular dependency → report error.
> - **Parallelism:** Nodes with indegree 0 at the same level can be executed concurrently.

---

### X4. Company-Specific Patterns

**Q: Google-style: How do you solve a grid-based problem (Number of Islands, Surrounded Regions)?**

> These are **graph problems on implicit grids**. Each cell is a node, adjacent cells (4-directional or 8-directional) are edges.

```java
// General pattern for grid BFS
int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
public void bfsGrid(int[][] grid, int i, int j, boolean[][] visited) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{i, j});
    visited[i][j] = true;
    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] d : directions) {
            int ni = cell[0] + d[0], nj = cell[1] + d[1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length
                && !visited[ni][nj] && grid[ni][nj] == target) {
                visited[ni][nj] = true;
                queue.add(new int[]{ni, nj});
            }
        }
    }
}
```

**Key:** Boundary checks, visited array, direction array.

---

**Q: Amazon-style: How do you serialize/deserialize a binary tree for a distributed system?**

> Use **BFS level-order serialization** with null markers. The serialized string must be compact and parseable. For distributed systems, add checksums, compression, and chunking.

```java
// Level-order serialization
public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) { sb.append("null,"); continue; }
        sb.append(node.data).append(",");
        queue.add(node.left); queue.add(node.right);
    }
    return sb.toString();
}
```

---

**Q: Meta/Facebook-style: How do you clone a graph with possible cycles?**

> Use a **HashMap<Node, Node>** to map original nodes to cloned nodes. During DFS/BFS, if a neighbor is already cloned (in the map), reuse it. This handles cycles naturally.

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
        for (Node nb : node.neighbors) {
            copy.neighbors.add(dfs(nb, map));
        }
        return copy;
    }
}
```

---

**Q: Microsoft-style: How do you handle BST operations with duplicates?**

> Option 1: Store a **count** in each node (`TreeNode { data, count, left, right }`). Option 2: Allow duplicates to go either left or right consistently. Option 3: Use **augmented BST** (Red-Black Tree) with satellite data.

```java
class TreeNode {
    int data;
    int count; // Number of occurrences
    TreeNode left, right;
    TreeNode(int data) { this.data = data; this.count = 1; }
}
```

---

**Q: Flipkart/Paytm-style: How do you find the shortest path with at most K stops?**

> **Bellman-Ford with K iterations** or **BFS with level tracking**.

```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    for (int i = 0; i <= k; i++) {
        int[] temp = dist.clone();
        for (int[] f : flights) {
            if (dist[f[0]] != Integer.MAX_VALUE && dist[f[0]] + f[2] < temp[f[1]]) {
                temp[f[1]] = dist[f[0]] + f[2];
            }
        }
        dist = temp;
    }
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
}
```

---

**Q: Uber/Lyft-style: How do you assign drivers to riders optimally (minimum cost matching)?**

> This is the **Assignment Problem** — solved using the **Hungarian Algorithm** in O(V³) or approximated with min-cost max-flow. For ride-sharing, use bipartite matching where riders on one side, drivers on the other, edge weights = distance/time.

---

**Q: Netflix-style: How do you recommend content using graph-based algorithms?**

> Build a **bipartite graph** (Users ↔ Content). Use **personalized PageRank** or **random walks** to find content similar to what a user has liked. Weight edges by watch time, ratings, and similarity scores. Use **community detection** for genre-based recommendations.

---

**Q: How do you find the cheapest flight route with at most K stops?**

> Same as Flipkart pattern above — **Bellman-Ford with K iterations** or **Dijkstra with stop count**.

```java
// Dijkstra with stop limit
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] f : flights) adj.get(f[0]).add(new int[]{f[1], f[2]});
    // {cost, node, stops}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[]{0, src, 0});
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int cost = curr[0], node = curr[1], stops = curr[2];
        if (node == dst) return cost;
        if (stops > k) continue;
        for (int[] nb : adj.get(node)) {
            pq.add(new int[]{cost + nb[1], nb[0], stops + 1});
        }
    }
    return -1;
}
```

---

**Q: How do you find the minimum cost to connect all cities? (MST real-world)**

> **Kruskal's Algorithm** using Union-Find. Sort all roads by cost, greedily add cheapest road that doesn't create a cycle until all cities are connected.

```java
public int minimumCost(int n, int[][] connections) {
    Arrays.sort(connections, (a, b) -> a[2] - b[2]);
    DSU dsu = new DSU(n);
    int cost = 0, edges = 0;
    for (int[] conn : connections) {
        if (dsu.union(conn[0], conn[1])) {
            cost += conn[2];
            if (++edges == n - 1) return cost;
        }
    }
    return -1; // Can't connect all cities
}
```

---

## 📋 Quick Reference Card

| Topic | Key Algorithm | Time | Space |
|-------|--------------|------|-------|
| Tree Traversals | DFS (recursive) / Morris | O(n) | O(h) / O(1) |
| BST Search | Binary Search | O(log n) avg | O(1) iter |
| BST Validate | DFS with bounds | O(n) | O(h) |
| LCA (General Tree) | DFS | O(n) | O(h) |
| LCA (BST) | BST Property | O(log n) avg | O(h) |
| Graph BFS | Queue | O(V+E) | O(V) |
| Graph DFS | Stack / Recursion | O(V+E) | O(V) |
| Cycle Undirected | DFS + parent | O(V+E) | O(V) |
| Cycle Directed | 3-color DFS | O(V+E) | O(V) |
| Topological Sort | Kahn's / DFS | O(V+E) | O(V) |
| Shortest Path (unweighted) | BFS | O(V+E) | O(V) |
| Shortest Path (weighted) | Dijkstra | O((V+E)log V) | O(V+E) |
| Negative Weights | Bellman-Ford | O(VE) | O(V) |
| All-Pairs Shortest | Floyd-Warshall | O(V³) | O(V²) |
| MST (Sparse) | Kruskal + DSU | O(E log V) | O(V) |
| MST (Dense) | Prim's | O(V²) | O(V) |
| SCC | Tarjan / Kosaraju | O(V+E) | O(V) |
| DSU | Path Comp + Rank | O(α(n)) ~ O(1) | O(V) |

---

*Master these questions and you'll be ready for any Trees & Graphs interview at any company level.* 🚀
