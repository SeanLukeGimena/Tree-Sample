class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeExample {
    public static void main(String[] args) {

        // Create root node
        TreeNode root = new TreeNode(10);

        // Add child nodes
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        System.out.println("Tree created successfully.");
    }
}
