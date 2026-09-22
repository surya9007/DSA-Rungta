public class CircularLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(13);
        Node node4 = new Node(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;  

        Node curr = node1;
        Node startNode = node1;
        System.out.print(curr.data + " -> ");
        curr = curr.next;

        while (curr != startNode) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }
}
