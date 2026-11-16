import java.util.PriorityQueue;

public class MergeKSortedLists {
     public static void main(String[] args) {

        Node[] lists = new Node[3];

        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        // PriorityQueue Approach

        Node result = mergeKLists(lists);

        System.out.println("Merged Sorted List:");
        printList(result);
    }

    // Normal Approach: Sequential Merging

    static Node mergeKListsNormal(Node[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }

        Node head = lists[0];

        for(int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }

    // Merge Two Sorted Lists

    static Node mergeTwoLists(Node l1, Node l2) {

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(l1 != null && l2 != null) {

            if(l1.data <= l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if(l1 != null) {
            temp.next = l1;
        }

        if(l2 != null) {
            temp.next = l2;
        }

        return dummy.next;
    }


    // Optimal Approach: PriorityQueue (Min Heap)

    static Node mergeKLists(Node[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.data, b.data)
        );

        for(Node node : lists) {
            if(node != null) {
                pq.offer(node);
            }
        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(!pq.isEmpty()) {

            Node node = pq.poll();

            temp.next = node;
            temp = temp.next;

            if(node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }


    // Print Linked List

    static void printList(Node head) {

        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }
}