/*
    ============================================
             DOUBLY LINKED LIST (DLL)
    ============================================

    Each node contains:
    1. data -> Stores the value.
    2. next -> Points to the next node.
    3. prev -> Points to the previous node.

    Structure:

    NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL


    OPERATIONS:
    1.  Create Doubly Linked List
    2.  Traverse DLL
    3.  Delete Head
    4.  Delete Tail
    5.  Delete Kth Node
    6.  Delete Given Node
    7.  Insert Before Head
    8.  Insert Before Tail
    9.  Insert Before Kth Node
    10. Insert Before Given Node
    11. Insert After Head
    12. Insert After Tail
    13. Insert After Kth Node
    14. Insert After Given Node
*/

public class DLL {

    public static void main(String[] args) {

        int[] arr = {6, 5, 8, 1, 2, 7};

        // Create Doubly Linked List
        Node head = createDLL(arr);

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
        // insertBeforeGivenNode(head.next.next, 100);

        // ==============================
        // INSERTION AFTER OPERATIONS
        // ==============================

        // head = insertAfterHead(head, 100);
        // insertAfterTail(head, 200);
        // head = insertAfterKthNode(head, 100, 3);
        // insertAfterGivenNode(head.next.next, 100);

        // Display DLL
        printDLL(head);
    }


    // ============================================
    // 1. CREATE DOUBLY LINKED LIST
    // ============================================

    static Node createDLL(int[] arr) {

        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < arr.length; i++) {

            Node temp = new Node(arr[i], null, prev);

            prev.next = temp;
            prev = temp;
        }

