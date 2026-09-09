# Arrays: 1D Array in Java

---

# 1. Introduction to Array

An **array** is a linear data structure used to store multiple elements of the **same data type** in a contiguous block of memory.

Instead of creating multiple variables:

```java
int a = 10;
int b = 20;
int c = 30;
int d = 40;
```

we can use an array:

```java
int[] arr = {10, 20, 30, 40};
```

An array stores multiple values under a single variable name.

---

# 2. Why Do We Need Arrays?

Suppose we want to store marks of 100 students.

Without an array:

```java
int marks1;
int marks2;
int marks3;
...
int marks100;
```

This is difficult to manage.

Using an array:

```java
int[] marks = new int[100];
```

Now all 100 values can be stored using one variable.

```text
marks[0]
marks[1]
marks[2]
...
marks[99]
```

---

# 3. Definition of Array

### Exam Definition

> An array is a collection of elements of the same data type stored in contiguous memory locations and accessed using an index.

Important points:

1. Same data type
2. Fixed size in Java
3. Index-based access
4. Contiguous logical storage
5. First index is `0`

---

# 4. Characteristics of Array

## 4.1 Homogeneous

An array stores elements of the same type.

Example:

```java
int[] arr = {10, 20, 30, 40};
```

All elements are integers.

---

## 4.2 Fixed Size

Once an array is created in Java, its length cannot be changed.

```java
int[] arr = new int[5];
```

The length is:

```text
5
```

We cannot directly increase it to 10.

If we need a larger array, we create a new array and copy the elements.

---

## 4.3 Index Based

Every element is accessed using an index.

For:

```java
int[] arr = {10, 20, 30, 40};
```

Indexes are:

```text
Index:    0   1   2   3
          ↓   ↓   ↓   ↓
Array:   10  20  30  40
```

---

## 4.4 Zero-Based Indexing

Java arrays start from index `0`.

For an array of size `n`:

```text
First index = 0
Last index  = n - 1
```

For size `5`:

```text
0  1  2  3  4
```

---

# One-Dimensional Array

A **one-dimensional array** stores elements in a single linear sequence.

Example:

```text
10 20 30 40 50
```

It can be represented as:

```text
Index:   0   1   2   3   4
         ↓   ↓   ↓   ↓   ↓
Value:  10  20  30  40  50
```

---

# Declaration of 1D Array

In Java:

```java
int[] arr;
```

or:

```java
int arr[];
```

Preferred syntax:

```java
int[] arr;
```

At this point, only the reference is declared.

Memory for elements has not yet been allocated.

---

# Array Creation

We use the `new` keyword.

```java
int[] arr = new int[5];
```

This creates an integer array of size `5`.

Indexes:

```text
0  1  2  3  4
```

Default values for an integer array are:

```text
0 0 0 0 0
```

---

# Declaration + Initialization

We can directly initialize an array:

```java
int[] arr = {10, 20, 30, 40, 50};
```

Java automatically determines the size.

Array size:

```java
arr.length
```

Output:

```text
5
```

---

# Taking User Input in 1D Array

For user input, we commonly use the `Scanner` class.

Import:

```java
import java.util.Scanner;
```

Create Scanner object:

```java
Scanner sc = new Scanner(System.in);
```

---

# Complete Program: User Input in Array

