# LabWork5 🚀

### Laboratory work for assignment 5 in AITU. This is a simple implementation of a ***`Binary Search Tree`*** (BST) in Java. It provides basic operations such as `insertion`, `retrieval`, and `deletion` of `key-value` pairs.

## `BST` implementation:
```java
public class BST<K extends Comparable<K>, V> implements Iterable<BST.Node<K, V>>{

    public static class Node<K, V> {
        private K key;
        private V val; 
        private Node<K, V> left, right; 

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }
    private Node<K, V> root;
    private int size;

    public void put(K key, V val) {
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");
        root = put(root, key, val);
    }

    private Node<K, V> put(Node<K, V> node, K key, V val) {
        if (node == null) {
            size++;
            return new Node<>(key, val);
        }

        int comparison = key.compareTo(node.key);

        if (comparison < 0)
            node.left = put(node.left, key, val);
        else if (comparison > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
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

    public Iterator<Node<K, V>> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Node<K, V>> {
        private Node<K, V> current;
        private Stack<Node<K, V>> nodeStack;

        public InOrderIterator() {
            current = root;
            nodeStack = new Stack<>();
        }

        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty() || current != null;
        }

        @Override
        public Node<K, V> next() {

            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }

            if (!hasNext())
                throw new NoSuchElementException("No more elements in the BST.");
                
            Node<K, V> node = nodeStack.pop();
            current = node.right;
            
            return node;
        }
    }

    public int size() {
        return size;
    }
}
```
