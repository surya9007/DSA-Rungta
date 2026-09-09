# Two-Dimensional Array (2D Array)


# 1. Introduction to 2D Array

A **two-dimensional array** is an array in which each element is itself arranged in rows and columns.

It is commonly used to represent:

* Matrices
* Tables
* Grids
* Game boards
* Seating arrangements
* Marks of students in multiple subjects
* Images/pixels
* Graph representations

Example:

```text
10  20  30
40  50  60
70  80  90
```

This matrix contains:

```text
Rows    = 3
Columns = 3
```

---

# 2. Definition of 2D Array

### Exam Definition

> A two-dimensional array is a collection of elements arranged in rows and columns, where each element is accessed using two indices: row index and column index.

Syntax:

```java
arr[row][column]
```

Example:

```java
arr[1][2]
```

means:

```text
row = 1
column = 2
```

---

# 3. Why Do We Need 2D Arrays?

Suppose we want to store marks of 3 students in 4 subjects.

A 2D array can represent this naturally:

```text
             Subject
          S1  S2  S3  S4

Student 1 10  20  30  40
Student 2 50  60  70  80
Student 3 90  25  35  45
```

Java:

```java
int[][] marks = new int[3][4];
```

Here:

```text
3 = rows
4 = columns
```

---

# 4. Representation of 2D Array

Consider:

```java
int[][] arr = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};
```

Representation:

```text
             Column
             0   1   2
           ┌───┬───┬───┐
Row 0      │10 │20 │30 │
           ├───┼───┼───┤
Row 1      │40 │50 │60 │
           ├───┼───┼───┤
Row 2      │70 │80 │90 │
           └───┴───┴───┘
```

Access:

```java
arr[0][0] = 10
arr[0][1] = 20
arr[1][0] = 40
arr[2][2] = 90
```

---

# 5. Row and Column Index

For a matrix:

```text
10 20 30
40 50 60
70 80 90
```

Rows:

```text
Row 0 → 10 20 30
Row 1 → 40 50 60
Row 2 → 70 80 90
```

Columns:

```text
Column 0 → 10 40 70
Column 1 → 20 50 80
Column 2 → 30 60 90
```

---

# 6. Declaration of 2D Array

Java syntax:

```java
int[][] arr;
```

Another valid syntax:

```java
int arr[][];
```

Preferred:

```java
int[][] arr;
```

At this stage, only the reference is declared.

---

# 7. Creation of 2D Array

```java
int[][] arr = new int[3][4];
```

This creates:

```text
3 rows
4 columns
```

Total elements:

```text
3 × 4 = 12
```

---

# 8. Default Values

For an integer 2D array:

```java
int[][] arr = new int[2][3];
```

Initially:

```text
0 0 0
0 0 0
```

For other types, Java initializes elements with their default values.

For example:

```text
int     → 0
double  → 0.0
boolean → false
char    → '\u0000'
reference types → null
```

---

# 9. Initialization of 2D Array

We can directly initialize a 2D array:

```java
int[][] arr = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};
```

---

# 10. Number of Rows

Use:

```java
arr.length
```

Example:

```java
int[][] arr = new int[3][4];

System.out.println(arr.length);
```

Output:

```text
3
```

Therefore:

```text
arr.length = number of rows
```

---

# 11. Number of Columns

For a rectangular matrix:

```java
arr[0].length
```

Example:

```java
int[][] arr = new int[3][4];

System.out.println(arr[0].length);
```

Output:

```text
4
```

Therefore:

```text
arr[0].length = number of columns in row 0
```

---

# 12. User Input in 2D Array

The most important practical program is taking matrix input from the user.

We use:

```java
Scanner
```

---

# 13. Basic User Input Program

```java
import java.util.Scanner;

public class MatrixInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter elements:");

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix:");

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

---

# 14. Understanding the Nested Loop

The outer loop controls rows:

```java
for(int i = 0; i < rows; i++)
```

The inner loop controls columns:

```java
for(int j = 0; j < cols; j++)
```

Therefore:

```text
Outer Loop → Row
Inner Loop → Column
```

This is one of the most important concepts in 2D arrays.

---

# 15. Example

Input:

```text
Enter rows: 3
Enter columns: 3

