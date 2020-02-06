package ch.sbb.cca;

public class Main {
    static int dimensionX = 12;
    static int dimensionY = 12;
    static boolean[][] world;

    public static void main(String[] args) {
        world = initializeWorld();
        /**
         * Test grid
            world = new boolean[][]{
                new boolean[] { false, false, false, false, false},
                new boolean[] { false, false, true, false, false},
                new boolean[] { false, false, true, false, false},
                new boolean[] { false, false, true, false, false},
                new boolean[] { false, false, false, false, false}
            };
        */
        System.out.println("Original world");
        showWorld(world);

        // run game
        for(int i = 1; i <= 10; i++){
            world = createGeneration(world);
            System.out.println("Generation: " + i);
            showWorld(world);
        }
    }

    /**
     * initialize world
     *
     * @return 2 dimensional boolean array
     */
    public static boolean[][] initializeWorld(){
        boolean[][] initWorld = new boolean[dimensionX][dimensionY];

        // generate state for each coordinate
        for(int x = 0; x < dimensionX; x++){
            for(int y = 0; y < dimensionY; y++){
                // cell is alive with 0.x% * 100 chance
                initWorld[x][y] = Math.random() > 0.5;
            }
        }

        return initWorld;
    }

    /**
     * print world on console
     *
     * @param world 2 dimensional boolean array
     */
    public static void showWorld(boolean[][] world){
        String worldView = "";

        // iterate through y first (height of world)
        for(int y = 0; y < world[1].length; y++){
            // iterate through x coordinates
            for(int x = 0; x < world[0].length; x++){
                if(world[x][y] == true){
                    worldView += "X\t";
                } else {
                    worldView += "0\t";
                }
            }
            worldView += "\n";
        }

        System.out.println(worldView);
    }

    /**
     * create new generation of cells, based on the 4 rules
     *
     * @param world current generation of world 2d-array
     *
     * @return new generation of world (2-dimensional boolean array)s
     */
    public static boolean[][] createGeneration(boolean[][] world){
        boolean[][] oldGen = world;
        boolean[][] newGen = new boolean[dimensionX][dimensionY];

        for(int y = 0; y < oldGen[1].length; y++){
            for(int x = 0; x < oldGen[0].length; x++){
                // calculate neighbours of cell
                int countOfNeighbours = 0;
                //catch out of bounds
                if(x - 1 >= 0 && x + 1 < oldGen[0].length && y - 1 >= 0 && y + 1 < oldGen[1].length){
                    // check all cells relative to current cell
                    for(int relY = y - 1; relY <= y + 1; relY++){
                        for(int relX = x - 1; relX <= x + 1; relX++){
                            // prevent from checking self
                            if(relX != x || relY != y){
                                // when neighbour is alive add to countOfNeighbours
                                if(oldGen[relX][relY]){
                                    countOfNeighbours++;
                                }
                            }
                        }
                    }
                } else {
                    // continue loop on out of bound exception
                    continue;
                }
                // add new cell state to newGeneration Array
                newGen[x][y] = checkCellAgainstRules(oldGen[x][y], countOfNeighbours);
            }
        }
        // return new Generation of world
        return newGen;
    }


    /**
     * Check cells against predefined rules
     * @param cellState state cell to check
     * @param countNeighbours neighbours of said cell
     * @return if cell is alive or dead (true/false9
     */
    private static boolean checkCellAgainstRules(boolean cellState, int countNeighbours) {
        // check if cell is alive
        int cellStateInt = ((cellState) ? 1 : 0);

        /**
         * Return cellState according to Rules:
         * 1. jede lebendige Zelle, die weniger als zwei lebendige Nachbarn hat, stirbt an
         *      Einsamkeit
         * 2. jede lebendige Zelle mit mehr als drei lebendigen Nachbarn stirbt an Überbevölkerung
         * 3. jede lebendige Zelle mit zwei oder drei Nachbarn fühlt sich wohl und lebt weiter
         * 4. jede tote Zelle mit genau drei lebendigen Nachbarn wird wieder zum Leben
         *      erweckt
         */
        switch (cellStateInt){
            case 0:
                if(countNeighbours == 3){
                    return true;
                } else {
                    return false;
                }

            case 1:
                if(countNeighbours == 2 || countNeighbours == 3){
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }
}
