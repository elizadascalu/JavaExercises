import java.time.LocalTime;

public class Church extends Node implements Visitable{
    LocalTime openinghours;
    LocalTime endinghours;
    public Church(String name) {
        super(name);
    }

    @Override
    public void setOpeningHours(LocalTime opening) {
        this.openinghours=opening;
    }

    @Override
    public LocalTime getOpeningHours() {
        return openinghours;
    }

    @Override
    public void getType() {
        System.out.println("This is a Church.");
    }

    @Override
    public void setEndingHours(LocalTime ending) {
        this.endinghours=ending;
    }

    @Override
    public LocalTime getEndingHours() {
        return endinghours;
    }

}