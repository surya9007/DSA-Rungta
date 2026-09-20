# Stack

## 1. Stack

A Stack is a linear data structure that follows the **LIFO** principle.

**LIFO = Last In First Out**

The element inserted last is removed first.

Example:

```text
Push 10
Push 20
Push 30

Stack:

30 <- Top
20
10

Pop removes 30 first.
```

### Main Operations

| Operation | Meaning | Time Complexity |
|---|---|---:|
| Push | Insert an element at the top | O(1) |
| Pop | Remove the top element | O(1) |
| Peek / Top | Return the top element | O(1) |
| isEmpty | Check whether stack is empty | O(1) |
| isFull | Check whether array stack is full | O(1) |
| Size | Number of elements | O(1) |

### Applications of Stack

- Expression conversion
- Infix to postfix
- Infix to prefix
- Postfix evaluation
- Prefix evaluation
- Parenthesis matching
- Function calls
- Recursion
- Undo and redo
- Browser history
- Backtracking
- Depth First Search
- String reversal

---

# 2. Stack Using Array

In an array implementation, a variable named `top` stores the index of the current top element.

Initially:

```text
top = -1
```

When an element is pushed:

```text
top = top + 1
```

When an element is popped:

```text
top = top - 1
```

## Java Code

```java
class ArrayStack {
    private int[] stack;
    private int top;

    ArrayStack(int size) {
        stack = new int[size];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == stack.length - 1;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = value;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[top];
    }

    int size() {
        return top + 1;
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
```

## Main Method

```java
public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        stack.display();
    }
}
```

## Advantages

- Simple implementation
- Fast push and pop
- Easy to understand
- Good when maximum size is known

## Disadvantages

- Fixed size
- Stack overflow can occur when the array becomes full
- Unused array space may be wasted

---

# 3. Stack Using Linked List

A linked list stack uses nodes.

Each node contains:

```text
data
next
```

The first node works as the top of the stack.

Push inserts a node at the beginning.

Pop removes the first node.

## Structure

```text
Top
 |
 v
30 -> 20 -> 10 -> null
```

## Java Code

```java
class LinkedStack {
    private Node top;
    private int size;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
        size++;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;
        size--;

        return value;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return top.data;
    }

    int size() {
        return size;
    }

    void display() {
        Node current = top;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
```

## Main Method

```java
public class Main {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        stack.display();
    }
}
```

## Advantages

- Dynamic size
- No fixed capacity
- Push and pop are O(1)
- Memory is allocated when required

## Disadvantages

- Extra memory is required for pointers
- More complex than array implementation
- Nodes are not stored in contiguous memory

---

# 4. Array Stack vs Linked List Stack

| Feature | Array Stack | Linked List Stack |
|---|---|---|
| Size | Fixed | Dynamic |
| Push | O(1) | O(1) |
| Pop | O(1) | O(1) |
| Extra Pointer Memory | No | Yes |
| Overflow | When array is full | Only when memory is unavailable |
| Implementation | Simple | Slightly complex |

---

# 5. Expression Conversion

Expressions can be written in three common forms.

## Infix Expression

Operator is written between operands.

```text
A + B
```

Examples:

```text
A + B * C
(A + B) * C
A / B - C
```

## Prefix Expression

Operator is written before operands.

```text
+ A B
```

Example:

```text
Infix: A + B * C
Prefix: + A * B C
```

## Postfix Expression

Operator is written after operands.

```text
A B +
```

Example:

```text
Infix: A + B * C
Postfix: A B C * +
```

---

# 6. Operator Precedence

| Operator | Precedence |
|---|---:|
| `^` | 3 |
| `*`, `/`, `%` | 2 |
| `+`, `-` | 1 |

Parentheses have special handling during expression conversion.

### Associativity

```text
^        Right to Left
*, /, %  Left to Right
+, -     Left to Right
```

---

# 7. Infix to Postfix

## Rules

1. Scan the expression from left to right.
2. If the character is an operand, add it to the result.
3. If the character is `(`, push it.
4. If the character is `)`, pop operators until `(` is found.
5. If the character is an operator, pop higher-precedence operators from the stack.
6. Push the current operator.
7. At the end, pop all remaining operators.

