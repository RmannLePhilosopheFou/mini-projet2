import graph.GraphBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------\n");
        System.out.println(GraphBuilder.G);
        System.out.println("------Début de l'algorithme choisie ");
        Algorithm.algorithm1(GraphBuilder.G);//remplacer algorithm1 par algortihm2 si vous voulez utiliser la deuxième méthode afin de comparer


    }
}
