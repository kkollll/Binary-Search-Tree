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

    /**
     * 查询元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }


    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) == 0) {
            return true;
        }
        return contains(e.compareTo(node.e) > 0 ? node.right : node.left, e);
    }

    /**
     * 二分搜索树前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
//        if (node == null) {
//            return;
//        }
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     * 排序树
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     * 应用：为二分搜索树释放内存
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.e);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    @Override

    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {7, 4, 3, 4, 10, 8, 7, 11};
        for (int num : nums) {
            bst.add(num);
        }
//                    7
//                   / \
//                  4  10
//                 /   / \
//                3   8   11
//        System.out.println(bst.root.e);
//        System.out.println(bst.root.left.e);
//        System.out.println(bst.root.left.left.e);
//        System.out.println(bst.root.right.e);
//        System.out.println(bst.root.right.left.e);
//        System.out.println(bst.root.right.right.e);
//        System.out.println(bst.getSize());
//        System.out.println(bst.contains(9));
//        bst.preOrder();
//        System.out.println(bst);
//        bst.inOrder();
        bst.postOrder();
    }
}