```java
import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array elements:");

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

### Sample Input

```text
Enter array size: 5
Enter 5 elements:
10 20 30 40 50
```

### Output

```text
Array elements:
10 20 30 40 50
```

---

# Array Traversal

## Definition

**Traversal** means visiting or accessing every element of an array exactly once.

Example:

```text
10 20 30 40 50
```

Traversal means:

```text
10 → 20 → 30 → 40 → 50
```

---

# Traversal Using for Loop

```java
for(int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```

### Complete Program

```java
import java.util.Scanner;

public class ArrayTraversal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array:");

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

### Complexity

```text
Time Complexity  = O(n)
Space Complexity = O(n)
```

The `O(n)` space above refers to the array used to store the input. The traversal itself uses `O(1)` extra space.

---

# Traversal Using Enhanced for Loop

Java also provides the enhanced `for` loop.

```java
for(int x : arr) {
    System.out.print(x + " ");
}
```

Example:

```java
int[] arr = {10, 20, 30, 40};

for(int x : arr) {
    System.out.print(x + " ");
}
```

Output:

```text
10 20 30 40
```

---

# Accessing Individual Elements

```java
System.out.println(arr[0]);
System.out.println(arr[1]);
System.out.println(arr[2]);
```

Example:

```text
Array = 10 20 30 40 50

arr[0] = 10
arr[1] = 20
arr[2] = 30
```

Accessing an element by index takes:

```text
O(1)
```

---

# Updating an Array Element

## Definition

Updating means changing the value of an existing element.

Suppose:

```text
10 20 30 40 50
```

We want to change `30` to `100`.

```java
arr[2] = 100;
```

Array becomes:

```text
10 20 100 40 50
```

---

# 16. Complete Program: Update an Element

```java
import java.util.Scanner;

public class ArrayUpdate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter index to update: ");
        int index = sc.nextInt();

        System.out.print("Enter new value: ");
        int value = sc.nextInt();

        if(index >= 0 && index < n) {

            arr[index] = value;

            System.out.println("Updated array:");

            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

        } else {
            System.out.println("Invalid index");
        }
    }
}
```

### Complexity

```text
Time Complexity = O(1)
```

for the actual update operation.

---

# Insertion in 1D Array

## Definition

Insertion means adding a new element at a particular position in an array.

Example:

Original:

```text
10 20 30 40
```

Insert `25` at index `2`.

New array:

```text
10 20 25 30 40
```

---

# Why Is Shifting Required?

Arrays store elements in sequential positions.

Suppose:

```text
Index:   0   1   2   3
Value:  10  20  30  40
```

We want to insert `25` at index `2`.

Before:

```text
10 20 30 40
```

We first shift elements toward the right:

```text
10 20 30 40
         ↑  ↑
```

`40` moves to the next position.

Then `30` moves to the next position.

Finally:

```text
10 20 25 30 40
```

---

# Insertion Algorithm

To insert an element at index `pos`:

1. Check whether there is free space.
2. Start from the last occupied element.
3. Shift elements one position to the right.
4. Continue until `pos`.
5. Insert the new element at `pos`.
6. Increase the logical size.

---

# Important Insertion Logic

```java
for(int i = n; i > pos; i--) {
    arr[i] = arr[i - 1];
}

arr[pos] = value;
n++;
```

Notice:

```text
i = n
```

and not:

```text
i = 0
```

because we need to shift from **right to left**.

---

# Complete Insertion Program

Because Java arrays have fixed length, we create an array with extra capacity.

```java
import java.util.Scanner;

public class ArrayInsertion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();

        int[] arr = new int[capacity];

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter position/index for insertion: ");
        int pos = sc.nextInt();

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        if(n == capacity) {
            System.out.println("Array is full. Insertion not possible.");
        }
        else if(pos < 0 || pos > n) {
            System.out.println("Invalid position.");
        }
        else {

            for(int i = n; i > pos; i--) {
                arr[i] = arr[i - 1];
            }

            arr[pos] = value;
            n++;

            System.out.println("Array after insertion:");

            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
```

---

# Example of Insertion

Suppose:

```text
n = 4

10 20 30 40
```

Insert:

```text
value = 25
position = 2
```

### Step 1

Shift `40`:

```text
10 20 30 40 40
```

### Step 2

Shift `30`:

```text
10 20 30 30 40
```

### Step 3

Insert `25`:

```text
10 20 25 30 40
```

Final array:

```text
10 20 25 30 40
```

---

# Insertion at Beginning

To insert at index `0`:

```java
for(int i = n; i > 0; i--) {
    arr[i] = arr[i - 1];
}

arr[0] = value;
n++;
```

Example:

```text
Original:
20 30 40

Insert:
10
```

Result:

```text
10 20 30 40
```

---

# Insertion at End

Insertion at the end does not require shifting.

```java
arr[n] = value;
n++;
```

Example:

```text
10 20 30
```

Insert `40`.

Result:

```text
10 20 30 40
```

Complexity:

```text
O(1)
```

assuming there is free capacity.

---

# Deletion from 1D Array

## Definition

Deletion means removing an element from an array.

Example:

Original:

```text
10 20 30 40 50
```

Delete element at index `2`.

Result:

```text
10 20 40 50
```

---

# Why Is Shifting Required in Deletion?

After deleting an element, a gap is created.

Original:

```text
10 20 30 40 50
```

Delete:

```text
30
```

Temporary:

```text
10 20 _ 40 50
```

To remove the gap, elements after the deleted element are shifted left:

```text
10 20 40 50
```

---

# Deletion Algorithm

To delete an element at position `pos`:

1. Check whether the position is valid.
2. Start from `pos`.
3. Shift every next element one position left.
4. Decrease the logical size.
5. Display the array.

---

# 28. Important Deletion Logic

```java
for(int i = pos; i < n - 1; i++) {
    arr[i] = arr[i + 1];
}

n--;
```

Notice:

```text
i < n - 1
```

because `arr[i + 1]` must remain a valid index.

---

# Complete Deletion Program

```java
import java.util.Scanner;

public class ArrayDeletion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter index to delete: ");
        int pos = sc.nextInt();

        if(pos < 0 || pos >= n) {

            System.out.println("Invalid index.");

        } else {

            for(int i = pos; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }

            n--;

            System.out.println("Array after deletion:");

            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
```

---

# Example of Deletion

Original:

```text
10 20 30 40 50
```

Delete index:

```text
2
```

Element:

```text
30
```

Shift:

```text
40 → index 2
50 → index 3
```

Final:

```text
10 20 40 50
```

---

# Deletion from Beginning

To delete the first element:

```java
for(int i = 0; i < n - 1; i++) {
    arr[i] = arr[i + 1];
}

n--;
```

Example:

```text
10 20 30 40
```

After deletion:

```text
20 30 40
```

Complexity:

```text
O(n)
```

---

# Deletion from End

To delete the last element:

```java
n--;
```

No shifting is required.

Example:

```text
10 20 30 40
```

After deletion:

```text
10 20 30
```

Complexity:

```text
O(1)
```

---

# Searching in Array

Searching means finding whether a particular element exists in the array.

Example:

```text
10 20 30 40 50
```

Search:

```text
30
```

Result:

```text
Element found at index 2
```

---

# Linear Search

Linear Search checks elements one by one.

### Algorithm

```text
Start from index 0
       ↓
Compare element with target
       ↓
If equal → Found
       ↓
Otherwise move to next element
       ↓
Repeat
```

---

# Linear Search Code

```java
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        int index = -1;

        for(int i = 0; i < n; i++) {

            if(arr[i] == target) {
                index = i;
                break;
            }
        }

        if(index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found");
        }
    }
}
```

### Complexity

Best Case:

```text
O(1)
```

Worst Case:

```text
O(n)
```

---

# Find Maximum Element

```java
import java.util.Scanner;

public class ArrayMaximum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];

        for(int i = 1; i < n; i++) {

            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum = " + max);
    }
}
```

Complexity:

```text
Time = O(n)
Extra Space = O(1)
```

---

# Find Minimum Element

```java
import java.util.Scanner;

public class ArrayMinimum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = arr[0];

        for(int i = 1; i < n; i++) {

            if(arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Minimum = " + min);
    }
}
```

---

# Sum of Array Elements

```java
import java.util.Scanner;

public class ArraySum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        int sum = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        System.out.println("Sum = " + sum);
    }
}
```

Complexity:

```text
Time = O(n)
Extra Space = O(1)
```

---

# Average of Array Elements

Formula:

```text
Average = Sum / Number of Elements
```

Java:

```java
double average = (double) sum / n;
```


```java
import java.util.Scanner;

public class ArrayAverage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int sum = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        double average = (double) sum / n;

        System.out.println("Average = " + average);
    }
}
```

---

# Count Even and Odd Elements

```java
import java.util.Scanner;

public class EvenOddCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int even = 0;
        int odd = 0;

        for(int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

            if(arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even = " + even);
        System.out.println("Odd = " + odd);
    }
}
```

---

# Reverse an Array

Original:

```text
10 20 30 40 50
```

Reverse:

```text
50 40 30 20 10
```

---

# Reverse Using Two Pointers

We use:

```text
left
right
```

Initially:

```text
left = 0
right = n - 1
```

Swap:

```text
arr[left]
arr[right]
```

Then:

```text
left++
right--
```

Continue until:

```text
left < right
```

---

# 43. Reverse Array

```java
import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;

        while(left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println("Reversed array:");

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Complexity:

```text
Time = O(n)
Extra Space = O(1)
```

---

# 44. Sorting an Array

Sorting means arranging elements in a particular order.

### Ascending Order

```text
10 20 30 40 50
```

### Descending Order

```text
50 40 30 20 10
```

---

# 45. Bubble Sort

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

Example:

```text
5 3 4 1
```

After comparisons, larger elements gradually move toward the end.

---



# Copy an Array

We can copy elements using a loop.

```java
int[] copy = new int[arr.length];

for(int i = 0; i < arr.length; i++) {
    copy[i] = arr[i];
}
```

Complexity:

```text
Time = O(n)
Space = O(n)
```

---

# Find Second Largest Element

One common semester/exam problem is finding the second largest element.

Example:

```text
10 50 30 40 20
```

Output:

```text
Second Largest = 40
```

One simple approach is to track the largest and second largest values.

```java
import java.util.Scanner;

public class SecondLargest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {

            if(arr[i] > largest) {

                second = largest;
                largest = arr[i];

            } else if(arr[i] > second && arr[i] != largest) {

                second = arr[i];
            }
        }

        if(second == Integer.MIN_VALUE) {
            System.out.println("Second largest distinct element does not exist.");
        } else {
            System.out.println("Second Largest = " + second);
        }
    }
}
```

---

# Frequency of an Element

Suppose:

```text
Array:
10 20 10 30 10
```

Frequency of `10`:

```text
3
```

Code:

```java
int count = 0;