Enter elements:
10 20 30
40 50 60
70 80 90
```

Matrix:

```text
10 20 30
40 50 60
70 80 90
```

---

# 16. 2D Array Traversal

## Definition

Traversal means visiting every element of a 2D array.

For a matrix:

```text
10 20 30
40 50 60
70 80 90
```

Traversal:

```text
10 → 20 → 30
↓
40 → 50 → 60
↓
70 → 80 → 90
```

---

# 17. Row-Wise Traversal

The most common traversal is row-wise.

```java
for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        System.out.print(arr[i][j] + " ");
    }

    System.out.println();
}
```

Output:

```text
10 20 30
40 50 60
70 80 90
```

---

# 18. Column-Wise Traversal

For column-wise traversal:

```java
for(int j = 0; j < cols; j++) {

    for(int i = 0; i < rows; i++) {

        System.out.print(arr[i][j] + " ");
    }

    System.out.println();
}
```

For:

```text
10 20 30
40 50 60
70 80 90
```

Output:

```text
10 40 70
20 50 80
30 60 90
```

---

# 19. Row-Wise vs Column-Wise

| Row-wise             | Column-wise            |
| -------------------- | ---------------------- |
| Outer loop = rows    | Outer loop = columns   |
| Inner loop = columns | Inner loop = rows      |
| `arr[i][j]`          | `arr[i][j]`            |
| Prints complete row  | Prints complete column |

---

# 20. Accessing a Specific Element

Syntax:

```java
arr[i][j]
```

Example:

```java
System.out.println(arr[1][2]);
```

For:

```text
10 20 30
40 50 60
70 80 90
```

Output:

```text
60
```

because:

```text
arr[1][2] = 60
```

---

# 21. Updating an Element

We can directly update a specific element.

```java
arr[1][2] = 100;
```

Before:

```text
10 20 30
40 50 60
70 80 90
```

After:

```text
10 20 30
40 50 100
70 80 90
```

Complexity:

```text
O(1)
```

for direct indexed update.

---

# 22. Complete Update Program

```java
import java.util.Scanner;

public class MatrixUpdate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter row: ");
        int r = sc.nextInt();

        System.out.print("Enter column: ");
        int c = sc.nextInt();

        System.out.print("Enter new value: ");
        int value = sc.nextInt();

        if(r >= 0 && r < rows && c >= 0 && c < cols) {

            arr[r][c] = value;

        } else {

            System.out.println("Invalid index.");
        }

        System.out.println("Updated Matrix:");

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

---

# 23. Sum of All Elements

For:

```text
10 20 30
40 50 60
70 80 90
```

Sum:

```text
10 + 20 + 30 + 40 + 50 + 60 + 70 + 80 + 90
```

```text
= 450
```

---

# 24. Program: Sum of Matrix

```java
import java.util.Scanner;

public class MatrixSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        int sum = 0;

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();

                sum += arr[i][j];
            }
        }

        System.out.println("Sum = " + sum);
    }
}
```

Time Complexity:

```text
O(rows × cols)
```

For an `n × n` matrix:

```text
O(n²)
```

---

# 25. Row Sum

Suppose:

```text
10 20 30
40 50 60
70 80 90
```

Row sums:

```text
Row 0 = 10 + 20 + 30 = 60
Row 1 = 40 + 50 + 60 = 150
Row 2 = 70 + 80 + 90 = 240
```

---

# 26. Program: Row Sum

```java
import java.util.Scanner;

public class RowSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < rows; i++) {

            int sum = 0;

            for(int j = 0; j < cols; j++) {
                sum += arr[i][j];
            }

            System.out.println("Sum of row " + i + " = " + sum);
        }
    }
}
```

---

# 27. Column Sum

For:

```text
10 20 30
40 50 60
70 80 90
```

Column sums:

```text
Column 0 = 10 + 40 + 70 = 120

Column 1 = 20 + 50 + 80 = 150

Column 2 = 30 + 60 + 90 = 180
```

---

# 28. Program: Column Sum

