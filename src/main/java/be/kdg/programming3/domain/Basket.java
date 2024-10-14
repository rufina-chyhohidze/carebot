package be.kdg.programming3.domain;

public class Basket {
    private int capacity;
    private int currentLoad;

    public Basket(int capacity, int currentLoad) {
        this.capacity = capacity;
        this.currentLoad = currentLoad;
    }

    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public int getCurrentLoad() {return currentLoad;}
    public void setCurrentLoad(int currentLoad) {this.currentLoad = currentLoad;}

    @Override
    public String toString() {
        return "Basket capacity: " + capacity + ", currentLoad: " + currentLoad;
    }
}
