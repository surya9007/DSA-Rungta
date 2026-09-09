# Array Address Calculation —

## 1. Introduction

An **array** is a collection of elements of the same data type stored in **contiguous memory locations**.

For example:

```text
A = [10, 20, 30, 40, 50]
```

The elements are stored one after another in memory. Because the elements are stored at fixed-size locations, we can calculate the address of any element using a mathematical formula.

Address calculation is especially important in **Data Structures, C/C++, Java memory concepts, and semester examinations**.

---

# One-Dimensional Array Representation

A one-dimensional array can be represented as:

```text
A[lb .... ub]
```

Where:

- `lb` = Lower Bound
- `ub` = Upper Bound
- `BA` = Base Address
- `C` = Size of one element in bytes
- `i` = Index of the required element

Example:

```text
A[0 ... 5]
```

Here:

```text
Lower Bound (lb) = 0
Upper Bound (ub) = 5
```

The array contains:

```text
6 elements
```

---

# 3. Important Terms

## 3.1 Lower Bound (lb)

The **lower bound** is the smallest valid index of an array.

For a zero-based array:

```text
lb = 0
```

Example:

```text
A[0], A[1], A[2], A[3]
```

Lower bound = `0`

If an array starts from index `1`, then:

```text
lb = 1
```

---

## 3.2 Upper Bound (ub)

The **upper bound** is the largest valid index of an array.

Example:

```text
A[0 ... 9]
```

Then:

```text
lb = 0
ub = 9
```

---

## 3.3 Base Address (BA)

The **Base Address** is the memory address of the first element of the array.

For:

```text
A[0]
```

its address is called:

```text
BA
```

Therefore:

```text
BA = Address of A[lb]
```

For a zero-based array:

```text
BA = Address of A[0]
```

---

## 3.4 Element Size (C)

`C` represents the amount of memory occupied by one array element.

Examples:

| Data Type | Typical Size |
|---|---:|
| char | 1 byte |
| int | 4 bytes |
| float | 4 bytes |
| double | 8 bytes |

> In theoretical questions, always use the element size given in the question.

---

# 4. Total Number of Elements

For an array represented as:

```text
A[lb ... ub]
```

the total number of elements is:

```text
Total Elements = ub - lb + 1
```

## Example 1

Suppose:

```text
A[0 ... 9]
```

Then:

```text
lb = 0
ub = 9
```

Therefore:

```text
Total Elements = ub - lb + 1
               = 9 - 0 + 1
               = 10
```

So the array contains **10 elements**.

---

## Example 2

Suppose:

```text
A[5 ... 15]
```

Then:

```text
Total Elements = 15 - 5 + 1
               = 11
```

So the array contains **11 elements**.

---

# 5. One-Dimensional Array Address Formula

The general formula for finding the address of an element in a one-dimensional array is:

```text
LOC(A[i]) = BA + (i - lb) × C
```

Where:

```text
LOC(A[i]) = Address of A[i]
BA        = Base Address
i         = Index of required element
lb        = Lower Bound
C         = Size of each element
```

---

# 6. Why Do We Subtract the Lower Bound?

The important part of the formula is:

```text
(i - lb)
```

This calculates the **offset** of the required element from the first element.

Suppose the array starts from:

```text
A[5]
```

and we want:

```text
A[8]
```

The offset is:

```text
8 - 5 = 3
```

So `A[8]` is the **3rd offset** from the first element.

Therefore:

```text
LOC(A[8]) = BA + 3 × C
```

---

# 7. Zero-Based Array

Most programming languages use **zero-based indexing**.

Example:

```text
A[0]  A[1]  A[2]  A[3]  A[4]
```

Here:

```text
lb = 0
```

The address formula becomes:

```text
LOC(A[i]) = BA + (i - 0) × C
```

Therefore:

```text
LOC(A[i]) = BA + i × C
```

This is simpler because there is **no subtraction of the lower bound**.

---

# 8. Why Does Array Index Start From 0?

A common exam/interview question is:

> Why does array indexing start from 0?

The important reason is related to **offset calculation**.

If indexing starts from `0`:

```text
A[0]
```

is at offset:

```text
0
```

Then:

```text
A[1] → offset 1
A[2] → offset 2
A[3] → offset 3
```

So the address calculation becomes:

