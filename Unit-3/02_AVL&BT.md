
# PART 1: AVL TREE

# 1. Introduction to AVL Tree

An **AVL Tree (Adelson-Velsky and Landis Tree)** is a self-balancing Binary Search Tree (BST).

In a normal BST, inserting sorted elements can create a skewed tree. This increases the searching time to O(N).

AVL Tree solves this problem by maintaining balance after every insertion and deletion.

The height difference between the left and right subtrees of every node must not be greater than 1.

### Example

Balanced AVL Tree:

```text
          30
         /  \
       20    40
      /        \
     10         50
```

Unbalanced BST:

```text
10
  \
   20
     \
      30
        \
         40
```

# 2. Properties of AVL Tree

1. AVL Tree is a self-balancing BST.
2. Each node can have at most two children.
3. Left subtree contains smaller values.
4. Right subtree contains greater values.
5. Balance factor must be -1, 0, or +1.
6. Rotations are used to maintain balance.
7. Searching, insertion and deletion take O(log N) time.

# 3. Structure of AVL Tree Node

Every AVL Tree node contains:

- Data
- Left child
- Right child
- Height

### Java Code

```java
class Node {
    int data;
    int height;

    Node left, right;

    Node(int data) {
        this.data = data;
        height = 1;
        left = right = null;
    }
}
```

**Why is height initialized to 1?**

Because a newly created node is always a leaf node.

We consider:

- NULL node height = 0
- Leaf node height = 1

Formula:

```text
Height = 1 + max(left height, right height)
```

# 4. Height of a Node

Height represents the number of nodes on the longest path from a particular node to a leaf.

### Example

```text
           30
          /  \
        20    40
       /
      10
```

| Node | Height |
|---|---:|
| 10 | 1 |
| 20 | 2 |
| 40 | 1 |
| 30 | 3 |

### Java Code

```java
int height(Node root) {
    if (root == null)
        return 0;

    return root.height;
}
```

# 5. Balance Factor

Balance Factor is used to check whether an AVL Tree node is balanced.

### Formula

```text
Balance Factor = Height(Left) - Height(Right)
```

| Balance Factor | Meaning |
|---|---|
| 0 | Both subtrees have equal height |
| +1 | Left subtree is higher |
| -1 | Right subtree is higher |
| +2 | Left-heavy imbalance |
| -2 | Right-heavy imbalance |

### Java Code

```java
int getBalance(Node root) {
    if (root == null)
        return 0;

    return height(root.left) - height(root.right);
}
```

# 6. Rotations in AVL Tree

Rotation is an operation used to balance an AVL Tree without violating the Binary Search Tree property.

There are four types of rotations:

1. LL Rotation
2. RR Rotation
3. LR Rotation
4. RL Rotation

## 6.1 LL (Left-Left Case)


LL imbalance occurs when a new node is inserted into the left subtree of the left child of an unbalanced node.

Solution: Right Rotation.

### Example

Insert: 30, 20, 10

Before rotation:

```text
        30
       /
      20
     /
    10
```

Balance factor of 30 = +2.

After Right Rotation:

```text
       20
      /  \
     10   30
```

### Code

```java
Node rightRotate(Node y) {

    Node x = y.left;
    Node T2 = x.right;

    x.right = y;
    y.left = T2;

    y.height = 1 + Math.max(
        height(y.left),
        height(y.right)
    );

    x.height = 1 + Math.max(
        height(x.left),
        height(x.right)
    );

    return x;
}
```

## 6.2 RR (Right-Right Case)


RR imbalance occurs when a new node is inserted into the right subtree of the right child of an unbalanced node.

Solution: Left Rotation.

### Example

Insert: 10, 20, 30

Before rotation:

```text
10
  \
   20
     \
      30
```

After Left Rotation:

```text
       20
      /  \
     10   30
```

### Java Code

```java
Node leftRotate(Node x) {

    Node y = x.right;
    Node T2 = y.left;

    y.left = x;
    x.right = T2;

    x.height = 1 + Math.max(
        height(x.left),
        height(x.right)
    );

    y.height = 1 + Math.max(
        height(y.left),
        height(y.right)
    );

    return y;
}
```

## 6.3 LR Rotation (Left-Right Case)


LR imbalance occurs when a new node is inserted into the right subtree of the left child.

Solution:

