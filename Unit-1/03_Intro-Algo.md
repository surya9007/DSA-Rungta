# Algorithm Analysis, Time & Space Complexity, Asymptotic Notations

---

## 1. Introduction to Algorithm

An **algorithm** is a finite sequence of well-defined steps used to solve a particular problem.

In simple words:

> An algorithm is a step-by-step procedure for solving a problem.

### Example

Problem: Find the maximum element in an array.

### Algorithm

1. Start.
2. Read the array.
3. Assume the first element is maximum.
4. Compare the maximum element with every remaining element.
5. If a larger element is found, update maximum.
6. Print maximum.
7. Stop.

### Example

Array:

```text
10 25 7 40 15
```

Output:

```text
Maximum = 40
```

---

# 2. Characteristics of an Algorithm

A good algorithm generally has the following characteristics.

## 2.1 Input

An algorithm may accept zero or more inputs.

Example:

```text
Input: n = 5
```

---

## 2.2 Output

An algorithm must produce at least one output.

Example:

```text
Output: Maximum = 40
```

---

## 2.3 Definiteness

Every step of an algorithm must be clear and unambiguous.

For example:

```text
Add two numbers
```

is clear.

But:

```text
Process the numbers somehow
```

is not a definite instruction.

---

## 2.4 Finiteness

An algorithm must terminate after a finite number of steps.

An algorithm that continues forever is not considered a proper algorithm for a finite problem.

---

## 2.5 Effectiveness

Every operation of an algorithm should be basic enough to be performed in a finite amount of time.

---

# What is Algorithm Analysis?

**Algorithm analysis** is the process of determining the efficiency of an algorithm.

When we analyze an algorithm, we mainly study:

1. Time Complexity
2. Space Complexity

The purpose is to determine how efficiently an algorithm uses:

* CPU time
* Memory
* Other computational resources

---

# Why Do We Need Algorithm Analysis?

Suppose two algorithms solve the same problem.

### Algorithm A

Takes:

```text
n² operations
```

### Algorithm B

Takes:

```text
n operations
```

For small input sizes, the difference may not be significant.

But for large input sizes, Algorithm B is much faster.

For example:

```text
n = 1,000,000
```

Algorithm A:

```text
n² = 1,000,000,000,000
```

Algorithm B:

```text
n = 1,000,000
```

Therefore, algorithm analysis helps us select a better algorithm.

---

# Factors Affecting Algorithm Performance

Algorithm performance can depend on:

* Input size
* Hardware
* Programming language
* Compiler
* Operating system
* Implementation technique
* Data structure
* Algorithm design

However, when studying algorithms theoretically, we generally focus on **input size** rather than machine-specific execution time.

---

# Input Size

Input size represents the amount of data given to an algorithm.

Usually, input size is represented by:

```text
n
```

### Examples

For an array:

```text
int arr[n];
```

Input size:

```text
n = number of elements
```

For a matrix:

```text
n × n
```

Input size may be represented using:

```text
n²
```

For a string:

```text
n = length of string
```

---

# Time Complexity

## Definition

**Time complexity** describes how the running time or number of basic operations of an algorithm grows as the input size increases.

It does not necessarily mean actual time in seconds.

Instead, we count the number of fundamental operations performed by the algorithm.

---

## Example

Consider:

```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```

The loop executes:

```text
n times
```

Therefore:

```text
Time Complexity = O(n)
```

---

# Basic Operation

A **basic operation** is an operation that takes approximately constant time.

Examples:

```text
Assignment
Comparison
Addition
Subtraction
Array access
Increment
```

For example:

```java
x = a + b;
```

contains a constant number of operations.

Therefore:

```text
O(1)
```

---

# Constant Time Complexity — O(1)

An algorithm has constant time complexity when its execution time does not depend on input size.

### Example

```java
int x = arr[0];
```

Only one element is accessed.

Therefore:

```text
T(n) = 1
```

Complexity:

```text
O(1)
```

### Another Example

```java
int sum = a + b;
```

Complexity:

```text
O(1)
```

---

# Linear Time Complexity — O(n)

An algorithm has linear complexity when the number of operations grows directly with input size.

### Example

```java
for(int i = 0; i < n; i++) {
    System.out.println(arr[i]);
}
```

The loop executes `n` times.

Therefore:

```text
T(n) = n
```

Complexity:

```text
O(n)
```

### Example

Searching for an element using Linear Search:

```text
10 20 30 40 50
```

In the worst case, we may check every element.

Therefore:

```text
O(n)
```

---

# Quadratic Time Complexity — O(n²)

Quadratic complexity usually occurs with two nested loops.

### Example

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

