# 1D Array Operations in Java

## Introduction to 1D Array

An **array** is a linear data structure used to store a collection of elements of the **same data type** in contiguous memory locations.

A **1D (one-dimensional) array** stores elements in a single sequence.

Example:

```text
10  20  30  40  50
```

Each element can be accessed using an **index**.

In Java, array indexing starts from:

```text
0
```

Therefore:

```text
Index:   0   1   2   3   4
         ↓   ↓   ↓   ↓   ↓
Array:  10  20  30  40  50
```

For an array of size `n`, valid indexes are:

```text
0 to n - 1
```

---

# 1. Declaration of 1D Array

In Java, an array can be declared as:

```java
int[] arr;
```

or:

```java
int arr[];
```

The preferred Java style is:

```java
int[] arr;
```

---

# 2. Array Creation

An array can be created using the `new` keyword.

```java
int[] arr = new int[5];
```

This creates an integer array capable of storing 5 elements.

Initially, Java initializes integer array elements to:

```text
0
```

Example:

```text
Index:  0  1  2  3  4
        ↓  ↓  ↓  ↓  ↓
Array:  0  0  0  0  0
```

---

# 3. Array Initialization

We can initialize an array directly:

```java
int[] arr = {10, 20, 30, 40, 50};
```

The array contains:

```text
Index:  0   1   2   3   4
        ↓   ↓   ↓   ↓   ↓
       10  20  30  40  50
```

---

# 4. Accessing Array Elements

We can access an element using its index.

```java
int[] arr = {10, 20, 30, 40, 50};

System.out.println(arr[0]);
System.out.println(arr[3]);
```

Output:

```text
10
40
```

---

# 5. Updating an Array Element

To update an element, assign a new value to its index.

```java
arr[2] = 100;
```

Before:

```text
10 20 30 40 50
      ↑
```

After:

```text
10 20 100 40 50
```

The size of the array does not change.

---

# 6. Important 1D Array Operations

The most important operations performed on a 1D array are:

```text
1. Traversal
2. Insertion
3. Deletion
4. Updation
5. Searching
6. Sorting
```

We can represent them as:

```text
                    1D ARRAY
                       |
       -----------------------------------
       |       |       |       |         |
    Insert  Delete  Update  Search     Sort
```

---

# 7. Traversal

Traversal means visiting every element of an array one by one.

Example:

```text
10 20 30 40 50
```

Traversal:

```text
10
20
30
40
50
```

### Java Code

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

### Time Complexity

```text
O(n)
```

because every element is visited once.

---

# 8. Insertion in 1D Array

## What is Insertion?

**Insertion** means adding a new element at a particular position in an array.

Suppose we have:

```text
10 20 30 40
```

We want to insert:

```text
25
```

at index:

```text
2
```

Before insertion:

```text
Index:  0   1   2   3
        ↓   ↓   ↓   ↓
       10  20  30  40
```

After insertion:

```text
Index:  0   1   2   3   4
        ↓   ↓   ↓   ↓   ↓
       10  20  25  30  40
```

---

# 9. Why Shifting is Required During Insertion?

Arrays store elements in consecutive positions.

If we want to insert an element in the middle, existing elements must be shifted to the right to create an empty position.

Example:

```text
Before:

10 20 30 40
      ↑
   Position 2
```

To insert `25`:

```text
40 → right
30 → right
```

Then:

```text
10 20 25 30 40
```

The shifting is done from **right to left**.

---

# 10. Algorithm for Insertion

To insert an element at a particular index:

```text
Step 1: Start
Step 2: Check whether there is available space
Step 3: Check whether the position is valid
Step 4: Start from the last occupied position
Step 5: Shift elements one position to the right
Step 6: Continue until the insertion position is reached
Step 7: Insert the new element
Step 8: Increase the current size
Step 9: Stop
```

---

