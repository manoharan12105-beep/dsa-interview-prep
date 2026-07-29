# 📖 Dutch National Flag Algorithm

## 📌 Definition

**Dutch National Flag Algorithm** is an in-place partitioning algorithm used to divide an array into **three groups** in a single traversal.

It is most commonly used to sort arrays containing only **0s, 1s, and 2s** without using any extra space.

The algorithm was proposed by the Dutch computer scientist **Edsger W. Dijkstra**.

---

## 🤔 Why Do We Need Dutch National Flag Algorithm?

Suppose we have the following array:

```text
[2, 0, 2, 1, 1, 0]
```

A straightforward approach is to sort the array using a standard sorting algorithm.

```text
Time Complexity = O(n log n)
```

However, since the array contains only **three distinct values**, we can do much better.

Dutch National Flag Algorithm sorts the array in a **single traversal**.

---

## 💡 The Core Idea

Maintain three pointers:

```text
low
mid
high
```

These pointers divide the array into four regions.

```text
0s | 1s | Unknown | 2s

 ^     ^          ^
low   mid       high
```

During each step:

- If the current element is **0**, move it to the left.
- If the current element is **1**, leave it where it is.
- If the current element is **2**, move it to the right.

Eventually, every element reaches its correct region.

---

## ⚙️ How the Algorithm Works

Initially,

```text
low = 0
mid = 0
high = n - 1
```

### If nums[mid] == 0

```text
Swap(low, mid)

low++
mid++
```

### If nums[mid] == 1

```text
mid++
```

### If nums[mid] == 2

```text
Swap(mid, high)

high--
```

Notice that **mid is not incremented** after swapping with `high` because the new element at `mid` has not been processed yet.

---

## 🎯 Example

Array

```text
[2, 0, 2, 1, 1, 0]
```

Initially

```text
low = 0
mid = 0
high = 5
```

### Step 1

```text
2

Swap(mid, high)

[0, 0, 2, 1, 1, 2]
```

### Step 2

```text
0

Swap(low, mid)

low++
mid++
```

### Step 3

```text
0

Swap(low, mid)

low++
mid++
```

### Step 4

```text
2

Swap(mid, high)

[0, 0, 1, 1, 2, 2]
```

### Remaining Steps

```text
Both remaining elements are 1

Move mid
```

Final Array

```text
[0, 0, 1, 1, 2, 2]
```

---

## 🧠 Intuition

Imagine sorting colored balls.

- Red (0) belongs on the left.
- White (1) belongs in the middle.
- Blue (2) belongs on the right.

As you scan the array once,

- Place every **0** at the left boundary.
- Place every **2** at the right boundary.
- Leave every **1** in the middle.

The three boundaries gradually expand until the entire array is sorted.

---

## 📊 Complexity

| Operation | Complexity |
| :--- | :--- |
| Time Complexity | **O(n)** |
| Space Complexity | **O(1)** |

---

## 🌍 Applications

- Sort Colors
- Three-Way Partitioning
- QuickSort (3-Way Partition)
- Partition Around a Pivot
- In-place Array Rearrangement

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 75. Sort Colors | 🟡 Medium |
| LeetCode | 2161. Partition Array According to Given Pivot | 🟡 Medium |
| LeetCode | 905. Sort Array By Parity | 🟢 Easy |
| LeetCode | 922. Sort Array By Parity II | 🟢 Easy |

---

## ✨ Key Takeaway

> **Dutch National Flag Algorithm partitions an array into three regions in a single traversal using three pointers, making it an optimal solution for problems involving three distinct groups.**