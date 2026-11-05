public class AddOne {
    public static void main(String[] args) {

        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        head = addOne(head);

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node addOne(Node head) {
        Node newHead = reverseList(head);
        Node temp = newHead;
        int carry = 1;

        while(temp != null && carry != 0) {
            int sum = temp.data + carry;

            temp.data = sum % 10;
            carry = sum / 10;

            if(temp.next == null && carry != 0) {
                temp.next = new Node(carry);
                carry = 0;
            }

            temp = temp.next;
        }

        return reverseList(newHead);
    }

    static Node reverseList(Node head) {
        Node prev = null, curr = head;

        while(curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}