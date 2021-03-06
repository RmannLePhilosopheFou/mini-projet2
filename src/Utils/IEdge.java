package Utils;

public interface IEdge extends Comparable<IEdge>{

    public IVertex origin();

    public IVertex destination();

    public Color getColor();

    public void setColor(Color color);
}
