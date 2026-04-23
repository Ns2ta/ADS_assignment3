public class BST<K extends Comparable<K>, V> {

    private Node root;
    private int size = 0;
    private class Node
    {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val)
        {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);

            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else {
                current.val = val;
                return;
            }
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left = new Node(key, val);
        else parent.right = new Node(key, val);

        size++;
    }

    public V get(K key) {
        //if (root == null) return;

        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else {
                return current.val;
            }
        }

        return null;
    }

    public void delete(K key) {
        if (root == null) return;

        Node parent = null;
        Node current = root;

        while (current != null && !key.equals(current.key)) {
            parent = current;

            int cmp = key.compareTo(current.key);

            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else {
                current.val = null;
                current.key = null;
            }
        }
    }

    public Iterable<K> iterator() {
        return null;
    }

    public int size() {
        return size;
    }
}

//Add size
//2) Implement in-order traversal for iterator()
//3) Make it possible for both key and value to be accessible during the iteration

// public void inOrder (Node root) {
//      if (root == null) return;
//      inOrder(root.left);
//      System.out.println(root.data + " ");
//      inOrder(root.right);
// }