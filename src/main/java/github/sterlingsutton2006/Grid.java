package github.sterlingsutton2006;

import java.util.Random;

public class Grid {
    // Attributes
    public final int X_LENGTH = 30;
    public final int Y_LENGTH = 30;
    private Cell[][] grid = new Cell[X_LENGTH][Y_LENGTH];

    // Methods
    public Grid() {
        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
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
                        if (currentCellState) {
                            numAliveNeighbors++;
                        }
                    } catch (Exception ignored) {
                    }
                }

                if (numAliveNeighbors == 3 && !grid[x][y].getAlive()) {
                    nextGrid[x][y].setAlive(true);
                } else if (!(numAliveNeighbors == 2 || numAliveNeighbors == 3) && grid[x][y].getAlive()) {
                    nextGrid[x][y].setAlive(false);
                }
            }
        }

        grid = Utility.copyGrid(nextGrid);
    }

    public void printGrid() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utility.clearConsole();
        for (int x = 0; x < X_LENGTH; x++) {
            System.out.println();
            for (int y = 0; y < Y_LENGTH; y++) {
                if (grid[x][y].getAlive()) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
