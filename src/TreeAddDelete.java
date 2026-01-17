public class TreeAddDelete {
    
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private TreeNode root;
    
    public TreeAddDelete() {
        this.root = null;
    }
    
    /**
     * ADD (INSERT) OPERATION
     * Inserts a new value into the BST while maintaining the BST property
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(log n) for recursion stack
     * 
     * @param data The value to insert
     */
    public void add(int data) {
        root = addRecursive(root, data);
        System.out.println("Added: " + data);
    }
    
    private TreeNode addRecursive(TreeNode node, int data) {
        // Create new node if empty position
        if (node == null) {
            return new TreeNode(data);
        }
        
        // Insert in appropriate subtree
        if (data < node.data) {
            node.left = addRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = addRecursive(node.right, data);
        }
        // Ignore duplicates
        
        return node;
    }
    
    /**
     * DELETE OPERATION
     * Removes a node from the BST while maintaining the BST property
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(log n) for recursion stack
     * 
     * Handles three cases:
     * 1. Node is a leaf (no children) - simply remove it
     * 2. Node has one child - replace it with its child
     * 3. Node has two children - find in-order successor and replace
     * 
     * @param data The value to delete
     * @return true if deleted, false if not found
     */
    public boolean delete(int data) {
        int size = getSize(root);
        root = deleteRecursive(root, data);
        int newSize = getSize(root);
        
        boolean deleted = (size > newSize);
        if (deleted) {
            System.out.println("Deleted: " + data);
        } else {
            System.out.println("Value " + data + " not found in tree");
        }
        return deleted;
    }
    
    private TreeNode deleteRecursive(TreeNode node, int data) {
        if (node == null) {
            return null;
        }
        
        // Navigate to the node to delete
        if (data < node.data) {
            node.left = deleteRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Found the node to delete - handle three cases
            
            // CASE 1: Node is a leaf (no children)
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // CASE 2: Node has only right child
            if (node.left == null) {
                return node.right;
            }
            
            // CASE 2: Node has only left child
            if (node.right == null) {
                return node.left;
            }
            
            // CASE 3: Node has two children
            // Find the minimum value in the right subtree (in-order successor)
            TreeNode minRight = findMin(node.right);
            node.data = minRight.data;
            node.right = deleteRecursive(node.right, minRight.data);
        }
        
        return node;
    }
    
    /**
     * Find the node with minimum value (leftmost node)
     * Time Complexity: O(log n) average
     */
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    /**
     * Get the total number of nodes in the tree
     * Time Complexity: O(n)
     */
    private int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }
    
    /**
     * Display tree in in-order traversal (sorted order)
     */
    public void display() {
        System.out.print("Tree (in-order): ");
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    
    /**
     * Check if a value exists in the tree
     * Time Complexity: O(log n) average
     */
    public boolean contains(int data) {
        return searchRecursive(root, data);
    }
    
    private boolean searchRecursive(TreeNode node, int data) {
        if (node == null) {
            return false;
        }
        
        if (node.data == data) {
            return true;
        }
        
        if (data < node.data) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }
    
    /**
     * Get the root of the tree
     */
    public TreeNode getRoot() {
        return root;
    }
    
    /**
     * Main method demonstrating add and delete operations
     */
    public static void main(String[] args) {
        System.out.println("=== Tree Add and Delete Operations ===\n");
        
        TreeAddDelete tree = new TreeAddDelete();
        
        // ADD OPERATIONS
        System.out.println("--- ADD Operations ---");
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        tree.add(10);
        tree.display();
        
        // DELETE OPERATIONS
        System.out.println("\n--- DELETE Operations ---");
        
        // Case 1: Delete a leaf node (10)
        System.out.println("\nCase 1: Delete leaf node (10)");
        tree.delete(10);
        tree.display();
        
        // Case 2: Delete a node with one child (20)
        System.out.println("\nCase 2: Delete node with one child (20)");
        tree.delete(20);
        tree.display();
        
        // Case 3: Delete a node with two children (30)
        System.out.println("\nCase 3: Delete node with two children (30)");
        tree.delete(30);
        tree.display();
        
        // Try to delete non-existent value
        System.out.println("\nAttempt to delete non-existent value (100):");
        tree.delete(100);
        tree.display();
        
        // Delete more nodes
        System.out.println("\nDelete root node (50):");
        tree.delete(50);
        tree.display();
        
        // Verify tree integrity with search
        System.out.println("\n--- Verification ---");
        System.out.println("Tree contains 70: " + tree.contains(70));
        System.out.println("Tree contains 30: " + tree.contains(30));
        System.out.println("Tree contains 40: " + tree.contains(40));
    }
}
