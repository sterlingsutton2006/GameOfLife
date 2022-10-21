package github.sterlingsutton2006;

public class Utility {
    public static Cell[][] copyGrid(Cell[][] grid) {
        if (grid == null) {
            return null;
        }
        Cell[][] gridCopy = new Cell[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            gridCopy[i] = grid[i].clone();
        }
        return gridCopy;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
