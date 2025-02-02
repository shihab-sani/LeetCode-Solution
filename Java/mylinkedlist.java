class Node {
    int data;
    Node next;
    Node prev;

    public Node (int val) {
        this.data = val;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {

    Node head;
    Node tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = this.head;
    }
    
    public int get(int index) {
        Node curr = head;
        int i = 0;
        while(curr != null) {
            if (i == index) {
                return curr.data;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
        if (head.next == null) {
            tail = head;
        }
    }
    
    public void addAtTail(int val) {
        Node new_node = new Node(val);

        if (head == null) {
            head = new_node;
            tail = head;
        } else {
            this.tail.next = new_node;
            new_node.prev = tail;
            this.tail = new_node;
        }
    }
    
    public void addAtIndex(int index, int val) {
        Node new_node = new Node(val);
        Node curr = head;
        int i = 0;
        boolean found = true;
        if (index == 0) {
            addAtHead(val);
            found = false;
        } else {
            while (curr != null) {
                if (i == index) {
                    found = false;
                    new_node.prev = curr.prev;
                    new_node.next = curr;
                    curr.prev.next = new_node;
                    curr.prev = new_node;
                    break;
                }
                curr = curr.next;
                i++;
            }
            if (found && (i == index)) {
                tail.next = new_node;
                new_node.prev = tail;
                tail = new_node;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        Node curr = head;
        int i = 0;
        if(index == 0) {
            head = head.next;
        } else {
            while (curr != null){
                if (i == index) {
                    curr.prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    } else {
                        tail = curr.prev;
                    }
                    break;
                }
                curr = curr.next;
                i++;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */