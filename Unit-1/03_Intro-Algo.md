# Introduction to Algorithms

## What is an Algorithm?

An **algorithm** is a finite sequence of well-defined, step-by-step instructions used to solve a particular problem or perform a particular task.

In simple words:

> **An algorithm is a step-by-step procedure for solving a problem.**

Before writing a program, we generally need to understand the problem and decide the steps required to solve it.

For example, if we want to find the largest number from an array:

```text
10 25 7 40 15
```

We can solve the problem using the following steps:

```text
1. Start
2. Assume the first element is the maximum.
3. Compare it with the second element.
4. If the second element is greater, update maximum.
5. Continue comparing with all remaining elements.
6. Display the maximum value.
7. Stop
```

The above sequence of steps is an **algorithm**.

---

# 1. Why Do We Need Algorithms?

Computers are very fast, but they cannot solve a problem intelligently unless we provide them with instructions.

An algorithm provides a systematic way to solve a problem.

Consider the problem:

> Find the sum of two numbers.

We can write the algorithm as:

```text
Step 1: Start
Step 2: Read number A
Step 3: Read number B
Step 4: Calculate A + B
Step 5: Display the result
Step 6: Stop
```

Then we can convert this algorithm into a programming language such as Java, C++, Python, etc.

For example:

```java
int a = 10;
int b = 20;

int sum = a + b;

System.out.println(sum);
```

Therefore:

```text
Problem
   ↓
Algorithm
   ↓
Program
   ↓
Output
```

---

# 2. Algorithm vs Program

An algorithm and a program are not exactly the same.

## Algorithm

An algorithm is a **logical solution** to a problem.

It is generally independent of a particular programming language.

Example:

```text
1. Read two numbers
2. Add the numbers
3. Display the result
```

## Program

A program is the actual implementation of an algorithm using a programming language.

Example in Java:

```java
int a = 10;
int b = 20;

int sum = a + b;

System.out.println(sum);
```

Therefore:

```text
Algorithm = Logic / Steps
Program   = Implementation of those steps
```

---

# 3. Characteristics of an Algorithm

A good algorithm generally has the following characteristics:

```text
1. Input
2. Output
3. Definiteness
4. Finiteness
5. Effectiveness
6. Correctness
7. Generality
```

These characteristics help us determine whether a sequence of instructions can be considered a proper algorithm.

---

# 4. Input

An algorithm may receive zero or more inputs.

Input is the data provided to the algorithm.

For example, to calculate the sum of two numbers:

```text
Input:
A = 10
B = 20
```

The algorithm uses these values to produce the result.

Another example:

For finding the maximum element:

```text
Input:
10 20 30 15 5
```

The input consists of the elements of the array.

---

# 5. Output

An algorithm should produce at least one output.

Output is the result generated after processing the input.

Example:

```text
Input:
10
20

Output:
30
```

For maximum element:

```text
Input:
10 25 7 40 15

Output:
40
```

Therefore:

```text
Input
  ↓
Algorithm
  ↓
Output
```

---

# 6. Definiteness

**Definiteness** means that every step of an algorithm must be clear and unambiguous.

Each instruction should have only one clear interpretation.

### Incorrect

```text
Do something with the number.
```

This is ambiguous.

### Correct

```text
Add 10 to the number.
```

The instruction is clear.

Another example:

```text
If A > B, assign A to max.
Otherwise assign B to max.
```

Every step has a definite meaning.

---

# 7. Finiteness

An algorithm must terminate after a finite number of steps.

It cannot continue indefinitely for a valid input.

For example:

```text
1. Start
2. Read A
3. Read B
4. Calculate A + B
5. Display result
6. Stop
```

The algorithm terminates.

An algorithm that continuously executes without reaching a stopping condition is not a finite algorithm.

For example:

```text
while(true) {
    System.out.println("Hello");
}
```

This is an infinite loop unless there is some mechanism to terminate it.

---

# 8. Effectiveness

Each step of an algorithm should be basic enough that it can actually be performed.

For example:

```text
Add two numbers
Compare two numbers
Assign a value
Read an input
Display an output
```

These are effective operations.

An algorithm should not contain instructions that cannot realistically be executed.

---

# 9. Correctness

A good algorithm must produce the correct output for valid inputs.

