class Node {
    int key;
    Node next;

    public Node (int key) {
        this.key = key;
        this.next = null;
    }
}

class MyHashSet {
    Node[] set;

    public MyHashSet() {
        this.set = new Node[100000];
    }
    
    public void add(int key) {
        int index = key % set.length;
        Node prev = null;
        Node curr = set[index];
        while (curr != null) {
            if (curr.key == key) {
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if (prev != null)
            prev.next = new Node(key);
        else
            set[index] = new Node(key);
    }
    
    public void remove(int key) {
        Node curr = set[key % set.length];
        Node prev = null;

        while(curr != null) {
            if (curr.key == key) {
                if (prev != null){
                    prev.next = curr.next;
                    return;
                } else {
                    set[key % set.length] = null;
                    return;
                }
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        Node curr = set[key % set.length];

        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */