public class Player {
    private String playerName;
    private int score;
    private int availableShips;
    private int sunkenShips;
    

    public Player(String name) {
        this.playerName = name;
        this.availableShips = 5;
        this.sunkenShips = 0;
        this.score = 0;
    }

    public String getName() {
        return this.playerName;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getAvailableShips() {
        return this.availableShips;
    }

    public void loseShip() {
        if (this.availableShips > 0) {
            this.availableShips--;
            this.sunkenShips++;
        }
    }

    public int getSunkenShips() {
        return this.sunkenShips;
    }

    public void resetShips() {
        this.availableShips = 5;
        this.sunkenShips = 0;
    }

    public boolean hasLost() {
        return this.availableShips == 0;
    }

    public void resetPlayer() {
        resetScore();
        resetShips();
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public void placeShip(int shipSize, String location,String orientation) {
        //Place ship logic to be implemented
    }

    @Override
    public String toString() {
        return "Player: " + this.playerName + ", Score: " + this.score +
               ", Available Ships: " + this.availableShips +
               ", Sunken Ships: " + this.sunkenShips;
    }

}
