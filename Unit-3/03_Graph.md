## 1. Graph: Definition

A **graph** is a non-linear data structure made up of a set of **vertices (or nodes)** and **edges** that connect pairs of vertices.

A graph is written as:

\[
G = (V, E)
\]

- `V` = set of vertices (nodes)
- `E` = set of edges (connections)

**Example:** If `V = {0, 1, 2, 3}` and `E = {(0,1), (0,2), (1,3)}`, the graph has four vertices and three edges.

### terms

- **Vertex:** A node in a graph.
- **Edge:** A connection between two vertices.
- **Adjacent vertices:** Two vertices connected by an edge.
- **Degree:** Number of edges connected to a vertex in an undirected graph.
- **Path:** A sequence of vertices connected by edges.
- **Cycle:** A path that starts and ends at the same vertex.
- **Connected graph:** An undirected graph in which every vertex can be reached from every other vertex.
- **Component:** A maximal connected part of a graph.
- **Self-loop:** An edge from a vertex to itself.
- **Parallel edges:** More than one edge joining the same pair of vertices.

---

## 2. Types of Graphs

1. **Undirected graph:** Edges have no direction. If `0` is connected to `1`, travel is possible both ways.
2. **Directed graph (Digraph):** Every edge has a direction, such as `0 → 1`.
3. **Weighted graph:** Edges have weights or costs, such as distance or time.
4. **Unweighted graph:** Edges do not have weights.
5. **Connected graph:** Every vertex is reachable from every other vertex (for an undirected graph).
6. **Disconnected graph:** At least one vertex cannot be reached from another.
7. **Cyclic graph:** Contains at least one cycle.
8. **Acyclic graph:** Contains no cycle.
9. **Complete graph:** Every pair of distinct vertices is connected by an edge.
10. **Bipartite graph:** Vertices can be divided into two sets so that every edge connects vertices from different sets.
11. **Tree:** A connected, undirected graph with no cycle.

---

## 3. Graph Representation

A graph is commonly represented in two ways:

- Adjacency Matrix
- Adjacency List

We will use this undirected graph in the examples:

```text
0 ----- 1
|       |
|       |
2 ----- 3
```

Edges: `(0,1), (0,2), (1,3), (2,3)`

### 3.1 Adjacency Matrix

An **adjacency matrix** is a 2D array of size `V × V`.

- `matrix[i][j] = 1` means an edge exists between `i` and `j`.
- `matrix[i][j] = 0` means no edge exists.
- For an undirected graph, the matrix is symmetric.

For the example:

```text
    0  1  2  3
  +------------
0 | 0  1  1  0
1 | 1  0  0  1
2 | 1  0  0  1
3 | 0  1  1  0
```

**Java code:**

```java
class AdjacencyMatrix {
    public static void main(String[] args) {
        int vertices = 4;
        int[][] matrix = new int[vertices][vertices];

        // Undirected edges
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}
        };

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        // Print matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

**Complexity:**
- Space: `O(V²)`
- Checking whether an edge exists: `O(1)`
- Suitable for dense graphs (graphs with many edges).

### 3.2 Adjacency List

An **adjacency list** stores the neighbours of each vertex. It is commonly implemented using an array of lists.

For the example:

```text
0 -> 1, 2
1 -> 0, 3
2 -> 0, 3
3 -> 1, 2
```

**Java code:**

```java
import java.util.*;

class AdjacencyList {
    public static void main(String[] args) {
        int vertices = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create an empty list for every vertex
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected edges
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}
        };

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Print adjacency list
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}
```

**Complexity:**
- Space: `O(V + E)`
- Listing all neighbours of a vertex: proportional to its degree.
- Suitable for sparse graphs (graphs with fewer edges).

## 4. BFS (Breadth-First Search)

**Breadth-First Search (BFS)** is a graph traversal algorithm that visits vertices level by level. It visits the nearest unvisited neighbours first.

BFS uses a **Queue (FIFO: First In, First Out)**.

### BFS steps

1. Select a starting vertex.
2. Mark it as visited and add it to the queue.
3. Remove a vertex from the front of the queue.
4. Visit each of its unvisited neighbours, mark them visited, and add them to the queue.
5. Repeat until the queue becomes empty.

### Java code: BFS

```java
import java.util.*;

