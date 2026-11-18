## 1. What is Searching?

**Searching** is the process of finding a particular element (called the **key** or **target**) in a collection of data.

Example:

```text
Array = [10, 20, 30, 40, 50]
Target = 30
```

The target `30` is present at index `2`.

> **Important:** Array indexing in Java starts from `0`. Therefore, the first element is at index `0`.

There are two common searching techniques:

1. Linear Search
2. Binary Search

---

# 2. Linear Search

## Definition

**Linear Search** is a simple searching technique in which we check each element of the array one by one from the beginning until the target element is found or the array ends.

It does not require the array to be sorted.

## Algorithm: Linear Search

```text
LINEAR-SEARCH(array, n, target):

1. Start from index i = 0.
2. Repeat while i < n:
      a. If array[i] == target:
             Return i.
      b. Otherwise, increase i by 1.
3. If the target is not found, return -1.
```

## Java Code: Linear Search

```java
class LinearSearch {
    static int search(int a[], int tar) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == tar) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {10, 20, 30, 40, 50};
        int tar = 30;

        int ans = search(a, tar);
        System.out.println(ans);
    }
}
```

**Output:**

```text
2
```

## Dry Run: Linear Search

Given:

```text
Array  = [10, 20, 30, 40, 50]
Target = 30
```

| Step | Index `i` | `a[i]` | Comparison | Result |
|---|---:|---:|---|---|
| 1 | 0 | 10 | 10 == 30? | No |
| 2 | 1 | 20 | 20 == 30? | No |
| 3 | 2 | 30 | 30 == 30? | Yes |

The target is found at **index 2**.

## Complexity of Linear Search

| Case | Time Complexity | Explanation |
|---|---|---|
| Best Case | `O(1)` | Target is at the first index |
| Average Case | `O(n)` | Several elements are checked |
| Worst Case | `O(n)` | Target is last or not present |

**Space Complexity:** `O(1)` because the algorithm uses only a constant amount of extra space.

---

# 3. Binary Search

## Definition

**Binary Search** is an efficient searching technique that repeatedly divides a sorted array into two halves to find the target element.

**Important condition:** Binary Search works correctly only when the array is sorted.

It compares the target with the middle element:

- If the middle element equals the target, the search is successful.
- If the target is smaller, search the left half.
- If the target is greater, search the right half.

## Algorithm: Binary Search

```text
BINARY-SEARCH(array, low, high, target):

1. Repeat while low <= high.
2. Calculate mid = (low + high) / 2.
3. If array[mid] == target:
       Return mid.
4. If target < array[mid]:
       Set high = mid - 1.
5. Otherwise:
       Set low = mid + 1.
6. If the loop ends, return -1.
```

## Example

```text
Array  = [1, 2, 3, 45, 67, 89, 99]
Target = 45
```

Index positions:

```text
Index:  0  1  2   3   4   5   6
Array:  1  2  3  45  67  89  99
```

## Dry Run: Binary Search (Non-Recursive)

Initial values:

```text
low = 0
high = 6
target = 45
```

| Step | low | high | mid = (low + high) / 2 | a[mid] | Decision |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 45 | Target found |

The target is found at **index 3** in the first comparison.

### Another dry run to understand both halves

Given the same array and `target = 89`:

| Step | low | high | mid | a[mid] | Decision |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 45 | 89 > 45, so `low = 4` |
| 2 | 4 | 6 | 5 | 89 | Target found |

The target is found at **index 5**.

## 3.1 Non-Recursive Binary Search (Iterative)

This version uses a `while` loop. It does not use recursion.

### Java Code

```java
public class BinarySearchWR {
    public static int BSR(int a[], int i, int j, int tar) {
        while (i <= j) {
            int mid = (i + j) / 2;

            if (a[mid] == tar) {
                return mid;
            } else if (a[mid] > tar) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 45, 67, 89, 99};
        int tar = 9;

        int ans = BSR(a, 0, a.length - 1, tar);
        System.out.println(ans);
    }
}
```

**Output for target `9`:**

```text
-1
```

`-1` means the target is not present in the array.

To see a successful search, change `tar = 9` to `tar = 45`. The output will be `3`.

### Explanation