## Example

```text
Infix:

A+B*C

Step:

A
AB
ABC
ABC*
ABC*+

Postfix:

ABC*+
```

## Java Code Using Stack

```java
import java.util.Stack;

public class InfixToPostfix {

    static int precedence(char ch) {
        if (ch == '^') {
            return 3;
        }

        if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        }

        if (ch == '+' || ch == '-') {
            return 1;
        }

        return -1;
    }

    static String convert(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : expression.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && (precedence(stack.peek()) > precedence(ch)
                        || (precedence(stack.peek()) == precedence(ch) && ch != '^'))) {
                    result.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A+B*C"));
        System.out.println(convert("(A+B)*C"));
        System.out.println(convert("A^B^C"));
    }
}
```

---

# 8. Infix to Prefix

One common method is:

1. Reverse the infix expression.
2. Replace `(` with `)` and `)` with `(`.
3. Convert the modified expression to postfix.
4. Reverse the postfix result.
5. The final result is prefix.

## Example

```text
Infix:

A+B*C

Prefix:

+A*BC
```

## Java Code

```java
import java.util.Stack;

public class InfixToPrefix {

    static int precedence(char ch) {
        if (ch == '^') {
            return 3;
        }

        if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        }

        if (ch == '+' || ch == '-') {
            return 1;
        }

        return -1;
    }

    static String reverseAndSwap(String expression) {
        StringBuilder result = new StringBuilder();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                result.append(')');
            } else if (ch == ')') {
                result.append('(');
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    static String postfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : expression.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && (precedence(stack.peek()) > precedence(ch)
                        || (precedence(stack.peek()) == precedence(ch) && ch == '^'))) {
                    result.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    static String convert(String expression) {
        String modified = reverseAndSwap(expression);
        String result = postfix(modified);

        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A+B*C"));
        System.out.println(convert("(A+B)*C"));
    }
}
```

---

# 9. Postfix Evaluation

In postfix evaluation, operands are pushed into a stack.

When an operator appears:

1. Pop the second operand.
2. Pop the first operand.
3. Perform the operation.
4. Push the result.

## Example

```text
Postfix:

23+

Push 2
Push 3
Apply +

Result:

5
```

Another example:

```text
Postfix:

23*5+

2 * 3 = 6
6 + 5 = 11

Result:

11
```

## Java Code

```java
import java.util.Stack;

public class PostfixEvaluation {

    static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();

                if (ch == '+') {
                    stack.push(a + b);
                } else if (ch == '-') {
                    stack.push(a - b);
                } else if (ch == '*') {
                    stack.push(a * b);
                } else if (ch == '/') {
                    stack.push(a / b);
                } else if (ch == '%') {
                    stack.push(a % b);
                } else if (ch == '^') {
                    stack.push((int) Math.pow(a, b));
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("23+"));
        System.out.println(evaluate("23*5+"));
        System.out.println(evaluate("82/3+"));
    }
}
```

---

# 10. Prefix Evaluation

Prefix expression is generally scanned from right to left.

Rules:

1. Scan from right to left.
2. Push operands.
3. When an operator appears, pop two operands.
4. Apply the operator.
5. Push the result.
6. The final stack value is the answer.

## Example

```text
Prefix:

+23

2 + 3 = 5
```

## Java Code

```java
import java.util.Stack;

public class PrefixEvaluation {

    static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();

                if (ch == '+') {
                    stack.push(a + b);
                } else if (ch == '-') {
                    stack.push(a - b);
                } else if (ch == '*') {
                    stack.push(a * b);
                } else if (ch == '/') {
                    stack.push(a / b);
                } else if (ch == '%') {
                    stack.push(a % b);
                } else if (ch == '^') {
                    stack.push((int) Math.pow(a, b));
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("+23"));
        System.out.println(evaluate("+*235"));
    }
}
```

---

# 11. Parenthesis Matching

Parenthesis matching checks whether every opening bracket has a corresponding closing bracket in the correct order.

Common brackets:

```text
()
{}
[]
```

