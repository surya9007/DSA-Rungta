# Abstract Data Type (ADT) in Java

## Abstract Data Type (ADT)

An **Abstract Data Type (ADT)** is a logical description of a data type that defines:

* **What data is stored**
* **What operations can be performed**
* **What those operations should do**

ADT focuses on **what to do**, rather than **how to do it**.

In simple words:

> **ADT defines the behavior of a data structure without specifying its implementation.**

For example, a **Stack ADT** tells us that a stack should support operations such as:

* `push()`
* `pop()`
* `peek()`
* `isEmpty()`

But Stack ADT does not say whether the stack must be implemented using:

* Array
* Linked List
* Java Collection
* Any other implementation

The implementation is a separate concern.

---

# 1. What is an Abstract Data Type?

An **Abstract Data Type** is a mathematical/logical model for a data structure.

It specifies:

1. **Data**
2. **Operations**
3. **Behavior of operations**
4. **Rules or constraints**

It hides the implementation details from the user.

### Example

Consider a Stack.

A stack follows the:

**LIFO — Last In, First Out**

Suppose we insert:

```text
10
20
30
```

The stack looks like:

```text
| 30 | ← Top
| 20 |
| 10 |
------
```

If we perform:

```java
pop();
```

Then `30` will be removed.

The Stack ADT only specifies that the most recently inserted element must be removed first.

It does not care whether we use an array or linked list internally.

---

# 2. ADT vs Data Structure

ADT and Data Structure are related but they are **not the same thing**.

## Abstract Data Type

ADT describes:

> **What operations are available and what they do.**

## Data Structure

Data Structure describes:

> **How data and operations are implemented in memory.**

### Example: Stack

**Stack ADT:**

```text
push()
pop()
peek()
isEmpty()
```

Possible implementations:

```text
Stack ADT
   |
   |------------------|
   |                  |
 Array              Linked List
```

Therefore:

```text
ADT = Logical view
Data Structure = Physical/Implementation view
```

---

# 3. Why do we need ADT?

ADT provides **abstraction**.

Suppose a user wants to use a stack.

The user does not need to know:

* How memory is allocated
* How indexes are maintained
* How nodes are connected
* How elements are shifted
* How overflow is handled internally

The user only needs to know:

```java
push()
pop()
peek()
```

This makes programs:

* Easier to understand
* Easier to maintain
* Easier to modify
* Easier to test
* More reusable
* Less dependent on implementation

---

# 4. Abstraction

Abstraction means:

> **Showing only the important information and hiding unnecessary implementation details.**

### Real-life example

Consider an ATM.

When using an ATM, you see:

```text
Insert Card
Enter PIN
Withdraw Money
Check Balance
Deposit Money
```

You don't need to know how the ATM internally communicates with:

* Bank server
* Database
* Authentication system
* Transaction system

You only interact with the available operations.

Similarly, an ADT hides implementation details and exposes only the required operations.

---

# 5. Encapsulation vs Abstraction

These two concepts are often confused.

## Encapsulation

Encapsulation means:

> Binding data and methods together and restricting direct access to internal data.

Example:

```java
class Student {

    private int marks;

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}
```

Here:

```java
private int marks;
```

hides the data.

---

## Abstraction

Abstraction means:

> Showing only essential functionality and hiding implementation details.

For example:

```java
stack.push(10);
stack.pop();
```

The user does not need to know how these operations are implemented.

---

# 6. Main Components of an ADT

An ADT generally consists of:

```text
ADT
 |
 |--- Data
 |
 |--- Operations
 |
 |--- Behavior
 |
 |--- Rules
```

### 1. Data

Defines what type of elements can be stored.

Example:

```text
Integer
String
Student
Employee
```

### 2. Operations

Defines what operations can be performed.

Example:

```text
insert()
delete()
search()
display()
```

### 3. Behavior

Defines what each operation does.

Example:

```text
push() → Adds an element to the top
pop()  → Removes the top element
```

### 4. Rules

Defines restrictions.

For Stack:

```text
Insertion → Only at top
Deletion → Only from top
```

