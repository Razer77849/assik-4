import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> pathMap = new HashMap<>();

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);
        pathMap.put(startVertex, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    pathMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> destination) {
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> at = destination; at != null; at = pathMap.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
