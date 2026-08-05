# 1. Linked List

This directory contains Java implementations of **Singly Linked List**, **Doubly Linked List**, and a collection of **interview and LeetCode-style Linked List problems**. All implementations are written from scratch to help understand pointer manipulation and the internal workings of linked lists.

---

# 📂 Directory Structure

```text
1. LinkedList
│
├── DoublyLinkedList
│   ├── DLL.java
│   ├── User.java
│   ├── Main.java
│   └── Problems
│       ├── FindMidElement.java
│       └── PalindromeCheck.java
│
├── SinglyLinkedList
│   ├── SinglyLinkedList.java
│   ├── Main.java
│   └── Problems
│       ├── BinaryToNumber.java
│       ├── LinkedListCycle.java
│       ├── MiddleOfTheLinkedList.java
│       └── ReverseList.java
│
└── README.md
```

---

# 📖 Contents

## Singly Linked List

Implementation of a custom **Singly Linked List** without using Java Collections.

### Operations Implemented

- Insert at Beginning
- Insert at End
- Insert at Any Position
- Delete First Node
- Delete Last Node
- Delete at Any Position
- Search a Node
- Get Node by Index
- Display the Linked List

### Features

- Maintains both **head** and **tail** pointers.
- Tracks the current size of the list.
- Efficient insertion at the end using a tail pointer.
- Demonstrates pointer manipulation from scratch.

---

## Doubly Linked List

Implementation of a custom **Doubly Linked List** using a `User` object as node data.

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

This demonstrates storing custom objects inside linked list nodes instead of primitive data types.

---

# 🧩 Interview Problems

## Singly Linked List Problems

| Problem | LeetCode | Concept |
|----------|:--------:|---------|
| Binary Number in a Linked List to Integer | 1290 | Binary Conversion |
| Linked List Cycle | 141 | Floyd's Cycle Detection |
| Middle of the Linked List | 876 | Slow & Fast Pointer |
| Reverse Linked List | 206 | In-place Reversal |

---

## Doubly Linked List Problems

| Problem | Concept |
|----------|---------|
| Find Middle Element | Slow & Fast Pointer |
| Palindrome Check | Two Pointer Technique |

---

# 📚 Concepts Covered

- Node Design
- Head Pointer
- Tail Pointer
- Previous Pointer
- Traversal
- Searching
- Insertion
- Deletion
- Dynamic Memory Allocation
- Two Pointer Technique
- Slow & Fast Pointer
- In-place Reversal
- Palindrome Checking
- Forward & Reverse Traversal

---

# ⏱️ Time Complexity

| Operation | Singly | Doubly |
|------------|:------:|:------:|
| Insert First | O(1) | O(1) |
| Insert Last* | O(1) | O(1) |
| Insert at Index | O(n) | O(n) |
| Delete First | O(1) | O(1) |
| Delete Last | O(n) | O(1) |
| Delete at Index | O(n) | O(n) |
| Search | O(n) | O(n) |
| Display | O(n) | O(n) |
| Reverse Traversal | — | O(n) |

> *Assumes the linked list maintains a tail pointer.

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

After completing this directory, you should be able to:

- Build linked lists from scratch.
- Understand the difference between Singly and Doubly Linked Lists.
- Perform insertion, deletion, traversal, and searching operations.
- Manipulate pointers confidently.
- Apply common interview techniques such as:
  - Slow & Fast Pointer
  - Two Pointer Technique
  - Cycle Detection
  - In-place Reversal
  - Palindrome Checking

---

# 📌 Notes

This module is intended for **Data Structures learning** and **coding interview preparation**. It emphasizes implementing linked lists manually instead of using Java's built-in `LinkedList` class.
