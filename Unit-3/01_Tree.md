
# 1. Introduction to Tree

A **Tree** is a non-linear hierarchical data structure consisting of nodes connected through edges.

Unlike arrays and linked lists, trees organize data in a hierarchical structure.

### Applications

- File and Folder Structure
- Organization Hierarchy
- HTML DOM Structure
- Database Indexing
- Decision Trees

### Example

```text
             10
           /    \
          20     30
         /  \      \
        40   50     60
```

Here:
- 10 is the Root Node.
- 20 and 30 are children of 10.
- 10 is the parent of 20 and 30.
- 40, 50 and 60 are Leaf Nodes.
- Connections between nodes are called Edges.

---

# 2. Tree Terminologies

| Terminology | Definition |
|---|---|
| Node | Individual element of a tree |
| Root | Topmost node |
| Parent | Node having children |
| Child | Node directly connected below a parent |
| Sibling | Nodes having the same parent |
| Leaf Node | Node having zero children |
| Internal Node | Node having at least one child |
| Edge | Connection between two nodes |
| Degree | Number of children of a node |
| Path | Sequence of connected nodes |
| Ancestor | Parent, grandparent, etc. |
| Descendant | Child, grandchild, etc. |
| Subtree | Smaller tree inside a tree |
| Depth | Number of edges from root to a node |
| Height | Maximum number of edges from a node to a leaf |

---

# 3. Properties of Tree

1. A tree with N nodes has exactly N - 1 edges.
2. A tree has exactly one root node.
3. Every node except the root has exactly one parent.
4. A tree does not contain cycles.
5. Every node is reachable from the root.

---

# 4. Types of Trees

## 4.1 General Tree

A tree in which a node can have any number of children.

## 4.2 Binary Tree

A tree in which each node can have at most two children:

- Left Child
- Right Child

```text
          10
         /  \
        20   30
       / \
      40  50
```

## 4.3 Full Binary Tree

A binary tree in which every node has either:

- Zero children
- Exactly two children

```text
          10
         /  \
        20   30
       / \
      40  50
```

## 4.4 Complete Binary Tree

A binary tree in which:

- Every level except possibly the last level is completely filled.
- The last level is filled from left to right.

## 4.5 Perfect Binary Tree

A binary tree in which:

- Every internal node has exactly two children.
- All leaf nodes are at the same level.

## 4.6 Skewed Binary Tree

A binary tree in which every node has only one child.

**Left Skewed Tree**

```text
       10
      /
     20
    /
   30
  /
 40
```

**Right Skewed Tree**

```text
  10
    \
     20
       \
        30
          \
           40
```

## 4.7 Balanced Binary Tree

A height-balanced binary tree is one in which the heights of the left and right subtrees differ by at most 1 at every node.

Examples:

- AVL Tree

### Difference Between Types of Binary Trees

| Type | Main Condition |
|---|---|
| Full | Every node has 0 or 2 children |
| Complete | Last level fills from left to right |
| Perfect | All levels completely filled |
| Balanced | Left and right subtree heights remain close |
| Skewed | Every node has only one child |

---

# 5. Tree Traversal

Tree Traversal means visiting every node of a tree exactly once in a specific order.

There are two major categories:

### 1. Depth First Search (DFS)

- Preorder
- Inorder
- Postorder

### 2. Breadth First Search (BFS)

- Level Order Traversal

---

# 6. Depth First Search (DFS)

DFS explores a branch as deeply as possible before backtracking.

Consider the following tree:

```text
             1
           /   \
          2     3
         / \   / \
        4   5 6   7
```

## 6.1 Preorder Traversal

**Rule: Root → Left → Right**

### Algorithm

1. Visit the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.

### Pseudocode

```text
PREORDER(root)

1. If root == NULL
       return

2. Print root.data

3. PREORDER(root.left)

4. PREORDER(root.right)
```

### Java Code

```java
void preorder(Node root) {

    if(root == null)
        return;

    System.out.print(root.data + " ");

    preorder(root.left);

    preorder(root.right);
}
```

**Output:**

```text
1 2 4 5 3 6 7
```

## 6.2 Inorder Traversal

**Rule: Left → Root → Right**

### Algorithm

1. Traverse the left subtree.
2. Visit the root node.
3. Traverse the right subtree.

### Pseudocode