```text
LOC(A[i]) = BA + i × C
```

There is no need to subtract a lower-bound value.

### If indexing starts from 1

If the array were:

```text
A[1], A[2], A[3], A[4]
```

then:

```text
A[1] → offset 0
A[2] → offset 1
A[3] → offset 2
A[4] → offset 3
```

Therefore, we would need:

```text
(i - 1)
```

in the address calculation.

So:

```text
LOC(A[i]) = BA + (i - 1) × C
```

### Main idea

Zero-based indexing makes the index itself equal to the **offset from the first element**.

```text
Index = Offset
```

Therefore, the formula becomes simpler:

```text
LOC(A[i]) = BA + i × C
```

> Important: The statement "arrays must start from 0" is not universally true. Some languages or array models can use different lower bounds. In languages such as Java and C/C++, ordinary arrays use zero-based indexing.

---

# 9. Visual Representation

Consider:

```text
A[0]   A[1]   A[2]   A[3]   A[4]
 ↓      ↓      ↓      ↓      ↓
BA    BA+C   BA+2C  BA+3C  BA+4C
```

For example, if:

```text
BA = 1000
C  = 4 bytes
```

then:

```text
A[0] → 1000
A[1] → 1004
A[2] → 1008
A[3] → 1012
A[4] → 1016
```

---

# 10. Solved Example — Zero-Based Array

### Question

An array `A[0...9]` has a base address of `1000`. Each element occupies `4 bytes`. Find the address of `A[6]`.

### Given

```text
lb = 0
BA = 1000
i  = 6
C  = 4
```

### Formula

```text
LOC(A[i]) = BA + (i - lb) × C
```

### Calculation

```text
LOC(A[6]) = 1000 + (6 - 0) × 4
          = 1000 + 24
          = 1024
```

### Answer

```text
Address of A[6] = 1024
```

---

# Solved Example — Non-Zero Lower Bound

### Question

An array is represented as:

```text
A[5...14]
```

Base address is `2000` and each element occupies `4 bytes`. Find the address of `A[10]`.

### Given

```text
lb = 5
ub = 14
BA = 2000
i  = 10
C  = 4
```

### Formula

```text
LOC(A[i]) = BA + (i - lb) × C
```

### Calculation

```text
LOC(A[10]) = 2000 + (10 - 5) × 4
           = 2000 + 5 × 4
           = 2000 + 20
           = 2020
```

### Answer

```text
Address of A[10] = 2020
```

---

# 12. Important Observation

Suppose:

```text
A[5...10]
```

and:

```text
BA = 500
C = 4
```

Then:

```text
A[5] → 500
A[6] → 504
A[7] → 508
A[8] → 512
A[9] → 516
A[10] → 520
```

Notice:

```text
A[5] is the first element.
```

Therefore:

```text
offset of A[5] = 5 - 5 = 0
```

The first element always has offset `0` from the base address.

---

# 13. Shortcut for Zero-Based Array

If:

```text
lb = 0
```

then directly use:

```text
LOC(A[i]) = BA + i × C
```

### Example

```text
BA = 4000
C = 8 bytes
i = 7
```

Then:

```text
LOC(A[7]) = 4000 + 7 × 8
           = 4000 + 56
           = 4056
```

---

# 14. Address of the First Element

For the first element:

```text
A[lb]
```

Formula:

```text
LOC(A[lb]) = BA + (lb - lb) × C
```

Therefore:

```text
LOC(A[lb]) = BA + 0
```

So:

```text
LOC(A[lb]) = BA
```

Hence:

> The address of the first element of an array is the base address.

---

# 15. Address of the Last Element

The last element is:

```text
A[ub]
```

Formula:

```text
LOC(A[ub]) = BA + (ub - lb) × C
```

The number of elements is:

```text
N = ub - lb + 1
```

Therefore:

```text
ub - lb = N - 1
```

So:

```text
LOC(A[ub]) = BA + (N - 1) × C
```

This is useful for exam problems involving the last element.

---

# 16. Finding Base Address

Sometimes the question gives the address of another element and asks for the base address.

From:

```text
LOC(A[i]) = BA + (i - lb) × C
```

we can rearrange:

```text
BA = LOC(A[i]) - (i - lb) × C
```

### Example

Given:

```text
LOC(A[5]) = 1020
lb = 0
C = 4
```