Suppose the problem is:

> Find the maximum of two numbers.

Input:

```text
A = 10
B = 20
```

Correct output:

```text
20
```

An algorithm that always returns `10` would not be correct.

Correctness is one of the most important properties of an algorithm.

---

# 10. Generality

An algorithm should ideally solve a class of problems rather than only one specific input.

For example, this is not a useful general algorithm:

```text
10 + 20 = 30
```

It only solves one particular case.

A better algorithm is:

```text
1. Read A
2. Read B
3. Calculate A + B
4. Display A + B
```

This works for:

```text
5 + 7
100 + 200
1000 + 500
-10 + 20
```

Therefore, a good algorithm should be applicable to a range of valid inputs.

---

# 11. Basic Structure of an Algorithm

A simple algorithm can be represented as:

```text
START
  ↓
INPUT
  ↓
PROCESS
  ↓
OUTPUT
  ↓
STOP
```

For example:

```text
START
  ↓
Read A and B
  ↓
Calculate Sum = A + B
  ↓
Display Sum
  ↓
STOP
```

---

# 12. Example: Algorithm to Add Two Numbers

### Problem

Write an algorithm to calculate the sum of two numbers.

### Algorithm

```text
Step 1: Start
Step 2: Read A
Step 3: Read B
Step 4: Sum = A + B
Step 5: Display Sum
Step 6: Stop
```

### Example

```text
A = 10
B = 20

Sum = 10 + 20

Sum = 30
```

---

# 13. Example: Find Maximum of Two Numbers

### Problem

Find the maximum of two numbers.

### Algorithm

```text
Step 1: Start
Step 2: Read A and B
Step 3: If A > B, then MAX = A
Step 4: Otherwise MAX = B
Step 5: Display MAX
Step 6: Stop
```

Example:

```text
A = 25
B = 40
```

Since:

```text
40 > 25
```

Output:

```text
40
```

---

# 14. Example: Find Maximum Element in an Array

Consider:

```text
arr = [10, 25, 7, 40, 15]
```

We need to find the maximum element.

### Algorithm

```text
Step 1: Start
Step 2: Read array
Step 3: Set max = first element
Step 4: Compare max with each remaining element
Step 5: If current element > max, update max
Step 6: Repeat until all elements are checked
Step 7: Display max
Step 8: Stop
```

### Working

```text
Initial max = 10

Compare 25:
25 > 10
max = 25

Compare 7:
7 > 25 → No

Compare 40:
40 > 25
max = 40

Compare 15:
15 > 40 → No
```

Final result:

```text
Maximum = 40
```

---

# 15. Algorithm Representation

Algorithms can be represented in different ways.

Common methods include:

```text
1. Natural Language
2. Pseudocode
3. Flowchart
4. Programming Language
```

---

# 16. Natural Language

We can write an algorithm using simple English statements.

Example:

```text
1. Start
2. Read two numbers
3. Add the two numbers
4. Display the result
5. Stop
```

This is easy to understand but may sometimes become ambiguous for complex problems.

---

# 17. Pseudocode

**Pseudocode** is a structured way of writing an algorithm using programming-like statements without following the syntax of a specific programming language.

Example:

```text
BEGIN

READ A
READ B

SUM ← A + B

PRINT SUM

END
```

Pseudocode is useful because it focuses on logic rather than programming-language syntax.

---

# 18. Flowchart

A flowchart represents an algorithm graphically.

Common flowchart symbols include:

```text
Oval       → Start / Stop
Rectangle  → Process
Parallelogram → Input / Output
Diamond    → Decision
Arrow      → Flow direction
```

For example:

```text
       START
         ↓
      Read A,B
         ↓
     Sum = A+B
         ↓
    Display Sum
         ↓
        STOP
```

Flowcharts are particularly useful for understanding the flow of a problem visually.

---

# 19. Algorithm and Flowchart

Suppose we want to check whether a number is even or odd.

### Algorithm

```text
Step 1: Start
Step 2: Read N
Step 3: Calculate N % 2
Step 4: If N % 2 == 0, print "Even"
Step 5: Otherwise print "Odd"
Step 6: Stop
```

### Logic

