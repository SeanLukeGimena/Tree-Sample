public class TreeRecursion {
    
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
    
    public TreeRecursion() {
        this.root = null;
    }
    
    /**
     * Insert a value into the BST
     */
    public void insert(int data) {
        root = insertRecursive(root, data);
    }
    
    private TreeNode insertRecursive(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = insertRecursive(node.right, data);
        }
        
        return node;
    }
    
    /**
     * RECURSION 1: Calculate Tree Height
     * Height is the number of edges from root to deepest leaf
     * 
     * Algorithm:
     * - Height(null) = -1
     * - Height(node) = 1 + max(Height(left), Height(right))
     * 
     * Time Complexity: O(n) - visit each node once
     * Space Complexity: O(h) - recursion depth
     * 
     * @return Height of tree (-1 if empty)
     */
    public int calculateHeight() {
        return calculateHeightRecursive(root);
    }
    
    private int calculateHeightRecursive(TreeNode node) {
        // Base case: empty tree has height -1
        if (node == null) {
            return -1;
        }
        
        // Height = 1 + maximum height of subtrees
        int leftHeight = calculateHeightRecursive(node.left);
        int rightHeight = calculateHeightRecursive(node.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * RECURSION 2: In-Order Traversal
     * Visits nodes in order: Left -> Root -> Right
     * Produces sorted output for BST
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void inOrderTraversal() {
        System.out.print("In-order: ");
        inOrderRecursive(root);
        System.out.println();
    }
    
    private void inOrderRecursive(TreeNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }
    
    /**
     * RECURSION 3: Pre-Order Traversal
     * Visits nodes in order: Root -> Left -> Right
     * Useful for copying trees
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void preOrderTraversal() {
        System.out.print("Pre-order: ");
        preOrderRecursive(root);
        System.out.println();
    }
    
    private void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }
    
    /**
     * RECURSION 4: Post-Order Traversal
     * Visits nodes in order: Left -> Right -> Root
     * Useful for deletion
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void postOrderTraversal() {
        System.out.print("Post-order: ");
        postOrderRecursive(root);
        System.out.println();
    }
    
    private void postOrderRecursive(TreeNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    /**
     * RECURSION 5: Calculate Sum of All Nodes
     * Sums all data values in the tree
     * 
     * Algorithm:
     * - Sum(null) = 0
     * - Sum(node) = node.data + Sum(left) + Sum(right)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     * 
     * @return Total sum of all node values
     */
    public int calculateSum() {
        return calculateSumRecursive(root);
    }
    
    private int calculateSumRecursive(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return node.data + calculateSumRecursive(node.left) + calculateSumRecursive(node.right);
    }
    
    /**
     * RECURSION 6: Count Total Nodes
     * Counts how many nodes are in the tree
     * 
     * Algorithm:
     * - Count(null) = 0
     * - Count(node) = 1 + Count(left) + Count(right)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     * 
     * @return Total number of nodes
     */
    public int countNodes() {
        return countNodesRecursive(root);
    }
    
    private int countNodesRecursive(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }
    
    /**
     * RECURSION 7: Find Path Sum
     * Finds all paths from root to leaf that sum to target
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) for storing paths
     * 
     * @param targetSum Target sum
     * @return List of all root-to-leaf paths that sum to target
     */
    public java.util.List<java.util.List<Integer>> findPathsWithSum(int targetSum) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.List<Integer> currentPath = new java.util.ArrayList<>();
        findPathsRecursive(root, targetSum, currentPath, result);
        return result;
    }
    
    private void findPathsRecursive(TreeNode node, int targetSum, 
                                    java.util.List<Integer> currentPath, 
                                    java.util.List<java.util.List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        // Add current node to path
        currentPath.add(node.data);
        
        // Check if we reached a leaf with target sum
        if (node.left == null && node.right == null && node.data == targetSum) {
            result.add(new java.util.ArrayList<>(currentPath));
        }
        
        // Recursively explore left and right subtrees
        if (node.left != null) {
            findPathsRecursive(node.left, targetSum - node.data, currentPath, result);
        }
        if (node.right != null) {
            findPathsRecursive(node.right, targetSum - node.data, currentPath, result);
        }
        
        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
    
    /**
     * RECURSION 8: Check if Tree is Balanced
     * A balanced tree has height difference <= 1 at every node
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     * 
     * @return true if balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalancedRecursive(root).isBalanced;
    }
    
    static class BalanceInfo {
        boolean isBalanced;
        int height;
        
        BalanceInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    
    private BalanceInfo isBalancedRecursive(TreeNode node) {
        if (node == null) {
            return new BalanceInfo(true, -1);
        }
        
        BalanceInfo leftInfo = isBalancedRecursive(node.left);
        if (!leftInfo.isBalanced) {
            return new BalanceInfo(false, 0);
        }
        
        BalanceInfo rightInfo = isBalancedRecursive(node.right);
        if (!rightInfo.isBalanced) {
            return new BalanceInfo(false, 0);
        }
        
        // Check if current node is balanced
        boolean isCurrentBalanced = Math.abs(leftInfo.height - rightInfo.height) <= 1;
        int height = 1 + Math.max(leftInfo.height, rightInfo.height);
        
        return new BalanceInfo(isCurrentBalanced, height);
    }
    
    /**
     * RECURSION 9: Clone/Copy Tree
     * Creates a deep copy of the tree
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @return Root of cloned tree
     */
    public TreeRecursion cloneTree() {
        TreeRecursion cloned = new TreeRecursion();
        cloned.root = cloneRecursive(root);
        return cloned;
    }
    
    private TreeNode cloneRecursive(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode newNode = new TreeNode(node.data);
        newNode.left = cloneRecursive(node.left);
        newNode.right = cloneRecursive(node.right);
        
        return newNode;
    }
    
    /**
     * Display tree in in-order traversal
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
     * Main method demonstrating recursive operations
     */
    public static void main(String[] args) {
        System.out.println("=== Recursive Tree Operations ===\n");
        
        TreeRecursion tree = new TreeRecursion();
        
        // Build tree
        System.out.println("Building tree with values: 50, 30, 70, 20, 40, 60, 80, 10, 25");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(25);
        tree.display();
        
        // RECURSION 1: Height
        System.out.println("\n--- RECURSION 1: Calculate Height ---");
        int height = tree.calculateHeight();
        System.out.println("Tree height: " + height);
        
        // RECURSION 2-4: Traversals
        System.out.println("\n--- RECURSION 2-4: Tree Traversals ---");
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();
        
        // RECURSION 5: Sum
        System.out.println("\n--- RECURSION 5: Calculate Sum ---");
        int sum = tree.calculateSum();
        System.out.println("Sum of all nodes: " + sum);
        
        // RECURSION 6: Count Nodes
        System.out.println("\n--- RECURSION 6: Count Nodes ---");
        int nodeCount = tree.countNodes();
        System.out.println("Total nodes: " + nodeCount);
        
        // RECURSION 7: Path Sum
        System.out.println("\n--- RECURSION 7: Find Paths with Sum ---");
        java.util.List<java.util.List<Integer>> paths = tree.findPathsWithSum(80);
        System.out.println("Paths that sum to 80: " + paths);
        
        // RECURSION 8: Check Balance
        System.out.println("\n--- RECURSION 8: Check if Balanced ---");
        boolean balanced = tree.isBalanced();
        System.out.println("Tree is balanced: " + balanced);
        
        // RECURSION 9: Clone Tree
        System.out.println("\n--- RECURSION 9: Clone Tree ---");
        TreeRecursion clonedTree = tree.cloneTree();
        System.out.print("Cloned tree: ");
        clonedTree.display();
        
        // Build skewed tree for comparison
        System.out.println("\n\n--- Testing with Skewed Tree ---");
        TreeRecursion skewedTree = new TreeRecursion();
        System.out.println("Building skewed tree: 1, 2, 3, 4, 5");
        skewedTree.insert(1);
        skewedTree.insert(2);
        skewedTree.insert(3);
        skewedTree.insert(4);
        skewedTree.insert(5);
        skewedTree.display();
        
        System.out.println("Skewed tree height: " + skewedTree.calculateHeight());
        System.out.println("Skewed tree is balanced: " + skewedTree.isBalanced());
        
        System.out.println("\n--- Space Complexity Summary ---");
        System.out.println("Balanced tree: O(log n) recursion depth");
        System.out.println("Skewed tree: O(n) recursion depth");
        System.out.println("All operations: O(n) time to visit each node once");
    }
}
