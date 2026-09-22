public class deleteNode {
    static class Node {
        int data;
        Node next;
        Node(int data) {
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
    public static Node del(Node head, Node delNode) {
        if (head == delNode) { 
            return head.next;
        }
        Node curr = head;
        while (curr.next != null && curr.next != delNode) {
            curr = curr.next;
        } 
        if (curr.next == null) {
            return head;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(11);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println("Before deletion:");
        traverse(a);

        a = del(a, d);

        System.out.println("\nAfter deletion:");
        traverse(a);
    }
}

