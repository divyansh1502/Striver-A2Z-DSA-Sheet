public class RotateList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("List before rotation: ");
        printList(head);
        head = rotateList(head, 4);

        System.out.println("List after rotation: ");
        printList(head);
    }
    static Node rotateList(Node head, int k) {

        if(head == null || head.next == null || k == 0) return head;

        Node tail = head;
        int length = 1;

        while(tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if(k == 0) return head;

        tail.next = head;
        Node newTail = head;

        int stepsToNewTail = length - k;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
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