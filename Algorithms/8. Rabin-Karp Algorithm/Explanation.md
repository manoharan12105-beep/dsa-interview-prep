# 📖 Rabin–Karp Algorithm

## 📌 Definition

**Rabin–Karp Algorithm** is an efficient string matching algorithm used to find a pattern inside a text.

Instead of comparing every character, it compares the **hash values** of the pattern and the current window of the text.

If the hash values match, it performs a character-by-character comparison to confirm the match.

---

## 🤔 Why Do We Need Rabin–Karp?

Suppose we want to find the pattern:

```text
Pattern = "ABC"
```

inside the text:

```text
Text = "ABCDABCAB"
```

A straightforward approach compares every character one by one.

Whenever a mismatch occurs, it starts again from the next position.

```text
Time Complexity = O(n × m)
```

where

- n = Length of the text
- m = Length of the pattern

Rabin–Karp speeds up this process by comparing **hash values** instead of characters.

---

## 💡 The Core Idea

Instead of comparing strings directly,

convert both the pattern and the current window of the text into numbers using a **hash function**.

Example

```text
Pattern

ABC

↓

Hash = 12345
```

Text window

```text
ABC

↓

Hash = 12345
```

If the hash values are different,

```text
Definitely NOT a match.
```

If the hash values are the same,

```text
Compare the actual characters to confirm.
```

---

## 📖 Rolling Hash

The most important idea in Rabin–Karp is the **Rolling Hash**.

Suppose the window size is 3.

Initially,

```text
ABC
```

Compute its hash.

Now move one character to the right.

Instead of computing the hash again from scratch,

```text
ABC

↓

BCD
```

Update the hash by

- Removing the left character
- Adding the new right character

This takes **O(1)** time.

---

## ⚙️ How the Algorithm Works

### Step 1

Compute the hash of the pattern.

---

### Step 2

Compute the hash of the first window of the text.

---

### Step 3

Compare both hash values.

If they are equal,

```text
Compare the actual characters.
```

---

### Step 4

Slide the window by one character.

Update the hash using the rolling hash technique.

Repeat until the end of the text.

---

## 🎯 Example

Text

```text
ABCDABCAB
```

Pattern

```text
ABC
```

Window 1

```text
ABC

Hash matches

↓

Compare characters

Pattern found at index 0
```

Slide

```text
BCD

Hash doesn't match

↓

Skip
```

Slide

```text
CDA

Hash doesn't match

↓

Skip
```

Slide

```text
DAB

Hash doesn't match

↓

Skip
```

Slide

```text
ABC

Hash matches

↓

Compare characters

Pattern found at index 4
```

---

## 🧠 Intuition

Imagine searching for a word in a dictionary.

Instead of reading every letter of every word,

you first compare a short fingerprint (hash).

- Different fingerprint → Ignore immediately.
- Same fingerprint → Check the actual word.

This saves many unnecessary comparisons.

The rolling hash makes this even faster because it updates the fingerprint without recalculating everything.

---

## 📊 Complexity

| Operation | Complexity |
| :--- | :--- |
| Average Time | **O(n + m)** |
| Worst Time | **O(n × m)** |
| Space Complexity | **O(1)** |

where

- **n** = Length of the text
- **m** = Length of the pattern

---

## 🌍 Applications

- Pattern Searching
- Plagiarism Detection
- Malware Signature Detection
- DNA Sequence Matching
- Search Engines
- Document Comparison
- Duplicate String Detection

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 28. Find the Index of the First Occurrence in a String | 🟢 Easy |
| LeetCode | 1044. Longest Duplicate Substring | 🔴 Hard |
| LeetCode | 1062. Longest Repeating Substring | 🟡 Medium |
| LeetCode | 187. Repeated DNA Sequences | 🟡 Medium |
| LeetCode | 2156. Find Substring With Given Hash Value | 🔴 Hard |

---

## ⭐ Must Solve

- **LeetCode 28. Find the Index of the First Occurrence in a String**
- **LeetCode 187. Repeated DNA Sequences**

These problems help you understand both **basic pattern searching** and **rolling hash applications**.

---

## ✨ Key Takeaway

> **Rabin–Karp Algorithm uses a rolling hash to compare hash values instead of characters, allowing efficient pattern searching by skipping unnecessary character comparisons.**