---

# 7. General Structure of ADT

An ADT can be represented as:

```text
ADT Name

Data:
    Define the data

Operations:
    operation1()
    operation2()
    operation3()

Behavior:
    Define what each operation does
```

For example:

```text
Stack ADT

Data:
    Collection of elements

Operations:
    push()
    pop()
    peek()
    isEmpty()

Rules:
    Follows LIFO
```

---

# 8. Common ADTs in Data Structures

Some commonly studied ADTs are:

```text
1. List ADT
2. Stack ADT
3. Queue ADT
4. Deque ADT
5. Set ADT
6. Map ADT
7. Priority Queue ADT
8. Tree ADT
9. Graph ADT
```

Each ADT provides a specific logical behavior.

---

# 9. List ADT

A **List ADT** represents an ordered collection of elements.

Example:

```text
10 20 30 40 50
```

Each element has a position.

The List ADT commonly supports:

```text
insert()
remove()
get()
set()
search()
size()
isEmpty()
```

---

## List ADT Operations

### Insert

Adds an element to the list.

```text
Before:

10 20 30

insert(1, 15)

After:

10 15 20 30
```

### Remove

Removes an element.

```text
10 20 30 40

remove(2)

10 20 40
```

### Get

Returns an element at a specific position.

```text
get(2)
```

Example:

```text
10 20 30 40
      ↑
```

Result:

```text
30
```

---

# 10. List ADT in Java

Java provides the `List` interface.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }
}
```

Output:

```text
[10, 20, 30]
```

Here:

```java
List<Integer>
```

is an abstraction.

The implementation can be:

```java
ArrayList
LinkedList
```

This is one of the best examples of ADT and implementation separation.

---

# 11. Stack ADT

A **Stack** is a linear ADT that follows:

```text
LIFO
```

LIFO means:

> **Last In, First Out**

Example:

```text
10 → 20 → 30
```

The last inserted element is:

```text
30
```

Therefore, `30` will be removed first.

---

# 12. Stack Operations

A Stack generally supports:

### push()

Adds an element.

```text
push(10)
push(20)
push(30)
```

Stack:

```text
30 ← Top
20
10
```

### pop()

Removes the top element.

```text
pop()
```

Result:

```text
30
```

Stack becomes:

```text
20 ← Top
10
```

### peek()

Returns the top element without removing it.

```text
peek()
```

Result:

```text
20
```

### isEmpty()

Checks whether the stack contains elements.

```text
isEmpty()
```

Returns:

```text
true
```

or

```text
false
```

---

# 13. Stack ADT in Java

Java provides a `Deque` interface that can be used to implement stack behavior.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        System.out.println("Top: " + stack.peek());

        System.out.println("Removed: " + stack.pop());

        System.out.println(stack);
    }
}
```

Output:

```text
[30, 20, 10]
Top: 30
Removed: 30
[20, 10]
```

The important point is that the user works with stack operations without needing to know the internal implementation.

---

# 14. Queue ADT

A **Queue** is a linear ADT that follows:

```text
FIFO
```

FIFO means:

> **First In, First Out**

Example:

```text
10 20 30
```

The first inserted element is:

```text
10
```

Therefore, `10` will be removed first.

---

# 15. Queue Operations

Common Queue operations are:

```text
enqueue()
dequeue()
front()
rear()
isEmpty()
```

### Enqueue

Adds an element at the rear.

```text
enqueue(10)
enqueue(20)
enqueue(30)
```

Queue:

```text
Front → 10 20 30 ← Rear
```

### Dequeue

Removes the element from the front.

```text
dequeue()
```

Result:

```text
10
```

Queue:

```text
Front → 20 30 ← Rear
```

---

# 16. Queue ADT in Java

Java provides `Queue` as an interface.

