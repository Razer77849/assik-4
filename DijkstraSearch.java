import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> pathMap = new HashMap<>();
    private Map<Vertex<V>, Double> distances = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.MAX_VALUE);
        }
        distances.put(startVertex, 0.0);

        pq.add(startVertex);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    pathMap.put(neighbor, current);
                    pq.add(neighbor);
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
