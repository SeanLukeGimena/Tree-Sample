public class TreeSort {
    
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
    
    public TreeSort() {
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
     * SORT METHOD 1: Tree Sort
     * Inserts all elements into a BST and retrieves them in sorted order via in-order traversal
     * 
     * Algorithm:
     * 1. Insert each element into the BST
     * 2. Perform in-order traversal (Left -> Root -> Right)
     * 3. Elements come out in ascending order
     * 
     * Time Complexity: O(n log n) average, O(n²) worst case
     * Space Complexity: O(n)
     * 
     * @param array The unsorted array
     * @return Sorted array
     */
    public static int[] treeSort(int[] array) {
        System.out.println("--- Tree Sort ---");
        System.out.println("Sorting using Binary Search Tree");
        
        if (array == null || array.length == 0) {
            return array;
        }
        
        // Create tree and insert all elements
        TreeSort tree = new TreeSort();
        System.out.print("Inserting elements: ");
        for (int value : array) {
            tree.insert(value);
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Extract sorted elements through in-order traversal
        int[] sortedArray = new int[array.length];
        int[] index = {0};
        tree.inOrderToArray(tree.root, sortedArray, index);
        
        return sortedArray;
    }
    
    /**
     * Helper method to fill array with in-order traversal
     * Time Complexity: O(n)
     */
    private void inOrderToArray(TreeNode node, int[] array, int[] index) {
        if (node != null) {
            inOrderToArray(node.left, array, index);
            array[index[0]++] = node.data;
            inOrderToArray(node.right, array, index);
        }
    }
    
    /**
     * SORT METHOD 2: Reverse Tree Sort (Descending Order)
     * Uses reverse in-order traversal (Right -> Root -> Left) for descending order
     * 
     * Time Complexity: O(n log n) average, O(n²) worst case
     * Space Complexity: O(n)
     * 
     * @param array The unsorted array
     * @return Array sorted in descending order
     */
    public static int[] reverseTreeSort(int[] array) {
        System.out.println("\n--- Reverse Tree Sort ---");
        System.out.println("Sorting in descending order using BST");
        
        if (array == null || array.length == 0) {
            return array;
        }
        
        TreeSort tree = new TreeSort();
        System.out.print("Inserting elements: ");
        for (int value : array) {
            tree.insert(value);
            System.out.print(value + " ");
        }
        System.out.println();
        
        int[] sortedArray = new int[array.length];
        int[] index = {0};
        tree.reverseInOrderToArray(tree.root, sortedArray, index);
        
        return sortedArray;
    }
    
    /**
     * Helper method for reverse in-order traversal (Right -> Root -> Left)
     */
    private void reverseInOrderToArray(TreeNode node, int[] array, int[] index) {
        if (node != null) {
            reverseInOrderToArray(node.right, array, index);
            array[index[0]++] = node.data;
            reverseInOrderToArray(node.left, array, index);
        }
    }
    
    /**
     * Display an array
     */
    public static void displayArray(int[] array, String label) {
        System.out.print(label + ": ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * Compare sorted array with expected sorted result
     */
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Main method demonstrating tree sorting
     */
    public static void main(String[] args) {
        System.out.println("=== Tree Sorting ===\n");
        
        // Test Case 1: Random unsorted array
        int[] unsorted1 = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        System.out.println("Test Case 1: Random Array");
        displayArray(unsorted1, "Original");
        int[] sorted1 = treeSort(unsorted1);
        displayArray(sorted1, "Sorted");
        System.out.println("Is sorted: " + isArraySorted(sorted1));
        
        // Test Case 2: Reverse sorted array
        System.out.println("\n\nTest Case 2: Reverse Sorted Array");
        int[] unsorted2 = {90, 80, 70, 60, 50, 40, 30, 20, 10};
        displayArray(unsorted2, "Original");
        int[] sorted2 = treeSort(unsorted2);
        displayArray(sorted2, "Sorted");
        System.out.println("Is sorted: " + isArraySorted(sorted2));
        
        // Test Case 3: Already sorted array
        System.out.println("\n\nTest Case 3: Already Sorted Array");
        int[] unsorted3 = {10, 20, 30, 40, 50};
        displayArray(unsorted3, "Original");
        int[] sorted3 = treeSort(unsorted3);
        displayArray(sorted3, "Sorted");
        System.out.println("Is sorted: " + isArraySorted(sorted3));
        
        // Test Case 4: Array with duplicates
        System.out.println("\n\nTest Case 4: Array with Duplicates");
        int[] unsorted4 = {50, 30, 70, 30, 50, 20, 70};
        displayArray(unsorted4, "Original");
        int[] sorted4 = treeSort(unsorted4);
        displayArray(sorted4, "Sorted");
        System.out.println("Is sorted: " + isArraySorted(sorted4));
        
        // Test Case 5: Reverse sort
        System.out.println("\n\nTest Case 5: Descending Order Sort");
        int[] unsorted5 = {15, 45, 23, 87, 12, 56};
        displayArray(unsorted5, "Original");
        int[] sorted5 = reverseTreeSort(unsorted5);
        displayArray(sorted5, "Sorted (Descending)");
        
        // Verify descending order
        boolean isDescending = true;
        for (int i = 0; i < sorted5.length - 1; i++) {
            if (sorted5[i] < sorted5[i + 1]) {
                isDescending = false;
                break;
            }
        }
        System.out.println("Is descending: " + isDescending);
    }
}
