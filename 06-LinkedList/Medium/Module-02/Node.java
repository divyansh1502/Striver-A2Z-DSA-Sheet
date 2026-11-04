class Node {
    int data;
    Node next;
    Node prev;

    Node() {

    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    
}