for(int i = 0; i < n; i++) {

    if(arr[i] == target) {
        count++;
    }
}

System.out.println("Frequency = " + count);
```

Time:

```text
O(n)
```

---

# Check if Array is Sorted

An array is sorted in ascending order if:

```text
arr[i] <= arr[i + 1]
```

for every valid `i`.

### Code

```java
boolean sorted = true;

for(int i = 0; i < n - 1; i++) {

    if(arr[i] > arr[i + 1]) {
        sorted = false;
        break;
    }
}

if(sorted)
    System.out.println("Array is sorted");
else
    System.out.println("Array is not sorted");
```

Complexity:

```text
O(n)
```

---

# Array Operations

| Operation              | Description             |  Time Complexity |
| ---------------------- | ----------------------- | ---------------: |
| Access                 | Access using index      |             O(1) |
| Update                 | Change existing element |             O(1) |
| Traversal              | Visit all elements      |             O(n) |
| Linear Search          | Search element          |             O(n) |
| Insertion at beginning | Shift elements right    |             O(n) |
| Insertion at middle    | Shift elements right    |             O(n) |
| Insertion at end       | Direct placement        |            O(1)* |
| Deletion at beginning  | Shift elements left     |             O(n) |
| Deletion at middle     | Shift elements left     |             O(n) |
| Deletion at end        | Reduce logical size     |             O(1) |
| Reverse                | Swap elements           |             O(n) |
| Find Maximum           | Traverse array          |             O(n) |
| Find Minimum           | Traverse array          |             O(n) |
| Bubble Sort            | Repeated comparisons    | O(n²) worst case |

`*` Assuming sufficient capacity is already available.

---

# Insertion vs Deletion

| Feature        | Insertion              | Deletion               |
| -------------- | ---------------------- | ---------------------- |
| Purpose        | Add element            | Remove element         |
| Main operation | Shift right            | Shift left             |
| Beginning      | O(n)                   | O(n)                   |
| Middle         | O(n)                   | O(n)                   |
| End            | O(1)*                  | O(1)                   |
| Array size     | Logical size increases | Logical size decreases |

---

# Difference: Array Size vs Logical Size

This is very important for insertion and deletion.

Suppose:

```java
int[] arr = new int[10];
```

The physical array capacity is:

```text
10
```

But suppose only 5 elements are currently stored:

```text
10 20 30 40 50
```

Then:

```text
capacity = 10
logical size = 5
```

We can insert another element without creating a new array.

---

# Why Java Array Does Not Support Direct Insertion?

Java arrays have a fixed length.

If we create:

```java
int[] arr = new int[5];
```

its length always remains:

```text
5
```

We cannot do:

```java
arr.length = 6;
```

Therefore, insertion and deletion are implemented by **shifting elements** and maintaining a logical size.

---

# Array Index Out of Bounds

If an array has size `5`:

```text
Valid indexes:
0 1 2 3 4
```

Trying:

```java
arr[5]
```

causes:

```text
ArrayIndexOutOfBoundsException
```

Therefore, always ensure:

```java
0 <= index < arr.length
```

---

# 56. Complete Menu-Driven Array Program

This is an excellent **semester practical/exam program** because it combines several operations.

```java
import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array capacity: ");
        int capacity = sc.nextInt();

        int[] arr = new int[capacity];

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {

            System.out.println("\n----- ARRAY MENU -----");
            System.out.println("1. Traversal");
            System.out.println("2. Insertion");
            System.out.println("3. Deletion");
            System.out.println("4. Update");
            System.out.println("5. Search");
            System.out.println("6. Maximum");
            System.out.println("7. Minimum");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("Array elements:");

                    for(int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }

                    System.out.println();
                    break;


                case 2:

                    if(n == capacity) {

                        System.out.println("Array is full.");

                    } else {

                        System.out.print("Enter index: ");
                        int pos = sc.nextInt();

                        System.out.print("Enter value: ");
                        int value = sc.nextInt();

                        if(pos < 0 || pos > n) {

                            System.out.println("Invalid index.");

                        } else {

                            for(int i = n; i > pos; i--) {
                                arr[i] = arr[i - 1];
                            }

                            arr[pos] = value;
                            n++;

                            System.out.println("Element inserted.");
                        }
                    }

                    break;


                case 3:

                    if(n == 0) {

                        System.out.println("Array is empty.");

                    } else {

                        System.out.print("Enter index to delete: ");
                        int pos = sc.nextInt();

                        if(pos < 0 || pos >= n) {

                            System.out.println("Invalid index.");

                        } else {

                            for(int i = pos; i < n - 1; i++) {
                                arr[i] = arr[i + 1];
                            }

                            n--;

                            System.out.println("Element deleted.");
                        }
                    }

                    break;


                case 4:

                    System.out.print("Enter index: ");
                    int index = sc.nextInt();

                    if(index < 0 || index >= n) {

                        System.out.println("Invalid index.");

                    } else {

                        System.out.print("Enter new value: ");
                        int value = sc.nextInt();

                        arr[index] = value;

                        System.out.println("Element updated.");
                    }

                    break;


                case 5:

                    System.out.print("Enter value to search: ");
                    int target = sc.nextInt();

                    int found = -1;

                    for(int i = 0; i < n; i++) {

                        if(arr[i] == target) {
                            found = i;
                            break;
                        }
                    }

                    if(found == -1)
                        System.out.println("Element not found.");
                    else
                        System.out.println("Element found at index " + found);

                    break;


                case 6:

                    if(n == 0) {

                        System.out.println("Array is empty.");

                    } else {

                        int max = arr[0];

                        for(int i = 1; i < n; i++) {

                            if(arr[i] > max) {
                                max = arr[i];
                            }
                        }

                        System.out.println("Maximum = " + max);
                    }

                    break;


                case 7:

                    if(n == 0) {

                        System.out.println("Array is empty.");

                    } else {

                        int min = arr[0];

                        for(int i = 1; i < n; i++) {

                            if(arr[i] < min) {
                                min = arr[i];
                            }
                        }

                        System.out.println("Minimum = " + min);
                    }

                    break;


                case 8:

                    System.out.println("Program terminated.");
                    break;


                default:

                    System.out.println("Invalid choice.");
            }

        } while(choice != 8);
    }
}
```

---


## Traversal

> Visiting each element of an array one by one.

```text
Time = O(n)
```

---

## Insertion

> Adding a new element at a specified position.

Usually requires shifting elements toward the right.

```text
Beginning/Middle = O(n)
End = O(1)*
```

---

## Deletion

> Removing an element from a specified position.

Usually requires shifting elements toward the left.

```text
Beginning/Middle = O(n)
End = O(1)
```

---

## Searching

> Finding the location of a particular element.

Linear Search:

```text
O(n)
```

---

## Updating

> Changing the value of an existing element.

```text
arr[index] = value;
```

Complexity:

```text
O(1)
```

---

# 58. Array Advantages

### 1. Fast Access

Elements can be accessed directly using indexes.

```java
arr[5]
```

Complexity:

```text
O(1)
```

---

### 2. Simple to Use

Arrays are easy to understand and implement.

---

### 3. Memory Efficiency

Arrays have relatively low overhead compared with many dynamic data structures.

---

### 4. Cache-Friendly

Elements are stored sequentially, which can provide good memory locality.

---

# 59. Array Disadvantages

### 1. Fixed Size

Once created, a Java array cannot change length.

---

### 2. Insertion Can Be Expensive

Insertion at the beginning or middle requires shifting.

```text
O(n)
```

---

### 3. Deletion Can Be Expensive

Deletion from the beginning or middle also requires shifting.

```text
O(n)
```

---

### 4. Homogeneous Data

A primitive `int[]` stores integers only.

---

# 60. Array vs Linked List

| Array                              | Linked List                              |
| ---------------------------------- | ---------------------------------------- |
| Contiguous logical storage         | Nodes linked using references            |
| Fast random access                 | Sequential access                        |
| Index-based                        | Node/reference based                     |
| Access O(1)                        | Access O(n)                              |
| Middle insertion requires shifting | Can be efficient after locating position |
| Fixed length in Java arrays        | Dynamic size                             |
| Better cache locality              | Usually less cache-friendly              |

---
