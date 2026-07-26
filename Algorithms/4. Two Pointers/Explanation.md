# 📖 Two Pointers

## 📌 Definition

**Two Pointers** is a technique that uses two indices to traverse an array or string efficiently.

Instead of checking every possible pair of elements, the pointers move based on the problem's conditions, reducing many **O(n²)** solutions to **O(n)**.

---

## 🤔 Why Do We Need Two Pointers?

Suppose we have the following sorted array:

```text
[2, 4, 6, 8, 10, 14]
```

Now imagine we need to find two numbers whose sum is **18**.

A straightforward approach compares every possible pair.

```text
2 + 4

2 + 6

2 + 8

...

10 + 14
```

```text
Time Complexity = O(n²)
```

This becomes inefficient for large arrays.

Instead, Two Pointers solves the same problem in a single traversal.

---

## 💡 The Core Idea

Place one pointer at the beginning and another at the end.

```text
Left --------->

<--------- Right
```

Compare the two elements.

- If the sum is too small, move the left pointer.
- If the sum is too large, move the right pointer.
- If the required answer is found, stop.

Each pointer moves only in one direction.

---

## ⚙️ How the Pointers Move

Array

```text
[2, 4, 6, 8, 10, 14]
```

Target

```text
18
```

Step 1

```text
2 + 14 = 16

Too small

Move Left →
```

Step 2

```text
4 + 14 = 18

Answer Found
```

Only two comparisons were needed.

---

## 🎯 Another Common Pattern

Two Pointers are also useful when traversing from both ends.

For example, checking whether a string is a palindrome.

```text
racecar
^     ^
```

Compare both characters.

If they are equal,

```text
Move both pointers inward.
```

Continue until they meet.

---

## 🧠 Intuition

Think of the pointers as two people searching from opposite ends.

Instead of checking every possible pair,

they gradually narrow down the search space by moving closer based on the current result.

This avoids unnecessary comparisons.

---

## 📊 Complexity

| Operation | Time |
|-----------|------|
| Single Traversal | **O(n)** |

**Space Complexity:** **O(1)**

---

## 🌍 Applications

- Pair Sum in Sorted Arrays
- Palindrome Checking
- Removing Duplicates
- Merging Sorted Arrays
- Container Problems
- Trapping Rain Water
- 3Sum and 4Sum

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 125. Valid Palindrome | 🟢 Easy |
| LeetCode | 167. Two Sum II – Input Array Is Sorted | 🟡 Medium |
| LeetCode | 11. Container With Most Water | 🟡 Medium |
| LeetCode | 15. 3Sum | 🟡 Medium |
| LeetCode | 42. Trapping Rain Water | 🔴 Hard |

---

## ✨ Key Takeaway

> **Two Pointers solves many array and string problems by moving two indices intelligently instead of checking every possible combination.**

Whenever you encounter **sorted arrays, palindromes, pairs, or problems involving both ends of an array or string**, Two Pointers should be one of the first techniques you consider.