```text
        N
        ↓
   N % 2 == 0?
      /     \
    Yes      No
     ↓        ↓
   Even      Odd
      \       /
       \     /
        STOP
```

---

# 20. Algorithm Design

Algorithm design is the process of developing a sequence of steps to solve a problem efficiently.

A common approach is:

```text
Understand the Problem
        ↓
Identify Input
        ↓
Identify Output
        ↓
Develop Logic
        ↓
Write Algorithm
        ↓
Test Algorithm
        ↓
Analyze Complexity
        ↓
Implement Program
```

---

# 21. Steps for Developing an Algorithm

## Step 1: Understand the Problem

First understand exactly what the problem is asking.

For example:

> Find the maximum element in an array.

We need to identify:

```text
Input  → Array
Output → Maximum element
```

---

## Step 2: Identify Inputs

Determine what information is given.

Example:

```text
Array size = n
Array elements = n integers
```

---

## Step 3: Identify Output

Determine what needs to be produced.

Example:

```text
Maximum element
```

---

## Step 4: Develop the Logic

Think about how the problem can be solved.

For maximum:

```text
Assume first element is maximum.
Compare remaining elements.
Update maximum whenever a larger element is found.
```

---

## Step 5: Write the Algorithm

Convert the logic into clear steps.

---

## Step 6: Test the Algorithm

Test using different inputs:

```text
Normal input
Small input
Large input
Duplicate values
Negative values
Single element
```

---

## Step 7: Analyze Complexity

Determine:

```text
Time Complexity
Space Complexity
```

---

## Step 8: Implement

Finally convert the algorithm into a programming language.

---

# 22. Algorithm Analysis

Once an algorithm is designed, we should analyze it.

The two most important resources are:

```text
1. Time
2. Space
```

Therefore:

```text
Algorithm Analysis
       |
       |----------------|
       ↓                ↓
Time Complexity   Space Complexity
```

---

# 23. Time Complexity

Time complexity describes how the running time of an algorithm grows as the input size increases.

It does not necessarily mean the exact time in seconds.

Instead, we analyze the number of operations relative to input size.

For example:

```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```

The loop runs approximately `n` times.

Therefore:

```text
Time Complexity = O(n)
```

---

# 24. Space Complexity

Space complexity describes how much additional memory an algorithm requires as the input size grows.

Example:

```java
int sum = 0;
```

This uses constant extra space.

Therefore:

```text
Space Complexity = O(1)
```

If an algorithm creates an additional array of size `n`:

```java
int[] temp = new int[n];
```

then the additional space is:

```text
O(n)
```

---

# 25. Why Analyze Algorithms?

Two programs may produce the same output but have very different performance.

Consider searching for an element.

### Linear Search

```text
Check elements one by one.
```

Complexity:

```text
O(n)
```

### Binary Search

On a sorted array:

```text
Repeatedly divide the search space into half.
```

Complexity:

```text
O(log n)
```

For a very large input, the difference can be significant.

Therefore, algorithm analysis helps us choose efficient solutions.

---

# 26. Best Case, Average Case and Worst Case

An algorithm's performance can be analyzed under different conditions.

```text
Best Case
Average Case
Worst Case
```

---

## Best Case

The minimum amount of work performed by the algorithm.

Example: Linear Search

```text
Array:
10 20 30 40 50

Search = 10
```

The element is found at the first position.

Best case:

```text
O(1)
```

---

## Worst Case

The maximum amount of work performed.

Example:

```text
Search = 50
```

or the element is not present.

We may need to check all `n` elements.

Worst case:

```text
O(n)
```

---

## Average Case

Represents expected performance over typical inputs.

The exact analysis depends on the problem and assumptions about the input distribution.

---

# 27. Common Time Complexities

Common complexity classes include:

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
O(2ⁿ)
O(n!)
```

From generally more efficient to less efficient for large `n`:

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
O(2ⁿ)
   ↓
O(n!)
```

This ordering is a general growth comparison; actual performance also depends on constants, hardware, and implementation.

---

# 28. Constant Time — O(1)

An algorithm is `O(1)` when the amount of work does not depend on input size.

Example:

```java
int x = arr[0];
```

Accessing an array element by index is generally constant time.

Another example:

```java
int sum = a + b;
```

The operation does not grow with `n`.

