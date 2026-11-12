public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(1);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(5);
        head1.next.next.next.next = new Node(8);
        head1.next.next.next.next.next = new Node(8);
        head1.next.next.next.next.next.next = new Node(9);
        head1.next.next.next.next.next.next.next = new Node(11);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);

        Node head = mergeList(head1, head2);
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    static Node mergeList(Node head1, Node head2) {

        Node dummy = new Node();
        Node dummyPtr = dummy;

        Node t1 = head1;
        Node t2 = head2;

        while(t1 != null && t2 != null) {
            if(t1.data <= t2.data) {
                dummyPtr.next = t1;
                t1 = t1.next;
            } else {
                dummyPtr.next = t2;
                t2 = t2.next;
            } 
            dummyPtr = dummyPtr.next;
        }
        while(t1 != null) {
            dummyPtr.next = t1;
            t1 = t1.next;
            dummyPtr = dummyPtr.next;
        }
        while(t2 != null) {
            dummyPtr.next = t2;
            t2 = t2.next;
            dummyPtr = dummyPtr.next;
        }
        return dummy.next;
    }
}