class BFS {
    static void bfs(ArrayList<ArrayList<Integer>> adj,
                    int start, int vertices) {

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}
        };

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bfs(adj, 0, vertices);
    }
}
```

**Possible output:**

```text
0 1 2 3
```

The exact order can depend on the order in which neighbours are stored.

**Time complexity:** `O(V + E)` using an adjacency list.  
**Space complexity:** `O(V)` for the visited array and queue.

**Applications:** Shortest path in an unweighted graph, level-order exploration, and finding connected components.

---

## 5. DFS (Depth-First Search)

**Depth-First Search (DFS)** is a graph traversal algorithm that goes as deep as possible along one path before backtracking.

DFS can be implemented using **recursion** or an explicit **stack (LIFO: Last In, First Out)**.

### Recursive DFS steps

1. Start from a vertex.
2. Mark it as visited and print it.
3. Visit an unvisited neighbour by calling DFS again.
4. When no unvisited neighbour remains, backtrack.
5. Continue until all reachable vertices have been visited.

### Java code: Recursive DFS

```java
import java.util.*;

class DFS {
    static void dfs(ArrayList<ArrayList<Integer>> adj,
                    int node, boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}
        };

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[vertices];
        dfs(adj, 0, visited);
    }
}
```

**Possible output:**

```text
0 1 3 2
```

The exact order can depend on the order in which neighbours are stored.

**Time complexity:** `O(V + E)` using an adjacency list.  
**Space complexity:** `O(V)` for visited data and the recursion stack in the worst case.

**Applications:** Cycle detection, connected components, path finding, and topological sorting in a directed acyclic graph.

---

## 6. Bipartite Graph

A **bipartite graph** is a graph whose vertices can be divided into two disjoint sets, usually called `Set A` and `Set B`, such that every edge connects a vertex in Set A to a vertex in Set B.

There must be **no edge between two vertices of the same set**.

### Example

```text
Set A          Set B

  0 ---------- 1
  |            |
  |            |
  2 ---------- 3
```

One valid division is:

- Set A = `{0, 3}`
- Set B = `{1, 2}`

Every edge connects different sets.

### Important property

An undirected graph is bipartite **if and only if it has no odd-length cycle**.

For example:
- A triangle (cycle of length 3) is not bipartite.
- A square (cycle of length 4) is bipartite.

### How to check a bipartite graph

We use **BFS and two colours**:

- Colour `0` represents the first set.
- Colour `1` represents the second set.
- Start a BFS and give the starting vertex colour `0`.
- Give every uncoloured neighbour the opposite colour.
- If two adjacent vertices have the same colour, the graph is not bipartite.
- Check every component, because a graph may be disconnected.

### Java code: Check Bipartite Graph using BFS

```java
import java.util.*;

class BipartiteGraph {
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj,
                               int vertices) {

        int[] colour = new int[vertices];
        Arrays.fill(colour, -1); // -1 means uncoloured

        for (int start = 0; start < vertices; start++) {

            // Handle disconnected components
            if (colour[start] != -1) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            colour[start] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbour : adj.get(node)) {

                    if (colour[neighbour] == -1) {
                        colour[neighbour] = 1 - colour[node];
                        queue.add(neighbour);
                    }
                    else if (colour[neighbour] == colour[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}
        };

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if (isBipartite(adj, vertices)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }
}
```

**Output:**

```text
Graph is Bipartite
```

**Time complexity:** `O(V + E)`  
**Space complexity:** `O(V)`

---
