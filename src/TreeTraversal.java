import java.util.*;

public class TreeTraversal {
    
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
    
    public TreeTraversal() {
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
     * TRAVERSAL 1: In-Order Traversal (Recursive)
     * Visits nodes in order: Left -> Root -> Right
     * For BST, produces elements in sorted (ascending) order
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) for recursion stack
     * 
     * Use Cases:
     * - Getting sorted data from BST
     * - Testing if BST is valid
     * - Expression evaluation
     */
    public void inOrderRecursive() {
        System.out.print("In-Order (Recursive):   ");
        inOrderHelper(root);
        System.out.println();
    }
    
    private void inOrderHelper(TreeNode node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }
    
    /**
     * TRAVERSAL 2: In-Order Traversal (Iterative)
     * Uses a stack to simulate recursion
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) for stack
     * 
     * Algorithm:
     * 1. Push all left nodes onto stack
     * 2. Pop and process node
     * 3. Go to right child
     */
    public void inOrderIterative() {
        System.out.print("In-Order (Iterative):   ");
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Go to leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Current is null, pop from stack
            current = stack.pop();
            System.out.print(current.data + " ");
            
            // Go to right child
            current = current.right;
        }
        System.out.println();
    }
    
    /**
     * TRAVERSAL 3: Pre-Order Traversal (Recursive)
     * Visits nodes in order: Root -> Left -> Right
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     * 
     * Use Cases:
     * - Creating a copy of tree
     * - Pre-fixing expression (Polish notation)
     * - Serializing tree
     */
    public void preOrderRecursive() {
        System.out.print("Pre-Order (Recursive):  ");
        preOrderHelper(root);
        System.out.println();
    }
    
    private void preOrderHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }
    
    /**
     * TRAVERSAL 4: Pre-Order Traversal (Iterative)
     * Uses a single stack
     * 
     * Algorithm:
     * 1. Push root to stack
     * 2. While stack not empty:
     *    - Pop and process node
     *    - Push right then left (to maintain left-first order)
     */
    public void preOrderIterative() {
        System.out.print("Pre-Order (Iterative):  ");
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");
            
            // Push right first so left is processed first (stack is LIFO)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        System.out.println();
    }
    
    /**
     * TRAVERSAL 5: Post-Order Traversal (Recursive)
     * Visits nodes in order: Left -> Right -> Root
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     * 
     * Use Cases:
     * - Deleting tree (delete children before parent)
     * - Post-fixing expression (Reverse Polish notation)
     * - Calculating tree properties
     */
    public void postOrderRecursive() {
        System.out.print("Post-Order (Recursive): ");
        postOrderHelper(root);
        System.out.println();
    }
    
    private void postOrderHelper(TreeNode node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    /**
     * TRAVERSAL 6: Post-Order Traversal (Iterative)
     * Uses two stacks or one stack with tracking
     * 
     * Algorithm (using two stacks):
     * 1. Process nodes in pre-order manner into stack2
     * 2. Stack2 will have nodes in post-order
     */
    public void postOrderIterative() {
        System.out.print("Post-Order (Iterative): ");
        if (root == null) return;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root);
        
        // Fill stack2 with pre-order traversal (Root -> Right -> Left)
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        
        // stack2 now contains post-order traversal
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
        System.out.println();
    }
    
    /**
     * TRAVERSAL 7: Level-Order Traversal (BFS)
     * Visits all nodes level by level from top to bottom
     * Uses a queue (FIFO)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(w) where w is max width
     * 
     * Use Cases:
     * - Finding shortest path
     * - Level-by-level processing
     * - Reconstructing tree from breadth-first data
     */
    public void levelOrderTraversal() {
        System.out.print("Level-Order (BFS):      ");
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
    
    /**
     * TRAVERSAL 8: Level-Order with Level Separation
     * Returns list of lists, each inner list represents one level
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(w) for queue, O(n) for result
     * 
     * @return List of lists representing each level
     */
    public List<List<Integer>> levelOrderByLevel() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.data);
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
    
    /**
     * TRAVERSAL 9: Depth-First Search (DFS) - Generic
     * Can be implemented recursively (all other traversals are DFS)
     * or with explicit stack
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void depthFirstSearch() {
        System.out.print("Depth-First Search (DFS): ");
        dfsHelper(root);
        System.out.println();
    }
    
    private void dfsHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            dfsHelper(node.left);
            dfsHelper(node.right);
        }
    }
    
    /**
     * TRAVERSAL 10: Vertical Order Traversal
     * Groups nodes by their vertical position
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @return Sorted map of vertical position to node values
     */
    public Map<Integer, List<Integer>> verticalOrderTraversal() {
        Map<Integer, List<Integer>> result = new TreeMap<>();
        if (root == null) return result;
        
        Queue<NodeVerticalLevel> queue = new LinkedList<>();
        queue.add(new NodeVerticalLevel(root, 0));
        
        while (!queue.isEmpty()) {
            NodeVerticalLevel nvl = queue.poll();
            TreeNode node = nvl.node;
            int verticalLevel = nvl.verticalLevel;
            
            result.computeIfAbsent(verticalLevel, k -> new ArrayList<>()).add(node.data);
            
            if (node.left != null) {
                queue.add(new NodeVerticalLevel(node.left, verticalLevel - 1));
            }
            if (node.right != null) {
                queue.add(new NodeVerticalLevel(node.right, verticalLevel + 1));
            }
        }
        
        return result;
    }
    
    /**
     * Helper class for vertical order traversal
     */
    static class NodeVerticalLevel {
        TreeNode node;
        int verticalLevel;
        
        NodeVerticalLevel(TreeNode node, int verticalLevel) {
            this.node = node;
            this.verticalLevel = verticalLevel;
        }
    }
    
    /**
     * Main method demonstrating all traversal methods
     */
    public static void main(String[] args) {
        System.out.println("=== Tree Traversal Methods ===\n");
        
        TreeTraversal tree = new TreeTraversal();
        
        // Build a sample tree
        System.out.println("Building tree with values: 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 65");
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
        
        System.out.println("\nTree Structure (approximately):");
        System.out.println("           50");
        System.out.println("          /  \\");
        System.out.println("        30    70");
        System.out.println("       / \\   / \\");
        System.out.println("      20 40 60 80");
        System.out.println("     / \\  /");
        System.out.println("    10 25 35 65");
        
        System.out.println("\n--- RECURSIVE TRAVERSALS ---");
        tree.inOrderRecursive();
        tree.preOrderRecursive();
        tree.postOrderRecursive();
        tree.depthFirstSearch();
        
        System.out.println("\n--- ITERATIVE TRAVERSALS ---");
        tree.inOrderIterative();
        tree.preOrderIterative();
        tree.postOrderIterative();
        
        System.out.println("\n--- BREADTH-FIRST TRAVERSALS ---");
        tree.levelOrderTraversal();
        
        System.out.println("\n--- LEVEL-ORDER BY LEVEL ---");
        List<List<Integer>> levels = tree.levelOrderByLevel();
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + i + ": " + levels.get(i));
        }
        
        System.out.println("\n--- VERTICAL ORDER TRAVERSAL ---");
        Map<Integer, List<Integer>> verticalOrder = tree.verticalOrderTraversal();
        for (Map.Entry<Integer, List<Integer>> entry : verticalOrder.entrySet()) {
            System.out.println("Column " + entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n--- TIME AND SPACE COMPLEXITY ---");
        System.out.println("All Traversals:");
        System.out.println("  Time Complexity: O(n) - visit each node once");
        System.out.println("  Space Complexity:");
        System.out.println("    Recursive: O(h) for recursion stack");
        System.out.println("    Iterative In/Pre/Post-Order: O(h) for stack");
        System.out.println("    Level-Order: O(w) for queue (w = max width)");
        System.out.println("    For balanced tree: h = log n, w ≤ n");
    }
}
