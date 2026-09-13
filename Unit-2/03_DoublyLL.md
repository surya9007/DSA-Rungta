# Doubly Linked List

## 1. Introduction

A **Doubly Linked List** is a linear data structure made up of nodes.

Each node contains three parts:

```text
1. Previous reference
2. Data
3. Next reference
```

Example:

```text
NULL ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → NULL
```

In a doubly linked list, every node knows both:

```text
Previous node
Next node
```

Because of this, traversal is possible in both directions.

---

# 2. Definition

A **Doubly Linked List** is a linked data structure in which each node contains a reference to both the previous node and the next node.

General structure:

```text
NULL ← [10] ⇄ [20] ⇄ [30] → NULL
```

The first node has:

```text
prev = null
```

The last node has:

```text
next = null
```

---

# 3. Structure of a Node

A node contains:

```text
┌────────┬────────┬────────┐
│  Prev  │  Data  │  Next  │
└────────┴────────┴────────┘
```

Java representation:

```java
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
```

---

# 4. Why is it Called Doubly Linked List?

It is called a doubly linked list because every node has two links:

```text
1. Link to previous node
2. Link to next node
```

Example:

```text
10 ⇄ 20 ⇄ 30
```

Node `20` stores:

```text
prev → 10
next → 30
```

This allows movement in both directions.

---

# 5. Head and Tail

A doubly linked list may use two references:

```text
head
tail
```

`head` points to the first node.

`tail` points to the last node.

Example:

```text
head                     tail
 ↓                        ↓
10 ⇄ 20 ⇄ 30 ⇄ 40
```

If the list is empty:

```text
head = null
tail = null
```

---

# 6. Singly Linked List vs Doubly Linked List

| Singly Linked List     | Doubly Linked List                    |
| ---------------------- | ------------------------------------- |
| One link per node      | Two links per node                    |
| Only next reference    | Previous and next references          |
| Forward traversal only | Forward and backward traversal        |
| Less memory            | More memory                           |
| Deletion can be harder | Deletion is easier when node is known |
| Simpler implementation | More pointer management               |

---

# 7. Advantages of Doubly Linked List

## Bidirectional Traversal

We can move:

```text
Forward
Backward
```

Example:

```text
10 → 20 → 30
```

and:

```text
30 → 20 → 10
```

---

## Easier Deletion

If a node reference is already known, it is easier to remove because we can access both:

```text
node.prev
node.next
```

---

## Easy Reverse Traversal

Using the `prev` reference, reverse traversal is direct.

---

## Useful for Navigation

Applications such as:

```text
Browser history
Undo/Redo
Music playlist
Image viewer
```

often benefit from two-way movement.

---

# 8. Disadvantages of Doubly Linked List

## Extra Memory

Every node requires one extra pointer:

```text
prev
```

So it uses more memory than a singly linked list.

---

## More Complex

While inserting or deleting a node, both references may need to be updated:

```text
prev
next
```

Incorrect pointer updates can break the list.

---

## More Pointer Operations

A single insertion may require multiple reference changes.

---

# 9. Main Operations

Important operations are:

```text
1. Traversal forward
2. Traversal backward
3. Insert at beginning
4. Insert at end
5. Insert at position
6. Delete from beginning
7. Delete from end
8. Delete by value
9. Search
```

---

# 10. Forward Traversal

Suppose:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

We start from:

```text
head
```

and move using:

```text
current = current.next
```

Code:

```java
void displayForward() {
    Node current = head;

    while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
    }
}
```

Time Complexity:

```text
O(n)
```

---

# 11. Backward Traversal

For backward traversal, start from the last node.

Using a `tail` reference:

```text
tail
 ↓
40 ⇄ 30 ⇄ 20 ⇄ 10
```

Move using:

```text
current = current.prev
```

Code:

```java
void displayBackward() {
    Node current = tail;

    while (current != null) {
        System.out.print(current.data + " ");
        current = current.prev;
    }
}
```

Time Complexity:

```text
O(n)
```

---

# 12. Insertion at Beginning

Suppose:

```text
10 ⇄ 20 ⇄ 30
```

Insert:

```text
5
```

Result:

```text
5 ⇄ 10 ⇄ 20 ⇄ 30
```

