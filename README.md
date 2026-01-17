# Trees Sample Codes

A comprehensive collection of Java implementations demonstrating tree data structures and algorithms.

## Project Structure

```
Trees Sample Codes/
├── src/
│   ├── BasicTree.java
│   ├── TreeAddDelete.java
│   ├── TreeSort.java
│   ├── TreeMerge.java
│   ├── TreeSearch.java
│   ├── TreeRecursion.java
│   └── TreeTraversal.java
└── README.md
```

## Files Overview

### 1. BasicTree.java
**Core Binary Search Tree Implementation**
- Demonstrates fundamental BST operations
- Insert, search operations
- Multiple traversal methods (in-order, pre-order, post-order)
- Time Complexity: O(log n) average, O(n) worst case
- Space Complexity: O(n)

### 2. TreeAddDelete.java
**Tree Addition and Deletion Operations**
- Comprehensive insertion algorithm
- Complex deletion with three cases:
  - Leaf nodes (no children)
  - Nodes with one child
  - Nodes with two children
- In-order successor strategy for balancing
- Time Complexity: O(log n) average, O(n) worst case

### 3. TreeSort.java
**Sorting Using Binary Search Trees**
- Tree sort algorithm
- Reverse tree sort (descending order)
- In-order traversal extraction
- Time Complexity: O(n log n) average, O(n²) worst case
- Multiple test cases included

### 4. TreeMerge.java
**Merging Two Binary Search Trees**
- Three merge methods:
  1. Collect and Insert
  2. In-place Merge
  3. Balanced Merge via Combined Traversal
- Efficient node handling
- Time Complexity: O(n + m) for all methods
- Space Complexity varies by method

### 5. TreeSearch.java
**Comprehensive Search Operations**
- Binary search (recursive and iterative)
- Find minimum and maximum values
- Range search with results collection
- Count nodes in range
- Find closest value to target
- Time Complexity: O(log n) average to O(log n + k) for range queries

### 6. TreeRecursion.java
**Recursive Tree Operations**
- Calculate tree height
- Tree traversals via recursion
- Sum and count of nodes
- Path finding with target sum
- Tree balancing check
- Tree cloning
- Time Complexity: O(n) for most operations
- Space Complexity: O(h) where h is height

### 7. TreeTraversal.java
**All Tree Traversal Techniques**
- In-order traversal (recursive and iterative)
- Pre-order traversal (recursive and iterative)
- Post-order traversal (recursive and iterative)
- Level-order traversal (BFS)
- Level-order with level separation
- Depth-first search (DFS)
- Vertical order traversal
- Time Complexity: O(n) for all traversals
- Space Complexity varies by method

## Key Features

✅ **Complete Documentation**
- Detailed comments explaining algorithms
- Time and space complexity analysis
- Use cases and applications

✅ **Multiple Implementations**
- Recursive and iterative approaches
- Different algorithmic strategies
- Edge case handling

✅ **Comprehensive Examples**
- Test cases in main methods
- Multiple scenarios and inputs
- Output demonstrations

✅ **MotorPH Applications**
- Hierarchical data management
- Efficient searching and sorting
- Dynamic inventory tracking
- Employee record organization

## Complexity Summary

### Time Complexity
| Operation | Average | Worst Case |
|-----------|---------|-----------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Traversal | O(n) | O(n) |
| Sort | O(n log n) | O(n²) |

### Space Complexity
| Operation | Space |
|-----------|-------|
| Tree Storage | O(n) |
| Recursive Calls | O(h) |
| Stack Operations | O(h) |
| Queue Operations | O(w) |

## Compilation and Execution

### Compile all files
```bash
javac src/*.java
```

### Run individual files
```bash
java -cp src BasicTree
java -cp src TreeAddDelete
java -cp src TreeSort
java -cp src TreeMerge
java -cp src TreeSearch
java -cp src TreeRecursion
java -cp src TreeTraversal
```

## Use Cases for MotorPH

1. **Hierarchical Data Organization**
   - Employee organizational structure
   - Department hierarchy
   - Vehicle categorization

2. **Efficient Search and Retrieval**
   - Quick lookup of vehicle records
   - Employee information access
   - Customer data retrieval

3. **Dynamic Inventory Management**
   - Add/remove vehicle inventory items
   - Maintain sorted stock levels
   - Track price ranges

4. **Reporting and Analytics**
   - Generate sorted reports
   - Range-based queries
   - Hierarchical data aggregation

## Learning Objectives

After studying these implementations, you should understand:
- ✓ Binary Search Tree properties and operations
- ✓ Recursive vs iterative approaches
- ✓ Tree traversal methods and their applications
- ✓ Algorithm complexity analysis
- ✓ Practical implementations of tree algorithms
- ✓ How to apply trees to real-world problems

## References

- Data Structures and Algorithms (DSAA)
- Binary Search Tree principles
- Tree traversal techniques
- Algorithm complexity analysis

---

**Created for**: DSA Learning - Week 2  
**Data Structure Focus**: Trees (Binary Search Trees)  
**Java Version**: Java 8+
