public class StartingNodeOfLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;

        System.out.println(startingNode(head));
        
    }
    static int startingNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                slow = head;

                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }
        return -1;
    }
}
