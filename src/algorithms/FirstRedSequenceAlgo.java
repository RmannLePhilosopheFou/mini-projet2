package algorithms;

import graph.Graph;
import graph.GraphBuilder;
import models.IVertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FirstRedSequenceAlgo {


    public FirstRedSequenceAlgo() { }

    public static ArrayList<IVertex> getSortedList (ArrayList<IVertex> list, int factor) { // triage par ordre decroissant
        ArrayList<IVertex> tmp=new ArrayList<>(list);
        Comparator<IVertex> comparator;
        if(factor==0)  // trier la liste des sommets par celui qui a le plus grand nombre de sommets adjacents rouge
            comparator =Comparator.comparing(IVertex::getNumberRedAdjacents);
        else if(factor==1) // trier la liste des sommets par celui qui a transforme le plus grand nombre de sommet rouge en bleu
            comparator =Comparator.comparing(IVertex::numberOfRedToBlue);
        else
            comparator =Comparator.comparing(IVertex::getNumberOfBlueEdge); // trier la liste des sommets par celui qui transforme le plus grand nombre de sommet rouge en bleu et le moins de sommet bleu en rouge

        Collections.sort(tmp,comparator.reversed());
        return tmp;
    }

    public static void run (Graph graph){
        int i = 0;
        while(graph.haveRedVertice())
        {
            String deletedVertice="";
            i++;
            ArrayList<IVertex> sortedRedVertices=getSortedList(graph.getAllRedVertice(),2);// trier par le sommet qui change le plus de sommet rouge en bleu et le moins de sommet bleu en rouge
                int max = sortedRedVertices.get(0).numberOfRedToBlue();
               if(max>0) { // si la supression de ce sommet peut entrainer la coloration d'au moins un sommet rouge en bleu
                   deletedVertice=sortedRedVertices.get(0).getTag();
               graph.removeVertex(sortedRedVertices.get(0));
               }
               else {
                   sortedRedVertices=getSortedList(sortedRedVertices,2);
                   if(sortedRedVertices.get(0).getNumberOfBlueEdge()>0)
                   {
                       deletedVertice=sortedRedVertices.get(0).getTag();
                       graph.removeVertex(sortedRedVertices.get(0)); // on supprime celui qui a le plus d'arrete bleu

                   }
                   else
                   {
                       sortedRedVertices=getSortedList(sortedRedVertices,0);
                       deletedVertice=sortedRedVertices.get(0).getTag();
                       graph.removeVertex(sortedRedVertices.get(sortedRedVertices.size()-1)); // on supprime celui qui a le moins d'arrete rouge
                   }
               }
            System.out.println(" ITERATION  N° "+i);
            System.out.println("Le sommet rouge "+deletedVertice+" a été supprimé");
            System.out.println(graph);
        }
    }
    public static void main(String[] args) {
        System.out.println("-------------------------------\n");
        System.out.println(GraphBuilder.G);
        Graph g = GraphBuilder.G;
        //System.out.println(g.getAllRedVertice());
        //System.out.println(getSortedList(g.getAllRedVertice(),1));
        run(GraphBuilder.G);

    }
}