- `i` represents the starting index (`low`).
- `j` represents the ending index (`high`).
- `mid` represents the middle index.
- If `a[mid]` equals the target, return the middle index.
- If `a[mid]` is greater than the target, move to the left half.
- Otherwise, move to the right half.
- If `i > j`, the target is not present, so return `-1`.

---

# 4. Recursive Binary Search

## Definition

**Recursive Binary Search** uses a function that calls itself to search in either the left half or the right half of a sorted array.

Instead of using a loop, it repeatedly calls the same function with a smaller search range.

## Algorithm: Recursive Binary Search

```text
RECURSIVE-BINARY-SEARCH(array, low, high, target):

1. If low > high:
       Return -1.
2. Calculate mid = (low + high) / 2.
3. If array[mid] == target:
       Return mid.
4. If target < array[mid]:
       Search the left half:
       Return RECURSIVE-BINARY-SEARCH(array, low, mid - 1, target).
5. Otherwise:
       Search the right half:
       Return RECURSIVE-BINARY-SEARCH(array, mid + 1, high, target).
```

## 4.1 Recursive Binary Search Code

The following is your supplied recursive code, kept in the same structure and style:

```java
class BinarySearchRecursive {
    static int BSR(int a[], int i, int j, int tar) {
        if (i == j) {
            if (a[i] == tar) {
                return i;
            } else {
                return -1;
            }
        } else {
            int mid = (i + j) / 2;

            if (a[mid] == tar) {
                return mid;
            } else if (a[mid] > tar) {
                return BSR(a, i, mid - 1, tar);
            } else {
                return BSR(a, mid + 1, j, tar);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 45, 67, 89, 99};
        int tar = 45;

        int ans = BSR(a, 0, a.length - 1, tar);
        System.out.println(ans);
    }
}
```

**Output:**

```text
3
```

### Important correction for your recursive code

Your exact code works for the shown example where `45` is present. However, if the target is absent (for example, `tar = 9`), the search range can become empty (`i > j`). The condition `i == j` does not handle that case, so the function may keep calling itself.

To safely handle both found and not-found targets, use this small correction in the base condition:

```java
class BinarySearchRecursive {
    static int BSR(int a[], int i, int j, int tar) {

        if (i > j) {
            return -1;
        }

        if (i == j) {
            if (a[i] == tar) {
                return i;
            } else {
                return -1;
            }
        } else {
            int mid = (i + j) / 2;

            if (a[mid] == tar) {
                return mid;
            } else if (a[mid] > tar) {
                return BSR(a, i, mid - 1, tar);
            } else {
                return BSR(a, mid + 1, j, tar);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 45, 67, 89, 99};
        int tar = 9;

        int ans = BSR(a, 0, a.length - 1, tar);
        System.out.println(ans);
    }
}
```

**Output for target `9`:**

```text
-1
```

## Dry Run: Recursive Binary Search

Given:

```text
Array  = [1, 2, 3, 45, 67, 89, 99]
Target = 45
```

### Step 1: First function call

```text
BSR(a, 0, 6, 45)

i = 0
j = 6
mid = (0 + 6) / 2 = 3
a[3] = 45
```

Condition:

```text
a[mid] == tar
45 == 45
```

True, so return `3`.

<badge color="success">Target found at index 3</badge>

### Dry run where recursion goes deeper

Given the same array and `target = 89`:

| Function call | i | j | mid | a[mid] | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 45 | `89 > 45`, call left? No, right half |
| 2 | 4 | 6 | 5 | 89 | Target found |

The second call returns index `5`. The first call also returns that result.

---

# 5. Time and Space Complexity of Binary Search

| Version | Best Time | Average Time | Worst Time | Auxiliary Space |
|---|---|---|---|---|
| Iterative Binary Search | `O(1)` | `O(log n)` | `O(log n)` | `O(1)` |
| Recursive Binary Search | `O(1)` | `O(log n)` | `O(log n)` | `O(log n)` |

**Why is recursive space `O(log n)`?** Each recursive call uses stack memory. Binary Search halves the search range in every call, so the maximum number of calls is proportional to `log n`.

**Why is iterative space `O(1)`?** It uses only a few variables such as `i`, `j`, and `mid`, without recursive calls.

---

**Note:** All examples use zero-based indexing. Binary Search examples use the sorted array `{1, 2, 3, 45, 67, 89, 99}`.
