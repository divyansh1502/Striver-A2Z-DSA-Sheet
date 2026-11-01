public class DLL {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 1, 2, 7};
        // Node head = doublyLL(arr);

        Node head = doublyLL(arr);
        // head = deleteHead(head);
        // head = deleteTail(head);
        // head = removeKthElement(head, 2);
        // deleteNode(head.next.next);
        // head = insertBeforeHead(head, 10);
        head = insertBeforeTail(head, 20);
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    static Node doublyLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
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
    static Node deleteTail(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }
        Node newNode = tail.prev;
        newNode.next = null;
        tail.prev = null;
        return head;
    }
    static Node removeKthElement(Node head, int k) {
        if(head == null) {
            return null;
        }
        int cnt = 0;
        Node kNode = head;

        while(kNode != null) {
            cnt++;
            if(cnt == k) {
                break;
            }
            kNode = kNode.next;
        }

        if(kNode.next == null && kNode.prev == null) {
            return null;
        }

        else if(kNode.prev == null) {
            return deleteHead(head);
        } 
        
        else if(kNode.next == null) {
            return deleteTail(head);
        }

        Node back = kNode.prev;
        Node front = kNode.next;

        back.next = front;
        front.prev = back;

        kNode.next = null;
        kNode.prev = null;

        return head;
    }
    static void deleteNode(Node temp) {

    Node front = temp.next;
    Node back = temp.prev;

    // If temp is the tail
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
    static Node insertBeforeHead(Node head, int val) {
        Node newNode = new Node(val, head, null);
        head.prev = newNode;
        return newNode;
    }
    static Node insertBeforeTail(Node head, int val) {
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
}
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