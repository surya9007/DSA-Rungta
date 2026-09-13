# Sparse Matrix

## 1. Introduction

A **Sparse Matrix** is a matrix in which most of the elements are `0`.

In simple words:

> If the number of zero elements is much greater than the number of non-zero elements, the matrix is called a Sparse Matrix.

Example:

```text
0  0  0  8
0  0  0  0
0  5  0  0
0  0  0  0
```

In this matrix:

```text
Total elements = 4 × 4 = 16
Non-zero elements = 2
Zero elements = 14
```

Since most elements are zero, this is a **Sparse Matrix**.

---

# 2. Normal Matrix vs Sparse Matrix

Consider this matrix:

```text
1  2  3
4  5  6
7  8  9
```

Almost every position contains some value.

This is called a **Dense Matrix**.

Now consider:

```text
0  0  5
0  0  0
0  8  0
```

Most elements are `0`.

This is a **Sparse Matrix**.

So:

```text
Dense Matrix
    ↓
Large number of non-zero values

Sparse Matrix
    ↓
Large number of zero values
```

---

# 3. Why Do We Need Sparse Matrix?

Suppose we have a matrix of size:

```text
1000 × 1000
```

Total elements:

```text
1000 × 1000 = 1,000,000
```

Suppose only `100` elements contain actual values and all other elements are `0`.

If we store the complete matrix, we store:

```text
1,000,000 values
```

But useful data exists only in:

```text
100 positions
```

That means we are wasting a huge amount of memory storing zeros.

Instead of storing:

```text
0
0
0
0
0
10
0
0
0
...
```

we can store only:

```text
row
column
value
```

For example:

```text
Row   Column   Value
0       5       10
5       8       20
9       3       40
```

This saves memory.

---

# 4. Condition for Sparse Matrix

A matrix is generally considered sparse when:

```text
Number of zero elements > Number of non-zero elements
```

Example:

```text
0 0 3
0 0 0
0 4 0
```

Total elements:

```text
3 × 3 = 9
```

Non-zero elements:

```text
3
4
```

Count:

```text
2
```

Zero elements:

```text
9 - 2 = 7
```

Therefore:

```text
Zero = 7
Non-zero = 2

7 > 2
```

Hence it is a Sparse Matrix.

---

# 5. Java Program to Check Sparse Matrix

```java
public class SparseMatrixCheck {

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 3},
            {0, 0, 0},
            {0, 4, 0}
        };

        int rows = matrix.length;
        int columns = matrix[0].length;

        int zeroCount = 0;
        int nonZeroCount = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] == 0) {
                    zeroCount++;
                } else {
                    nonZeroCount++;
                }
            }
        }

        System.out.println("Zero elements: " + zeroCount);
        System.out.println("Non-zero elements: " + nonZeroCount);

        if (zeroCount > nonZeroCount) {
            System.out.println("Matrix is Sparse");
        } else {
            System.out.println("Matrix is not Sparse");
        }
    }
}
```

Output:

```text
Zero elements: 7
Non-zero elements: 2
Matrix is Sparse
```

---

# 6. Another Efficient Way to Check Sparse Matrix

Instead of maintaining two counters, calculate total elements.

```java
totalElements = rows * columns;
```

If zero elements are more than half of total elements:

```java
zeroCount > totalElements / 2
```

then the matrix is sparse.

Example:

```java
public class SparseMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 0, 10},
            {0, 0, 0, 0},
            {0, 20, 0, 0},
            {0, 0, 0, 0}
        };

        int rows = matrix.length;
        int columns = matrix[0].length;

        int zeroCount = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        int totalElements = rows * columns;

        if (zeroCount > totalElements / 2) {
            System.out.println("Sparse Matrix");
        } else {
            System.out.println("Not a Sparse Matrix");
        }
    }
}
```

---

# 7. Main Problem with Normal Matrix Storage

Consider:

```text
0  0  0  0
0  0  7  0
0  0  0  0
5  0  0  0
```

Using a normal 2D array:

```java
int[][] matrix = new int[4][4];
```

we store all `16` values.

But only two values are useful:

```text
7
5
```

Therefore, instead of storing all values, sparse matrix representation stores only the useful values.

---

# 8. Triplet Representation

One of the most common representations of a sparse matrix is called:

```text
Triplet Representation
```

Every non-zero value is represented using three things:

```text
Row
Column
Value
```

Suppose matrix is:

```text
0  0  3
0  0  0
5  0  8
```

The non-zero values are:

```text
3 → row 0, column 2
5 → row 2, column 0
8 → row 2, column 2
```

Triplet representation:

```text
Row   Column   Value

0       2       3
2       0       5
2       2       8
```

---

# 9. Special First Row in Triplet Representation

Sometimes the first row stores matrix information.

For example:

```text
3  3  3
0  2  3
2  0  5
2  2  8
```

The first row:

```text
3  3  3
```

means:

```text
3 rows
3 columns
3 non-zero values
```

Remaining rows contain actual data.

---

# 10. Converting Normal Matrix into Triplet Sparse Matrix

Input:

```text
0 0 3
0 0 0
5 0 8
```

First count non-zero elements:

```text
3
5
8
```

Number of non-zero elements:

```text
3
```

Therefore, sparse representation needs:

```text
nonZero + 1
```

rows.

So:

```text
3 + 1 = 4 rows
```

Each row contains:

```text
3 columns
```

for:

```text
row
column
value
```

---

# 11. Java Program to Convert Matrix into Sparse Triplet Form

```java
public class SparseMatrixRepresentation {

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 3},
            {0, 0, 0},
            {5, 0, 8}
        };

        int rows = matrix.length;
        int columns = matrix[0].length;

        int nonZero = 0;

        // Count non-zero elements
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] != 0) {
                    nonZero++;
                }
            }
        }

        // +1 because first row stores metadata
        int[][] sparse = new int[nonZero + 1][3];

        sparse[0][0] = rows;
        sparse[0][1] = columns;
        sparse[0][2] = nonZero;

        int k = 1;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] != 0) {

                    sparse[k][0] = i;
                    sparse[k][1] = j;
                    sparse[k][2] = matrix[i][j];

                    k++;
                }
            }
        }

        System.out.println("Sparse Matrix:");

        for (int i = 0; i < sparse.length; i++) {

            System.out.println(
                sparse[i][0] + " " +
                sparse[i][1] + " " +
                sparse[i][2]
            );
        }
    }
}
```

Output:

```text
3 3 3
0 2 3
2 0 5
2 2 8
```

---

# 12. Dry Run of the Program

Original matrix:

```text
0 0 3
0 0 0
5 0 8
```

Initially:

```java
nonZero = 0;
```

We scan each element.

First row:

```text
matrix[0][0] = 0
matrix[0][1] = 0
matrix[0][2] = 3
```

Since `3 != 0`:

```text
nonZero = 1
```

Second row:

```text
0 0 0
```

No change.

Third row:

```text
5 0 8
```

For `5`:

```text
nonZero = 2
```

For `8`:

```text
nonZero = 3
```

Finally:

```text
nonZero = 3
```

Create:

```java
int[][] sparse = new int[4][3];
```

First row:

```text
3 3 3
```

Then:

```text
0 2 3
2 0 5
2 2 8
```

Final:

```text
3 3 3
0 2 3
2 0 5
2 2 8
```

---

# 13. Convert Sparse Matrix Back to Normal Matrix

Suppose sparse matrix is:

```text
3 3 3
0 2 3
2 0 5
2 2 8
```

The first row tells us:

```text
rows = 3
columns = 3
non-zero elements = 3
```

Create:

```java
int[][] matrix = new int[3][3];
```

By default Java initializes all values to:

```text
0
```

Now insert the values.

For:

```text
0 2 3
```

write:

```java
matrix[0][2] = 3;
```

For:

```text
2 0 5
```

write:

```java
matrix[2][0] = 5;
```

For:

```text
2 2 8
```

write:

```java
matrix[2][2] = 8;
```

Final matrix:

```text
0 0 3
0 0 0
5 0 8
```

---