        return head;
    }


    // ============================================
    // 2. TRAVERSE / PRINT DLL
    // ============================================

    static void printDLL(Node head) {

        Node temp = head;

        while(temp != null) {

            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }


    // ============================================
    // 3. DELETE HEAD
    // ============================================

    static Node deleteHead(Node head) {

        if(head == null || head.next == null) {
            return null;
        }

        Node prev = head;

        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }


    // ============================================
    // 4. DELETE TAIL
    // ============================================

    static Node deleteTail(Node head) {

        if(head == null || head.next == null) {
            return null;
        }

        Node tail = head;

        // Reach the last node
        while(tail.next != null) {
            tail = tail.next;
        }

        Node newTail = tail.prev;

        newTail.next = null;
        tail.prev = null;

        return head;
    }


    // ============================================
    // 5. DELETE KTH NODE (1-BASED INDEXING)
    // ============================================

    static Node deleteKthNode(Node head, int k) {

        if(head == null || k <= 0) {
            return head;
        }

        Node temp = head;
        int cnt = 0;

        // Find Kth node
        while(temp != null) {

            cnt++;

            if(cnt == k) {
                break;
            }

            temp = temp.next;
        }

        // K is greater than list length
        if(temp == null) {
            return head;
        }

        // If only one node exists
        if(temp.prev == null && temp.next == null) {
            return null;
        }

        // If Kth node is head
        if(temp.prev == null) {
            return deleteHead(head);
        }

        // If Kth node is tail
        if(temp.next == null) {
            return deleteTail(head);
        }

        Node back = temp.prev;
        Node front = temp.next;

        // Connect previous and next nodes
        back.next = front;
        front.prev = back;

        // Detach deleted node
        temp.next = null;
        temp.prev = null;

        return head;
    }


    // ============================================
    // 6. DELETE GIVEN NODE
    // ============================================

    // Assumption: temp is not the head node.

    static void deleteGivenNode(Node temp) {

        Node back = temp.prev;
        Node front = temp.next;

        // If deleting tail
        if(front == null) {

            back.next = null;
            temp.prev = null;

            return;
        }

        // Connect back and front
        back.next = front;
        front.prev = back;

        // Detach temp
        temp.next = null;
        temp.prev = null;
    }


    // ============================================
    // 7. INSERT BEFORE HEAD
    // ============================================

    static Node insertBeforeHead(Node head, int val) {

        Node newNode = new Node(val, head, null);

        if(head != null) {
            head.prev = newNode;
        }

        return newNode;
    }


    // ============================================
    // 8. INSERT BEFORE TAIL
    // ============================================

    static Node insertBeforeTail(Node head, int val) {

        if(head == null) {
            return new Node(val);
        }

        if(head.next == null) {
            return insertBeforeHead(head, val);
        }

        Node tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }

        Node back = tail.prev;

        Node newNode = new Node(val, tail, back);

        back.next = newNode;
        tail.prev = newNode;

        return head;
    }


    // ============================================
    // 9. INSERT BEFORE KTH NODE
    // ============================================

    static Node insertBeforeKthNode(Node head, int val, int k) {

        if(k <= 0) {
            return head;
        }

        if(k == 1) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;
        int cnt = 0;

        // Find Kth node
        while(temp != null) {

            cnt++;

            if(cnt == k) {
                break;
            }

            temp = temp.next;
        }

        // Invalid K
        if(temp == null) {
            return head;
        }

        Node back = temp.prev;

        Node newNode = new Node(val, temp, back);

        back.next = newNode;
        temp.prev = newNode;

        return head;
    }


    // ============================================
    // 10. INSERT BEFORE GIVEN NODE
    // ============================================

    // Assumption: node is not null.

    static void insertBeforeGivenNode(Node node, int val) {

        Node back = node.prev;

        Node newNode = new Node(val, node, back);

        node.prev = newNode;

        if(back != null) {
            back.next = newNode;
        }
    }


    // ============================================
    // 11. INSERT AFTER HEAD
    // ============================================

    static Node insertAfterHead(Node head, int val) {

        if(head == null) {
            return new Node(val);
        }

        Node front = head.next;

        Node newNode = new Node(val, front, head);

        head.next = newNode;

        if(front != null) {
            front.prev = newNode;
        }

        return head;
    }


    // ============================================
    // 12. INSERT AFTER TAIL
    // ============================================

    static Node insertAfterTail(Node head, int val) {

        if(head == null) {
            return new Node(val);
        }

        Node tail = head;

        // Reach last node
        while(tail.next != null) {
            tail = tail.next;
        }

        Node newNode = new Node(val, null, tail);

        tail.next = newNode;

        return head;
    }


    // ============================================
    // 13. INSERT AFTER KTH NODE
    // ============================================

    static Node insertAfterKthNode(Node head, int val, int k) {

        if(head == null || k <= 0) {
            return head;
        }

        Node temp = head;
        int cnt = 0;

        // Find Kth node
        while(temp != null) {

            cnt++;

            if(cnt == k) {
                break;
            }

            temp = temp.next;
        }

        // Invalid K
        if(temp == null) {
            return head;
        }

        Node front = temp.next;

        Node newNode = new Node(val, front, temp);

        temp.next = newNode;

        if(front != null) {
            front.prev = newNode;
        }

        return head;
    }


    // ============================================
    // 14. INSERT AFTER GIVEN NODE
    // ============================================

    // Assumption: node is not null.

    static void insertAfterGivenNode(Node node, int val) {

        Node front = node.next;

        Node newNode = new Node(val, front, node);

        node.next = newNode;

        if(front != null) {
            front.prev = newNode;
        }
    }
}