1. Left Rotation on the left child.
2. Right Rotation on the unbalanced node.

### Example

Insert: 30, 10, 20

Before rotation:

```text
       30
      /
     10
       \
        20
```

Step 1: Left Rotation on 10.

```text
       30
      /
     20
    /
   10
```

Step 2: Right Rotation on 30.

```text
       20
      /  \
     10   30
```

### Code

```java
root.left = leftRotate(root.left);

return rightRotate(root);
```

## 6.4 RL Rotation (Right-Left Case)


RL imbalance occurs when a new node is inserted into the left subtree of the right child.

Solution:

1. Right Rotation on the right child.
2. Left Rotation on the unbalanced node.

### Example

Insert: 10, 30, 20

Before rotation:

```text
10
  \
   30
  /
 20
```

Step 1: Right Rotation on 30.

```text
10
  \
   20
     \
      30
```

Step 2: Left Rotation on 10.

```text
       20
      /  \
     10   30
```

### Code

```java
root.right = rightRotate(root.right);

return leftRotate(root);
```

### Rotation Summary

| Case | Condition | Rotation |
|---|---|---|
| LL | Left of Left | Right Rotation |
| RR | Right of Right | Left Rotation |
| LR | Right of Left | Left + Right |
| RL | Left of Right | Right + Left |

# 7. AVL Tree Insertion


Insertion in AVL Tree is similar to insertion in BST.

However, after inserting a new node, we must update the height and balance factor of every affected ancestor.

If a node becomes unbalanced, we perform the appropriate rotation.

### Algorithm

1. If root is NULL, create a new node.
2. If value is smaller, insert into the left subtree.
3. If value is greater, insert into the right subtree.
4. Update the height.
5. Calculate the balance factor.
6. Check LL, RR, LR and RL cases.
7. Perform the required rotation.
8. Return the updated root.

### Code

```java
Node insert(Node root, int value) {

    // Step 1: Normal BST insertion
    if (root == null)
        return new Node(value);

    if (value < root.data)
        root.left = insert(root.left, value);

    else if (value > root.data)
        root.right = insert(root.right, value);

    else
        return root;

    // Step 2: Update height
    root.height = 1 + Math.max(
        height(root.left),
        height(root.right)
    );

    // Step 3: Calculate balance factor
    int bf = getBalance(root);

    // LL Case
    if (bf > 1 && value < root.left.data)
        return rightRotate(root);

    // RR Case
    if (bf < -1 && value > root.right.data)
        return leftRotate(root);

    // LR Case
    if (bf > 1 && value > root.left.data) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    // RL Case
    if (bf < -1 && value < root.right.data) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    return root;
}
```

# 8. AVL Tree Insertion

## Example 1

Insert the following values:

```text
40, 20, 60, 10, 30, 25
```

### Step 1: Insert 40

```text
40
```

### Step 2: Insert 20

```text
    40
   /
  20
```

### Step 3: Insert 60

```text
    40
   /  \
  20   60
```

### Step 4: Insert 10

```text
       40
      /  \
    20    60
   /
  10
```

### Step 5: Insert 30

```text
       40
      /  \
    20    60
   /  \
  10   30
```

### Step 6: Insert 25

```text
         40
        /  \
      20    60
     /  \
   10    30
         /
        25
```

Now calculate the balance factor of 40:

```text
Height(left)  = 3
Height(right) = 1

BF = 3 - 1 = +2
```

This is an LR case because the insertion occurred in the right subtree of the left child.

### Step 7: Perform LR Rotation

First: Left Rotation on 20's right child relationship.

```text
         40
        /  \
      25    60
     /  \
   20    30
  /
 10
```

Second: Right Rotation on 40.

<escape>```text
          25
         /  \
       20    40
      /     /  \
     10    30   60
```</escape>

<escape>Final AVL Tree:</escape>

```text
          25
         /  \
       20    40
      /     /  \
     10    30   60
```

## Example 2

Insert:

```text
50, 30, 70, 20, 40, 10, 5
```

### Step 1: Insert first five values

```text
          50
         /  \
       30    70
      /  \
     20   40
```

### Step 2: Insert 10

```text
          50
         /  \
       30    70
      /  \
     20   40
    /
   10
```

### Step 3: Insert 5

```text
          50
         /  \
       30    70
      /  \
     20   40
    /
   10
  /
 5
```

