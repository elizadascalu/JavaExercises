public class Hotel extends Node implements Classifiable {
    private int numberRooms;
    int rank;

    public Hotel(String name) {
        super(name);
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }


    @Override
    public void setRank(int rank) {
        this.rank=rank;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public void getType() {
        System.out.println("This is a Hotel.");
    }
}