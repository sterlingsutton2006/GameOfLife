package io.github.sterlingsutton2006;

public class Main {

    public static void main(String[] args) {

    Grid grid = null;
     try
        {
         grid = new Grid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
    catch(Exception e)
        { System.out.println("An Error has occured please try again"); }

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