Node 20 has balance factor +2.

This is an LL case.

Perform Right Rotation on node 20.

```text
          50
         /  \
       30    70
      /  \
     10   40
    /  \
   5    20
```

Final tree:

```text
          50
         /  \
       30    70
      /  \
     10   40
    /  \
   5    20
```

# 9. AVL Tree Deletion

**Theory:**

Deletion in AVL Tree follows normal BST deletion rules.

However, after deleting a node, the height of a subtree may change and create an imbalance.

Therefore, we must update heights and perform rotations.

### Three BST Deletion Cases

**Case 1: Leaf Node**

Delete a node that has no children.

```text
       30
      /  \
     20   40
```

Delete 20:

```text
       30
         \
          40
```

**Case 2: One Child**

Replace the deleted node with its child.

```text
       30
      /
     20
    /
   10
```

Delete 20:

```text
       30
      /
     10
```

**Case 3: Two Children**

Replace the node with its inorder successor (smallest value in the right subtree).

```text
       30
      /  \
     20   40
         /
        35
```

Delete 30:

```text
       35
      /  \
     20   40
```

### Code – AVL Deletion

```java
Node minValueNode(Node root) {

    Node current = root;

    while (current.left != null)
        current = current.left;

    return current;
}

Node deleteNode(Node root, int value) {

    if (root == null)
        return root;

    // Normal BST deletion
    if (value < root.data)
        root.left = deleteNode(root.left, value);

    else if (value > root.data)
        root.right = deleteNode(root.right, value);

    else {

        // Zero or one child
        if (root.left == null || root.right == null) {

            Node temp = (root.left != null)
                        ? root.left : root.right;

            if (temp == null)
                return null;

            else
                root = temp;
        }

        // Two children
        else {

            Node temp = minValueNode(root.right);

            root.data = temp.data;

            root.right = deleteNode(root.right, temp.data);
        }
    }

    // Update height
    root.height = 1 + Math.max(
        height(root.left),
        height(root.right)
    );

    int bf = getBalance(root);

    // LL
    if (bf > 1 && getBalance(root.left) >= 0)
        return rightRotate(root);

    // LR
    if (bf > 1 && getBalance(root.left) < 0) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    // RR
    if (bf < -1 && getBalance(root.right) <= 0)
        return leftRotate(root);

    // RL
    if (bf < -1 && getBalance(root.right) > 0) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    return root;
}
```

# 10. AVL Tree Deletion

Consider the following AVL Tree:

```text
           30
          /  \
        20    40
       /  \
      10   25
     /
    5
```

Delete 40.

### Step 1: Delete 40

```text
           30
          /
        20
       /  \
      10   25
     /
    5
```

### Step 2: Calculate Balance Factor of 30

```text
Height(left) = 3
Height(right) = 0

BF = 3 - 0 = +3
```

Node 30 is unbalanced.

### Step 3: Check its left child

Balance factor of 20 is +1.

Therefore, this is an LL case.

Perform Right Rotation on 30.

### Final Tree

```text
           20
          /  \
        10    30
       /     /
      5     25
```

The AVL Tree is balanced again.

# 11. AVL Tree Program

```java
class Node {

    int data, height;

    Node left, right;

    Node(int data) {
        this.data = data;
        height = 1;
    }
}

class AVLTree {

    int height(Node root) {
        if (root == null)
            return 0;

        return root.height;
    }

    int getBalance(Node root) {
        if (root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    Node rightRotate(Node y) {

        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(
            height(y.left), height(y.right));

        x.height = 1 + Math.max(
            height(x.left), height(x.right));

        return x;
    }

    Node leftRotate(Node x) {

        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(
            height(x.left), height(x.right));

        y.height = 1 + Math.max(
            height(y.left), height(y.right));

        return y;
    }

    Node insert(Node root, int value) {

        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);

        else if (value > root.data)
            root.right = insert(root.right, value);

        else
            return root;

        root.height = 1 + Math.max(
            height(root.left), height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && value < root.left.data)
            return rightRotate(root);

        if (bf < -1 && value > root.right.data)
            return leftRotate(root);

        if (bf > 1 && value > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && value < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    Node minValueNode(Node root) {

        Node current = root;

        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int value) {

        if (root == null)
            return root;

        if (value < root.data)
            root.left = deleteNode(root.left, value);

        else if (value > root.data)
            root.right = deleteNode(root.right, value);

        else {

            if (root.left == null || root.right == null) {

                Node temp = (root.left != null)
                            ? root.left : root.right;

                if (temp == null)
                    return null;

                root = temp;
            }

            else {

                Node temp = minValueNode(root.right);

                root.data = temp.data;

                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null)
            return root;

        root.height = 1 + Math.max(
            height(root.left), height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class Main {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        Node root = null;

        root = tree.insert(root, 40);
        root = tree.insert(root, 20);
        root = tree.insert(root, 60);
        root = tree.insert(root, 10);
        root = tree.insert(root, 30);
        root = tree.insert(root, 25);

        System.out.println("AVL Inorder:");
        tree.inorder(root);

        root = tree.deleteNode(root, 60);

        System.out.println("\nAfter Deletion:");
        tree.inorder(root);
    }
}
```