We need to update both directions.

Important links:

```text
newNode.next = head
head.prev = newNode
head = newNode
```

If the list is empty:

```text
head = newNode
tail = newNode
```

Code:

```java
void insertFirst(int data) {
    Node newNode = new Node(data);

    if (head == null) {
        head = tail = newNode;
        return;
    }

    newNode.next = head;
    head.prev = newNode;
    head = newNode;
}
```

Time Complexity:

```text
O(1)
```

---

# 13. Insertion at End

Suppose:

```text
10 ⇄ 20 ⇄ 30
```

Insert:

```text
40
```

Result:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Using `tail`, insertion is easy.

Important links:

```text
tail.next = newNode
newNode.prev = tail
tail = newNode
```

Code:

```java
void insertLast(int data) {
    Node newNode = new Node(data);

    if (tail == null) {
        head = tail = newNode;
        return;
    }

    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
}
```

Time Complexity:

```text
O(1)
```

because `tail` directly gives the last node.

---

# 14. Insertion in Middle

Suppose:

```text
10 ⇄ 20 ⇄ 30
```

Insert:

```text
25
```

between `20` and `30`.

Result:

```text
10 ⇄ 20 ⇄ 25 ⇄ 30
```

Four important connections may be involved:

```text
newNode.prev = current
newNode.next = current.next
current.next.prev = newNode
current.next = newNode
```

The important idea is:

```text
20 ⇄ 30
```

becomes:

```text
20 ⇄ 25 ⇄ 30
```

Time Complexity:

```text
O(n)
```

if we first have to search for the position.

---

# 15. Deletion from Beginning

Suppose:

```text
10 ⇄ 20 ⇄ 30
```

Delete first node.

Result:

```text
20 ⇄ 30
```

Logic:

```text
head = head.next
head.prev = null
```

Special case: if only one node exists:

```text
head = null
tail = null
```

Code:

```java
void deleteFirst() {
    if (head == null) {
        return;
    }

    if (head == tail) {
        head = tail = null;
        return;
    }

    head = head.next;
    head.prev = null;
}
```

Time Complexity:

```text
O(1)
```

---

# 16. Deletion from End

Suppose:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Delete:

```text
40
```

Result:

```text
10 ⇄ 20 ⇄ 30
```

Using `tail`, this is simple.

Logic:

```text
tail = tail.prev
tail.next = null
```

Code:

```java
void deleteLast() {
    if (tail == null) {
        return;
    }

    if (head == tail) {
        head = tail = null;
        return;
    }

    tail = tail.prev;
    tail.next = null;
}
```

Time Complexity:

```text
O(1)
```

---

# 17. Delete a Specific Node

Suppose:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Delete:

```text
30
```

Result:

```text
10 ⇄ 20 ⇄ 40
```

Before deletion:

```text
20 ⇄ 30 ⇄ 40
```

After deletion:

```text
20 ⇄ 40
```

Important logic:

```text
node.prev.next = node.next
node.next.prev = node.prev
```

This is one of the biggest advantages of a doubly linked list.

Both neighboring nodes can directly be connected.

---

# 18. Delete by Value

We first search for the node containing the required value.

Then there can be three cases:

```text
1. Node is first node
2. Node is last node
3. Node is a middle node
```

Code:

```java
void deleteByValue(int value) {
    Node current = head;

    while (current != null && current.data != value) {
        current = current.next;
    }

    if (current == null) {
        return;
    }

    if (current == head) {
        deleteFirst();
    } else if (current == tail) {
        deleteLast();
    } else {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
}
```

Time Complexity:

```text
O(n)
```

because searching may require traversal.

---

# 19. Searching

Searching is similar to singly linked list.

Example:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Search:

```text
30
```

Start from head and compare one by one.

Code:

```java
boolean search(int value) {
    Node current = head;

    while (current != null) {
        if (current.data == value) {
            return true;
        }

        current = current.next;
    }

    return false;
}
```

Time Complexity:

```text
O(n)
```

---

# 20. Empty Doubly Linked List

An empty list is represented as:

```text
head = null
tail = null
```

Diagram:

```text
head → NULL
tail → NULL
```

Before deletion, always check whether the list is empty.

---

# 21. Single Node Doubly Linked List

