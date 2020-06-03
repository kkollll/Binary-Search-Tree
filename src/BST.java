public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            Node cur = root;
            while (true) {
                if (e.compareTo(cur.e) == 0 ) {
                    return;
                }
                if (e.compareTo(cur.e) > 0 ) {
                    if (cur.right == null) {
                        cur.right = new Node(e);
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
                if (e.compareTo(cur.e) < 0) {
                    if (cur.left == null) {
                        cur.left = new Node(e);
                        break;
                    } else {
                        cur = cur.left;
                    }
                }
            }
        }
        size++;
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(7);
        bst.add(4);
        bst.add(2);
        bst.add(3);
        bst.add(10);
        bst.add(8);
        bst.add(11);

        System.out.println(bst.root.e);
        System.out.println(bst.root.left.e);
        System.out.println(bst.root.left.left.e);
        System.out.println(bst.root.left.left.right.e);
        System.out.println(bst.root.e);
        System.out.println(bst.root.right.e);
        System.out.println(bst.root.right.left.e);
        System.out.println(bst.root.right.right.e);
        System.out.println(bst.getSize());
    }
}
