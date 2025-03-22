import java.util.*;

public class Dijkstra {
    private static final int INF = 0x3f3f3f3f;
    public static void main (String args[]) {
        int graph[][] = new int[][] {
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
        };
        alShortestPath(graph, 0, graph.length);

        int numV = 9;
        List<List<Pair<Integer, Integer> > > adj = new ArrayList<>(numV);
        for (int i = 0; i < numV; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 7, 8);
        addEdge(adj, 1, 2, 8);
        addEdge(adj, 1, 7, 11);
        addEdge(adj, 2, 3, 7);
        addEdge(adj, 2, 8, 2);
        addEdge(adj, 2, 5, 4);
        addEdge(adj, 3, 4, 9);
        addEdge(adj, 3, 5, 14);
        addEdge(adj, 4, 5, 10);
        addEdge(adj, 5, 6, 2);
        addEdge(adj, 6, 7, 1);
        addEdge(adj, 6, 8, 6);
        addEdge(adj, 7, 8, 7);
        hShortestPath(adj, numV, 0);
    }

    private static void alShortestPath(int graph[][], int src, int v) {
        System.out.println("Shortest path using adjacency matrix");
        // output array
        // dist[i] will hold the shortest distance from src to i
        int dist[] = new int[v];
    
        // sptSet[i] will be true if vertex i is included in shorest path tree
        // or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[v];
        
        // init arrays
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        System.out.println("Creating distance array of length " + v);
        printSolution(dist, v);
        System.out.println("\nCreating included vertex array of length " + v);
        for (int i = 0; i < v; i++) {
            System.out.println("v" + i + ": " + sptSet[i]);
        }

        // init dist from src to itsself 
        dist[src] = 0; 
        System.out.println("\nInitializing distance from src to itself with 0");
        printSolution(dist, v);


        // find shortest path for all vertices
        for (int count = 0; count < v - 1; count++) {
            // pick the min distance vertex from the set of vertices not
            // yet processed. u is always equal to src in first iteration
            System.out.println("\nFinding min distance vertex from set not yet processed");
            int u = minDistance(dist, sptSet, v);
            System.out.println("Min distance vertex is v" + u + ", marking as processed");
            
            // mark the picked vertex as processed
            sptSet[u] = true;
            System.out.println("\nUpdated processed vertex set: ");
            for (int i = 0; i < v; i++) {
                System.out.println("v" + i + ": " + sptSet[i]);
            }

            // Update dist value of the adjacent vertices of the picked vertex
            System.out.println("\nUpdating distance values of adjacent verticies: ");
            for (int j = 0; j < v; j++) {
                // Update dist[j] only if its not in sptSet, there is an edge from
                // u to j, and total weight of path from src to j through u is
                // smaller than current value of dist[j]
                if (!sptSet[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][j] < dist[j]) {
                        System.out.printf("\t v%d not yet visited, there is an edge from v%d to v%d, total weight of path from v%d to v%d through v%d is < current weight\n", j, u, j, src, j, u);
                        dist[j] = dist[u] + graph[u][j];
                        System.out.printf("\t distance from v%d to v%d through v%d updated to %d\n", src, j, u, dist[j]);
                    } else if (sptSet[j]) {
                        System.out.printf("\t v%d already visited\n", j);
                    } else if (graph[u][j] == 0) {
                        continue;
                    } else if (dist[u] + graph[u][j] >= dist[j]) {
                        System.out.printf("\t distance from v%d to v%d through v%d is %d which is >= %d\n", src, j, u, dist[j] + graph[u][j], dist[j]);
                    }
            }
            System.out.println("Current distance values: ");
            printSolution(dist, v);
        }
    }

    private static int minDistance(int dist[], Boolean sptSet[], int v) {
        // init min value
        int min = Integer.MAX_VALUE, min_index = -1;
        System.out.println("\t initializing min value to ∞");

        for (int i = 0; i < v; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                System.out.println("\t v" + i + " not yet visited, distance of v" + i 
                + ": " + dist[i] + " is <= current min: " + (min == Integer.MAX_VALUE ? "∞" : min));
                min = dist[i];
                System.out.println("\t update min = " + dist[i]);
                min_index = i;
                System.out.println("\t update min index = " + i);
            }
        }
        return min_index;
    }

    private static void printSolution(int dist[], int v) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " \t\t\t ∞");
            } else {
                System.out.println(i + " \t\t\t " + dist[i]);
            }
        }
    }
    
    private static void hShortestPath(List<List<Pair<Integer, Integer> > > adj, int v, int src) {
        System.out.println("\nShortest path using a heap");
        
        // create a priority queue to store vertices that are being preprocessed
        System.out.println("Creating a priorty queue to store preprocessed vertices");
        PriorityQueue<Pair<Integer, Integer> > pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getFirst));
        
        // create a list for distances and initialize all distances as infinite (INF)
        System.out.println("Creating a list for distances and init");
        List<Integer> dist = new ArrayList<>(Collections.nCopies(v, INF));
        for (Integer vertex : dist) {
            System.out.println("v" + dist.indexOf(vertex) + " \t\t\t ∞");
        }

        // insert source itself in priority queue and init its distance to 0
        System.out.println("\nPut src into priority queue and set dist src to 0");
        pq.add(new Pair<>(0, src));
        dist.set(src, 0);
        System.out.println("Priority queue: [ (" + pq.peek().getFirst() + ", " + pq.peek().getSecond() + ") ]");
        printList(dist);

        // looping till priority queue becomes empty (or all distances are not finalized)
        System.out.println("\nLoop over priority queue until it is empty");
        while (!pq.isEmpty()) {
            // the first vertex in pair is the min distance vertex
            // extract it from priority queue
            int u = pq.peek().getSecond();
            pq.poll();
            System.out.println("\tv" + u + " is min distance vertex, popping");

            // get all adjacent of u
            System.out.println("\tFind all adjacent vertices of v" + u);
            for (Pair<Integer, Integer> x : adj.get(u)) {
                // get vertex label and weight of current adjacent of u
                int ver = x.getFirst();
                int weight = x.getSecond();

                // if there is a shorter path to v through u
                if (dist.get(ver) > dist.get(u) + weight) {
                    // updating distance of v
                    System.out.println("\t\tdistance of v" + ver + ": " + dist.get(ver) + " > v" 
                    + u + ": " + dist.get(u) + " + weight: " + weight);
                    dist.set(ver, dist.get(u) + weight);
                    System.out.println("\t\tSet distance of v" + ver + " to " + (dist.get(u) + weight));
                    pq.add(new Pair<>(dist.get(ver), ver));
                    System.out.println("\t\tAdd (" + dist.get(ver) + ", v" + ver + ") to priority queue");
                    System.out.println("Updated distances:");
                    printList(dist);
                }
            }
        }
        System.out.println("\nPriority queue empty");
    }

    private static void printList(List<Integer> dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (Integer vertex : dist) {
            if (vertex == INF) {
                System.out.println("v" + dist.indexOf(vertex) + " \t\t\t ∞");
            } else {
                System.out.println("v" + dist.indexOf(vertex) + " \t\t\t " + vertex);
            }
        }
    }

    private static void addEdge(List<List<Pair<Integer, Integer> > > adj, int u, int v, int wt) {
        adj.get(u).add(new Pair<>(v, wt));
        adj.get(v).add(new Pair<>(u, wt));
    }

    
}
class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }
    public U getSecond() {
        return this.second;
    }
}