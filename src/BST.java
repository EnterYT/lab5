public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
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

    public V get(K key){

    }

    public void delete(K key){

    }

    public Iterable<K> iterator(){

    }

    public int size(){

    }
}
