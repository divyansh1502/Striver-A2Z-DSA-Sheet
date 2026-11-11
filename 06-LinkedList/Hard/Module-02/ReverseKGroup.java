public class ReverseKGroup {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, 3);

        System.out.println("After Reversing in K Groups:");
        printList(head);
    }

    static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevNode = null;

        while(temp != null) {
            Node kthNode = getKthNode(temp, k);

            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;

            reverseList(temp);

            if(temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    static Node getKthNode(Node temp, int k) {
        k--;

        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}