# 14. Java Program: Sparse Matrix to Normal Matrix

```java
public class SparseToNormal {

    public static void main(String[] args) {

        int[][] sparse = {
            {3, 3, 3},
            {0, 2, 3},
            {2, 0, 5},
            {2, 2, 8}
        };

        int rows = sparse[0][0];
        int columns = sparse[0][1];

        int[][] matrix = new int[rows][columns];

        for (int i = 1; i < sparse.length; i++) {

            int row = sparse[i][0];
            int column = sparse[i][1];
            int value = sparse[i][2];

            matrix[row][column] = value;
        }

        System.out.println("Normal Matrix:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

Output:

```text
0 0 3
0 0 0
5 0 8
```

---

# 15. Sparse Matrix Using Objects

Instead of using:

```java
int[][] sparse
```

we can create a class.

```java
class Element {

    int row;
    int column;
    int value;

    Element(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }
}
```

Each object represents one non-zero matrix element.

Example:

```java
new Element(0, 2, 3);
```

means:

```text
Row = 0
Column = 2
Value = 3
```

---

# 16. Sparse Matrix Using ArrayList

This is a useful Java implementation.

```java
import java.util.ArrayList;
import java.util.List;

class Element {

    int row;
    int column;
    int value;

    Element(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }
}

public class SparseMatrixList {

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 10, 0},
            {0, 20, 0, 0},
            {0, 0, 0, 30},
            {40, 0, 0, 0}
        };

        List<Element> sparse = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != 0) {

                    sparse.add(
                        new Element(i, j, matrix[i][j])
                    );
                }
            }
        }

        System.out.println("Row Column Value");

        for (Element element : sparse) {

            System.out.println(
                element.row + "     " +
                element.column + "      " +
                element.value
            );
        }
    }
}
```

Output:

```text
Row Column Value
0     2      10
1     1      20
2     3      30
3     0      40
```

---

# 17. Advantages of Sparse Matrix

## 17.1 Memory Saving

The biggest advantage is memory efficiency.

Instead of storing thousands or millions of zeros, only non-zero values are stored.

---

## 17.2 Faster Processing

Some operations become faster because algorithms can ignore zero elements.

Example:

Instead of processing:

```text
1,000,000 elements
```

we may only process:

```text
1000 non-zero elements
```

---

## 17.3 Useful for Large Data

Sparse matrices are especially useful when working with very large datasets.

---

## 17.4 Efficient Graph Representation

Sparse matrices are often useful for graphs where each node has only a few connections.

---

# 18. Disadvantages of Sparse Matrix

Sparse matrices also have some disadvantages.

## 18.1 Complex Implementation

A normal matrix is simple:

```java
matrix[i][j]
```

Sparse representations may require extra logic.

---

## 18.2 Access Can Be Slower

In a normal 2D array:

```java
matrix[5][10]
```

can directly access an element.

But in some sparse formats, we may need to search for the row-column combination.

---

## 18.3 Not Useful for Dense Matrices

If most values are non-zero, sparse representation may use more memory because we need to store:

```text
row
column
value
```

for every element.

---

# Types of Sparse Matrix Representations

Important sparse matrix representations include:

```text
1. Triplet / Coordinate List
2. CSR
3. CSC
4. Linked List
5. Dictionary / HashMap
```

---

# COO - Coordinate List Format

COO means:

```text
Coordinate List
```

It stores three arrays:

```text
Rows
Columns
Values
```

Example matrix:

```text
0 5 0
0 0 8
3 0 0
```

We store:

```text
Rows    = [0, 1, 2]
Columns = [1, 2, 0]
Values  = [5, 8, 3]
```

Together:

```text
(0, 1, 5)
(1, 2, 8)
(2, 0, 3)
```

This is similar to triplet representation.

---

# CSR - Compressed Sparse Row

CSR stands for:

```text
Compressed Sparse Row
```

It is one of the most commonly used sparse matrix formats.

CSR uses three arrays:

```text
values[]
columnIndex[]
rowPointer[]
```

Suppose:

```text
0 5 0 0
0 0 8 0
3 0 0 6
```

Non-zero values:

```text
5
8
3
6
```

Values array:

```text
values = [5, 8, 3, 6]
```

Column indexes:

```text
5 → column 1
8 → column 2
3 → column 0
6 → column 3
```

Therefore:

```text
columnIndex = [1, 2, 0, 3]
```

The `rowPointer` array tells where each row starts inside `values`.

```text
rowPointer = [0, 1, 2, 4]
```

Complete CSR:

```text
values      = [5, 8, 3, 6]

