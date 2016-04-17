public class RedBlackTree implements BinaryTree {
    Node nil = new Node("BLACK");
    Node root = nil;

    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        Node n = new Node();
        n.key = 1;
        t.insert(n);

        System.out.println(t.root.key);
    }


    public void insert(Node z) {
        Node y = nil;
        Node x = root;
        while (x != nil) {
            y = x;
            if (z.key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if (y == nil)
            root = z;
        else if (z.key < y.key)
            y.left = z;
        else 
            y.right = z;
        z.left = nil;
        z.right = nil;
        z.color = "RED";
        insertFixup(z);   
    }

    private void insertFixup(Node z) {
        while (z.parent.color == "RED") {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y.color == "RED") {
                    z.parent.color = "BLACK";
                    y.color = "BLACK";
                    z.parent.parent.color = "RED";
                    z = z.parent.parent;
                } else if (z == z.parent.right) {
                    z = z.parent;
                    leftRotate(z);
                } 
                z.parent.color = "BLACK";
                z.parent.parent.color = "RED";
                rightRotate(z.parent.parent);
            } else {
                Node y = z.parent.parent.left;
                if (y.color == "RED") {
                    z.parent.color = "BLACK";
                    y.color = "BLACK";
                    z.parent.parent.color = "RED";
                    z = z.parent.parent;
                } else if (z == z.parent.left) {
                    z = z.parent;
                    rightRotate(z);
                } 
                z.parent.color = "BLACK";
                z.parent.parent.color = "RED";
                leftRotate(z.parent.parent);
            }
        }
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left; 
        if (y.left != nil) 
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == nil)
            root = y;
        else if ( x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != nil)
            x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == nil)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;
        x.right = y;
        y.parent = x;
    }

    private void transplant(Node u, Node v) {
        if (u.parent == nil) 
            root = v;
        else if (u == u.parent.left) 
            u.parent.left = v;
        else 
            u.parent.right = v;
        v.parent = u.parent;
    }

    private void deleteFixup(Node n) {
        
    }

    public Node delete(Node z) { 
        Node y = z;
        Node x = nil;
        String originalColor = y.color;
        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        }
        else {
            y = minimum(z.right);
            originalColor = y.color;
            x = y.right;
            if (y.parent == z)
                x.p = y;
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(x,y);
            y.lelft = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (originalColor == "BLACK")
            deleteFixup(x);
    }

    public Node search(int key){return null;}
    public Node sucessor(Node n){return null;}
    public Node predecessor(Node n){return null;}
    public Node minimum(){return null;}
    private Node minimum(Node n){return null;}
    public Node maximum(){return null;}

}
