# 1. Linked List

This directory contains Java implementations of **Singly Linked List**, **Doubly Linked List**, and a collection of **popular LeetCode Linked List problems**. The code is written from scratch to understand the internal working of linked lists before solving interview questions.

---

## 📂 Directory Structure

```
1. LinkedList
│
├── DoublyLinkedList
│   ├── DLL.java
│   ├── User.java
│   └── Main.java
│
├── SinglyLinkedList
│   ├── SinglyLinkedList.java
│   ├── Main.java
│   └── Problems
│       ├── BinaryToNumber.java
│       ├── LinkedListCycle.java
│       ├── MiddleofTheLinkedList.java
│       └── ReverseList.java
```

---

# 📖 Contents

## Singly Linked List

Implementation of a custom Singly Linked List without using Java Collections.

### Operations Implemented

- Insert at Beginning
- Insert at End
- Insert at Any Position
- Delete First Node
- Delete Last Node
- Delete at Any Position
- Find a Node
- Get Node by Index
- Display the Linked List

### Features

- Maintains both **head** and **tail** references.
- Tracks the current size of the list.
- Supports efficient insertion at the end using a tail pointer.
- Demonstrates manual node manipulation.

---

## Doubly Linked List

Implementation of a custom Doubly Linked List using a `User` object as node data.

Each node stores:

- Previous Pointer
- Next Pointer
- User Object

### Operations Implemented

- Insert at Beginning
- Insert at End
- Insert at Any Position
- Delete First Node
- Delete Last Node
- Delete at Any Position
- Display Forward
- Display Backward
- Get Tail Node
- Get Node by Index

### User Model

Each node stores a `User` object containing:

- User ID
- Name
- Age
- Salary

This demonstrates how linked lists can store custom objects instead of primitive data types.

---

# 🧩 Interview Problems

The `Problems` folder contains solutions to commonly asked Linked List interview questions.

| Problem | LeetCode | Concept |
|----------|-----------|---------|
| Binary Number in a Linked List to Integer | 1290 | Binary Conversion |
| Linked List Cycle | 141 | Floyd's Slow & Fast Pointer |
| Middle of the Linked List | 876 | Two Pointer Technique |
| Reverse Linked List | 206 | In-place Reversal |

---

# 📚 Concepts Covered

- Node Design
- Head Pointer
- Tail Pointer
- Previous Pointer
- Dynamic Memory Allocation
- Traversal
- Insertion
- Deletion
- Searching
- Two Pointer Technique
- Slow & Fast Pointer
- In-place Reversal

---

# ⏱️ Time Complexity

| Operation | Singly | Doubly |
|------------|:------:|:------:|
| Insert First | O(1) | O(1) |
| Insert Last | O(1)* | O(n) |
| Insert at Index | O(n) | O(n) |
| Delete First | O(1) | O(1) |
| Delete Last | O(n) | O(n) |
| Delete at Index | O(n) | O(n) |
| Search | O(n) | O(n) |
| Display | O(n) | O(n) |

> *Singly Linked List maintains a tail pointer, making insertion at the end **O(1)**.

---

# 🚀 Running the Code

Compile and run the `Main.java` file inside the desired implementation.

### Singly Linked List

```bash
javac Main.java
java Main
```

### Doubly Linked List

```bash
javac Main.java
java Main
```

---

# 🎯 Learning Outcomes

After completing this directory, you should understand:

- How linked lists work internally.
- Difference between Singly and Doubly Linked Lists.
- Why linked lists provide efficient insertions and deletions.
- How pointer manipulation works.
- How interview problems use techniques like:
  - Slow & Fast Pointer
  - In-place Reversal
  - Cycle Detection

---

# 📌 Notes

This implementation is intended for **learning and interview preparation**, focusing on building linked lists from scratch rather than relying on Java's built-in `LinkedList` class.

It also serves as a foundation for advanced data structures such as:

- Stack
- Queue
- LRU Cache
- HashMap Chaining
- Graph Adjacency Lists
