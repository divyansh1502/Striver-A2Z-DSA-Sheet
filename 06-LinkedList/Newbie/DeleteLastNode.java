public class DeleteLastNode {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        head = deleteLast(head);

        // Traversal
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    static Node deleteLast(Node head) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Single node: deleting it empties the list
        if (head.next == null) {
            return null;
        }

        // Stop at the second-to-last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        return head;
    }
}