columnIndex = [1, 2, 0, 3]

rowPointer  = [0, 1, 2, 4]
```

CSR is useful when performing operations row by row.

---

# CSC - Compressed Sparse Column

CSC means:

```text
Compressed Sparse Column
```

It is similar to CSR, but data is organized by columns.

It usually contains:

```text
values[]
rowIndex[]
columnPointer[]
```

CSR:

```text
optimized for rows
```

CSC:

```text
optimized for columns
```

---

# Sparse Matrix Using Linked List

We can also store every non-zero element inside a linked-list node.

```java
class Node {

    int row;
    int column;
    int value;

    Node next;

    Node(int row, int column, int value) {

        this.row = row;
        this.column = column;
        this.value = value;
        this.next = null;
    }
}
```

Each node stores:

```text
row
column
value
next
```

Example:

```text
(0,2,5) → (2,0,8) → (3,3,10) → null
```

This means:

```text
matrix[0][2] = 5
matrix[2][0] = 8
matrix[3][3] = 10
```

---

# Complete Linked List Example

```java
class Node {

    int row;
    int column;
    int value;

    Node next;

    Node(int row, int column, int value) {

        this.row = row;
        this.column = column;
        this.value = value;
    }
}

public class SparseLinkedList {

    Node head;

    public void add(int row, int column, int value) {

        Node newNode = new Node(row, column, value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void display() {

        Node current = head;

        System.out.println("Row Column Value");

        while (current != null) {

            System.out.println(
                current.row + "     " +
                current.column + "      " +
                current.value
            );

            current = current.next;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 5},
            {0, 0, 0},
            {8, 0, 10}
        };

        SparseLinkedList sparse = new SparseLinkedList();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != 0) {

                    sparse.add(
                        i,
                        j,
                        matrix[i][j]
                    );
                }
            }
        }

        sparse.display();
    }
}
```

Output:

```text
Row Column Value
0     2      5
2     0      8
2     2      10
```

---

# 25. Sparse Matrix Addition

Suppose we have:

Matrix A:

```text
0 5 0
0 0 8
3 0 0
```

Matrix B:

```text
0 2 0
0 0 4
7 0 0
```

Addition:

```text
A + B
```

Result:

```text
0 7 0
0 0 12
10 0 0
```

Because:

```text
5 + 2 = 7
8 + 4 = 12
3 + 7 = 10
```

---

# Sparse Matrix Addition

```java
public class SparseAddition {

