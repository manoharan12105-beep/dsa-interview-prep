# 💡 Understanding Kadane's Algorithm

Kadane's Algorithm is a greedy algorithm used to find the **maximum sum contiguous subarray** in an array. Instead of checking every possible subarray, it processes the array only once by deciding whether to **continue the current subarray or start a new one**. This simple strategy reduces the time complexity from **O(n²)** to **O(n)** while using **O(1)** extra space.

---

## 🤔 The Brute Force Idea

One way is to generate every possible subarray, calculate its sum, and keep the largest one.

```text
[-2]
[-2, 1]
[-2, 1, -3]
...

[1]
[1, -3]
...
```

This works, but checking every subarray takes **O(n²)** time.

Can we do better?

---

## 💡 The Insight

Imagine your current running sum is:

```text
Current Sum = -5
```

Now the next number is:

```text
10
```

Should you continue?

```text
-5 + 10 = 5
```

Or should you start fresh?

```text
10
```

Starting fresh gives a better result.

This leads to an important observation:

> **If the running sum becomes negative, it's better to discard it and start a new subarray.**

A negative sum can only reduce the sum of future subarrays.

---

## ⚙️ The Algorithm

At every element, there are only two choices:

- Continue the current subarray.
- Start a new subarray.

Choose the better one.

```java
currentSum = Math.max(num, currentSum + num);
```

Then update the answer.

```java
maxSum = Math.max(maxSum, currentSum);
```

Repeat this until the end of the array.

---

## 📝 Example

For the array

```text
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

The algorithm eventually finds

```text
[4, -1, 2, 1]
```

whose sum is

```text
6
```

---

## 📌 Why It Works

Kadane's Algorithm never wastes time remembering subarrays that can't help in the future.

Whenever the running sum becomes negative, it simply starts over.

This simple greedy decision is what makes the algorithm run in **O(n)** time.

> **Think of it as carrying a backpack. If the backpack becomes too heavy (negative sum), drop it and continue your journey with a fresh start.**

--- 

## 📌 Quick Recap

- Kadane's Algorithm finds the maximum sum contiguous subarray.
- It processes the array in a single traversal.
- Negative running sums are discarded because they cannot improve future subarrays.
- Time Complexity: **O(n)**
- Space Complexity: **O(1)**