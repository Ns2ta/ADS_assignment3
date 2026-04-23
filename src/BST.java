public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node;
    {
        private K key;
        private V val;
        private Node left, rigth;
        public Node(K key, V val)
        {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val) {}

    public V get(K key) {}

    public void delete(K key) {}

    public Iterable<K> iterator() {}
}

//Add size
//2) Implement in-order traversal for iterator()
//3) Make it possible for both key and value to be accessible during the iteration