# 11. Java Code for Insertion

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];

        int n = 4;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;

        int position = 2;
        int element = 25;

        for (int i = n; i > position; i--) {
            arr[i] = arr[i - 1];
        }

        arr[position] = element;
        n++;

        System.out.println("Array after insertion:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Output:

```text
Array after insertion:
10 20 25 30 40
```

---

# 12. Insertion at Beginning

Suppose:

```text
10 20 30 40
```

We want to insert:

```text
5
```

at index `0`.

All elements must shift right.

```text
Before:

10 20 30 40

After shifting:

_ 10 20 30 40

Insert 5:

5 10 20 30 40
```

### Code

```java
int position = 0;
int element = 5;

for (int i = n; i > position; i--) {
    arr[i] = arr[i - 1];
}

arr[position] = element;
n++;
```

---

# 13. Insertion at End

Suppose:

```text
10 20 30 40
```

We want to insert:

```text
50
```

at the end.

No shifting is required.

```java
arr[n] = 50;
n++;
```

Result:

```text
10 20 30 40 50
```

---

# 14. Time Complexity of Insertion

Insertion complexity depends on the position.

### Beginning

Many elements need to be shifted.

```text
O(n)
```

### Middle

Some elements need to be shifted.

```text
O(n)
```

### End

No shifting is generally required if there is free capacity.

```text
O(1)
```

### Worst Case

```text
O(n)
```

---

# 15. Deletion in 1D Array

## What is Deletion?

Deletion means removing an element from an array.

Suppose:

```text
10 20 30 40 50
```

We want to delete the element at index `2`.

Element:

```text
30
```

After deletion:

```text
10 20 40 50
```

---

# 16. Why Shifting is Required During Deletion?

After removing an element, a gap is created.

Before:

```text
10 20 30 40 50
      ↑
    Delete
```

After removing `30`:

```text
10 20 _ 40 50
```

To remove the gap, elements after the deleted element are shifted left:

```text
40 → left
50 → left
```

Final:

```text
10 20 40 50
```

---

# 17. Algorithm for Deletion

```text
Step 1: Start
Step 2: Check whether the array contains elements
Step 3: Check whether the position is valid
Step 4: Start from the deletion position
Step 5: Shift every next element one position to the left
Step 6: Decrease the current size
Step 7: Stop
```

---

# 18. Java Code for Deletion

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int n = 5;
        int position = 2;

        for (int i = position; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        n--;

        System.out.println("Array after deletion:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Output:

```text
Array after deletion:
10 20 40 50
```

---

# 19. Deletion from Beginning

Suppose:

```text
10 20 30 40 50
```

Delete index `0`.

The remaining elements shift left:

```text
20 30 40 50
```

### Code

```java
for (int i = 0; i < n - 1; i++) {
    arr[i] = arr[i + 1];
}

n--;
```

---

# 20. Deletion from End

Suppose:

```text
10 20 30 40 50
```

Delete the last element.

No shifting is required.

Simply decrease the logical size:

```java
n--;
```

The active array becomes:

```text
10 20 30 40
```

---

# 21. Time Complexity of Deletion

### Beginning

```text
O(n)
```

### Middle

```text
O(n)
```

### End

```text
O(1)
```

### Worst Case

```text
O(n)
```

---

# 22. Updation in 1D Array

## What is Updation?

Updation means replacing an existing element with a new value.

Example:

```text
Before:

10 20 30 40 50
```

Update index `2`:

```text
30 → 100
```

After:

```text
10 20 100 40 50
```

---

# 23. Algorithm for Updation

```text
Step 1: Start
Step 2: Read the position
Step 3: Check whether the position is valid
Step 4: Replace the existing value with the new value
Step 5: Stop
```

---

# 24. Java Code for Updation

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int position = 2;
        int newValue = 100;

        arr[position] = newValue;

        System.out.println("Array after updation:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Output:

```text
Array after updation:
10 20 100 40 50
```

---

# 25. Time Complexity of Updation

Array elements can be directly accessed using their index.

Therefore:

```java
arr[index] = value;
```

takes:

```text
O(1)
```

time.

So:

```text
Updation = O(1)
```

assuming the index is valid.

---

# 26. Searching in 1D Array

Searching means finding whether a particular element exists in the array.

Example:

```text
Array:

10 20 30 40 50
```

Search:

```text
40
```

Result:

```text
Element found at index 3
```

Two important searching techniques are:

```text
1. Linear Search
2. Binary Search
```

---

# 27. Linear Search

Linear Search checks elements one by one from the beginning until the target is found or the array ends.

Example:

```text
Array:

10 20 30 40 50

Target = 40
```

Process:

```text
10 → No
20 → No
30 → No
40 → Yes
```

Result:

```text
Index = 3
```

---

# 28. Algorithm for Linear Search

```text
Step 1: Start
Step 2: Read array and target
Step 3: Start from index 0
Step 4: Compare current element with target
Step 5: If equal, return the index
Step 6: Otherwise continue
Step 7: If the end is reached, return -1
Step 8: Stop
```

---

# 29. Java Code for Linear Search

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int target = 40;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

Output:

```text
Element found at index: 3
```

---

# 30. Time Complexity of Linear Search

### Best Case

Target is at the first position:

```text
O(1)
```

### Worst Case

Target is at the last position or not present:

```text
O(n)
```

### Space Complexity

```text
O(1)
```

---

# 31. Binary Search

Binary Search is an efficient searching algorithm that works on a **sorted array**.

Example:

```text
10 20 30 40 50 60 70
```

Search:

```text
60
```

Binary Search repeatedly divides the search range into two halves.

---

# 32. Working of Binary Search

Consider:

```text
10 20 30 40 50 60 70
```

Target:

```text
60
```

First middle:

```text
40
```

Since:

```text
60 > 40
```

search only the right half:

```text
50 60 70
```

Middle:

```text
60
```

Target found.

---

# 33. Algorithm for Binary Search

```text
Step 1: Start
Step 2: Set low = 0
Step 3: Set high = n - 1
Step 4: Calculate mid
Step 5: Compare arr[mid] with target
Step 6: If equal, return mid
Step 7: If target is greater, move low to mid + 1
Step 8: If target is smaller, move high to mid - 1
Step 9: Repeat until low > high
Step 10: Return -1 if not found
Step 11: Stop
```

---

# 34. Java Code for Binary Search

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        int target = 60;

        int low = 0;
        int high = arr.length - 1;

        int index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                index = mid;
                break;
            }

            else if (arr[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

Output:

```text
Element found at index: 5
```

---

# 35. Time Complexity of Binary Search

Best case:

```text
O(1)
```

Worst case:

```text
O(log n)
```

Space complexity for the iterative implementation:

```text
O(1)
```

### Important

Binary Search requires the array to be **sorted**.

---

# 36. Searching Comparison

| Searching     | Requirement           | Best Case | Worst Case |
| ------------- | --------------------- | --------: | ---------: |
| Linear Search | No sorting required   |      O(1) |       O(n) |
| Binary Search | Sorted array required |      O(1) |   O(log n) |

---

# 37. Sorting in 1D Array

Sorting means arranging elements in a particular order.

Two common orders are:

### Ascending

```text
10 20 30 40 50
```

### Descending

```text
50 40 30 20 10
```

Sorting is important because many algorithms, especially Binary Search, require sorted data.

---

# 38. Common Sorting Algorithms

Important sorting algorithms include:

```text
1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort
5. Quick Sort
6. Heap Sort
```

For beginners, we generally start with:

```text
Bubble Sort
Selection Sort
Insertion Sort
```

---

# 39. Bubble Sort

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

Example:

```text
5 3 4 1
```

Compare:

```text
5 and 3
```

Since:

```text
5 > 3
```

swap:

```text
3 5 4 1
```

Then:

```text
5 and 4
```

swap:

```text
3 4 5 1
```

Then:

```text
5 and 1
```

swap:

```text
3 4 1 5
```

After one pass, the largest element reaches the end.

---

# 40. Bubble Sort Algorithm

```text
Step 1: Start
Step 2: Repeat for each pass
Step 3: Compare adjacent elements
Step 4: If the first is greater than the second, swap them
Step 5: Continue until the end of the unsorted portion
Step 6: Repeat until the array is sorted
Step 7: Stop
```

---

# 41. Java Code for Bubble Sort

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {50, 20, 40, 10, 30};

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Output:

```text
Sorted Array:
10 20 30 40 50
```

---

# 42. Bubble Sort Complexity

Standard Bubble Sort:

```text
Best Case    → O(n)      with an optimized early-exit version
Average Case → O(n²)
Worst Case   → O(n²)
```

Space complexity:

```text
O(1)
```

because sorting is performed in-place.

---

# 43. Selection Sort

Selection Sort repeatedly finds the smallest element from the unsorted portion and places it at the correct position.

Example:

```text
64 25 12 22 11
```

Find minimum:

```text
11
```

Place it at the beginning:

```text
11 25 12 22 64
```

Then find the minimum from the remaining elements:

```text
12
```

Result:

```text
11 12 25 22 64
```

Continue until sorted.

---

# 44. Java Code for Selection Sort

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Output:

```text
Sorted Array:
11 12 22 25 64
```

---

# 45. Selection Sort Complexity

Best Case:

```text
O(n²)
```

Average Case:

```text
O(n²)
```

Worst Case:

```text
O(n²)
```

Space:

```text
O(1)
```

---

# 46. Insertion Sort

Insertion Sort builds the sorted array one element at a time.

Example:

```text
5 3 4 1
```

Initially:

```text
5
```

Insert `3`:

```text
3 5
```

Insert `4`:

```text
3 4 5
```

Insert `1`:

```text
1 3 4 5
```

---

# 47. Java Code for Insertion Sort

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {5, 3, 4, 1, 2};

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];

                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

Output:

```text
Sorted Array:
1 2 3 4 5
```

---

# 48. Insertion Sort Complexity

Best Case:

```text
O(n)
```

Average Case:

```text
O(n²)
```

Worst Case:

```text
O(n²)
```

Space:

```text
O(1)
```

---

# 49. Java Built-in Sorting

Java provides built-in sorting functionality through `Arrays.sort()`.

Example:

```java
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {50, 20, 40, 10, 30};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
```

Output:

```text
[10, 20, 30, 40, 50]
```

For DSA learning, however, it is important to implement sorting algorithms manually to understand their logic.

---

# 50. Complete Comparison of Array Operations

| Operation           | Description             | Typical Time Complexity |
| ------------------- | ----------------------- | ----------------------: |
| Access              | Access element by index |                    O(1) |
| Update              | Replace element         |                    O(1) |
| Traversal           | Visit all elements      |                    O(n) |
| Search              | Find an element         |             O(n) Linear |
| Binary Search       | Search sorted array     |                O(log n) |
| Insert at beginning | Shift elements          |                    O(n) |
| Insert in middle    | Shift elements          |                    O(n) |
| Insert at end       | If space available      |                    O(1) |
| Delete at beginning | Shift elements          |                    O(n) |
| Delete in middle    | Shift elements          |                    O(n) |
| Delete at end       | Reduce logical size     |                    O(1) |

---

# 51. Array Operation Example

Consider:

```text
arr = [10, 20, 30, 40, 50]
```

### Access

```java
arr[2]
```

Result:

```text
30
```

---

### Update

```java
arr[2] = 100;
```

Result:

```text
10 20 100 40 50
```

---

### Insert

Insert `25` at index `2`:

```text
10 20 25 100 40 50
```

---

### Delete

Delete index `2`:

```text
10 20 100 40 50
```

---

### Search

Search `40`:

```text
Index = 3
```

---

### Sort

Before:

```text
50 20 40 10 30
```

After:

```text
10 20 30 40 50
```

---

# 52. Important Concept: Array Size vs Logical Size

In Java, an array has a fixed capacity.

Example:

```java
int[] arr = new int[10];
```

Capacity:

```text
10
```

But we may currently be using only:

```text
4
```

elements.

Therefore, we can maintain:

```java
int n = 4;
```

where:

```text
arr.length = 10
n = 4
```

This distinction is important when implementing insertion and deletion manually.

```text
Array Capacity = Total available positions

Logical Size = Number of currently stored elements
```

---

# 53. Why Array Insertion is Different from Updation?

This is an important interview question.

### Updation

Existing element is replaced.

```text
10 20 30 40
      ↓
     100
```

Size remains unchanged.

```text
n = 4
```

### Insertion

A new element is added.

```text
10 20 25 30 40
```

Size increases.

```text
n = 5
```

Therefore:

```text
Update → Replace
Insert → Add
```

---

# 54. Why Array Deletion Requires Shifting?

Suppose:

```text
10 20 30 40 50
```

Delete `30`.

Without shifting:

```text
10 20 _ 40 50
```

There is a gap.

To maintain a contiguous logical sequence:

```text
10 20 40 50
```

we shift elements to the left.

Therefore:

> **Deletion from the middle of an array requires shifting subsequent elements toward the left.**

---

# 55. Why Insertion Requires Shifting?

Suppose:

```text
10 20 30 40
```

We want:

```text
25
```

between `20` and `30`.

We first need an empty position:

```text
10 20 _ 30 40
```

Therefore:

```text
30 → right
40 → right
```

Then:

```text
10 20 25 30 40
```

Therefore:

> **Insertion into the middle of an array requires shifting elements toward the right.**

---

# 56. Advantages of 1D Arrays

### 1. Simple

Arrays are easy to understand and implement.

### 2. Fast Access

Elements can be accessed directly using an index.

```text
O(1)
```

### 3. Memory Efficient

Arrays store elements in contiguous memory and have relatively low overhead.

### 4. Cache Friendly

Contiguous storage can provide good cache locality.

### 5. Useful Foundation

Arrays are fundamental to many other data structures and algorithms.

---

# 57. Disadvantages of 1D Arrays

### 1. Fixed Size in Java

The length of a Java array cannot be changed after creation.

### 2. Insertion Can Be Expensive

Insertion in the beginning or middle requires shifting.

```text
O(n)
```

### 3. Deletion Can Be Expensive

Deletion in the beginning or middle requires shifting.

```text
O(n)
```

### 4. Requires Contiguous Storage Conceptually

Arrays are designed around contiguous indexed storage.

### 5. Possible Unused Capacity

When using a larger array to support manual insertion, some positions may remain unused.

---

# 58. Complete 1D Array Operations Program

The following program demonstrates:

```text
Insertion
Deletion
Updation
Linear Search
Sorting
```

```java
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];

        int n = 5;

        arr[0] = 50;
        arr[1] = 20;
        arr[2] = 40;
        arr[3] = 10;
        arr[4] = 30;

        System.out.println("Original Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Insertion
        int position = 2;
        int element = 25;

        for (int i = n; i > position; i--) {
            arr[i] = arr[i - 1];
        }

        arr[position] = element;
        n++;

        System.out.println("\n\nAfter Insertion:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Updation
        position = 2;
        arr[position] = 100;

        System.out.println("\n\nAfter Updation:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Deletion
        position = 3;

        for (int i = position; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        n--;

        System.out.println("\n\nAfter Deletion:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Linear Search
        int target = 40;
        int index = -1;

        for (int i = 0; i < n; i++) {

            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        System.out.println("\n\nSearching:");

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        // Sorting
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter Sorting:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

# 59. Final Summary

A 1D array is a linear collection of elements accessed using indexes.

The most important operations are:

```text
        1D ARRAY
           |
    -----------------
    |   |   |   |   |
 Insert Delete Update Search Sort
```

### Insertion

Adds a new element.

```text
Middle → Shift elements right
```

Typical worst-case complexity:

```text
O(n)
```

---

### Deletion

Removes an element.

```text
Middle → Shift elements left
```

Typical worst-case complexity:

```text
O(n)
```

---

### Updation

Replaces an existing element.

```text
arr[index] = value;
```

Complexity:

```text
O(1)
```

---

### Searching

Finds an element.

Linear Search:

```text
O(n) worst case
```

Binary Search:

```text
O(log n) worst case
```

but requires sorted data.

---

### Sorting

Arranges elements in a particular order.

Common algorithms:

```text
Bubble Sort
Selection Sort
Insertion Sort
Merge Sort
Quick Sort
Heap Sort
```

---



# One-Line Definitions

**Array:**

> A linear data structure that stores elements of the same type in indexed positions.

**Insertion:**

> The operation of adding a new element at a specified position.

**Deletion:**

> The operation of removing an existing element from a specified position.

**Updation:**

> The operation of replacing an existing element with a new value.

**Searching:**

> The operation of finding whether a particular element exists in an array and determining its position.

**Sorting:**

> The operation of arranging elements in a specified order, such as ascending or descending order.

---

