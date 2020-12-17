package graph;

import models.IEdge;
import models.IVertex;
import models.tools.Color;

public class Vertex implements IVertex {
    Graph fromGraph;
    String tag;
    Color color;

    Vertex(Graph fromGraph, String tag, Color color){
        this.tag = tag;
        this.fromGraph = fromGraph;
        this.color = color;
    }


    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return tag;
    }

    @Override
    public int compareTo(IVertex iVertex) {
        return 0;
    }
    public int getNumberRedAdjacents() {
        int nb=0;
        Iterable<IVertex> adjacent=fromGraph.adjacents(this);
        for(IVertex vertex:adjacent)
        {
            if(vertex.getColor()==Color.RED)
                nb++;
        }
        return nb;
    }

    @Override
    public int getNumberOfBlueEdge() {
        int nb=0;
        Iterable<IVertex> adjacents=fromGraph.adjacents(this);
        for(IVertex vertex: adjacents)
            if(fromGraph.findEdge(this,vertex)!=null && fromGraph.findEdge(this,vertex).getColor()==Color.BLUE)
                nb++;
        return nb;
    }

    @Override
    public int numberOfRedToBlue()  // le nombre de fleche bleu qui va vers un sommet rouge
    {
        int nb=0;
        Iterable<IVertex> adjacents=fromGraph.adjacents(this);
        for(IVertex vertex: adjacents)
        {
            IEdge edge=fromGraph.findEdge(this,vertex);
            if(edge!=null && edge.getColor()==Color.BLUE && vertex.getColor()==Color.RED)
                nb++;
        }
        return nb++;
    }
    @Override
    public int numberOfBlueToRed()  // le nombre de fleche rougequi va vers un sommet bleu
    {
        int nb=0;
        Iterable<IVertex> adjacents=fromGraph.adjacents(this);
        for(IVertex vertex: adjacents)
        {
            IEdge edge=fromGraph.findEdge(this,vertex);
            if(edge!=null && edge.getColor()==Color.RED && vertex.getColor()==Color.BLUE)
                nb++;
        }
        return nb++;
    }

    /**
     * Renvoie le nombre de sommet rouge transformé en bleu au final si on supprime ce sommet
     * @return
     */
    @Override
    public int finalNumberOfBlueToChange()
    {
        return  numberOfBlueToRed()- numberOfRedToBlue();

    }
}
