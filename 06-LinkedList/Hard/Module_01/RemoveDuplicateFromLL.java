

public class RemoveDuplicateFromLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next = new Node(4);

        System.out.println("List Before Removal: ");
        printList(head);

        System.out.println("List after Removal: ");
        head = removeDuplicate(head);
        printList(head);
    }
    static Node removeDuplicate(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node unqPtr = head;
        Node currPtr = head.next;

        while(currPtr != null) {
            if(unqPtr.data != currPtr.data) {
                unqPtr.next = currPtr;
                unqPtr = currPtr;
            }
            currPtr = currPtr.next;
        }
        unqPtr.next = null;
        return head;
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
