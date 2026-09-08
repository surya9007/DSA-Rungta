# 2D Array in Java

## 1. Introduction to 2D Array

A **2D Array (Two-Dimensional Array)** is an array in which data is stored in the form of **rows and columns**.

It can be visualized like a table or matrix.

For example:

```text
        Column
        0   1   2
      +---+---+---+
Row 0 | 1 | 2 | 3 |
      +---+---+---+
Row 1 | 4 | 5 | 6 |
      +---+---+---+
Row 2 | 7 | 8 | 9 |
      +---+---+---+
```

Here:

* Number of rows = `3`
* Number of columns = `3`
* Total elements = `3 × 3 = 9`

In Java, a 2D array is basically an **array of arrays**.

---

# 2. Syntax of 2D Array

```java
dataType[][] arrayName;
```

Example:

```java
int[][] arr;
```

We can also write:

```java
int arr[][];
```

or

```java
int[] arr[];
```

The most commonly used form is:

```java
int[][] arr;
```

---

# 3. Creating a 2D Array

Syntax:

```java
int[][] arr = new int[3][3];
```

This creates an array with:

* 3 rows
* 3 columns
* 9 integer elements

Initially, all integer values are `0`.

---

# 4. Initialization of 2D Array

We can directly initialize a 2D array.

```java
int[][] arr = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

Representation:

```text
1 2 3
4 5 6
7 8 9
```

---

# 5. Accessing Elements

Every element is accessed using:

```text
array[row][column]
```

Example:

```java
System.out.println(arr[0][0]);
```

Output:

```text
1
```

Another example:

```java
System.out.println(arr[1][2]);
```

Output:

```text
6
```

Because:

```text
arr[1][2]

row = 1
column = 2
```

---

# 6. Indexing in 2D Array

Consider:

```java
int[][] arr = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};
```

The indexes are:

```text
             Column
              0    1    2
           +----+----+----+
Row 0      | 10 | 20 | 30 |
           +----+----+----+
Row 1      | 40 | 50 | 60 |
           +----+----+----+
Row 2      | 70 | 80 | 90 |
           +----+----+----+
```

Therefore:

```java
arr[0][0] = 10
arr[0][1] = 20
arr[0][2] = 30

arr[1][0] = 40
arr[1][1] = 50
arr[1][2] = 60