```text
INORDER(root)

1. If root == NULL
       return

2. INORDER(root.left)

3. Print root.data

4. INORDER(root.right)
```

### Java Code

```java
void inorder(Node root) {

    if(root == null)
        return;

    inorder(root.left);

    System.out.print(root.data + " ");

    inorder(root.right);
}
```

**Output:**

```text
4 2 5 1 6 3 7
```

## 6.3 Postorder Traversal

**Rule: Left → Right → Root**

### Algorithm

1. Traverse the left subtree.
2. Traverse the right subtree.
3. Visit the root node.

### Pseudocode

```text
POSTORDER(root)

1. If root == NULL
       return

2. POSTORDER(root.left)

3. POSTORDER(root.right)

4. Print root.data
```

### Java Code

```java
void postorder(Node root) {

    if(root == null)
        return;

    postorder(root.left);

    postorder(root.right);

    System.out.print(root.data + " ");
}
```

**Output:**

```text
4 5 2 6 7 3 1
```

### Difference Between Traversals

| Traversal | Order | Output |
|---|---|---|
| Preorder | Root Left Right | 1 2 4 5 3 6 7 |
| Inorder | Left Root Right | 4 2 5 1 6 3 7 |
| Postorder | Left Right Root | 4 5 2 6 7 3 1 |

**Easy Trick:**

- Preorder: Root comes first.
- Inorder: Root comes in the middle.
- Postorder: Root comes last.

---

# 7. Level Order Traversal (BFS)

Level Order Traversal visits nodes level by level, from left to right.

It uses a **Queue** data structure.

### Algorithm

1. Insert root into the queue.
2. While the queue is not empty:
   - Remove the front node.
   - Print its value.
   - Insert its left child if present.
   - Insert its right child if present.

### Java Code

```java
void levelOrder(Node root) {

    if(root == null)
        return;

    Queue<Node> q = new LinkedList<>();

    q.add(root);

    while(!q.isEmpty()) {

        Node curr = q.poll();

        System.out.print(curr.data + " ");

        if(curr.left != null)
            q.add(curr.left);

        if(curr.right != null)
            q.add(curr.right);
    }
}
```

**Output:**

```text
1 2 3 4 5 6 7
```

---

# 8. Example

Consider the following tree:

```text
                 10
               /    \
              20     30
             /  \      \
            40   50     60
                /      /  \
               70     80   90
```

### Traversal Outputs

| Traversal | Result |
|---|---|
| Preorder | 10 20 40 50 70 30 60 80 90 |
| Inorder | 40 20 70 50 10 30 80 60 90 |
| Postorder | 40 70 50 20 80 90 60 30 10 |
| Level Order | 10 20 30 40 50 60 70 80 90 |

### Preorder Dry Run

Rule: Root → Left → Right

```text
Visit 10
   |
Go Left (20)
   |
Go Left (40)
   |
Return to 20
   |
Go Right (50)
   |
Go Left (70)
   |
Return to 10
   |
Go Right (30)
   |
Go Right (60)
   |
Visit 80, then 90
```

Final Output:

```text
10 20 40 50 70 30 60 80 90
```

---

# 9. Example

Consider a Binary Tree with 15 nodes:

```text
                    50
                 /      \
               30        80
              /  \      /  \
            20    40   70   90
           / \   / \   / \  / \
          10 25 35 45 60 75 85 95
```

### Traversal Outputs

| Traversal | Result |
|---|---|
| Preorder | 50 30 20 10 25 40 35 45 80 70 60 75 90 85 95 |
| Inorder | 10 20 25 30 35 40 45 50 60 70 75 80 85 90 95 |
| Postorder | 10 25 20 35 45 40 30 60 75 70 85 95 90 80 50 |
| Level Order | 50 30 80 20 40 70 90 10 25 35 45 60 75 85 95 |

**Important Observation:**

This tree also follows the Binary Search Tree property. Therefore, its Inorder Traversal produces sorted output.

---

# 10. Time and Space Complexity of Tree Traversals

Let:

- N = Number of nodes
- H = Height of tree
- W = Maximum width of tree

| Traversal | Time Complexity | Auxiliary Space |
|---|---|---|
| Preorder | O(N) | O(H) |
| Inorder | O(N) | O(H) |
| Postorder | O(N) | O(H) |
| Level Order | O(N) | O(W) |