# 12. AVL Tree Complexity

| Operation | Time Complexity |
|---|---|
| Searching | O(log N) |
| Insertion | O(log N) |
| Deletion | O(log N) |
| Rotation | O(1) |
| Inorder Traversal | O(N) |

Space Complexity:

- Tree storage: O(N)
- Recursive stack: O(log N)

---

# PART 2: B-TREE

# 1. Introduction to B-Tree

A **B-Tree** is a self-balancing multiway search tree in which a node can contain multiple keys and multiple children.

Unlike a Binary Search Tree, a B-Tree can have more than two children.

B-Trees are widely used in databases and file systems because they reduce disk access operations.

### Example

```text
              [20 | 40]
             /    |    \
            /     |     \
        [5|10] [25|30] [50|60]
```

The root contains two keys and three children.

# 2. Properties of B-Tree

For a B-Tree of order m:

1. Maximum children = m.
2. Maximum keys = m - 1.
3. Minimum children of a non-root internal node = ceil(m/2).
4. Minimum keys of a non-root node = ceil(m/2) - 1.
5. Keys are stored in sorted order.
6. All leaf nodes are at the same level.
7. A node containing k keys has k+1 children if it is an internal node.
8. The root is allowed to have fewer keys than other nodes.

# 3. Order of B-Tree

Order represents the maximum number of children a node can contain.

### Example: Order 4

```text
Maximum Children = 4
Maximum Keys = 3
Minimum Children = 2
Minimum Keys = 1
```

Example:

```text
             [20 | 40]
            /    |    \
         [10]  [30]  [50|60]
```

 In Java implementation, we will use minimum degree `t` instead of order `m`.

Relationship:

```text
Order m = 2t

Maximum Keys = 2t - 1
Maximum Children = 2t
Minimum Keys = t - 1
```

For `t = 2`, maximum keys = 3 and maximum children = 4.

# 4. Structure of B-Tree Node

A B-Tree node contains:

1. Array of keys.
2. Array of child references.
3. Number of keys.
4. Leaf indicator.

### Java Code

```java
class BTreeNode {

    int[] keys;
    BTreeNode[] child;

    int n;
    boolean leaf;
}
```

# 5. Searching in B-Tree

**Theory:**

Searching in B-Tree is similar to BST searching, but each node can contain multiple keys.

We compare the target value with the keys in the current node.

If the key is found, return it.

Otherwise, move to the appropriate child.

### Example

Search 30:

```text
              [20 | 40]
             /    |    \
        [5|10] [25|30] [50|60]
```

Steps:

1. Compare 30 with 20.
2. Compare 30 with 40.
3. Since 30 lies between 20 and 40, move to the middle child.
4. Find 30.

### Code

```java
BTreeNode search(int key) {

    int i = 0;

    while (i < n && key > keys[i])
        i++;

    if (i < n && keys[i] == key)
        return this;

    if (leaf)
        return null;

    return child[i].search(key);
}
```

# 6. B-Tree Insertion


Insertion in B-Tree always takes place at a leaf node.

Before inserting a new key, we find its correct position.

If a node is full, it must be split before inserting into it.

The middle key is promoted to the parent node.

### Algorithm

1. Start from root.
2. Find the correct leaf node.
3. Insert the new key in sorted order.
4. If the node is full, split it.
5. Promote the middle key.
6. If the parent becomes full, split it too.
7. If root splits, create a new root.

# 7. Splitting in B-Tree


