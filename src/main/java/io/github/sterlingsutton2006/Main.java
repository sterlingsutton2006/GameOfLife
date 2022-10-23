package io.github.sterlingsutton2006;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String @NotNull [] args) {

    Grid grid = null;
     try
        {
         grid = new Grid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
    catch(Exception e)
        { System.out.println("An error has occurred please try again"); }

    finally {
        if(grid == null){
            System.exit(1);
         }
    }
        grid.populateGrid();
        for (int i = 0; i < 10000; i++) {
            grid.nextGeneration();
            grid.printGrid();
        }
    }
}
