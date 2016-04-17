public interface BinaryTree {
    public void insert(Node n);
    public Node delete(Node n);
    public Node search(int key);
    public Node sucessor(Node n);
    public Node predecessor(Node n);
    public Node minimum();
    public Node maximum();
}
