# Polynomial Representation Using Arrays

## 1. Introduction

A **polynomial** is a mathematical expression that contains variables, coefficients, and exponents.

Example:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

Here:

* `5, 4, 2, 7` are coefficients.
* `x` is the variable.
* `3, 2, 1, 0` are exponents.
* `3` is the highest exponent, so the degree of the polynomial is `3`.

In Data Structures, a polynomial has to be stored in some structured form so that a computer can easily perform operations such as:

* Addition
* Subtraction
* Multiplication
* Evaluation
* Differentiation
* Display

One of the simplest ways to represent a polynomial is by using an **array**.

---

# 2. What is Polynomial Representation?

Polynomial representation means storing the terms of a polynomial inside a data structure in such a way that different polynomial operations can be performed efficiently.

Suppose we have:

```text
P(x) = 6x⁴ + 3x² + 5x + 2
```

A computer cannot directly understand this algebraic form in the same way humans do.

So we store the polynomial using data such as:

```text
Coefficient
Exponent
```

For example:

```text
6x⁴
```

can be represented as:

```text
Coefficient = 6
Exponent = 4
```

Similarly:

```text
3x²
```

can be represented as:

```text
Coefficient = 3
Exponent = 2
```

---

# 3. Basic Terminology

## Coefficient

The numerical value multiplied with a variable is called the coefficient.

Example:

```text
8x³
```

Here:

```text
Coefficient = 8
```

---

## Exponent

The power of the variable is called the exponent.

Example:

```text
8x³
```

Here:

```text
Exponent = 3
```

---

## Term

Every individual part of a polynomial is called a term.

Example:

```text
5x³ + 4x² + 2x + 7
```

Terms are:

```text
5x³
4x²
2x
7
```

---

## Degree

The highest exponent present in the polynomial is called the degree.

Example:

```text
7x⁵ + 2x² + 3
```

Degree:

```text
5
```

---

## Constant Term

A term that does not contain a variable is called the constant term.

Example:

```text
5x² + 2x + 9
```

Here:

```text
9
```

is the constant term.

We can also write:

```text
9 = 9x⁰
```

because:

```text
x⁰ = 1
```

---

# 4. Need for Polynomial Representation

Polynomial representation is important because computers need a proper data structure to process polynomial expressions.

For example:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

and:

```text
Q(x) = 3x³ + 2x² + 6
```

If we want to add these two polynomials, the computer should know which coefficients belong to the same exponent.

For example:

```text
5x³ + 3x³
```

can be combined because both terms have exponent `3`.

Similarly:

```text
4x² + 2x²
```

can be combined because both terms have exponent `2`.

An array representation makes this process easy.

---

# 5. Polynomial Representation Using Arrays

The most common array representation stores the coefficients in an array.

The array index represents the exponent.

Consider:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

Array representation:

```text
Index        0   1   2   3
Coefficient  7   2   4   5
```

Therefore:

```text
P = [7, 2, 4, 5]
```

The meaning is:

```text
P[0] = 7
P[1] = 2
P[2] = 4
P[3] = 5
```

So:

```text
P[0] = 7x⁰ = 7
P[1] = 2x¹ = 2x
P[2] = 4x²
P[3] = 5x³
```

Hence:

```text
5x³ + 4x² + 2x + 7
```

---

# 6. Important Rule

The most important rule is:

```text
Array Index = Exponent
Array Value = Coefficient
```

Example:

```text
[3, 5, 0, 8]
```

means:

```text
Index 0 → 3x⁰ = 3
Index 1 → 5x
Index 2 → 0x²
Index 3 → 8x³
```

Therefore the polynomial is:

```text
8x³ + 5x + 3
```

---

# 7. Representation with Missing Terms

Consider:

```text
P(x) = 7x⁵ + 3x² + 6
```

There are no terms for:

```text
x⁴
x³
x¹
```

Therefore their coefficients are stored as zero.

Array representation:

```text
Index        0   1   2   3   4   5
Coefficient  6   0   3   0   0   7
```

So:

```text
[6, 0, 3, 0, 0, 7]
```

represents:

```text
7x⁵ + 3x² + 6
```

This is one of the important characteristics of array representation.

---

# 8. Dense Polynomial

A polynomial is called dense when most powers are present.

Example:

```text
5x⁴ + 4x³ + 3x² + 2x + 1
```

Array:

```text
[1, 2, 3, 4, 5]
```

In this case, almost every array position contains a useful coefficient.

So array representation is very suitable.

---

# 9. Sparse Polynomial

A sparse polynomial contains very few terms compared to its highest degree.

Example:

```text
8x¹⁰⁰ + 5x⁴ + 2
```

