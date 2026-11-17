
public class SortList {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(1);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);

        System.out.println("List before sorting: ");
        printList(head);

        head = sortList(head);

        System.out.println("List after sorting");
        printList(head);
    }
    static Node sortList(Node head) {

        if(head == null || head.next == null) return head;

        Node mid = getMid(head);

        Node left = head;
        Node right = mid.next;

        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeList(left, right);
    }
    static Node mergeList(Node first, Node second) {
        
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(first != null && second != null) {
            if(first.data <= second.data) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        if(first != null) temp.next = first;
        if(second != null) temp.next = second;

        return dummy.next;
    }
    static Node getMid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