```java
import java.util.Scanner;

public class ColumnSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int j = 0; j < cols; j++) {

            int sum = 0;

            for(int i = 0; i < rows; i++) {
                sum += arr[i][j];
            }

            System.out.println("Sum of column " + j + " = " + sum);
        }
    }
}
```

---

# 29. Maximum Element

```java
int max = arr[0][0];

for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        if(arr[i][j] > max) {
            max = arr[i][j];
        }
    }
}

System.out.println("Maximum = " + max);
```

Complexity:

```text
O(rows × cols)
```

---

# 30. Minimum Element

```java
int min = arr[0][0];

for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        if(arr[i][j] < min) {
            min = arr[i][j];
        }
    }
}

System.out.println("Minimum = " + min);
```

---

# 31. Search an Element in 2D Array

Suppose:

```text
10 20 30
40 50 60
70 80 90
```

Search:

```text
50
```

Result:

```text
Found at row 1, column 1
```

---

# 32. Linear Search in 2D Array

```java
import java.util.Scanner;

public class MatrixSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        boolean found = false;

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(arr[i][j] == target) {

                    System.out.println(
                        "Found at row " + i +
                        ", column " + j
                    );

                    found = true;
                    break;
                }
            }

            if(found)
                break;
        }

        if(!found) {
            System.out.println("Element not found.");
        }
    }
}
```

Complexity:

```text
O(rows × cols)
```

---

# 33. Matrix Addition

Two matrices can be added only when they have the **same dimensions**.

Example:

Matrix A:

```text
10 20
30 40
```

Matrix B:

```text
1  2
3  4
```

Addition:

```text
11 22
33 44
```

Formula:

```text
C[i][j] = A[i][j] + B[i][j]
```

---

# 34. Matrix Addition Program

