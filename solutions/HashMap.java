class Pair {
    int key;
    int val;
    Pair next;

    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class MyHashMap {
    Pair[] map;

    public MyHashMap() {
        this.map = new Pair[100000];
    }
    
    public void put(int key, int value) {
        int index = key % map.length;
        Pair curr = map[index];
        Pair prev = null;

        while (curr != null) {
            if(curr.key == key) {
                curr.val = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if(prev != null) {
            prev.next = new Pair(key, value);
        } else {
            map[index] = new Pair(key, value);
        }
    }
    
    public int get(int key) {
        int index = key % map.length;
        Pair curr = map[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % map.length;
        Pair curr = map[index];
        Pair prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev != null) {
                    prev.next = curr.next;
                    return;
                } else {
                    map[index] = null;
                    return;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */