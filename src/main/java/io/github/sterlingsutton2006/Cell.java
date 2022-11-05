package io.github.sterlingsutton2006;

public class Cell {
    private boolean isAlive;

    public Cell() {
        isAlive = false;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
