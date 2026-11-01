public class DLL {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 1, 2, 7};
        // Node head = doublyLL(arr);

        Node head = doublyLL(arr);
        // head = deleteHead(head);
        head = deleteTail(head);
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