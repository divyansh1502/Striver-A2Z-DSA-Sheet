/*
    ============================================
             SINGLY LINKED LIST (SLL)
    ============================================

    Each node contains:
    1. data -> Stores the value.
    2. next -> Points to the next node.

    Structure:

    10 -> 20 -> 30 -> 40 -> NULL


    OPERATIONS:

    1.  Create Singly Linked List
    2.  Traverse / Print SLL
    3.  Find Length of SLL
    4.  Search an Element
    5.  Delete Head
    6.  Delete Tail
    7.  Delete Kth Node
    8.  Delete Given Node
    9.  Insert Before Head
    10. Insert Before Tail
    11. Insert Before Kth Node
    12. Insert Before Given Node
    13. Insert After Head
    14. Insert After Tail
    15. Insert After Kth Node
    16. Insert After Given Node
*/

public class SLL {

    public static void main(String[] args) {

        int[] arr = {6, 5, 8, 1, 2, 7};

        // Create Singly Linked List
        Node head = createSLL(arr);

        // ==============================
        // DELETION OPERATIONS
        // ==============================

        // head = deleteHead(head);
        // head = deleteTail(head);
        // head = deleteKthNode(head, 3);
        // deleteGivenNode(head.next.next);

        // ==============================
        // INSERTION BEFORE OPERATIONS
        // ==============================

        // head = insertBeforeHead(head, 10);
        // head = insertBeforeTail(head, 20);
        // head = insertBeforeKthNode(head, 50, 3);

        // ==============================
        // INSERTION AFTER OPERATIONS
        // ==============================

        // head = insertAfterHead(head, 100);
        // head = insertAfterTail(head, 200);
        // head = insertAfterKthNode(head, 100, 3);
        // insertAfterGivenNode(head.next.next, 100);

        // ==============================
        // OTHER OPERATIONS
        // ==============================

        // System.out.println("Length: " + findLength(head));
        // System.out.println("Found: " + searchElement(head, 8));

        // Display SLL
        printSLL(head);
    }


    // ============================================
    // 1. CREATE SINGLY LINKED LIST
    // ============================================

    static Node createSLL(int[] arr) {

        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i = 1; i < arr.length; i++) {

            Node temp = new Node(arr[i]);

            mover.next = temp;
            mover = temp;
        }

