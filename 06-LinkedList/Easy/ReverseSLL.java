public class ReverseSLL {
    public static void main(String[] args) {

        // Create nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        // Connect nodes
        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        System.out.println("Original List:");
        printList(head);

        head = reverseSLL(head);

        System.out.println("Reversed List:");
        printList(head);
    }

    static Node reverseSLL(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while(curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void printList(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}