```java
import java.util.Scanner;

public class MatrixAddition {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] C = new int[rows][cols];

        System.out.println("Enter Matrix A:");

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Matrix B:");

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                C[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("Result:");

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                System.out.print(C[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

---

# 35. Matrix Subtraction

Formula:

```text
C[i][j] = A[i][j] - B[i][j]
```

Example:

```text
A =        B =
10 20      1  2
30 40      3  4
```

Result:

```text
9  18
27 36
```

---

# 36. Matrix Multiplication

Matrix multiplication is different from addition.

For:

```text
A = m × n
B = n × p
```

Multiplication is possible.

Result:

```text
C = m × p
```

The important condition is:

```text
Columns of A = Rows of B
```

---

# 37. Matrix Multiplication Formula

```text
C[i][j] = Σ A[i][k] × B[k][j]
```

In programming:

```java
for(int i = 0; i < r1; i++) {

    for(int j = 0; j < c2; j++) {

        for(int k = 0; k < c1; k++) {

            C[i][j] += A[i][k] * B[k][j];
        }
    }
}
```

---

# 38. Matrix Multiplication Program

```java
import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows of A: ");
        int r1 = sc.nextInt();

        System.out.print("Enter columns of A: ");
        int c1 = sc.nextInt();

        System.out.print("Enter rows of B: ");
        int r2 = sc.nextInt();

        System.out.print("Enter columns of B: ");
        int c2 = sc.nextInt();

        if(c1 != r2) {

            System.out.println(
                "Matrix multiplication is not possible."
            );

            return;
        }

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];
        int[][] C = new int[r1][c2];

        System.out.println("Enter Matrix A:");

        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Matrix B:");

        for(int i = 0; i < r2; i++) {
            for(int j = 0; j < c2; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < r1; i++) {

            for(int j = 0; j < c2; j++) {

                for(int k = 0; k < c1; k++) {

                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Result:");

        for(int i = 0; i < r1; i++) {

            for(int j = 0; j < c2; j++) {

                System.out.print(C[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

For an `n × n` matrix, the usual straightforward multiplication takes:

```text
O(n³)
```

---

# 39. Transpose of Matrix

The transpose of a matrix is obtained by converting:

```text
Rows → Columns
Columns → Rows
```

Example:

Original:

```text
10 20 30
40 50 60
```

Transpose:

```text
10 40
20 50
30 60
```

---

# 40. Transpose Formula

```text
Transpose[j][i] = Matrix[i][j]
```

---

# 41. Transpose Program

```java
import java.util.Scanner;

public class MatrixTranspose {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Transpose:");

        for(int j = 0; j < cols; j++) {

            for(int i = 0; i < rows; i++) {

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

---

# 42. Main Diagonal

A diagonal element occurs when:

```text
row index = column index
```

Therefore:

```text
i == j
```

Example:

```text
10 20 30
40 50 60
70 80 90
```

Main diagonal:

```text
10
   50
      90
```

Elements:

```text
10 50 90
```

---

# 43. Main Diagonal Program

```java
for(int i = 0; i < n; i++) {

    System.out.print(arr[i][i] + " ");
}
```

For a square matrix:

```text
Time = O(n)
```

---

# 44. Secondary Diagonal

For an `n × n` matrix, secondary diagonal elements satisfy:

```text
i + j = n - 1
```

Example:

```text
10 20 30
40 50 60
70 80 90
```

Secondary diagonal:

```text
      30
   50
70
```

Elements:

```text
30 50 70
```

---

# 45. Secondary Diagonal Code

```java
for(int i = 0; i < n; i++) {

    System.out.print(arr[i][n - 1 - i] + " ");
}
```

---

# 46. Sum of Main Diagonal

```java
int sum = 0;

for(int i = 0; i < n; i++) {

    sum += arr[i][i];
}

System.out.println("Main diagonal sum = " + sum);
```

---

# 47. Sum of Secondary Diagonal

```java
int sum = 0;

for(int i = 0; i < n; i++) {

    sum += arr[i][n - 1 - i];
}

System.out.println("Secondary diagonal sum = " + sum);
```

---

# 48. Symmetric Matrix

A square matrix is called **symmetric** if:

```text
A = Aᵀ
```

In other words:

```text
arr[i][j] == arr[j][i]
```

Example:

```text
1 2 3
2 4 5
3 5 6
```

This matrix is symmetric.

---

# 49. Program to Check Symmetric Matrix

```java
import java.util.Scanner;

public class SymmetricMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                arr[i][j] = sc.nextInt();
            }
        }

        boolean symmetric = true;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(arr[i][j] != arr[j][i]) {

                    symmetric = false;
                    break;
                }
            }

            if(!symmetric)
                break;
        }

        if(symmetric)
            System.out.println("Symmetric Matrix");
        else
            System.out.println("Not a Symmetric Matrix");
    }
}
```

---

# 50. Identity Matrix

An identity matrix is a square matrix in which:

```text
Main diagonal = 1
Other elements = 0
```

Example:

```text
1 0 0
0 1 0
0 0 1
```

Condition:

```text
if(i == j)
    arr[i][j] should be 1

else
    arr[i][j] should be 0
```

---

# 51. Check Identity Matrix

```java
boolean identity = true;

for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

        if(i == j && arr[i][j] != 1) {
            identity = false;
        }

        if(i != j && arr[i][j] != 0) {
            identity = false;
        }
    }
}

if(identity)
    System.out.println("Identity Matrix");
else
    System.out.println("Not an Identity Matrix");
```

---

# 52. Diagonal Matrix

A square matrix is diagonal if all elements outside the main diagonal are zero.

Example:

```text
5 0 0
0 8 0
0 0 3
```

Condition:

```text
i != j → arr[i][j] must be 0
```

---

# 53. Upper Triangular Matrix

A square matrix is upper triangular if all elements below the main diagonal are zero.

Example:

```text
1 2 3
0 4 5
0 0 6
```

Below diagonal:

```text
i > j
```

Therefore:

```text
i > j → arr[i][j] = 0
```

---

# 54. Lower Triangular Matrix

A lower triangular matrix has all elements above the main diagonal equal to zero.

Example:

```text
1 0 0
2 3 0
4 5 6
```

Above diagonal:

```text
i < j
```

Therefore:

```text
i < j → arr[i][j] = 0
```

---

# 55. Boundary Elements

Boundary elements are the elements located on the outer boundary of a matrix.

Example:

```text
1  2  3  4
5  6  7  8
9 10 11 12
13 14 15 16
```

Boundary:

```text
1  2  3  4
5        8
9       12
13 14 15 16
```

Condition:

```text
i == 0
OR
i == rows - 1
OR
j == 0
OR
j == cols - 1
```

---

# 56. Boundary Elements Code

```java
for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        if(i == 0 || i == rows - 1 ||
           j == 0 || j == cols - 1) {

            System.out.print(arr[i][j] + " ");
        }
    }
}
```

---

# 57. Count Even and Odd Elements

```java
int even = 0;
int odd = 0;