Only three terms exist, but if we use the exponent as array index, we need an array from index `0` to `100`.

That means:

```text
101 positions
```

but only three positions contain useful values.

Most positions will contain zero.

Therefore, array representation can waste memory for sparse polynomials.

---

# 10. Why Array Representation is Simple

Array representation is simple because each exponent has a fixed location.

For example, coefficient of:

```text
x³
```

is always stored at:

```text
array[3]
```

Coefficient of:

```text
x⁵
```

is stored at:

```text
array[5]
```

Therefore direct access is very easy.

---

# 11. Polynomial Addition Using Arrays

Suppose:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

and:

```text
Q(x) = 3x³ + 2x² + 6
```

Their arrays are:

```text
P = [7, 2, 4, 5]
Q = [6, 0, 2, 3]
```

To add two polynomials, add coefficients with the same exponent.

For exponent `0`:

```text
7 + 6 = 13
```

For exponent `1`:

```text
2 + 0 = 2
```

For exponent `2`:

```text
4 + 2 = 6
```

For exponent `3`:

```text
5 + 3 = 8
```

Result:

```text
[13, 2, 6, 8]
```

Polynomial:

```text
8x³ + 6x² + 2x + 13
```

---

# 12. Logic of Polynomial Addition

The logic is very simple:

```text
Result[i] = P[i] + Q[i]
```

where `i` represents the exponent.

This is one of the biggest advantages of array representation.

Because terms with the same exponent are automatically stored at the same index.

---

# 13. Polynomial Subtraction

Polynomial subtraction is almost similar to addition.

Suppose:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

and:

```text
Q(x) = 3x³ + 2x² + 6
```

Now:

```text
P(x) - Q(x)
```

For exponent `3`:

```text
5 - 3 = 2
```

For exponent `2`:

```text
4 - 2 = 2
```

For exponent `1`:

```text
2 - 0 = 2
```

For constant term:

```text
7 - 6 = 1
```

Result:

```text
2x³ + 2x² + 2x + 1
```

Array:

```text
[1, 2, 2, 2]
```

---

# 14. Polynomial Multiplication

Polynomial multiplication is slightly more complex.

Suppose:

```text
P(x) = 2x + 3
```

and:

```text
Q(x) = x + 4
```

Their arrays are:

```text
P = [3, 2]
Q = [4, 1]
```

Now multiply every term of the first polynomial with every term of the second polynomial.

```text
3 × 4 = 12
```

```text
3 × x = 3x
```

```text
2x × 4 = 8x
```

```text
2x × x = 2x²
```

Combine similar terms:

```text
2x² + 11x + 12
```

Array:

```text
[12, 11, 2]
```

---

# 15. Important Rule in Multiplication

When two terms are multiplied:

```text
x^i × x^j
```

their exponents are added.

So:

```text
x^(i+j)
```

Therefore:

```text
Result[i + j]
```

is used.

The coefficient calculation is:

```text
Result[i + j] = Result[i + j] + P[i] × Q[j]
```

This is an important formula for semester exams.

---

# 16. Polynomial Evaluation

Polynomial evaluation means finding the value of a polynomial for a particular value of `x`.

Example:

```text
P(x) = 2x² + 3x + 4
```

Find value at:

```text
x = 2
```

So:

```text
P(2) = 2(2²) + 3(2) + 4
```

```text
= 2(4) + 6 + 4
```

```text
= 8 + 6 + 4
```

```text
= 18
```

In array representation:

```text
[4, 3, 2]
```

We can calculate:

```text
4 × 2⁰
+
3 × 2¹
+
2 × 2²
```

---

# 17. General Evaluation Formula

For:

```text
P(x) = a0 + a1x + a2x² + ... + anxⁿ
```

The value can be calculated using:

```text
P(x) = a0x⁰ + a1x¹ + a2x² + ... + anxⁿ
```

In array form:

```text
P[i] × x^i
```

for every index `i`.

---

# 18. Horner's Method

Horner's Method is a more efficient way to evaluate a polynomial.

Suppose:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

Instead of calculating:

```text
x³
x²
x¹
```

separately, we can rewrite:

```text
((5x + 4)x + 2)x + 7
```

This reduces the number of multiplication operations.

Horner's Method is useful for efficient polynomial evaluation.

---

# 19. Polynomial Derivative

Derivative can also be calculated using array representation.

Suppose:

```text
P(x) = 5x³ + 4x² + 2x + 7
```

Derivative:

```text
15x² + 8x + 2
```

The rule is:

```text
d/dx(axⁿ) = n × a × xⁿ⁻¹
```

So:

```text
5x³ → 15x²
4x² → 8x
2x → 2
7 → 0
```

The original array:

```text
[7, 2, 4, 5]
```

Derivative array:

```text
[2, 8, 15]
```

---

# 20. Degree of Polynomial from Array

The degree is the highest index whose coefficient is non-zero.

Example:

```text
[5, 2, 0, 7, 0, 0]
```

The highest non-zero index is:

```text
3
```

Therefore degree:

```text
3
```

The polynomial is:

```text
7x³ + 2x + 5
```

---

# Advantages of Polynomial Representation Using Arrays

## 1. Simple to Understand

Array representation is easy for beginners.

The index is directly related to the exponent.

---

## 2. Direct Access

Any coefficient can be directly accessed using its exponent.

For example:

```text
Coefficient of x⁴ = array[4]
```

---

## 3. Easy Addition

Two polynomial coefficients with the same exponent are stored at the same index.

So addition becomes very simple.

---

## 4. Easy Subtraction

Subtraction also works using corresponding indexes.

---

## 5. Easy Evaluation

The array index gives the power of `x`, so evaluation is straightforward.

---

## 6. Suitable for Dense Polynomials

If most exponents are present, array representation uses memory efficiently.

---

# Disadvantages of Polynomial Representation Using Arrays

## 1. Memory Wastage

If the polynomial has very high degree but only a few terms, many array positions contain zero.

Example:

```text
5x¹⁰⁰ + 2
```

needs an array of length `101`.

Only two positions contain useful values.

---

## 2. Not Suitable for Sparse Polynomial

Sparse polynomials are better represented using structures that store only non-zero terms.

---

## 3. Fixed Size Problem

If a fixed-size array is used and later a higher-degree term is added, a new larger array may be required.

---

## 4. Resizing Cost

Creating a larger array and copying old elements can increase processing cost.

---

# 23. Array Representation vs Linked List Representation

| Feature           | Array Representation | Linked List Representation |
| ----------------- | -------------------- | -------------------------- |
| Structure         | Continuous memory    | Nodes                      |
| Access            | Direct               | Sequential                 |
| Implementation    | Simple               | More complex               |
| Dense polynomial  | Very suitable        | Less efficient             |
| Sparse polynomial | Can waste memory     | More suitable              |
| Insertion         | May require resizing | Easier                     |
| Random access     | Fast                 | Slow                       |

---

# Time Complexity

Let the degree of polynomial be `n`.

## Accessing Coefficient

Direct array access:

```text
O(1)
```

---

## Display

Every element may need to be checked.

```text
O(n)
```

---

## Addition

If two polynomials have degrees `n` and `m`:

```text
O(max(n, m))
```

---

## Subtraction

```text
O(max(n, m))
```

---

## Multiplication

Every term of one polynomial may be multiplied with every term of the other polynomial.

```text
O(n × m)
```

---

## Evaluation

Normally:

```text
O(n)
```

---

# Space Complexity

For a polynomial of degree `n`, the array needs approximately:

```text
n + 1
```

positions.

So space complexity is:

```text
O(n)
```

For addition:

```text
O(max(n, m))
```

For multiplication:

```text
O(n + m)
```

approximately for the result.

---

# 26. Practical Applications of Polynomial Representation

Polynomial representations are useful in many areas.

## Scientific Computing

Polynomial expressions are commonly used in engineering and scientific calculations.

---

## Computer Graphics

Polynomials are used in curves and transformations.

---

## Numerical Methods

Approximation techniques frequently use polynomial equations.

---

## Signal Processing

Polynomial operations are used in filtering and mathematical models.

---

## Algebra Systems

Computer algebra software uses polynomial representations for symbolic calculations.


---

# Combined  Program

```java
public class PolynomialArray {

    static void display(int[] p) {
        for (int i = p.length - 1; i >= 0; i--) {
            if (p[i] != 0) {
                System.out.print(p[i] + "x^" + i + " ");
            }
        }
        System.out.println();
    }

    static int[] add(int[] a, int[] b) {
        int size = Math.max(a.length, b.length);
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            int x = i < a.length ? a[i] : 0;
            int y = i < b.length ? b[i] : 0;
            result[i] = x + y;
        }

        return result;
    }

    static int[] multiply(int[] a, int[] b) {
        int[] result = new int[a.length + b.length - 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] p1 = {7, 2, 4, 5};
        int[] p2 = {6, 0, 2, 3};

        System.out.println("Polynomial 1:");
        display(p1);

        System.out.println("Polynomial 2:");
        display(p2);

        System.out.println("Addition:");
        display(add(p1, p2));

        System.out.println("Multiplication:");
        display(multiply(p1, p2));
    }
}
```

---