Outer loop:

```text
n times
```

Inner loop:

```text
n times
```

Total:

```text
n × n = n²
```

Therefore:

```text
O(n²)
```

---

# Cubic Time Complexity — O(n³)

Three nested loops generally produce cubic complexity.

### Example

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

        for(int k = 0; k < n; k++) {
            System.out.println(i + " " + j + " " + k);
        }
    }
}
```

Operations:

```text
n × n × n
```

Therefore:

```text
O(n³)
```

---

# Logarithmic Time Complexity — O(log n)

An algorithm has logarithmic complexity when the problem size is repeatedly reduced by a constant factor.

The most common example is **Binary Search**.

### Example

Suppose:

```text
n = 16
```

Binary Search reduces the search space:

```text
16
↓
8
↓
4
↓
2
↓
1
```

Number of steps:

```text
log₂(16) = 4
```

Therefore:

```text
Time Complexity = O(log n)
```

---


# Linearithmic Complexity — O(n log n)

Many efficient sorting algorithms have:

```text
O(n log n)
```

complexity.

Examples:

* Merge Sort
* Heap Sort
* Average-case Quick Sort

### Example

Merge Sort:

```text
Divide → log n levels
Merge → n work per level
```

Therefore:

```text
n × log n
```

Complexity:

```text
O(n log n)
```

---

# Exponential Complexity — O(2ⁿ)

In exponential algorithms, the number of operations grows very rapidly as input size increases.

A common example is the naive recursive solution for generating subsets.

For `n` elements, the number of subsets is:

```text
2ⁿ
```

Therefore:

```text
O(2ⁿ)
```

---

# Factorial Complexity — O(n!)

Factorial complexity is even more expensive.

Example:

Generating all permutations of `n` elements.

Number of permutations:

```text
n!
```

Therefore:

```text
O(n!)
```

For example:

```text
3! = 6
4! = 24
5! = 120
10! = 3,628,800
```

The number grows extremely quickly.

---

# Common Time Complexities

From generally better to worse:

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
O(n³)
O(2ⁿ)
O(n!)
```

### Growth Order

```text
O(1)
   ↓
O(log n)
   ↓
O(n)
   ↓
O(n log n)
   ↓
O(n²)
   ↓
O(n³)
   ↓
O(2ⁿ)
   ↓
O(n!)
```

---

# Space Complexity

## Definition

**Space complexity** is the amount of memory required by an algorithm as a function of input size.

It includes memory used by:

* Variables
* Arrays
* Data structures
* Function call stack
* Dynamic memory
* Auxiliary data structures

---

# Example of O(1) Space

```java
int sum = 0;

for(int i = 0; i < n; i++) {
    sum += arr[i];
}
```

Only a few variables are used.

Extra memory does not increase with `n`.

Therefore:

```text
Auxiliary Space = O(1)
```

---

# 21. Example of O(n) Space

```java
int[] temp = new int[n];
```

The array size depends on `n`.

Therefore:

```text
Space Complexity = O(n)
```

---

# Time vs Space Complexity

| Time Complexity               | Space Complexity                |
| ----------------------------- | ------------------------------- |
| Measures execution operations | Measures memory usage           |
| Concerned with speed          | Concerned with memory           |
| Depends on input size         | Depends on input size           |
| Example: O(n)                 | Example: O(n)                   |
| Helps improve performance     | Helps reduce memory consumption |

---

# Auxiliary Space

**Auxiliary space** is the extra space used by an algorithm apart from the input data.

Example:

```java
int sum = 0;
```

If the input array is not counted, the algorithm uses constant extra space.

Therefore:

```text
Auxiliary Space = O(1)
```

---

# Total Space Complexity

Total space generally includes:

```text
Input Space + Auxiliary Space
```

For example, if an algorithm receives an array of `n` elements and creates another array of `n` elements:

```text
Input Space = O(n)
Auxiliary Space = O(n)
```

Total:

```text
O(n)
```

---

# Best Case, Average Case and Worst Case

Algorithm performance may vary depending on the input.

There are three important cases:

1. Best Case
2. Average Case
3. Worst Case

---

# Best Case

The **best case** represents the minimum amount of work performed by an algorithm.

### Example: Linear Search

Array:

```text
10 20 30 40 50
```

Searching for:

```text
10
```

The element is found at the first position.

Only one comparison is required.

Therefore:

```text
Best Case = O(1)
```

---

# Worst Case

The **worst case** represents the maximum amount of work performed.

In Linear Search, if the element is:

* At the last position, or
* Not present

We may check all `n` elements.

Therefore:

```text
Worst Case = O(n)
```

---

# Average Case