// ============================================
// NODE CLASS
// ============================================

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {

        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {

        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}













// public class DLL {
//     public static void main(String[] args) {
//         int[] arr = {6, 5, 8, 1, 2, 7};
//         // Node head = doublyLL(arr);

//         Node head = doublyLL(arr);
//         // head = deleteHead(head);
//         // head = deleteTail(head);
//         // head = removeKthElement(head, 2);
//         // deleteNode(head.next.next);
//         // head = insertBeforeHead(head, 10);
//         // head = insertBeforeTail(head, 20);
//         // head = insertBeforeKthElement(head, 50, 4);
//         insertBeforeNode(head.next.next, 100);
//         Node temp = head;
//         while(temp != null) {
//             System.out.print(temp.data + " -> ");
//             temp = temp.next;
//         }
//         System.out.println("null");
//     }
//     static Node doublyLL(int[] arr) {
//         Node head = new Node(arr[0]);
//         Node prev = head;

//         for (int i = 1; i < arr.length; i++) {
//             Node temp = new Node(arr[i], null, prev);
//             prev.next = temp;
//             prev = temp;
//         }
//         return head;
//     }
//     static Node deleteHead(Node head) {
//         if(head == null || head.next == null) {
//             return null;
//         }
//         Node prev = head;

//         head = head.next;
//         head.prev = null;
//         prev.next = null;

//         return head;
//     }
//     static Node deleteTail(Node head) {
//         if(head == null || head.next == null) {
//             return null;
//         }
//         Node tail = head;

//         while(tail.next != null) {
//             tail = tail.next;
//         }
//         Node newNode = tail.prev;
//         newNode.next = null;
//         tail.prev = null;
//         return head;
//     }
//     static Node removeKthElement(Node head, int k) {
//         if(head == null) {
//             return null;
//         }
//         int cnt = 0;
//         Node kNode = head;

//         while(kNode != null) {
//             cnt++;
//             if(cnt == k) {
//                 break;
//             }
//             kNode = kNode.next;
//         }

//         if(kNode.next == null && kNode.prev == null) {
//             return null;
//         }

//         else if(kNode.prev == null) {
//             return deleteHead(head);
//         } 
        
//         else if(kNode.next == null) {
//             return deleteTail(head);
//         }

//         Node back = kNode.prev;
//         Node front = kNode.next;

//         back.next = front;
//         front.prev = back;

//         kNode.next = null;
//         kNode.prev = null;

//         return head;
//     }
//     static void deleteNode(Node temp) {

//     Node front = temp.next;
//     Node back = temp.prev;

//     // If temp is the tail
//     if(front == null) {
//         back.next = null;
//         temp.prev = null;
//         return;
//     }

//     // Connect back and front
//     back.next = front;
//     front.prev = back;

//     // Detach temp
//     temp.next = null;
//     temp.prev = null;
// }
//     static Node insertBeforeHead(Node head, int val) {
//         Node newNode = new Node(val, head, null);
//         head.prev = newNode;
//         return newNode;
//     }
//     static Node insertBeforeTail(Node head, int val) {
//         if(head.next == null) {
//             return insertBeforeHead(head, val);
//         }
//         Node tail = head;
//         while(tail.next != null) {
//             tail = tail.next;
//         }
//         Node back = tail.prev;
//         Node newNode = new Node(val, tail, back);
//         back.next = newNode;
//         tail.prev = newNode;

//         return head;
//     }
//     static Node insertBeforeKthElement(Node head, int val, int k) {
//         if(k == 1) {
//             return insertBeforeHead(head, val);
//         }
//         Node temp = head;
//         int cnt = 0;

//         while(temp != null) {
//             cnt++;
//             if(cnt == k) {
//                 break;
//             }
//             temp = temp.next;
//         }
//         Node back = temp.prev;

//         Node newNode = new Node(val, temp, back);
//         back.next = newNode;
//         temp.prev = newNode;

//         return head;
//     }
//     static void insertBeforeNode(Node node, int val) {
//         Node back = node.prev;
//         Node newNode = new Node(val, node, back);

//         back.next = newNode;
//         node.prev = newNode;
//     }
// }
// class Node {
//     int data;
//     Node next;
//     Node prev;

//     Node(int data) {
//         this.data = data;
//         this.next = null;
//         this.prev = null;
//     }

//     Node(int data, Node next, Node prev) {
//         this.data = data;
//         this.next = next;
//         this.prev = prev;
//     }
// }