Example:

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue);

        System.out.println("Front: " + queue.peek());

        System.out.println("Removed: " + queue.poll());

        System.out.println(queue);
    }
}
```

Output:

```text
[10, 20, 30]
Front: 10
Removed: 10
[20, 30]
```

Here:

```java
Queue<Integer>
```

is the abstraction.

`LinkedList` is one possible implementation.

---

# 17. Deque ADT

Deque means:

> **Double Ended Queue**

It allows insertion and deletion from both ends.

```text
Front                  Rear
  ↓                      ↓
10  20  30  40  50
```

We can perform:

```text
Insert Front
Insert Rear
Delete Front
Delete Rear
```

---

# 18. Deque in Java

Java provides the `Deque` interface.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);

        System.out.println(deque);

        deque.removeFirst();
        deque.removeLast();

        System.out.println(deque);
    }
}
```

---

# 19. Set ADT

A **Set ADT** represents a collection where duplicate elements are not allowed.

Example:

```text
10 20 30 20 40
```

After storing in a Set:

```text
10 20 30 40
```

The duplicate `20` is removed.

Common operations include:

```text
add()
remove()
contains()
size()
isEmpty()
```

---

# 20. Set ADT in Java

Java provides the `Set` interface.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);

        System.out.println(set);

        System.out.println(set.contains(20));
    }
}
```

Output:

```text
[20, 10, 30]
true
```

The exact order of a `HashSet` should not be relied upon.

---

# 21. Map ADT

A **Map ADT** stores data in:

```text
Key → Value
```

Example:

```text
101 → "Surya"
102 → "Amit"
103 → "Rahul"
```

Each key identifies a value.

Common operations:

```text
put()
get()
remove()
containsKey()
size()
```

---

# 22. Map ADT in Java

Java provides the `Map` interface.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(101, "Surya");
        map.put(102, "Amit");
        map.put(103, "Rahul");

        System.out.println(map);

        System.out.println(map.get(101));

        System.out.println(map.containsKey(102));
    }
}
```

Output:

```text
Surya
true
```

Again:

```java
Map
```

is the abstraction.

`HashMap` is an implementation.

---

# 23. Priority Queue ADT

A Priority Queue is an ADT where elements are removed according to their priority rather than simply according to insertion order.

For example:

```text
Element    Priority

A             3
B             1
C             2
```

The element with the highest priority may be processed first depending on the priority convention.

Java provides:

```java
PriorityQueue
```

Example:

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println(pq);

        System.out.println(pq.poll());
    }
}
```

For Java's default `PriorityQueue`, the smallest element has the highest priority.

Output of `poll()`:

```text
10
```

---

# 24. ADT and Java Interfaces

Java interfaces are extremely useful for representing ADTs.

An interface specifies **what operations are available**, while a class provides the implementation.

Example:

```java
interface Stack {

    void push(int x);

    int pop();

    int peek();

    boolean isEmpty();
}
```

The interface defines the Stack ADT.

It does not specify how the stack is implemented.

---

# 25. Implementing the ADT

We can create an implementation using an array.

```java
interface Stack {

    void push(int x);

    int pop();

    int peek();

    boolean isEmpty();
}

class ArrayStack implements Stack {

    int[] arr;
    int top = -1;

    ArrayStack(int size) {
        arr = new int[size];
    }

    public void push(int x) {

        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        arr[++top] = x;
    }

    public int pop() {

        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return arr[top--];
    }

    public int peek() {

        if (top == -1) {
            return -1;
        }

        return arr[top];
    }

    public boolean isEmpty() {

        return top == -1;
    }
}
```

Now we can use it:

```java
public class Main {

    public static void main(String[] args) {

        Stack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }
}
```

Output:

```text
30
30
20
```

---

# 26. Important Concept: Programming to an Interface

One of the major advantages of ADT is:

> **Program to an interface, not to a concrete implementation.**

For example:

```java
List<Integer> list = new ArrayList<>();
```

instead of:

```java
ArrayList<Integer> list = new ArrayList<>();
```

Why?

Because:

```java
List
```

defines the operations we need.

The implementation can potentially be changed.

For example:

```java
List<Integer> list = new LinkedList<>();
```

The rest of the program can continue using:

```java
list.add(10);
list.remove(0);
list.get(0);
```

This reduces dependency on a particular implementation.

---

# 27. ADT vs Implementation

Consider:

```java
List<Integer> list = new ArrayList<>();
```

Here:

```text
List
 ↓