Average case represents the expected amount of work over typical inputs.

For Linear Search, assuming the element is equally likely to be at any position:

```text
Average comparisons ≈ n/2
```

Ignoring constants:

```text
O(n)
```

---

# Best, Average and Worst Case Example

For Linear Search:

| Case         | Complexity |
| ------------ | ---------- |
| Best Case    | O(1)       |
| Average Case | O(n)       |
| Worst Case   | O(n)       |

---

# Asymptotic Analysis

**Asymptotic analysis** is a mathematical method used to describe the growth rate of an algorithm as the input size becomes very large.

It focuses on:

```text
Growth of running time
```

rather than actual machine-dependent execution time.

The three major asymptotic notations are:

1. Big-O — O
2. Big-Omega — Ω
3. Big-Theta — Θ

---

# Big-O Notation — O

## Definition

**Big-O notation represents an upper bound on the growth of an algorithm.**

In algorithm analysis, Big-O is commonly used to describe the **worst-case growth rate**.

It tells us that the running time will not grow faster than a certain rate, up to constant factors, for sufficiently large input sizes.

---

# Big-O Example

Suppose:

```text
T(n) = 3n² + 5n + 10
```

We ignore:

* Constant coefficients
* Lower-order terms

Therefore:

```text
T(n) = O(n²)
```

Because `n²` dominates `n` and the constant.

---

# Rules for Finding Big-O

## Rule 1: Ignore Constants

```text
O(5n)
```

becomes:

```text
O(n)
```

Similarly:

```text
O(100n²)
```

becomes:

```text
O(n²)
```

---

## Rule 2: Ignore Lower-Order Terms

Suppose:

```text
T(n) = n² + n + 10
```

The dominant term is:

```text
n²
```

Therefore:

```text
O(n²)
```

---

## Rule 3: Sequential Statements Are Added

Example:

```java
for(int i = 0; i < n; i++) {
    // O(n)
}

for(int i = 0; i < n; i++) {
    // O(n)
}
```

Total:

```text
O(n) + O(n)
= O(2n)
= O(n)
```

---

## Rule 4: Nested Loops Are Multiplied

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

    }
}
```

Complexity:

```text
O(n × n)
= O(n²)
```

---

# Big-O Mathematical Definition

If there exist positive constants `c` and `n₀` such that:

```text
0 ≤ f(n) ≤ c × g(n)
```

for all:

```text
n ≥ n₀
```

then:

```text
f(n) = O(g(n))
```

Here:

* `f(n)` = actual running-time function
* `g(n)` = upper-bound function
* `c` = positive constant
* `n₀` = threshold value

---

# Big-O Example Mathematically

Suppose:

```text
f(n) = 3n + 5
```

We want to prove:

```text
f(n) = O(n)
```

For sufficiently large `n`:

```text
3n + 5 ≤ 8n
```

for:

```text
n ≥ 1
```

Therefore, suitable constants exist.

Hence:

```text
3n + 5 = O(n)
```

---

# Big-Omega Notation — Ω

## Definition

**Big-Omega represents the lower bound of an algorithm's growth rate.**

It tells us that an algorithm requires at least a certain amount of work asymptotically.

Mathematically:

```text
f(n) = Ω(g(n))
```

means that for sufficiently large `n`:

```text
f(n) ≥ c × g(n)
```

for some positive constant `c`.

---

# Big-Omega Example

Suppose:

```text
f(n) = 3n² + 5n + 10
```

The dominant growth is:

```text
n²
```

Therefore:

```text
f(n) = Ω(n²)
```

---

# Big-Theta Notation — Θ

## Definition

**Big-Theta represents a tight asymptotic bound.**

It means that a function is bounded both above and below by the same asymptotic function.

Mathematically:

```text
f(n) = Θ(g(n))
```

if:

```text
c₁g(n) ≤ f(n) ≤ c₂g(n)
```

for sufficiently large `n`.

Where:

```text
c₁ > 0
c₂ > 0
```

---

# Example of Big-Theta

Suppose:

```text
f(n) = 3n² + 5n + 10
```

The dominant term is:

```text
n²
```

Therefore:

```text
f(n) = Θ(n²)
```

This means the function grows at the same asymptotic rate as `n²`.

---

# Difference Between O, Ω and Θ

| Notation | Meaning     | Bound                |
| -------- | ----------- | -------------------- |
| O(g(n))  | Upper Bound | At most              |
| Ω(g(n))  | Lower Bound | At least             |
| Θ(g(n))  | Tight Bound | Both upper and lower |

### Easy Memory Trick

```text
O   → Upper
Ω   → Lower
Θ   → Tight
```

---

# Graphical Interpretation

Conceptually:

```text
          Upper Bound
             O(g(n))
               /
              /
             /
      f(n)  /
           /
