
public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Linklist before deletion: ");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("Linklist after deletion: ");
        printList(head);

    }
    static Node deleteMiddle(Node head) {

        if(head == null || head.next == null) return null;
        
        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        fast = fast.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
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