package github.sterlingsutton2006;

import java.util.Random;

public class Grid {
    // Attributes
    public final int X_LENGTH;
    public final int Y_LENGTH;
    private Cell[][] grid;

    // Methods
    private boolean decideState(int numAliveNeighbors, boolean isAlive) {
        if (isAlive) {
            return (numAliveNeighbors == 2 || numAliveNeighbors == 3);
        }
        else {
            return (numAliveNeighbors == 3);
        }
    }
    public Grid(int X_LENGTH, int Y_LENGTH) {
        this.X_LENGTH = X_LENGTH;
        this.Y_LENGTH = Y_LENGTH;
        grid = new Cell[this.X_LENGTH][this.Y_LENGTH];
        for (int x = 0; x < this.X_LENGTH; x++) {
            for (int y = 0; y < this.Y_LENGTH; y++) {
                grid[x][y] = new Cell();
            }
        }
    }

    public void populateGrid() {
        Cell[][] nextGrid = Utility.copyGrid(grid);
        Random rng = new Random();
        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
                nextGrid[x][y].setAlive(rng.nextBoolean());
            }
        }
        grid = Utility.copyGrid(nextGrid);
    }

    public void nextGeneration() {

        Cell[][] nextGrid = Utility.copyGrid(grid);
        int numAliveNeighbors;
        boolean currentCellState = false;

        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
                numAliveNeighbors = 0;
                for (int i = 0; i < 8; i++) {
                    try {
                        switch (i) {
                            case 0 -> currentCellState = grid[x + 1][y].getAlive();
                            case 1 -> currentCellState = grid[x + 1][y + 1].getAlive();
                            case 2 -> currentCellState = grid[x][y + 1].getAlive();
                            case 3 -> currentCellState = grid[x - 1][y + 1].getAlive();
                            case 4 -> currentCellState = grid[x - 1][y].getAlive();
                            case 5 -> currentCellState = grid[x - 1][y - 1].getAlive();
                            case 6 -> currentCellState = grid[x][y - 1].getAlive();
                            case 7 -> currentCellState = grid[x + 1][y - 1].getAlive();
                        }
                    } catch (Exception ignored) {
                        switch (i) {
                            case 0 -> currentCellState = grid[0][y].getAlive();
                            case 1 -> currentCellState = grid[0][0].getAlive();
                            case 2 -> currentCellState = grid[x][0].getAlive();
                            case 3 -> currentCellState = grid[X_LENGTH - 1][0].getAlive();
                            case 4 -> currentCellState = grid[X_LENGTH - 1][y].getAlive();
                            case 5 -> currentCellState = grid[X_LENGTH - 1][Y_LENGTH - 1].getAlive();
                            case 6 -> currentCellState = grid[x][Y_LENGTH - 1].getAlive();
                            case 7 -> currentCellState = grid[0][Y_LENGTH - 1].getAlive();
                        }
                    }
                    if (currentCellState) {
                        numAliveNeighbors++;
                    }
                }
                nextGrid[x][y].setAlive(decideState(numAliveNeighbors, nextGrid[x][y].getAlive()));


            }
        }

        grid = Utility.copyGrid(nextGrid);
    }

    public void printGrid() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utility.clearConsole();
        for (int x = 0; x < X_LENGTH; x++) {
            System.out.println();
            for (int y = 0; y < Y_LENGTH; y++) {
                if (grid[x][y].getAlive()) {
                    System.out.print("██");
                } else {
                    System.out.print("  ");
                }

            }
        }
    }
}