----------/----------------
        /
       /
      /
     Ω(g(n))
     Lower Bound
```

For Theta:

```text
Upper Bound
     \
      \   f(n)
       \  /
        \/
        /\
       /  \
      /    \
Lower Bound
```

Theta means the function is trapped between constant multiples of the same function.

---

#  Important Complexity Examples

## Example 1

```java
int x = 10;
```

Time:

```text
O(1)
```

Space:

```text
O(1)
```

---

## Example 2

```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Time:

```text
O(n)
```

Space:

```text
O(1)
```

---

## Example 3

```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Time:

```text
O(n²)
```

Space:

```text
O(1)
```

---

# Nested Loop with Different Sizes

Consider:

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < m; j++) {

    }
}
```

Outer loop:

```text
n
```

Inner loop:

```text
m
```

Total:

```text
n × m
```

Therefore:

```text
O(nm)
```

---

# Dependent Nested Loops

Consider:

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < i; j++) {

    }
}
```

Number of operations:

```text
0 + 1 + 2 + 3 + ... + (n-1)
```

Using the formula:

```text
n(n-1)/2
```

Therefore:

```text
T(n) = n(n-1)/2
```

Ignoring constants and lower-order terms:

```text
O(n²)
```

---

# Loop Dividing by 2

Consider:

```java
for(int i = n; i > 1; i = i / 2) {
    System.out.println(i);
}
```

Values approximately become:

```text
n
n/2
n/4
n/8
n/16
...
1
```

Number of iterations:

```text
log₂ n
```

Therefore:

```text
O(log n)
```

---

# Loop Multiplying by 2

Consider:

```java
for(int i = 1; i < n; i = i * 2) {
    System.out.println(i);
}
```

Values:

```text
1
2
4
8
16
32
...
```

Number of iterations:

```text
log₂ n
```

Therefore:

```text
O(log n)
```

---

# Two Separate Loops

```java
for(int i = 0; i < n; i++) {
}
    
for(int j = 0; j < n; j++) {
}
```

Complexity:

```text
O(n) + O(n)
```

```text
O(2n)
```

Ignoring constants:

```text
O(n)
```

---

# One Loop Inside Another

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

    }
}
```

Complexity:

```text
O(n²)
```

Remember:

```text
Sequential → Add
Nested → Multiply
```

---


# Complexity of Common Operations

| Operation                        | Complexity |
| -------------------------------- | ---------: |
| Array access                     |       O(1) |
| Array update                     |       O(1) |
| Linear Search                    |       O(n) |
| Binary Search                    |   O(log n) |
| Array traversal                  |       O(n) |
| Insertion at beginning of array  |       O(n) |
| Deletion from beginning of array |       O(n) |
| Merge Sort                       | O(n log n) |
| Heap Sort                        | O(n log n) |
| Quick Sort average               | O(n log n) |
| Quick Sort worst                 |      O(n²) |

---

# Complexity of Common Sorting Algorithms

| Sorting Algorithm |       Best |    Average |      Worst |
| ----------------- | ---------: | ---------: | ---------: |
| Bubble Sort       |       O(n) |      O(n²) |      O(n²) |
| Selection Sort    |      O(n²) |      O(n²) |      O(n²) |
| Insertion Sort    |       O(n) |      O(n²) |      O(n²) |
| Merge Sort        | O(n log n) | O(n log n) | O(n log n) |
| Quick Sort        | O(n log n) | O(n log n) |      O(n²) |
| Heap Sort         | O(n log n) | O(n log n) | O(n log n) |

---

# Complexity of Searching Algorithms

| Algorithm     | Best |  Average |    Worst |
| ------------- | ---: | -------: | -------: |
| Linear Search | O(1) |     O(n) |     O(n) |
| Binary Search | O(1) | O(log n) | O(log n) |

Binary Search requires a **sorted array**.

---

# Recursion and Time Complexity

Recursion can affect both time and space complexity.

Example:

```java
void fun(int n) {

    if(n == 0)
        return;

    System.out.println(n);

    fun(n - 1);
}
```

The function is called:

```text
n times
```

Therefore:

```text
Time Complexity = O(n)
```


---
# Common Complexity Mistakes

### Mistake 1

Thinking:

```text
O(2n) = O(2n)
```

Correct:

```text
O(2n) = O(n)
```

---

### Mistake 2

Thinking:

```text
O(n² + n) = O(n² + n)
```

Correct:

```text
O(n²)
```

---

### Mistake 3

Two nested loops are always:

```text
O(n²)
```

Not necessarily.

Example:

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < m; j++) {

    }
}
```

Complexity:

```text
O(nm)
```

---

# Dominant Term Concept

Suppose:

```text
T(n) = 7n³ + 5n² + 10n + 100
```

For large `n`, the dominant term is:

```text
n³
```

Therefore:

```text
T(n) = O(n³)
```

We ignore:

```text
7
5n²
10n
100
```

because their growth is smaller than `n³`.

---

# Constants and Asymptotic Analysis

Suppose:

```text
Algorithm A = 5n
Algorithm B = 100n
```

Both have:

```text
O(n)
```

Asymptotic notation ignores constant factors.

However, in real-world implementations, constants can still matter.

---

# 61. Comparing O(n) and O(n²)

For:

```text
n = 10
```

```text
n = 10
n² = 100
```

For:

```text
n = 1000
```

```text
n = 1000
n² = 1,000,000
```

As `n` increases, quadratic algorithms become significantly more expensive.

---

# Growth Table

|  n | log₂n |  n | n log₂n |    n² |         2ⁿ |
| -: | ----: | -: | ------: | ----: | ---------: |
|  2 |     1 |  2 |       2 |     4 |          4 |
|  4 |     2 |  4 |       8 |    16 |         16 |
|  8 |     3 |  8 |      24 |    64 |        256 |
| 16 |     4 | 16 |      64 |   256 |     65,536 |
| 32 |     5 | 32 |     160 | 1,024 | Very large |

This demonstrates why lower-complexity algorithms are preferred for large inputs.

---

# Asymptotic Notation Comparison

| Feature    | Big-O               | Big-Ω            | Big-Θ                   |
| ---------- | ------------------- | ---------------- | ----------------------- |
| Symbol     | O                   | Ω                | Θ                       |
| Meaning    | Upper bound         | Lower bound      | Tight bound             |
| Represents | At most             | At least         | Exact asymptotic growth |
| Common use | Worst-case analysis | Best/lower bound | Tight complexity        |

---

# Mathematical Relationships

If:

```text
f(n) = Θ(g(n))
```

then:

```text
f(n) = O(g(n))
```

and:

```text
f(n) = Ω(g(n))
```

Therefore:

```text
Θ(g(n)) ⟹ O(g(n)) and Ω(g(n))
```

---

# Important Exam Example

Find the complexity:

```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}

for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

First loop:

```text
O(n)
```

Second part:

```text
O(n²)
```

Total:

```text
O(n + n²)
```

Dominant term:

```text
n²
```

Final answer:

```text
O(n²)
```

---

# Another Important Exam Example

Find the complexity:

```java
for(int i = 1; i <= n; i *= 2) {
    for(int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Outer loop:

```text
O(log n)
```

Inner loop:

```text
O(n)
```

Nested:

```text
O(n log n)
```

Final answer:

```text
O(n log n)
```

---

# Example: Three Loops

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

        for(int k = 0; k < n; k++) {

        }
    }
}
```

Total:

```text
n × n × n
```

Therefore:

```text
O(n³)
```

---

# Example: Logarithmic Loop

```java
int i = n;

while(i > 1) {
    i = i / 2;
}
```

Values:

```text
n
n/2
n/4
n/8
...
1
```

Therefore:

```text
O(log n)
```

---

# Example: Constant + Linear

```java
int x = 10;

for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Complexity:

```text
O(1) + O(n)
```

Therefore:

```text
O(n)
```

---

# Example: Linear + Quadratic

```java
for(int i = 0; i < n; i++) {
}

for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
    }
}
```

Complexity:

```text
O(n) + O(n²)
```

Therefore:

```text
O(n²)
```

---

# Algorithm Efficiency

An efficient algorithm should ideally:

* Take less time
* Use less memory
* Work correctly
* Scale well for large input
* Be simple enough to maintain

There is often a trade-off between time and space.

---

#  Time-Space Trade-Off

Sometimes we use additional memory to reduce execution time.

Example:

Using a HashMap for searching/frequency counting.

Without additional data structure:

```text
O(n²)
```

With HashMap:

```text
O(n)
```

But additional memory is required.

Thus:

```text
More Space → Less Time
```

in some situations.

This is called a **time-space trade-off**.

---

# 73. Important Complexity

```text
Single statement        → O(1)

Single loop              → O(n)

Two independent loops    → O(n)

Nested loops             → O(n²)

Three nested loops       → O(n³)

Divide by 2              → O(log n)

Multiply by 2            → O(log n)

Divide + linear work     → O(n log n)

All subsets              → O(2ⁿ)

All permutations         → O(n!)
```

---
