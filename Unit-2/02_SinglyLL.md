# Singly Linked List

## 1. Introduction

A **Singly Linked List** is a linear data structure made up of nodes.

Each node contains two parts:

```text
1. Data
2. Reference to the next node
```

Example:

```text
HEAD
 ↓
10 → 20 → 30 → 40 → NULL
```

Here:

* `10`, `20`, `30`, `40` are data values.
* Each node points to the next node.
* The last node points to `NULL`.

---

# 2. Node Structure

Each node contains:

```text
┌──────────┬──────────┐
│   Data   │   Next   │
└──────────┴──────────┘
```

Java code:

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

# 3. Head Pointer

The `head` stores the reference of the first node.

Example:

```text
head
 ↓
10 → 20 → 30 → NULL
```

If:

```java
head == null
```

then the linked list is empty.

---

# 4. Main Operations

Important operations are:

```text
1. Insertion at beginning
2. Insertion at end
3. Insertion at position
4. Deletion from beginning
5. Deletion from end
6. Deletion by value
7. Traversal
8. Searching
9. Counting nodes
```

---

# 5. Insertion at Beginning

Suppose:

```text
10 → 20 → 30
```

Insert:

```text
5
```

Result:

```text
5 → 10 → 20 → 30
```

Logic:

```text
newNode.next = head
head = newNode
```

Code:

```java
void insertFirst(int data) {
    Node newNode = new Node(data);

    newNode.next = head;
    head = newNode;
}
```

Time Complexity:

```text
O(1)
```

---

# 6. Insertion at End

Suppose:

```text
10 → 20 → 30
```

Insert:

```text
40
```

Result:

```text
10 → 20 → 30 → 40
```

We have to reach the last node.

Code:

```java
void insertLast(int data) {

    Node newNode = new Node(data);

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
```

Time Complexity:

```text
O(n)
```

---

# 7. Insertion at Position

Suppose:

```text
10 → 20 → 30 → 40
```

Insert `25` at position `3`.

Result:

```text
10 → 20 → 25 → 30 → 40
```

Important logic:

```text
newNode.next = current.next
current.next = newNode
```

Code:

```java
void insertAtPosition(int data, int position) {

    if (position <= 1) {
        insertFirst(data);
        return;
    }

    Node newNode = new Node(data);
    Node current = head;

    for (int i = 1;
         i < position - 1 && current != null;
         i++) {

        current = current.next;
    }

    if (current == null) {
        System.out.println("Invalid Position");
        return;
    }

    newNode.next = current.next;
    current.next = newNode;
}
```

---

# 8. Deletion from Beginning

Suppose:

```text
10 → 20 → 30
```

Delete first node.

Result:

```text
20 → 30
```

Logic:

```text
head = head.next
```

Code:

```java
void deleteFirst() {

    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    head = head.next;
}
```

Time Complexity:

```text
O(1)
```

---

# 9. Deletion from End

Suppose:

```text
10 → 20 → 30 → 40
```

Delete last node.

Result:

```text
10 → 20 → 30
```

We need to reach the second-last node.

Code:

```java
void deleteLast() {

    if (head == null) {
        return;
    }

    if (head.next == null) {
        head = null;
        return;
    }

    Node current = head;

    while (current.next.next != null) {
        current = current.next;
    }

    current.next = null;
}
```

Time Complexity:

```text
O(n)
```

---

# 10. Delete by Value

Suppose:

```text
10 → 20 → 30 → 40
```

Delete:

```text
30
```

Result:

```text
10 → 20 → 40
```

We bypass the node containing `30`.

Logic:

```text
current.next = current.next.next
```

Code:

```java
void deleteByValue(int value) {

    if (head == null) {
        return;
    }

    if (head.data == value) {
        head = head.next;
        return;
    }

    Node current = head;

    while (
        current.next != null &&
        current.next.data != value
    ) {
        current = current.next;
    }

    if (current.next != null) {
        current.next = current.next.next;
    }
}
```

---

# 11. Traversal

Traversal means visiting every node one by one.

Example:

```text
10 → 20 → 30 → 40
```

Output:

```text
10 20 30 40
```

Code:

```java
void display() {

    Node current = head;

    while (current != null) {

        System.out.print(
            current.data + " -> "
        );

        current = current.next;
    }

    System.out.println("NULL");
}
```

Time Complexity:

```text
O(n)
```

---

# 12. Searching

Suppose:

```text
10 → 20 → 30 → 40
```

Search:

```text
30
```

The list is checked node by node.

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

# 13. Count Number of Nodes

Suppose:

```text
10 → 20 → 30 → 40
```

Count:

```text
4
```

Code:

```java
int countNodes() {

    int count = 0;

    Node current = head;

    while (current != null) {

        count++;

        current = current.next;
    }

    return count;
}
```

---

# 14. Complete Combined Java Program

```java
public class SinglyLinkedList {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;


    // Insert at beginning
    void insertFirst(int data) {

        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;
    }


    // Insert at end
    void insertLast(int data) {

        Node newNode = new Node(data);

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


    // Insert at position
    void insertAtPosition(
        int data,
        int position
    ) {

        if (position <= 1) {

            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);

        Node current = head;

        for (
            int i = 1;
            i < position - 1 && current != null;
            i++
        ) {

            current = current.next;
        }

        if (current == null) {

            System.out.println(
                "Invalid Position"
            );

            return;
        }

        newNode.next = current.next;

        current.next = newNode;
    }


    // Delete first node
    void deleteFirst() {

        if (head == null) {

            System.out.println(
                "List is empty"
            );

            return;
        }

        head = head.next;
    }


    // Delete last node
    void deleteLast() {

        if (head == null) {
            return;
        }

        if (head.next == null) {

            head = null;
            return;
        }

        Node current = head;

        while (
            current.next.next != null
        ) {

            current = current.next;
        }

        current.next = null;
    }


    // Delete by value
    void deleteByValue(int value) {

        if (head == null) {
            return;
        }

        if (head.data == value) {

            head = head.next;
            return;
        }

        Node current = head;

        while (
            current.next != null &&
            current.next.data != value
        ) {

            current = current.next;
        }

        if (current.next != null) {

            current.next =
                current.next.next;
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


    // Count nodes
    int countNodes() {

        int count = 0;

        Node current = head;

        while (current != null) {

            count++;

            current = current.next;
        }

        return count;
    }


    // Display
    void display() {

        Node current = head;

        while (current != null) {

            System.out.print(
                current.data + " -> "
            );

            current = current.next;
        }

        System.out.println("NULL");
    }


    // Main
    public static void main(String[] args) {

        SinglyLinkedList list =
            new SinglyLinkedList();


        // Insert
        list.insertFirst(20);
        list.insertFirst(10);

        list.insertLast(30);
        list.insertLast(40);

        list.insertAtPosition(25, 3);


        System.out.println(
            "Linked List:"
        );

        list.display();


        // Search
        System.out.println(
            "Search 30: "
            + list.search(30)
        );


        // Count
        System.out.println(
            "Total Nodes: "
            + list.countNodes()
        );


        // Delete first
        list.deleteFirst();

        System.out.println(
            "After Delete First:"
        );

        list.display();


        // Delete last
        list.deleteLast();

        System.out.println(
            "After Delete Last:"
        );

        list.display();


        // Delete value
        list.deleteByValue(25);

        System.out.println(
            "After Delete 25:"
        );

        list.display();
    }
}
```

---

# 15. Expected Output

```text
Linked List:
10 -> 20 -> 25 -> 30 -> 40 -> NULL

Search 30: true

Total Nodes: 5

After Delete First:
20 -> 25 -> 30 -> 40 -> NULL

After Delete Last:
20 -> 25 -> 30 -> NULL

After Delete 25:
20 -> 30 -> NULL
```


---

# Time Complexity Table

| Operation           | Complexity |
| ------------------- | ---------: |
| Insert at beginning |       O(1) |
| Delete at beginning |       O(1) |
| Insert at end       |       O(n) |
| Delete at end       |       O(n) |
| Insert at position  |       O(n) |
| Delete by value     |       O(n) |
| Search              |       O(n) |
| Traversal           |       O(n) |
| Count nodes         |       O(n) |

---
