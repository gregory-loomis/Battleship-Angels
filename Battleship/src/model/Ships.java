
public class Ships {

    private String name;
    private int size;
    private String orientation; // "horizontal" or "vertical"
    private int locations[][];
    private int hits;

    public Ships(String name, int size, String orientation) {
        this.name = name;
        this.size = size;
        this.orientation = orientation;
        this.locations = new int[size][2]; // Each location has x and y coordinates
        this.hits = 0;
    }



    public void registerHit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= size;
    }


    // Getters

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getOrientation() {
        return orientation;
    }

    public int[][] getLocations() {
        return locations;
    }

    public int getHits() {
        return hits;
    }

    
    // Setters

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setLocations(int[][] locations) {
        this.locations = locations;
    }


}