ADT / Interface
```

and:

```text
ArrayList
 ↓
Implementation
```

Similarly:

```java
Queue<Integer> q = new LinkedList<>();
```

means:

```text
Queue
 ↓
Abstract behavior

LinkedList
 ↓
Implementation
```

And:

```java
Map<Integer, String> map = new HashMap<>();
```

means:

```text
Map
 ↓
Abstract behavior

HashMap
 ↓
Implementation
```

---

# 28. Benefits of ADT

## 1. Abstraction

Implementation details are hidden.

---

## 2. Modularity

Different parts of a program can be developed independently.

---

## 3. Reusability

The same ADT can have multiple implementations.

---

## 4. Maintainability

Implementation can be changed without changing the code that uses the ADT.

---

## 5. Flexibility

We can select an implementation according to requirements.

---

## 6. Security

Internal data can be protected from direct access.

---

## 7. Easier Testing

Operations can be tested independently of the internal implementation.

---

# 29. Real-Life Examples of ADT

ADT concepts appear everywhere in computer science.

### Browser History

Can behave like a stack.

```text
Visit A
Visit B
Visit C

Back → C
Back → B
```

---

### Printer Queue

Can behave like a queue.

```text
Document A
Document B
Document C
```

Usually:

```text
A → B → C
```

---

### Contacts

Can be represented using a list/map.

```text
Name → Phone Number
```

---

### Social Media Followers

Can be represented using a set because duplicate followers should not exist.

---

### Hospital Emergency System

Can use a priority queue where patients with higher priority are treated first.

---

# 30. ADT Advantages in Software Design

ADT encourages **separation of concerns**.

For example:

```text
User
 ↓
Uses ADT
 ↓
Interface
 ↓
Implementation
 ↓
Memory
```

The user does not need to know the implementation.

Suppose we have:

```java
List<Integer> list = new ArrayList<>();
```

Later we decide to use:

```java
List<Integer> list = new LinkedList<>();
```

The interface remains:

```java
List
```

and the implementation changes.

This is one of the major advantages of abstraction.

---

# 31. ADT and Data Structure Relationship

The relationship can be represented as:

```text
                ADT
                 |
       ---------------------
       |         |         |
      List     Stack      Queue
       |         |         |
   ----------  -------  --------
   |        |  |     |  |      |
ArrayList LinkedList Array LinkedList
```

The ADT defines the logical behavior.

The data structure provides a particular implementation.

---

# 32. ADT Does Not Specify Implementation

This is one of the most important points.

For example:

### Stack ADT

It says:

```text
push()
pop()
peek()
```

But it does not say:

```text
Use array
```

or:

```text
Use linked list
```

Therefore:

```text
Stack ADT
   |
   |------ Array implementation
   |
   |------ Linked List implementation
```

Both implementations can satisfy the same Stack ADT.

---

# 33. Example: List ADT

Suppose we define:

```text
List ADT

insert(position, element)
remove(position)
get(position)
size()
isEmpty()
```

We can implement it using an array:

```text
ArrayList
```

or linked nodes:

```text
LinkedList
```

The logical behavior remains the same.

Only the internal implementation changes.

---

# 34. Time Complexity and ADT

ADT itself does not necessarily determine the exact time complexity.

The implementation affects performance.

For example, searching in a list:

```text
ArrayList
```

and:

```text
LinkedList
```

can have different performance characteristics.

Similarly, a Stack implemented using:

```text
Array
```

or:

```text
Linked List
```

may have different memory-management details.

Therefore:

```text
ADT → What operations are available
Implementation → How efficiently operations are performed
```

---

# 35. ADT Design Example

Suppose we want to create a Student Collection ADT.

We can define:

```text
StudentCollection ADT

Data:
    Collection of students

Operations:

    addStudent()
    removeStudent()
    searchStudent()
    getStudent()
    size()
