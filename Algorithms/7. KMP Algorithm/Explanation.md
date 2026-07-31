# 📖 KMP (Knuth–Morris–Pratt) Algorithm

## 📌 Definition

**KMP (Knuth–Morris–Pratt) Algorithm** is an efficient string matching algorithm used to find a pattern inside a text.

Instead of checking every character again after a mismatch, KMP uses information from previous comparisons to skip unnecessary checks.

This makes it much faster than the naive string matching approach.

---

## 🤔 Why Do We Need KMP?

Suppose we want to find the pattern:

```text
Pattern = "ABABC"
```

inside the text:

```text
Text = "ABABDABABC"
```

A simple approach compares every character one by one.

When a mismatch occurs, it starts matching from the next position in the text.

This causes many characters to be compared repeatedly.

```text
Time Complexity = O(n × m)
```

where

- n = Length of the text
- m = Length of the pattern

KMP avoids these repeated comparisons by remembering what has already been matched.

---

## 💡 The Core Idea

Before searching, KMP builds an array called the **LPS (Longest Prefix Suffix)** array.

The LPS array tells us:

> **If a mismatch occurs, where should the pattern continue matching instead of starting over?**

Using this information, KMP skips unnecessary comparisons and searches the text in linear time.

---

## 📖 What is the LPS Array?

LPS stands for:

**Longest Proper Prefix which is also a Suffix**

- **Prefix** → Starts from the beginning of the string.
- **Suffix** → Ends at the last character.
- **Proper Prefix** → A prefix that is **not equal to the entire string**.

Consider the pattern:

```text
ABABC
```

| Index | 0 | 1 | 2 | 3 | 4 |
| :--- | :-: | :-: | :-: | :-: | :-: |
| Character | A | B | A | B | C |
| LPS | 0 | 0 | 1 | 2 | 0 |

### Why?

For the substring:

```text
ABAB
```

Prefixes:

```text
A
AB
ABA
```

Suffixes:

```text
BAB
AB
B
```

The longest prefix that is also a suffix is:

```text
AB
```

Length:

```text
2
```

So,

```text
LPS[3] = 2
```

---

## ⚙️ How the Algorithm Works

### Step 1

Build the LPS array for the pattern.

---

### Step 2

Start comparing characters of the text and the pattern.

If they match,

```text
Move both pointers.
```

---

### Step 3

If a mismatch occurs,

Instead of restarting from the beginning of the pattern,

use the LPS array.

```text
patternIndex = LPS[patternIndex - 1]
```

The text pointer stays where it is.

---

### Step 4

Continue until the entire pattern is found.

---

## 🎯 Example

Text

```text
ABABDABABC
```

Pattern

```text
ABABC
```

LPS

```text
[0, 0, 1, 2, 0]
```

Initially,

```text
ABABDABABC
|||||
ABABC
```

The first four characters match.

```text
ABAB
```

Next comparison:

```text
Text    = D
Pattern = C
```

Mismatch!

Instead of starting from the beginning,

KMP checks the LPS value.

```text
LPS[3] = 2
```

This means the first two characters have already been matched.

So the pattern shifts and continues from:

```text
AB
```

without rechecking previously matched characters.

Eventually,

```text
Pattern found at index 5
```

---

## 🧠 Intuition

Imagine you're reading a book and searching for a word.

You've already matched several letters.

Suddenly, one letter doesn't match.

Instead of rereading every letter from the beginning, you reuse the part you already know matches.

That's exactly what the **LPS array** does.

It remembers the useful part of the previous match, allowing KMP to skip unnecessary comparisons and search much faster.

---

## 📊 Complexity

| Operation | Complexity |
| :--- | :--- |
| Time Complexity | **O(n + m)** |
| Space Complexity | **O(m)** |

where

- **n** = Length of the text
- **m** = Length of the pattern

---

## 🌍 Applications

- Find a Pattern in a String
- Text Editors (Find/Search)
- Search Engines
- DNA Sequence Matching
- Bioinformatics
- Plagiarism Detection
- Log File Searching

---

## 📚 Practice Problems

| Platform | Problem | Difficulty |
| :--- | :--- | :--- |
| LeetCode | 28. Find the Index of the First Occurrence in a String | 🟢 Easy |
| LeetCode | 459. Repeated Substring Pattern | 🟢 Easy |
| LeetCode | 686. Repeated String Match | 🟡 Medium |
| LeetCode | 214. Shortest Palindrome | 🔴 Hard |
| LeetCode | 3036. Number of Subarrays That Match a Pattern II | 🔴 Hard |

---

## ⭐ Must Solve

- **LeetCode 28. Find the Index of the First Occurrence in a String**
- **LeetCode 459. Repeated Substring Pattern**

These two problems teach the core concepts of the KMP Algorithm and the LPS array.

---

## ✨ Key Takeaway

> **KMP (Knuth–Morris–Pratt) Algorithm uses the LPS (Longest Prefix Suffix) array to avoid rechecking previously matched characters, allowing it to find a pattern in linear time, O(n + m).**