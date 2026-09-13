# Circular Linked List

## 1. Introduction

A **Circular Linked List** is a linked list in which the last node does not point to `NULL`.

Instead, the last node points back to the first node.

Example:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

So the list forms a circle.

In a normal singly linked list:

```text
10 → 20 → 30 → NULL
```

But in a circular linked list:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

The last node again points to the first node.

---

# 2. Definition

A **Circular Linked List** is a linked data structure in which the last node is connected back to the first node instead of pointing to `NULL`.

The important condition is:

```text
last.next = head
```

This connection makes the list circular.

---

# 3. Structure of a Node

A circular singly linked list uses the same node structure as a singly linked list.

Each node contains:

```text
1. Data
2. Next reference
```

Node structure:

```text
┌─────────┬─────────┐
│  Data   │  Next   │
└─────────┴─────────┘
```

Java:

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
```

---

# 4. Main Difference from Singly Linked List

In a singly linked list, the last node contains:

```text
next = null
```

In a circular linked list, the last node contains:

```text
next = head
```

Example:

### Singly Linked List

```text
10 → 20 → 30 → NULL
```

### Circular Linked List

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

---

# 5. Why Is It Called Circular?

It is called circular because the nodes form a closed loop.

Suppose we start from the first node:

```text
10
```

Then move:

```text
10 → 20 → 30 → 40
```

After `40`, we again reach:

```text
10
```

So traversal can continue repeatedly.

---

# 6. Important Property

The most important property is:

```text
Last Node.next = Head
```

This should always be remembered.

For example:

```text
head
 ↓
10 → 20 → 30
↑         ↓
└─────────┘
```

Here:

```text
30.next = 10
```

---

# 7. Types of Circular Linked List

There are mainly two types:

```text
1. Circular Singly Linked List
2. Circular Doubly Linked List
```

---

# 8. Circular Singly Linked List

Each node contains:

```text
Data
Next
```

The last node points to the first node.

Example:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

Traversal is mainly forward.

---

# 9. Circular Doubly Linked List

Each node contains:

```text
Prev
Data
Next
```

The last node's next points to the first node.

The first node's previous points to the last node.

Example:

```text
10 ⇄ 20 ⇄ 30
↑           ↓
└───────────┘
```

Important relationships:

```text
last.next = head
head.prev = last
```

This allows movement in both directions.

---

# 10. Why Use Circular Linked List?

A circular linked list is useful when data has to be processed repeatedly in a cyclic manner.

Examples:

```text
CPU scheduling
Round Robin scheduling
Music playlist
Multiplayer games
Turn-based systems
Circular queue
Repeated task management
```

---

# 11. Head and Tail

A circular linked list may maintain:

```text
head
tail
```

`head` points to the first node.

`tail` points to the last node.

Example:

```text
head              tail
 ↓                 ↓
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Important condition:

```text
tail.next = head
```

---

# 12. Empty Circular Linked List

If there are no nodes:

```text
head = null
tail = null
```

There is no circular connection yet.

---

# 13. Single Node Circular Linked List

Suppose only one node exists:

```text
10
```

Because the list is circular:

```text
10
↑ ↓
└─┘
```

The node points to itself.

So:

```text
head.next = head
```

If `tail` is maintained:

```text
head == tail
tail.next == head
```

---

# 14. Traversal

Traversal in a circular linked list is different from a normal linked list.

In a normal linked list, we stop when:

```text
current == null
```

But in a circular linked list, `current` will not become `null`.

So we stop when we reach the first node again.

Condition:

```text
current == head
```

---

# 15. Traversal Logic

Suppose:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

Start at:

```text
10
```

Visit:

```text
10
20
30
```

Then `current.next` becomes `10` again.

At that point, traversal must stop.

---

# 16. Why do-while is Useful?

A `do-while` loop is commonly used because the first node must be processed at least once.

Example:

```java
void display() {
    if (head == null) return;

    Node current = head;

    do {
        System.out.print(current.data + " ");
        current = current.next;
    } while (current != head);
}
```

This is an important circular linked list pattern.

---

# 17. Insertion at Beginning

