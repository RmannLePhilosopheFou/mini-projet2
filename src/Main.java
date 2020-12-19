import graph.Graph;
import graph.GraphBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- Génération données question 7 ----\n");
        for (double p = 0; p <= 1; p+=0.1) {
            for (double q = 0; q <= 1; q+=0.1) {
                System.out.println("p = " + p + "; q = " + q);
                int algo1=0, algo2 = 0;
                for (int i = 0; i < 100; i++) {
                    Graph graph = GraphBuilder.buildQuestion5Graph(p, q);
                    algo1 = algo1 + Algorithm.algorithm1(graph);
                    algo2 = algo2 + Algorithm.algorithm2(graph);
                }
                System.out.println("Itérations algo 1 : " + algo1/100);
                System.out.println("Itérations algo 2 : " + algo2/100);
            }
        }
        //System.out.println(GraphBuilder.G1);
        //Graph graph = GraphBuilder.buildQuestion5Graph(0.1, 0.5);
        //System.out.println(graph);
        //System.out.println("------Début de l'algorithme choisie ");
        //Algorithm.algorithm1(graph);//remplacer algorithm1 par algortihm2 si vous voulez utiliser la deuxième méthode afin de comparer


    }
}
