package github.sterlingsutton2006;

public class Cell {
    // Attributes
    private boolean isAlive;
    private int numAliveNeighbors;

    // Methods
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setNumAliveNeighbors(int numAliveNeighbors) {
        this.numAliveNeighbors = numAliveNeighbors;
    }

    public boolean getAlive() {
        return isAlive;
    }
}
