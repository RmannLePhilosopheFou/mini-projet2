import graph.Graph;
import graph.GraphBuilder;

public class Main {
    public static void main(String[] args) {
     System.out.println("---- Génération données question 7 ----\n");
        for (double p = 0; p <= 1; p+=0.1) {
            for (double q = 0; q <= 1; q+=0.1) {
                int moy = 0;
                int nItt = 100;
                for (int i = 0; i < nItt; i++) {
                    Graph graph = GraphBuilder.buildQuestion5Graph(100, p, q);
                    moy += Algorithm.algorithm1(graph, false);
                }
                System.out.print((double)moy/nItt+";");
            }
            System.out.println();
        }
      /*  Graph graph = GraphBuilder.buildQuestion5Graph(100, 0.1, 0.9);
        System.out.println(GraphBuilder.G);
        System.out.println("------Début de l'algorithme choisie ");
        Algorithm.algorithm1(GraphBuilder.G, true);  //Graphe du projet pour etre sur qu'il donne le meme k qu'a la question 1*/


    }
}
