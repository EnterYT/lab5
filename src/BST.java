public class BST<K extends Comparable<K>, V>{
    private Node<K, V> root;
    private class Node<K, V>{
        private K key;
        private V val;
        private Node<K, V> left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    BST(){
        root = null;
    }
    public void put(K key, V val){
        Node child = new Node(key, val);
        if ((int)root.val >= (int)child.val){
            root.left = child;
        }
        if ((int)root.val < (int)child.val){
            root.right = child;
        }
    }

    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");

        Node<K, V> node = get(root, key);

        return (node == null) ? null : node.val;
    }

    private Node<K, V> get(Node<K, V> node, K key) {
        if (node == null)
            return null;

        int comparison = key.compareTo(node.key);

        if (comparison < 0)
            return get(node.left, key);
        else if (comparison > 0)
            return get(node.right, key);
        else
            return node;
    }

    public void delete(K key){
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");

        root = delete(root, key);
    }

    public Iterable<K> iterator(){

    }

    public int size(){

    }
}
