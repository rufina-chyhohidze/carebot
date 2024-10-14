package be.kdg.programming3.domain;

import java.util.List;

public class Warehouse {
    private int id;
    private String location;
    private int capacity;
    private List<DropPoint> dropPoints;
    private StartingPoint startingPoint;

    public Warehouse(int id, String location, int capacity, List<DropPoint> dropPoints, StartingPoint startingPoint) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.dropPoints = dropPoints;
        this.startingPoint = startingPoint;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public List<DropPoint> getDropPoints() {return dropPoints;}
    public void setDropPoints(List<DropPoint> dropPoints) {this.dropPoints = dropPoints;}

    public StartingPoint getStartingPoint() {return startingPoint;}
    public void setStartingPoint(StartingPoint startingPoint) {this.startingPoint = startingPoint;}

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", dropPoints=" + dropPoints +
                ", startingPoint=" + startingPoint +
                '}';
    }
}
