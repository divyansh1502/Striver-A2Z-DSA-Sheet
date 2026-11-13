public class FlattenLL {
    public static void main(String[] args) {

        Node head = new Node(5);

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        Node result = flatten(head);

        printList(result);
    }

    static Node flatten(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mergeHead = flatten(head.next);

        return merge(head, mergeHead);
    }

    static Node merge(Node list1, Node list2) {
        Node t1 = list1;
        Node t2 = list2;

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(t1 != null && t2 != null) {
            if(t1.data < t2.data) {
                temp.bottom = t1;
                t1 = t1.bottom;
            } else {
                temp.bottom = t2;
                t2 = t2.bottom;
            }

            temp = temp.bottom;
        }

        if(t1 != null) {
            temp.bottom = t1;
        } else {
            temp.bottom = t2;
        }

        return dummyNode.bottom;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.bottom;
        }
        System.out.println("null");
    }
}

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}