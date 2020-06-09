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
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以node为根的二分搜索树插入元素E，递归算法
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {

        if (e.compareTo(node.e) == 0) {
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) > 0) {
            add(node.right, e);
        } else {
            add(node.left, e);
        }
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(7);
        bst.add(4);
        bst.add(2);
        bst.add(3);
        bst.add(10);
        bst.add(8);
        bst.add(7);
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
