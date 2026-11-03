public class SortZerosOnesTwosLL {

    public static void main(String[] args) {

        Node head = new Node(2);
        head.next = new Node(0);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(1);

        System.out.print("Original List: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted List: ");
        printList(head);
    }

    static Node sortList(Node head) {
        Node zero = new Node(-1), z = zero;
        Node one = new Node(-1), o = one;
        Node two = new Node(-1), t = two;

        Node temp = head;

        while(temp != null) {
            if(temp.data == 0) {
                z.next = temp;
                z = z.next;
            }
            else if(temp.data == 1) {
                o.next = temp;
                o = o.next;
            }
            else {
                t.next = temp;
                t = t.next;
            }

            temp = temp.next;
        }

        z.next = (one.next != null) ? one.next : two.next;
        o.next = two.next;
        t.next = null;

        return zero.next;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
