public class ReverseDLL {
    public static void main(String[] args) {

        // Create nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        // Connect nodes
        first.next = second;

        second.prev = first;
        second.next = third;

        third.prev = second;
        third.next = fourth;

        fourth.prev = third;

        Node head = first;

        System.out.println("Original DLL:");
        printList(head);

        head = reverseDLL(head);

        System.out.println("Reversed DLL:");
        printList(head);
    }

    static Node reverseDLL(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node temp = null;

        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        return temp.prev;
    }

    static void printList(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
