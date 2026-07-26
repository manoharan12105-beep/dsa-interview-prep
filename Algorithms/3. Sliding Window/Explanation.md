# 📖 Sliding Window

## 📌 Definition

**Sliding Window** is an optimization technique used to solve problems involving **contiguous subarrays or substrings**.

Instead of checking every possible window independently, we reuse previous computations by moving the window one step at a time.

---

## 🤔 Why Do We Need Sliding Window?

Suppose we have the following array:

```text
[2, 1, 5, 1, 3, 2]
```

Now imagine we need:

```text
Find the maximum sum of every subarray of size 3.
```

A straightforward approach calculates the sum of every window separately.

```text
Window 1 → 2 + 1 + 5

Window 2 → 1 + 5 + 1

Window 3 → 5 + 1 + 3

...
```

Each window requires recalculating its sum.

```text
Time Complexity = O(n × k)
```

For large arrays, this becomes inefficient.

Instead, Sliding Window updates the window by removing one element and adding another.

---

## 💡 The Core Idea

Keep a window of fixed size.

When moving to the next position:

```text
Remove the leftmost element.

Add the new rightmost element.
```

Instead of recalculating the entire window, update only the changed elements.

---

## ⚙️ How the Window Moves

Suppose the array is

```text
[2, 1, 5, 1, 3, 2]
```

Window Size = 3

```text
[2 1 5] 1 3 2

↓

2 [1 5 1] 3 2

↓

2 1 [5 1 3] 2

↓

2 1 5 [1 3 2]
```

Each move removes one element and includes one new element.

---

## 🎯 Example

Array

```text
[2, 1, 5, 1, 3, 2]
```

Window Size

```text
3
```

First Window

```text
2 + 1 + 5 = 8
```

Move one step

```text
Current Sum

= 8

Remove 2

Add 1

New Sum

= 7
```

Continue until the end while keeping track of the maximum.

---

## 🧠 Intuition

Think of the window as a frame moving across the array.

Instead of rebuilding the frame every time,

- Remove the element leaving the window.
- Add the element entering the window.

This makes every movement constant time.

---

## 📊 Complexity

| Operation | Time |
|-----------|------|
| Traverse Array | **O(n)** |

**Space Complexity:** **O(1)**

---

## 🌍 Applications

- Maximum/Minimum Sum Subarray
- Longest Substring Problems
- Fixed Size Window Problems
- Variable Size Window Problems
- String Matching
- Frequency Counting
- Streaming Data

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 643. Maximum Average Subarray I | 🟢 Easy |
| LeetCode | 1456. Maximum Number of Vowels in a Substring of Given Length | 🟡 Medium |
| LeetCode | 3. Longest Substring Without Repeating Characters | 🟡 Medium |
| LeetCode | 424. Longest Repeating Character Replacement | 🟡 Medium |
| LeetCode | 1004. Max Consecutive Ones III | 🟡 Medium |
| LeetCode | 209. Minimum Size Subarray Sum | 🟡 Medium |
| LeetCode | 76. Minimum Window Substring | 🔴 Hard |

---

## ✨ Key Takeaway

> **Sliding Window reduces repeated work by updating only the elements entering and leaving the current window, transforming many O(n × k) solutions into O(n).**

Whenever you encounter **contiguous subarray or substring problems**, Sliding Window should be one of the first techniques you consider.