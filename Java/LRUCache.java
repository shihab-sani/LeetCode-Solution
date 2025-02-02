import java.util.HashMap;

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private final  HashMap<Integer, Node> hashing;
    private final  int cap;
    private final Node left;
    private final Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.hashing = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (hashing.containsKey(key)) {
            Node node = hashing.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (hashing.containsKey(key)) {
            remove(hashing.get(key));
        }
        hashing.put(key, node);
        insert(node);

        if (hashing.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            hashing.remove(lru.key);
        }
    }
}