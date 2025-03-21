public class Dijkstra {
    public static void main (String args[]) {

    }

    private static int minDistance(int dist[], Boolean sptSet[], int v) {
        // init min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < v; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    private static int[] dShortestPath(int graph[][], int src, int v) {
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

        // init dist from src to itsself 
        dist[src] = 0;

        // find shortest path for all vertices
        for (int count = 0; count < v - 1; count++) {
            // pick the min distance vertex from the set of vertices not
            // yet processed. u is always equal to src in first iteration
            int u = minDistance(dist, sptSet, v);

            // mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex
            for (int j = 0; j < v; j++) {
                // Update dist[i] only if its not in sptSet, there is an edge from
                // u to v, and total weight of path from src to v through u is
                // smaller than current value of dist[i]
                if (!sptSet[j] && graph[u][j] != 0 && dist[j] != Integer.MAX_VALUE
                    && dist[j] + graph[u][j] < dist[j]) {
                        dist[j] = dist[u] + graph[u][j];
                    }
            }
        }
        return dist;
    }
}