## Balanced Examples

```text
()
{}
[]
([])
{[()]}
(a+b)
{a+(b*c)}
```

## Unbalanced Examples

```text
(
([)]
{]
((())
```

## Algorithm

1. Scan the expression from left to right.
2. Push every opening bracket.
3. When a closing bracket is found:
   - If stack is empty, expression is invalid.
   - Compare the closing bracket with the stack top.
   - If they match, pop the opening bracket.
   - Otherwise, expression is invalid.
4. After scanning, the stack must be empty.

## Java Code Using Stack

```java
import java.util.Stack;

public class ParenthesisMatching {

    static boolean isMatching(char open, char close) {
        return open == '(' && close == ')'
                || open == '{' && close == '}'
                || open == '[' && close == ']';
    }

    static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }

                if (!isMatching(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("(a+b)*(c-d)"));
    }
}
```

---

# 12. Parenthesis Matching Using Array Stack

```java
public class ParenthesisArray {

    static boolean isMatching(char open, char close) {
        return open == '(' && close == ')'
                || open == '{' && close == '}'
                || open == '[' && close == ']';
    }

    static boolean isBalanced(String expression) {
        char[] stack = new char[expression.length()];
        int top = -1;

        for (char ch : expression.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            }

            if (ch == ')' || ch == '}' || ch == ']') {

                if (top == -1) {
                    return false;
                }

                char open = stack[top--];

                if (!isMatching(open, ch)) {
                    return false;
                }
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("([)]"));
    }
}
```

---

# 13. Parenthesis Matching Using Linked List Stack

```java
public class ParenthesisLinkedList {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    static Node top;

    static void push(char value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    static char pop() {
        char value = top.data;
        top = top.next;
        return value;
    }

    static boolean isMatching(char open, char close) {
        return open == '(' && close == ')'
                || open == '{' && close == '}'
                || open == '[' && close == ']';
    }

    static boolean isBalanced(String expression) {
        top = null;

        for (char ch : expression.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            }

            if (ch == ')' || ch == '}' || ch == ']') {

                if (top == null) {
                    return false;
                }

                if (!isMatching(pop(), ch)) {
                    return false;
                }
            }
        }

        return top == null;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("([)]"));
    }
}
```

---

# 14. Recursion

Recursion is a technique in which a function calls itself.

Every recursive solution normally contains:

1. Base case
2. Recursive case

## General Structure

```java
static void function() {
    if (condition) {
        return;
    }

    function();
}
```

The base case stops recursion.

Without a base case, recursion continues until a `StackOverflowError` occurs.

---

# 15. How Stack Is Used in Recursion

Every method call creates a stack frame in the call stack.

A stack frame stores information such as:

- Method parameters
- Local variables
- Return address
- Method execution state

Example:

```text
factorial(4)
factorial(3)
factorial(2)
factorial(1)
```

Call stack:

```text
factorial(1)
factorial(2)
factorial(3)
factorial(4)
```

When the base case is reached, the calls return in reverse order.

```text
factorial(1) returns 1
factorial(2) returns 2
factorial(3) returns 6
factorial(4) returns 24
```

This is why recursion naturally follows LIFO behavior.

---

# 16. Factorial Using Recursion

Formula:

```text
n! = n × (n - 1)!
```

Base case:

```text
0! = 1
1! = 1
```

## Java Code

```java
public class FactorialRecursion {

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
```

Output:

```text
120
```

---

# 17. Sum of Natural Numbers Using Recursion

```java
public class NaturalSum {

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}
```

Output:

```text
15
```

---

# 18. Fibonacci Using Recursion

Fibonacci sequence:

```text
0 1 1 2 3 5 8 13 ...
```

Formula:

```text
F(n) = F(n - 1) + F(n - 2)
```

## Java Code

```java
public class FibonacciRecursion {

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
```

---

# 19. Reverse String Using Recursion

```java
public class ReverseStringRecursion {

    static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("STACK"));
    }
}
```

Output:

```text
KCATS
```

---

# 20. Print Numbers Using Recursion

## 1 to N

