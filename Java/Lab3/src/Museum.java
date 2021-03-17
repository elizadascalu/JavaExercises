public class Museum extends Node implements Payable {
    private int numberExposedArts=0;
    private double fee;

    public Museum(String name) {
        super(name);
    }

    public int getNumberExposedArts() {
        return numberExposedArts;
    }

    public void setNumberExposedArts(int numberExponates) {
        this.numberExposedArts = numberExponates;
    }

    @Override
    public void setEntryFee(double fee) {
        this.fee=fee;
    }

    @Override
    public double getEntryFee() {
        return this.fee;
    }

    @Override
    public void getType() {
        System.out.println("This is a Museum.");
    }
}

