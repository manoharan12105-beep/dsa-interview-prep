# 🚀 DSA Interview Prep

A structured **Java** repository for cracking coding interviews. It holds data structures built from scratch, must-know algorithm patterns with visual explanations, solved LeetCode problems, and interactive study notes on **Computer Networks, System Design and Linux**.

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)
![Java files](https://img.shields.io/badge/Java%20files-62-blue)
![Solved problems](https://img.shields.io/badge/Solved%20problems-31-brightgreen)
![Topics](https://img.shields.io/badge/Topics-8%20algorithms%20%7C%205%20data%20structures-purple)

---

## 📑 Table of Contents

- [Repository Structure](#-repository-structure)
- [Algorithms](#-algorithms)
- [Data Structures](#️-data-structures)
- [Other Concepts: Study Notes](#-other-concepts-study-notes)
- [How to Use This Repo](#-how-to-use-this-repo)
- [How to Run the Code](#️-how-to-run-the-code)
- [Roadmap](#️-roadmap)
- [Contributing](#-contributing)

---

## 📂 Repository Structure

```text
dsa-interview-prep
│
├── Algorithms
│   ├── 1. Kadane's Algorithm
│   ├── 2. Prefix Sum
│   ├── 3. Sliding Window
│   ├── 4. Two Pointers
│   ├── 5. Moore's Voting Algorithm
│   ├── 6. Dutch National Flag Algorithm
│   ├── 7. KMP Algorithm
│   └── 8. Rabin-Karp Algorithm
│        └── each has: Explanation.md · VisualRepresentation.png · <Algorithm>.java · Problems/
│
├── Data Structures
│   ├── 1. LinkedList          (Singly + Doubly, with problems)
│   ├── 2.1 Stack              (built-in + custom + dynamic)
│   ├── 2.2 Queue              (built-in + custom + circular + dynamic)
│   ├── 3. Tree                (Binary Tree, BST, AVL, Segment Tree)
│   └── TREES_AND_GRAPHS_INTERVIEW_QUESTIONS.md
│
└── Other Concepts
    ├── Computer Networks      (Packet Journey notes)
    ├── System Design          (System Design Master Notes)
    └── Linux                  (Linux Master Notes)
```

---

## 🧠 Algorithms

Every algorithm folder follows the same learning path:

> 📖 **Explanation.md** (brute force → optimal idea, dry run, complexity) → 🖼️ **VisualRepresentation.png** → 💻 **core Java implementation** → 🧩 **Problems/** (solved problems and a practice list)

| # | Pattern | Core idea | Time | Solved problems |
| :-: | :--- | :--- | :-: | :--- |
| 1 | [Kadane's Algorithm](./Algorithms/1.%20Kadane's%20Algorithm) | Extend the current subarray or start fresh | O(n) | 53 Maximum Subarray · 918 Maximum Sum Circular Subarray · 152 Maximum Product Subarray · 1191 K-Concatenation Maximum Sum |
| 2 | [Prefix Sum](./Algorithms/2.%20Prefix%20Sum) | Precompute running sums to answer range queries fast | O(n) | 303 Range Sum Query · 724 Find Pivot Index · 560 Subarray Sum Equals K |
| 3 | [Sliding Window](./Algorithms/3.%20Sliding%20Window) | Grow and shrink a window instead of recomputing | O(n) | 643 Maximum Average Subarray I · 1456 Max Vowels in a Substring · 3 Longest Substring Without Repeating Characters · 424 Longest Repeating Character Replacement · 1004 Max Consecutive Ones III |
| 4 | [Two Pointers](./Algorithms/4.%20Two%20Pointers) | Move two indices toward or with each other | O(n) | 125 Valid Palindrome · 167 Two Sum II · 11 Container With Most Water · 15 3Sum |
| 5 | [Moore's Voting Algorithm](./Algorithms/5.%20Moore's%20Voting%20Algorithm) | Cancel out different votes to find the majority | O(n), O(1) space | 169 Majority Element · 229 Majority Element II |
| 6 | [Dutch National Flag](./Algorithms/6.%20Dutch%20National%20Flag%20Algorithm) | Three pointers split the array into 3 partitions in one pass | O(n) | 75 Sort Colors |
| 7 | [KMP Algorithm](./Algorithms/7.%20KMP%20Algorithm) | LPS array avoids re-checking matched characters | O(n + m) | 28 Find the Index of the First Occurrence · 459 Repeated Substring Pattern |
| 8 | [Rabin-Karp Algorithm](./Algorithms/8.%20Rabin-Karp%20Algorithm) | Rolling hash compares windows in O(1) | O(n + m) avg | 28 Find the Index of the First Occurrence · 187 Repeated DNA Sequences |

> 📌 Each `Problems/README.md` also lists **extra practice problems** (Easy 🟢 / Medium 🟡 / Hard 🔴) to solve next.

---

## 🏗️ Data Structures

All data structures are **implemented from scratch** to show how they work internally, alongside Java's built-in versions.

| Data Structure | What's inside | Solved problems |
| :--- | :--- | :--- |
| [🔗 Linked List](./Data%20Structures/1.%20LinkedList) | Singly Linked List and Doubly Linked List (insert, delete, display, custom `User` objects) | **Singly:** Reverse List, Middle of the Linked List, Linked List Cycle, Binary to Number · **Doubly:** Find Middle, Palindrome Check, Target Pairs, Clockwise Rotate |
| [📚 Stack](./Data%20Structures/2.1%20Stack) | Built-in `Stack`, custom fixed-size stack, dynamic (resizing) stack, custom `StackException` | Method reference diagrams |
| [🚶 Queue](./Data%20Structures/2.2%20Queue) | Built-in `Queue`, custom queue, **circular queue**, dynamic queue | Method reference diagram |
| [🌳 Tree](./Data%20Structures/3.%20Tree) | Binary Tree · Binary Search Tree · **AVL Tree** (self-balancing rotations) · **Segment Tree** (range queries) | Traversals, insert, balance check |
| [🎯 Trees & Graphs Q&A](./Data%20Structures/TREES_AND_GRAPHS_INTERVIEW_QUESTIONS.md) | Frequently asked interview questions from Easy to Hard: traversals, BST, BFS/DFS, shortest paths, MST, SCC | Quick reference card included |

---

## 📘 Other Concepts: Study Notes

CS fundamentals that interviews test beyond DSA. Each set is an **interactive HTML page**: download it and open it in any browser, and it works offline.

| Topic | Notes | Highlights |
| :--- | :--- | :--- |
| 🌐 [Computer Networks](./Other%20Concepts/Computer%20Networks) | *Packet Journey* | OSI and TCP/IP layers, DNS, TCP handshake, subnetting, NAT, ARP · subnet calculator · 66 flashcards |
| 🏛️ [System Design](./Other%20Concepts/System%20Design) | *System Design Master Notes* | Scaling, load balancers, caching, replication, sharding, CAP, queues · simulators · graded flashcards |
| 🐧 [Linux](./Other%20Concepts/Linux) | *Linux Master Notes* | Commands, grep/find/awk/sed, permissions, processes, SSH/SCP, Bash scripting, cron & Airflow · practice terminal · 92 flashcards |

---

## 📖 How to Use This Repo

1. **Pick a pattern.** Start with `Algorithms/1. Kadane's Algorithm` and go in order; each builds intuition for the next.
2. **Read `Explanation.md`** and study the visual before looking at the code.
3. **Try the problems yourself** on LeetCode first, then compare with the solutions in `Problems/`.
4. **Do the extra practice list** in each `Problems/README.md`.
5. **Revise** with the Trees & Graphs Q&A and the study notes before interviews.

---

## ▶️ How to Run the Code

Requires **Java 8+** (JDK).

```bash
git clone https://github.com/manoharan12105-beep/dsa-interview-prep.git
cd dsa-interview-prep

# Example: run the Singly Linked List demo
cd "Data Structures/1. LinkedList/SinglyLinkedList"
javac *.java
java Main
```

> 💡 Folder names contain spaces, so wrap paths in quotes. You can also open the repo in **IntelliJ IDEA** or **VS Code** and run any file that has a `main` method.

---

## 🗺️ Roadmap

- [x] Linked List · Stack · Queue · Trees (BT, BST, AVL, Segment Tree)
- [x] Kadane · Prefix Sum · Sliding Window · Two Pointers · Moore's Voting · Dutch National Flag · KMP · Rabin-Karp
- [x] Computer Networks · System Design · Linux notes
- [ ] Heap / Priority Queue
- [ ] Hashing
- [ ] Graph implementations (BFS, DFS, Dijkstra, Topological Sort)
- [ ] Binary Search patterns
- [ ] Recursion & Backtracking
- [ ] Dynamic Programming
- [ ] DBMS & OOP notes

---

## 🤝 Contributing

Found a bug or have a better approach? Open an **issue** or a **pull request**. Suggestions for new patterns and problems are welcome.

---

## ⭐ Support

If this repo helps your interview prep, give it a **star ⭐**. It keeps the motivation going!

Made with ☕ and consistency by [@manoharan12105-beep](https://github.com/manoharan12105-beep)
