public class insertNodeLL {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static Node insertNodeAtpos(Node head, Node newNode, int pos) {
        if (pos == 1) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;
        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(89);
        Node b = new Node(91);
        Node c = new Node(93);
        Node d = new Node(99);

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Original list:");
        traverse(a);
        Node newNode = new Node(97);
        a = insertNodeAtpos(a, newNode, 2);
        System.out.println("\nAfter insertion:");
        traverse(a);
    }
}

