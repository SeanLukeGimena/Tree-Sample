public class BasicTree {
    
    /**
     * Node class represents individual elements in the tree
     */
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        // Constructor to create a new node
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private TreeNode root;
    
    /**
     * Constructor to initialize an empty tree
     */
    public BasicTree() {
        this.root = null;
    }
    
    /**
     * Insert a value into the BST
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(log n) for recursion stack
     * 
     * @param data The value to insert
     */
    public void insert(int data) {
        root = insertRecursive(root, data);
    }
    
    /**
     * Helper method to recursively insert a value
     */
    private TreeNode insertRecursive(TreeNode node, int data) {
        // Base case: create new node if position is empty
        if (node == null) {
            return new TreeNode(data);
        }
        
        // Recursively insert in left or right subtree
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = insertRecursive(node.right, data);
        }
        // If data equals node.data, we don't insert duplicates
        
        return node;
    }
    
    /**
     * Search for a value in the BST
     * Time Complexity: O(log n) average, O(n) worst case
     * 
     * @param data The value to search for
     * @return true if found, false otherwise
     */
    public boolean search(int data) {
        return searchRecursive(root, data);
    }
    
    /**
     * Helper method to recursively search for a value
     */
    private boolean searchRecursive(TreeNode node, int data) {
        // Base case: node is null
        if (node == null) {
            return false;
        }
        
        // Found the value
        if (node.data == data) {
            return true;
        }
        
        // Search in left or right subtree based on comparison
        if (data < node.data) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }
    
    /**
     * In-order traversal: Left -> Root -> Right (produces sorted output)
     * Time Complexity: O(n)
     * 
     * @param node The current node being visited
     */
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    
    /**
     * Pre-order traversal: Root -> Left -> Right
     * Time Complexity: O(n)
     */
    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    
    /**
     * Post-order traversal: Left -> Right -> Root
     * Time Complexity: O(n)
     */
    public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    /**
     * Get the root of the tree
     */
    public TreeNode getRoot() {
        return root;
    }
    
    /**
     * Main method to demonstrate basic tree operations
     */
    public static void main(String[] args) {
        System.out.println("=== Binary Search Tree - Basic Operations ===\n");
        
        BasicTree tree = new BasicTree();
        
        // Insert values into the tree
        System.out.println("Inserting values: 50, 30, 70, 20, 40, 60, 80");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        // Display tree structure through traversals
        System.out.println("\nIn-order Traversal (sorted): ");
        tree.inOrderTraversal(tree.getRoot());
        
        System.out.println("\n\nPre-order Traversal: ");
        tree.preOrderTraversal(tree.getRoot());
        
        System.out.println("\n\nPost-order Traversal: ");
        tree.postOrderTraversal(tree.getRoot());
        
        // Search operations
        System.out.println("\n\nSearch Operations:");
        System.out.println("Search for 40: " + tree.search(40)); // true
        System.out.println("Search for 25: " + tree.search(25)); // false
        System.out.println("Search for 70: " + tree.search(70)); // true
        System.out.println("Search for 100: " + tree.search(100)); // false
    }
}
