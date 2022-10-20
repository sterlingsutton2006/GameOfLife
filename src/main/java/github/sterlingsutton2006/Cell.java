package github.sterlingsutton2006;

public class Cell {
    // Attributes
    private boolean isAlive;

    // Methods
    public Cell() {
        isAlive = false;
    }
    public void setAlive(boolean isAlive) {
        try {
            this.isAlive = isAlive;
        }
        catch (Exception ignored) {
        }
    }

    public boolean getAlive() {
        return isAlive;
    }
}
