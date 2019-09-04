public class Node {
    private Integer data;
    private Node left;
    private Node right;
    private Node parent;

    Node(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Integer getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public void setLeft(Integer data) {
        this.left = new Node(data);
    }

    public void setRight(Integer data) {
        this.right = new Node(data);
    }

    public void setLeft(Node node) {
        left = node;
    }

    public void setRight(Node node) {
        right = node;
    }

    public void setParent(Integer data) {
        this.parent = new Node(data);
    }

    public void setParent(Node node) {
        parent = node;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void print() {
        print("", this, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + ((n != null) ? (isLeft ? "L:" + n.data : ((n.parent == null) ? "" : "R:") + n.data)
                : ((isLeft ? "L:-" : "R:-"))));
        if (n != null) {
            if (n.getLeft() != null || n.getRight() != null) {
                print(prefix + (isLeft ? "|   " : "    "), n.left, true);
                print(prefix + (isLeft ? "|   " : "    "), n.right, false);
            }
        }

    }
}
