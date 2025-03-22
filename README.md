# Java_DSA

# Algorithm Implementations

## Greedy Algorithms

### Dijkstra's Algorithm

#### Definition
Dijkstra's Algorithm is a graph search algorithm that finds the shortest path from a single source node to all other nodes in a weighted graph with non-negative edge weights.

#### Explanation
Dijkstra's Algorithm operates by maintaining a priority queue (min-heap) to process nodes based on their current shortest known distance from the source. It follows these steps:

1. **Initialization**:
   - Assign an initial distance of 0 to the source node and infinity to all other nodes.
   - Mark all nodes as unvisited.
   - Use a priority queue to store nodes based on their tentative distances.

2. **Processing Nodes**:
   - Extract the node with the smallest distance from the priority queue.
   - Update the distance for each of its unvisited neighbors if a shorter path is found through the current node.
   - Insert or update neighboring nodes in the priority queue.

3. **Termination**:
   - The algorithm stops when all nodes have been visited or when the shortest distance to the target node has been found (if a specific destination is required).

#### Time Complexity
- Using a simple array: **O(V^2)** (where V is the number of vertices)
- Using a priority queue (binary heap): **O((V + E) log V)** (where E is the number of edges)

#### Usage
Dijkstra's Algorithm is widely used in various applications, including:
- **Network Routing**: Finding the shortest path in networking and telecommunications.
- **GPS Navigation Systems**: Computing the quickest route from one location to another.
- **Graph-based AI**: Used in pathfinding algorithms for game development and robotics.
- **Operations Research**: Solving shortest path problems in logistics and supply chain optimization.

---

## Divide and Conquer Algorithms

### Binary Search

#### Definition
Binary Search is a searching algorithm that finds the position of a target value within a sorted array by repeatedly dividing the search interval in half.

#### Explanation
1. **Initialization**:
   - Define the low and high pointers at the beginning and end of the array.
2. **Search Process**:
   - Find the middle element of the array.
   - If the middle element is the target, return its index.
   - If the target is smaller, search in the left half; otherwise, search in the right half.
   - Repeat the process until the element is found or the search space is exhausted.

#### Time Complexity
- **O(log N)** in the worst and average cases.

---

### Merge Sort

#### Definition
Merge Sort is a divide-and-conquer sorting algorithm that recursively divides the array into two halves, sorts each half, and then merges them.

#### Explanation
1. **Divide**: Split the array into two halves until each subarray contains a single element.
2. **Conquer**: Recursively sort each half.
3. **Merge**: Merge sorted halves back together.

#### Time Complexity
- **O(N log N)** in all cases.

---

## Conclusion
This repository contains implementations of various algorithms categorized by their type. Feel free to contribute with more examples, optimizations, or explanations!