Suppose:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

Insert:

```text
5
```

Result:

```text
5 → 10 → 20 → 30
↑              ↓
└──────────────┘
```

The new node becomes the new head.

Important updates:

```text
newNode.next = head
head = newNode
tail.next = head
```

---

# 18. Insertion at Beginning - Special Case

If list is empty:

```text
head = null
```

Create new node.

Then:

```text
head = newNode
tail = newNode
newNode.next = newNode
```

Because the single node must point to itself.

---

# 19. Insertion at Beginning Code

```java
void insertFirst(int data) {
    Node newNode = new Node(data);

    if (head == null) {
        head = tail = newNode;
        newNode.next = newNode;
        return;
    }

    newNode.next = head;
    head = newNode;
    tail.next = head;
}
```

Time Complexity:

```text
O(1)
```

when `tail` is maintained.

---

# 20. Insertion at End

Suppose:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

Insert:

```text
40
```

Result:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Important updates:

```text
tail.next = newNode
newNode.next = head
tail = newNode
```

---

# 21. Insertion at End Code

```java
void insertLast(int data) {
    Node newNode = new Node(data);

    if (head == null) {
        head = tail = newNode;
        newNode.next = newNode;
        return;
    }

    tail.next = newNode;
    newNode.next = head;
    tail = newNode;
}
```

Time Complexity:

```text
O(1)
```

when `tail` is maintained.

---

# 22. Insertion at a Specific Position

Suppose:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Insert:

```text
25
```

between `20` and `30`.

Result:

```text
10 → 20 → 25 → 30 → 40
↑                   ↓
└───────────────────┘
```

The insertion logic for a middle position is similar to a singly linked list.

Important links:

```text
newNode.next = current.next
current.next = newNode
```

The circular connection must remain valid after insertion.

---

# 23. Deletion from Beginning

Suppose:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

Delete first node.

Result:

```text
20 → 30
↑    ↓
└────┘
```

Important updates:

```text
head = head.next
tail.next = head
```

Because `tail` must now point to the new head.

---

# 24. Delete First Code

```java
void deleteFirst() {
    if (head == null) return;

    if (head == tail) {
        head = tail = null;
        return;
    }

    head = head.next;
    tail.next = head;
}
```

Time Complexity:

```text
O(1)
```

---

# 25. Deletion from End

Suppose:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Delete `40`.

Result:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

Since it is a singly circular linked list, we have to find the node before the tail.

So traversal is required.

---

# 26. Delete Last Logic

Suppose:

```text
current.next == tail
```

Then:

```text
tail = current
tail.next = head
```

This removes the old last node and restores the circular connection.

---

# 27. Delete Last Code

```java
void deleteLast() {
    if (head == null) return;

    if (head == tail) {
        head = tail = null;
        return;
    }

    Node current = head;

    while (current.next != tail) {
        current = current.next;
    }

    tail = current;
    tail.next = head;
}
```

Time Complexity:

```text
O(n)
```

---

# 28. Deletion by Value

Suppose:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Delete:

```text
30
```

Result:

```text
10 → 20 → 40
↑         ↓
└─────────┘
```

We need to find the node before the target node.

Then:

```text
previous.next = target.next
```

---

# 29. Special Cases in Deletion

While deleting by value, consider:

```text
1. List is empty
2. Only one node exists
3. First node is deleted
4. Last node is deleted
5. Middle node is deleted
```

These cases are important in practical coding.

---

# 30. Searching

Searching is similar to traversal.

Suppose:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Search:

```text
30
```

We start from `head`.

Check:

```text
10
20
30
```

If found, return true.

If we reach `head` again, the element is not present.

---

# 31. Search Code

```java
boolean search(int value) {
    if (head == null) return false;

    Node current = head;

    do {
        if (current.data == value) {
            return true;
        }

        current = current.next;

    } while (current != head);

    return false;
}
```

Time Complexity:

```text
O(n)
```

---

# 32. Counting Nodes

We can count nodes by traversing from the head until we reach the head again.

Example:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Count:

```text
4
```

Time Complexity:

```text
O(n)
```

---

