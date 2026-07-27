# 📖 Moore's Voting Algorithm

## 📌 Definition

**Moore's Voting Algorithm** is an efficient algorithm used to find the **majority element** in an array.

A **majority element** is an element that appears **more than ⌊n/2⌋ times**.

The algorithm works by repeatedly **canceling out different elements**. Since the majority element appears more than half of the time, it can never be completely eliminated.

---

## 🤔 Why Do We Need Moore's Voting Algorithm?

Suppose we have the following array:

```text
[2, 2, 1, 1, 1, 2, 2]
```

One solution is to count the frequency of every element using a HashMap.

```text
2 → 4

1 → 3
```

Although this works, it requires extra memory.

```text
Time Complexity  = O(n)

Space Complexity = O(n)
```

Can we solve the same problem **without storing frequencies**?

Yes.

Moore's Voting Algorithm does exactly that using **O(1)** extra space.

---

## 💡 The Core Idea

Imagine every occurrence of the majority element is paired with one occurrence of a different element.

Whenever two different numbers meet,

```text
They cancel each other.
```

Example

```text
2 ✖ 1

2 ✖ 1
```

After canceling all possible pairs,

```text
2
```

is still left.

Why?

Because the majority element appears **more than half of the time**, there aren't enough different elements to cancel all of its occurrences.

The remaining element must be the majority element.

---

## ⚙️ How the Algorithm Works

Maintain two variables:

```text
candidate
count
```

Initially,

```text
count = 0
```

For every element:

### Case 1

If the count becomes zero,

```text
Choose the current element as the new candidate.
```

### Case 2

If the current element matches the candidate,

```text
Increase count.
```

### Case 3

Otherwise,

```text
Decrease count.
```

At the end of the traversal,

the remaining candidate is the majority element (if one exists).

---

## 🎯 Example

Array

```text
[2, 2, 1, 1, 1, 2, 2]
```

| Current | Candidate | Count |
|---------|-----------|------:|
| 2 | 2 | 1 |
| 2 | 2 | 2 |
| 1 | 2 | 1 |
| 1 | 2 | 0 |
| 1 | 1 | 1 |
| 2 | 1 | 0 |
| 2 | 2 | 1 |

Final Candidate

```text
2
```

Majority Element

```text
2
```

---

## 🧠 Intuition

Think of a voting competition.

- Every vote for the current candidate increases its score.
- Every vote for a different number decreases its score.
- When the score becomes zero, the current candidate has been completely canceled, so we start supporting a new candidate.

Since the true majority element has **more votes than all other elements combined**, it survives every cancellation and remains the final candidate.

---

## 📊 Complexity

| Operation | Complexity |
| :--- | :--- |
| Time Complexity | **O(n)** |
| Space Complexity | **O(1)** |

---

## 🌍 Applications

- Majority Element
- Majority Element II
- Election/Voting Systems
- Frequency-Based Problems
- Streaming Data
- Interview Optimization Problems

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 169. Majority Element | 🟢 Easy |
| LeetCode | 229. Majority Element II | 🟡 Medium |
| LeetCode | 1150. Check If a Number Is Majority Element in a Sorted Array | 🟢 Easy |
| LeetCode | 1535. Find the Winner of an Array Game | 🟡 Medium |

---

## ✨ Key Takeaway

> **Moore's Voting Algorithm works because every non-majority element can cancel only one occurrence of the majority element. Since the majority element appears more than half the time, it is guaranteed to survive all cancellations and become the final candidate.**