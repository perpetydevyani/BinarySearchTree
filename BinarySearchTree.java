class BSTNode {
    int info;
    BSTNode left, right;

    public BSTNode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BSTNode insertRec(BSTNode node, int value) {
        if (node == null) {
            return new BSTNode(value);
        }
        if (value < node.info) {
            node.left = insertRec(node.left, value);
        } else if (value > node.info) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    public void inOrder() {
        System.out.print("InOrder: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.info + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        System.out.print("PreOrder: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(BSTNode node) {
        if (node != null) {
            System.out.print(node.info + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void postOrder() {
        System.out.print("PostOrder: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(BSTNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.info + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int val : values) {
            bst.insert(val);
        }

        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
    }
}