for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        if(arr[i][j] % 2 == 0)
            even++;
        else
            odd++;
    }
}

System.out.println("Even = " + even);
System.out.println("Odd = " + odd);
```

---

# 58. Find Number of Positive and Negative Elements

```java
int positive = 0;
int negative = 0;
int zero = 0;

for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        if(arr[i][j] > 0)
            positive++;

        else if(arr[i][j] < 0)
            negative++;

        else
            zero++;
    }
}
```

---

# 59. Search Maximum in Each Row

```java
for(int i = 0; i < rows; i++) {

    int max = arr[i][0];

    for(int j = 1; j < cols; j++) {

        if(arr[i][j] > max) {
            max = arr[i][j];
        }
    }

    System.out.println(
        "Maximum of row " + i + " = " + max
    );
}
```

---

# 60. Search Minimum in Each Row

```java
for(int i = 0; i < rows; i++) {

    int min = arr[i][0];

    for(int j = 1; j < cols; j++) {

        if(arr[i][j] < min) {
            min = arr[i][j];
        }
    }

    System.out.println(
        "Minimum of row " + i + " = " + min
    );
}
```

---

# 61. Reverse Each Row

Original:

```text
1 2 3
4 5 6
7 8 9
```

After reversing every row:

```text
3 2 1
6 5 4
9 8 7
```

Code:

```java
for(int i = 0; i < rows; i++) {

    int left = 0;
    int right = cols - 1;

    while(left < right) {

        int temp = arr[i][left];

        arr[i][left] = arr[i][right];

        arr[i][right] = temp;

        left++;
        right--;
    }
}
```

---

# 62. Spiral Traversal

Spiral traversal means visiting matrix elements in spiral order.

Example:

```text
1  2  3
4  5  6
7  8  9
```

Spiral order:

```text
1 2 3 6 9 8 7 4 5
```

We maintain:

```text
top
bottom
left
right
```

---

# 63. Spiral Traversal Code

```java
int top = 0;
int bottom = rows - 1;
int left = 0;
int right = cols - 1;

while(top <= bottom && left <= right) {

    // Left to Right
    for(int j = left; j <= right; j++) {
        System.out.print(arr[top][j] + " ");
    }

    top++;

    // Top to Bottom
    for(int i = top; i <= bottom; i++) {
        System.out.print(arr[i][right] + " ");
    }

    right--;

    // Right to Left
    if(top <= bottom) {

        for(int j = right; j >= left; j--) {
            System.out.print(arr[bottom][j] + " ");
        }

        bottom--;
    }

    // Bottom to Top
    if(left <= right) {

        for(int i = bottom; i >= top; i--) {
            System.out.print(arr[i][left] + " ");
        }

        left++;
    }
}
```

---

# 64. Searching in a Sorted Matrix

Some matrices have additional ordering properties.

For example:

```text
1  4  7
2  5  8
3  6  9
```

If the matrix is sorted appropriately, more efficient search techniques can be used.

However, for basic semester-level 2D array questions, **linear traversal/search** is the fundamental technique.

---

# 65. Insertion in 2D Array

A Java 2D array has a fixed number of rows and columns once created.

Example:

```java
int[][] arr = new int[3][3];
```

Its dimensions are fixed:

```text
3 × 3
```

We cannot directly increase it to:

```text
4 × 3
```

or:

```text
3 × 4
```

---

# 66. Row Insertion Concept

Suppose:

```text
1 2
3 4
5 6
```

Insert a row:

```text
7 8
```

The resulting logical matrix:

```text
1 2
7 8
3 4
5 6
```

Since Java arrays have fixed dimensions, we generally create a **new array** with an additional row and copy the required elements.

---

# 67. Row Deletion Concept

Original:

```text
1 2
3 4
5 6
```

Delete row `1`:

```text
1 2
5 6
```

Again, because the Java array's dimensions are fixed, a new array is generally created.

---

# 68. Column Insertion and Deletion

The same concept applies to columns.

For:

```text
1 2 3
4 5 6
7 8 9
```

A column can be inserted by creating a new array with one extra column and copying elements.

A column can be deleted by creating a new array with one fewer column.

---

# 69. 2D Array vs Matrix

The terms are related but not always identical.

A **2D array** is a programming structure.

A **matrix** is a mathematical arrangement of values in rows and columns.

Example:

```text
2D Array:
int[][] arr = new int[3][3];