---

# 11. Binary Search Tree (BST)

A **Binary Search Tree** is a special type of Binary Tree that follows a specific ordering property.

### BST Property

For every node:

1. All values in the left subtree are smaller than the root.
2. All values in the right subtree are greater than the root.
3. Both left and right subtrees must also follow BST properties.

## Example

```text
                 50
               /    \
             30      70
            /  \    /  \
           20  40  60  80
```

## Why Do We Need BST?

BST organizes data in a hierarchical manner so that searching can eliminate one subtree at every comparison.

**Real-World Example:**

Imagine searching for a student roll number in an organized record system.

- If the target is smaller, search the left side.
- If the target is greater, search the right side.
- If it matches, the element is found.

---

# 12. BST Node Structure in Java

```java
class Node {

    int data;

    Node left;
    Node right;

    Node(int data) {

        this.data = data;

        left = null;
        right = null;
    }
}
```

---

# 13. BST Insertion

Insertion means adding a new node at its correct position while maintaining the BST property.

### Example

Insert the following values:

```text
50, 30, 70, 20, 40, 60, 80
```

Final BST:

```text
                 50
               /    \
             30      70
            /  \    /  \
           20  40  60  80
```

### Algorithm

1. If root is NULL, create a new node.
2. If new value is smaller than root, insert into left subtree.
3. If new value is greater than root, insert into right subtree.
4. Return the root.

### Pseudocode

```text
INSERT(root, value)

1. If root == NULL
       return NEW NODE(value)

2. If value < root.data
       root.left = INSERT(root.left, value)

3. Else if value > root.data
       root.right = INSERT(root.right, value)

4. Return root
```

### Java Code

```java
Node insert(Node root, int value) {

    if(root == null)
        return new Node(value);

    if(value < root.data) {

        root.left = insert(root.left, value);
    }

    else if(value > root.data) {

        root.right = insert(root.right, value);
    }

    return root;
}
```

### Dry Run

Insert 40:

```text
                 50
               /
             30
               \
                40
```

1. Compare 40 with 50.
2. 40 is smaller, go left.
3. Compare 40 with 30.
4. 40 is greater, go right.
5. Right position is empty.
6. Insert 40.

---

# 14. BST Searching

Searching means finding whether a particular value exists in BST.

### Algorithm

1. If root is NULL, return false.
2. If target equals root.data, return true.
3. If target is smaller, search left subtree.
4. Otherwise, search right subtree.

### Pseudocode

```text
SEARCH(root, key)

1. If root == NULL
       return false

2. If root.data == key
       return true

3. If key < root.data
       return SEARCH(root.left, key)

4. Else
       return SEARCH(root.right, key)
```

### Java Code

```java
boolean search(Node root, int key) {

    if(root == null)
        return false;

    if(root.data == key)
        return true;

    if(key < root.data)
        return search(root.left, key);

    return search(root.right, key);
}
```

### Dry Run

Search 60:

```text
                 50
               /    \
             30      70
                    /
                   60
```

| Step | Comparison | Action |
|---|---|---|
| 1 | 60 > 50 | Go Right |
| 2 | 60 < 70 | Go Left |
| 3 | 60 == 60 | Found |

---

# 15. BST Deletion

Deletion means removing a node from BST without violating the BST property.

There are three cases.

### Case 1: Deleting a Leaf Node

A leaf node has no children.

Example: Delete 20.

Before:

```text
        50
       /
      30
     /
    20
```

After:

```text
        50
       /
      30
```

Simply remove the node.

### Case 2: Deleting a Node with One Child

Example: Delete 30.

Before:

```text
        50
       /
      30
        \
         40
```

After:

```text
        50
       /
      40
```

Replace the deleted node with its only child.

### Case 3: Deleting a Node with Two Children

Example: Delete 50.

Before:

```text
          50
        /    \
       30     70
      / \    / \
     20 40  60 80
```

We use either:

- Inorder Successor: Smallest value in right subtree.
- Inorder Predecessor: Largest value in left subtree.

Using Inorder Successor:

1. Find the smallest node in the right subtree.
2. Copy its value into the node being deleted.
3. Delete the successor from the right subtree.

After:

```text
          60
        /    \
       30     70
      / \       \
     20 40       80
```

### Deletion Algorithm

