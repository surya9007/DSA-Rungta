
## 1. Queue

A Queue is a linear data structure that follows the **FIFO** principle.

**FIFO = First In First Out**

The element inserted first is removed first.

Real-life examples:

- People standing in a ticket line
- Printer job scheduling
- CPU task scheduling
- Customer-service requests
- Network packet handling

### Basic Structure

```text
Front                        Rear
  |                            |
  v                            v
[10] [20] [30] [40]
```

Insertion happens at the **rear**.

Deletion happens from the **front**.

### Main Operations

| Operation | Meaning |
|---|---|
| enqueue | Insert at rear |
| dequeue | Remove from front |
| peek | Read front element |
| rear | Read last element |
| isEmpty | Check whether queue is empty |
| isFull | Check whether fixed queue is full |
| size | Number of elements |

### Time Complexity

| Operation | Complexity |
|---|---:|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek | O(1) |
| Size | O(1) |

---

## 2. Queue Using Array

```java
class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == queue.length;
    }

    void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }

        queue[++rear] = value;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = queue[front++];
        size--;
        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return queue[front];
    }

    int rear() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return queue[rear];
    }

    int size() {
        return size;
    }

    void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }
}
```

### Main Method

```java
public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.rear());

        queue.display();
    }
}
```

---

## 3. Queue Using Linked List

A linked-list Queue keeps two references:

```text
front
rear
```

`front` points to the first node and `rear` points to the last node.

```text
Front                         Rear
  |                             |
  v                             v
10 -> 20 -> 30 -> 40 -> null
```

```java
class LinkedQueue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int value) {
        Node node = new Node(value);

        if (rear == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }

        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return front.data;
    }

    int rear() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return rear.data;
    }

    int size() {
        return size;
    }

    void display() {
        Node current = front;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}
```

---

## 4. Queue Using Java LinkedList

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
```

Important Java Queue methods:

| Method | Meaning |
|---|---|
| `offer()` | Insert |
| `poll()` | Remove |
| `peek()` | View front |
| `isEmpty()` | Check empty |
| `size()` | Number of elements |

---


# Circular Queue

A Circular Queue is a Queue in which the last array position is logically connected to the first position.

It solves the wasted-space problem of a normal array Queue.

A Circular Queue is also called:

```text
Circular Buffer
Ring Buffer
```

### Why Circular Queue?

In a normal array Queue, deleted positions at the beginning may become unusable after `rear` reaches the final array index.

Circular Queue reuses those positions.

### Important Formula

```text
rear = (rear + 1) % capacity
```

```text
front = (front + 1) % capacity
```

### Example

Capacity = 5

```text
[10] [20] [30] [40] [50]
 F                   R
```

After deleting 10 and 20:

```text
[ ] [ ] [30] [40] [50]
         F           R
```

Insert 60:

```text
[60] [ ] [30] [40] [50]
 R       F
```

Insert 70:

```text
[60] [70] [30] [40] [50]
      R    F
```

Logical order:

```text
30 40 50 60 70
```

---

## Circular Queue Using Array

```java
class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    CircularQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == queue.length;
    }

    void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Circular Queue Overflow");
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Circular Queue Underflow");
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Circular Queue is Empty");
        }

        return queue[front];
    }

    int rear() {
        if (isEmpty()) {
            throw new RuntimeException("Circular Queue is Empty");
        }

        return queue[rear];
    }

    void display() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }
}
```

### Main Method

```java
public class Main {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(60);
        queue.enqueue(70);

        queue.display();
    }
}
```

---

## Circular Queue Using front = -1 and rear = -1

```java
class CircularQueueAlternative {

    private int[] queue;
    private int front;
    private int rear;

    CircularQueueAlternative(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return (rear + 1) % queue.length == front;
    }

    void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % queue.length;
        }

        queue[rear] = value;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }

        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return queue[front];
    }
}
```

### Circular Queue Applications

- Round-robin CPU scheduling
- Audio buffering
- Video buffering
- Network packet buffering
- Keyboard buffers
- Producer-consumer systems
- Embedded systems
- Streaming systems

---

# 9. Priority Queue

A Priority Queue is a special Queue in which every element has a priority.

The element with the highest priority is removed first.

If two elements have equal priority, their order depends on the implementation.

There are two common forms.

### Min Priority Queue

Smaller value has higher priority.

```text
Input:
40 10 30 20

Removal:
10 20 30 40
```

### Max Priority Queue

Larger value has higher priority.

```text
Input:
40 10 30 20

Removal:
40 30 20 10
```

### Applications

- CPU scheduling
- Dijkstra's algorithm
- Prim's algorithm
- Huffman coding
- Emergency task handling
- Network routing
- Event simulation
- Hospital priority systems
- Job scheduling

---

## 10. Priority Queue Using Java PriorityQueue

Java `PriorityQueue` is a heap-based implementation.

By default it behaves like a min-priority Queue.

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(40);
        queue.offer(10);
        queue.offer(30);
        queue.offer(20);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```

Output:

```text
10
20
30
40
```

---

## 11. Max Priority Queue

```java
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(40);
        queue.offer(10);
        queue.offer(30);
        queue.offer(20);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```

Output:

```text
40
30
20
10
```

---

## 12. Priority Queue Using Linked List

Here smaller priority number means higher priority.

```java
class LinkedPriorityQueue {

    static class Node {
        int data;
        int priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node front;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int data, int priority) {
        Node node = new Node(data, priority);

        if (front == null || priority < front.priority) {
            node.next = front;
            front = node;
            return;
        }

        Node current = front;

        while (current.next != null &&
                current.next.priority <= priority) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue Underflow");
        }

        int value = front.data;
        front = front.next;
        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is Empty");
        }

        return front.data;
    }

    void display() {
        Node current = front;

        while (current != null) {
            System.out.println(current.data + " " + current.priority);
            current = current.next;
        }
    }
}
```