Matrix:
1 2 3
4 5 6
7 8 9
```

In programming courses, 2D arrays are frequently used to implement matrices.

---

---

# 2D Array Memory Concept

A 2D array logically represents:

```text
Rows × Columns
```

For:

```java
int[][] arr = new int[3][4];
```

there are:

```text
3 × 4 = 12
```

integer element positions.

Java's 2D arrays are technically arrays of arrays, so each row is a separate array object.

This also allows jagged arrays.

---

# Row-Major Concept

In a rectangular matrix, **row-major order** means processing elements row by row.

Example:

```text
1 2 3
4 5 6
7 8 9
```

Row-major sequence:

```text
1 2 3 4 5 6 7 8 9
```

The standard nested loop:

```java
for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        System.out.print(arr[i][j] + " ");
    }
}
```

follows row-major traversal.

---

# Column-Major Concept

Column-major order means processing column by column.

For:

```text
1 2 3
4 5 6
7 8 9
```

Column-major sequence:

```text
1 4 7 2 5 8 3 6 9
```

Code:

```java
for(int j = 0; j < cols; j++) {

    for(int i = 0; i < rows; i++) {

        System.out.print(arr[i][j] + " ");
    }
}
```

---

# Convert 2D Array into 1D Array

Suppose:

```text
1 2 3
4 5 6
7 8 9
```

Converted to 1D:

```text
1 2 3 4 5 6 7 8 9
```

Code:

```java
int[] oneD = new int[rows * cols];

int k = 0;

for(int i = 0; i < rows; i++) {

    for(int j = 0; j < cols; j++) {

        oneD[k] = arr[i][j];
        k++;
    }
}
```

---

# Sparse Matrix

A matrix containing a large number of zero elements is called a **sparse matrix**.

Example:

```text
0 0 5
0 0 0
7 0 0
```

There are many zeros and only a few non-zero values.

---

# Dense vs Sparse Matrix

### Dense Matrix

Contains a relatively large number of non-zero elements.

```text
1 2 3
4 5 6
7 8 9
```

### Sparse Matrix

Contains mostly zero values.

```text
0 0 5
0 0 0
7 0 0
```

---

# Check Sparse Matrix

One simple criterion is:

```text
Number of zero elements > Number of non-zero elements
```

Then the matrix can be considered sparse under that criterion.

---

# Sparse Matrix Program

```java
import java.util.Scanner;

public class SparseMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        int zero = 0;
        int nonZero = 0;

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 0)
                    zero++;
                else
                    nonZero++;
            }
        }

        if(zero > nonZero)
            System.out.println("Sparse Matrix");
        else
            System.out.println("Not a Sparse Matrix");
    }
}
```

---

# Common 2D Array Time Complexities

For a matrix with `rows × cols` elements:

| Operation             |      Complexity |
| --------------------- | --------------: |
| Access `arr[i][j]`    |            O(1) |
| Update `arr[i][j]`    |            O(1) |
| Full Traversal        |  O(rows × cols) |
| Search                |  O(rows × cols) |
| Sum                   |  O(rows × cols) |
| Maximum               |  O(rows × cols) |
| Minimum               |  O(rows × cols) |
| Transpose             |  O(rows × cols) |
| Matrix Addition       |  O(rows × cols) |
| Matrix Subtraction    |  O(rows × cols) |
| Matrix Multiplication | O(r₁ × c₁ × c₂) |

For square `n × n` matrices:

```text
Traversal → O(n²)
Addition → O(n²)
Transpose → O(n²)
Multiplication → O(n³)
```

---