```text
DELETE(root, key)

1. If root == NULL
       return NULL

2. If key < root.data
       root.left = DELETE(root.left, key)

3. Else if key > root.data
       root.right = DELETE(root.right, key)

4. Else:

       If root.left == NULL
           return root.right

       If root.right == NULL
           return root.left

       temp = MINIMUM(root.right)

       root.data = temp.data

       root.right = DELETE(root.right, temp.data)

5. Return root
```

### Java Code

```java
Node delete(Node root, int key) {

    if(root == null)
        return null;

    if(key < root.data) {

        root.left = delete(root.left, key);
    }

    else if(key > root.data) {

        root.right = delete(root.right, key);
    }

    else {

        if(root.left == null)
            return root.right;

        if(root.right == null)
            return root.left;

        Node temp = minValue(root.right);

        root.data = temp.data;

        root.right = delete(root.right, temp.data);
    }

    return root;
}

Node minValue(Node root) {

    while(root.left != null) {

        root = root.left;
    }

    return root;
}
```

---

# 16. Finding Minimum and Maximum in BST

### Minimum Value

The minimum value is always present in the leftmost node of a BST.

```java
Node findMin(Node root) {

    if(root == null)
        return null;

    while(root.left != null) {

        root = root.left;
    }

    return root;
}
```

### Maximum Value

The maximum value is always present in the rightmost node of a BST.

```java
Node findMax(Node root) {

    if(root == null)
        return null;

    while(root.right != null) {

        root = root.right;
    }

    return root;
}
```

Example:

```text
             50
           /    \
         30      70
        /  \    /  \
       20  40  60  80
```

- Minimum = 20
- Maximum = 80

---

# 17. BST Traversal

Consider:

```text
             50
           /    \
         30      70
        /  \    /  \
       20  40  60  80
```

| Traversal | Output |
|---|---|
| Preorder | 50 30 20 40 70 60 80 |
| Inorder | 20 30 40 50 60 70 80 |
| Postorder | 20 40 30 60 80 70 50 |
| Level Order | 50 30 70 20 40 60 80 |

**Important Point:**

Inorder traversal of a BST produces values in sorted ascending order, assuming distinct keys.

---


# 18. Time Complexity of BST Operations

Let N = Number of nodes and H = Height of the tree.

| Operation | Average Case | Worst Case |
|---|---|---|
| Insertion | O(log N) | O(N) |
| Searching | O(log N) | O(N) |
| Deletion | O(log N) | O(N) |
| Find Minimum | O(log N) | O(N) |
| Find Maximum | O(log N) | O(N) |
| Traversal | O(N) | O(N) |

## Why Does BST Have O(N) Worst-Case Complexity

Because an unbalanced BST can become a skewed tree.

```text
10
  \
   20
     \
      30
        \
         40
           \
            50
```

Searching for 50 requires checking all five nodes.

Therefore, worst-case searching complexity is O(N).

---

# 20. Complete Java BST Program

This program combines:

- Insertion
- Searching
- Deletion
- Inorder Traversal

```java
class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class BST {

    Node root;

    Node insert(Node root, int value) {

        if(root == null)
            return new Node(value);

        if(value < root.data)
            root.left = insert(root.left, value);

        else if(value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    boolean search(Node root, int key) {

        if(root == null)
            return false;

        if(root.data == key)
            return true;

        if(key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    void inorder(Node root) {

        if(root == null)
            return;

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    Node minValue(Node root) {

        while(root.left != null)
            root = root.left;

        return root;
    }

    Node delete(Node root, int key) {

        if(root == null)
            return null;

        if(key < root.data)
            root.left = delete(root.left, key);

        else if(key > root.data)
            root.right = delete(root.right, key);

        else {

            if(root.left == null)
                return root.right;

            if(root.right == null)
                return root.left;

            Node temp = minValue(root.right);

            root.data = temp.data;

            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    public static void main(String[] args) {

        BST tree = new BST();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Inorder:");
        tree.inorder(tree.root);

        System.out.println("\nSearch 60:");
        System.out.println(tree.search(tree.root, 60));

        tree.root = tree.delete(tree.root, 30);

        System.out.println("After Deletion:");
        tree.inorder(tree.root);
    }
}
```

### Expected Output

```text
Inorder:
20 30 40 50 60 70 80

Search 60:
true

After Deletion:
20 40 50 60 70 80
```

---