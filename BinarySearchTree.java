public class BinarySearchTree {
    private Node root;
    private int size;

    BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void addNode(Integer data) {
        if (data != null) {
            if (this.root == null) {
                this.root = new Node(data);
                this.root.setParent((Node) null);
            } else {
                addTree(this.root, data);
            }
            size++;
        }
    }

    private void addTree(Node node, int data) {
        if (data < node.getData()) {
            if (node.getLeft() == null) {
                node.setLeft(data);
                node.getLeft().setParent(node);
            } else if (node.getLeft() != null) {
                addTree(node.getLeft(), data);
            }
        } else if (data > node.getData()) {
            if (node.getRight() == null) {
                node.setRight(data);
                node.getRight().setParent(node);
            } else if (node.getRight() != null) {
                addTree(node.getRight(), data);
            }
        }
    }


    public Node delete(int data) {
        return deleteNode(root, data);
    }

    private Node deleteNode(Node root, int data) {
        if (root == null) return null;

        if (data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } else if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                Integer minValue = searchMin(root.getRight()).getData();
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
            }
        }

        return root;
    }

    public void deleteRight(int val) {
        Node node = search(val);
        if (node != null) {
            if (node.getRight() != null) {
                Node min = searchMin(node.getRight());
                int minval = min.getData();
                deleteNode(root, min.getData());
                node.setData(minval);
            } else delete(val);
        }
    }

    public void deleteLeft(int val) {
        Node node = search(val);
        if (node != null) {
            if (node.getLeft() != null) {
                Node max = searchMax(node.getLeft());
                int maxval = max.getData();
                deleteNode(root, max.getData());
                node.setData(maxval);
            } else delete(val);
        }
    }

    public Node search(int val) {
        return search(root, val);
    }

    private Node search(Node r, int data) {
        if (r == null || r.getData() == data) return r;
        if (r.getData() > data)
            return search(r.getLeft(), data);

        return search(r.getRight(), data);
    }

    public Node searchMax() {
        if (root.getRight() == null) return root;
        else {
            Node max = root.getRight();
            while (max.getRight() != null) {
                max = max.getRight();
            }
            return max;
        }
    }

    public Node searchMax(Node root) {
        if (root.getRight() == null) return root;
        else {
            Node max = root.getRight();
            while (max.getRight() != null) {
                max = max.getRight();
            }
            return max;
        }
    }

    public Node searchMin() {
        if (root.getLeft() == null) return root;
        else {
            Node min = root.getLeft();
            while (min.getLeft() != null) {
                min = min.getLeft();
            }
            return min;
        }
    }

    public Node searchMin(Node root) {
        if (root.getLeft() == null) return root;
        else {
            Node min = root.getLeft();
            while (min.getLeft() != null) {
                min = min.getLeft();
            }
            return min;
        }
    }

    public int getHeight(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }

    public int getHeight(int root) {
        Node node = search(root);
        if (node == null)
            return -1;
        else
            return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    public int getDepth(Node root) {
        if (root == null)
            return -1;
        else
            return getDepth(root.getParent()) + 1;
    }

    public int getDepth(int root) {
        Node node = search(root);
        if (node == null)
            return -1;
        else
            return getDepth(node.getParent()) + 1;
    }

    public int getLevel(Node node) {
        return getHeight(root) - getDepth(node);
    }

    public int getLevel(int val) {
        Node node = search(val);
        if (node != null) {
            return getHeight(root) - getDepth(node);
        } else return -1;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node getRoot() {
        return root;
    }

    public void printTree() {
        if (root != null)
            root.print();
        else System.err.println("Empty tree");
    }
}
