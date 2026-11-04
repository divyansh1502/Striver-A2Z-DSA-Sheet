public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverseList(slow.next);
        Node secondHead = second;

        Node first = head;

        while (second != null) {
            if (first.data != second.data) {
                reverseList(secondHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverseList(secondHead);
        return true;
    }

    static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverseList(head.next);
        Node front = head.next;

        front.next = head;
        head.next = null;

        return newHead;
    }

    
}