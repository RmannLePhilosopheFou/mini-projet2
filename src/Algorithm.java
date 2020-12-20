import graph.Graph;
import Utils.IVertex;

import java.util.ArrayList;
import java.util.Comparator;

public class Algorithm {


    public Algorithm() { }

    public static ArrayList<IVertex> getSortedList (ArrayList<IVertex> list, int factor) { // triage par ordre decroissant
        ArrayList<IVertex> tmp = new ArrayList<>(list);
        Comparator<IVertex> comparator;
        if(factor == 0)  // trier la liste des sommets par celui qui a le plus grand nombre de sommets adjacents rouge
            comparator = Comparator.comparing(IVertex::getNumberRedAdjacents);
        else if(factor == 1) // trier la liste des sommets par celui qui a transforme le plus grand nombre de sommet rouge en bleu
            comparator = Comparator.comparing(IVertex::numberOfRedToBlue);
        else
            comparator = Comparator.comparing(IVertex::getNumberOfBlueEdge); // trier la liste des sommets par celui qui transforme le plus grand nombre de sommet rouge en bleu et le moins de sommet bleu en rouge

        tmp.sort(comparator.reversed());
        return tmp;
    }

    public static int algorithm1(Graph graph, boolean debug){  //l'algorithme la plus éfficace
        int i = 0;
        while(graph.haveRedVertice()) //tant qu'il y'a toujours un sommet rouge dans le graphe
        {
            String deletedVertice="";
            i++;
            ArrayList<IVertex> sortedRedVertices=getSortedList(graph.getAllRedVertice(),0);// trier par le sommet rouge qui a le moins de sommet rouge adjacent
                    deletedVertice=sortedRedVertices.get(sortedRedVertices.size()-1).getTag();
                    graph.removeVertex(sortedRedVertices.get(sortedRedVertices.size()-1)); //

            if(debug) {
                System.out.println(" ITERATION  N° "+i);
                System.out.println("Le sommet rouge "+deletedVertice+" a été supprimé");
                System.out.println(graph);
            }


        }
        return i;
    }

    public static int algorithm2(Graph graph, boolean debug) {
        int i = 0;
        while(graph.haveRedVertice()) {
            String deletedVertice;
            i++;
            IVertex deletedVertex = getBestVertexToDeleteA2(graph.getAllRedVertice());
            deletedVertice = deletedVertex.getTag();
            graph.removeVertex(deletedVertex);

            if(debug) {
               System.out.println(" ITERATION  N° "+i);
               System.out.println("Le sommet rouge "+ deletedVertice +" a été supprimé");
               System.out.println(graph);
            }
        }
        return i;
    }

    public static IVertex getBestVertexToDeleteA2(ArrayList<IVertex> vertices) {
        int bestScore = Integer.MIN_VALUE;
        IVertex bestVertex = vertices.get(0);
        for (IVertex v : vertices) {
            if(bestScore < v.finalNumberOfBlueToChange()) {
                bestScore = v.finalNumberOfBlueToChange();
                bestVertex = v;
            }
        }
        return bestVertex;
    }


}