Then:

```text
BA = 1020 - (5 - 0) × 4
   = 1020 - 20
   = 1000
```

Therefore:

```text
BA = 1000
```

---

# 17. Finding Element Size

Sometimes element size `C` is unknown.

From:

```text
LOC(A[i]) = BA + (i - lb) × C
```

we can calculate:

```text
C = [LOC(A[i]) - BA] / (i - lb)
```

### Example

Suppose:

```text
BA = 1000
LOC(A[5]) = 1020
lb = 0
```

Then:

```text
C = (1020 - 1000) / (5 - 0)
  = 20 / 5
  = 4 bytes
```

---

# 18. Finding the Index

Sometimes the index is unknown.

From:

```text
LOC(A[i]) = BA + (i - lb) × C
```

we get:

```text
LOC(A[i]) - BA = (i - lb) × C
```

Therefore:

```text
(LOC(A[i]) - BA) / C = i - lb
```

So:

```text
i = lb + [LOC(A[i]) - BA] / C
```

---

# 19. General Formula

For:

```text
A[lb ... ub]
```

### Total number of elements

```text
N = ub - lb + 1
```

### Address of an element

```text
LOC(A[i]) = BA + (i - lb) × C
```

### Base address

```text
BA = LOC(A[i]) - (i - lb) × C
```

### Element size

```text
C = [LOC(A[i]) - BA] / (i - lb)
```

### Index

```text
i = lb + [LOC(A[i]) - BA] / C
```

---

# 20. Common Mistakes in Exams

## Mistake 1: Forgetting `+1`

Wrong:

```text
Total elements = ub - lb
```

Correct:

```text
Total elements = ub - lb + 1
```

---

## Mistake 2: Always assuming lower bound is 0

If the question says:

```text
A[10...20]
```

then:

```text
lb = 10
```

Do not automatically use `0`.

---

## Mistake 3: Forgetting element size

Wrong:

```text
LOC(A[i]) = BA + i
```

Correct:

```text
LOC(A[i]) = BA + (i - lb) × C
```

---

## Mistake 4: Confusing index with offset

For:

```text
A[5...10]
```

the index of the first element is:

```text
5
```

but its offset is:

```text
5 - 5 = 0
```

So:

```text
Index ≠ Offset
```

when the lower bound is not zero.

---

# 21.

Remember these four terms:

```text
lb = Lower Bound
ub = Upper Bound
BA = Base Address
C  = Size of one element
```

### Formula 1

```text
Total Elements = ub - lb + 1
```

### Formula 2

```text
LOC(A[i]) = BA + (i - lb) × C
```

### If indexing starts from 0

```text
LOC(A[i]) = BA + i × C
```

### First element

```text
LOC(A[lb]) = BA
```

### Last element

```text
LOC(A[ub]) = BA + (ub - lb) × C
```

---

# 22. Practice Questions

## Question 1

An array `A[0...9]` has base address `1000`. Each element occupies `4 bytes`. Find the address of `A[7]`.

**Answer:**

```text
1000 + (7 - 0) × 4
= 1028
```

---

## Question 2

An array `A[5...15]` has base address `2000`. Each element occupies `4 bytes`. Find the address of `A[12]`.

**Answer:**

```text
2000 + (12 - 5) × 4
= 2028
```

---

## Question 3

Find the number of elements in:

```text
A[10...25]
```

**Answer:**

```text
25 - 10 + 1 = 16
```

---

## Question 4

The base address of an array is `5000`. The element size is `8 bytes`. Find the address of `A[6]` if the lower bound is `0`.

**Answer:**

```text
5000 + 6 × 8
= 5048
```

---

## Important Formula Box

```text
┌─────────────────────────────────────────────┐
│          1D ARRAY ADDRESS FORMULAS          │
├─────────────────────────────────────────────┤
│ Total Elements = ub - lb + 1               │
│                                             │
│ LOC(A[i]) = BA + (i - lb) × C              │
│                                             │
│ If lb = 0:                                  │
│ LOC(A[i]) = BA + i × C                     │
│                                             │
│ First Element Address = BA                 │
│                                             │
│ Last Element Address =                     │
│ BA + (ub - lb) × C                         │
└─────────────────────────────────────────────┘
```

**© Surya Mani**