Splitting occurs when a node exceeds its maximum capacity.

The middle key moves to the parent node.

The remaining keys are divided into two nodes.

### Example: Minimum Degree t = 2

Maximum keys = 3.

Suppose we have:

```text
[10 | 20 | 30]
```

Now insert 40.

A temporary overflow occurs:

```text
[10 | 20 | 30 | 40]
```

For the standard top-down insertion algorithm, a full node is split before descending into it. The resulting split is:

```text
           [20]
          /    \
       [10]  [30 | 40]
```

The middle key 20 is promoted.

# 8. B-Tree Insertion

Consider a B-Tree with minimum degree t = 2.

Insert:

```text
10, 20, 5, 6, 12, 30, 7, 17
```

### Step 1: Insert 10, 20, 5

```text
[5 | 10 | 20]
```

The node is full.

### Step 2: Insert 6

Split the full root before descending.

```text
       [10]
      /    \
    [5]    [20]
```

Insert 6 into the left child.

```text
       [10]
      /    \
   [5 | 6] [20]
```

### Step 3: Insert 12

```text
       [10]
      /    \
   [5 | 6] [12 | 20]
```

### Step 4: Insert 30

```text
       [10]
      /    \
   [5 | 6] [12 | 20 | 30]
```

### Step 5: Insert 7

```text
       [10]
      /    \
 [5 | 6 | 7] [12 | 20 | 30]
```

### Step 6: Insert 17

The right child is full, so split it.

Promote 20 to the root.

```text
             [10 | 20]
            /    |    \
       [5|6|7]  [12]  [30]
```

Now insert 17 into the middle child.

### Final B-Tree

```text
             [10 | 20]
            /    |    \
       [5|6|7] [12|17] [30]
```

All nodes satisfy the B-Tree properties.

# 9. B-Tree Deletion


Deletion in B-Tree is more complex than insertion.

Every non-root node must maintain at least t-1 keys.

If deletion causes a node to contain fewer than the minimum number of keys, we must resolve underflow.

There are four important operations:

1. Delete from leaf.
2. Delete from internal node.
3. Borrow from sibling.
4. Merge nodes.

## 9.1 Deletion from Leaf Node

If the key exists in a leaf node, remove it directly.

Example:

Before:

```text
          [20 | 40]
         /    |    \
       [10]  [30]  [50]
```

Delete 10:

```text
          [20 | 40]
         /    |    \
        []   [30]  [50]
```

If the node still satisfies the minimum key requirement, deletion is complete.

Otherwise, fix underflow.

## 9.2 Deletion from Internal Node

If the key is in an internal node, we cannot simply remove it.

We replace it with:

- Inorder predecessor: largest key in the left subtree.
- Inorder successor: smallest key in the right subtree.

Then delete that replacement key from its original subtree.

Example:

```text
          [20 | 40]
         /    |    \
       [10]  [30]  [50]
```

Delete 20.

Its inorder successor is 30.

Replace 20 with 30:

```text
          [30 | 40]
         /    |    \
       [10]   []   [50]
```

Then resolve the underflow in the middle child.

## 9.3 Borrowing from Sibling

**Theory:**

If a node has fewer than the minimum required keys, it can borrow a key from an adjacent sibling if that sibling has more than the minimum number of keys.

The parent separator key moves down to the deficient node.

A key from the sibling moves up to the parent.

Example:

Before:

```text
          [30]
         /    \
       [10]  [40 | 50]
```

After borrowing:

```text
          [40]
         /    \
    [10 | 30] [50]
```

The tree is balanced again.

## 9.4 Merging Nodes

**Theory:**

If borrowing is not possible, merge the deficient node with an adjacent sibling.

The separator key from the parent is also moved into the merged node.

Example:

Before:

```text
          [30]
         /    \
       [10]   [40]
```

After merging:

```text
       [10 | 30 | 40]
```

The root becomes empty, so its only child becomes the new root.

# 10. B-Tree Deletion 

Consider the following B-Tree with minimum degree t = 2.

```text
             [10 | 20]
            /    |    \
       [5|6|7] [12|17] [30]
```

### Step 1: Delete 6

Delete 6 from the first leaf.

```text
             [10 | 20]
            /    |    \
        [5|7]  [12|17] [30]
```

### Step 2: Delete 7