Therefore:

```text
O(1)
```

---

# 29. Logarithmic Time — O(log n)

An algorithm is logarithmic when the problem size is repeatedly reduced by a factor, commonly by half.

Binary Search is a classic example.

Suppose:

```text
n = 16
```

Binary search approximately reduces the search space:

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

Therefore:

```text
O(log n)
```

---

# 30. Linear Time — O(n)

An algorithm is linear when the amount of work grows proportionally with the input size.

Example:

```java
for(int i = 0; i < n; i++) {
    System.out.println(arr[i]);
}
```

If:

```text
n = 10
```

approximately 10 iterations occur.

If:

```text
n = 1000
```

approximately 1000 iterations occur.

Therefore:

```text
O(n)
```

---

# 31. Linearithmic Time — O(n log n)

Common efficient sorting algorithms such as Merge Sort have:

```text
O(n log n)
```

time complexity in their standard analysis.

The algorithm combines:

```text
Divide
+
Process/Merge
```

This complexity is generally better than quadratic time for large inputs.

---

# 32. Quadratic Time — O(n²)

An algorithm often has `O(n²)` complexity when it uses two nested loops over the same input.

Example:

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

        System.out.println(i + " " + j);
    }
}
```

The outer loop runs:

```text
n
```

times.

The inner loop runs:

```text
n
```

times for each outer iteration.

Total:

```text
n × n = n²
```

Therefore:

```text
O(n²)
```

---

# 33. Exponential Time — O(2ⁿ)

Some recursive algorithms generate a number of possibilities that grows exponentially.

For example, generating all subsets of a set of `n` elements results in:

```text
2ⁿ
```

possible subsets.

Therefore:

```text
O(2ⁿ)
```

can arise in subset-generation algorithms.

---

# 34. Factorial Time — O(n!)

Factorial complexity occurs in problems involving permutations of `n` elements.

The number of permutations is:

```text
n!
```

For example:

```text
3! = 6
```

```text
4! = 24
```

```text
5! = 120
```

The growth becomes extremely large very quickly.

---

# 35. Algorithm Correctness

An algorithm should be verified to ensure that it produces the correct result.

For example:

```text
Problem:
Find maximum element.

Input:
[5, 10, 3, 20]

Expected:
20
```

We test whether our algorithm produces:

```text
20
```

We should test multiple cases.

### Test Case 1

```text
[10, 20, 30]
Output: 30
```

### Test Case 2

```text
[-10, -5, -20]
Output: -5
```

### Test Case 3

```text
[5]
Output: 5
```

### Test Case 4

```text
[10, 10, 10]
Output: 10
```

Testing helps identify logical errors.

---

# 36. Algorithm Efficiency

A good algorithm should ideally:

```text
1. Produce correct output
2. Use reasonable time
3. Use reasonable memory
4. Be understandable
5. Be maintainable
```

There is often a trade-off between time and space.

For example:

```text
Use more memory
       ↓
May reduce execution time
```

This is known as a:

> **Time-Space Trade-off**

---

# 37. Time-Space Trade-off

Sometimes we can make an algorithm faster by using additional memory.

For example, hashing often uses extra memory to achieve faster lookup.

Conceptually:

```text
More Space
    ↓
Potentially Faster Operations
```

Alternatively, we may use less memory at the cost of additional computation.

Therefore, algorithm design involves selecting an appropriate balance.

---

# 38. Algorithm vs Data Structure

Algorithms and data structures are closely related.

A data structure organizes data.

An algorithm processes data.

For example:

```text
Array
 ↓
Data Structure

Binary Search
 ↓
Algorithm
```

Together:

```text
Data Structure + Algorithm
            ↓
     Efficient Program
