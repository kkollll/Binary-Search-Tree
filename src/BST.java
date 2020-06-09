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
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树插入元素E，递归算法
     *
     * @param node
     * @param e
     * @return 返回插入新节点后的二分搜索树的根
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
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
