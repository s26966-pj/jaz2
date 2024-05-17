package pl.pjatk.kamlit;

public class Car {
    private int id;

    public Car(int id) {
        this.id = id;
    }

    public Car(String id){}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
