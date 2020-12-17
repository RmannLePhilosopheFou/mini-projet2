package graph;

import models.IEdge;
import models.IVertex;
import models.tools.Color;

public class Edge implements IEdge {

    IVertex origin;
    IVertex destination;
    Color color;

    public Edge(IVertex origin, IVertex destination, Color color){
        this.origin = origin;
        this.destination = destination;
        this.color = color;
    }

    @Override
    public IVertex origin() {
        return origin;
    }

    @Override
    public IVertex destination() {
        return destination;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public String toString() {
        return "(" + origin + ", " + destination + ")";
    }

    @Override
    public boolean equals(Object o) {
        Edge e = (Edge) o;
        return origin == e.origin && destination == e.destination;
    }

    @Override
    public int compareTo(IEdge iEdge) {
        return 0;
    }
}
