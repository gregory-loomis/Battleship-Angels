package Model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;


public class Board{
    private final int width;
    private final int height;

    // 0 = not hit and empty
    // -1 = hit
    //>0 = unhit ship number present
    private int[][] board;

    private ArrayList<Ship> ships = new ArrayList<>();

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
    public ArrayList<Ship> getShips() {return ships;}

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

    //places ship on board
    //assumes given spot is valid
    public void placeShip(int vertical_index, int horizontal_index, int len, String orientation,int id) throws Exception{
        orientation = orientation.toLowerCase();

        //errors if the orientation isnt h for horizontal or v for vertical
        if (!orientation.equals("h") && !orientation.equals("v")) {
            throw new Exception("Orientation must be (H)orizontal or (V)ertical");
        }

        switch (orientation) {
            //vertical ship
            case "v":

                for (int v = vertical_index;v<vertical_index+len;v++){
                    //goes through each square in the length of the ship vertically and fills it
                    board[v][horizontal_index] = id;

                }
                break;


            //horizontal ship
            case "h":

                for (int h = horizontal_index;h<horizontal_index+len;h++){
                    //goes through each square in the length of the ship horizontally and fills it
                    board[vertical_index][h] = id;
                }
                break;

            default:
        }

        /*
        TODO: Make ship and add to list of ships
        Ship s = new Ship(asofjasifjasfio);
        ships.add(s);
        */
    }



    public void randomPlacement(int[] sizes) throws Exception{
        clearBoard();
        int[] copy = Arrays.copyOf(sizes, sizes.length);
        Arrays.sort(copy);

        for (int i = copy.length-1;i>=0;i--){
            int len = copy[i];
            int vertical_index;
            int horizontal_index;
            String orientation;
            do {
                vertical_index = (int) (Math.random()*board.length);
                horizontal_index = (int) (Math.random()*board[0].length);
                if (Math.random()<.5) orientation = "h";
                else orientation = "v";
            } while (!validPlacement(vertical_index, horizontal_index, len, orientation));

            placeShip(vertical_index, horizontal_index, len, orientation, i+1);

        }
    }

    @Override
    public String toString(){
        String ret = "";

        for (int[] row : board){
            for (int item: row){
                ret+=item;
                ret+=" ";
            }
            ret+="\n";
        }

        return ret;
    }

}