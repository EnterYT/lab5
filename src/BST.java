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

    public void delete(K key) {
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");

        root = delete(root, key);
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null)
            return null;

        int comparison = key.compareTo(node.key);

        if (comparison < 0)
            node.left = delete(node.left, key);
        else if (comparison > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null && node.right == null) {
                return null;
            }
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node<K, V> replaceTemp = findMin(node.right);
                node.key = replaceTemp.key;
                node.val = replaceTemp.val;
                node.right = deleteMin(node.right);
            }
        }

        return node;
    }

    private Node<K, V> findMin(Node<K, V> node) {
        return node.left == null ? node : findMin(node.left);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null)
            return node.right;

        node.left = deleteMin(node.left);

        return node;
    }

    public Iterable<K> iterator(){

    }

    public int size(){

    }
}