    public static void main(String[] args) {

        int[][] a = {
            {0, 5, 0},
            {0, 0, 8},
            {3, 0, 0}
        };

        int[][] b = {
            {0, 2, 0},
            {0, 0, 4},
            {7, 0, 0}
        };

        int rows = a.length;
        int columns = a[0].length;

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                result[i][j] = a[i][j] + b[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

Output:

```text
0 7 0
0 0 12
10 0 0
```

---

# Transpose of Sparse Matrix

Transpose means converting:

```text
Rows → Columns
Columns → Rows
```

Suppose matrix:

```text
0 5 0
0 0 8
3 0 0
```

Transpose:

```text
0 0 3
5 0 0
0 8 0
```

If sparse triplet contains:

```text
row column value
```

then transpose can be created by swapping:

```text
row ↔ column
```

---

# Sparse Matrix Transpose

```java
public class SparseTranspose {

    public static void main(String[] args) {

        int[][] sparse = {
            {3, 3, 3},
            {0, 1, 5},
            {1, 2, 8},
            {2, 0, 3}
        };

        System.out.println("Transpose:");

        System.out.println(
            sparse[0][1] + " " +
            sparse[0][0] + " " +
            sparse[0][2]
        );

        for (int i = 1; i < sparse.length; i++) {

            System.out.println(
                sparse[i][1] + " " +
                sparse[i][0] + " " +
                sparse[i][2]
            );
        }
    }
}
```

Output:

```text
3 3 3
1 0 5
2 1 8
0 2 3
```

---

# Time Complexity

Suppose matrix size is:

```text
m × n
```

To check every element:

```text
Time Complexity = O(m × n)
```

Because every matrix position must be visited.

For example:

```text
3 × 4
```

requires checking:

```text
12 elements
```

---

# Space Complexity

For normal matrix:

```text
O(m × n)
```

because every element is stored.

For triplet sparse representation:

If number of non-zero values is:

```text
k
```

we store approximately:

```text
k × 3
```

values.

Therefore:

```text
Space Complexity = O(k)
```

where:

```text
k = number of non-zero elements
```

If:

```text
k << m × n
```

then sparse storage saves a lot of memory.

---

---

# Applications of Sparse Matrix

Sparse matrices are very important in computer science.

## Graphs

Large social networks may contain millions of users, but each user connects with only a small number of users.

Adjacency matrices therefore contain many zeros.

---

## Machine Learning

Many machine-learning datasets contain large numbers of missing or zero-valued features.

Sparse representations reduce memory consumption.

---

## Search Engines

Search engines store relationships between:

```text
documents
words
keywords
```

A document contains only a small percentage of all possible words.

Therefore, document-term matrices are usually sparse.

---

## Recommendation Systems

Consider:

```text
Users × Movies
```

A user may rate only 20 movies out of 100,000 movies.

Most values are empty or zero.

Therefore the rating matrix is sparse.

---

## Scientific Computing

Sparse matrices are common in:

```text
Physics
Engineering
Simulation
Numerical analysis
```

because large systems of equations often generate matrices containing many zeros.

---

## Computer Graphics

Sparse matrices may be used for transformations and large mathematical models.

---


# 38. Example

```java
public class CompleteSparseMatrixExample {

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 5, 0},
            {0, 0, 0, 0},
            {8, 0, 0, 10},
            {0, 0, 0, 0}
        };

        int rows = matrix.length;
        int columns = matrix[0].length;

        int nonZeroCount = 0;

        // Step 1: Print original matrix

        System.out.println("Original Matrix:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        // Step 2: Count non-zero elements

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] != 0) {

                    nonZeroCount++;
                }
            }
        }

        int totalElements = rows * columns;

        int zeroCount = totalElements - nonZeroCount;

        // Step 3: Check sparse matrix

        System.out.println();

        System.out.println("Total Elements: " + totalElements);

        System.out.println("Zero Elements: " + zeroCount);

        System.out.println("Non-Zero Elements: " + nonZeroCount);

        if (zeroCount > nonZeroCount) {

            System.out.println("It is a Sparse Matrix");

        } else {

            System.out.println("It is not a Sparse Matrix");
        }

        // Step 4: Create sparse representation

        int[][] sparse = new int[nonZeroCount + 1][3];

        sparse[0][0] = rows;
        sparse[0][1] = columns;
        sparse[0][2] = nonZeroCount;

        int k = 1;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] != 0) {

                    sparse[k][0] = i;

                    sparse[k][1] = j;

                    sparse[k][2] = matrix[i][j];

                    k++;
                }
            }
        }

        // Step 5: Print sparse representation

        System.out.println();

        System.out.println("Sparse Representation:");

        System.out.println("Row Column Value");

        for (int i = 0; i < sparse.length; i++) {

            System.out.println(
                sparse[i][0] + "     " +
                sparse[i][1] + "      " +
                sparse[i][2]
            );
        }
    }
}
```

Expected output:

```text
Original Matrix:

0 0 5 0
0 0 0 0
8 0 0 10
0 0 0 0

Total Elements: 16
Zero Elements: 13
Non-Zero Elements: 3

It is a Sparse Matrix

Sparse Representation:

Row Column Value
4     4      3
0     2      5
2     0      8
2     3      10
```

---

