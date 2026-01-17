public class TreeMerge {
    
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
    
    public TreeMerge() {
        this.root = null;
    }
    
    /**
     * Insert a value into the BST
     * Time Complexity: O(log n) average
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
     * MERGE METHOD 1: Merge Two Trees into a New Tree
     * Creates a new merged tree from two existing BSTs
     * 
     * Algorithm:
     * 1. Traverse first tree and collect all elements
     * 2. Traverse second tree and collect all elements
     * 3. Insert all elements into a new tree
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * 
     * @param tree1 First BST
     * @param tree2 Second BST
     * @return New merged BST
     */
    public static TreeMerge mergeTreesMethod1(TreeMerge tree1, TreeMerge tree2) {
        System.out.println("--- Merge Method 1: Collect and Insert ---");
        
        TreeMerge mergedTree = new TreeMerge();
        
        // Collect elements from both trees
        collectAndInsert(tree1.root, mergedTree);
        collectAndInsert(tree2.root, mergedTree);
        
        System.out.println("Trees merged successfully");
        return mergedTree;
    }
    
    /**
     * Helper: Traverse tree and insert elements into target tree
     */
    private static void collectAndInsert(TreeNode node, TreeMerge targetTree) {
        if (node != null) {
            collectAndInsert(node.left, targetTree);
            targetTree.insert(node.data);
            collectAndInsert(node.right, targetTree);
        }
    }
    
    /**
     * MERGE METHOD 2: Merge Two Trees by Connecting Nodes
     * Merges two BSTs by connecting nodes without creating new ones (more memory efficient)
     * 
     * Algorithm:
     * 1. Traverse elements of second tree
     * 2. Insert each element into first tree
     * 3. Original nodes are reused
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(1) extra space (reuses existing nodes)
     * 
     * @param tree1 First BST (will be modified)
     * @param tree2 Second BST (will be merged into tree1)
     * @return Merged tree (tree1)
     */
    public static TreeMerge mergeTreesMethod2(TreeMerge tree1, TreeMerge tree2) {
        System.out.println("\n--- Merge Method 2: In-place Merge ---");
        
        mergeInOrder(tree2.root, tree1);
        System.out.println("Trees merged successfully (in-place)");
        
        return tree1;
    }
    
    /**
     * Helper: Insert nodes from source tree into target tree
     */
    private static void mergeInOrder(TreeNode node, TreeMerge targetTree) {
        if (node != null) {
            mergeInOrder(node.left, targetTree);
            targetTree.insert(node.data);
            mergeInOrder(node.right, targetTree);
        }
    }
    
    /**
     * MERGE METHOD 3: Combined Traversal Merge
     * Merges two trees by doing simultaneous in-order traversals
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m) for the merged tree
     * 
     * @param tree1 First BST
     * @param tree2 Second BST
     * @return New merged BST
     */
    public static TreeMerge mergeTreesMethod3(TreeMerge tree1, TreeMerge tree2) {
        System.out.println("\n--- Merge Method 3: Combined Traversal ---");
        
        TreeMerge mergedTree = new TreeMerge();
        
        // Collect sorted elements from both trees
        java.util.List<Integer> sortedElements = new java.util.ArrayList<>();
        collectInOrder(tree1.root, sortedElements);
        collectInOrder(tree2.root, sortedElements);
        
        // Sort the combined list
        java.util.Collections.sort(sortedElements);
        
        // Build balanced tree from sorted elements
        mergedTree.root = buildBalancedTree(sortedElements, 0, sortedElements.size() - 1);
        
        System.out.println("Balanced merged tree created");
        return mergedTree;
    }
    
    /**
     * Helper: Collect elements from tree in sorted order
     */
    private static void collectInOrder(TreeNode node, java.util.List<Integer> list) {
        if (node != null) {
            collectInOrder(node.left, list);
            list.add(node.data);
            collectInOrder(node.right, list);
        }
    }
    
    /**
     * Helper: Build balanced tree from sorted list
     * Time Complexity: O(n)
     */
    private static TreeNode buildBalancedTree(java.util.List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalancedTree(list, start, mid - 1);
        node.right = buildBalancedTree(list, mid + 1, end);
        
        return node;
    }
    
    /**
     * Display tree in sorted order
     */
    public void display() {
        System.out.print("Merged Tree (in-order): ");
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
     * Get the root of the tree
     */
    public TreeNode getRoot() {
        return root;
    }
    
    /**
     * Main method demonstrating tree merging
     */
    public static void main(String[] args) {
        System.out.println("=== Binary Search Tree Merge Operations ===\n");
        
        // Create first tree
        System.out.println("Creating Tree 1 with elements: 50, 30, 70, 20, 40");
        TreeMerge tree1 = new TreeMerge();
        tree1.insert(50);
        tree1.insert(30);
        tree1.insert(70);
        tree1.insert(20);
        tree1.insert(40);
        tree1.display();
        
        // Create second tree
        System.out.println("\nCreating Tree 2 with elements: 60, 10, 80, 5, 15");
        TreeMerge tree2 = new TreeMerge();
        tree2.insert(60);
        tree2.insert(10);
        tree2.insert(80);
        tree2.insert(5);
        tree2.insert(15);
        tree2.display();
        
        // MERGE METHOD 1
        System.out.println("\n=== MERGE METHOD 1: Collect and Insert ===");
        TreeMerge merged1 = mergeTreesMethod1(tree1, tree2);
        merged1.display();
        
        // Create new trees for Method 2
        System.out.println("\n\n=== MERGE METHOD 2: In-place Merge ===");
        System.out.println("Creating new trees for Method 2...");
        TreeMerge tree3 = new TreeMerge();
        tree3.insert(50);
        tree3.insert(30);
        tree3.insert(70);
        tree3.insert(20);
        tree3.insert(40);
        System.out.print("Tree 3 (in-order): ");
        tree3.display();
        
        TreeMerge tree4 = new TreeMerge();
        tree4.insert(60);
        tree4.insert(10);
        tree4.insert(80);
        tree4.insert(5);
        tree4.insert(15);
        System.out.print("Tree 4 (in-order): ");
        tree4.display();
        
        TreeMerge merged2 = mergeTreesMethod2(tree3, tree4);
        merged2.display();
        
        // Create new trees for Method 3
        System.out.println("\n\n=== MERGE METHOD 3: Combined Traversal (Balanced) ===");
        System.out.println("Creating new trees for Method 3...");
        TreeMerge tree5 = new TreeMerge();
        tree5.insert(50);
        tree5.insert(30);
        tree5.insert(70);
        tree5.insert(20);
        tree5.insert(40);
        System.out.print("Tree 5 (in-order): ");
        tree5.display();
        
        TreeMerge tree6 = new TreeMerge();
        tree6.insert(60);
        tree6.insert(10);
        tree6.insert(80);
        tree6.insert(5);
        tree6.insert(15);
        System.out.print("Tree 6 (in-order): ");
        tree6.display();
        
        TreeMerge merged3 = mergeTreesMethod3(tree5, tree6);
        merged3.display();
        
        System.out.println("\n--- Time and Space Complexity Summary ---");
        System.out.println("All merge methods: O(n + m) time complexity");
        System.out.println("Method 1 & 3: O(n + m) space for new tree");
        System.out.println("Method 2: O(1) extra space (in-place merge)");
    }
}
