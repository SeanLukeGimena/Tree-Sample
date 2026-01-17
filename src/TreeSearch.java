public class TreeSearch {
    
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
    
    public TreeSearch() {
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
     * SEARCH 1: Binary Search (Recursive)
     * Efficiently searches for a value using BST property
     * 
     * Algorithm:
     * 1. Start at root
     * 2. If value equals node, return true
     * 3. If value < node.data, search left subtree
     * 4. If value > node.data, search right subtree
     * 
     * Time Complexity: O(log n) average, O(n) worst case (unbalanced)
     * Space Complexity: O(log n) for recursion stack
     * 
     * @param data The value to search
     * @return true if found, false otherwise
     */
    public boolean binarySearchRecursive(int data) {
        return searchRecursive(root, data);
    }
    
    private boolean searchRecursive(TreeNode node, int data) {
        // Base case: node is null
        if (node == null) {
            return false;
        }
        
        // Found the value
        if (node.data == data) {
            System.out.println("Found: " + data);
            return true;
        }
        
        // Search in appropriate subtree
        if (data < node.data) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }
    
    /**
     * SEARCH 2: Binary Search (Iterative)
     * Non-recursive version for better space efficiency
     * 
     * Algorithm:
     * 1. Start at root
     * 2. While node is not null:
     *    - If value equals node, return true
     *    - If value < node.data, move to left child
     *    - If value > node.data, move to right child
     * 3. Return false if not found
     * 
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(1) - only uses a pointer
     * 
     * @param data The value to search
     * @return true if found, false otherwise
     */
    public boolean binarySearchIterative(int data) {
        TreeNode current = root;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println("Found: " + data);
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        System.out.println("Not found: " + data);
        return false;
    }
    
    /**
     * SEARCH 3: Find Minimum Value
     * Finds the smallest element in the tree
     * 
     * Algorithm:
     * - Keep traversing to the left until reaching a node with no left child
     * 
     * Time Complexity: O(log n) average, O(n) worst case (unbalanced)
     * 
     * @return Minimum value in tree, -1 if empty
     */
    public int findMinimum() {
        if (root == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        
        System.out.println("Minimum value: " + current.data);
        return current.data;
    }
    
    /**
     * SEARCH 4: Find Maximum Value
     * Finds the largest element in the tree
     * 
     * Algorithm:
     * - Keep traversing to the right until reaching a node with no right child
     * 
     * Time Complexity: O(log n) average, O(n) worst case (unbalanced)
     * 
     * @return Maximum value in tree, -1 if empty
     */
    public int findMaximum() {
        if (root == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        System.out.println("Maximum value: " + current.data);
        return current.data;
    }
    
    /**
     * SEARCH 5: Range Search
     * Finds all values within a given range [min, max]
     * 
     * Algorithm:
     * 1. Traverse tree maintaining range bounds
     * 2. If node value is in range, include it
     * 3. Recursively search left if node.data > min
     * 4. Recursively search right if node.data < max
     * 
     * Time Complexity: O(k + log n) where k is number of results
     * Space Complexity: O(k) for storing results
     * 
     * @param min Minimum value of range (inclusive)
     * @param max Maximum value of range (inclusive)
     * @return List of values in range
     */
    public java.util.List<Integer> rangeSearch(int min, int max) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        rangeSearchHelper(root, min, max, result);
        return result;
    }
    
    private void rangeSearchHelper(TreeNode node, int min, int max, java.util.List<Integer> result) {
        if (node == null) {
            return;
        }
        
        // If node is in range, include it
        if (node.data >= min && node.data <= max) {
            result.add(node.data);
        }
        
        // Recursively search left subtree if needed
        if (node.data > min) {
            rangeSearchHelper(node.left, min, max, result);
        }
        
        // Recursively search right subtree if needed
        if (node.data < max) {
            rangeSearchHelper(node.right, min, max, result);
        }
    }
    
    /**
     * SEARCH 6: Count Occurrences in Range
     * Counts how many values fall within a range
     * 
     * Time Complexity: O(k + log n) where k is number of results
     * Space Complexity: O(log n) for recursion
     * 
     * @param min Minimum value
     * @param max Maximum value
     * @return Count of values in range
     */
    public int countInRange(int min, int max) {
        return countInRangeHelper(root, min, max);
    }
    
    private int countInRangeHelper(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        
        // Count this node if in range
        if (node.data >= min && node.data <= max) {
            count = 1;
        }
        
        // Count in left subtree if needed
        if (node.data > min) {
            count += countInRangeHelper(node.left, min, max);
        }
        
        // Count in right subtree if needed
        if (node.data < max) {
            count += countInRangeHelper(node.right, min, max);
        }
        
        return count;
    }
    
    /**
     * SEARCH 7: Find Closest Value
     * Finds the value in tree closest to a target value
     * 
     * Time Complexity: O(log n) average
     * Space Complexity: O(log n) for recursion
     * 
     * @param target The target value
     * @return The closest value in tree
     */
    public int findClosest(int target) {
        if (root == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        
        int[] closest = {root.data};
        findClosestHelper(root, target, closest);
        System.out.println("Closest value to " + target + ": " + closest[0]);
        return closest[0];
    }
    
    private void findClosestHelper(TreeNode node, int target, int[] closest) {
        if (node == null) {
            return;
        }
        
        // Update closest if current node is closer
        if (Math.abs(node.data - target) < Math.abs(closest[0] - target)) {
            closest[0] = node.data;
        }
        
        // Continue searching in appropriate direction
        if (target < node.data) {
            findClosestHelper(node.left, target, closest);
        } else if (target > node.data) {
            findClosestHelper(node.right, target, closest);
        }
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
     * Main method demonstrating search operations
     */
    public static void main(String[] args) {
        System.out.println("=== Binary Search Tree Search Operations ===\n");
        
        TreeSearch tree = new TreeSearch();
        
        // Build tree
        System.out.println("Building tree with values: 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 65, 75, 85");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(25);
        tree.insert(35);
        tree.insert(65);
        tree.insert(75);
        tree.insert(85);
        tree.display();
        
        // SEARCH 1: Binary Search Recursive
        System.out.println("\n--- SEARCH 1: Binary Search (Recursive) ---");
        tree.binarySearchRecursive(40);
        tree.binarySearchRecursive(100);
        
        // SEARCH 2: Binary Search Iterative
        System.out.println("\n--- SEARCH 2: Binary Search (Iterative) ---");
        tree.binarySearchIterative(30);
        tree.binarySearchIterative(55);
        
        // SEARCH 3: Find Minimum
        System.out.println("\n--- SEARCH 3: Find Minimum ---");
        tree.findMinimum();
        
        // SEARCH 4: Find Maximum
        System.out.println("\n--- SEARCH 4: Find Maximum ---");
        tree.findMaximum();
        
        // SEARCH 5: Range Search
        System.out.println("\n--- SEARCH 5: Range Search (20-60) ---");
        java.util.List<Integer> rangeResults = tree.rangeSearch(20, 60);
        System.out.println("Values in range [20, 60]: " + rangeResults);
        
        // SEARCH 6: Count in Range
        System.out.println("\n--- SEARCH 6: Count in Range (30-70) ---");
        int count = tree.countInRange(30, 70);
        System.out.println("Count of values in range [30, 70]: " + count);
        
        // SEARCH 7: Find Closest
        System.out.println("\n--- SEARCH 7: Find Closest Value ---");
        tree.findClosest(15);
        tree.findClosest(63);
        tree.findClosest(50);
        
        System.out.println("\n--- Time Complexity Summary ---");
        System.out.println("Binary Search: O(log n) average, O(n) worst case");
        System.out.println("Find Min/Max: O(log n) average");
        System.out.println("Range Search: O(k + log n) where k is result count");
        System.out.println("Find Closest: O(log n) average");
    }
}