```text
             [10 | 20]
            /    |    \
          [5]   [12|17] [30]
```

### Step 3: Delete 5

The first child becomes empty.

```text
             [10 | 20]
            /    |    \
           []   [12|17] [30]
```

The middle sibling has two keys, so borrowing is possible.

The separator key 10 moves down to the left child.

The sibling's smallest key 12 moves up to the parent.

After borrowing:

```text
             [12 | 20]
            /    |    \
          [10]   [17]  [30]
```

### Step 4: Delete 10

The first child becomes empty again.

Its adjacent sibling [17] has only one key, so borrowing is not possible.

We merge the empty child, separator 12 and sibling [17].

After merging:

```text
             [20]
            /    \
       [12 | 17] [30]
```

**Important observations:**

- Step 3 demonstrates borrowing.
- Step 4 demonstrates merging.
- The B-Tree continues to maintain its properties.

# 11. B-Tree Java Implementation

The following code supports:

- Insertion
- Deletion
- Searching
- Inorder traversal
- Splitting
- Borrowing
- Merging

```java
class BTreeNode {

    int[] keys;
    BTreeNode[] child;

    int n;
    boolean leaf;

    int t;

    BTreeNode(int t, boolean leaf) {

        this.t = t;
        this.leaf = leaf;

        keys = new int[2 * t - 1];
        child = new BTreeNode[2 * t];

        n = 0;
    }

    // Search
    BTreeNode search(int key) {

        int i = 0;

        while (i < n && key > keys[i])
            i++;

        if (i < n && keys[i] == key)
            return this;

        if (leaf)
            return null;

        return child[i].search(key);
    }

    // Traversal
    void traverse() {

        int i;

        for (i = 0; i < n; i++) {

            if (!leaf)
                child[i].traverse();

            System.out.print(keys[i] + " ");
        }

        if (!leaf)
            child[i].traverse();
    }

    // Insert into a non-full node
    void insertNonFull(int key) {

        int i = n - 1;

        if (leaf) {

            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }

            keys[i + 1] = key;
            n++;
        }

        else {

            while (i >= 0 && keys[i] > key)
                i--;

            i++;

            if (child[i].n == 2 * t - 1) {

                splitChild(i, child[i]);

                if (keys[i] < key)
                    i++;
            }

            child[i].insertNonFull(key);
        }
    }

    // Split child
    void splitChild(int i, BTreeNode y) {

        BTreeNode z = new BTreeNode(t, y.leaf);

        z.n = t - 1;

        for (int j = 0; j < t - 1; j++)
            z.keys[j] = y.keys[j + t];

        if (!y.leaf) {

            for (int j = 0; j < t; j++)
                z.child[j] = y.child[j + t];
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--)
            child[j + 1] = child[j];

        child[i + 1] = z;

        for (int j = n - 1; j >= i; j--)
            keys[j + 1] = keys[j];

        keys[i] = y.keys[t - 1];

        n++;
    }

    // Find the key index
    int findKey(int key) {

        int idx = 0;

        while (idx < n && keys[idx] < key)
            idx++;

        return idx;
    }

    // Remove key
    void remove(int key) {

        int idx = findKey(key);

        if (idx < n && keys[idx] == key) {

            if (leaf)
                removeFromLeaf(idx);

            else
                removeFromNonLeaf(idx);
        }

        else {

            if (leaf)
                return;

            boolean flag = (idx == n);

            if (child[idx].n < t)
                fill(idx);

            if (flag && idx > n)
                child[idx - 1].remove(key);

            else
                child[idx].remove(key);
        }
    }

    // Delete from leaf
    void removeFromLeaf(int idx) {

        for (int i = idx + 1; i < n; i++)
            keys[i - 1] = keys[i];

        n--;
    }

    // Delete from internal node
    void removeFromNonLeaf(int idx) {

        int key = keys[idx];

        if (child[idx].n >= t) {

            int pred = getPredecessor(idx);

            keys[idx] = pred;

            child[idx].remove(pred);
        }

        else if (child[idx + 1].n >= t) {

            int succ = getSuccessor(idx);

            keys[idx] = succ;

            child[idx + 1].remove(succ);
        }

        else {

            merge(idx);

            child[idx].remove(key);
        }
    }

    // Get predecessor
    int getPredecessor(int idx) {

        BTreeNode current = child[idx];

        while (!current.leaf)
            current = current.child[current.n];

        return current.keys[current.n - 1];
    }

    // Get successor
    int getSuccessor(int idx) {

        BTreeNode current = child[idx + 1];

        while (!current.leaf)
            current = current.child[0];

        return current.keys[0];
    }

    // Fill an underflow child
    void fill(int idx) {

        if (idx != 0 && child[idx - 1].n >= t)
            borrowFromPrev(idx);

        else if (idx != n && child[idx + 1].n >= t)
            borrowFromNext(idx);

        else {

            if (idx != n)
                merge(idx);

            else
                merge(idx - 1);
        }
    }

    // Borrow from previous sibling
    void borrowFromPrev(int idx) {

        BTreeNode c = child[idx];
        BTreeNode s = child[idx - 1];

        for (int i = c.n - 1; i >= 0; i--)
            c.keys[i + 1] = c.keys[i];

        if (!c.leaf) {

            for (int i = c.n; i >= 0; i--)
                c.child[i + 1] = c.child[i];
        }

        c.keys[0] = keys[idx - 1];

        if (!c.leaf)
            c.child[0] = s.child[s.n];

        keys[idx - 1] = s.keys[s.n - 1];

        c.n++;
        s.n--;
    }

    // Borrow from next sibling
    void borrowFromNext(int idx) {

        BTreeNode c = child[idx];
        BTreeNode s = child[idx + 1];

        c.keys[c.n] = keys[idx];

        if (!c.leaf)
            c.child[c.n + 1] = s.child[0];

        keys[idx] = s.keys[0];

        for (int i = 1; i < s.n; i++)
            s.keys[i - 1] = s.keys[i];

        if (!s.leaf) {

            for (int i = 1; i <= s.n; i++)
                s.child[i - 1] = s.child[i];
        }

        c.n++;
        s.n--;
    }

    // Merge two children
    void merge(int idx) {

        BTreeNode c = child[idx];
        BTreeNode s = child[idx + 1];

        c.keys[t - 1] = keys[idx];

        for (int i = 0; i < s.n; i++)
            c.keys[i + t] = s.keys[i];

        if (!c.leaf) {

            for (int i = 0; i <= s.n; i++)
                c.child[i + t] = s.child[i];
        }

        for (int i = idx + 1; i < n; i++)
            keys[i - 1] = keys[i];

        for (int i = idx + 2; i <= n; i++)
            child[i - 1] = child[i];

        c.n += s.n + 1;
        n--;
    }
}

class BTree {

    BTreeNode root;
    int t;

    BTree(int t) {
        this.t = t;
        root = null;
    }

    // Insertion
    void insert(int key) {

        if (root == null) {

            root = new BTreeNode(t, true);

            root.keys[0] = key;
            root.n = 1;

            return;
        }

        // Avoid duplicate keys
        if (search(key))
            return;

        if (root.n == 2 * t - 1) {

            BTreeNode s = new BTreeNode(t, false);

            s.child[0] = root;

            s.splitChild(0, root);

            int i = 0;

            if (s.keys[0] < key)
                i++;

            s.child[i].insertNonFull(key);

            root = s;
        }

        else
            root.insertNonFull(key);
    }

    // Search
    boolean search(int key) {

        return root != null &&
               root.search(key) != null;
    }

    // Deletion
    void delete(int key) {

        if (root == null)
            return;

        root.remove(key);

        if (root.n == 0) {

            if (root.leaf)
                root = null;

            else
                root = root.child[0];
        }
    }

    // Traversal
    void traverse() {

        if (root != null)
            root.traverse();

        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {

        BTree tree = new BTree(2);

        // Insertion
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        System.out.println("B-Tree:");
        tree.traverse();

        // Searching
        System.out.println("Search 12: " + tree.search(12));

        // Deletion
        tree.delete(6);
        tree.delete(7);
        tree.delete(5);
        tree.delete(10);

        System.out.println("After Deletion:");
        tree.traverse();
    }
}
```

# 12. B-Tree Complexity

| Operation | Time Complexity |
|---|---|
| Searching | O(log N) |
| Insertion | O(log N) |
| Deletion | O(log N) |
| Traversal | O(N) |
| Splitting | O(t) per split |
| Borrowing | O(t) |
| Merging | O(t) |

Space Complexity: O(N) for storing all nodes and keys.

---