---

## 13. Priority Queue With Custom Object

```java
import java.util.PriorityQueue;

class Task implements Comparable<Task> {

    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    public String toString() {
        return name + " Priority " + priority;
    }
}

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Task> queue = new PriorityQueue<>();

        queue.offer(new Task("Backup", 3));
        queue.offer(new Task("Server Failure", 1));
        queue.offer(new Task("Security Alert", 2));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```

### Priority Queue Complexity

| Operation | Complexity |
|---|---:|
| Insert | O(log n) |
| Remove | O(log n) |
| Peek | O(1) |
| Search | O(n) |

---

# 14. Deque

Deque means **Double Ended Queue**.

A Deque allows insertion and deletion from both ends.

```text
Front                      Rear
  |                          |
  v                          v
[10] [20] [30] [40]
```

Operations:

- addFront
- addRear
- removeFront
- removeRear
- getFront
- getRear

### Types of Deque

#### Input Restricted Deque

```text
Insertion: one end only
Deletion: both ends
```

#### Output Restricted Deque

```text
Insertion: both ends
Deletion: one end only
```

### Applications

- Sliding window maximum
- Palindrome checking
- Undo/redo
- Browser navigation
- LRU cache
- Scheduling
- Monotonic Queue
- Work-stealing algorithms

---

## Deque Using Circular Array

```java
class CustomDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;

    CustomDeque(int capacity) {
        deque = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == deque.length;
    }

    void addRear(int value) {
        if (isFull()) {
            throw new RuntimeException("Deque Overflow");
        }

        rear = (rear + 1) % deque.length;
        deque[rear] = value;
        size++;
    }

    void addFront(int value) {
        if (isFull()) {
            throw new RuntimeException("Deque Overflow");
        }

        front = (front - 1 + deque.length) % deque.length;
        deque[front] = value;

        if (size == 0) {
            rear = front;
        }

        size++;
    }

    int removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque Underflow");
        }

        int value = deque[front];

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % deque.length;
        }

        size--;
        return value;
    }

    int removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque Underflow");
        }

        int value = deque[rear];

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + deque.length) % deque.length;
        }

        size--;
        return value;
    }

    int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is Empty");
        }

        return deque[front];
    }

    int getRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is Empty");
        }

        return deque[rear];
    }

    void display() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % deque.length;
            System.out.print(deque[index] + " ");
        }

        System.out.println();
    }
}
```

---

## 16. Deque Using Doubly Linked List

```java
class LinkedDeque {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    boolean isEmpty() {
        return front == null;
    }

    void addFront(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
    }

    void addRear(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
    }

    int removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque Underflow");
        }

        int value = front.data;

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        return value;
    }

    int removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque Underflow");
        }

        int value = rear.data;

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        return value;
    }

    int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is Empty");
        }

        return front.data;
    }

    int getRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is Empty");
        }

        return rear.data;
    }
}
```

---

## 17. Java ArrayDeque

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(20);
        deque.addFirst(10);
        deque.addLast(30);
        deque.addLast(40);

        System.out.println(deque);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        deque.removeFirst();
        deque.removeLast();

        System.out.println(deque);
    }
}
```

Important methods:

| Front Side | Rear Side |
|---|---|
| `addFirst()` | `addLast()` |
| `offerFirst()` | `offerLast()` |
| `removeFirst()` | `removeLast()` |
| `pollFirst()` | `pollLast()` |
| `getFirst()` | `getLast()` |
| `peekFirst()` | `peekLast()` |

---

## 18. Deque ADT

```java
interface DequeADT<T> {
    void addFront(T value);
    void addRear(T value);
    T removeFront();
    T removeRear();
    T getFront();
    T getRear();
    boolean isEmpty();
    int size();
}
```

---

## 19. Palindrome Using Deque

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeDeque {

    static boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("hello"));
    }
}
```

---

## 20. Sliding Window Maximum Using Deque

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int[] result = maxSlidingWindow(nums, 3);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
```

---

## 21. Queue Using Two Stacks

```java
import java.util.Stack;

class QueueUsingStacks {

    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    void enqueue(int value) {
        input.push(value);
    }

    int dequeue() {
        move();

        if (output.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return output.pop();
    }

    int peek() {
        move();

        if (output.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return output.peek();
    }

    boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void move() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
```

---

## 22. Reverse Queue

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        reverse(queue);

        System.out.println(queue);
    }
}
```

---

## 23. Generate Binary Numbers Using Queue

```java
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers {

    static void generate(int n) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String current = queue.poll();

            System.out.println(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }

    public static void main(String[] args) {
        generate(10);
    }
}
```

---

## 24. Breadth First Search Using Queue

BFS explores graph vertices level by level and therefore naturally uses a Queue.

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void bfs(ArrayList<ArrayList<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        bfs(graph, 0);
    }
}
```

---



# Complexity Summary

## Queue

| Operation | Complexity |
|---|---:|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek | O(1) |

## Circular Queue

| Operation | Complexity |
|---|---:|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek | O(1) |

## Priority Queue

| Operation | Complexity |
|---|---:|
| Offer | O(log n) |
| Poll | O(log n) |
| Peek | O(1) |

## Deque

| Operation | Complexity |
|---|---:|
| Add Front | O(1) |
| Add Rear | O(1) |
| Remove Front | O(1) |
| Remove Rear | O(1) |

---