arr[2][0] = 70
arr[2][1] = 80
arr[2][2] = 90
```

---

# 7. Taking User Input in 2D Array

For user input, we can use the `Scanner` class.

```java
import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter array elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("2D Array:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

### Input

```text
Enter number of rows: 3
Enter number of columns: 3

Enter array elements:
10 20 30
40 50 60
70 80 90
```

### Output

```text
2D Array:
10 20 30
40 50 60
70 80 90
```

---

# 8. Traversal of 2D Array

Traversal means **visiting every element of the array one by one**.

For a 2D array, we generally use **nested loops**.

```java
for (int i = 0; i < rows; i++) {

    for (int j = 0; j < cols; j++) {

        System.out.print(arr[i][j] + " ");

    }

    System.out.println();
}
```

Here:

* Outer loop → controls rows
* Inner loop → controls columns

---

# 9. Row-Wise Traversal

Row-wise traversal means we visit all elements of the first row, then second row, and so on.

Example:

```text
1 2 3
4 5 6
7 8 9
```

Traversal:

```text
1 → 2 → 3
4 → 5 → 6
7 → 8 → 9
```

Code:

```java
for (int i = 0; i < rows; i++) {

    for (int j = 0; j < cols; j++) {

        System.out.print(arr[i][j] + " ");

    }

    System.out.println();
}
```

Time Complexity:

```text
O(rows × cols)
```

---

# 10. Column-Wise Traversal

Column-wise traversal means we visit elements column by column.

For:

```text
1 2 3
4 5 6
7 8 9
```

Traversal:

```text
1 → 4 → 7
2 → 5 → 8
3 → 6 → 9
```

Code:

```java
for (int j = 0; j < cols; j++) {

    for (int i = 0; i < rows; i++) {

        System.out.print(arr[i][j] + " ");

    }

    System.out.println();
}
```

---

# 11. Updating an Element

Updating means changing an existing value.

Syntax:

```java
arr[row][column] = newValue;
```

Example:

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

### Code

```java
import java.util.Scanner;

public class Update2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        System.out.print("Enter row: ");
        int row = sc.nextInt();

        System.out.print("Enter column: ");
        int col = sc.nextInt();

        System.out.print("Enter new value: ");
        int value = sc.nextInt();

        arr[row][col] = value;

        System.out.println("Updated Array:");

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");

            }

            System.out.println();
        }
    }
}
```

### Time Complexity

```text
O(1)
```

Because we directly access the element using its index.

---

# 12. Searching in 2D Array

Searching means finding whether a particular element exists in the array.

Since a normal 2D array is not necessarily sorted, we generally use **Linear Search**.

Example:

```text
10 20 30
40 50 60
70 80 90
```

Search:

```text
50
```

We check every element until we find `50`.

---

## Java Code for Searching

```java
import java.util.Scanner;

public class Search2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == key) {

                    System.out.println(
                        "Element found at row " + i +
                        " and column " + j
                    );

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }
    }
}
```

### Time Complexity

```text
O(rows × cols)
```

### Space Complexity

```text
O(1)
```

---

# 13. Insertion in 2D Array

In a normal fixed-size 2D array, insertion is different from insertion in a 1D array.

A Java array has a fixed size.

For example:

```java
int[][] arr = new int[3][3];
```

We cannot increase it to:

```text
3 × 4
```

directly.

If we need a larger 2D array, we generally create a **new array** and copy the old elements.

---

# 14. Inserting a New Row

Suppose we have:

```text
1 2 3
4 5 6
7 8 9
```

We want to add:

```text
10 11 12
```

New array:

```text
1  2  3
4  5  6
7  8  9
10 11 12
```

### Java Code

```java
import java.util.Scanner;

public class InsertRow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] newArr = new int[rows + 1][cols];

        // Copy old array
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                newArr[i][j] = arr[i][j];

            }
        }

        // Take new row
        System.out.println("Enter new row elements:");

        for (int j = 0; j < cols; j++) {
            newArr[rows][j] = sc.nextInt();
        }

        System.out.println("After Insertion:");

        for (int i = 0; i < newArr.length; i++) {

            for (int j = 0; j < newArr[i].length; j++) {

                System.out.print(newArr[i][j] + " ");

            }

            System.out.println();
        }
    }
}
```

---

# 15. Inserting a New Column

Suppose:

```text
1 2
3 4
5 6
```

We want to insert a new column:

```text
10
20
30
```

Result:

```text
1  2  10
3  4  20
5  6  30
```

### Java Code

```java
import java.util.Scanner;

public class InsertColumn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] newArr = new int[rows][cols + 1];

        // Copy old elements
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                newArr[i][j] = arr[i][j];

            }
        }

        System.out.println("Enter new column elements:");

        for (int i = 0; i < rows; i++) {

            newArr[i][cols] = sc.nextInt();

        }

        System.out.println("After Insertion:");

        for (int i = 0; i < newArr.length; i++) {

            for (int j = 0; j < newArr[i].length; j++) {

                System.out.print(newArr[i][j] + " ");

            }

            System.out.println();
        }
    }
}
```

---

# 16. Deletion in 2D Array

Since a Java array has fixed size, deletion does not physically reduce the array size.

We generally create a new smaller array and copy the required elements.

For example:

```text
1 2 3
4 5 6
7 8 9
```

Delete row `1`.

Result:

```text
1 2 3
7 8 9
```

---

# 17. Delete a Row

### Java Code

```java
import java.util.Scanner;

public class DeleteRow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Enter row to delete: ");
        int deleteRow = sc.nextInt();

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] newArr = new int[rows - 1][cols];

        int newRow = 0;

        for (int i = 0; i < rows; i++) {

            if (i == deleteRow) {
                continue;
            }

            for (int j = 0; j < cols; j++) {

                newArr[newRow][j] = arr[i][j];

            }

            newRow++;
        }

        System.out.println("After Deletion:");

        for (int i = 0; i < newArr.length; i++) {

            for (int j = 0; j < newArr[i].length; j++) {

                System.out.print(newArr[i][j] + " ");

            }

            System.out.println();
        }
    }
}
```

---

# 18. Delete a Column

Example:

Before:

```text
1 2 3
4 5 6
7 8 9
```

Delete column `1`.

After:

```text
1 3
4 6
7 9
```

### Java Code

```java
import java.util.Scanner;

public class DeleteColumn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Enter column to delete: ");
        int deleteCol = sc.nextInt();

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] newArr = new int[rows][cols - 1];

        for (int i = 0; i < rows; i++) {

            int newCol = 0;

            for (int j = 0; j < cols; j++) {

                if (j == deleteCol) {
                    continue;
                }

                newArr[i][newCol] = arr[i][j];

                newCol++;
            }
        }

        System.out.println("After Deletion:");

        for (int i = 0; i < newArr.length; i++) {

            for (int j = 0; j < newArr[i].length; j++) {

                System.out.print(newArr[i][j] + " ");

            }

            System.out.println();
        }
    }
}
```

---

# 19. Sum of All Elements

We can calculate the sum of all elements using nested loops.

### Code

```java
import java.util.Scanner;

public class Sum2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();

            }
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                sum += arr[i][j];

            }
        }

        System.out.println("Sum = " + sum);
    }
}
```

---

# 20. Find Maximum Element

### Code

```java
import java.util.Scanner;

public class Max2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();

            }
        }

        int max = arr[0][0];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (arr[i][j] > max) {
                    max = arr[i][j];
                }

            }
        }

        System.out.println("Maximum = " + max);
    }
}
```

---

# 21. Find Minimum Element

```java
int min = arr[0][0];

for (int i = 0; i < rows; i++) {

    for (int j = 0; j < cols; j++) {

        if (arr[i][j] < min) {
            min = arr[i][j];
        }
    }
}

System.out.println("Minimum = " + min);
```

---

# 22. Row-Wise Sum

Example:

```text
1 2 3
4 5 6
7 8 9
```

Row sums:

```text
Row 0 = 1 + 2 + 3 = 6
Row 1 = 4 + 5 + 6 = 15
Row 2 = 7 + 8 + 9 = 24
```

### Code

```java
for (int i = 0; i < rows; i++) {

    int sum = 0;

    for (int j = 0; j < cols; j++) {

        sum += arr[i][j];

    }

    System.out.println("Sum of row " + i + " = " + sum);
}
```

---

# 23. Column-Wise Sum

### Code

```java
for (int j = 0; j < cols; j++) {

    int sum = 0;

    for (int i = 0; i < rows; i++) {

        sum += arr[i][j];

    }

    System.out.println("Sum of column " + j + " = " + sum);
}
```

---

# 24. Main Diagonal

A diagonal exists in a square matrix.

Example:

```text
1 2 3
4 5 6
7 8 9
```

Main diagonal:

```text
1
   5
      9
```

Condition:

```java
i == j
```

### Code

```java
for (int i = 0; i < rows; i++) {

    for (int j = 0; j < cols; j++) {

        if (i == j) {
            System.out.print(arr[i][j] + " ");
        }

    }
}
```

Output:

```text
1 5 9
```

---

# 25. Secondary Diagonal

For a square matrix:

```text
1 2 3
4 5 6
7 8 9
```

Secondary diagonal:

```text
      3
   5
7
```

Condition:

```text
i + j == n - 1
```

### Code

```java
int n = arr.length;

for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {

        if (i + j == n - 1) {

            System.out.print(arr[i][j] + " ");

        }
    }
}
```

Output:

```text
3 5 7
```

---

# 26. Complete 2D Array Program

The following program takes input from the user and performs basic operations:

* Create array
* Input
* Display
* Traversal
* Search
* Update
* Sum
* Maximum
* Minimum

```java
import java.util.Scanner;

public class TwoDArrayOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Create array
        int[][] arr = new int[rows][cols];

        // Input elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                arr[i][j] = sc.nextInt();

            }
        }

        // Display array
        System.out.println("\n2D Array:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(arr[i][j] + " ");

            }

            System.out.println();
        }

        // Sum
        int sum = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                sum += arr[i][j];

            }
        }

        System.out.println("\nSum = " + sum);

        // Maximum
        int max = arr[0][0];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (arr[i][j] > max) {
                    max = arr[i][j];
                }

            }
        }

        System.out.println("Maximum = " + max);

        // Minimum
        int min = arr[0][0];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (arr[i][j] < min) {
                    min = arr[i][j];
                }

            }
        }

        System.out.println("Minimum = " + min);

        // Searching
        System.out.print("\nEnter element to search: ");
        int key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (arr[i][j] == key) {

                    System.out.println(
                        "Element found at row " + i +
                        " and column " + j
                    );

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }

        // Update
        System.out.print("\nEnter row to update: ");
        int row = sc.nextInt();

        System.out.print("Enter column to update: ");
        int col = sc.nextInt();

        System.out.print("Enter new value: ");
        int value = sc.nextInt();

        if (row >= 0 && row < rows && col >= 0 && col < cols) {

            arr[row][col] = value;

            System.out.println("Array after update:");

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    System.out.print(arr[i][j] + " ");

                }

                System.out.println();
            }

        } else {

            System.out.println("Invalid index.");

        }

        sc.close();
    }
}
```

---

# 27. Jagged Array

A **jagged array** is a 2D array where every row can have a different number of columns.

Example:

```java
int[][] arr = new int[3][];

arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[3];
```

Representation:

```text
Row 0 → 10 20
Row 1 → 30 40 50 60
Row 2 → 70 80 90
```

Traversal:

```java
for (int i = 0; i < arr.length; i++) {

    for (int j = 0; j < arr[i].length; j++) {

        System.out.print(arr[i][j] + " ");

    }

    System.out.println();
}
```

Notice that we use:

```java
arr[i].length
```

instead of a common `cols` value.

---

# 28. 2D Array vs 1D Array

| Feature   | 1D Array  | 2D Array        |
| --------- | --------- | --------------- |
| Dimension | One       | Two             |
| Structure | Linear    | Rows + Columns  |
| Index     | `arr[i]`  | `arr[i][j]`     |
| Loop      | One loop  | Nested loops    |
| Example   | `[1,2,3]` | `[[1,2],[3,4]]` |
| Used for  | Lists     | Matrix/Table    |

---

# 29. Time Complexity of Common Operations

Let:

```text
Rows = R
Columns = C
```

| Operation        | Time Complexity |
| ---------------- | --------------: |
| Access           |            O(1) |
| Update           |            O(1) |
| Traversal        |        O(R × C) |
| Linear Search    |        O(R × C) |
| Sum              |        O(R × C) |
| Maximum          |        O(R × C) |
| Minimum          |        O(R × C) |
| Row Insertion    |        O(R × C) |
| Column Insertion |        O(R × C) |
| Row Deletion     |        O(R × C) |
| Column Deletion  |        O(R × C) |

---

# 30. Important Points

### Point 1

2D array uses two indexes:

```java
arr[row][column]
```

### Point 2

Java array indexing starts from `0`.

### Point 3

For traversal, use nested loops:

```java
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        // operation
    }
}
```

### Point 4

A normal Java array has a fixed size.

### Point 5

Searching an unsorted 2D array generally requires linear search.

### Point 6

For a square matrix:

```text
rows == columns
```

Example:

```text
3 × 3
4 × 4
5 × 5
```

### Point 7

Main diagonal condition:

```java
i == j
```

### Point 8

Secondary diagonal condition:

```java
i + j == n - 1
```

---
