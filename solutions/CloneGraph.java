import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, HashMap<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }

        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(clone(nei, oldToNew));
        }

        return copy;
    }
}