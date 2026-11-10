public class DeleteAllOccurences {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(1);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.print("Original List: ");
        printList(head);

        head = deleteOccurences(head, 1);

        System.out.print("After Deletion: ");
        printList(head);
    }

    static Node deleteOccurences(Node head, int x) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == x) {
                if (head == temp) {
                    head = head.next;
                }

                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if (nextNode != null) nextNode.prev = prevNode;
                if (prevNode != null) prevNode.next = nextNode;

                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}