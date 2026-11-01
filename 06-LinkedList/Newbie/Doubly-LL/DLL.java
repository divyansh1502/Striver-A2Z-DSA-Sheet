public class DLL {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 1, 2, 7};
        // Node head = doublyLL(arr);

        Node head = doublyLL(arr);
        // head = deleteHead(head);
        // head = deleteTail(head);
        head = removeKthElement(head, 2);
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