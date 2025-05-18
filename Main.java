public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 1);
        graph.addEdge(b, c, 2);
        graph.addEdge(a, c, 4);

        Search<String> bfs = new BreadthFirstSearch<>(graph, a);
        System.out.println("BFS Path from A to C: " + bfs.getPath(c));

        Search<String> dijkstra = new DijkstraSearch<>(graph, a);
        System.out.println("Dijkstra Path from A to C: " + dijkstra.getPath(c));
    }
}