```java
public class PrintOneToN {

    static void print(int n) {
        if (n == 0) {
            return;
        }

        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(5);
    }
}
```

Output:

```text
1
2
3
4
5
```

## N to 1

```java
public class PrintNToOne {

    static void print(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        print(n - 1);
    }

    public static void main(String[] args) {
        print(5);
    }
}
```

Output:

```text
5
4
3
2
1
```

---

# 21. Power Using Recursion

```java
public class PowerRecursion {

    static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }
}
```

Output:

```text
32
```

---

# 22. Recursive Stack Reversal

A stack can also be reversed using recursion.

## Java Code

```java
import java.util.Stack;

public class ReverseStack {

    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }

    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        reverse(stack);

        System.out.println(stack);
    }
}
```

---

# 23. Stack Using Array with Generic Type

```java
class GenericArrayStack<T> {
    private Object[] stack;
    private int top;

    GenericArrayStack(int capacity) {
        stack = new Object[capacity];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == stack.length - 1;
    }

    void push(T value) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }

        stack[++top] = value;
    }

    T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        T value = (T) stack[top];
        stack[top--] = null;

        return value;
    }

    T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return (T) stack[top];
    }

    int size() {
        return top + 1;
    }
}
```

---

# 24. Stack Using Generic Linked List

```java
class GenericLinkedStack<T> {

    private Node<T> top;
    private int size;

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        size++;
    }

    T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        T value = top.data;
        top = top.next;
        size--;

        return value;
    }

    T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return top.data;
    }

    int size() {
        return size;
    }
}
```

---

# 25. Expression Conversion Quick Table

| Infix | Prefix | Postfix |
|---|---|---|
| `A+B` | `+AB` | `AB+` |
| `A-B` | `-AB` | `AB-` |
| `A*B` | `*AB` | `AB*` |
| `A/B` | `/AB` | `AB/` |
| `A+B*C` | `+A*BC` | `ABC*+` |
| `(A+B)*C` | `*+ABC` | `AB+C*` |
| `A*(B+C)` | `*A+BC` | `ABC+*` |
| `A+B-C` | `-+ABC` | `AB+C-` |
| `A*(B+C)/D` | `/*A+BCD` | `ABC+*D/` |

---

# 26. Important Stack Conditions

## Array Stack Empty Condition

```text
top == -1
```

## Array Stack Full Condition

```text
top == capacity - 1
```

## Linked List Stack Empty Condition

```text
top == null
```

---

# 27. Stack Overflow

Stack overflow occurs when we try to push an element into a full fixed-size array stack.

Example:

```text
Capacity = 3

Push 10
Push 20
Push 30
Push 40

Stack Overflow
```

In recursion, stack overflow can also happen because of too many recursive calls.

Example:

```java
public class InfiniteRecursion {

    static void test() {
        test();
    }

    public static void main(String[] args) {
        test();
    }
}
```

This eventually throws:

```text
StackOverflowError
```

---

# 28. Stack Underflow

Stack underflow occurs when we try to pop or peek from an empty stack.

Example:

```text
Stack is empty
Pop

Stack Underflow
```

---

# 29. Time Complexity Summary

## Array Stack

| Operation | Complexity |
|---|---:|
| Push | O(1) |
| Pop | O(1) |
| Peek | O(1) |
| isEmpty | O(1) |
| isFull | O(1) |
| Display | O(n) |

## Linked List Stack

| Operation | Complexity |
|---|---:|
| Push | O(1) |
| Pop | O(1) |
| Peek | O(1) |
| isEmpty | O(1) |
| Display | O(n) |

## Expression Problems

| Problem | Complexity |
|---|---:|
| Infix to Postfix | O(n) |
| Infix to Prefix | O(n) |
| Postfix Evaluation | O(n) |
| Prefix Evaluation | O(n) |
| Parenthesis Matching | O(n) |

---

# Practice Problems

## Expression Practice

Convert these to postfix and prefix:

```text
A+B*C
(A+B)*C
A*(B+C)
A+B*C-D
(A+B)*(C-D)
A^B^C
A*(B+C)/D
A+B*(C^D-E)^(F+G*H)-I
```

---


