import graph.Edge;
import graph.Graph;
import graph.GraphBuilder;
import graph.Vertex;
import models.IEdge;
import models.IVertex;

public class GraphRunner {

    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_BRIGHT_RED    = "\u001B[91m";
    public static final String ANSI_BRIGHT_BLUE   = "\u001B[94m";
    public static final String ANSI_RESET  = "\u001B[0m";

    private static void testGraphMethods(String name, Graph G) {
        System.out.println(name);
        System.out.println(G);

        System.out.println("\nVertices enumeration:");
        for ( IVertex vertex :  G.vertices() )
            System.out.print(vertex.getTag() + " ");
        System.out.println();

        System.out.println("\nEdges enumeration:");
        for ( IEdge edge :  G.edges() )
            System.out.print("(" + edge.origin() + "," + edge.destination() + ") ");
        System.out.println();

        System.out.println("\nAdjacents enumeration:");
        for ( IVertex vertex :  G.vertices() ) {
            System.out.print("Adjacents of vertex " + vertex + ": ");
            for ( IVertex adjacent : G.adjacents(vertex) )
                System.out.print(adjacent + " ");
            System.out.println();
        }

        System.out.println("\nIncidents enumeration:");
        for ( IVertex vertex :  G.vertices() ) {
            System.out.println("Incident edges of vertex " + vertex + ":");
            for ( IEdge edge : G.incidents(vertex) )
                System.out.println("   " + edge + ", origin = " + edge.origin() + ", destination = " + edge.destination());
            System.out.println();
        }

        System.out.println("\nIn-degree of vertices:");
        for ( IVertex vertex :  G.vertices() )
            System.out.println("in-degree(" + vertex + ") = " + G.inDegree(vertex));
        System.out.println();

        System.out.println("\nOut-degree of vertices:");
        for ( IVertex vertex :  G.vertices() )
            System.out.println("out-degree(" + vertex + ") = " + G.outDegree(vertex));
        System.out.println();

        System.out.println("\n(total) degree of vertices:");
        for ( IVertex vertex :  G.vertices() )
            System.out.println("degree(" + vertex + ") = " + G.degree(vertex));
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println("-------------------------------\n");
        testGraphMethods("G:", GraphBuilder.G);
    }
}
