package graph;

import exception.BadInputGraphException;
import Utils.IVertex;
import Utils.Color;

import java.util.Scanner;

public class GraphBuilder {
    public static Graph D1 = graph("A 1 E 1 0 B 0 D 1 1 B 1 F 1 0 C 1 E 0 1 D 1 F 0 1 F 1 C 0 1 F 1 E 1 1 G 0 A 0 0 G 1 B 1 1 G 0 C 0 0");
    public static Graph G = graph("A 0 B 1 0 A 0 C 1 0 C 1 A 0 1 B 1 D 0 1 C 1 D 0 0 C 1 E 1 0 E 1 D 0 1 E 1 F 0 0 F 0 E 1 0 G 0 E 1 1 G 0 F 0 0 G 0 H 1 1 H 1 F 0 1 H 1 D 0 0");


    public static Graph graph(String input) {
        Graph G = new Graph();
        buildGraph(G,input);
        return G;
    }

    private static void buildGraph(Graph G, String input) {
        Scanner scanner = new Scanner(input);
        buildGraph(G,scanner);
        scanner.close();
    }


    private static void buildGraph(Graph G, Scanner input) {
        String u, v;
        int cu, cv, c;
        while ( input.hasNext() ) {
            u = input.next();
            if ( input.hasNextInt() )
                cu = input.nextInt();
            else
                throw new BadInputGraphException("");

            if ( input.hasNext() )
                v = input.next();
            else
                throw new BadInputGraphException("");
            if ( input.hasNextInt() )
                cv = input.nextInt();
            else
                throw new BadInputGraphException("");

            if ( input.hasNextInt() )
                c = input.nextInt();
            else
                throw new BadInputGraphException("");
            if (c != 0 && c!= 1) throw new BadInputGraphException("");
            IVertex uu;
            if(cu == 0) {
                 uu = addVertex(G,u,Color.BLUE);
            } else {
                 uu = addVertex(G,u,Color.RED);
            }
            IVertex vv;
            if(cv == 0) {
                vv = addVertex(G,v,Color.BLUE);
            } else {
                vv = addVertex(G,v,Color.RED);
            }
            if(c == 0) G.addEdge(uu, vv, Color.BLUE);
            else G.addEdge(uu, vv, Color.RED);
        }
    }

    public static Graph buildQuestion5Graph(int n, double p, double q) {
        Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            double r = Math.random();
            if(r < p) {
                graph.addVertex(Integer.toString(i), Color.RED);
            }
            else {
                graph.addVertex(Integer.toString(i), Color.BLUE);
            }
        }
        for (IVertex v: graph.vertices()) {
            for(IVertex v2: graph.vertices()) {
                if(!v.equals(v2)) {
                    double r = Math.random();
                    if(r < q) {
                        graph.addEdge(v, v2, Color.BLUE);
                    }
                    else {
                        graph.addEdge(v, v2, Color.RED);
                    }
                }
            }
        }
        return graph;
    }


    private static IVertex addVertex(Graph G, String u, Color c) {
        IVertex v = G.getVertex(u);
        if ( v == null )
            return G.addVertex(u, c);
        return v;
    }
}