        return head;
    }


    // ============================================
    // 2. TRAVERSE / PRINT SLL
    // ============================================

    static void printSLL(Node head) {

        Node temp = head;

        while(temp != null) {

            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }


    // ============================================
    // 3. FIND LENGTH OF SLL
    // ============================================

    static int findLength(Node head) {

        int cnt = 0;
        Node temp = head;

        while(temp != null) {

            cnt++;
            temp = temp.next;
        }

        return cnt;
    }


    // ============================================
    // 4. SEARCH AN ELEMENT
    // ============================================

    static boolean searchElement(Node head, int target) {

        Node temp = head;

        while(temp != null) {

            if(temp.data == target) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }


    // ============================================
    // 5. DELETE HEAD
    // ============================================

    static Node deleteHead(Node head) {

        if(head == null) {
            return null;
        }

        Node temp = head;

        head = head.next;

        // Detach old head
        temp.next = null;

        return head;
    }


    // ============================================
    // 6. DELETE TAIL
    // ============================================

    static Node deleteTail(Node head) {

        if(head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        // Reach second-last node
        while(temp.next.next != null) {
            temp = temp.next;
        }

        Node tail = temp.next;

        temp.next = null;

        // Detach old tail
        tail.next = null;

        return head;
    }


    // ============================================
    // 7. DELETE KTH NODE (1-BASED INDEXING)
    // ============================================

    static Node deleteKthNode(Node head, int k) {

        if(head == null || k <= 0) {
            return head;
        }

        // Delete head
        if(k == 1) {
            return deleteHead(head);
        }

        Node temp = head;
        int cnt = 1;

        // Reach node before Kth node
        while(temp != null && cnt < k - 1) {

            temp = temp.next;
            cnt++;
        }

        // Invalid K
        if(temp == null || temp.next == null) {
            return head;
        }

        Node nodeToDelete = temp.next;

        // Skip Kth node
        temp.next = nodeToDelete.next;

        // Detach deleted node
        nodeToDelete.next = null;

        return head;
    }


    // ============================================
    // 8. DELETE GIVEN NODE
    // ============================================

    /*
       Assumption:
       Given node is not the tail node.

       In SLL, we don't have access to the
       previous node.

       Therefore, copy the next node's data
       and skip the next node.
    */

    static void deleteGivenNode(Node node) {

        if(node == null || node.next == null) {
            return;
        }

        Node nextNode = node.next;

        // Copy next node's data
        node.data = nextNode.data;

        // Skip next node
        node.next = nextNode.next;

        // Detach next node
        nextNode.next = null;
    }


    // ============================================
    // 9. INSERT BEFORE HEAD
    // ============================================

    static Node insertBeforeHead(Node head, int val) {

        Node newNode = new Node(val);

        newNode.next = head;

        return newNode;
    }


    // ============================================
    // 10. INSERT BEFORE TAIL
    // ============================================

    static Node insertBeforeTail(Node head, int val) {

        if(head == null) {
            return new Node(val);
        }

        if(head.next == null) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;

        // Reach second-last node
        while(temp.next.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(val);

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }


    // ============================================
    // 11. INSERT BEFORE KTH NODE
    // ============================================

    static Node insertBeforeKthNode(Node head, int val, int k) {

        if(k <= 0) {
            return head;
        }

        if(k == 1) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;
        int cnt = 1;

        // Reach node before Kth node
        while(temp != null && cnt < k - 1) {

            temp = temp.next;
            cnt++;
        }

        // Invalid K
        if(temp == null || temp.next == null) {
            return head;
        }

        Node newNode = new Node(val);

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }


    // ============================================
    // 12. INSERT BEFORE GIVEN NODE
    // ============================================

    /*
       SLL doesn't have a prev pointer.

       Therefore, to insert before a given node,
       we need to find its previous node by traversal.

       Assumption: node belongs to this list.
    */

    static Node insertBeforeGivenNode(Node head, Node node, int val) {

        if(head == null || node == null) {
            return head;
        }

        if(head == node) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;

        // Find previous node
        while(temp != null && temp.next != node) {
            temp = temp.next;
        }

        // Node not found
        if(temp == null) {
            return head;
        }

        Node newNode = new Node(val);

        newNode.next = node;
        temp.next = newNode;

        return head;
    }


    // ============================================
    // 13. INSERT AFTER HEAD
    // ============================================

    static Node insertAfterHead(Node head, int val) {

        if(head == null) {
            return new Node(val);
        }

        Node newNode = new Node(val);

        newNode.next = head.next;
        head.next = newNode;

        return head;
    }


    // ============================================
    // 14. INSERT AFTER TAIL
    // ============================================

    static Node insertAfterTail(Node head, int val) {

        Node newNode = new Node(val);

        if(head == null) {
            return newNode;
        }

        Node tail = head;

        // Reach last node
        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = newNode;

        return head;
    }


    // ============================================
    // 15. INSERT AFTER KTH NODE
    // ============================================

    static Node insertAfterKthNode(Node head, int val, int k) {

        if(k <= 0) {
            return head;
        }

        Node temp = head;
        int cnt = 1;

        // Find Kth node
        while(temp != null && cnt < k) {

            temp = temp.next;
            cnt++;
        }

        // Invalid K
        if(temp == null) {
            return head;
        }

        Node newNode = new Node(val);

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }


    // ============================================
    // 16. INSERT AFTER GIVEN NODE
    // ============================================

    static void insertAfterGivenNode(Node node, int val) {

        if(node == null) {
            return;
        }

        Node newNode = new Node(val);

        newNode.next = node.next;
        node.next = newNode;
    }

}


// ============================================
// NODE CLASS
// ============================================

class Node {

    int data;
    Node next;

    Node(int data) {

        this.data = data;
        this.next = null;
    }
}