# 33. Singly Linked List vs Circular Linked List

| Singly Linked List              | Circular Linked List                      |
| ------------------------------- | ----------------------------------------- |
| Last node points to NULL        | Last node points to head                  |
| Has clear end                   | Forms a loop                              |
| Traversal ends at NULL          | Traversal ends when head is reached again |
| Suitable for one-time traversal | Suitable for cyclic processing            |
| `while(current != null)`        | often `do-while(current != head)`         |

---

# 34. Circular Singly vs Circular Doubly Linked List

| Circular Singly   | Circular Doubly                       |
| ----------------- | ------------------------------------- |
| One link          | Two links                             |
| Forward traversal | Forward and backward traversal        |
| Less memory       | More memory                           |
| Simpler           | More complex                          |
| Last.next = head  | Last.next = head and head.prev = last |

---

# 35. Advantages of Circular Linked List

## 1. Continuous Traversal

Traversal can continue repeatedly without restarting manually.

---

## 2. Useful for Cyclic Tasks

Circular lists naturally represent repeated cycles.

Example:

```text
Player 1
Player 2
Player 3
Player 1
...
```

---

## 3. Efficient Queue Implementation

With a tail pointer, insertion at end and access to front can be efficient.

---

## 4. No NULL at End

The last node directly connects back to the first node.

---

## 5. Useful in Round Robin Scheduling

Each process can get its turn repeatedly in a circular order.

---

# 36. Disadvantages

## 1. Traversal is More Careful

If the stopping condition is wrong, traversal may become infinite.

---

## 2. More Difficult Debugging

There is no natural `NULL` at the end.

---

## 3. Pointer Handling

Incorrect links can break the circular structure.

---

## 4. Deletion from End can be O(n)

In a singly circular linked list, the node before the last node has to be found.

---

# 37. Time Complexity

| Operation                     | Complexity |
| ----------------------------- | ---------: |
| Insert at beginning with tail |       O(1) |
| Insert at end with tail       |       O(1) |
| Delete first                  |       O(1) |
| Delete last                   |       O(n) |
| Search                        |       O(n) |
| Traversal                     |       O(n) |
| Insert at position            |       O(n) |
| Delete by value               |       O(n) |

---

# 38. Space Complexity

For `n` nodes:

```text
O(n)
```

Each node stores:

```text
Data
Next reference
```

So total memory increases according to the number of nodes.

---

# 39. Applications

Circular linked lists are commonly used in:

```text
1. Round Robin CPU scheduling
2. Circular queue
3. Multiplayer turn systems
4. Music playlists
5. Slide shows
6. Repeating task schedulers
7. Token passing networks
8. Repeated resource allocation
```

---

# 40. Round Robin Example

Suppose three processes exist:

```text
P1 → P2 → P3
↑         ↓
└─────────┘
```

Execution order:

```text
P1
P2
P3
P1
P2
P3
...
```

This is naturally represented using a circular linked list.

---

# 41. Complete Combined Java Program

```java
public class CircularLinkedList {

    class Node {
        int data;
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
            newNode.next = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // Insert at end
    void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
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
        tail.next = head;
    }

    // Delete last
    void deleteLast() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        tail = current;
        tail.next = head;
    }

    // Search
    boolean search(int value) {
        if (head == null) return false;

        Node current = head;

        do {
            if (current.data == value) {
                return true;
            }

            current = current.next;

        } while (current != head);

        return false;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;

        } while (current != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {

        CircularLinkedList list =
            new CircularLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);

        list.insertLast(30);
        list.insertLast(40);

        System.out.println("Circular List:");
        list.display();

        System.out.println(
            "Search 30: " + list.search(30)
        );

        list.deleteFirst();

        System.out.println("After Delete First:");
        list.display();

        list.deleteLast();

        System.out.println("After Delete Last:");
        list.display();
    }
}
```

---

# 42. Expected Output

```text
Circular List:
10 -> 20 -> 30 -> 40 -> (back to head)

Search 30: true

After Delete First:
20 -> 30 -> 40 -> (back to head)

After Delete Last:
20 -> 30 -> (back to head)
```

---
