package github.sterlingsutton2006;

public class Main {
    public static void render(Grid grid) {
        System.out.println(grid.toString());
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.populateGrid();
        for (int i = 0; i < 100; i++) {
            grid.nextGeneration();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