```

The user only needs to know these operations.

The implementation could use:

```text
ArrayList
```

or:

```text
LinkedList
```

or:

```text
Array
```

---

# 36. ADT in Object-Oriented Programming

ADT works very well with Object-Oriented Programming.

Important OOP concepts related to ADT include:

```text
Abstraction
Encapsulation
Interfaces
Classes
Polymorphism
Information Hiding
```

For example:

```java
interface ListADT {

    void add(int value);

    void remove(int value);

    int get(int index);

    int size();
}
```

Implementation:

```java
class MyList implements ListADT {

    // implementation
}
```

This provides a clear separation between:

```text
What?
```

and:

```text
How?
```

---

# 37. "What" vs "How"

This is the easiest way to remember ADT.

### WHAT

ADT tells us:

```text
What operations are available?
What should they do?
What rules should they follow?
```

### HOW

Implementation tells us:

```text
How is memory managed?
How are elements stored?
How is an operation performed?
Which algorithm is used?
```

Therefore:

```text
ADT = WHAT
Implementation = HOW
```

---

# 38. ADT Example Summary

| ADT            | Main Rule          | Common Operations     |
| -------------- | ------------------ | --------------------- |
| List           | Ordered collection | add, remove, get      |
| Stack          | LIFO               | push, pop, peek       |
| Queue          | FIFO               | offer, poll, peek     |
| Deque          | Both ends          | addFirst, addLast     |
| Set            | No duplicates      | add, remove, contains |
| Map            | Key-value          | put, get, remove      |
| Priority Queue | Priority based     | add, poll, peek       |

---

# 39. Important Interview Questions

## Q1. What is ADT?

ADT is a logical model that defines data and the operations that can be performed on that data without specifying the implementation details.

---

## Q2. What is the difference between ADT and Data Structure?

ADT defines **what** operations should be performed, while a data structure defines **how** those operations are implemented and how data is stored.

---

## Q3. Give examples of ADTs.

Examples include:

```text
List
Stack
Queue
Deque
Set
Map
Priority Queue
```

---

## Q4. Is Stack an ADT?

Yes.

Stack describes the logical behavior of a collection following LIFO.

It can be implemented using arrays, linked lists, or other mechanisms.

---

## Q5. Is Array a data structure or ADT?

An array is generally considered a **data structure/implementation mechanism**, while structures such as List and Stack are commonly discussed as ADTs.

---

## Q6. Why is abstraction important?

It hides unnecessary implementation details and allows users to work with a simple and well-defined interface.

---

## Q7. Can one ADT have multiple implementations?

Yes.

For example:

```text
Stack ADT
   |
   |--- Array
   |
   |--- Linked List
```

---

## Q8. What is the relationship between interface and ADT in Java?

A Java interface can be used to specify the operations of an ADT, while one or more classes can implement those operations.

---

# 40. Key Points to Remember

```text
ADT = Abstract Data Type
```

### Remember:

```text
ADT defines WHAT.
Implementation defines HOW.
```

ADT provides:

```text
Abstraction
Encapsulation
Information Hiding
Modularity
Flexibility
Reusability
Maintainability
```

Important examples:

```text
List
Stack
Queue
Deque
Set
Map
Priority Queue
```

Java interfaces commonly represent abstract behavior:

```java
List
Queue
Deque
Set
Map
```

while concrete classes provide implementations:

```java
ArrayList
LinkedList
ArrayDeque
HashSet
HashMap
```

---

# 41. Final Concept

The complete idea of ADT can be represented as:

```text
                    ABSTRACT DATA TYPE
                           |
             -----------------------------
             |                           |
          WHAT?                         HOW?
             |                           |
      Operations & Rules           Implementation
             |                           |
     -------------------          ------------------
     |        |        |          |        |       |
    List    Stack    Queue       Array   LinkedList
```

The **ADT defines the logical behavior** of a collection, while the **implementation defines how that behavior is achieved**.

Therefore, the most important statement to remember is:

> **An Abstract Data Type defines a data type by its behavior and supported operations while hiding the implementation details.**

---
