public class AddTwoNumbers {
    public static void main(String[] args) {

        // First Number: 342 (2 -> 4 -> 3)
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Second Number: 465 (5 -> 6 -> 4)
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.println("First Number:");
        printList(l1);

        System.out.println("Second Number:");
        printList(l2);

        Node result = addTwoNumbers(l1, l2);

        System.out.println("Sum:");
        printList(result);
    }

    static Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = carry;

            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;

            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        if(carry == 1) {
            curr.next = new Node(carry);
        }

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