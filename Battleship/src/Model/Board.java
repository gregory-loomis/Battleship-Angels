package Model;


import java.util.HashMap;


public class Board{
    private final int width;
    private final int height;

    // 0 = not hit and empty
    // -1 = hit
    //>0 = unhit ship number present
    private int[][] board;

    //corresponds given coordinate to the reference to the ship object
    private HashMap<int[],Ship> correspondence = new HashMap<>();

    private Ship[] ships;

    public Board(int w,int h){
        width = w;
        height = h;
        
        board = new int[h][w];
        //defaults board to 0s  
        clearBoard();

    }

    //gets the various objects
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public int[][] getBoard() {return board;}
    public Ship[] getShips() {return ships;}

    //sets board to 0s
    public void clearBoard(){
        for (int i = 0;i<height;i++){
            for (int ii = 0;ii<width;ii++){
                board[i][ii]=0;
            }
        }
    }


    //checks if ship can be placed is available given top left point (via index in the board), length of ship, and orientation
    //returns true if the placement is valid, else returns false
    public boolean validPlacement(int vertical_index, int horizontal_index, int len, String orientation) throws Exception{
        
        orientation = orientation.toLowerCase();

        //errors if the orientation isnt h for horizontal or v for vertical
        if (!orientation.equals("h") && !orientation.equals("v")) {
            throw new Exception("Orientation must be (H)orizontal or (V)ertical");
        }
        
        switch (orientation) {
            //vertical ship
            case "v":
                //checks if vertical and horizontal indices for each of the potential ship's squares exist in the board and aren't filled
                if (horizontal_index >= width || horizontal_index < 0) return false;
                for (int v = vertical_index;v<vertical_index+len;v++){
                    if (v>=this.height || v<0) return false;

                    // "if a square is already full, say you can't place ship"
                    if (board[v][horizontal_index] != 0) return false;
                }

                //if every square the potential ship will be placed on is available, return true
                return true;

            //horizontal ship
            case "h":
                //checks if vertical and horizontal indices for each of the potential ship's squares exist in the board and aren't filled
                if (vertical_index >= height || vertical_index < 0) return false;
                for (int h = horizontal_index;h<horizontal_index+len;h++){
                    if (h>=this.width || h<0) return false;

                    // "if a square is already full, say you can't place ship"
                    if (board[vertical_index][h] != 0) return false;
                }

                //if every square the potential ship will be placed on is available, return true
                return true;
        
            default:
                return false;
        }

    }

}