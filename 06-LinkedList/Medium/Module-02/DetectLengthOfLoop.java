
public class DetectLengthOfLoop {
    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating cycle: 5 -> 3
        head.next.next.next.next.next = head.next;

        System.out.println("Length of Loop: " + lengthOfLoop(head));
    }
    static int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        int length = 0;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                length = 1;
                fast = fast.next;

                while(slow != fast) {
                    fast = fast.next;
                    length++;
                }
                return length;
            }
        }
        return 0;
    }
}