Example:

```text
NULL ← 10 → NULL
```

For this node:

```text
prev = null
next = null
```

Also:

```text
head == tail
```

If this node is deleted:

```text
head = null
tail = null
```

---

# 22. Important Pointer Relationships

For a normal middle node:

```text
A ⇄ B ⇄ C
```

For node `B`:

```text
B.prev = A
B.next = C
```

For `A`:

```text
A.next = B
```

For `C`:

```text
C.prev = B
```

These relationships are the foundation of the doubly linked list.

---

# 23. Why Deletion is Easier than Singly Linked List

Suppose we already have a reference to:

```text
30
```

In singly linked list:

```text
10 → 20 → 30 → 40
```

we often need the previous node `20` to delete `30`.

But in a doubly linked list:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

node `30` itself gives:

```text
30.prev → 20
30.next → 40
```

So we can directly reconnect:

```text
20 ⇄ 40
```

This is a major advantage.

---

# 24. Memory Representation

Nodes do not need to be stored continuously in memory.

For example:

```text
Node 10 at memory 500
Node 20 at memory 900
Node 30 at memory 650
```

They are still logically connected using:

```text
prev
next
```

Therefore physical memory location does not decide the list order.

---

# 25. Complete Combined Java Program

```java
public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    // Insert at beginning
    void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    void insertLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Delete first
    void deleteFirst() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // Delete last
    void deleteLast() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // Delete by value
    void deleteByValue(int value) {
        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) return;

        if (current == head) {
            deleteFirst();
        } else if (current == tail) {
            deleteLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Search
    boolean search(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Forward traversal
    void displayForward() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // Backward traversal
    void displayBackward() {
        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        DoublyLinkedList list =
            new DoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);

        list.insertLast(30);
        list.insertLast(40);

        System.out.println("Forward:");
        list.displayForward();

        System.out.println("Backward:");
        list.displayBackward();

        list.deleteFirst();

        System.out.println("After Delete First:");
        list.displayForward();

        list.deleteLast();

        System.out.println("After Delete Last:");
        list.displayForward();

        list.deleteByValue(20);

        System.out.println("After Delete 20:");
        list.displayForward();

        System.out.println(
            "Search 30: " + list.search(30)
        );
    }
}
```

---

# 26. Expected Output

```text
Forward:
10 <-> 20 <-> 30 <-> 40 <-> NULL

Backward:
40 <-> 30 <-> 20 <-> 10 <-> NULL

After Delete First:
20 <-> 30 <-> 40 <-> NULL

After Delete Last:
20 <-> 30 <-> NULL

After Delete 20:
30 <-> NULL

Search 30: true
```

---

# 27. Time Complexity

| Operation                 | Complexity |
| ------------------------- | ---------: |
| Insert at beginning       |       O(1) |
| Insert at end with tail   |       O(1) |
| Delete from beginning     |       O(1) |
| Delete from end with tail |       O(1) |
| Search                    |       O(n) |
| Traversal                 |       O(n) |
| Insert at position        |       O(n) |
| Delete by value           |       O(n) |

---

# 28. Space Complexity

For `n` nodes:

```text
O(n)
```

However, each node contains:

```text
Data
Previous reference
Next reference
```

So the memory required per node is greater than in a singly linked list.

---

# 29. Applications of Doubly Linked List

## Browser History

A user can move:

```text
Back
Forward
```

---

## Undo and Redo

Applications can move between previous and next states.

---

## Music Playlist

We can move:

```text
Previous Song
Next Song
```

---

## Image Viewer

Navigation can happen in both directions.

---

## LRU Cache

Doubly linked lists are commonly used with hash maps to implement efficient LRU caching.

---

## Deque

Insertion and deletion can be performed efficiently from both ends when head and tail are maintained.

---

# 30. Advantages

Main advantages:

```text
1. Forward traversal
2. Backward traversal
3. Easy deletion when node is known
4. O(1) insertion at beginning
5. O(1) insertion at end with tail
6. O(1) deletion at both ends with head and tail
```

---

# 31. Disadvantages

Main disadvantages:

```text
1. Extra memory for prev pointer
2. More pointer updates
3. More complex than singly linked list
4. Incorrect reference handling can break the list
```

---

