# 📖 Prefix Sum

## 📌 Definition

**Prefix Sum** is a preprocessing technique used to answer range sum queries efficiently.

Instead of calculating the sum for every query repeatedly, we first build a prefix sum array where each element stores the sum of all previous elements (including itself). Once built, any range sum can be found in **O(1)** time.

---

## 🤔 Why Do We Need Prefix Sum?

Suppose we have the following array:

```text
[2, 4, 1, 7, 3, 6]
```

Now imagine multiple queries like:

```text
Sum from index 1 to 4
Sum from index 0 to 3
Sum from index 2 to 5
```

A straightforward approach is to loop through every element in the given range.

```text
Time per query = O(n)
```

If there are thousands of queries, the total time becomes very large.

Instead, we can preprocess the array once and answer every query instantly.

---

## 💡 The Core Idea

Create another array called **Prefix Sum**.

Each index stores the sum of all elements from the beginning of the array up to that index.

For example,

```text
Array

[2, 4, 1, 7, 3, 6]
```

Prefix Sum Array

```text
Index : 0   1   2   3   4   5

Value : 2   6   7   14  17  23
```

Notice that,

```text
6  = 2 + 4

14 = 2 + 4 + 1 + 7

23 = 2 + 4 + 1 + 7 + 3 + 6
```

Now every position already knows the sum from the beginning.

---

## ⚙️ Building the Prefix Sum Array

The first element remains the same.

```text
prefix[0] = arr[0]
```

Every other element is simply:

```text
prefix[i] = prefix[i - 1] + arr[i]
```

This takes only one traversal.

---

## 🎯 Finding Range Sum

Suppose we need the sum from index **L** to **R**.

Instead of adding every element,

```text
Sum(L...R)

=

Prefix[R] - Prefix[L - 1]
```

If **L = 0**,

```text
Sum = Prefix[R]
```

---

### Example

Array

```text
[2, 4, 1, 7, 3, 6]
```

Prefix

```text
[2, 6, 7, 14, 17, 23]
```

Find the sum from index **2** to **4**.

Instead of

```text
1 + 7 + 3 = 11
```

Simply compute

```text
17 - 6 = 11
```

The answer is obtained in constant time.

---

## 🧠 Intuition

Think of the prefix array as a running total.

Instead of remembering individual values, each position remembers the sum from the beginning.

When finding the sum between two indices,

- Take the total sum until **R**
- Remove everything before **L**

The remaining value is exactly the required range sum.

---

## 📊 Complexity

| Operation | Time |
|-----------|------|
| Build Prefix Sum | **O(n)** |
| Range Sum Query | **O(1)** |

**Space Complexity:** **O(n)**

---

## 🌍 Applications

- Range Sum Queries
- Frequency Counting
- Cumulative Scores
- Subarray Sum Problems
- 2D Prefix Sum (Matrix Queries)
- Competitive Programming
- Dynamic Programming

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 303. Range Sum Query - Immutable | 🟢 Easy |
| LeetCode | 724. Find Pivot Index | 🟢 Easy |
| LeetCode | 560. Subarray Sum Equals K | 🟡 Medium |
| LeetCode | 974. Subarray Sums Divisible by K | 🟡 Medium |
| LeetCode | 2389. Longest Subsequence With Limited Sum | 🟡 Medium |
| LeetCode | 930. Binary Subarrays With Sum | 🟡 Medium |
| LeetCode | 1074. Number of Submatrices That Sum to Target | 🔴 Hard |

---

## ✨ Key Takeaway

> **Prefix Sum trades a one-time preprocessing cost of O(n) for O(1) range sum queries.**

Whenever you encounter **multiple range sum queries**, Prefix Sum should be one of the first techniques that comes to mind.