```

Choosing the correct data structure can make an algorithm much more efficient.

---

# 39. Examples of Algorithms in DSA

Important algorithms studied in Data Structures and Algorithms include:

### Searching

```text
Linear Search
Binary Search
```

### Sorting

```text
Bubble Sort
Selection Sort
Insertion Sort
Merge Sort
Quick Sort
Heap Sort
```

### Graph Algorithms

```text
BFS
DFS
Dijkstra's Algorithm
Floyd-Warshall Algorithm
Prim's Algorithm
Kruskal's Algorithm
```

### Tree Algorithms

```text
Tree Traversal
Inorder
Preorder
Postorder
Level Order
```

### Recursion and Backtracking

```text
Factorial
Fibonacci
Subsets
Permutations
N-Queens
Maze Problems
```

---

# 40. Algorithm Design Techniques

Different problems require different approaches.

Common algorithm design techniques include:

```text
1. Brute Force
2. Divide and Conquer
3. Greedy
4. Dynamic Programming
5. Backtracking
6. Recursion
7. Branch and Bound
```

---

# 41. Brute Force

Brute force means trying all possible solutions or using a straightforward approach.

Example:

To find an element in an unsorted array:

```text
Check first element
Check second element
Check third element
...
Check last element
```

This is Linear Search.

Complexity:

```text
O(n)
```

Brute force is often easy to understand but may not be the most efficient approach.

---

# 42. Divide and Conquer

Divide and Conquer solves a problem by:

```text
Divide
 ↓
Solve smaller problems
 ↓
Combine results
```

Examples:

```text
Merge Sort
Quick Sort
Binary Search
```

For example, Merge Sort divides an array into smaller parts and then combines sorted parts.

---

# 43. Greedy Algorithm

A greedy algorithm makes the best-looking local choice at each step.

The idea is:

```text
Choose the best current option
        ↓
Continue
        ↓
Build final solution
```

Examples include:

```text
Activity Selection
Fractional Knapsack
Huffman Coding
Prim's Algorithm
Kruskal's Algorithm
```

Greedy methods do not automatically produce an optimal solution for every problem; their correctness depends on the specific problem.

---

# 44. Dynamic Programming

Dynamic Programming is used when a problem contains overlapping subproblems and an appropriate optimal-substructure property.

The general idea is:

```text
Break problem into subproblems
        ↓
Solve subproblems
        ↓
Store results
        ↓
Reuse results
```

Common examples:

```text
Fibonacci
0/1 Knapsack
Longest Common Subsequence
Coin Change
Matrix Chain Multiplication
```

---

# 45. Backtracking

Backtracking builds a solution step by step.

If a choice leads to an invalid solution, we go back and try another choice.

General idea:

```text
Choose
 ↓
Explore
 ↓
Valid?
 ↓
Yes → Continue
No  → Backtrack
```

Examples:

```text
N-Queens
Sudoku
Rat in a Maze
Permutations
Subsets
```

---

# 46. Recursion

Recursion occurs when a function calls itself to solve a smaller version of the same problem.

Example:

```java
static int factorial(int n) {

    if (n == 0) {
        return 1;
    }

    return n * factorial(n - 1);
}
```

For:

```text
factorial(5)
```

the calls are conceptually:

```text
5 × factorial(4)
      ↓
4 × factorial(3)
      ↓
3 × factorial(2)
      ↓
2 × factorial(1)
      ↓
1 × factorial(0)
      ↓
1
```

---

# 47. Algorithm Complexity Example

Consider:

```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```

The loop runs `n` times.

Therefore:

```text
Time Complexity = O(n)
Space Complexity = O(1)
```

Now consider:

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

        System.out.println(i + j);
    }
}
```

Total operations:

```text
n × n = n²
```

Therefore:

```text
Time Complexity = O(n²)
Space Complexity = O(1)
```

---

# 48. Algorithm Example: Linear Search

### Problem

Find an element in an array.

Input:

```text
arr = [10, 20, 30, 40, 50]
target = 40
```

### Algorithm

```text
Step 1: Start
Step 2: Read array and target
Step 3: Start from index 0
Step 4: Compare current element with target
Step 5: If equal, return the index
Step 6: Otherwise move to the next element
Step 7: Repeat until the array ends
Step 8: If not found, return -1
Step 9: Stop
```

### Complexity

Best case:

```text
O(1)
```

Worst case:

```text
O(n)
```

---

# 49. Algorithm Example: Binary Search

Binary Search works on a **sorted array**.

Example:

```text
[10, 20, 30, 40, 50, 60, 70]
```

Search:

```text
60
```

Instead of checking every element, binary search repeatedly examines the middle and discards half of the remaining search space.

General steps:

```text
1. Find middle element
2. Compare middle with target
3. If equal → found
4. If target is smaller → search left half
5. If target is larger → search right half
6. Repeat
```

Time complexity:

```text
O(log n)
```

---

# 50. Importance of Choosing the Right Algorithm

Suppose we have:

```text
1,000,000 elements
```

An `O(n)` algorithm performs work proportional to:

```text
1,000,000
```

An `O(log n)` algorithm requires far fewer search steps.

This demonstrates why algorithm selection matters, especially for large inputs.

---

# 51. Algorithm Documentation

A good algorithm should be documented clearly.

Documentation can include:

```text
Problem Statement
Input
Output
Algorithm
Example
Correctness
Time Complexity
Space Complexity
```

Example:

```text
Problem:
Find maximum element.

Input:
Array of n integers.

Output:
Maximum element.

Approach:
Traverse the array and maintain the largest value seen so far.

Time Complexity:
O(n)

Space Complexity:
O(1)
```

---

# 52. Pseudocode Example

### Find Maximum Element

```text
Algorithm FindMaximum(arr, n)

    max ← arr[0]

    for i ← 1 to n - 1

        if arr[i] > max then
            max ← arr[i]

    return max

End Algorithm
```

---

# 53. Algorithm Design Checklist

Before implementing an algorithm, ask:

```text
✓ What is the problem?

✓ What are the inputs?

✓ What is the expected output?

✓ What constraints exist?

✓ What is the simplest solution?

✓ Can the solution be optimized?

✓ What data structure should be used?

✓ What is the time complexity?

✓ What is the space complexity?

✓ Does it work for edge cases?

✓ Is the algorithm correct?
```

---

# 54. Common Mistakes While Designing Algorithms

### 1. Not understanding the problem

Writing code before understanding the requirements often leads to incorrect solutions.

---

### 2. Ignoring edge cases

Examples:

```text
Empty array
Single element
Negative numbers
Duplicate values
Very large input
```

---

### 3. Ignoring constraints

A solution that works for:

```text
n = 10
```

may not work efficiently for:

```text
n = 10⁶
```

---

### 4. Choosing an inefficient approach

Sometimes a brute-force solution works but is too slow for large inputs.

---

### 5. Not analyzing complexity

Always consider:

```text
Time
Space
```

before finalizing the solution.

---

# 55. Algorithm and Problem Solving

Algorithmic problem solving can be viewed as:

```text
Problem
   ↓
Understand
   ↓
Analyze
   ↓
Design
   ↓
Test
   ↓
Optimize
   ↓
Implement
   ↓
Verify
```

This process is fundamental to Data Structures and Algorithms.

---

# 56. Real-Life Example of an Algorithm

Consider making tea.

A simplified algorithm might be:

```text
Step 1: Start
Step 2: Boil water
Step 3: Add tea leaves
Step 4: Add milk
Step 5: Add sugar
Step 6: Boil the mixture
Step 7: Filter the tea
Step 8: Serve
Step 9: Stop
```

This is an everyday example of a sequence of well-defined steps.

The same concept is used in computer algorithms, although computer algorithms need precise instructions that can be executed by a computer.

---

# 57. Algorithm in Computer Science

Algorithms are the foundation of computer science.

They are used in:

```text
Operating Systems
Database Systems
Artificial Intelligence
Machine Learning
Computer Networks
Cybersecurity
Compilers
Web Applications
Search Engines
Data Analysis
Computer Graphics
```

Almost every software system uses algorithms.

---

# 58. Algorithm and Data Structures

Data Structures and Algorithms are closely connected.

```text
              DSA
             /   \
            /     \
   Data Structures  Algorithms
          |              |
          ↓              ↓
    Organize Data    Process Data
```

Examples:

```text
Array + Linear Search
Array + Binary Search
Stack + DFS
Queue + BFS
Heap + Priority Queue
Hash Table + Fast Lookup
Tree + Tree Traversal
Graph + Dijkstra
```

Choosing an appropriate data structure often makes it possible to design a more efficient algorithm.

---

## Important Complexities

```text
O(1)       → Constant
O(log n)   → Logarithmic
O(n)       → Linear
O(n log n) → Linearithmic
O(n²)      → Quadratic
O(2ⁿ)      → Exponential
O(n!)      → Factorial
```
