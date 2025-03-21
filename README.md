# Java_DSA

# Dijkstra's Algorithm

## Definition
Dijkstra's Algorithm is a graph search algorithm that finds the shortest path from a single source node to all other nodes in a weighted graph with non-negative edge weights.

## Explanation
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

### Time Complexity
- Using a simple array: **O(V^2)** (where V is the number of vertices)
- Using a priority queue (binary heap): **O((V + E) log V)** (where E is the number of edges)

## Usage
Dijkstra's Algorithm is widely used in various applications, including:
- **Network Routing**: Finding the shortest path in networking and telecommunications.
- **GPS Navigation Systems**: Computing the quickest route from one location to another.
- **Graph-based AI**: Used in pathfinding algorithms for game development and robotics.
- **Operations Research**: Solving shortest path problems in logistics and supply chain optimization.


---
Feel free to contribute to this repository with more examples, optimizations, or applications!

