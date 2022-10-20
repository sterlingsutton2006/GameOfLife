package github.sterlingsutton2006;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.populateGrid();
        for (int i = 0; i < 100; i++) {
            grid.nextGeneration();
        }
    }
}
